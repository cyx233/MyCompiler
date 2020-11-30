from ..utils import *
from ..generated.MiniDecafParser import MiniDecafParser
from ..generated.MiniDecafVisitor import MiniDecafVisitor
from .instruction import *
from .namer import *
from .types import *


class TypeInfo:
    def __init__(self):
        self.loc = {} # ExprContext -> (IRInstr|ExprContext)+
        self.funcs = {} # str -> FuncTypeInfo
        self._t = {} # ExprContext -> Type

    def lvalueLoc(self, ctx):
        return self.loc[ctx]

    def setLvalueLoc(self, ctx, loc:list):
        self.loc[ctx] = loc

    def __str__(self):
        res = "Lvalue analysis result: (location of expr at lhs == value of rhs):\n\t"
        def p(c):
            return f"{c.start.line},{c.start.column}~{c.stop.line},{c.stop.column}"
        def g(locStep):
            if isinstance(locStep, IRInstr):
                return f"{locStep}"
            else:
                return f"[{p(locStep)}]"
        def f(cl):
            ctx, loc = cl
            ctxStr = f"{p(ctx)}"
            locStr = " :: ".join(map(g, loc))
            return f"{ctxStr:>32} : {locStr}"
        res += "\n\t".join(map(f, self.loc.items()))
        res += "\n\nType info for funcs:\n\t"

        def f2(nf):
            name, funcInfo = nf
            return f"{name:>32} : ({funcInfo.paramTy}) -> {funcInfo.retTy}"
        res += "\n\t".join(map(f2, self.funcs.items()))

        return res

    def __getitem__(self, ctx):
        return self._t[ctx]


class FuncTypeInfo:
    def __init__(self, retTy:Type, paramTy:list):
        self.retType = retTy
        self.paramType = paramTy

    def compatible(self, other):
        return self.retType == other.retType and self.paramType == other.paramType

    def call(self):
        @TypeRule
        def callRule(ctx, argTy:list):
            if self.paramType == argTy:
                return self.retType
            return f"bad argument types"
        return callRule

class Locator(MiniDecafVisitor):
    def __init__(self, nameInfo:NameInfo, typeInfo:TypeInfo):
        self.nameInfo = nameInfo
        self.typeInfo = typeInfo

    def locate(self, func:str, ctx):
        return ctx.accept(self)

    def visitAtomIdent(self, ctx:MiniDecafParser.AtomIdentContext):
        var = self.nameInfo[ctx.Ident()]
        if var.offset is None:
            return [GlobalVar(var.ident)]
        else:
            return [FrameAddr(var.offset)]

    def visitComplexUnary(self, ctx:MiniDecafParser.ComplexUnaryContext):
        if text(ctx.unaryOp())=="*":
            return [ctx.unary()]

    def visitArrayPostfix(self, ctx:MiniDecafParser.ArrayPostfixContext):
        baseSize = self.typeInfo[ctx.postfix()].base.sizeof()
        return [ctx.postfix(), ctx.expression(), Const(baseSize), Arithmetic('*'), Arithmetic('+')]

    def visitAtomParent(self, ctx:MiniDecafParser.AtomParentContext):
        return ctx.expression().accept(self)
    

def SaveType(f):
    def g(self, ctx):
        ty = f(self, ctx)
        self.typeInfo._t[ctx] = ty
        return ty
    return g


class Typer(MiniDecafVisitor):
    """Type checking.
    Run after name resolution, type checking computes the type of each
    expression, and also check for incompatibilities like int*+int*. Besides
    type checking, Typer also does lvalue analysis i.e. determine which
    expressions are lvalues and their address."""
    def __init__(self, nameInfo: NameInfo):
        self.var2type = {} # Variable -> Type
        self.nameInfo = nameInfo
        self.curFunc = None
        self.typeInfo = TypeInfo()
        self.locator = Locator(self.nameInfo, self.typeInfo)
        self.unaryRule = {
            "-":intUnaryRule,
            "!":intUnaryRule,
            "~":intUnaryRule,
            "&":addrOfRule,
            "*":derefRule
        }
        self.binaryRule = {
            "*":intBinaryRule,
            "/":intBinaryRule,
            "%":intBinaryRule,
            "&&":intBinaryRule,
            "||":intBinaryRule,
            "==":eqRule,
            "!=":eqRule,
            "<":relationRule,
            ">":relationRule,
            "<=":relationRule,
            ">=":relationRule,
            "=":asgnRule,
            "+":tryEach('+',intBinaryRule,ptrArithRule),
            "-":tryEach('-',intBinaryRule,ptrArithRule,ptrDiffRule)
        }

    def visitChildren(self, ctx):
        ty = MiniDecafVisitor.visitChildren(self, ctx)
        self.typeInfo._t[ctx] = ty
        return ty

    def var(self, term):
        return self.nameInfo[term]

    def declType(self, ctx:MiniDecafParser.DeclarationContext):
        base = ctx.mtype().accept(self)
        dims = [int(text(x)) for x in reversed(ctx.Integer())]
        if len(dims) == 0:
            return base
        else:
            return ArrayType.make(base, dims)

    def funcTypeInfo(self, ctx):
        retType = ctx.mtype().accept(self)
        paramType = self.paramTy(ctx.parameterList())
        return FuncTypeInfo(retType, paramType)

    def argType(self, ctx:MiniDecafParser.ExpressionListContext):
        return list(map(lambda x: x.accept(self), ctx.expression()))

    def visitTypePointer(self, ctx:MiniDecafParser.TypePointerContext):
        return PtrType(ctx.mtype().accept(self))

    def visitTypeInt(self, ctx:MiniDecafParser.TypeIntContext):
        return IntType()

    def locate(self, ctx):
        loc = self.locator.locate(self.curFunc, ctx)
        if loc is None:
            raise MiniDecafLocatedError(ctx, "lvalue expected")
        self.typeInfo.setLvalueLoc(ctx, loc)

    def checkUnary(self, ctx, op:str, ty:Type):
        rule = self.unaryRule[op]
        return rule(ctx, ty)

    def checkBinary(self, ctx, op:str, lhs:Type, rhs:Type):
        rule = self.binaryRule[op]
        return rule(ctx, lhs, rhs)

    @SaveType
    def visitCastUnary(self, ctx:MiniDecafParser.CastUnaryContext):
        ctx.unary().accept(self)
        return ctx.mtype().accept(self)

    @SaveType
    def visitComplexUnary(self, ctx:MiniDecafParser.ComplexUnaryContext):
        res = self.checkUnary(ctx.unaryOp(), text(ctx.unaryOp()),
                ctx.unary().accept(self))
        if text(ctx.unaryOp())=="&":
            self.locate(ctx.unary())
        return res

    @SaveType
    def visitAtomParent(self, ctx:MiniDecafParser.AtomParentContext):
        return ctx.expression().accept(self)

    @SaveType
    def visitComplexAdd(self, ctx:MiniDecafParser.ComplexAddContext):
        return self.checkBinary(ctx.addOp(), text(ctx.addOp()),
                ctx.additive().accept(self), ctx.multiplicative().accept(self))

    @SaveType
    def visitComplexMult(self, ctx:MiniDecafParser.ComplexMultContext):
        return self.checkBinary(ctx.mulOp(), text(ctx.mulOp()),
                ctx.multiplicative().accept(self), ctx.unary().accept(self))

    @SaveType
    def visitComplexRelation(self, ctx:MiniDecafParser.ComplexRelationContext):
        return self.checkBinary(ctx.relationOp(), text(ctx.relationOp()),
                ctx.relational().accept(self), ctx.additive().accept(self))

    @SaveType
    def visitComplexEqual(self, ctx:MiniDecafParser.ComplexEqualContext):
        return self.checkBinary(ctx.eqOp(), text(ctx.eqOp()),
                ctx.equality().accept(self), ctx.relational().accept(self))

    @SaveType
    def visitComplexLand(self, ctx:MiniDecafParser.ComplexLandContext):
        return self.checkBinary(ctx, "&&",
                ctx.logical_and().accept(self), ctx.equality().accept(self))

    @SaveType
    def visitComplexLor(self, ctx:MiniDecafParser.ComplexLorContext):
        return self.checkBinary(ctx, "||",
                ctx.logical_or().accept(self), ctx.logical_and().accept(self))

    @SaveType
    def visitComplexCond(self, ctx:MiniDecafParser.ComplexCondContext):
        return condRule(ctx, ctx.logical_or().accept(self),
                ctx.expression().accept(self), ctx.conditional().accept(self))

    @SaveType
    def visitComplexAsgn(self, ctx:MiniDecafParser.ComplexAsgnContext):
        res = self.checkBinary(ctx.Equal(), text(ctx.Equal()),
                ctx.unary().accept(self), ctx.expression().accept(self))
        self.locate(ctx.unary())
        return res

    @SaveType
    def visitFuncPostfix(self, ctx:MiniDecafParser.FuncPostfixContext):
        argTy = self.argType(ctx.expressionList())
        func = text(ctx.Ident())
        rule = self.typeInfo.funcs[func].call()
        return rule(ctx, argTy)

    @SaveType
    def visitAtomInt(self, ctx:MiniDecafParser.AtomIntContext):
        from ast import literal_eval
        if literal_eval(text(ctx)) == 0:
            return ZeroType()
        else:
            return IntType()

    @SaveType
    def visitAtomIdent(self, ctx:MiniDecafParser.AtomIdentContext):
        var = self.var(ctx.Ident())
        return self.var2type[var]

    @SaveType
    def visitArrayPostfix(self,ctx:MiniDecafParser.ArrayPostfixContext):
        return arrayRule(ctx, ctx.postfix().accept(self), ctx.expression().accept(self))

    def visitDeclaration(self, ctx:MiniDecafParser.DeclarationContext):
        var = self.var(ctx.Ident())
        ty = self.declType(ctx)
        self.var2type[var] = ty
        if ctx.expression() is not None:
            initType = ctx.expression().accept(self)
            asgnRule(ctx, ty, initType)

    def checkFunc(self, ctx):
        funcTypeInfo = self.funcTypeInfo(ctx)
        func = text(ctx.Ident())
        if func in self.typeInfo.funcs:
            prevFuncTypeInfo = self.typeInfo.funcs[func]
            if not funcTypeInfo.compatible(prevFuncTypeInfo):
                raise MiniDecafLocatedError(ctx, f"conflicting types for {func}")
        else:
            self.typeInfo.funcs[func] = funcTypeInfo

    def visitFuncDef(self, ctx:MiniDecafParser.FuncDefContext):
        func = text(ctx.Ident())
        self.curFunc = func
        self.checkFunc(ctx)
        self.visitChildren(ctx)
        self.curFunc = None

    def visitFuncDecl(self, ctx:MiniDecafParser.FuncDeclContext):
        func = text(ctx.Ident())
        self.curFunc = func
        self.checkFunc(ctx)
        self.curFunc = None

    def paramTy(self, ctx:MiniDecafParser.parameterList):
        res = []
        for decl in ctx.declaration():
            if decl.expression() is not None:
                raise MiniDecafLocatedError(decl, "parameter cannot have initializers")
            paramTy = self.declType(decl)
            if isinstance(paramTy, ArrayType):
                raise MiniDecafLocatedError(decl, "parameter cannot have array types")
            res += [paramTy]
        return res

    def visitGlobalDecl(self, ctx:MiniDecafParser.GlobalDeclContext):
        ctx = ctx.declaration()
        var = self.nameInfo.globs[text(ctx.Ident())].var
        ty = self.declType(ctx)
        if var in self.var2type:
            prevTy = self.var2type[var]
            if prevTy != ty:
                raise MiniDecafLocatedError(ctx, f"conflicting types for {var.ident}")
        else:
            self.var2type[var] = ty
        if ctx.expression():
            initType = ctx.expression().accept(self)
            asgnRule(ctx, ty, initType)

    def visitReturnStmt(self, ctx:MiniDecafParser.ReturnStmtContext):
        funcRetType = self.typeInfo.funcs[self.curFunc].retType
        ty = ctx.expression().accept(self)
        retRule(ctx, funcRetType, ty)

    def visitIfStmt(self, ctx:MiniDecafParser.IfStmtContext):
        self.visitChildren(ctx)
        stmtCondRule(ctx, ctx.expression().accept(self)) # idempotent

    def visitForDeclStmt(self, ctx:MiniDecafParser.ForDeclStmtContext):
        self.visitChildren(ctx)
        if ctx.cond:
            stmtCondRule(ctx, ctx.cond.accept(self))

    def visitForStmt(self, ctx:MiniDecafParser.ForStmtContext):
        self.visitChildren(ctx)
        if ctx.cond:
            stmtCondRule(ctx, ctx.cond.accept(self))

    def visitWhileStmt(self, ctx:MiniDecafParser.WhileStmtContext):
        self.visitChildren(ctx)
        stmtCondRule(ctx, ctx.expression().accept(self))

    def visitDoWhileStmt(self, ctx:MiniDecafParser.DoWhileStmtContext):
        self.visitChildren(ctx)
        stmtCondRule(ctx, ctx.expression().accept(self))
