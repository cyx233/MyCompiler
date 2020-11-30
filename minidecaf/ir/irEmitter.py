from .instruction import *
from .namer import GlobalInfo

class IRFunc:
    def __init__(self, name:str, nParam:int, instrs:[IRInstr]):
        self.name = name
        self.instrs = instrs
        self.nParam = nParam

    def __str__(self):
        def f(i):
            if type(i) is Comment:
                return f"\t\t\t\t{i}"
            if type(i) is Label:
                return f"{i}"
            return f"\t{i}"
        body = '\n'.join(map(f, self.instrs))
        return f"{self.name}():\n{body}"

class IRGlob:
    def __init__(self, ident:str, size:int, init=None):
        self.ident = ident
        self.size = size
        self.init = init # byte array
        self.align = INT_BYTES

    def __str__(self):
        return f"{self.ident}:\n\tsize={self.size}, align=4\n\t{self.initStr()}"

    def initStr(self):
        if self.init is None:
            return "uninitialized"
        else:
            return f"initializer={self.init}"   

class IRProg:
    def __init__(self, funcs:[IRFunc], globalVar:[IRGlob]):
        self.funcs = funcs
        self.globalVar = globalVar

    def __str__(self):
        globs = "\n".join(map(str, self.globalVar))
        funcs = "\n\n".join(map(str, self.funcs))
        res = "========Globs:\n" + globs
        res += "\n\n========Funcs:\n" + funcs
        return res



class IREmitter:
    def __init__(self):
        self.funcs = []
        self.globalVar = []
        self.curName = None
        self.curNParam = None
        self.curInstrs = []


    def enterFunction(self, name:str, nParam:int):
        self.curName = name
        self.curInstrs = []
        self.curNParam = nParam

    def exitFunction(self):
        self.funcs.append(IRFunc(self.curName,self.curNParam,self.curInstrs))
    
    def emitGlobal(self, globalInfo:GlobalInfo):
        if globalInfo.var.offset:
            raise MiniDecafError(f"Global variable Error")
        self.globalVar += [IRGlob(globalInfo.var.ident, globalInfo.size, globalInfo.init)]

    def emit(self, irs:[IRInstr]):
        self.curInstrs += irs

    def getIR(self):
        return IRProg(self.funcs, self.globalVar)

    def __call__(self, irs:[IRInstr]):
        self.emit(irs)