# Generated from MiniDecaf.g4 by ANTLR 4.8
from antlr4 import *
if __name__ is not None and "." in __name__:
    from .MiniDecafParser import MiniDecafParser
else:
    from MiniDecafParser import MiniDecafParser

# This class defines a complete listener for a parse tree produced by MiniDecafParser.
class MiniDecafListener(ParseTreeListener):

    # Enter a parse tree produced by MiniDecafParser#prog.
    def enterProg(self, ctx:MiniDecafParser.ProgContext):
        pass

    # Exit a parse tree produced by MiniDecafParser#prog.
    def exitProg(self, ctx:MiniDecafParser.ProgContext):
        pass


    # Enter a parse tree produced by MiniDecafParser#globalDecl.
    def enterGlobalDecl(self, ctx:MiniDecafParser.GlobalDeclContext):
        pass

    # Exit a parse tree produced by MiniDecafParser#globalDecl.
    def exitGlobalDecl(self, ctx:MiniDecafParser.GlobalDeclContext):
        pass


    # Enter a parse tree produced by MiniDecafParser#funcDef.
    def enterFuncDef(self, ctx:MiniDecafParser.FuncDefContext):
        pass

    # Exit a parse tree produced by MiniDecafParser#funcDef.
    def exitFuncDef(self, ctx:MiniDecafParser.FuncDefContext):
        pass


    # Enter a parse tree produced by MiniDecafParser#funcDecl.
    def enterFuncDecl(self, ctx:MiniDecafParser.FuncDeclContext):
        pass

    # Exit a parse tree produced by MiniDecafParser#funcDecl.
    def exitFuncDecl(self, ctx:MiniDecafParser.FuncDeclContext):
        pass


    # Enter a parse tree produced by MiniDecafParser#parameterList.
    def enterParameterList(self, ctx:MiniDecafParser.ParameterListContext):
        pass

    # Exit a parse tree produced by MiniDecafParser#parameterList.
    def exitParameterList(self, ctx:MiniDecafParser.ParameterListContext):
        pass


    # Enter a parse tree produced by MiniDecafParser#compoundStatement.
    def enterCompoundStatement(self, ctx:MiniDecafParser.CompoundStatementContext):
        pass

    # Exit a parse tree produced by MiniDecafParser#compoundStatement.
    def exitCompoundStatement(self, ctx:MiniDecafParser.CompoundStatementContext):
        pass


    # Enter a parse tree produced by MiniDecafParser#typeInt.
    def enterTypeInt(self, ctx:MiniDecafParser.TypeIntContext):
        pass

    # Exit a parse tree produced by MiniDecafParser#typeInt.
    def exitTypeInt(self, ctx:MiniDecafParser.TypeIntContext):
        pass


    # Enter a parse tree produced by MiniDecafParser#typePointer.
    def enterTypePointer(self, ctx:MiniDecafParser.TypePointerContext):
        pass

    # Exit a parse tree produced by MiniDecafParser#typePointer.
    def exitTypePointer(self, ctx:MiniDecafParser.TypePointerContext):
        pass


    # Enter a parse tree produced by MiniDecafParser#blockItem.
    def enterBlockItem(self, ctx:MiniDecafParser.BlockItemContext):
        pass

    # Exit a parse tree produced by MiniDecafParser#blockItem.
    def exitBlockItem(self, ctx:MiniDecafParser.BlockItemContext):
        pass


    # Enter a parse tree produced by MiniDecafParser#returnStmt.
    def enterReturnStmt(self, ctx:MiniDecafParser.ReturnStmtContext):
        pass

    # Exit a parse tree produced by MiniDecafParser#returnStmt.
    def exitReturnStmt(self, ctx:MiniDecafParser.ReturnStmtContext):
        pass


    # Enter a parse tree produced by MiniDecafParser#exprStmt.
    def enterExprStmt(self, ctx:MiniDecafParser.ExprStmtContext):
        pass

    # Exit a parse tree produced by MiniDecafParser#exprStmt.
    def exitExprStmt(self, ctx:MiniDecafParser.ExprStmtContext):
        pass


    # Enter a parse tree produced by MiniDecafParser#ifStmt.
    def enterIfStmt(self, ctx:MiniDecafParser.IfStmtContext):
        pass

    # Exit a parse tree produced by MiniDecafParser#ifStmt.
    def exitIfStmt(self, ctx:MiniDecafParser.IfStmtContext):
        pass


    # Enter a parse tree produced by MiniDecafParser#compoundStmt.
    def enterCompoundStmt(self, ctx:MiniDecafParser.CompoundStmtContext):
        pass

    # Exit a parse tree produced by MiniDecafParser#compoundStmt.
    def exitCompoundStmt(self, ctx:MiniDecafParser.CompoundStmtContext):
        pass


    # Enter a parse tree produced by MiniDecafParser#forStmt.
    def enterForStmt(self, ctx:MiniDecafParser.ForStmtContext):
        pass

    # Exit a parse tree produced by MiniDecafParser#forStmt.
    def exitForStmt(self, ctx:MiniDecafParser.ForStmtContext):
        pass


    # Enter a parse tree produced by MiniDecafParser#forDeclStmt.
    def enterForDeclStmt(self, ctx:MiniDecafParser.ForDeclStmtContext):
        pass

    # Exit a parse tree produced by MiniDecafParser#forDeclStmt.
    def exitForDeclStmt(self, ctx:MiniDecafParser.ForDeclStmtContext):
        pass


    # Enter a parse tree produced by MiniDecafParser#whileStmt.
    def enterWhileStmt(self, ctx:MiniDecafParser.WhileStmtContext):
        pass

    # Exit a parse tree produced by MiniDecafParser#whileStmt.
    def exitWhileStmt(self, ctx:MiniDecafParser.WhileStmtContext):
        pass


    # Enter a parse tree produced by MiniDecafParser#doWhileStmt.
    def enterDoWhileStmt(self, ctx:MiniDecafParser.DoWhileStmtContext):
        pass

    # Exit a parse tree produced by MiniDecafParser#doWhileStmt.
    def exitDoWhileStmt(self, ctx:MiniDecafParser.DoWhileStmtContext):
        pass


    # Enter a parse tree produced by MiniDecafParser#breakStmt.
    def enterBreakStmt(self, ctx:MiniDecafParser.BreakStmtContext):
        pass

    # Exit a parse tree produced by MiniDecafParser#breakStmt.
    def exitBreakStmt(self, ctx:MiniDecafParser.BreakStmtContext):
        pass


    # Enter a parse tree produced by MiniDecafParser#continueStmt.
    def enterContinueStmt(self, ctx:MiniDecafParser.ContinueStmtContext):
        pass

    # Exit a parse tree produced by MiniDecafParser#continueStmt.
    def exitContinueStmt(self, ctx:MiniDecafParser.ContinueStmtContext):
        pass


    # Enter a parse tree produced by MiniDecafParser#declaration.
    def enterDeclaration(self, ctx:MiniDecafParser.DeclarationContext):
        pass

    # Exit a parse tree produced by MiniDecafParser#declaration.
    def exitDeclaration(self, ctx:MiniDecafParser.DeclarationContext):
        pass


    # Enter a parse tree produced by MiniDecafParser#expression.
    def enterExpression(self, ctx:MiniDecafParser.ExpressionContext):
        pass

    # Exit a parse tree produced by MiniDecafParser#expression.
    def exitExpression(self, ctx:MiniDecafParser.ExpressionContext):
        pass


    # Enter a parse tree produced by MiniDecafParser#pureAsgn.
    def enterPureAsgn(self, ctx:MiniDecafParser.PureAsgnContext):
        pass

    # Exit a parse tree produced by MiniDecafParser#pureAsgn.
    def exitPureAsgn(self, ctx:MiniDecafParser.PureAsgnContext):
        pass


    # Enter a parse tree produced by MiniDecafParser#complexAsgn.
    def enterComplexAsgn(self, ctx:MiniDecafParser.ComplexAsgnContext):
        pass

    # Exit a parse tree produced by MiniDecafParser#complexAsgn.
    def exitComplexAsgn(self, ctx:MiniDecafParser.ComplexAsgnContext):
        pass


    # Enter a parse tree produced by MiniDecafParser#pureCond.
    def enterPureCond(self, ctx:MiniDecafParser.PureCondContext):
        pass

    # Exit a parse tree produced by MiniDecafParser#pureCond.
    def exitPureCond(self, ctx:MiniDecafParser.PureCondContext):
        pass


    # Enter a parse tree produced by MiniDecafParser#complexCond.
    def enterComplexCond(self, ctx:MiniDecafParser.ComplexCondContext):
        pass

    # Exit a parse tree produced by MiniDecafParser#complexCond.
    def exitComplexCond(self, ctx:MiniDecafParser.ComplexCondContext):
        pass


    # Enter a parse tree produced by MiniDecafParser#complexLor.
    def enterComplexLor(self, ctx:MiniDecafParser.ComplexLorContext):
        pass

    # Exit a parse tree produced by MiniDecafParser#complexLor.
    def exitComplexLor(self, ctx:MiniDecafParser.ComplexLorContext):
        pass


    # Enter a parse tree produced by MiniDecafParser#pureLor.
    def enterPureLor(self, ctx:MiniDecafParser.PureLorContext):
        pass

    # Exit a parse tree produced by MiniDecafParser#pureLor.
    def exitPureLor(self, ctx:MiniDecafParser.PureLorContext):
        pass


    # Enter a parse tree produced by MiniDecafParser#complexLand.
    def enterComplexLand(self, ctx:MiniDecafParser.ComplexLandContext):
        pass

    # Exit a parse tree produced by MiniDecafParser#complexLand.
    def exitComplexLand(self, ctx:MiniDecafParser.ComplexLandContext):
        pass


    # Enter a parse tree produced by MiniDecafParser#pureLand.
    def enterPureLand(self, ctx:MiniDecafParser.PureLandContext):
        pass

    # Exit a parse tree produced by MiniDecafParser#pureLand.
    def exitPureLand(self, ctx:MiniDecafParser.PureLandContext):
        pass


    # Enter a parse tree produced by MiniDecafParser#pureEqual.
    def enterPureEqual(self, ctx:MiniDecafParser.PureEqualContext):
        pass

    # Exit a parse tree produced by MiniDecafParser#pureEqual.
    def exitPureEqual(self, ctx:MiniDecafParser.PureEqualContext):
        pass


    # Enter a parse tree produced by MiniDecafParser#complexEqual.
    def enterComplexEqual(self, ctx:MiniDecafParser.ComplexEqualContext):
        pass

    # Exit a parse tree produced by MiniDecafParser#complexEqual.
    def exitComplexEqual(self, ctx:MiniDecafParser.ComplexEqualContext):
        pass


    # Enter a parse tree produced by MiniDecafParser#eqOp.
    def enterEqOp(self, ctx:MiniDecafParser.EqOpContext):
        pass

    # Exit a parse tree produced by MiniDecafParser#eqOp.
    def exitEqOp(self, ctx:MiniDecafParser.EqOpContext):
        pass


    # Enter a parse tree produced by MiniDecafParser#complexRelation.
    def enterComplexRelation(self, ctx:MiniDecafParser.ComplexRelationContext):
        pass

    # Exit a parse tree produced by MiniDecafParser#complexRelation.
    def exitComplexRelation(self, ctx:MiniDecafParser.ComplexRelationContext):
        pass


    # Enter a parse tree produced by MiniDecafParser#pureRelation.
    def enterPureRelation(self, ctx:MiniDecafParser.PureRelationContext):
        pass

    # Exit a parse tree produced by MiniDecafParser#pureRelation.
    def exitPureRelation(self, ctx:MiniDecafParser.PureRelationContext):
        pass


    # Enter a parse tree produced by MiniDecafParser#relationOp.
    def enterRelationOp(self, ctx:MiniDecafParser.RelationOpContext):
        pass

    # Exit a parse tree produced by MiniDecafParser#relationOp.
    def exitRelationOp(self, ctx:MiniDecafParser.RelationOpContext):
        pass


    # Enter a parse tree produced by MiniDecafParser#complexAdd.
    def enterComplexAdd(self, ctx:MiniDecafParser.ComplexAddContext):
        pass

    # Exit a parse tree produced by MiniDecafParser#complexAdd.
    def exitComplexAdd(self, ctx:MiniDecafParser.ComplexAddContext):
        pass


    # Enter a parse tree produced by MiniDecafParser#pureAdd.
    def enterPureAdd(self, ctx:MiniDecafParser.PureAddContext):
        pass

    # Exit a parse tree produced by MiniDecafParser#pureAdd.
    def exitPureAdd(self, ctx:MiniDecafParser.PureAddContext):
        pass


    # Enter a parse tree produced by MiniDecafParser#addOp.
    def enterAddOp(self, ctx:MiniDecafParser.AddOpContext):
        pass

    # Exit a parse tree produced by MiniDecafParser#addOp.
    def exitAddOp(self, ctx:MiniDecafParser.AddOpContext):
        pass


    # Enter a parse tree produced by MiniDecafParser#pureMult.
    def enterPureMult(self, ctx:MiniDecafParser.PureMultContext):
        pass

    # Exit a parse tree produced by MiniDecafParser#pureMult.
    def exitPureMult(self, ctx:MiniDecafParser.PureMultContext):
        pass


    # Enter a parse tree produced by MiniDecafParser#complexMult.
    def enterComplexMult(self, ctx:MiniDecafParser.ComplexMultContext):
        pass

    # Exit a parse tree produced by MiniDecafParser#complexMult.
    def exitComplexMult(self, ctx:MiniDecafParser.ComplexMultContext):
        pass


    # Enter a parse tree produced by MiniDecafParser#mulOp.
    def enterMulOp(self, ctx:MiniDecafParser.MulOpContext):
        pass

    # Exit a parse tree produced by MiniDecafParser#mulOp.
    def exitMulOp(self, ctx:MiniDecafParser.MulOpContext):
        pass


    # Enter a parse tree produced by MiniDecafParser#expressionList.
    def enterExpressionList(self, ctx:MiniDecafParser.ExpressionListContext):
        pass

    # Exit a parse tree produced by MiniDecafParser#expressionList.
    def exitExpressionList(self, ctx:MiniDecafParser.ExpressionListContext):
        pass


    # Enter a parse tree produced by MiniDecafParser#pureUnary.
    def enterPureUnary(self, ctx:MiniDecafParser.PureUnaryContext):
        pass

    # Exit a parse tree produced by MiniDecafParser#pureUnary.
    def exitPureUnary(self, ctx:MiniDecafParser.PureUnaryContext):
        pass


    # Enter a parse tree produced by MiniDecafParser#complexUnary.
    def enterComplexUnary(self, ctx:MiniDecafParser.ComplexUnaryContext):
        pass

    # Exit a parse tree produced by MiniDecafParser#complexUnary.
    def exitComplexUnary(self, ctx:MiniDecafParser.ComplexUnaryContext):
        pass


    # Enter a parse tree produced by MiniDecafParser#castUnary.
    def enterCastUnary(self, ctx:MiniDecafParser.CastUnaryContext):
        pass

    # Exit a parse tree produced by MiniDecafParser#castUnary.
    def exitCastUnary(self, ctx:MiniDecafParser.CastUnaryContext):
        pass


    # Enter a parse tree produced by MiniDecafParser#unaryOp.
    def enterUnaryOp(self, ctx:MiniDecafParser.UnaryOpContext):
        pass

    # Exit a parse tree produced by MiniDecafParser#unaryOp.
    def exitUnaryOp(self, ctx:MiniDecafParser.UnaryOpContext):
        pass


    # Enter a parse tree produced by MiniDecafParser#funcPostfix.
    def enterFuncPostfix(self, ctx:MiniDecafParser.FuncPostfixContext):
        pass

    # Exit a parse tree produced by MiniDecafParser#funcPostfix.
    def exitFuncPostfix(self, ctx:MiniDecafParser.FuncPostfixContext):
        pass


    # Enter a parse tree produced by MiniDecafParser#arrayPostfix.
    def enterArrayPostfix(self, ctx:MiniDecafParser.ArrayPostfixContext):
        pass

    # Exit a parse tree produced by MiniDecafParser#arrayPostfix.
    def exitArrayPostfix(self, ctx:MiniDecafParser.ArrayPostfixContext):
        pass


    # Enter a parse tree produced by MiniDecafParser#purePostfix.
    def enterPurePostfix(self, ctx:MiniDecafParser.PurePostfixContext):
        pass

    # Exit a parse tree produced by MiniDecafParser#purePostfix.
    def exitPurePostfix(self, ctx:MiniDecafParser.PurePostfixContext):
        pass


    # Enter a parse tree produced by MiniDecafParser#atomInt.
    def enterAtomInt(self, ctx:MiniDecafParser.AtomIntContext):
        pass

    # Exit a parse tree produced by MiniDecafParser#atomInt.
    def exitAtomInt(self, ctx:MiniDecafParser.AtomIntContext):
        pass


    # Enter a parse tree produced by MiniDecafParser#atomParent.
    def enterAtomParent(self, ctx:MiniDecafParser.AtomParentContext):
        pass

    # Exit a parse tree produced by MiniDecafParser#atomParent.
    def exitAtomParent(self, ctx:MiniDecafParser.AtomParentContext):
        pass


    # Enter a parse tree produced by MiniDecafParser#atomIdent.
    def enterAtomIdent(self, ctx:MiniDecafParser.AtomIdentContext):
        pass

    # Exit a parse tree produced by MiniDecafParser#atomIdent.
    def exitAtomIdent(self, ctx:MiniDecafParser.AtomIdentContext):
        pass



del MiniDecafParser