// Generated from /home/cyx/School/2020.9/Compiler/minidecaf/minidecaf/MiniDecaf.g4 by ANTLR 4.8
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class MiniDecafParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.8", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, Int=3, Return=4, If=5, Else=6, For=7, Do=8, While=9, Break=10, 
		Continue=11, Lparen=12, Rparen=13, Lbrkt=14, Rbrkt=15, Lbrace=16, Rbrace=17, 
		Comma=18, Semicolon=19, Punctuator=20, Plus=21, Minus=22, Asterisk=23, 
		Slash=24, Percent=25, Exclamation=26, Tilde=27, Ampersand=28, Langle=29, 
		Rangle=30, Langle_eq=31, Rangle_eq=32, Double_eq=33, Exclam_eq=34, Equal=35, 
		Double_amp=36, Double_bar=37, Operator=38, Integer=39, Whitespace=40, 
		Ident=41;
	public static final int
		RULE_prog = 0, RULE_globalDecl = 1, RULE_function = 2, RULE_parameterList = 3, 
		RULE_compoundStatement = 4, RULE_mtype = 5, RULE_blockItem = 6, RULE_statement = 7, 
		RULE_declaration = 8, RULE_expression = 9, RULE_assignment = 10, RULE_conditional = 11, 
		RULE_logical_or = 12, RULE_logical_and = 13, RULE_equality = 14, RULE_eqOp = 15, 
		RULE_relational = 16, RULE_relationOp = 17, RULE_additive = 18, RULE_addOp = 19, 
		RULE_multiplicative = 20, RULE_mulOp = 21, RULE_expressionList = 22, RULE_unary = 23, 
		RULE_unaryOp = 24, RULE_postfix = 25, RULE_primary = 26;
	private static String[] makeRuleNames() {
		return new String[] {
			"prog", "globalDecl", "function", "parameterList", "compoundStatement", 
			"mtype", "blockItem", "statement", "declaration", "expression", "assignment", 
			"conditional", "logical_or", "logical_and", "equality", "eqOp", "relational", 
			"relationOp", "additive", "addOp", "multiplicative", "mulOp", "expressionList", 
			"unary", "unaryOp", "postfix", "primary"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'?'", "':'", "'int'", "'return'", "'if'", "'else'", "'for'", "'do'", 
			"'while'", "'break'", "'continue'", "'('", "')'", "'['", "']'", "'{'", 
			"'}'", "','", "';'", null, "'+'", "'-'", "'*'", "'/'", "'%'", "'!'", 
			"'~'", "'&'", "'<'", "'>'", "'<='", "'>='", "'=='", "'!='", "'='", "'&&'", 
			"'||'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, "Int", "Return", "If", "Else", "For", "Do", "While", 
			"Break", "Continue", "Lparen", "Rparen", "Lbrkt", "Rbrkt", "Lbrace", 
			"Rbrace", "Comma", "Semicolon", "Punctuator", "Plus", "Minus", "Asterisk", 
			"Slash", "Percent", "Exclamation", "Tilde", "Ampersand", "Langle", "Rangle", 
			"Langle_eq", "Rangle_eq", "Double_eq", "Exclam_eq", "Equal", "Double_amp", 
			"Double_bar", "Operator", "Integer", "Whitespace", "Ident"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "MiniDecaf.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public MiniDecafParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class ProgContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(MiniDecafParser.EOF, 0); }
		public List<FunctionContext> function() {
			return getRuleContexts(FunctionContext.class);
		}
		public FunctionContext function(int i) {
			return getRuleContext(FunctionContext.class,i);
		}
		public List<GlobalDeclContext> globalDecl() {
			return getRuleContexts(GlobalDeclContext.class);
		}
		public GlobalDeclContext globalDecl(int i) {
			return getRuleContext(GlobalDeclContext.class,i);
		}
		public ProgContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prog; }
	}

	public final ProgContext prog() throws RecognitionException {
		ProgContext _localctx = new ProgContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_prog);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(58);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Int) {
				{
				setState(56);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
				case 1:
					{
					setState(54);
					function();
					}
					break;
				case 2:
					{
					setState(55);
					globalDecl();
					}
					break;
				}
				}
				setState(60);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(61);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class GlobalDeclContext extends ParserRuleContext {
		public DeclarationContext declaration() {
			return getRuleContext(DeclarationContext.class,0);
		}
		public TerminalNode Semicolon() { return getToken(MiniDecafParser.Semicolon, 0); }
		public GlobalDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_globalDecl; }
	}

	public final GlobalDeclContext globalDecl() throws RecognitionException {
		GlobalDeclContext _localctx = new GlobalDeclContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_globalDecl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(63);
			declaration();
			setState(64);
			match(Semicolon);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FunctionContext extends ParserRuleContext {
		public FunctionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_function; }
	 
		public FunctionContext() { }
		public void copyFrom(FunctionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class FuncDeclContext extends FunctionContext {
		public MtypeContext mtype() {
			return getRuleContext(MtypeContext.class,0);
		}
		public TerminalNode Ident() { return getToken(MiniDecafParser.Ident, 0); }
		public TerminalNode Lparen() { return getToken(MiniDecafParser.Lparen, 0); }
		public ParameterListContext parameterList() {
			return getRuleContext(ParameterListContext.class,0);
		}
		public TerminalNode Rparen() { return getToken(MiniDecafParser.Rparen, 0); }
		public TerminalNode Semicolon() { return getToken(MiniDecafParser.Semicolon, 0); }
		public FuncDeclContext(FunctionContext ctx) { copyFrom(ctx); }
	}
	public static class FuncDefContext extends FunctionContext {
		public MtypeContext mtype() {
			return getRuleContext(MtypeContext.class,0);
		}
		public TerminalNode Ident() { return getToken(MiniDecafParser.Ident, 0); }
		public TerminalNode Lparen() { return getToken(MiniDecafParser.Lparen, 0); }
		public ParameterListContext parameterList() {
			return getRuleContext(ParameterListContext.class,0);
		}
		public TerminalNode Rparen() { return getToken(MiniDecafParser.Rparen, 0); }
		public CompoundStatementContext compoundStatement() {
			return getRuleContext(CompoundStatementContext.class,0);
		}
		public FuncDefContext(FunctionContext ctx) { copyFrom(ctx); }
	}

	public final FunctionContext function() throws RecognitionException {
		FunctionContext _localctx = new FunctionContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_function);
		try {
			setState(80);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				_localctx = new FuncDefContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(66);
				mtype(0);
				setState(67);
				match(Ident);
				setState(68);
				match(Lparen);
				setState(69);
				parameterList();
				setState(70);
				match(Rparen);
				setState(71);
				compoundStatement();
				}
				break;
			case 2:
				_localctx = new FuncDeclContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(73);
				mtype(0);
				setState(74);
				match(Ident);
				setState(75);
				match(Lparen);
				setState(76);
				parameterList();
				setState(77);
				match(Rparen);
				setState(78);
				match(Semicolon);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ParameterListContext extends ParserRuleContext {
		public List<DeclarationContext> declaration() {
			return getRuleContexts(DeclarationContext.class);
		}
		public DeclarationContext declaration(int i) {
			return getRuleContext(DeclarationContext.class,i);
		}
		public List<TerminalNode> Comma() { return getTokens(MiniDecafParser.Comma); }
		public TerminalNode Comma(int i) {
			return getToken(MiniDecafParser.Comma, i);
		}
		public ParameterListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parameterList; }
	}

	public final ParameterListContext parameterList() throws RecognitionException {
		ParameterListContext _localctx = new ParameterListContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_parameterList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(90);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Int) {
				{
				setState(82);
				declaration();
				setState(87);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==Comma) {
					{
					{
					setState(83);
					match(Comma);
					setState(84);
					declaration();
					}
					}
					setState(89);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CompoundStatementContext extends ParserRuleContext {
		public TerminalNode Lbrace() { return getToken(MiniDecafParser.Lbrace, 0); }
		public TerminalNode Rbrace() { return getToken(MiniDecafParser.Rbrace, 0); }
		public List<BlockItemContext> blockItem() {
			return getRuleContexts(BlockItemContext.class);
		}
		public BlockItemContext blockItem(int i) {
			return getRuleContext(BlockItemContext.class,i);
		}
		public CompoundStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_compoundStatement; }
	}

	public final CompoundStatementContext compoundStatement() throws RecognitionException {
		CompoundStatementContext _localctx = new CompoundStatementContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_compoundStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(92);
			match(Lbrace);
			setState(96);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Int) | (1L << Return) | (1L << If) | (1L << For) | (1L << Do) | (1L << While) | (1L << Break) | (1L << Continue) | (1L << Lparen) | (1L << Lbrace) | (1L << Semicolon) | (1L << Minus) | (1L << Asterisk) | (1L << Exclamation) | (1L << Tilde) | (1L << Ampersand) | (1L << Integer) | (1L << Ident))) != 0)) {
				{
				{
				setState(93);
				blockItem();
				}
				}
				setState(98);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(99);
			match(Rbrace);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MtypeContext extends ParserRuleContext {
		public MtypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mtype; }
	 
		public MtypeContext() { }
		public void copyFrom(MtypeContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class TypeIntContext extends MtypeContext {
		public TerminalNode Int() { return getToken(MiniDecafParser.Int, 0); }
		public TypeIntContext(MtypeContext ctx) { copyFrom(ctx); }
	}
	public static class TypePointerContext extends MtypeContext {
		public MtypeContext mtype() {
			return getRuleContext(MtypeContext.class,0);
		}
		public TerminalNode Asterisk() { return getToken(MiniDecafParser.Asterisk, 0); }
		public TypePointerContext(MtypeContext ctx) { copyFrom(ctx); }
	}

	public final MtypeContext mtype() throws RecognitionException {
		return mtype(0);
	}

	private MtypeContext mtype(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		MtypeContext _localctx = new MtypeContext(_ctx, _parentState);
		MtypeContext _prevctx = _localctx;
		int _startState = 10;
		enterRecursionRule(_localctx, 10, RULE_mtype, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			_localctx = new TypeIntContext(_localctx);
			_ctx = _localctx;
			_prevctx = _localctx;

			setState(102);
			match(Int);
			}
			_ctx.stop = _input.LT(-1);
			setState(108);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new TypePointerContext(new MtypeContext(_parentctx, _parentState));
					pushNewRecursionContext(_localctx, _startState, RULE_mtype);
					setState(104);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(105);
					match(Asterisk);
					}
					} 
				}
				setState(110);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class BlockItemContext extends ParserRuleContext {
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public DeclarationContext declaration() {
			return getRuleContext(DeclarationContext.class,0);
		}
		public TerminalNode Semicolon() { return getToken(MiniDecafParser.Semicolon, 0); }
		public BlockItemContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_blockItem; }
	}

	public final BlockItemContext blockItem() throws RecognitionException {
		BlockItemContext _localctx = new BlockItemContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_blockItem);
		try {
			setState(115);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Return:
			case If:
			case For:
			case Do:
			case While:
			case Break:
			case Continue:
			case Lparen:
			case Lbrace:
			case Semicolon:
			case Minus:
			case Asterisk:
			case Exclamation:
			case Tilde:
			case Ampersand:
			case Integer:
			case Ident:
				enterOuterAlt(_localctx, 1);
				{
				setState(111);
				statement();
				}
				break;
			case Int:
				enterOuterAlt(_localctx, 2);
				{
				setState(112);
				declaration();
				setState(113);
				match(Semicolon);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StatementContext extends ParserRuleContext {
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
	 
		public StatementContext() { }
		public void copyFrom(StatementContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ExprStmtContext extends StatementContext {
		public TerminalNode Semicolon() { return getToken(MiniDecafParser.Semicolon, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ExprStmtContext(StatementContext ctx) { copyFrom(ctx); }
	}
	public static class ForStmtContext extends StatementContext {
		public ExpressionContext pre;
		public ExpressionContext cond;
		public ExpressionContext post;
		public StatementContext body;
		public TerminalNode For() { return getToken(MiniDecafParser.For, 0); }
		public TerminalNode Lparen() { return getToken(MiniDecafParser.Lparen, 0); }
		public List<TerminalNode> Semicolon() { return getTokens(MiniDecafParser.Semicolon); }
		public TerminalNode Semicolon(int i) {
			return getToken(MiniDecafParser.Semicolon, i);
		}
		public TerminalNode Rparen() { return getToken(MiniDecafParser.Rparen, 0); }
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public ForStmtContext(StatementContext ctx) { copyFrom(ctx); }
	}
	public static class WhileStmtContext extends StatementContext {
		public TerminalNode While() { return getToken(MiniDecafParser.While, 0); }
		public TerminalNode Lparen() { return getToken(MiniDecafParser.Lparen, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode Rparen() { return getToken(MiniDecafParser.Rparen, 0); }
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public WhileStmtContext(StatementContext ctx) { copyFrom(ctx); }
	}
	public static class IfStmtContext extends StatementContext {
		public StatementContext ifBody;
		public StatementContext elseBody;
		public TerminalNode If() { return getToken(MiniDecafParser.If, 0); }
		public TerminalNode Lparen() { return getToken(MiniDecafParser.Lparen, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode Rparen() { return getToken(MiniDecafParser.Rparen, 0); }
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public TerminalNode Else() { return getToken(MiniDecafParser.Else, 0); }
		public IfStmtContext(StatementContext ctx) { copyFrom(ctx); }
	}
	public static class ForDeclStmtContext extends StatementContext {
		public DeclarationContext pre;
		public ExpressionContext cond;
		public ExpressionContext post;
		public StatementContext body;
		public TerminalNode For() { return getToken(MiniDecafParser.For, 0); }
		public TerminalNode Lparen() { return getToken(MiniDecafParser.Lparen, 0); }
		public List<TerminalNode> Semicolon() { return getTokens(MiniDecafParser.Semicolon); }
		public TerminalNode Semicolon(int i) {
			return getToken(MiniDecafParser.Semicolon, i);
		}
		public TerminalNode Rparen() { return getToken(MiniDecafParser.Rparen, 0); }
		public DeclarationContext declaration() {
			return getRuleContext(DeclarationContext.class,0);
		}
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public ForDeclStmtContext(StatementContext ctx) { copyFrom(ctx); }
	}
	public static class DoWhileStmtContext extends StatementContext {
		public TerminalNode Do() { return getToken(MiniDecafParser.Do, 0); }
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public TerminalNode While() { return getToken(MiniDecafParser.While, 0); }
		public TerminalNode Lparen() { return getToken(MiniDecafParser.Lparen, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode Rparen() { return getToken(MiniDecafParser.Rparen, 0); }
		public TerminalNode Semicolon() { return getToken(MiniDecafParser.Semicolon, 0); }
		public DoWhileStmtContext(StatementContext ctx) { copyFrom(ctx); }
	}
	public static class CompoundStmtContext extends StatementContext {
		public CompoundStatementContext compoundStatement() {
			return getRuleContext(CompoundStatementContext.class,0);
		}
		public CompoundStmtContext(StatementContext ctx) { copyFrom(ctx); }
	}
	public static class BreakStmtContext extends StatementContext {
		public TerminalNode Break() { return getToken(MiniDecafParser.Break, 0); }
		public TerminalNode Semicolon() { return getToken(MiniDecafParser.Semicolon, 0); }
		public BreakStmtContext(StatementContext ctx) { copyFrom(ctx); }
	}
	public static class ReturnStmtContext extends StatementContext {
		public TerminalNode Return() { return getToken(MiniDecafParser.Return, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode Semicolon() { return getToken(MiniDecafParser.Semicolon, 0); }
		public ReturnStmtContext(StatementContext ctx) { copyFrom(ctx); }
	}
	public static class ContinueStmtContext extends StatementContext {
		public TerminalNode Continue() { return getToken(MiniDecafParser.Continue, 0); }
		public TerminalNode Semicolon() { return getToken(MiniDecafParser.Semicolon, 0); }
		public ContinueStmtContext(StatementContext ctx) { copyFrom(ctx); }
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_statement);
		int _la;
		try {
			setState(182);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
			case 1:
				_localctx = new ReturnStmtContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(117);
				match(Return);
				setState(118);
				expression();
				setState(119);
				match(Semicolon);
				}
				break;
			case 2:
				_localctx = new ExprStmtContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(122);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Lparen) | (1L << Minus) | (1L << Asterisk) | (1L << Exclamation) | (1L << Tilde) | (1L << Ampersand) | (1L << Integer) | (1L << Ident))) != 0)) {
					{
					setState(121);
					expression();
					}
				}

				setState(124);
				match(Semicolon);
				}
				break;
			case 3:
				_localctx = new IfStmtContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(125);
				match(If);
				setState(126);
				match(Lparen);
				setState(127);
				expression();
				setState(128);
				match(Rparen);
				setState(129);
				((IfStmtContext)_localctx).ifBody = statement();
				setState(132);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
				case 1:
					{
					setState(130);
					match(Else);
					setState(131);
					((IfStmtContext)_localctx).elseBody = statement();
					}
					break;
				}
				}
				break;
			case 4:
				_localctx = new CompoundStmtContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(134);
				compoundStatement();
				}
				break;
			case 5:
				_localctx = new ForStmtContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(135);
				match(For);
				setState(136);
				match(Lparen);
				setState(138);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Lparen) | (1L << Minus) | (1L << Asterisk) | (1L << Exclamation) | (1L << Tilde) | (1L << Ampersand) | (1L << Integer) | (1L << Ident))) != 0)) {
					{
					setState(137);
					((ForStmtContext)_localctx).pre = expression();
					}
				}

				setState(140);
				match(Semicolon);
				setState(142);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Lparen) | (1L << Minus) | (1L << Asterisk) | (1L << Exclamation) | (1L << Tilde) | (1L << Ampersand) | (1L << Integer) | (1L << Ident))) != 0)) {
					{
					setState(141);
					((ForStmtContext)_localctx).cond = expression();
					}
				}

				setState(144);
				match(Semicolon);
				setState(146);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Lparen) | (1L << Minus) | (1L << Asterisk) | (1L << Exclamation) | (1L << Tilde) | (1L << Ampersand) | (1L << Integer) | (1L << Ident))) != 0)) {
					{
					setState(145);
					((ForStmtContext)_localctx).post = expression();
					}
				}

				setState(148);
				match(Rparen);
				setState(149);
				((ForStmtContext)_localctx).body = statement();
				}
				break;
			case 6:
				_localctx = new ForDeclStmtContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(150);
				match(For);
				setState(151);
				match(Lparen);
				setState(152);
				((ForDeclStmtContext)_localctx).pre = declaration();
				setState(153);
				match(Semicolon);
				setState(155);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Lparen) | (1L << Minus) | (1L << Asterisk) | (1L << Exclamation) | (1L << Tilde) | (1L << Ampersand) | (1L << Integer) | (1L << Ident))) != 0)) {
					{
					setState(154);
					((ForDeclStmtContext)_localctx).cond = expression();
					}
				}

				setState(157);
				match(Semicolon);
				setState(159);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Lparen) | (1L << Minus) | (1L << Asterisk) | (1L << Exclamation) | (1L << Tilde) | (1L << Ampersand) | (1L << Integer) | (1L << Ident))) != 0)) {
					{
					setState(158);
					((ForDeclStmtContext)_localctx).post = expression();
					}
				}

				setState(161);
				match(Rparen);
				setState(162);
				((ForDeclStmtContext)_localctx).body = statement();
				}
				break;
			case 7:
				_localctx = new WhileStmtContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(164);
				match(While);
				setState(165);
				match(Lparen);
				setState(166);
				expression();
				setState(167);
				match(Rparen);
				setState(168);
				statement();
				}
				break;
			case 8:
				_localctx = new DoWhileStmtContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(170);
				match(Do);
				setState(171);
				statement();
				setState(172);
				match(While);
				setState(173);
				match(Lparen);
				setState(174);
				expression();
				setState(175);
				match(Rparen);
				setState(176);
				match(Semicolon);
				}
				break;
			case 9:
				_localctx = new BreakStmtContext(_localctx);
				enterOuterAlt(_localctx, 9);
				{
				setState(178);
				match(Break);
				setState(179);
				match(Semicolon);
				}
				break;
			case 10:
				_localctx = new ContinueStmtContext(_localctx);
				enterOuterAlt(_localctx, 10);
				{
				setState(180);
				match(Continue);
				setState(181);
				match(Semicolon);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DeclarationContext extends ParserRuleContext {
		public MtypeContext mtype() {
			return getRuleContext(MtypeContext.class,0);
		}
		public TerminalNode Ident() { return getToken(MiniDecafParser.Ident, 0); }
		public List<TerminalNode> Lbrkt() { return getTokens(MiniDecafParser.Lbrkt); }
		public TerminalNode Lbrkt(int i) {
			return getToken(MiniDecafParser.Lbrkt, i);
		}
		public List<TerminalNode> Integer() { return getTokens(MiniDecafParser.Integer); }
		public TerminalNode Integer(int i) {
			return getToken(MiniDecafParser.Integer, i);
		}
		public List<TerminalNode> Rbrkt() { return getTokens(MiniDecafParser.Rbrkt); }
		public TerminalNode Rbrkt(int i) {
			return getToken(MiniDecafParser.Rbrkt, i);
		}
		public TerminalNode Equal() { return getToken(MiniDecafParser.Equal, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public DeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaration; }
	}

	public final DeclarationContext declaration() throws RecognitionException {
		DeclarationContext _localctx = new DeclarationContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_declaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(184);
			mtype(0);
			setState(185);
			match(Ident);
			setState(191);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Lbrkt) {
				{
				{
				setState(186);
				match(Lbrkt);
				setState(187);
				match(Integer);
				setState(188);
				match(Rbrkt);
				}
				}
				setState(193);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(196);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Equal) {
				{
				setState(194);
				match(Equal);
				setState(195);
				expression();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpressionContext extends ParserRuleContext {
		public AssignmentContext assignment() {
			return getRuleContext(AssignmentContext.class,0);
		}
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
	}

	public final ExpressionContext expression() throws RecognitionException {
		ExpressionContext _localctx = new ExpressionContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_expression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(198);
			assignment();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AssignmentContext extends ParserRuleContext {
		public AssignmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignment; }
	 
		public AssignmentContext() { }
		public void copyFrom(AssignmentContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class PureAsgnContext extends AssignmentContext {
		public ConditionalContext conditional() {
			return getRuleContext(ConditionalContext.class,0);
		}
		public PureAsgnContext(AssignmentContext ctx) { copyFrom(ctx); }
	}
	public static class ComplexAsgnContext extends AssignmentContext {
		public UnaryContext unary() {
			return getRuleContext(UnaryContext.class,0);
		}
		public TerminalNode Equal() { return getToken(MiniDecafParser.Equal, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ComplexAsgnContext(AssignmentContext ctx) { copyFrom(ctx); }
	}

	public final AssignmentContext assignment() throws RecognitionException {
		AssignmentContext _localctx = new AssignmentContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_assignment);
		try {
			setState(205);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
			case 1:
				_localctx = new PureAsgnContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(200);
				conditional();
				}
				break;
			case 2:
				_localctx = new ComplexAsgnContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(201);
				unary();
				setState(202);
				match(Equal);
				setState(203);
				expression();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ConditionalContext extends ParserRuleContext {
		public ConditionalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_conditional; }
	 
		public ConditionalContext() { }
		public void copyFrom(ConditionalContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ComplexCondContext extends ConditionalContext {
		public Logical_orContext logical_or() {
			return getRuleContext(Logical_orContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ConditionalContext conditional() {
			return getRuleContext(ConditionalContext.class,0);
		}
		public ComplexCondContext(ConditionalContext ctx) { copyFrom(ctx); }
	}
	public static class PureCondContext extends ConditionalContext {
		public Logical_orContext logical_or() {
			return getRuleContext(Logical_orContext.class,0);
		}
		public PureCondContext(ConditionalContext ctx) { copyFrom(ctx); }
	}

	public final ConditionalContext conditional() throws RecognitionException {
		ConditionalContext _localctx = new ConditionalContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_conditional);
		try {
			setState(214);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
			case 1:
				_localctx = new PureCondContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(207);
				logical_or(0);
				}
				break;
			case 2:
				_localctx = new ComplexCondContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(208);
				logical_or(0);
				setState(209);
				match(T__0);
				setState(210);
				expression();
				setState(211);
				match(T__1);
				setState(212);
				conditional();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Logical_orContext extends ParserRuleContext {
		public Logical_orContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_logical_or; }
	 
		public Logical_orContext() { }
		public void copyFrom(Logical_orContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ComplexLorContext extends Logical_orContext {
		public Logical_orContext logical_or() {
			return getRuleContext(Logical_orContext.class,0);
		}
		public TerminalNode Double_bar() { return getToken(MiniDecafParser.Double_bar, 0); }
		public Logical_andContext logical_and() {
			return getRuleContext(Logical_andContext.class,0);
		}
		public ComplexLorContext(Logical_orContext ctx) { copyFrom(ctx); }
	}
	public static class PureLorContext extends Logical_orContext {
		public Logical_andContext logical_and() {
			return getRuleContext(Logical_andContext.class,0);
		}
		public PureLorContext(Logical_orContext ctx) { copyFrom(ctx); }
	}

	public final Logical_orContext logical_or() throws RecognitionException {
		return logical_or(0);
	}

	private Logical_orContext logical_or(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		Logical_orContext _localctx = new Logical_orContext(_ctx, _parentState);
		Logical_orContext _prevctx = _localctx;
		int _startState = 24;
		enterRecursionRule(_localctx, 24, RULE_logical_or, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			_localctx = new PureLorContext(_localctx);
			_ctx = _localctx;
			_prevctx = _localctx;

			setState(217);
			logical_and(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(224);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,20,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new ComplexLorContext(new Logical_orContext(_parentctx, _parentState));
					pushNewRecursionContext(_localctx, _startState, RULE_logical_or);
					setState(219);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(220);
					match(Double_bar);
					setState(221);
					logical_and(0);
					}
					} 
				}
				setState(226);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,20,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class Logical_andContext extends ParserRuleContext {
		public Logical_andContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_logical_and; }
	 
		public Logical_andContext() { }
		public void copyFrom(Logical_andContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ComplexLandContext extends Logical_andContext {
		public Logical_andContext logical_and() {
			return getRuleContext(Logical_andContext.class,0);
		}
		public TerminalNode Double_amp() { return getToken(MiniDecafParser.Double_amp, 0); }
		public EqualityContext equality() {
			return getRuleContext(EqualityContext.class,0);
		}
		public ComplexLandContext(Logical_andContext ctx) { copyFrom(ctx); }
	}
	public static class PureLandContext extends Logical_andContext {
		public EqualityContext equality() {
			return getRuleContext(EqualityContext.class,0);
		}
		public PureLandContext(Logical_andContext ctx) { copyFrom(ctx); }
	}

	public final Logical_andContext logical_and() throws RecognitionException {
		return logical_and(0);
	}

	private Logical_andContext logical_and(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		Logical_andContext _localctx = new Logical_andContext(_ctx, _parentState);
		Logical_andContext _prevctx = _localctx;
		int _startState = 26;
		enterRecursionRule(_localctx, 26, RULE_logical_and, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			_localctx = new PureLandContext(_localctx);
			_ctx = _localctx;
			_prevctx = _localctx;

			setState(228);
			equality(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(235);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,21,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new ComplexLandContext(new Logical_andContext(_parentctx, _parentState));
					pushNewRecursionContext(_localctx, _startState, RULE_logical_and);
					setState(230);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(231);
					match(Double_amp);
					setState(232);
					equality(0);
					}
					} 
				}
				setState(237);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,21,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class EqualityContext extends ParserRuleContext {
		public EqualityContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_equality; }
	 
		public EqualityContext() { }
		public void copyFrom(EqualityContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class PureEqualContext extends EqualityContext {
		public RelationalContext relational() {
			return getRuleContext(RelationalContext.class,0);
		}
		public PureEqualContext(EqualityContext ctx) { copyFrom(ctx); }
	}
	public static class ComplexEqualContext extends EqualityContext {
		public EqualityContext equality() {
			return getRuleContext(EqualityContext.class,0);
		}
		public EqOpContext eqOp() {
			return getRuleContext(EqOpContext.class,0);
		}
		public RelationalContext relational() {
			return getRuleContext(RelationalContext.class,0);
		}
		public ComplexEqualContext(EqualityContext ctx) { copyFrom(ctx); }
	}

	public final EqualityContext equality() throws RecognitionException {
		return equality(0);
	}

	private EqualityContext equality(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		EqualityContext _localctx = new EqualityContext(_ctx, _parentState);
		EqualityContext _prevctx = _localctx;
		int _startState = 28;
		enterRecursionRule(_localctx, 28, RULE_equality, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			_localctx = new PureEqualContext(_localctx);
			_ctx = _localctx;
			_prevctx = _localctx;

			setState(239);
			relational(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(247);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,22,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new ComplexEqualContext(new EqualityContext(_parentctx, _parentState));
					pushNewRecursionContext(_localctx, _startState, RULE_equality);
					setState(241);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(242);
					eqOp();
					setState(243);
					relational(0);
					}
					} 
				}
				setState(249);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,22,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class EqOpContext extends ParserRuleContext {
		public TerminalNode Double_eq() { return getToken(MiniDecafParser.Double_eq, 0); }
		public TerminalNode Exclam_eq() { return getToken(MiniDecafParser.Exclam_eq, 0); }
		public EqOpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_eqOp; }
	}

	public final EqOpContext eqOp() throws RecognitionException {
		EqOpContext _localctx = new EqOpContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_eqOp);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(250);
			_la = _input.LA(1);
			if ( !(_la==Double_eq || _la==Exclam_eq) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class RelationalContext extends ParserRuleContext {
		public RelationalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_relational; }
	 
		public RelationalContext() { }
		public void copyFrom(RelationalContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ComplexRelationContext extends RelationalContext {
		public RelationalContext relational() {
			return getRuleContext(RelationalContext.class,0);
		}
		public RelationOpContext relationOp() {
			return getRuleContext(RelationOpContext.class,0);
		}
		public AdditiveContext additive() {
			return getRuleContext(AdditiveContext.class,0);
		}
		public ComplexRelationContext(RelationalContext ctx) { copyFrom(ctx); }
	}
	public static class PureRelationContext extends RelationalContext {
		public AdditiveContext additive() {
			return getRuleContext(AdditiveContext.class,0);
		}
		public PureRelationContext(RelationalContext ctx) { copyFrom(ctx); }
	}

	public final RelationalContext relational() throws RecognitionException {
		return relational(0);
	}

	private RelationalContext relational(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		RelationalContext _localctx = new RelationalContext(_ctx, _parentState);
		RelationalContext _prevctx = _localctx;
		int _startState = 32;
		enterRecursionRule(_localctx, 32, RULE_relational, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			_localctx = new PureRelationContext(_localctx);
			_ctx = _localctx;
			_prevctx = _localctx;

			setState(253);
			additive(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(261);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,23,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new ComplexRelationContext(new RelationalContext(_parentctx, _parentState));
					pushNewRecursionContext(_localctx, _startState, RULE_relational);
					setState(255);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(256);
					relationOp();
					setState(257);
					additive(0);
					}
					} 
				}
				setState(263);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,23,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class RelationOpContext extends ParserRuleContext {
		public TerminalNode Langle() { return getToken(MiniDecafParser.Langle, 0); }
		public TerminalNode Rangle() { return getToken(MiniDecafParser.Rangle, 0); }
		public TerminalNode Langle_eq() { return getToken(MiniDecafParser.Langle_eq, 0); }
		public TerminalNode Rangle_eq() { return getToken(MiniDecafParser.Rangle_eq, 0); }
		public RelationOpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_relationOp; }
	}

	public final RelationOpContext relationOp() throws RecognitionException {
		RelationOpContext _localctx = new RelationOpContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_relationOp);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(264);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Langle) | (1L << Rangle) | (1L << Langle_eq) | (1L << Rangle_eq))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AdditiveContext extends ParserRuleContext {
		public AdditiveContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_additive; }
	 
		public AdditiveContext() { }
		public void copyFrom(AdditiveContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ComplexAddContext extends AdditiveContext {
		public AdditiveContext additive() {
			return getRuleContext(AdditiveContext.class,0);
		}
		public AddOpContext addOp() {
			return getRuleContext(AddOpContext.class,0);
		}
		public MultiplicativeContext multiplicative() {
			return getRuleContext(MultiplicativeContext.class,0);
		}
		public ComplexAddContext(AdditiveContext ctx) { copyFrom(ctx); }
	}
	public static class PureAddContext extends AdditiveContext {
		public MultiplicativeContext multiplicative() {
			return getRuleContext(MultiplicativeContext.class,0);
		}
		public PureAddContext(AdditiveContext ctx) { copyFrom(ctx); }
	}

	public final AdditiveContext additive() throws RecognitionException {
		return additive(0);
	}

	private AdditiveContext additive(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		AdditiveContext _localctx = new AdditiveContext(_ctx, _parentState);
		AdditiveContext _prevctx = _localctx;
		int _startState = 36;
		enterRecursionRule(_localctx, 36, RULE_additive, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			_localctx = new PureAddContext(_localctx);
			_ctx = _localctx;
			_prevctx = _localctx;

			setState(267);
			multiplicative(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(275);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,24,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new ComplexAddContext(new AdditiveContext(_parentctx, _parentState));
					pushNewRecursionContext(_localctx, _startState, RULE_additive);
					setState(269);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(270);
					addOp();
					setState(271);
					multiplicative(0);
					}
					} 
				}
				setState(277);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,24,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class AddOpContext extends ParserRuleContext {
		public TerminalNode Plus() { return getToken(MiniDecafParser.Plus, 0); }
		public TerminalNode Minus() { return getToken(MiniDecafParser.Minus, 0); }
		public AddOpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_addOp; }
	}

	public final AddOpContext addOp() throws RecognitionException {
		AddOpContext _localctx = new AddOpContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_addOp);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(278);
			_la = _input.LA(1);
			if ( !(_la==Plus || _la==Minus) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MultiplicativeContext extends ParserRuleContext {
		public MultiplicativeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_multiplicative; }
	 
		public MultiplicativeContext() { }
		public void copyFrom(MultiplicativeContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class PureMultContext extends MultiplicativeContext {
		public UnaryContext unary() {
			return getRuleContext(UnaryContext.class,0);
		}
		public PureMultContext(MultiplicativeContext ctx) { copyFrom(ctx); }
	}
	public static class ComplexMultContext extends MultiplicativeContext {
		public MultiplicativeContext multiplicative() {
			return getRuleContext(MultiplicativeContext.class,0);
		}
		public MulOpContext mulOp() {
			return getRuleContext(MulOpContext.class,0);
		}
		public UnaryContext unary() {
			return getRuleContext(UnaryContext.class,0);
		}
		public ComplexMultContext(MultiplicativeContext ctx) { copyFrom(ctx); }
	}

	public final MultiplicativeContext multiplicative() throws RecognitionException {
		return multiplicative(0);
	}

	private MultiplicativeContext multiplicative(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		MultiplicativeContext _localctx = new MultiplicativeContext(_ctx, _parentState);
		MultiplicativeContext _prevctx = _localctx;
		int _startState = 40;
		enterRecursionRule(_localctx, 40, RULE_multiplicative, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			_localctx = new PureMultContext(_localctx);
			_ctx = _localctx;
			_prevctx = _localctx;

			setState(281);
			unary();
			}
			_ctx.stop = _input.LT(-1);
			setState(289);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,25,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new ComplexMultContext(new MultiplicativeContext(_parentctx, _parentState));
					pushNewRecursionContext(_localctx, _startState, RULE_multiplicative);
					setState(283);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(284);
					mulOp();
					setState(285);
					unary();
					}
					} 
				}
				setState(291);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,25,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class MulOpContext extends ParserRuleContext {
		public TerminalNode Asterisk() { return getToken(MiniDecafParser.Asterisk, 0); }
		public TerminalNode Slash() { return getToken(MiniDecafParser.Slash, 0); }
		public TerminalNode Percent() { return getToken(MiniDecafParser.Percent, 0); }
		public MulOpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mulOp; }
	}

	public final MulOpContext mulOp() throws RecognitionException {
		MulOpContext _localctx = new MulOpContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_mulOp);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(292);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Asterisk) | (1L << Slash) | (1L << Percent))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpressionListContext extends ParserRuleContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<TerminalNode> Comma() { return getTokens(MiniDecafParser.Comma); }
		public TerminalNode Comma(int i) {
			return getToken(MiniDecafParser.Comma, i);
		}
		public ExpressionListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expressionList; }
	}

	public final ExpressionListContext expressionList() throws RecognitionException {
		ExpressionListContext _localctx = new ExpressionListContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_expressionList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(302);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Lparen) | (1L << Minus) | (1L << Asterisk) | (1L << Exclamation) | (1L << Tilde) | (1L << Ampersand) | (1L << Integer) | (1L << Ident))) != 0)) {
				{
				setState(294);
				expression();
				setState(299);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==Comma) {
					{
					{
					setState(295);
					match(Comma);
					setState(296);
					expression();
					}
					}
					setState(301);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class UnaryContext extends ParserRuleContext {
		public UnaryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unary; }
	 
		public UnaryContext() { }
		public void copyFrom(UnaryContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ComplexUnaryContext extends UnaryContext {
		public UnaryOpContext unaryOp() {
			return getRuleContext(UnaryOpContext.class,0);
		}
		public UnaryContext unary() {
			return getRuleContext(UnaryContext.class,0);
		}
		public ComplexUnaryContext(UnaryContext ctx) { copyFrom(ctx); }
	}
	public static class CastUnaryContext extends UnaryContext {
		public TerminalNode Lparen() { return getToken(MiniDecafParser.Lparen, 0); }
		public MtypeContext mtype() {
			return getRuleContext(MtypeContext.class,0);
		}
		public TerminalNode Rparen() { return getToken(MiniDecafParser.Rparen, 0); }
		public UnaryContext unary() {
			return getRuleContext(UnaryContext.class,0);
		}
		public CastUnaryContext(UnaryContext ctx) { copyFrom(ctx); }
	}
	public static class PureUnaryContext extends UnaryContext {
		public PostfixContext postfix() {
			return getRuleContext(PostfixContext.class,0);
		}
		public PureUnaryContext(UnaryContext ctx) { copyFrom(ctx); }
	}

	public final UnaryContext unary() throws RecognitionException {
		UnaryContext _localctx = new UnaryContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_unary);
		try {
			setState(313);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,28,_ctx) ) {
			case 1:
				_localctx = new PureUnaryContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(304);
				postfix(0);
				}
				break;
			case 2:
				_localctx = new ComplexUnaryContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(305);
				unaryOp();
				setState(306);
				unary();
				}
				break;
			case 3:
				_localctx = new CastUnaryContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(308);
				match(Lparen);
				setState(309);
				mtype(0);
				setState(310);
				match(Rparen);
				setState(311);
				unary();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class UnaryOpContext extends ParserRuleContext {
		public TerminalNode Minus() { return getToken(MiniDecafParser.Minus, 0); }
		public TerminalNode Tilde() { return getToken(MiniDecafParser.Tilde, 0); }
		public TerminalNode Exclamation() { return getToken(MiniDecafParser.Exclamation, 0); }
		public TerminalNode Ampersand() { return getToken(MiniDecafParser.Ampersand, 0); }
		public TerminalNode Asterisk() { return getToken(MiniDecafParser.Asterisk, 0); }
		public UnaryOpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unaryOp; }
	}

	public final UnaryOpContext unaryOp() throws RecognitionException {
		UnaryOpContext _localctx = new UnaryOpContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_unaryOp);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(315);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Minus) | (1L << Asterisk) | (1L << Exclamation) | (1L << Tilde) | (1L << Ampersand))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PostfixContext extends ParserRuleContext {
		public PostfixContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_postfix; }
	 
		public PostfixContext() { }
		public void copyFrom(PostfixContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class FuncPostfixContext extends PostfixContext {
		public TerminalNode Ident() { return getToken(MiniDecafParser.Ident, 0); }
		public TerminalNode Lparen() { return getToken(MiniDecafParser.Lparen, 0); }
		public ExpressionListContext expressionList() {
			return getRuleContext(ExpressionListContext.class,0);
		}
		public TerminalNode Rparen() { return getToken(MiniDecafParser.Rparen, 0); }
		public FuncPostfixContext(PostfixContext ctx) { copyFrom(ctx); }
	}
	public static class ArrayPostfixContext extends PostfixContext {
		public PostfixContext postfix() {
			return getRuleContext(PostfixContext.class,0);
		}
		public TerminalNode Lbrkt() { return getToken(MiniDecafParser.Lbrkt, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode Rbrkt() { return getToken(MiniDecafParser.Rbrkt, 0); }
		public ArrayPostfixContext(PostfixContext ctx) { copyFrom(ctx); }
	}
	public static class PurePostfixContext extends PostfixContext {
		public PrimaryContext primary() {
			return getRuleContext(PrimaryContext.class,0);
		}
		public PurePostfixContext(PostfixContext ctx) { copyFrom(ctx); }
	}

	public final PostfixContext postfix() throws RecognitionException {
		return postfix(0);
	}

	private PostfixContext postfix(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		PostfixContext _localctx = new PostfixContext(_ctx, _parentState);
		PostfixContext _prevctx = _localctx;
		int _startState = 50;
		enterRecursionRule(_localctx, 50, RULE_postfix, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(324);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,29,_ctx) ) {
			case 1:
				{
				_localctx = new PurePostfixContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(318);
				primary();
				}
				break;
			case 2:
				{
				_localctx = new FuncPostfixContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(319);
				match(Ident);
				setState(320);
				match(Lparen);
				setState(321);
				expressionList();
				setState(322);
				match(Rparen);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(333);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,30,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new ArrayPostfixContext(new PostfixContext(_parentctx, _parentState));
					pushNewRecursionContext(_localctx, _startState, RULE_postfix);
					setState(326);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(327);
					match(Lbrkt);
					setState(328);
					expression();
					setState(329);
					match(Rbrkt);
					}
					} 
				}
				setState(335);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,30,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class PrimaryContext extends ParserRuleContext {
		public PrimaryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_primary; }
	 
		public PrimaryContext() { }
		public void copyFrom(PrimaryContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class AtomIdentContext extends PrimaryContext {
		public TerminalNode Ident() { return getToken(MiniDecafParser.Ident, 0); }
		public AtomIdentContext(PrimaryContext ctx) { copyFrom(ctx); }
	}
	public static class AtomIntContext extends PrimaryContext {
		public TerminalNode Integer() { return getToken(MiniDecafParser.Integer, 0); }
		public AtomIntContext(PrimaryContext ctx) { copyFrom(ctx); }
	}
	public static class AtomParentContext extends PrimaryContext {
		public TerminalNode Lparen() { return getToken(MiniDecafParser.Lparen, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode Rparen() { return getToken(MiniDecafParser.Rparen, 0); }
		public AtomParentContext(PrimaryContext ctx) { copyFrom(ctx); }
	}

	public final PrimaryContext primary() throws RecognitionException {
		PrimaryContext _localctx = new PrimaryContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_primary);
		try {
			setState(342);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Integer:
				_localctx = new AtomIntContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(336);
				match(Integer);
				}
				break;
			case Lparen:
				_localctx = new AtomParentContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(337);
				match(Lparen);
				setState(338);
				expression();
				setState(339);
				match(Rparen);
				}
				break;
			case Ident:
				_localctx = new AtomIdentContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(341);
				match(Ident);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 5:
			return mtype_sempred((MtypeContext)_localctx, predIndex);
		case 12:
			return logical_or_sempred((Logical_orContext)_localctx, predIndex);
		case 13:
			return logical_and_sempred((Logical_andContext)_localctx, predIndex);
		case 14:
			return equality_sempred((EqualityContext)_localctx, predIndex);
		case 16:
			return relational_sempred((RelationalContext)_localctx, predIndex);
		case 18:
			return additive_sempred((AdditiveContext)_localctx, predIndex);
		case 20:
			return multiplicative_sempred((MultiplicativeContext)_localctx, predIndex);
		case 25:
			return postfix_sempred((PostfixContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean mtype_sempred(MtypeContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean logical_or_sempred(Logical_orContext _localctx, int predIndex) {
		switch (predIndex) {
		case 1:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean logical_and_sempred(Logical_andContext _localctx, int predIndex) {
		switch (predIndex) {
		case 2:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean equality_sempred(EqualityContext _localctx, int predIndex) {
		switch (predIndex) {
		case 3:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean relational_sempred(RelationalContext _localctx, int predIndex) {
		switch (predIndex) {
		case 4:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean additive_sempred(AdditiveContext _localctx, int predIndex) {
		switch (predIndex) {
		case 5:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean multiplicative_sempred(MultiplicativeContext _localctx, int predIndex) {
		switch (predIndex) {
		case 6:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean postfix_sempred(PostfixContext _localctx, int predIndex) {
		switch (predIndex) {
		case 7:
			return precpred(_ctx, 1);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3+\u015b\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\3\2\3\2\7\2;\n\2\f\2\16\2>\13\2\3\2\3\2"+
		"\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\5"+
		"\4S\n\4\3\5\3\5\3\5\7\5X\n\5\f\5\16\5[\13\5\5\5]\n\5\3\6\3\6\7\6a\n\6"+
		"\f\6\16\6d\13\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\7\7m\n\7\f\7\16\7p\13\7\3"+
		"\b\3\b\3\b\3\b\5\bv\n\b\3\t\3\t\3\t\3\t\3\t\5\t}\n\t\3\t\3\t\3\t\3\t\3"+
		"\t\3\t\3\t\3\t\5\t\u0087\n\t\3\t\3\t\3\t\3\t\5\t\u008d\n\t\3\t\3\t\5\t"+
		"\u0091\n\t\3\t\3\t\5\t\u0095\n\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\5\t\u009e"+
		"\n\t\3\t\3\t\5\t\u00a2\n\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t"+
		"\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\5\t\u00b9\n\t\3\n\3\n\3\n\3\n"+
		"\3\n\7\n\u00c0\n\n\f\n\16\n\u00c3\13\n\3\n\3\n\5\n\u00c7\n\n\3\13\3\13"+
		"\3\f\3\f\3\f\3\f\3\f\5\f\u00d0\n\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r\5\r\u00d9"+
		"\n\r\3\16\3\16\3\16\3\16\3\16\3\16\7\16\u00e1\n\16\f\16\16\16\u00e4\13"+
		"\16\3\17\3\17\3\17\3\17\3\17\3\17\7\17\u00ec\n\17\f\17\16\17\u00ef\13"+
		"\17\3\20\3\20\3\20\3\20\3\20\3\20\3\20\7\20\u00f8\n\20\f\20\16\20\u00fb"+
		"\13\20\3\21\3\21\3\22\3\22\3\22\3\22\3\22\3\22\3\22\7\22\u0106\n\22\f"+
		"\22\16\22\u0109\13\22\3\23\3\23\3\24\3\24\3\24\3\24\3\24\3\24\3\24\7\24"+
		"\u0114\n\24\f\24\16\24\u0117\13\24\3\25\3\25\3\26\3\26\3\26\3\26\3\26"+
		"\3\26\3\26\7\26\u0122\n\26\f\26\16\26\u0125\13\26\3\27\3\27\3\30\3\30"+
		"\3\30\7\30\u012c\n\30\f\30\16\30\u012f\13\30\5\30\u0131\n\30\3\31\3\31"+
		"\3\31\3\31\3\31\3\31\3\31\3\31\3\31\5\31\u013c\n\31\3\32\3\32\3\33\3\33"+
		"\3\33\3\33\3\33\3\33\3\33\5\33\u0147\n\33\3\33\3\33\3\33\3\33\3\33\7\33"+
		"\u014e\n\33\f\33\16\33\u0151\13\33\3\34\3\34\3\34\3\34\3\34\3\34\5\34"+
		"\u0159\n\34\3\34\2\n\f\32\34\36\"&*\64\35\2\4\6\b\n\f\16\20\22\24\26\30"+
		"\32\34\36 \"$&(*,.\60\62\64\66\2\7\3\2#$\3\2\37\"\3\2\27\30\3\2\31\33"+
		"\4\2\30\31\34\36\2\u0169\2<\3\2\2\2\4A\3\2\2\2\6R\3\2\2\2\b\\\3\2\2\2"+
		"\n^\3\2\2\2\fg\3\2\2\2\16u\3\2\2\2\20\u00b8\3\2\2\2\22\u00ba\3\2\2\2\24"+
		"\u00c8\3\2\2\2\26\u00cf\3\2\2\2\30\u00d8\3\2\2\2\32\u00da\3\2\2\2\34\u00e5"+
		"\3\2\2\2\36\u00f0\3\2\2\2 \u00fc\3\2\2\2\"\u00fe\3\2\2\2$\u010a\3\2\2"+
		"\2&\u010c\3\2\2\2(\u0118\3\2\2\2*\u011a\3\2\2\2,\u0126\3\2\2\2.\u0130"+
		"\3\2\2\2\60\u013b\3\2\2\2\62\u013d\3\2\2\2\64\u0146\3\2\2\2\66\u0158\3"+
		"\2\2\28;\5\6\4\29;\5\4\3\2:8\3\2\2\2:9\3\2\2\2;>\3\2\2\2<:\3\2\2\2<=\3"+
		"\2\2\2=?\3\2\2\2><\3\2\2\2?@\7\2\2\3@\3\3\2\2\2AB\5\22\n\2BC\7\25\2\2"+
		"C\5\3\2\2\2DE\5\f\7\2EF\7+\2\2FG\7\16\2\2GH\5\b\5\2HI\7\17\2\2IJ\5\n\6"+
		"\2JS\3\2\2\2KL\5\f\7\2LM\7+\2\2MN\7\16\2\2NO\5\b\5\2OP\7\17\2\2PQ\7\25"+
		"\2\2QS\3\2\2\2RD\3\2\2\2RK\3\2\2\2S\7\3\2\2\2TY\5\22\n\2UV\7\24\2\2VX"+
		"\5\22\n\2WU\3\2\2\2X[\3\2\2\2YW\3\2\2\2YZ\3\2\2\2Z]\3\2\2\2[Y\3\2\2\2"+
		"\\T\3\2\2\2\\]\3\2\2\2]\t\3\2\2\2^b\7\22\2\2_a\5\16\b\2`_\3\2\2\2ad\3"+
		"\2\2\2b`\3\2\2\2bc\3\2\2\2ce\3\2\2\2db\3\2\2\2ef\7\23\2\2f\13\3\2\2\2"+
		"gh\b\7\1\2hi\7\5\2\2in\3\2\2\2jk\f\3\2\2km\7\31\2\2lj\3\2\2\2mp\3\2\2"+
		"\2nl\3\2\2\2no\3\2\2\2o\r\3\2\2\2pn\3\2\2\2qv\5\20\t\2rs\5\22\n\2st\7"+
		"\25\2\2tv\3\2\2\2uq\3\2\2\2ur\3\2\2\2v\17\3\2\2\2wx\7\6\2\2xy\5\24\13"+
		"\2yz\7\25\2\2z\u00b9\3\2\2\2{}\5\24\13\2|{\3\2\2\2|}\3\2\2\2}~\3\2\2\2"+
		"~\u00b9\7\25\2\2\177\u0080\7\7\2\2\u0080\u0081\7\16\2\2\u0081\u0082\5"+
		"\24\13\2\u0082\u0083\7\17\2\2\u0083\u0086\5\20\t\2\u0084\u0085\7\b\2\2"+
		"\u0085\u0087\5\20\t\2\u0086\u0084\3\2\2\2\u0086\u0087\3\2\2\2\u0087\u00b9"+
		"\3\2\2\2\u0088\u00b9\5\n\6\2\u0089\u008a\7\t\2\2\u008a\u008c\7\16\2\2"+
		"\u008b\u008d\5\24\13\2\u008c\u008b\3\2\2\2\u008c\u008d\3\2\2\2\u008d\u008e"+
		"\3\2\2\2\u008e\u0090\7\25\2\2\u008f\u0091\5\24\13\2\u0090\u008f\3\2\2"+
		"\2\u0090\u0091\3\2\2\2\u0091\u0092\3\2\2\2\u0092\u0094\7\25\2\2\u0093"+
		"\u0095\5\24\13\2\u0094\u0093\3\2\2\2\u0094\u0095\3\2\2\2\u0095\u0096\3"+
		"\2\2\2\u0096\u0097\7\17\2\2\u0097\u00b9\5\20\t\2\u0098\u0099\7\t\2\2\u0099"+
		"\u009a\7\16\2\2\u009a\u009b\5\22\n\2\u009b\u009d\7\25\2\2\u009c\u009e"+
		"\5\24\13\2\u009d\u009c\3\2\2\2\u009d\u009e\3\2\2\2\u009e\u009f\3\2\2\2"+
		"\u009f\u00a1\7\25\2\2\u00a0\u00a2\5\24\13\2\u00a1\u00a0\3\2\2\2\u00a1"+
		"\u00a2\3\2\2\2\u00a2\u00a3\3\2\2\2\u00a3\u00a4\7\17\2\2\u00a4\u00a5\5"+
		"\20\t\2\u00a5\u00b9\3\2\2\2\u00a6\u00a7\7\13\2\2\u00a7\u00a8\7\16\2\2"+
		"\u00a8\u00a9\5\24\13\2\u00a9\u00aa\7\17\2\2\u00aa\u00ab\5\20\t\2\u00ab"+
		"\u00b9\3\2\2\2\u00ac\u00ad\7\n\2\2\u00ad\u00ae\5\20\t\2\u00ae\u00af\7"+
		"\13\2\2\u00af\u00b0\7\16\2\2\u00b0\u00b1\5\24\13\2\u00b1\u00b2\7\17\2"+
		"\2\u00b2\u00b3\7\25\2\2\u00b3\u00b9\3\2\2\2\u00b4\u00b5\7\f\2\2\u00b5"+
		"\u00b9\7\25\2\2\u00b6\u00b7\7\r\2\2\u00b7\u00b9\7\25\2\2\u00b8w\3\2\2"+
		"\2\u00b8|\3\2\2\2\u00b8\177\3\2\2\2\u00b8\u0088\3\2\2\2\u00b8\u0089\3"+
		"\2\2\2\u00b8\u0098\3\2\2\2\u00b8\u00a6\3\2\2\2\u00b8\u00ac\3\2\2\2\u00b8"+
		"\u00b4\3\2\2\2\u00b8\u00b6\3\2\2\2\u00b9\21\3\2\2\2\u00ba\u00bb\5\f\7"+
		"\2\u00bb\u00c1\7+\2\2\u00bc\u00bd\7\20\2\2\u00bd\u00be\7)\2\2\u00be\u00c0"+
		"\7\21\2\2\u00bf\u00bc\3\2\2\2\u00c0\u00c3\3\2\2\2\u00c1\u00bf\3\2\2\2"+
		"\u00c1\u00c2\3\2\2\2\u00c2\u00c6\3\2\2\2\u00c3\u00c1\3\2\2\2\u00c4\u00c5"+
		"\7%\2\2\u00c5\u00c7\5\24\13\2\u00c6\u00c4\3\2\2\2\u00c6\u00c7\3\2\2\2"+
		"\u00c7\23\3\2\2\2\u00c8\u00c9\5\26\f\2\u00c9\25\3\2\2\2\u00ca\u00d0\5"+
		"\30\r\2\u00cb\u00cc\5\60\31\2\u00cc\u00cd\7%\2\2\u00cd\u00ce\5\24\13\2"+
		"\u00ce\u00d0\3\2\2\2\u00cf\u00ca\3\2\2\2\u00cf\u00cb\3\2\2\2\u00d0\27"+
		"\3\2\2\2\u00d1\u00d9\5\32\16\2\u00d2\u00d3\5\32\16\2\u00d3\u00d4\7\3\2"+
		"\2\u00d4\u00d5\5\24\13\2\u00d5\u00d6\7\4\2\2\u00d6\u00d7\5\30\r\2\u00d7"+
		"\u00d9\3\2\2\2\u00d8\u00d1\3\2\2\2\u00d8\u00d2\3\2\2\2\u00d9\31\3\2\2"+
		"\2\u00da\u00db\b\16\1\2\u00db\u00dc\5\34\17\2\u00dc\u00e2\3\2\2\2\u00dd"+
		"\u00de\f\3\2\2\u00de\u00df\7\'\2\2\u00df\u00e1\5\34\17\2\u00e0\u00dd\3"+
		"\2\2\2\u00e1\u00e4\3\2\2\2\u00e2\u00e0\3\2\2\2\u00e2\u00e3\3\2\2\2\u00e3"+
		"\33\3\2\2\2\u00e4\u00e2\3\2\2\2\u00e5\u00e6\b\17\1\2\u00e6\u00e7\5\36"+
		"\20\2\u00e7\u00ed\3\2\2\2\u00e8\u00e9\f\3\2\2\u00e9\u00ea\7&\2\2\u00ea"+
		"\u00ec\5\36\20\2\u00eb\u00e8\3\2\2\2\u00ec\u00ef\3\2\2\2\u00ed\u00eb\3"+
		"\2\2\2\u00ed\u00ee\3\2\2\2\u00ee\35\3\2\2\2\u00ef\u00ed\3\2\2\2\u00f0"+
		"\u00f1\b\20\1\2\u00f1\u00f2\5\"\22\2\u00f2\u00f9\3\2\2\2\u00f3\u00f4\f"+
		"\3\2\2\u00f4\u00f5\5 \21\2\u00f5\u00f6\5\"\22\2\u00f6\u00f8\3\2\2\2\u00f7"+
		"\u00f3\3\2\2\2\u00f8\u00fb\3\2\2\2\u00f9\u00f7\3\2\2\2\u00f9\u00fa\3\2"+
		"\2\2\u00fa\37\3\2\2\2\u00fb\u00f9\3\2\2\2\u00fc\u00fd\t\2\2\2\u00fd!\3"+
		"\2\2\2\u00fe\u00ff\b\22\1\2\u00ff\u0100\5&\24\2\u0100\u0107\3\2\2\2\u0101"+
		"\u0102\f\3\2\2\u0102\u0103\5$\23\2\u0103\u0104\5&\24\2\u0104\u0106\3\2"+
		"\2\2\u0105\u0101\3\2\2\2\u0106\u0109\3\2\2\2\u0107\u0105\3\2\2\2\u0107"+
		"\u0108\3\2\2\2\u0108#\3\2\2\2\u0109\u0107\3\2\2\2\u010a\u010b\t\3\2\2"+
		"\u010b%\3\2\2\2\u010c\u010d\b\24\1\2\u010d\u010e\5*\26\2\u010e\u0115\3"+
		"\2\2\2\u010f\u0110\f\3\2\2\u0110\u0111\5(\25\2\u0111\u0112\5*\26\2\u0112"+
		"\u0114\3\2\2\2\u0113\u010f\3\2\2\2\u0114\u0117\3\2\2\2\u0115\u0113\3\2"+
		"\2\2\u0115\u0116\3\2\2\2\u0116\'\3\2\2\2\u0117\u0115\3\2\2\2\u0118\u0119"+
		"\t\4\2\2\u0119)\3\2\2\2\u011a\u011b\b\26\1\2\u011b\u011c\5\60\31\2\u011c"+
		"\u0123\3\2\2\2\u011d\u011e\f\3\2\2\u011e\u011f\5,\27\2\u011f\u0120\5\60"+
		"\31\2\u0120\u0122\3\2\2\2\u0121\u011d\3\2\2\2\u0122\u0125\3\2\2\2\u0123"+
		"\u0121\3\2\2\2\u0123\u0124\3\2\2\2\u0124+\3\2\2\2\u0125\u0123\3\2\2\2"+
		"\u0126\u0127\t\5\2\2\u0127-\3\2\2\2\u0128\u012d\5\24\13\2\u0129\u012a"+
		"\7\24\2\2\u012a\u012c\5\24\13\2\u012b\u0129\3\2\2\2\u012c\u012f\3\2\2"+
		"\2\u012d\u012b\3\2\2\2\u012d\u012e\3\2\2\2\u012e\u0131\3\2\2\2\u012f\u012d"+
		"\3\2\2\2\u0130\u0128\3\2\2\2\u0130\u0131\3\2\2\2\u0131/\3\2\2\2\u0132"+
		"\u013c\5\64\33\2\u0133\u0134\5\62\32\2\u0134\u0135\5\60\31\2\u0135\u013c"+
		"\3\2\2\2\u0136\u0137\7\16\2\2\u0137\u0138\5\f\7\2\u0138\u0139\7\17\2\2"+
		"\u0139\u013a\5\60\31\2\u013a\u013c\3\2\2\2\u013b\u0132\3\2\2\2\u013b\u0133"+
		"\3\2\2\2\u013b\u0136\3\2\2\2\u013c\61\3\2\2\2\u013d\u013e\t\6\2\2\u013e"+
		"\63\3\2\2\2\u013f\u0140\b\33\1\2\u0140\u0147\5\66\34\2\u0141\u0142\7+"+
		"\2\2\u0142\u0143\7\16\2\2\u0143\u0144\5.\30\2\u0144\u0145\7\17\2\2\u0145"+
		"\u0147\3\2\2\2\u0146\u013f\3\2\2\2\u0146\u0141\3\2\2\2\u0147\u014f\3\2"+
		"\2\2\u0148\u0149\f\3\2\2\u0149\u014a\7\20\2\2\u014a\u014b\5\24\13\2\u014b"+
		"\u014c\7\21\2\2\u014c\u014e\3\2\2\2\u014d\u0148\3\2\2\2\u014e\u0151\3"+
		"\2\2\2\u014f\u014d\3\2\2\2\u014f\u0150\3\2\2\2\u0150\65\3\2\2\2\u0151"+
		"\u014f\3\2\2\2\u0152\u0159\7)\2\2\u0153\u0154\7\16\2\2\u0154\u0155\5\24"+
		"\13\2\u0155\u0156\7\17\2\2\u0156\u0159\3\2\2\2\u0157\u0159\7+\2\2\u0158"+
		"\u0152\3\2\2\2\u0158\u0153\3\2\2\2\u0158\u0157\3\2\2\2\u0159\67\3\2\2"+
		"\2\":<RY\\bnu|\u0086\u008c\u0090\u0094\u009d\u00a1\u00b8\u00c1\u00c6\u00cf"+
		"\u00d8\u00e2\u00ed\u00f9\u0107\u0115\u0123\u012d\u0130\u013b\u0146\u014f"+
		"\u0158";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}