grammar MiniDecaf;
import CommonLex;

prog
    : (function|globalDecl)* EOF
    ;

globalDecl
    : declaration ';'
    ;

function
    : mtype Ident '(' parameterList ')' compoundStatement # funcDef
    | mtype Ident '(' parameterList ')' ';' # funcDecl
    ;

parameterList
     : (declaration (',' declaration)*)?
     ;

compoundStatement
    : '{' blockItem* '}'
    ;

mtype
    : 'int'         # typeInt
    | mtype '*'     # typePointer
    ;

blockItem
    :statement
    |declaration ';'
    ;

statement
    : 'return' expression ';' # returnStmt
    | expression? ';'       # exprStmt
    | 'if' '(' expression ')' ifBody=statement ('else' elseBody=statement)? # ifStmt
    | compoundStatement # compoundStmt
    | 'for' '(' pre=expression? ';' cond=expression? ';' post=expression? ')' body=statement # forStmt
    | 'for' '(' pre=declaration ';' cond=expression? ';' post=expression? ')' body=statement   # forDeclStmt
    | 'while' '(' expression ')' statement  # whileStmt
    | 'do' statement 'while' '(' expression ')' ';' # doWhileStmt
    | 'break' ';'   # breakStmt
    | 'continue' ';'    # continueStmt
    ;

declaration
    : mtype Ident ('[' Integer ']')* ('=' expression)?
    ;

expression
    : assignment
    ;

assignment
    : conditional           # pureAsgn
    | unary '=' expression  # complexAsgn
    ;

conditional
    : logical_or    # pureCond
    | logical_or '?' expression ':' conditional # complexCond
    ;

logical_or
    : logical_and                   # pureLor
    | logical_or '||' logical_and   # complexLor
    ;

logical_and
    : equality                  # pureLand
    | logical_and '&&' equality # complexLand
    ;

equality
    : relational                        # pureEqual
    | equality eqOp relational   # complexEqual
    ;

eqOp
    : '=='|'!='
    ;

relational
    : additive                         # pureRelation
    | relational relationOp additive   # complexRelation
    ;

relationOp
    :'<'|'>'|'<='|'>='
    ;

additive
    : multiplicative                        # pureAdd
    | additive addOp multiplicative     # complexAdd
    ;

addOp
    : '+'|'-'
    ;

multiplicative
    : unary                                 # pureMult
    | multiplicative mulOp unary    # complexMult
    ;

mulOp
    : '*'|'/'|'%'
    ;

expressionList
     : (expression (',' expression)*)?
     ;

unary
    : postfix              # pureUnary
    | unaryOp unary   # complexUnary
    | '(' mtype ')' unary   # castUnary
    ;

unaryOp
    : '-'|'~'|'!'|'&'|'*'
    ;

postfix
     : primary  # purePostfix
     | Ident '(' expressionList ')' # funcPostfix
     | postfix '[' expression ']' # arrayPostfix
     ;

primary
    : Integer              # atomInt
    | '(' expression ')'   # atomParent
    | Ident                # atomIdent
    ;
