from .irGen import StackIRGen
from .irEmitter import IREmitter
from .namer import Namer
from .typer import Typer

def nameGen(tree):
    namer = Namer()
    namer.visit(tree)
    return namer.nameInfo

def typeCheck(tree, nameInfo):
    typer = Typer(nameInfo)
    typer.visit(tree)
    return typer.typeInfo

def irGen(tree,nameInfo,typeInfo):
    irEmitter = IREmitter()
    StackIRGen(irEmitter,nameInfo,typeInfo).visit(tree)
    return irEmitter.getIR()
