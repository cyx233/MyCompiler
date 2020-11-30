from .asm import asmGen
from .ir import irGen,nameGen,typeCheck
from .generated.MiniDecafParser import MiniDecafParser
from .generated.MiniDecafLexer import MiniDecafLexer
from .utils import *
from antlr4 import *
import argparse
import sys

def parseArgs(argv):
    parser = argparse.ArgumentParser(description="MiniDecaf compiler")
    parser.add_argument("infile", type=str,
                        help="the input C file")
    parser.add_argument("outfile", type=str, nargs="?",
                        help="the output assembly file")
    parser.add_argument("-ir", action="store_true", help="emit ir rather than asm")
    parser.add_argument("-ni", action="store_true", help="emit result of name resulution")
    parser.add_argument("-ty", action="store_true", help="emit type check information")
    parser.add_argument("-lex", action="store_true", help="emit tokens produced by lexing")
    parser.add_argument("-parse", action="store_true", help="emit cst produced by parsing (use `make cst` for graphical view)")
    parser.add_argument("-backtrace", action="store_true", help="emit backtrace information (for debugging)")
    return parser.parse_args()


def IRGen(tree,nameInfo,typeInfo):
    ir = irGen(tree,nameInfo,typeInfo)
    if args.ir:
        print(ir)
        exit(0)
    return ir

def NameGen(tree):
    nameInfo = nameGen(tree)
    if args.ni:
        print(nameInfo)
        exit(0)
    return nameInfo

def TypeCheck(tree, nameInfo):
    typeInfo = typeCheck(tree, nameInfo)
    if args.ty:
        print(typeInfo)
        exit(0)
    return typeInfo

def AsmGen(ir, outfile):
    if outfile is not None:
        with open(outfile, 'w') as fout:
            return asmGen(ir, fout)
    else:
        return asmGen(ir, sys.stdout)


def mLexer(inputStream):
    lexer = MiniDecafLexer(inputStream)
    if args.lex:
        dumpLexerTokens(lexer)
        exit(0)
    return CommonTokenStream(lexer)


def mParser(tokenStream):
    parser = MiniDecafParser(tokenStream)
    # BailErrorStrategy halts execution rather than try to recover on any parser error.
    # The Python antlr4 API has not yet exposed a get/set interface,
    # so we just assign to the error handler.
    parser._errHandler = BailErrorStrategy()
    tree = parser.prog()
    if args.parse:
        print(tree.toStringTree(recog=parser))
        exit(0)
    return tree


def main(argv):
    try:
        global args
        args = parseArgs(argv)

        inputStream = FileStream(args.infile)
        tokenStream = mLexer(inputStream)
        tree = mParser(tokenStream)
        nameInfo = NameGen(tree)
        typeInfo = TypeCheck(tree, nameInfo)
        ir = IRGen(tree,nameInfo,typeInfo)
        AsmGen(ir, args.outfile)
        return 0
    except MiniDecafError as e:
        if args.backtrace:
            raise e
        print(e, file=sys.stderr)
        return 1
