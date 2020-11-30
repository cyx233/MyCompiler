# Generated from MiniDecaf.g4 by ANTLR 4.8
from antlr4 import *
if __name__ is not None and "." in __name__:
    from .MiniDecafParser import MiniDecafParser
else:
    from MiniDecafParser import MiniDecafParser

# This class defines a complete generic visitor for a parse tree produced by MiniDecafParser.

class MiniDecafVisitor(ParseTreeVisitor):

    # Visit a parse tree produced by MiniDecafParser#prog.
    def visitProg(self, ctx:MiniDecafParser.ProgContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by MiniDecafParser#globalDecl.
    def visitGlobalDecl(self, ctx:MiniDecafParser.GlobalDeclContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by MiniDecafParser#funcDef.
    def visitFuncDef(self, ctx:MiniDecafParser.FuncDefContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by MiniDecafParser#funcDecl.
    def visitFuncDecl(self, ctx:MiniDecafParser.FuncDeclContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by MiniDecafParser#parameterList.
    def visitParameterList(self, ctx:MiniDecafParser.ParameterListContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by MiniDecafParser#compoundStatement.
    def visitCompoundStatement(self, ctx:MiniDecafParser.CompoundStatementContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by MiniDecafParser#typeInt.
    def visitTypeInt(self, ctx:MiniDecafParser.TypeIntContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by MiniDecafParser#typePointer.
    def visitTypePointer(self, ctx:MiniDecafParser.TypePointerContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by MiniDecafParser#blockItem.
    def visitBlockItem(self, ctx:MiniDecafParser.BlockItemContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by MiniDecafParser#returnStmt.
    def visitReturnStmt(self, ctx:MiniDecafParser.ReturnStmtContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by MiniDecafParser#exprStmt.
    def visitExprStmt(self, ctx:MiniDecafParser.ExprStmtContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by MiniDecafParser#ifStmt.
    def visitIfStmt(self, ctx:MiniDecafParser.IfStmtContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by MiniDecafParser#compoundStmt.
    def visitCompoundStmt(self, ctx:MiniDecafParser.CompoundStmtContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by MiniDecafParser#forStmt.
    def visitForStmt(self, ctx:MiniDecafParser.ForStmtContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by MiniDecafParser#forDeclStmt.
    def visitForDeclStmt(self, ctx:MiniDecafParser.ForDeclStmtContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by MiniDecafParser#whileStmt.
    def visitWhileStmt(self, ctx:MiniDecafParser.WhileStmtContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by MiniDecafParser#doWhileStmt.
    def visitDoWhileStmt(self, ctx:MiniDecafParser.DoWhileStmtContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by MiniDecafParser#breakStmt.
    def visitBreakStmt(self, ctx:MiniDecafParser.BreakStmtContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by MiniDecafParser#continueStmt.
    def visitContinueStmt(self, ctx:MiniDecafParser.ContinueStmtContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by MiniDecafParser#declaration.
    def visitDeclaration(self, ctx:MiniDecafParser.DeclarationContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by MiniDecafParser#expression.
    def visitExpression(self, ctx:MiniDecafParser.ExpressionContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by MiniDecafParser#pureAsgn.
    def visitPureAsgn(self, ctx:MiniDecafParser.PureAsgnContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by MiniDecafParser#complexAsgn.
    def visitComplexAsgn(self, ctx:MiniDecafParser.ComplexAsgnContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by MiniDecafParser#pureCond.
    def visitPureCond(self, ctx:MiniDecafParser.PureCondContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by MiniDecafParser#complexCond.
    def visitComplexCond(self, ctx:MiniDecafParser.ComplexCondContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by MiniDecafParser#complexLor.
    def visitComplexLor(self, ctx:MiniDecafParser.ComplexLorContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by MiniDecafParser#pureLor.
    def visitPureLor(self, ctx:MiniDecafParser.PureLorContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by MiniDecafParser#complexLand.
    def visitComplexLand(self, ctx:MiniDecafParser.ComplexLandContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by MiniDecafParser#pureLand.
    def visitPureLand(self, ctx:MiniDecafParser.PureLandContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by MiniDecafParser#pureEqual.
    def visitPureEqual(self, ctx:MiniDecafParser.PureEqualContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by MiniDecafParser#complexEqual.
    def visitComplexEqual(self, ctx:MiniDecafParser.ComplexEqualContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by MiniDecafParser#eqOp.
    def visitEqOp(self, ctx:MiniDecafParser.EqOpContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by MiniDecafParser#complexRelation.
    def visitComplexRelation(self, ctx:MiniDecafParser.ComplexRelationContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by MiniDecafParser#pureRelation.
    def visitPureRelation(self, ctx:MiniDecafParser.PureRelationContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by MiniDecafParser#relationOp.
    def visitRelationOp(self, ctx:MiniDecafParser.RelationOpContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by MiniDecafParser#complexAdd.
    def visitComplexAdd(self, ctx:MiniDecafParser.ComplexAddContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by MiniDecafParser#pureAdd.
    def visitPureAdd(self, ctx:MiniDecafParser.PureAddContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by MiniDecafParser#addOp.
    def visitAddOp(self, ctx:MiniDecafParser.AddOpContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by MiniDecafParser#pureMult.
    def visitPureMult(self, ctx:MiniDecafParser.PureMultContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by MiniDecafParser#complexMult.
    def visitComplexMult(self, ctx:MiniDecafParser.ComplexMultContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by MiniDecafParser#mulOp.
    def visitMulOp(self, ctx:MiniDecafParser.MulOpContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by MiniDecafParser#expressionList.
    def visitExpressionList(self, ctx:MiniDecafParser.ExpressionListContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by MiniDecafParser#pureUnary.
    def visitPureUnary(self, ctx:MiniDecafParser.PureUnaryContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by MiniDecafParser#complexUnary.
    def visitComplexUnary(self, ctx:MiniDecafParser.ComplexUnaryContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by MiniDecafParser#castUnary.
    def visitCastUnary(self, ctx:MiniDecafParser.CastUnaryContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by MiniDecafParser#unaryOp.
    def visitUnaryOp(self, ctx:MiniDecafParser.UnaryOpContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by MiniDecafParser#funcPostfix.
    def visitFuncPostfix(self, ctx:MiniDecafParser.FuncPostfixContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by MiniDecafParser#arrayPostfix.
    def visitArrayPostfix(self, ctx:MiniDecafParser.ArrayPostfixContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by MiniDecafParser#purePostfix.
    def visitPurePostfix(self, ctx:MiniDecafParser.PurePostfixContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by MiniDecafParser#atomInt.
    def visitAtomInt(self, ctx:MiniDecafParser.AtomIntContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by MiniDecafParser#atomParent.
    def visitAtomParent(self, ctx:MiniDecafParser.AtomParentContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by MiniDecafParser#atomIdent.
    def visitAtomIdent(self, ctx:MiniDecafParser.AtomIdentContext):
        return self.visitChildren(ctx)



del MiniDecafParser