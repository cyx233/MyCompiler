from ..utils import *
from ..generated.MiniDecafParser import MiniDecafParser
from ..generated.MiniDecafVisitor import MiniDecafVisitor


class Variable:
    _varcnt = {}
    def __init__(self, ident:str, offset:int, size:int=INT_BYTES):
        """offset denotes a location in memory. It could be an int, indicating
        the offset relative to frame pointer, or None indicating that self is a
        global variable. The value of self is stored at that location. But when
        self is an array, that location is the location of the first element in
        the array."""
        incOrInit(Variable._varcnt, ident)
        self.id = Variable._varcnt[ident]
        self.ident = ident
        self.offset = offset
        self.size = size

    def __eq__(self, other):
        return self.id == other.id and self.ident == other.ident and\
            self.offset == other.offset and self.size == other.size

    def __str__(self):
        return f"{self.ident}({self.id})"

    def __repr__(self):
        return self.__str__()

    def __hash__(self):
        return hash((self.ident, self.id, self.offset, self.size))

class GlobalInfo:
    def __init__(self, var:Variable, size:int, init=None):
        self.var = var
        self.size = var.size
        self.init = init 

    def __str__(self):
        return f"{self.var}, size={self.size}, {self.initStr()}"

    def initStr(self):
        if self.init is None:
            return "uninitialized"
        else:
            return f"initializer={self.init}"

class FuncNameInfo:
    def __init__(self, hasDef=True):
        self._v = {}    # term -> Variable
        self._pos = {}  # term -> (int, int)
        self.hasDef = hasDef
        self.compoundSlots = {} # CompooundStmtContext-> int >= 0

    def __str__(self):
        res = "name resolution:\n"
        def f1(pv):
            pos, var = pv
            if var.offset is not None:
                loc = f"at frameslot {var.offset}"
            else:
                loc = f"global symbol"
            return f"{str(pos):>16} : {str(var):<10} {loc}"
        res += "\n".join(map(f1,
            [(self._pos[term], self._v[term]) for term in self._v]))
        
        res += "\nnumber of slots in each block:\n"
        def f(bs):
            ctx, slots = bs
            startPos = (ctx.start.line, ctx.start.column)
            stopPos = (ctx.stop.line, ctx.stop.column)
            region = f"{startPos} ~ {stopPos}"
            return f"{region:>32} : {slots}"
        res += "\n".join(map(f,
            [(ctx, self.compoundSlots[ctx]) for ctx in self.compoundSlots]))
        return res

    def bind(self, term, var, pos):
        self._v[term] = var
        self._pos[term] = pos

    def __repr__(self):
        return self.__str__()

    def __getitem__(self, term):
        return self._v[term]


class NameInfo():
    def __init__(self):
        self.funcs = {} # str -> FuncNameInfo. Initialized by Def.
        self.globs = {} # str -> GlobalInfo.
        self._v = {} # term->Variable

    def freeze(self):
        for funcNameInfo in self.funcs.values():
            self._v.update(funcNameInfo._v)

    def __getitem__(self, ctx):
        return self._v[ctx]

    def __str__(self):
        def f(fn):
            func, funcNameInfo = fn
            indentedFuncNameInfo = "\t" + str(funcNameInfo).replace("\n", "\n\t")
            return f"NameInfo for {func}:\n{indentedFuncNameInfo}"
        res = "\n--------\n\n".join(map(f, self.funcs.items()))
        res += "\n--------\n\nGlobInfos:\n\t"
        res += "\n\t".join(map(str, self.globs.values()))
        return res

class Namer(MiniDecafVisitor):
    """Name resolution.
    It is basically an alpha conversion pass; different variables with the same
    name are resolved to different `Variable`s. The output is a NameInfo, mapping
    variable occurrence (i.e. its Ident's TerminalNodeImpl) to Variable/Offsets."""
    def __init__(self):
        self._v = stacked_dict() # str -> Variable
        self.nSlots = [] # number of frame slots on block entry
        self.curSlots = 0
        self.nameInfo = NameInfo()
        self.curFuncNameInfo = None # == self.nameInfo[curFunc]

    def defVar(self, ctx, term, intNums):
        self.curSlots += intNums
        var = self._v[text(term)] = Variable(text(term),-INT_BYTES * self.curSlots, INT_BYTES*intNums)
        pos = (ctx.start.line, ctx.start.column)
        self.curFuncNameInfo.bind(term, var, pos)

    def useVar(self, ctx, term):
        var = self._v[text(term)]
        pos = (ctx.start.line, ctx.start.column)
        self.curFuncNameInfo.bind(term, var, pos)
    
    def enterScope(self, ctx):
        self._v.push()    
        self.nSlots.append(self.curSlots)

    def exitScope(self, ctx):
        self.curFuncNameInfo.compoundSlots[ctx] = self.curSlots - self.nSlots[-1]
        self.curSlots = self.nSlots[-1]
        self._v.pop()
        self.nSlots.pop()

    def visitCompoundStatement(self,ctx:MiniDecafParser.CompoundStatementContext):
        self.enterScope(ctx)
        self.visitChildren(ctx)
        self.exitScope(ctx)

    def visitDeclaration(self, ctx:MiniDecafParser.DeclarationContext):
        if ctx.expression() is not None:
            ctx.expression().accept(self)
        var = text(ctx.Ident())
        if var in self._v.peek():
            raise MiniDecafLocatedError(ctx, f"redefinition of {var}")
        self.defVar(ctx, ctx.Ident(),self.declArraySize(ctx))

    def visitForDeclStmt(self, ctx:MiniDecafParser.ForDeclStmtContext):
        self.enterScope(ctx)
        self.visitChildren(ctx)
        self.exitScope(ctx)

    def visitAtomIdent(self, ctx:MiniDecafParser.AtomIdentContext):
        var = text(ctx.Ident())
        if var not in self._v:
            raise MiniDecafLocatedError(ctx, f"var {var} undeclared")
        self.useVar(ctx, ctx.Ident())

    def visitFuncDef(self, ctx:MiniDecafParser.FuncDefContext):
        func = text(ctx.Ident())
        if func in self.nameInfo.funcs and self.nameInfo.funcs[func].hasDef:
                raise MiniDecafLocatedError(ctx,f"redefinition of function {func}")
        funcNameInfo = FuncNameInfo(hasDef=True)
        self.curFuncNameInfo = self.nameInfo.funcs[func] = funcNameInfo
        self.enterScope(ctx.compoundStatement())
        ctx.parameterList().accept(self)
        self.visitChildren(ctx.compoundStatement())
        self.exitScope(ctx.compoundStatement())
        self.curFuncNameInfo = None

    def visitFuncDecl(self, ctx:MiniDecafParser.FuncDeclContext):
        func = text(ctx.Ident())
        if func in self.nameInfo.globs:
            raise MiniDecafLocatedError(ctx, f"global variable {func} redeclared as function")
        funcNameInfo = FuncNameInfo(hasDef=False)
        if func not in self.nameInfo.funcs:
            self.nameInfo.funcs[func] = funcNameInfo

    def visitFuncPostfix(self, ctx:MiniDecafParser.FuncPostfixContext):
        func = text(ctx.Ident())
        if func not in self.nameInfo.funcs:
            raise MiniDecafLocatedError(ctx, f"func {func} undeclared")
        self.visitChildren(ctx)

    def globalInitializer(self, ctx:MiniDecafParser.ExpressionContext):
        if ctx is None:
            return None
        try:
            from ast import literal_eval
            initializer = literal_eval(text(ctx))
            return initializer
        except:
            raise MiniDecafLocatedError(ctx, "global initializers must be constants")

    def declArraySize(self, ctx:MiniDecafParser.DeclarationContext):
        res = prod([int(text(x)) for x in ctx.Integer()])
        if res <= 0:
            raise MiniDecafLocatedError(ctx, "array size <= 0")
        if res >= MAX_INT:
            raise MiniDecafLocatedError(ctx, "array size too large")
        return res

    def visitGlobalDecl(self, ctx:MiniDecafParser.GlobalDeclContext):
        ctx = ctx.declaration()
        init = self.globalInitializer(ctx.expression())
        varStr = text(ctx.Ident())
        if varStr in self.nameInfo.funcs:
            raise MiniDecafLocatedError(ctx, f"function {varStr} redeclared as global variable")
        var = Variable(varStr, None, INT_BYTES*self.declArraySize(ctx))
        globInfo = GlobalInfo(var, INT_BYTES, init)
        if varStr in self._v.peek():
            prevGlobInfo = self.nameInfo.globs[varStr]
            if globInfo.init is not None:
                if prevGlobInfo.init is not None:
                    raise MiniDecafLocatedError(ctx, f"redefinition of variable {varStr}")
                else:
                    self.nameInfo.globs[varStr].init = init
        else:
            self._v[varStr] = var
            self.nameInfo.globs[varStr] = globInfo

    def visitProg(self, ctx:MiniDecafParser.ProgContext):
        self.visitChildren(ctx)
        self.nameInfo.freeze()