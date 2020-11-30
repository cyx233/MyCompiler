from ..utils import *
from ..ir.instruction import *
from .command import *
from ..ir.irEmitter import *

def Instrs(f):
    def g(*args, **kwargs):
        instrs = f(*args, *kwargs)
        return [(AsmInstr(x) if type(x) is not AsmInstr else x) for x in instrs]
    return g

@Instrs
def _push(val):
    if type(val) is int:
        return [f"addi sp, sp, -{INT_BYTES}", f"li t1, {val}", f"sw t1, 0(sp)"] # push int
    else:
        return [f"addi sp, sp, -{INT_BYTES}", f"sw {val}, 0(sp)"] # push register

def push(*vals):
    return flatten(map(_push, vals))

@Instrs
def _pop(reg):
    return ([f"lw {reg}, 0(sp)"] if reg is not None else []) + [f"addi sp, sp, {INT_BYTES}"]

def pop(*regs):
    return flatten(map(_pop, regs))

@Instrs
def ret(func:str):
    return [f"j {func}_exit"]

@Instrs
def label(label:str):
    return [f"{label}:"]

@Instrs
def unary(opstr):
    return [f"lw t1,0(sp)"]+opstr+["sw t1,0(sp)"]

@Instrs 
def arithmetic(opstr):
    return [f"lw t1,0(sp)"] + [f"lw t2,4(sp)"] + [f"addi sp,sp,4"] + opstr + [f"sw t1,0(sp)"]

@Instrs 
def logic(opstr):
    return [f"lw t1,0(sp)"] + [f"lw t2,4(sp)"] + [f"addi sp,sp,4"] + opstr + [f"sw t1,0(sp)"]

@Instrs
def call(func:str, nParam:int):
    return [f"call {func}"] + pop(*[None]*nParam) + push("a0")

@Instrs
def globalVar(ident:str):
    return [f"la t1, {ident}"] + push("t1")

@Instrs 
def direct(opstr):
    return opstr


class RISCVAsmGen():
    def __init__(self, emitter):
        self._E = emitter
        self.curFunc = None
        self.curParamInfo = None

    def visitComment(self,instruction:Comment):
        pass

    def visitConst(self,instruction:Const):
        self._E(push(instruction.v))

    def visitRet(self, instruction:Ret):
        self._E(ret(self.curFunc))

    def visitUnary(self,instruction:Unary):
        if instruction.op == "-":
            self._E(unary([f"neg t1,t1"]))
        elif instruction.op == "!":
            self._E(unary([f"seqz t1,t1"]))
        elif instruction.op == "~":
            self._E(unary([f"not t1,t1"]))

    def visitArithmetic(self,instruction:Arithmetic):
        if instruction.op == "-":
            self._E(arithmetic([f"sub t1,t2,t1"]))
        if instruction.op == "+":
            self._E(arithmetic([f"add t1,t2,t1"]))
        if instruction.op == "*":
            self._E(arithmetic([f"mul t1,t2,t1"]))
        if instruction.op == "/":
            self._E(arithmetic([f"div t1,t2,t1"]))
        if instruction.op == "%":
            self._E(arithmetic([f"rem t1,t2,t1"]))

    def visitLogic(self,instruction:Logic):
        if instruction.op == "&&":
            self._E(logic([f"snez t1,t1",f"snez t2,t2",f"and t1,t1,t2"]))
        elif instruction.op == "||":
            self._E(logic([f"or t1,t1,t2",f"snez t1,t1"]))
        elif instruction.op == "==":
            self._E(logic([f"xor t1,t1,t2",f"seqz t1,t1"]))
        elif instruction.op == "<":
            self._E(logic([f"slt t1,t2,t1"]))
        elif instruction.op == ">":
            self._E(logic([f"sgt t1,t2,t1"]))
        elif instruction.op == "<=":
            self._E(logic([f"sgt t1,t2,t1",f"xori t1,t1,1"]))
        elif instruction.op == ">=":
            self._E(logic([f"slt t1,t2,t1",f"xori t1,t1,1"]))
        elif instruction.op == "!=":
            self._E(logic([f"xor t1,t2,t1",f"snez t1,t1"]))

    def visitPop(self,instruction):
        self._E(direct([f"addi sp, sp, 4"]))

    def visitStore(self,instruction):
        self._E(direct([f"lw t1, 4(sp)", f"lw t2, 0(sp)", f"addi sp, sp, 4", f"sw t1, 0(t2)"]))
    
    def visitLoad(self,instruction):
        self._E(direct([f"lw t1, 0(sp)", f"lw t1, 0(t1)", f"sw t1, 0(sp)"]))
    
    def visitFrameAddr(self,instruction:FrameAddr):
        self._E(direct([f"addi sp, sp, -4", f"addi t1, fp, "+str(instruction.offset), f"sw t1, 0(sp)"]))

    def visitBeqz(self,instruction:Beqz):
        self._E(direct([f"lw t1, 0(sp)","addi sp, sp, 4","beqz t1, "+instruction.label]))
        
    def visitGoto(self,instruction:Goto):
        self._E(direct([f"j "+instruction.label]))

    def visitLabel(self,instruction:Label):
        self._E([AsmLabel(instruction.label)])
    
    def visitCall(self,instruction:Call):
        callFunc = None 
        for func in self.ir.funcs:
            if(func.name==instruction.func):
                callFunc = func
                break
        self._E(call(callFunc.name, callFunc.nParam))

    def visitGlobalVar(self, instruction:GlobalVar):
        self._E(globalVar(instruction.ident))


    def genPrologue(self, func:IRFunc):
        self._E([
            AsmBlank(),
            AsmDirective(".text"),
            AsmDirective(f".globl {func.name}"),
            AsmLabel(f"{func.name}")] +
            push("ra", "fp") + [
            AsmInstr("mv fp, sp"),
            AsmComment("copy args:")])
        for i in range(func.nParam):
            fr = INT_BYTES*(i+2)
            self._E([
                AsmInstr(f"lw t1, {fr}(fp)")] +
                push("t1"))
        self._E([
            AsmComment("END PROLOGUE"),
            AsmBlank()])

    def genEpilogue(self, func:IRFunc):
        self._E([
            AsmBlank(),
            AsmComment("BEGIN EPOLOGUE")] +
            push(0) + [
            AsmLabel(f"{func.name}_exit"),
            AsmInstr("lw a0, 0(sp)"),
            AsmInstr("mv sp, fp")] +
            pop("fp", "ra") + [
            AsmInstr("jr ra"),
            AsmBlank()])

    def genFunc(self, func:IRFunc):
        self.curFunc = func.name
        self.genPrologue(func)
        for instr in func.instrs:
            self._E([
                AsmComment(instr)])
            instr.accept(self)
        self.genEpilogue(func)

    def genGlob(self, glob:IRGlob):
        if glob.init is None:
            self._E([AsmDirective(f".comm {glob.ident},{glob.size},{glob.align}")])
        else:
            self._E([
                AsmDirective(".data"),
                AsmDirective(f".globl {glob.ident}"),
                AsmDirective(f".align {glob.align}"),
                AsmDirective(f".size {glob.ident}, {glob.size}"),
                AsmLabel(f"{glob.ident}"),
                AsmDirective(f".quad {glob.init}")])


    def gen(self, ir):
        self.ir = ir
        for glob in ir.globalVar:
            self.genGlob(glob)
        for func in ir.funcs:
            self.genFunc(func)
 

