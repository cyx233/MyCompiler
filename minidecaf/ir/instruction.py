from ..utils import *
class IRInstr:
    def __repr__(self):
        return self.__str__()

class Comment(IRInstr):
    def __init__(self, msg:str):
        self.msg = msg

    def __str__(self):
        return f"# {self.msg}"

    def accept(self, visitor):
        visitor.visitComment(self)


class Const(IRInstr):
    def __init__(self, v:int):
        if MIN_INT <= v <= MAX_INT:
            self.v = v
        else:
            raise MiniDecafError("Integer Error")


    def __str__(self):
        return f"const {self.v}"

    def accept(self, visitor):
        visitor.visitConst(self)

class Ret(IRInstr):
    def __str__(self):
        return f"ret"

    def accept(self, visitor):
        visitor.visitRet(self)

class Unary(IRInstr):
    def __init__(self,op:str):
        self.op = text(op)
    def __str__(self):
        return f"Unary operator \"{self.op}\""
    def accept(self,visitor):
        visitor.visitUnary(self)

class Arithmetic(IRInstr):
    def __init__(self,op:str):
        self.op = text(op)
    def __str__(self):
        return f"Arithmetic operator \"{self.op}\""
    def accept(self,visitor):
        visitor.visitArithmetic(self)

class Logic(IRInstr):
    def __init__(self,op:str):
        self.op = text(op)
    def __str__(self):
        return f"Logic operator \"{self.op}\""
    def accept(self,visitor):
        visitor.visitLogic(self)
    
class Pop(IRInstr):
    def __str__(self):
        return f"pop"
    def accept(self, visitor):
        visitor.visitPop(self)

class Store(IRInstr):
    def __str__(self):
        return f"store"
    def accept(self, visitor):
        visitor.visitStore(self)

class Load(IRInstr):
    def __str__(self):
        return f"load"
    def accept(self, visitor):
        visitor.visitLoad(self)

class FrameAddr(IRInstr):
    def __init__(self,offset):
        self.offset = offset
    def __str__(self):
        return f"frame address {self.offset}"
    def accept(self, visitor):
        visitor.visitFrameAddr(self)

class Label(IRInstr):
    def __init__(self, label:str):
        self.label = label

    def __str__(self):
        return f"{self.label}:"

    def accept(self, visitor):
        visitor.visitLabel(self)

class Beqz(IRInstr):
    def __init__(self,label:str):
        self.label = label 
    def __str__(self):
        return f"beqz {self.label}"
    def accept(self, visitor):
        visitor.visitBeqz(self)

class Goto(IRInstr):
    def __init__(self,label:str):
        self.label = label 
    def __str__(self):
        return f"goto {self.label}"
    def accept(self, visitor):
        visitor.visitGoto(self)

class Call(IRInstr):
    """Before call, arguments need be pushed (from right to left)."""
    def __init__(self, func:str):
        self.func = func

    def __str__(self):
        return f"call {self.func}"

    def accept(self, visitor):
        visitor.visitCall(self)

class GlobalVar(IRInstr):
    def __init__(self, ident:str):
        self.ident = ident

    def __str__(self):
        return f"global variable {self.ident}"

    def accept(self, visitor):
        visitor.visitGlobalVar(self)
