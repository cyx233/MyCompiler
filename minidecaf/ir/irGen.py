from .instruction import *
from .namer import *
from .types import *
from ..utils import *
from ..generated.MiniDecafVisitor import MiniDecafVisitor
from ..generated.MiniDecafParser import MiniDecafParser

class LabelManager:
    def __init__(self):
        self.nlabels = {}
        self.loopEntry=[]
        self.loopExit=[]

    def newLabel(self, scope="_L"):
        incOrInit(self.nlabels, scope)
        return f"{scope}_{self.nlabels[scope]}"

    def enterLoop(self, entry, exitLabel):
        self.loopEntry.append(entry)
        self.loopExit.append(exitLabel)

    def exitLoop(self):
        self.loopEntry.pop()
        self.loopExit.pop()
    
    def breakLabel(self,ctx):
        if len(self.loopExit) == 0:
            raise MiniDecafLocatedError(ctx,"not in a loop")
        return self.loopExit[-1]

    def continueLabel(self,ctx):
        if len(self.loopExit) == 0:
            raise MiniDecafLocatedError(ctx,"not in a loop")
        return self.loopEntry[-1]



class StackIRGen(MiniDecafVisitor):
    def __init__(self, emitter,nameInfo,typeInfo):
        self._E = emitter
        self.curFunc = None
        self.nameInfo = nameInfo
        self.typeInfo = typeInfo
        self.labelManager = LabelManager()

    def _var(self, term):
        return self.nameInfo[term]

    def emitVar(self, var:Variable):
        if var.offset is None:
            self._E([GlobalVar(var.ident)])
        else:
            self._E([FrameAddr(var.offset)])

    def emitLoc(self, lvalue:MiniDecafParser.ExpressionContext):
        actionList = self.typeInfo.lvalueLoc(lvalue)
        for act in actionList:
            if isinstance(act, IRInstr):
                self._E([act])
            else:
                act.accept(self)

    def setConst(self,ctx:MiniDecafParser.Integer):
        self._E([Const(int(text(ctx)))])

    def loop(self, name, pre, cond, body, post):
        self._E([Comment(f"[ir-LoopEntry] {name}")])
        entryLabel = self.labelManager.newLabel(f"{name}_entry")
        if post is not None:
            continueLabel = self.labelManager.newLabel(f"{name}_continue")
        else:
            continueLabel = entryLabel
        exitLabel = self.labelManager.newLabel(f"{name}_exit")
        self.labelManager.enterLoop(continueLabel, exitLabel)
        if pre is not None:
            pre.accept(self)
            if isinstance(pre, MiniDecafParser.ExpressionContext):
                self._E([Pop()])
        self._E([Label(entryLabel)])
        if cond is not None:
            cond.accept(self)
        else:
            self._E([Const(1)])
        self._E([Beqz(exitLabel)])
        body.accept(self)
        if post is not None:
            self._E([Label(continueLabel)])
            post.accept(self)
            if isinstance(post, MiniDecafParser.ExpressionContext):
                self._E([Pop()])
        self._E([Goto(entryLabel)])
        self._E([Label(exitLabel)])
        self._E([Comment(f"[ir-LoopExit] {name}")])
        self.labelManager.exitLoop()


    def visitCompoundStatement(self, ctx:MiniDecafParser.CompoundStatementContext):
        self._E([Comment("[ir-block] Enter")])
        self.visitChildren(ctx)
        self._E([Comment("[ir-block] Exit")])
        self._E([Pop()] * self.nameInfo.funcs[self.curFunc].compoundSlots[ctx])
    
    def visitReturnStmt(self,ctx:MiniDecafParser.ReturnStmtContext):
        self._E([Comment("[ir-stmt] Ret")])
        self.visitChildren(ctx)
        self._E([Ret()])

    def visitExprStmt(self,ctx:MiniDecafParser.ExprStmtContext):
        self._E([Comment("[ir-stmt] Expr")])
        self.visitChildren(ctx)
        if ctx.expression():
            self._E([Pop()])

    def visitIfStmt(self,ctx:MiniDecafParser.IfStmtContext):
        self._E([Comment("[ir-stmt] If")])
        ctx.expression().accept(self)
        exitLabel = self.labelManager.newLabel("if_end")
        elseLabel = self.labelManager.newLabel("if_else")
        if ctx.elseBody is not None:
            self._E([Beqz(elseLabel)])
            ctx.ifBody.accept(self)
            self._E([Goto(exitLabel)])

            self._E([Label(elseLabel)])
            ctx.elseBody.accept(self)
            self._E([Label(exitLabel)])
        else:
            self._E([Beqz(exitLabel)])
            ctx.ifBody.accept(self)
            self._E([Label(exitLabel)])

    def visitForDeclStmt(self, ctx:MiniDecafParser.ForDeclStmtContext):
        self.loop("for", ctx.pre, ctx.cond, ctx.body, ctx.post)
        self._E([Pop()] * self.nameInfo.funcs[self.curFunc].compoundSlots[ctx])

    def visitForStmt(self, ctx:MiniDecafParser.ForStmtContext):
        self.loop("for", ctx.pre, ctx.cond, ctx.body, ctx.post)

    def visitWhileStmt(self, ctx:MiniDecafParser.WhileStmtContext):
        self.loop("while", None, ctx.expression(), ctx.statement(), None)

    def visitDoWhileStmt(self, ctx:MiniDecafParser.DoWhileStmtContext):
        self.loop("dowhile", ctx.statement(), ctx.expression(), ctx.statement(), None)

    def visitBreakStmt(self, ctx:MiniDecafParser.BreakStmtContext):
        self._E([Goto(self.labelManager.breakLabel(ctx))])

    def visitContinueStmt(self, ctx:MiniDecafParser.ContinueStmtContext):
        self._E([Goto(self.labelManager.continueLabel(ctx))])
        
    def visitComplexCond(self,ctx:MiniDecafParser.ComplexCondContext):
        self._E([Comment("[ir-stmt] Condition")])
        ctx.logical_or().accept(self)
        exitLabel = self.labelManager.newLabel("if_end")
        elseLabel = self.labelManager.newLabel("if_else")
        self._E([Beqz(elseLabel)])
        ctx.expression().accept(self)
        self._E([Goto(exitLabel)])

        self._E([Label(elseLabel)])
        ctx.conditional().accept(self)
        self._E([Label(exitLabel)])

    def visitExpression(self,ctx:MiniDecafParser.ExpressionContext):
        self.visitChildren(ctx)

    def visitComplexLand(self,ctx:MiniDecafParser.Logical_andContext):
        self.visitChildren(ctx)
        self._E([Logic(ctx.Double_amp())])
    
    def visitComplexLor(self,ctx:MiniDecafParser.Logical_orContext):
        self.visitChildren(ctx)
        self._E([Logic(ctx.Double_bar())])

    def visitComplexEqual(self,ctx:MiniDecafParser.ComplexEqualContext):
        self.visitChildren(ctx)
        self._E([Logic(ctx.eqOp())])

    def visitComplexRelation(self,ctx:MiniDecafParser.ComplexRelationContext):
        self.visitChildren(ctx)
        self._E([Logic(ctx.relationOp())])

    def visitDeclaration(self, ctx:MiniDecafParser.DeclarationContext):
        self._E([Comment("[ir-decl] Decl")])
        if ctx.expression() is not None:
            ctx.expression().accept(self)
        else:
            self._E([Const(0)]*(self.nameInfo[ctx.Ident()].size//INT_BYTES))
    
    def visitGlobalDecl(self,ctx):
        pass

    def visitAtomIdent(self,ctx:MiniDecafParser.AtomIdentContext):
        self.emitVar(self._var(ctx.Ident()))
        if not isinstance(self.typeInfo[ctx], ArrayType):
            self._E([Load()]) 

    def visitAtomInt(self,ctx:MiniDecafParser.AtomIntContext):
        self.setConst(ctx.Integer())

    def visitComplexAsgn(self, ctx:MiniDecafParser.ComplexAsgnContext):
        ctx.expression().accept(self)
        self.emitLoc(ctx.unary())
        self._E([Store()])
    
    def visitComplexUnary(self,ctx:MiniDecafParser.ComplexUnaryContext):
        op = text(ctx.unaryOp())
        if op=='&':
            self.emitLoc(ctx.unary())
        elif op=="*":
            self.visitChildren(ctx)
            self._E([Load()])
        else:
            self.visitChildren(ctx)
            self._E([Unary(ctx.unaryOp())])

    def visitComplexAdd(self,ctx:MiniDecafParser.ComplexAddContext):
        op = text(ctx.addOp())
        lhs = ctx.additive()
        rhs = ctx.multiplicative()
        if isinstance(self.typeInfo[lhs], PtrType):
            sz = self.typeInfo[lhs].sizeof()
            if isinstance(self.typeInfo[rhs], PtrType): # ptr - ptr
                lhs.accept(self)
                rhs.accept(self)
                self._E([Arithmetic(op)])
                self._E([Const(sz), Arithmetic('/')])
            else: # ptr +- int
                lhs.accept(self)
                rhs.accept(self)
                self._E([Const(sz), Arithmetic('*')])
                self._E([Arithmetic(op)])
        else:
            sz = self.typeInfo[rhs].sizeof()
            if isinstance(self.typeInfo[rhs], PtrType): # int +- ptr
                lhs.accept(self)
                self._E([Const(sz), Arithmetic('*')])
                rhs.accept(self)
                self._E([Arithmetic(op)])
            else: # int +- int
                self.visitChildren(ctx)
                self._E([Arithmetic(op)])

    def visitComplexMult(self,ctx:MiniDecafParser.ComplexMultContext):
        self.visitChildren(ctx)
        self._E([Arithmetic(ctx.mulOp())])

    def visitFuncDef(self, ctx:MiniDecafParser.FuncDefContext):
        func = text(ctx.Ident())
        self.curFunc = func
        nParam = len(self.typeInfo.funcs[func].paramType)
        self._E.enterFunction(func,nParam)
        ctx.compoundStatement().accept(self)
        self._E.exitFunction()
        self.curFunc = None

    def visitFuncDecl(self, ctx:MiniDecafParser.FuncDeclContext):
        pass

    def visitFuncPostfix(self, ctx:MiniDecafParser.FuncPostfixContext):
        args = ctx.expressionList().expression()
        for arg in reversed(args):
            arg.accept(self)
        func = text(ctx.Ident())
        self._E([Call(func)])

    def visitArrayPostfix(self,ctx:MiniDecafParser.ArrayPostfixContext):
        baseSize = self.typeInfo[ctx.postfix()].base.sizeof()
        ctx.postfix().accept(self)
        ctx.expression().accept(self)
        self._E([Const(baseSize), Arithmetic('*'), Arithmetic('+')])
        if not isinstance(self.typeInfo[ctx], ArrayType):
            self._E([Load()])

    def visitProg(self, ctx:MiniDecafParser.ProgContext):
        for globInfo in self.nameInfo.globs.values():
            self._E.emitGlobal(globInfo)
        self.visitChildren(ctx)