// Generated from E:\lijz\javamonkey\bee\research\antlrworks2\projects\beetl\BeetlParser.g4 by ANTLR 4.1
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class BeetlParser extends Parser {
	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		Switch=5, OctalLiteral=48, MOD=27, CharacterLiteral=50, INCREASE=20, While=4, 
		NOT=33, Case=12, AND=34, RIGHT_SQBR=19, DECREASE=21, Identifier=52, PARA=54, 
		Default=13, AT=37, NOT_EQUAL=29, COMMA=42, EQUAL=28, LESS=32, LEFT_PAR=16, 
		Select=6, MUlTIP=25, Return=7, VIRTUAL=22, If=1, LEFT_SQBR=18, ADD=23, 
		RIGHT_BRACE=15, HexLiteral=46, QUESTOIN=36, Continue=9, LINE_COMMENT=58, 
		PERIOD=44, NULL=38, ASSIN=30, COMMENT_OPEN=53, MIN=24, Directive=11, DecimalLiteral=47, 
		For=2, TRUE=39, StringLiteral=51, COLON=43, WS=57, COMMENT_END=56, Break=8, 
		FOR_IN=45, LEFT_BRACE=14, WS1=55, FloatingPointLiteral=49, RIGHT_PAR=17, 
		OR=35, LARGE=31, DIV=26, END=41, Else=3, FALSE=40, Var=10;
	public static final String[] tokenNames = {
		"<INVALID>", "'if'", "'for'", "'else'", "'while'", "'switch'", "'select'", 
		"'return'", "'break'", "'continue'", "'var'", "Directive", "'case'", "'default'", 
		"'{'", "'}'", "'('", "')'", "'['", "']'", "'++'", "'--'", "'.~'", "'+'", 
		"'-'", "'*'", "'/'", "'%'", "'=='", "'!='", "'='", "'>'", "'<'", "'!'", 
		"'&&'", "'||'", "'?'", "'@'", "'null'", "'true'", "'false'", "';'", "','", 
		"':'", "'.'", "'in'", "HexLiteral", "DecimalLiteral", "OctalLiteral", 
		"FloatingPointLiteral", "CharacterLiteral", "StringLiteral", "Identifier", 
		"'/*'", "PARA", "WS1", "'*/'", "WS", "LINE_COMMENT"
	};
	public static final int
		RULE_prog = 0, RULE_comment = 1, RULE_block = 2, RULE_statement = 3, RULE_directiveExp = 4, 
		RULE_g_switchStatment = 5, RULE_g_caseStatment = 6, RULE_g_defaultStatment = 7, 
		RULE_varDeclareList = 8, RULE_assignMent = 9, RULE_switchBlock = 10, RULE_switchBlockStatementGroup = 11, 
		RULE_switchLabel = 12, RULE_forControl = 13, RULE_parExpression = 14, 
		RULE_expressionList = 15, RULE_statementExpression = 16, RULE_constantExpression = 17, 
		RULE_expression = 18, RULE_varRef = 19, RULE_varAttribute = 20, RULE_functionCall = 21, 
		RULE_functionTagCall = 22, RULE_functionNs = 23, RULE_nativeCall = 24, 
		RULE_nativeMethod = 25, RULE_nativeArray = 26, RULE_nativeVarRefChain = 27, 
		RULE_literal = 28, RULE_integerLiteral = 29, RULE_booleanLiteral = 30, 
		RULE_arguments = 31;
	public static final String[] ruleNames = {
		"prog", "comment", "block", "statement", "directiveExp", "g_switchStatment", 
		"g_caseStatment", "g_defaultStatment", "varDeclareList", "assignMent", 
		"switchBlock", "switchBlockStatementGroup", "switchLabel", "forControl", 
		"parExpression", "expressionList", "statementExpression", "constantExpression", 
		"expression", "varRef", "varAttribute", "functionCall", "functionTagCall", 
		"functionNs", "nativeCall", "nativeMethod", "nativeArray", "nativeVarRefChain", 
		"literal", "integerLiteral", "booleanLiteral", "arguments"
	};

	@Override
	public String getGrammarFileName() { return "BeetlParser.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public BeetlParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class ProgContext extends ParserRuleContext {
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public CommentContext comment() {
			return getRuleContext(CommentContext.class,0);
		}
		public TerminalNode EOF() { return getToken(BeetlParser.EOF, 0); }
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public ProgContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prog; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BeetlParserListener ) ((BeetlParserListener)listener).enterProg(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BeetlParserListener ) ((BeetlParserListener)listener).exitProg(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BeetlParserVisitor ) return ((BeetlParserVisitor<? extends T>)visitor).visitProg(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgContext prog() throws RecognitionException {
		ProgContext _localctx = new ProgContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_prog);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(65);
			switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
			case 1:
				{
				setState(64); comment();
				}
				break;
			}
			setState(70);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << If) | (1L << For) | (1L << While) | (1L << Switch) | (1L << Select) | (1L << Return) | (1L << Break) | (1L << Continue) | (1L << Var) | (1L << Directive) | (1L << LEFT_BRACE) | (1L << LEFT_PAR) | (1L << INCREASE) | (1L << DECREASE) | (1L << ADD) | (1L << MIN) | (1L << NOT) | (1L << AT) | (1L << NULL) | (1L << TRUE) | (1L << FALSE) | (1L << HexLiteral) | (1L << DecimalLiteral) | (1L << OctalLiteral) | (1L << FloatingPointLiteral) | (1L << CharacterLiteral) | (1L << StringLiteral) | (1L << Identifier) | (1L << COMMENT_OPEN))) != 0)) {
				{
				{
				setState(67); statement();
				}
				}
				setState(72);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(73); match(EOF);
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

	public static class CommentContext extends ParserRuleContext {
		public TerminalNode COMMENT_OPEN() { return getToken(BeetlParser.COMMENT_OPEN, 0); }
		public TerminalNode COMMENT_END() { return getToken(BeetlParser.COMMENT_END, 0); }
		public TerminalNode PARA(int i) {
			return getToken(BeetlParser.PARA, i);
		}
		public List<TerminalNode> PARA() { return getTokens(BeetlParser.PARA); }
		public CommentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_comment; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BeetlParserListener ) ((BeetlParserListener)listener).enterComment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BeetlParserListener ) ((BeetlParserListener)listener).exitComment(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BeetlParserVisitor ) return ((BeetlParserVisitor<? extends T>)visitor).visitComment(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CommentContext comment() throws RecognitionException {
		CommentContext _localctx = new CommentContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_comment);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(75); match(COMMENT_OPEN);
			setState(79);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==PARA) {
				{
				{
				setState(76); match(PARA);
				}
				}
				setState(81);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(82); match(COMMENT_END);
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

	public static class BlockContext extends ParserRuleContext {
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public TerminalNode RIGHT_BRACE() { return getToken(BeetlParser.RIGHT_BRACE, 0); }
		public TerminalNode LEFT_BRACE() { return getToken(BeetlParser.LEFT_BRACE, 0); }
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public BlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_block; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BeetlParserListener ) ((BeetlParserListener)listener).enterBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BeetlParserListener ) ((BeetlParserListener)listener).exitBlock(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BeetlParserVisitor ) return ((BeetlParserVisitor<? extends T>)visitor).visitBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BlockContext block() throws RecognitionException {
		BlockContext _localctx = new BlockContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(84); match(LEFT_BRACE);
			setState(88);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << If) | (1L << For) | (1L << While) | (1L << Switch) | (1L << Select) | (1L << Return) | (1L << Break) | (1L << Continue) | (1L << Var) | (1L << Directive) | (1L << LEFT_BRACE) | (1L << LEFT_PAR) | (1L << INCREASE) | (1L << DECREASE) | (1L << ADD) | (1L << MIN) | (1L << NOT) | (1L << AT) | (1L << NULL) | (1L << TRUE) | (1L << FALSE) | (1L << HexLiteral) | (1L << DecimalLiteral) | (1L << OctalLiteral) | (1L << FloatingPointLiteral) | (1L << CharacterLiteral) | (1L << StringLiteral) | (1L << Identifier) | (1L << COMMENT_OPEN))) != 0)) {
				{
				{
				setState(85); statement();
				}
				}
				setState(90);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(91); match(RIGHT_BRACE);
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
		public TerminalNode While() { return getToken(BeetlParser.While, 0); }
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public TerminalNode RIGHT_PAR() { return getToken(BeetlParser.RIGHT_PAR, 0); }
		public FunctionTagCallContext functionTagCall() {
			return getRuleContext(FunctionTagCallContext.class,0);
		}
		public TerminalNode Else() { return getToken(BeetlParser.Else, 0); }
		public TerminalNode If() { return getToken(BeetlParser.If, 0); }
		public TerminalNode Switch() { return getToken(BeetlParser.Switch, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode Directive() { return getToken(BeetlParser.Directive, 0); }
		public TerminalNode For() { return getToken(BeetlParser.For, 0); }
		public CommentContext comment() {
			return getRuleContext(CommentContext.class,0);
		}
		public TerminalNode LEFT_PAR() { return getToken(BeetlParser.LEFT_PAR, 0); }
		public G_switchStatmentContext g_switchStatment() {
			return getRuleContext(G_switchStatmentContext.class,0);
		}
		public TerminalNode Select() { return getToken(BeetlParser.Select, 0); }
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public TerminalNode Return() { return getToken(BeetlParser.Return, 0); }
		public ForControlContext forControl() {
			return getRuleContext(ForControlContext.class,0);
		}
		public ParExpressionContext parExpression() {
			return getRuleContext(ParExpressionContext.class,0);
		}
		public SwitchBlockContext switchBlock() {
			return getRuleContext(SwitchBlockContext.class,0);
		}
		public TerminalNode Var() { return getToken(BeetlParser.Var, 0); }
		public DirectiveExpContext directiveExp() {
			return getRuleContext(DirectiveExpContext.class,0);
		}
		public VarDeclareListContext varDeclareList() {
			return getRuleContext(VarDeclareListContext.class,0);
		}
		public StatementExpressionContext statementExpression() {
			return getRuleContext(StatementExpressionContext.class,0);
		}
		public TerminalNode Continue() { return getToken(BeetlParser.Continue, 0); }
		public TerminalNode Break() { return getToken(BeetlParser.Break, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public AssignMentContext assignMent() {
			return getRuleContext(AssignMentContext.class,0);
		}
		public TerminalNode END() { return getToken(BeetlParser.END, 0); }
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BeetlParserListener ) ((BeetlParserListener)listener).enterStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BeetlParserListener ) ((BeetlParserListener)listener).exitStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BeetlParserVisitor ) return ((BeetlParserVisitor<? extends T>)visitor).visitStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_statement);
		int _la;
		try {
			setState(140);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(93); block();
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(94); comment();
				}
				break;

			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(95); match(If);
				setState(96); parExpression();
				setState(97); statement();
				setState(100);
				switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
				case 1:
					{
					setState(98); match(Else);
					setState(99); statement();
					}
					break;
				}
				}
				break;

			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(102); match(For);
				setState(103); match(LEFT_PAR);
				setState(104); forControl();
				setState(105); match(RIGHT_PAR);
				setState(106); statement();
				}
				break;

			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(108); match(While);
				setState(109); parExpression();
				setState(110); statement();
				}
				break;

			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(112); match(Switch);
				setState(113); parExpression();
				setState(114); switchBlock();
				}
				break;

			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(116); match(Select);
				setState(117); g_switchStatment();
				}
				break;

			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(118); match(Return);
				setState(120);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LEFT_PAR) | (1L << INCREASE) | (1L << DECREASE) | (1L << ADD) | (1L << MIN) | (1L << NOT) | (1L << AT) | (1L << NULL) | (1L << TRUE) | (1L << FALSE) | (1L << HexLiteral) | (1L << DecimalLiteral) | (1L << OctalLiteral) | (1L << FloatingPointLiteral) | (1L << CharacterLiteral) | (1L << StringLiteral) | (1L << Identifier))) != 0)) {
					{
					setState(119); expression(0);
					}
				}

				setState(122); match(END);
				}
				break;

			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(123); match(Break);
				setState(124); match(END);
				}
				break;

			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(125); match(Continue);
				setState(126); match(END);
				}
				break;

			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(127); match(Var);
				setState(128); varDeclareList();
				setState(129); match(END);
				}
				break;

			case 12:
				enterOuterAlt(_localctx, 12);
				{
				setState(131); match(Directive);
				setState(132); directiveExp();
				}
				break;

			case 13:
				enterOuterAlt(_localctx, 13);
				{
				setState(133); assignMent();
				setState(134); match(END);
				}
				break;

			case 14:
				enterOuterAlt(_localctx, 14);
				{
				setState(136); functionTagCall();
				}
				break;

			case 15:
				enterOuterAlt(_localctx, 15);
				{
				setState(137); statementExpression();
				setState(138); match(END);
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

	public static class DirectiveExpContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(BeetlParser.Identifier, 0); }
		public TerminalNode StringLiteral() { return getToken(BeetlParser.StringLiteral, 0); }
		public TerminalNode END() { return getToken(BeetlParser.END, 0); }
		public DirectiveExpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_directiveExp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BeetlParserListener ) ((BeetlParserListener)listener).enterDirectiveExp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BeetlParserListener ) ((BeetlParserListener)listener).exitDirectiveExp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BeetlParserVisitor ) return ((BeetlParserVisitor<? extends T>)visitor).visitDirectiveExp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DirectiveExpContext directiveExp() throws RecognitionException {
		DirectiveExpContext _localctx = new DirectiveExpContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_directiveExp);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(142); match(Identifier);
			setState(144);
			_la = _input.LA(1);
			if (_la==StringLiteral) {
				{
				setState(143); match(StringLiteral);
				}
			}

			setState(146); match(END);
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

	public static class G_switchStatmentContext extends ParserRuleContext {
		public ExpressionContext base;
		public TerminalNode RIGHT_PAR() { return getToken(BeetlParser.RIGHT_PAR, 0); }
		public TerminalNode LEFT_PAR() { return getToken(BeetlParser.LEFT_PAR, 0); }
		public TerminalNode RIGHT_BRACE() { return getToken(BeetlParser.RIGHT_BRACE, 0); }
		public G_caseStatmentContext g_caseStatment(int i) {
			return getRuleContext(G_caseStatmentContext.class,i);
		}
		public List<G_caseStatmentContext> g_caseStatment() {
			return getRuleContexts(G_caseStatmentContext.class);
		}
		public G_defaultStatmentContext g_defaultStatment() {
			return getRuleContext(G_defaultStatmentContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode LEFT_BRACE() { return getToken(BeetlParser.LEFT_BRACE, 0); }
		public G_switchStatmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_g_switchStatment; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BeetlParserListener ) ((BeetlParserListener)listener).enterG_switchStatment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BeetlParserListener ) ((BeetlParserListener)listener).exitG_switchStatment(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BeetlParserVisitor ) return ((BeetlParserVisitor<? extends T>)visitor).visitG_switchStatment(this);
			else return visitor.visitChildren(this);
		}
	}

	public final G_switchStatmentContext g_switchStatment() throws RecognitionException {
		G_switchStatmentContext _localctx = new G_switchStatmentContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_g_switchStatment);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(152);
			_la = _input.LA(1);
			if (_la==LEFT_PAR) {
				{
				setState(148); match(LEFT_PAR);
				setState(149); ((G_switchStatmentContext)_localctx).base = expression(0);
				setState(150); match(RIGHT_PAR);
				}
			}

			setState(154); match(LEFT_BRACE);
			setState(158);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Case) {
				{
				{
				setState(155); g_caseStatment();
				}
				}
				setState(160);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(162);
			_la = _input.LA(1);
			if (_la==Default) {
				{
				setState(161); g_defaultStatment();
				}
			}

			setState(164); match(RIGHT_BRACE);
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

	public static class G_caseStatmentContext extends ParserRuleContext {
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode Case() { return getToken(BeetlParser.Case, 0); }
		public List<TerminalNode> COMMA() { return getTokens(BeetlParser.COMMA); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public TerminalNode COLON() { return getToken(BeetlParser.COLON, 0); }
		public TerminalNode COMMA(int i) {
			return getToken(BeetlParser.COMMA, i);
		}
		public G_caseStatmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_g_caseStatment; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BeetlParserListener ) ((BeetlParserListener)listener).enterG_caseStatment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BeetlParserListener ) ((BeetlParserListener)listener).exitG_caseStatment(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BeetlParserVisitor ) return ((BeetlParserVisitor<? extends T>)visitor).visitG_caseStatment(this);
			else return visitor.visitChildren(this);
		}
	}

	public final G_caseStatmentContext g_caseStatment() throws RecognitionException {
		G_caseStatmentContext _localctx = new G_caseStatmentContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_g_caseStatment);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(166); match(Case);
			setState(167); expression(0);
			setState(172);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(168); match(COMMA);
				setState(169); expression(0);
				}
				}
				setState(174);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(175); match(COLON);
			setState(176); statement();
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

	public static class G_defaultStatmentContext extends ParserRuleContext {
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public TerminalNode Default() { return getToken(BeetlParser.Default, 0); }
		public TerminalNode COLON() { return getToken(BeetlParser.COLON, 0); }
		public G_defaultStatmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_g_defaultStatment; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BeetlParserListener ) ((BeetlParserListener)listener).enterG_defaultStatment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BeetlParserListener ) ((BeetlParserListener)listener).exitG_defaultStatment(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BeetlParserVisitor ) return ((BeetlParserVisitor<? extends T>)visitor).visitG_defaultStatment(this);
			else return visitor.visitChildren(this);
		}
	}

	public final G_defaultStatmentContext g_defaultStatment() throws RecognitionException {
		G_defaultStatmentContext _localctx = new G_defaultStatmentContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_g_defaultStatment);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(178); match(Default);
			setState(179); match(COLON);
			setState(180); statement();
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

	public static class VarDeclareListContext extends ParserRuleContext {
		public List<TerminalNode> COMMA() { return getTokens(BeetlParser.COMMA); }
		public AssignMentContext assignMent(int i) {
			return getRuleContext(AssignMentContext.class,i);
		}
		public List<AssignMentContext> assignMent() {
			return getRuleContexts(AssignMentContext.class);
		}
		public TerminalNode COMMA(int i) {
			return getToken(BeetlParser.COMMA, i);
		}
		public VarDeclareListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varDeclareList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BeetlParserListener ) ((BeetlParserListener)listener).enterVarDeclareList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BeetlParserListener ) ((BeetlParserListener)listener).exitVarDeclareList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BeetlParserVisitor ) return ((BeetlParserVisitor<? extends T>)visitor).visitVarDeclareList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VarDeclareListContext varDeclareList() throws RecognitionException {
		VarDeclareListContext _localctx = new VarDeclareListContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_varDeclareList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(182); assignMent();
			setState(187);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(183); match(COMMA);
				setState(184); assignMent();
				}
				}
				setState(189);
				_errHandler.sync(this);
				_la = _input.LA(1);
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

	public static class AssignMentContext extends ParserRuleContext {
		public TerminalNode ASSIN() { return getToken(BeetlParser.ASSIN, 0); }
		public TerminalNode Identifier() { return getToken(BeetlParser.Identifier, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public AssignMentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignMent; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BeetlParserListener ) ((BeetlParserListener)listener).enterAssignMent(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BeetlParserListener ) ((BeetlParserListener)listener).exitAssignMent(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BeetlParserVisitor ) return ((BeetlParserVisitor<? extends T>)visitor).visitAssignMent(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssignMentContext assignMent() throws RecognitionException {
		AssignMentContext _localctx = new AssignMentContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_assignMent);
		try {
			setState(197);
			switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(190); match(Identifier);
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(191); match(Identifier);
				setState(192); match(ASSIN);
				setState(193); expression(0);
				}
				break;

			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(194); match(Identifier);
				setState(195); match(ASSIN);
				setState(196); block();
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

	public static class SwitchBlockContext extends ParserRuleContext {
		public SwitchLabelContext switchLabel(int i) {
			return getRuleContext(SwitchLabelContext.class,i);
		}
		public SwitchBlockStatementGroupContext switchBlockStatementGroup(int i) {
			return getRuleContext(SwitchBlockStatementGroupContext.class,i);
		}
		public TerminalNode RIGHT_BRACE() { return getToken(BeetlParser.RIGHT_BRACE, 0); }
		public List<SwitchLabelContext> switchLabel() {
			return getRuleContexts(SwitchLabelContext.class);
		}
		public TerminalNode LEFT_BRACE() { return getToken(BeetlParser.LEFT_BRACE, 0); }
		public List<SwitchBlockStatementGroupContext> switchBlockStatementGroup() {
			return getRuleContexts(SwitchBlockStatementGroupContext.class);
		}
		public SwitchBlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_switchBlock; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BeetlParserListener ) ((BeetlParserListener)listener).enterSwitchBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BeetlParserListener ) ((BeetlParserListener)listener).exitSwitchBlock(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BeetlParserVisitor ) return ((BeetlParserVisitor<? extends T>)visitor).visitSwitchBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SwitchBlockContext switchBlock() throws RecognitionException {
		SwitchBlockContext _localctx = new SwitchBlockContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_switchBlock);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(199); match(LEFT_BRACE);
			setState(203);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					{
					{
					setState(200); switchBlockStatementGroup();
					}
					} 
				}
				setState(205);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
			}
			setState(209);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Case || _la==Default) {
				{
				{
				setState(206); switchLabel();
				}
				}
				setState(211);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(212); match(RIGHT_BRACE);
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

	public static class SwitchBlockStatementGroupContext extends ParserRuleContext {
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public SwitchLabelContext switchLabel(int i) {
			return getRuleContext(SwitchLabelContext.class,i);
		}
		public List<SwitchLabelContext> switchLabel() {
			return getRuleContexts(SwitchLabelContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public SwitchBlockStatementGroupContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_switchBlockStatementGroup; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BeetlParserListener ) ((BeetlParserListener)listener).enterSwitchBlockStatementGroup(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BeetlParserListener ) ((BeetlParserListener)listener).exitSwitchBlockStatementGroup(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BeetlParserVisitor ) return ((BeetlParserVisitor<? extends T>)visitor).visitSwitchBlockStatementGroup(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SwitchBlockStatementGroupContext switchBlockStatementGroup() throws RecognitionException {
		SwitchBlockStatementGroupContext _localctx = new SwitchBlockStatementGroupContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_switchBlockStatementGroup);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(215); 
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(214); switchLabel();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(217); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
			} while ( _alt!=2 && _alt!=-1 );
			setState(222);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << If) | (1L << For) | (1L << While) | (1L << Switch) | (1L << Select) | (1L << Return) | (1L << Break) | (1L << Continue) | (1L << Var) | (1L << Directive) | (1L << LEFT_BRACE) | (1L << LEFT_PAR) | (1L << INCREASE) | (1L << DECREASE) | (1L << ADD) | (1L << MIN) | (1L << NOT) | (1L << AT) | (1L << NULL) | (1L << TRUE) | (1L << FALSE) | (1L << HexLiteral) | (1L << DecimalLiteral) | (1L << OctalLiteral) | (1L << FloatingPointLiteral) | (1L << CharacterLiteral) | (1L << StringLiteral) | (1L << Identifier) | (1L << COMMENT_OPEN))) != 0)) {
				{
				{
				setState(219); statement();
				}
				}
				setState(224);
				_errHandler.sync(this);
				_la = _input.LA(1);
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

	public static class SwitchLabelContext extends ParserRuleContext {
		public TerminalNode Default() { return getToken(BeetlParser.Default, 0); }
		public TerminalNode Case() { return getToken(BeetlParser.Case, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode COLON() { return getToken(BeetlParser.COLON, 0); }
		public SwitchLabelContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_switchLabel; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BeetlParserListener ) ((BeetlParserListener)listener).enterSwitchLabel(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BeetlParserListener ) ((BeetlParserListener)listener).exitSwitchLabel(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BeetlParserVisitor ) return ((BeetlParserVisitor<? extends T>)visitor).visitSwitchLabel(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SwitchLabelContext switchLabel() throws RecognitionException {
		SwitchLabelContext _localctx = new SwitchLabelContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_switchLabel);
		try {
			setState(231);
			switch (_input.LA(1)) {
			case Case:
				enterOuterAlt(_localctx, 1);
				{
				setState(225); match(Case);
				setState(226); expression(0);
				setState(227); match(COLON);
				}
				break;
			case Default:
				enterOuterAlt(_localctx, 2);
				{
				setState(229); match(Default);
				setState(230); match(COLON);
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

	public static class ForControlContext extends ParserRuleContext {
		public TerminalNode FOR_IN() { return getToken(BeetlParser.FOR_IN, 0); }
		public TerminalNode Identifier() { return getToken(BeetlParser.Identifier, 0); }
		public TerminalNode Var() { return getToken(BeetlParser.Var, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ForControlContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forControl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BeetlParserListener ) ((BeetlParserListener)listener).enterForControl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BeetlParserListener ) ((BeetlParserListener)listener).exitForControl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BeetlParserVisitor ) return ((BeetlParserVisitor<? extends T>)visitor).visitForControl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ForControlContext forControl() throws RecognitionException {
		ForControlContext _localctx = new ForControlContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_forControl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(234);
			_la = _input.LA(1);
			if (_la==Var) {
				{
				setState(233); match(Var);
				}
			}

			setState(236); match(Identifier);
			setState(237); match(FOR_IN);
			setState(238); expression(0);
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

	public static class ParExpressionContext extends ParserRuleContext {
		public TerminalNode RIGHT_PAR() { return getToken(BeetlParser.RIGHT_PAR, 0); }
		public TerminalNode LEFT_PAR() { return getToken(BeetlParser.LEFT_PAR, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ParExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BeetlParserListener ) ((BeetlParserListener)listener).enterParExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BeetlParserListener ) ((BeetlParserListener)listener).exitParExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BeetlParserVisitor ) return ((BeetlParserVisitor<? extends T>)visitor).visitParExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParExpressionContext parExpression() throws RecognitionException {
		ParExpressionContext _localctx = new ParExpressionContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_parExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(240); match(LEFT_PAR);
			setState(241); expression(0);
			setState(242); match(RIGHT_PAR);
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
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(BeetlParser.COMMA); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public TerminalNode COMMA(int i) {
			return getToken(BeetlParser.COMMA, i);
		}
		public ExpressionListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expressionList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BeetlParserListener ) ((BeetlParserListener)listener).enterExpressionList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BeetlParserListener ) ((BeetlParserListener)listener).exitExpressionList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BeetlParserVisitor ) return ((BeetlParserVisitor<? extends T>)visitor).visitExpressionList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionListContext expressionList() throws RecognitionException {
		ExpressionListContext _localctx = new ExpressionListContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_expressionList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(244); expression(0);
			setState(249);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(245); match(COMMA);
				setState(246); expression(0);
				}
				}
				setState(251);
				_errHandler.sync(this);
				_la = _input.LA(1);
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

	public static class StatementExpressionContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public StatementExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statementExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BeetlParserListener ) ((BeetlParserListener)listener).enterStatementExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BeetlParserListener ) ((BeetlParserListener)listener).exitStatementExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BeetlParserVisitor ) return ((BeetlParserVisitor<? extends T>)visitor).visitStatementExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementExpressionContext statementExpression() throws RecognitionException {
		StatementExpressionContext _localctx = new StatementExpressionContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_statementExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(252); expression(0);
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

	public static class ConstantExpressionContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ConstantExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constantExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BeetlParserListener ) ((BeetlParserListener)listener).enterConstantExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BeetlParserListener ) ((BeetlParserListener)listener).exitConstantExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BeetlParserVisitor ) return ((BeetlParserVisitor<? extends T>)visitor).visitConstantExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConstantExpressionContext constantExpression() throws RecognitionException {
		ConstantExpressionContext _localctx = new ConstantExpressionContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_constantExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(254); expression(0);
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
		public int _p;
		public TerminalNode RIGHT_PAR() { return getToken(BeetlParser.RIGHT_PAR, 0); }
		public TerminalNode ASSIN() { return getToken(BeetlParser.ASSIN, 0); }
		public VarRefContext varRef() {
			return getRuleContext(VarRefContext.class,0);
		}
		public TerminalNode DECREASE() { return getToken(BeetlParser.DECREASE, 0); }
		public TerminalNode AND() { return getToken(BeetlParser.AND, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public TerminalNode NOT_EQUAL() { return getToken(BeetlParser.NOT_EQUAL, 0); }
		public TerminalNode ADD() { return getToken(BeetlParser.ADD, 0); }
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode LEFT_PAR() { return getToken(BeetlParser.LEFT_PAR, 0); }
		public FunctionCallContext functionCall() {
			return getRuleContext(FunctionCallContext.class,0);
		}
		public TerminalNode LESS() { return getToken(BeetlParser.LESS, 0); }
		public TerminalNode QUESTOIN() { return getToken(BeetlParser.QUESTOIN, 0); }
		public LiteralContext literal() {
			return getRuleContext(LiteralContext.class,0);
		}
		public NativeCallContext nativeCall() {
			return getRuleContext(NativeCallContext.class,0);
		}
		public TerminalNode LARGE() { return getToken(BeetlParser.LARGE, 0); }
		public TerminalNode OR() { return getToken(BeetlParser.OR, 0); }
		public TerminalNode MIN() { return getToken(BeetlParser.MIN, 0); }
		public TerminalNode EQUAL() { return getToken(BeetlParser.EQUAL, 0); }
		public TerminalNode AT() { return getToken(BeetlParser.AT, 0); }
		public TerminalNode MUlTIP() { return getToken(BeetlParser.MUlTIP, 0); }
		public TerminalNode DIV() { return getToken(BeetlParser.DIV, 0); }
		public TerminalNode INCREASE() { return getToken(BeetlParser.INCREASE, 0); }
		public TerminalNode NOT() { return getToken(BeetlParser.NOT, 0); }
		public TerminalNode COLON() { return getToken(BeetlParser.COLON, 0); }
		public TerminalNode MOD() { return getToken(BeetlParser.MOD, 0); }
		public ExpressionContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public ExpressionContext(ParserRuleContext parent, int invokingState, int _p) {
			super(parent, invokingState);
			this._p = _p;
		}
		@Override public int getRuleIndex() { return RULE_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BeetlParserListener ) ((BeetlParserListener)listener).enterExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BeetlParserListener ) ((BeetlParserListener)listener).exitExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BeetlParserVisitor ) return ((BeetlParserVisitor<? extends T>)visitor).visitExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionContext expression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpressionContext _localctx = new ExpressionContext(_ctx, _parentState, _p);
		ExpressionContext _prevctx = _localctx;
		int _startState = 36;
		enterRecursionRule(_localctx, RULE_expression);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(272);
			switch ( getInterpreter().adaptivePredict(_input,21,_ctx) ) {
			case 1:
				{
				setState(257);
				_la = _input.LA(1);
				if ( !(_la==ADD || _la==MIN) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				setState(258); expression(12);
				}
				break;

			case 2:
				{
				setState(259);
				_la = _input.LA(1);
				if ( !(_la==INCREASE || _la==DECREASE) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				setState(260); expression(11);
				}
				break;

			case 3:
				{
				setState(261); match(NOT);
				setState(262); expression(10);
				}
				break;

			case 4:
				{
				setState(263); literal();
				}
				break;

			case 5:
				{
				setState(264); match(AT);
				setState(265); nativeCall();
				}
				break;

			case 6:
				{
				setState(266); functionCall();
				}
				break;

			case 7:
				{
				setState(267); varRef();
				}
				break;

			case 8:
				{
				setState(268); match(LEFT_PAR);
				setState(269); expression(0);
				setState(270); match(RIGHT_PAR);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(317);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,27,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(315);
					switch ( getInterpreter().adaptivePredict(_input,26,_ctx) ) {
					case 1:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState, _p);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(274);
						if (!(9 >= _localctx._p)) throw new FailedPredicateException(this, "9 >= $_p");
						setState(275);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << MUlTIP) | (1L << DIV) | (1L << MOD))) != 0)) ) {
						_errHandler.recoverInline(this);
						}
						consume();
						setState(276); expression(10);
						}
						break;

					case 2:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState, _p);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(277);
						if (!(8 >= _localctx._p)) throw new FailedPredicateException(this, "8 >= $_p");
						setState(278);
						_la = _input.LA(1);
						if ( !(_la==ADD || _la==MIN) ) {
						_errHandler.recoverInline(this);
						}
						consume();
						setState(279); expression(9);
						}
						break;

					case 3:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState, _p);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(280);
						if (!(7 >= _localctx._p)) throw new FailedPredicateException(this, "7 >= $_p");
						setState(287);
						switch ( getInterpreter().adaptivePredict(_input,22,_ctx) ) {
						case 1:
							{
							setState(281); match(LESS);
							setState(282); match(ASSIN);
							}
							break;

						case 2:
							{
							setState(283); match(LARGE);
							setState(284); match(ASSIN);
							}
							break;

						case 3:
							{
							setState(285); match(LARGE);
							}
							break;

						case 4:
							{
							setState(286); match(LESS);
							}
							break;
						}
						setState(289); expression(8);
						}
						break;

					case 4:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState, _p);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(290);
						if (!(6 >= _localctx._p)) throw new FailedPredicateException(this, "6 >= $_p");
						setState(291);
						_la = _input.LA(1);
						if ( !(_la==EQUAL || _la==NOT_EQUAL) ) {
						_errHandler.recoverInline(this);
						}
						consume();
						setState(292); expression(7);
						}
						break;

					case 5:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState, _p);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(293);
						if (!(5 >= _localctx._p)) throw new FailedPredicateException(this, "5 >= $_p");
						setState(294); match(AND);
						setState(295); expression(6);
						}
						break;

					case 6:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState, _p);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(296);
						if (!(4 >= _localctx._p)) throw new FailedPredicateException(this, "4 >= $_p");
						setState(297); match(OR);
						setState(298); expression(5);
						}
						break;

					case 7:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState, _p);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(299);
						if (!(13 >= _localctx._p)) throw new FailedPredicateException(this, "13 >= $_p");
						setState(300);
						_la = _input.LA(1);
						if ( !(_la==INCREASE || _la==DECREASE) ) {
						_errHandler.recoverInline(this);
						}
						consume();
						}
						break;

					case 8:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState, _p);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(301);
						if (!(3 >= _localctx._p)) throw new FailedPredicateException(this, "3 >= $_p");
						setState(302); match(QUESTOIN);
						setState(304);
						_la = _input.LA(1);
						if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LEFT_PAR) | (1L << INCREASE) | (1L << DECREASE) | (1L << ADD) | (1L << MIN) | (1L << NOT) | (1L << AT) | (1L << NULL) | (1L << TRUE) | (1L << FALSE) | (1L << HexLiteral) | (1L << DecimalLiteral) | (1L << OctalLiteral) | (1L << FloatingPointLiteral) | (1L << CharacterLiteral) | (1L << StringLiteral) | (1L << Identifier))) != 0)) {
							{
							setState(303); expression(0);
							}
						}

						setState(306); match(COLON);
						setState(308);
						switch ( getInterpreter().adaptivePredict(_input,24,_ctx) ) {
						case 1:
							{
							setState(307); expression(0);
							}
							break;
						}
						}
						break;

					case 9:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState, _p);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(310);
						if (!(2 >= _localctx._p)) throw new FailedPredicateException(this, "2 >= $_p");
						setState(311); match(NOT);
						setState(313);
						switch ( getInterpreter().adaptivePredict(_input,25,_ctx) ) {
						case 1:
							{
							setState(312); expression(0);
							}
							break;
						}
						}
						break;
					}
					} 
				}
				setState(319);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,27,_ctx);
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

	public static class VarRefContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(BeetlParser.Identifier, 0); }
		public List<VarAttributeContext> varAttribute() {
			return getRuleContexts(VarAttributeContext.class);
		}
		public VarAttributeContext varAttribute(int i) {
			return getRuleContext(VarAttributeContext.class,i);
		}
		public VarRefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varRef; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BeetlParserListener ) ((BeetlParserListener)listener).enterVarRef(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BeetlParserListener ) ((BeetlParserListener)listener).exitVarRef(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BeetlParserVisitor ) return ((BeetlParserVisitor<? extends T>)visitor).visitVarRef(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VarRefContext varRef() throws RecognitionException {
		VarRefContext _localctx = new VarRefContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_varRef);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(320); match(Identifier);
			setState(324);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,28,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					{
					{
					setState(321); varAttribute();
					}
					} 
				}
				setState(326);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,28,_ctx);
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

	public static class VarAttributeContext extends ParserRuleContext {
		public TerminalNode RIGHT_SQBR() { return getToken(BeetlParser.RIGHT_SQBR, 0); }
		public TerminalNode LEFT_SQBR() { return getToken(BeetlParser.LEFT_SQBR, 0); }
		public TerminalNode Identifier() { return getToken(BeetlParser.Identifier, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode VIRTUAL() { return getToken(BeetlParser.VIRTUAL, 0); }
		public TerminalNode PERIOD() { return getToken(BeetlParser.PERIOD, 0); }
		public VarAttributeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varAttribute; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BeetlParserListener ) ((BeetlParserListener)listener).enterVarAttribute(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BeetlParserListener ) ((BeetlParserListener)listener).exitVarAttribute(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BeetlParserVisitor ) return ((BeetlParserVisitor<? extends T>)visitor).visitVarAttribute(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VarAttributeContext varAttribute() throws RecognitionException {
		VarAttributeContext _localctx = new VarAttributeContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_varAttribute);
		try {
			setState(335);
			switch (_input.LA(1)) {
			case PERIOD:
				enterOuterAlt(_localctx, 1);
				{
				setState(327); match(PERIOD);
				setState(328); match(Identifier);
				}
				break;
			case VIRTUAL:
				enterOuterAlt(_localctx, 2);
				{
				setState(329); match(VIRTUAL);
				setState(330); match(Identifier);
				}
				break;
			case LEFT_SQBR:
				enterOuterAlt(_localctx, 3);
				{
				setState(331); match(LEFT_SQBR);
				setState(332); expression(0);
				setState(333); match(RIGHT_SQBR);
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

	public static class FunctionCallContext extends ParserRuleContext {
		public TerminalNode RIGHT_PAR() { return getToken(BeetlParser.RIGHT_PAR, 0); }
		public TerminalNode LEFT_PAR() { return getToken(BeetlParser.LEFT_PAR, 0); }
		public ExpressionListContext expressionList() {
			return getRuleContext(ExpressionListContext.class,0);
		}
		public FunctionNsContext functionNs() {
			return getRuleContext(FunctionNsContext.class,0);
		}
		public List<VarAttributeContext> varAttribute() {
			return getRuleContexts(VarAttributeContext.class);
		}
		public VarAttributeContext varAttribute(int i) {
			return getRuleContext(VarAttributeContext.class,i);
		}
		public FunctionCallContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionCall; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BeetlParserListener ) ((BeetlParserListener)listener).enterFunctionCall(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BeetlParserListener ) ((BeetlParserListener)listener).exitFunctionCall(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BeetlParserVisitor ) return ((BeetlParserVisitor<? extends T>)visitor).visitFunctionCall(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionCallContext functionCall() throws RecognitionException {
		FunctionCallContext _localctx = new FunctionCallContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_functionCall);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(337); functionNs();
			setState(338); match(LEFT_PAR);
			setState(340);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LEFT_PAR) | (1L << INCREASE) | (1L << DECREASE) | (1L << ADD) | (1L << MIN) | (1L << NOT) | (1L << AT) | (1L << NULL) | (1L << TRUE) | (1L << FALSE) | (1L << HexLiteral) | (1L << DecimalLiteral) | (1L << OctalLiteral) | (1L << FloatingPointLiteral) | (1L << CharacterLiteral) | (1L << StringLiteral) | (1L << Identifier))) != 0)) {
				{
				setState(339); expressionList();
				}
			}

			setState(342); match(RIGHT_PAR);
			setState(346);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,31,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					{
					{
					setState(343); varAttribute();
					}
					} 
				}
				setState(348);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,31,_ctx);
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

	public static class FunctionTagCallContext extends ParserRuleContext {
		public TerminalNode RIGHT_PAR() { return getToken(BeetlParser.RIGHT_PAR, 0); }
		public TerminalNode LEFT_PAR() { return getToken(BeetlParser.LEFT_PAR, 0); }
		public ExpressionListContext expressionList() {
			return getRuleContext(ExpressionListContext.class,0);
		}
		public FunctionNsContext functionNs() {
			return getRuleContext(FunctionNsContext.class,0);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public FunctionTagCallContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionTagCall; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BeetlParserListener ) ((BeetlParserListener)listener).enterFunctionTagCall(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BeetlParserListener ) ((BeetlParserListener)listener).exitFunctionTagCall(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BeetlParserVisitor ) return ((BeetlParserVisitor<? extends T>)visitor).visitFunctionTagCall(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionTagCallContext functionTagCall() throws RecognitionException {
		FunctionTagCallContext _localctx = new FunctionTagCallContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_functionTagCall);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(349); functionNs();
			setState(350); match(LEFT_PAR);
			setState(352);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LEFT_PAR) | (1L << INCREASE) | (1L << DECREASE) | (1L << ADD) | (1L << MIN) | (1L << NOT) | (1L << AT) | (1L << NULL) | (1L << TRUE) | (1L << FALSE) | (1L << HexLiteral) | (1L << DecimalLiteral) | (1L << OctalLiteral) | (1L << FloatingPointLiteral) | (1L << CharacterLiteral) | (1L << StringLiteral) | (1L << Identifier))) != 0)) {
				{
				setState(351); expressionList();
				}
			}

			setState(354); match(RIGHT_PAR);
			setState(355); block();
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

	public static class FunctionNsContext extends ParserRuleContext {
		public TerminalNode Identifier(int i) {
			return getToken(BeetlParser.Identifier, i);
		}
		public List<TerminalNode> Identifier() { return getTokens(BeetlParser.Identifier); }
		public TerminalNode PERIOD(int i) {
			return getToken(BeetlParser.PERIOD, i);
		}
		public List<TerminalNode> PERIOD() { return getTokens(BeetlParser.PERIOD); }
		public FunctionNsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionNs; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BeetlParserListener ) ((BeetlParserListener)listener).enterFunctionNs(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BeetlParserListener ) ((BeetlParserListener)listener).exitFunctionNs(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BeetlParserVisitor ) return ((BeetlParserVisitor<? extends T>)visitor).visitFunctionNs(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionNsContext functionNs() throws RecognitionException {
		FunctionNsContext _localctx = new FunctionNsContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_functionNs);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(357); match(Identifier);
			setState(362);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==PERIOD) {
				{
				{
				setState(358); match(PERIOD);
				setState(359); match(Identifier);
				}
				}
				setState(364);
				_errHandler.sync(this);
				_la = _input.LA(1);
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

	public static class NativeCallContext extends ParserRuleContext {
		public NativeArrayContext nativeArray(int i) {
			return getRuleContext(NativeArrayContext.class,i);
		}
		public NativeVarRefChainContext nativeVarRefChain(int i) {
			return getRuleContext(NativeVarRefChainContext.class,i);
		}
		public List<NativeMethodContext> nativeMethod() {
			return getRuleContexts(NativeMethodContext.class);
		}
		public List<NativeVarRefChainContext> nativeVarRefChain() {
			return getRuleContexts(NativeVarRefChainContext.class);
		}
		public NativeMethodContext nativeMethod(int i) {
			return getRuleContext(NativeMethodContext.class,i);
		}
		public TerminalNode PERIOD(int i) {
			return getToken(BeetlParser.PERIOD, i);
		}
		public List<NativeArrayContext> nativeArray() {
			return getRuleContexts(NativeArrayContext.class);
		}
		public List<TerminalNode> PERIOD() { return getTokens(BeetlParser.PERIOD); }
		public NativeCallContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_nativeCall; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BeetlParserListener ) ((BeetlParserListener)listener).enterNativeCall(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BeetlParserListener ) ((BeetlParserListener)listener).exitNativeCall(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BeetlParserVisitor ) return ((BeetlParserVisitor<? extends T>)visitor).visitNativeCall(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NativeCallContext nativeCall() throws RecognitionException {
		NativeCallContext _localctx = new NativeCallContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_nativeCall);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(365); nativeVarRefChain();
			setState(372);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,35,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					{
					setState(370);
					switch (_input.LA(1)) {
					case LEFT_PAR:
						{
						setState(366); nativeMethod();
						}
						break;
					case LEFT_SQBR:
						{
						setState(367); nativeArray();
						}
						break;
					case PERIOD:
						{
						setState(368); match(PERIOD);
						setState(369); nativeVarRefChain();
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					} 
				}
				setState(374);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,35,_ctx);
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

	public static class NativeMethodContext extends ParserRuleContext {
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode RIGHT_PAR() { return getToken(BeetlParser.RIGHT_PAR, 0); }
		public TerminalNode LEFT_PAR() { return getToken(BeetlParser.LEFT_PAR, 0); }
		public List<TerminalNode> COMMA() { return getTokens(BeetlParser.COMMA); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public TerminalNode COMMA(int i) {
			return getToken(BeetlParser.COMMA, i);
		}
		public NativeMethodContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_nativeMethod; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BeetlParserListener ) ((BeetlParserListener)listener).enterNativeMethod(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BeetlParserListener ) ((BeetlParserListener)listener).exitNativeMethod(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BeetlParserVisitor ) return ((BeetlParserVisitor<? extends T>)visitor).visitNativeMethod(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NativeMethodContext nativeMethod() throws RecognitionException {
		NativeMethodContext _localctx = new NativeMethodContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_nativeMethod);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(375); match(LEFT_PAR);
			setState(384);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LEFT_PAR) | (1L << INCREASE) | (1L << DECREASE) | (1L << ADD) | (1L << MIN) | (1L << NOT) | (1L << AT) | (1L << NULL) | (1L << TRUE) | (1L << FALSE) | (1L << HexLiteral) | (1L << DecimalLiteral) | (1L << OctalLiteral) | (1L << FloatingPointLiteral) | (1L << CharacterLiteral) | (1L << StringLiteral) | (1L << Identifier))) != 0)) {
				{
				setState(376); expression(0);
				setState(381);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(377); match(COMMA);
					setState(378); expression(0);
					}
					}
					setState(383);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(386); match(RIGHT_PAR);
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

	public static class NativeArrayContext extends ParserRuleContext {
		public TerminalNode RIGHT_SQBR() { return getToken(BeetlParser.RIGHT_SQBR, 0); }
		public TerminalNode LEFT_SQBR() { return getToken(BeetlParser.LEFT_SQBR, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public NativeArrayContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_nativeArray; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BeetlParserListener ) ((BeetlParserListener)listener).enterNativeArray(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BeetlParserListener ) ((BeetlParserListener)listener).exitNativeArray(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BeetlParserVisitor ) return ((BeetlParserVisitor<? extends T>)visitor).visitNativeArray(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NativeArrayContext nativeArray() throws RecognitionException {
		NativeArrayContext _localctx = new NativeArrayContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_nativeArray);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(388); match(LEFT_SQBR);
			setState(389); expression(0);
			setState(390); match(RIGHT_SQBR);
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

	public static class NativeVarRefChainContext extends ParserRuleContext {
		public TerminalNode Identifier(int i) {
			return getToken(BeetlParser.Identifier, i);
		}
		public List<TerminalNode> Identifier() { return getTokens(BeetlParser.Identifier); }
		public TerminalNode PERIOD(int i) {
			return getToken(BeetlParser.PERIOD, i);
		}
		public List<TerminalNode> PERIOD() { return getTokens(BeetlParser.PERIOD); }
		public NativeVarRefChainContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_nativeVarRefChain; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BeetlParserListener ) ((BeetlParserListener)listener).enterNativeVarRefChain(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BeetlParserListener ) ((BeetlParserListener)listener).exitNativeVarRefChain(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BeetlParserVisitor ) return ((BeetlParserVisitor<? extends T>)visitor).visitNativeVarRefChain(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NativeVarRefChainContext nativeVarRefChain() throws RecognitionException {
		NativeVarRefChainContext _localctx = new NativeVarRefChainContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_nativeVarRefChain);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(392); match(Identifier);
			setState(397);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,38,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					{
					{
					setState(393); match(PERIOD);
					setState(394); match(Identifier);
					}
					} 
				}
				setState(399);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,38,_ctx);
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

	public static class LiteralContext extends ParserRuleContext {
		public IntegerLiteralContext integerLiteral() {
			return getRuleContext(IntegerLiteralContext.class,0);
		}
		public TerminalNode CharacterLiteral() { return getToken(BeetlParser.CharacterLiteral, 0); }
		public TerminalNode StringLiteral() { return getToken(BeetlParser.StringLiteral, 0); }
		public TerminalNode FloatingPointLiteral() { return getToken(BeetlParser.FloatingPointLiteral, 0); }
		public TerminalNode NULL() { return getToken(BeetlParser.NULL, 0); }
		public BooleanLiteralContext booleanLiteral() {
			return getRuleContext(BooleanLiteralContext.class,0);
		}
		public LiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_literal; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BeetlParserListener ) ((BeetlParserListener)listener).enterLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BeetlParserListener ) ((BeetlParserListener)listener).exitLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BeetlParserVisitor ) return ((BeetlParserVisitor<? extends T>)visitor).visitLiteral(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LiteralContext literal() throws RecognitionException {
		LiteralContext _localctx = new LiteralContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_literal);
		try {
			setState(406);
			switch (_input.LA(1)) {
			case HexLiteral:
			case DecimalLiteral:
			case OctalLiteral:
				enterOuterAlt(_localctx, 1);
				{
				setState(400); integerLiteral();
				}
				break;
			case FloatingPointLiteral:
				enterOuterAlt(_localctx, 2);
				{
				setState(401); match(FloatingPointLiteral);
				}
				break;
			case CharacterLiteral:
				enterOuterAlt(_localctx, 3);
				{
				setState(402); match(CharacterLiteral);
				}
				break;
			case StringLiteral:
				enterOuterAlt(_localctx, 4);
				{
				setState(403); match(StringLiteral);
				}
				break;
			case TRUE:
			case FALSE:
				enterOuterAlt(_localctx, 5);
				{
				setState(404); booleanLiteral();
				}
				break;
			case NULL:
				enterOuterAlt(_localctx, 6);
				{
				setState(405); match(NULL);
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

	public static class IntegerLiteralContext extends ParserRuleContext {
		public TerminalNode OctalLiteral() { return getToken(BeetlParser.OctalLiteral, 0); }
		public TerminalNode DecimalLiteral() { return getToken(BeetlParser.DecimalLiteral, 0); }
		public TerminalNode HexLiteral() { return getToken(BeetlParser.HexLiteral, 0); }
		public IntegerLiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_integerLiteral; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BeetlParserListener ) ((BeetlParserListener)listener).enterIntegerLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BeetlParserListener ) ((BeetlParserListener)listener).exitIntegerLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BeetlParserVisitor ) return ((BeetlParserVisitor<? extends T>)visitor).visitIntegerLiteral(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IntegerLiteralContext integerLiteral() throws RecognitionException {
		IntegerLiteralContext _localctx = new IntegerLiteralContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_integerLiteral);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(408);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << HexLiteral) | (1L << DecimalLiteral) | (1L << OctalLiteral))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			consume();
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

	public static class BooleanLiteralContext extends ParserRuleContext {
		public TerminalNode TRUE() { return getToken(BeetlParser.TRUE, 0); }
		public TerminalNode FALSE() { return getToken(BeetlParser.FALSE, 0); }
		public BooleanLiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_booleanLiteral; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BeetlParserListener ) ((BeetlParserListener)listener).enterBooleanLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BeetlParserListener ) ((BeetlParserListener)listener).exitBooleanLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BeetlParserVisitor ) return ((BeetlParserVisitor<? extends T>)visitor).visitBooleanLiteral(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BooleanLiteralContext booleanLiteral() throws RecognitionException {
		BooleanLiteralContext _localctx = new BooleanLiteralContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_booleanLiteral);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(410);
			_la = _input.LA(1);
			if ( !(_la==TRUE || _la==FALSE) ) {
			_errHandler.recoverInline(this);
			}
			consume();
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

	public static class ArgumentsContext extends ParserRuleContext {
		public TerminalNode RIGHT_PAR() { return getToken(BeetlParser.RIGHT_PAR, 0); }
		public TerminalNode LEFT_PAR() { return getToken(BeetlParser.LEFT_PAR, 0); }
		public ExpressionListContext expressionList() {
			return getRuleContext(ExpressionListContext.class,0);
		}
		public ArgumentsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arguments; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BeetlParserListener ) ((BeetlParserListener)listener).enterArguments(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BeetlParserListener ) ((BeetlParserListener)listener).exitArguments(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BeetlParserVisitor ) return ((BeetlParserVisitor<? extends T>)visitor).visitArguments(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArgumentsContext arguments() throws RecognitionException {
		ArgumentsContext _localctx = new ArgumentsContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_arguments);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(412); match(LEFT_PAR);
			setState(414);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LEFT_PAR) | (1L << INCREASE) | (1L << DECREASE) | (1L << ADD) | (1L << MIN) | (1L << NOT) | (1L << AT) | (1L << NULL) | (1L << TRUE) | (1L << FALSE) | (1L << HexLiteral) | (1L << DecimalLiteral) | (1L << OctalLiteral) | (1L << FloatingPointLiteral) | (1L << CharacterLiteral) | (1L << StringLiteral) | (1L << Identifier))) != 0)) {
				{
				setState(413); expressionList();
				}
			}

			setState(416); match(RIGHT_PAR);
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
		case 18: return expression_sempred((ExpressionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0: return 9 >= _localctx._p;

		case 1: return 8 >= _localctx._p;

		case 2: return 7 >= _localctx._p;

		case 3: return 6 >= _localctx._p;

		case 4: return 5 >= _localctx._p;

		case 5: return 4 >= _localctx._p;

		case 6: return 13 >= _localctx._p;

		case 7: return 3 >= _localctx._p;

		case 8: return 2 >= _localctx._p;
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\uacf5\uee8c\u4f5d\u8b0d\u4a45\u78bd\u1b2f\u3378\3<\u01a5\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\3\2\5\2D\n\2\3\2\7\2G\n\2\f\2\16\2J\13\2\3\2\3\2\3\3\3\3\7\3P\n\3"+
		"\f\3\16\3S\13\3\3\3\3\3\3\4\3\4\7\4Y\n\4\f\4\16\4\\\13\4\3\4\3\4\3\5\3"+
		"\5\3\5\3\5\3\5\3\5\3\5\5\5g\n\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3"+
		"\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\5\5{\n\5\3\5\3\5\3\5\3\5\3\5\3\5\3"+
		"\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\5\5\u008f\n\5\3\6\3\6\5"+
		"\6\u0093\n\6\3\6\3\6\3\7\3\7\3\7\3\7\5\7\u009b\n\7\3\7\3\7\7\7\u009f\n"+
		"\7\f\7\16\7\u00a2\13\7\3\7\5\7\u00a5\n\7\3\7\3\7\3\b\3\b\3\b\3\b\7\b\u00ad"+
		"\n\b\f\b\16\b\u00b0\13\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\n\3\n\3\n\7\n\u00bc"+
		"\n\n\f\n\16\n\u00bf\13\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13\5\13\u00c8"+
		"\n\13\3\f\3\f\7\f\u00cc\n\f\f\f\16\f\u00cf\13\f\3\f\7\f\u00d2\n\f\f\f"+
		"\16\f\u00d5\13\f\3\f\3\f\3\r\6\r\u00da\n\r\r\r\16\r\u00db\3\r\7\r\u00df"+
		"\n\r\f\r\16\r\u00e2\13\r\3\16\3\16\3\16\3\16\3\16\3\16\5\16\u00ea\n\16"+
		"\3\17\5\17\u00ed\n\17\3\17\3\17\3\17\3\17\3\20\3\20\3\20\3\20\3\21\3\21"+
		"\3\21\7\21\u00fa\n\21\f\21\16\21\u00fd\13\21\3\22\3\22\3\23\3\23\3\24"+
		"\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24"+
		"\3\24\5\24\u0113\n\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24"+
		"\3\24\3\24\3\24\5\24\u0122\n\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24"+
		"\3\24\3\24\3\24\3\24\3\24\3\24\3\24\5\24\u0133\n\24\3\24\3\24\5\24\u0137"+
		"\n\24\3\24\3\24\3\24\5\24\u013c\n\24\7\24\u013e\n\24\f\24\16\24\u0141"+
		"\13\24\3\25\3\25\7\25\u0145\n\25\f\25\16\25\u0148\13\25\3\26\3\26\3\26"+
		"\3\26\3\26\3\26\3\26\3\26\5\26\u0152\n\26\3\27\3\27\3\27\5\27\u0157\n"+
		"\27\3\27\3\27\7\27\u015b\n\27\f\27\16\27\u015e\13\27\3\30\3\30\3\30\5"+
		"\30\u0163\n\30\3\30\3\30\3\30\3\31\3\31\3\31\7\31\u016b\n\31\f\31\16\31"+
		"\u016e\13\31\3\32\3\32\3\32\3\32\3\32\7\32\u0175\n\32\f\32\16\32\u0178"+
		"\13\32\3\33\3\33\3\33\3\33\7\33\u017e\n\33\f\33\16\33\u0181\13\33\5\33"+
		"\u0183\n\33\3\33\3\33\3\34\3\34\3\34\3\34\3\35\3\35\3\35\7\35\u018e\n"+
		"\35\f\35\16\35\u0191\13\35\3\36\3\36\3\36\3\36\3\36\3\36\5\36\u0199\n"+
		"\36\3\37\3\37\3 \3 \3!\3!\5!\u01a1\n!\3!\3!\3!\2\"\2\4\6\b\n\f\16\20\22"+
		"\24\26\30\32\34\36 \"$&(*,.\60\62\64\668:<>@\2\b\3\2\31\32\3\2\26\27\3"+
		"\2\33\35\3\2\36\37\3\2\60\62\3\2)*\u01d0\2C\3\2\2\2\4M\3\2\2\2\6V\3\2"+
		"\2\2\b\u008e\3\2\2\2\n\u0090\3\2\2\2\f\u009a\3\2\2\2\16\u00a8\3\2\2\2"+
		"\20\u00b4\3\2\2\2\22\u00b8\3\2\2\2\24\u00c7\3\2\2\2\26\u00c9\3\2\2\2\30"+
		"\u00d9\3\2\2\2\32\u00e9\3\2\2\2\34\u00ec\3\2\2\2\36\u00f2\3\2\2\2 \u00f6"+
		"\3\2\2\2\"\u00fe\3\2\2\2$\u0100\3\2\2\2&\u0112\3\2\2\2(\u0142\3\2\2\2"+
		"*\u0151\3\2\2\2,\u0153\3\2\2\2.\u015f\3\2\2\2\60\u0167\3\2\2\2\62\u016f"+
		"\3\2\2\2\64\u0179\3\2\2\2\66\u0186\3\2\2\28\u018a\3\2\2\2:\u0198\3\2\2"+
		"\2<\u019a\3\2\2\2>\u019c\3\2\2\2@\u019e\3\2\2\2BD\5\4\3\2CB\3\2\2\2CD"+
		"\3\2\2\2DH\3\2\2\2EG\5\b\5\2FE\3\2\2\2GJ\3\2\2\2HF\3\2\2\2HI\3\2\2\2I"+
		"K\3\2\2\2JH\3\2\2\2KL\7\2\2\3L\3\3\2\2\2MQ\7\67\2\2NP\78\2\2ON\3\2\2\2"+
		"PS\3\2\2\2QO\3\2\2\2QR\3\2\2\2RT\3\2\2\2SQ\3\2\2\2TU\7:\2\2U\5\3\2\2\2"+
		"VZ\7\20\2\2WY\5\b\5\2XW\3\2\2\2Y\\\3\2\2\2ZX\3\2\2\2Z[\3\2\2\2[]\3\2\2"+
		"\2\\Z\3\2\2\2]^\7\21\2\2^\7\3\2\2\2_\u008f\5\6\4\2`\u008f\5\4\3\2ab\7"+
		"\3\2\2bc\5\36\20\2cf\5\b\5\2de\7\5\2\2eg\5\b\5\2fd\3\2\2\2fg\3\2\2\2g"+
		"\u008f\3\2\2\2hi\7\4\2\2ij\7\22\2\2jk\5\34\17\2kl\7\23\2\2lm\5\b\5\2m"+
		"\u008f\3\2\2\2no\7\6\2\2op\5\36\20\2pq\5\b\5\2q\u008f\3\2\2\2rs\7\7\2"+
		"\2st\5\36\20\2tu\5\26\f\2u\u008f\3\2\2\2vw\7\b\2\2w\u008f\5\f\7\2xz\7"+
		"\t\2\2y{\5&\24\2zy\3\2\2\2z{\3\2\2\2{|\3\2\2\2|\u008f\7+\2\2}~\7\n\2\2"+
		"~\u008f\7+\2\2\177\u0080\7\13\2\2\u0080\u008f\7+\2\2\u0081\u0082\7\f\2"+
		"\2\u0082\u0083\5\22\n\2\u0083\u0084\7+\2\2\u0084\u008f\3\2\2\2\u0085\u0086"+
		"\7\r\2\2\u0086\u008f\5\n\6\2\u0087\u0088\5\24\13\2\u0088\u0089\7+\2\2"+
		"\u0089\u008f\3\2\2\2\u008a\u008f\5.\30\2\u008b\u008c\5\"\22\2\u008c\u008d"+
		"\7+\2\2\u008d\u008f\3\2\2\2\u008e_\3\2\2\2\u008e`\3\2\2\2\u008ea\3\2\2"+
		"\2\u008eh\3\2\2\2\u008en\3\2\2\2\u008er\3\2\2\2\u008ev\3\2\2\2\u008ex"+
		"\3\2\2\2\u008e}\3\2\2\2\u008e\177\3\2\2\2\u008e\u0081\3\2\2\2\u008e\u0085"+
		"\3\2\2\2\u008e\u0087\3\2\2\2\u008e\u008a\3\2\2\2\u008e\u008b\3\2\2\2\u008f"+
		"\t\3\2\2\2\u0090\u0092\7\66\2\2\u0091\u0093\7\65\2\2\u0092\u0091\3\2\2"+
		"\2\u0092\u0093\3\2\2\2\u0093\u0094\3\2\2\2\u0094\u0095\7+\2\2\u0095\13"+
		"\3\2\2\2\u0096\u0097\7\22\2\2\u0097\u0098\5&\24\2\u0098\u0099\7\23\2\2"+
		"\u0099\u009b\3\2\2\2\u009a\u0096\3\2\2\2\u009a\u009b\3\2\2\2\u009b\u009c"+
		"\3\2\2\2\u009c\u00a0\7\20\2\2\u009d\u009f\5\16\b\2\u009e\u009d\3\2\2\2"+
		"\u009f\u00a2\3\2\2\2\u00a0\u009e\3\2\2\2\u00a0\u00a1\3\2\2\2\u00a1\u00a4"+
		"\3\2\2\2\u00a2\u00a0\3\2\2\2\u00a3\u00a5\5\20\t\2\u00a4\u00a3\3\2\2\2"+
		"\u00a4\u00a5\3\2\2\2\u00a5\u00a6\3\2\2\2\u00a6\u00a7\7\21\2\2\u00a7\r"+
		"\3\2\2\2\u00a8\u00a9\7\16\2\2\u00a9\u00ae\5&\24\2\u00aa\u00ab\7,\2\2\u00ab"+
		"\u00ad\5&\24\2\u00ac\u00aa\3\2\2\2\u00ad\u00b0\3\2\2\2\u00ae\u00ac\3\2"+
		"\2\2\u00ae\u00af\3\2\2\2\u00af\u00b1\3\2\2\2\u00b0\u00ae\3\2\2\2\u00b1"+
		"\u00b2\7-\2\2\u00b2\u00b3\5\b\5\2\u00b3\17\3\2\2\2\u00b4\u00b5\7\17\2"+
		"\2\u00b5\u00b6\7-\2\2\u00b6\u00b7\5\b\5\2\u00b7\21\3\2\2\2\u00b8\u00bd"+
		"\5\24\13\2\u00b9\u00ba\7,\2\2\u00ba\u00bc\5\24\13\2\u00bb\u00b9\3\2\2"+
		"\2\u00bc\u00bf\3\2\2\2\u00bd\u00bb\3\2\2\2\u00bd\u00be\3\2\2\2\u00be\23"+
		"\3\2\2\2\u00bf\u00bd\3\2\2\2\u00c0\u00c8\7\66\2\2\u00c1\u00c2\7\66\2\2"+
		"\u00c2\u00c3\7 \2\2\u00c3\u00c8\5&\24\2\u00c4\u00c5\7\66\2\2\u00c5\u00c6"+
		"\7 \2\2\u00c6\u00c8\5\6\4\2\u00c7\u00c0\3\2\2\2\u00c7\u00c1\3\2\2\2\u00c7"+
		"\u00c4\3\2\2\2\u00c8\25\3\2\2\2\u00c9\u00cd\7\20\2\2\u00ca\u00cc\5\30"+
		"\r\2\u00cb\u00ca\3\2\2\2\u00cc\u00cf\3\2\2\2\u00cd\u00cb\3\2\2\2\u00cd"+
		"\u00ce\3\2\2\2\u00ce\u00d3\3\2\2\2\u00cf\u00cd\3\2\2\2\u00d0\u00d2\5\32"+
		"\16\2\u00d1\u00d0\3\2\2\2\u00d2\u00d5\3\2\2\2\u00d3\u00d1\3\2\2\2\u00d3"+
		"\u00d4\3\2\2\2\u00d4\u00d6\3\2\2\2\u00d5\u00d3\3\2\2\2\u00d6\u00d7\7\21"+
		"\2\2\u00d7\27\3\2\2\2\u00d8\u00da\5\32\16\2\u00d9\u00d8\3\2\2\2\u00da"+
		"\u00db\3\2\2\2\u00db\u00d9\3\2\2\2\u00db\u00dc\3\2\2\2\u00dc\u00e0\3\2"+
		"\2\2\u00dd\u00df\5\b\5\2\u00de\u00dd\3\2\2\2\u00df\u00e2\3\2\2\2\u00e0"+
		"\u00de\3\2\2\2\u00e0\u00e1\3\2\2\2\u00e1\31\3\2\2\2\u00e2\u00e0\3\2\2"+
		"\2\u00e3\u00e4\7\16\2\2\u00e4\u00e5\5&\24\2\u00e5\u00e6\7-\2\2\u00e6\u00ea"+
		"\3\2\2\2\u00e7\u00e8\7\17\2\2\u00e8\u00ea\7-\2\2\u00e9\u00e3\3\2\2\2\u00e9"+
		"\u00e7\3\2\2\2\u00ea\33\3\2\2\2\u00eb\u00ed\7\f\2\2\u00ec\u00eb\3\2\2"+
		"\2\u00ec\u00ed\3\2\2\2\u00ed\u00ee\3\2\2\2\u00ee\u00ef\7\66\2\2\u00ef"+
		"\u00f0\7/\2\2\u00f0\u00f1\5&\24\2\u00f1\35\3\2\2\2\u00f2\u00f3\7\22\2"+
		"\2\u00f3\u00f4\5&\24\2\u00f4\u00f5\7\23\2\2\u00f5\37\3\2\2\2\u00f6\u00fb"+
		"\5&\24\2\u00f7\u00f8\7,\2\2\u00f8\u00fa\5&\24\2\u00f9\u00f7\3\2\2\2\u00fa"+
		"\u00fd\3\2\2\2\u00fb\u00f9\3\2\2\2\u00fb\u00fc\3\2\2\2\u00fc!\3\2\2\2"+
		"\u00fd\u00fb\3\2\2\2\u00fe\u00ff\5&\24\2\u00ff#\3\2\2\2\u0100\u0101\5"+
		"&\24\2\u0101%\3\2\2\2\u0102\u0103\b\24\1\2\u0103\u0104\t\2\2\2\u0104\u0113"+
		"\5&\24\2\u0105\u0106\t\3\2\2\u0106\u0113\5&\24\2\u0107\u0108\7#\2\2\u0108"+
		"\u0113\5&\24\2\u0109\u0113\5:\36\2\u010a\u010b\7\'\2\2\u010b\u0113\5\62"+
		"\32\2\u010c\u0113\5,\27\2\u010d\u0113\5(\25\2\u010e\u010f\7\22\2\2\u010f"+
		"\u0110\5&\24\2\u0110\u0111\7\23\2\2\u0111\u0113\3\2\2\2\u0112\u0102\3"+
		"\2\2\2\u0112\u0105\3\2\2\2\u0112\u0107\3\2\2\2\u0112\u0109\3\2\2\2\u0112"+
		"\u010a\3\2\2\2\u0112\u010c\3\2\2\2\u0112\u010d\3\2\2\2\u0112\u010e\3\2"+
		"\2\2\u0113\u013f\3\2\2\2\u0114\u0115\6\24\2\3\u0115\u0116\t\4\2\2\u0116"+
		"\u013e\5&\24\2\u0117\u0118\6\24\3\3\u0118\u0119\t\2\2\2\u0119\u013e\5"+
		"&\24\2\u011a\u0121\6\24\4\3\u011b\u011c\7\"\2\2\u011c\u0122\7 \2\2\u011d"+
		"\u011e\7!\2\2\u011e\u0122\7 \2\2\u011f\u0122\7!\2\2\u0120\u0122\7\"\2"+
		"\2\u0121\u011b\3\2\2\2\u0121\u011d\3\2\2\2\u0121\u011f\3\2\2\2\u0121\u0120"+
		"\3\2\2\2\u0122\u0123\3\2\2\2\u0123\u013e\5&\24\2\u0124\u0125\6\24\5\3"+
		"\u0125\u0126\t\5\2\2\u0126\u013e\5&\24\2\u0127\u0128\6\24\6\3\u0128\u0129"+
		"\7$\2\2\u0129\u013e\5&\24\2\u012a\u012b\6\24\7\3\u012b\u012c\7%\2\2\u012c"+
		"\u013e\5&\24\2\u012d\u012e\6\24\b\3\u012e\u013e\t\3\2\2\u012f\u0130\6"+
		"\24\t\3\u0130\u0132\7&\2\2\u0131\u0133\5&\24\2\u0132\u0131\3\2\2\2\u0132"+
		"\u0133\3\2\2\2\u0133\u0134\3\2\2\2\u0134\u0136\7-\2\2\u0135\u0137\5&\24"+
		"\2\u0136\u0135\3\2\2\2\u0136\u0137\3\2\2\2\u0137\u013e\3\2\2\2\u0138\u0139"+
		"\6\24\n\3\u0139\u013b\7#\2\2\u013a\u013c\5&\24\2\u013b\u013a\3\2\2\2\u013b"+
		"\u013c\3\2\2\2\u013c\u013e\3\2\2\2\u013d\u0114\3\2\2\2\u013d\u0117\3\2"+
		"\2\2\u013d\u011a\3\2\2\2\u013d\u0124\3\2\2\2\u013d\u0127\3\2\2\2\u013d"+
		"\u012a\3\2\2\2\u013d\u012d\3\2\2\2\u013d\u012f\3\2\2\2\u013d\u0138\3\2"+
		"\2\2\u013e\u0141\3\2\2\2\u013f\u013d\3\2\2\2\u013f\u0140\3\2\2\2\u0140"+
		"\'\3\2\2\2\u0141\u013f\3\2\2\2\u0142\u0146\7\66\2\2\u0143\u0145\5*\26"+
		"\2\u0144\u0143\3\2\2\2\u0145\u0148\3\2\2\2\u0146\u0144\3\2\2\2\u0146\u0147"+
		"\3\2\2\2\u0147)\3\2\2\2\u0148\u0146\3\2\2\2\u0149\u014a\7.\2\2\u014a\u0152"+
		"\7\66\2\2\u014b\u014c\7\30\2\2\u014c\u0152\7\66\2\2\u014d\u014e\7\24\2"+
		"\2\u014e\u014f\5&\24\2\u014f\u0150\7\25\2\2\u0150\u0152\3\2\2\2\u0151"+
		"\u0149\3\2\2\2\u0151\u014b\3\2\2\2\u0151\u014d\3\2\2\2\u0152+\3\2\2\2"+
		"\u0153\u0154\5\60\31\2\u0154\u0156\7\22\2\2\u0155\u0157\5 \21\2\u0156"+
		"\u0155\3\2\2\2\u0156\u0157\3\2\2\2\u0157\u0158\3\2\2\2\u0158\u015c\7\23"+
		"\2\2\u0159\u015b\5*\26\2\u015a\u0159\3\2\2\2\u015b\u015e\3\2\2\2\u015c"+
		"\u015a\3\2\2\2\u015c\u015d\3\2\2\2\u015d-\3\2\2\2\u015e\u015c\3\2\2\2"+
		"\u015f\u0160\5\60\31\2\u0160\u0162\7\22\2\2\u0161\u0163\5 \21\2\u0162"+
		"\u0161\3\2\2\2\u0162\u0163\3\2\2\2\u0163\u0164\3\2\2\2\u0164\u0165\7\23"+
		"\2\2\u0165\u0166\5\6\4\2\u0166/\3\2\2\2\u0167\u016c\7\66\2\2\u0168\u0169"+
		"\7.\2\2\u0169\u016b\7\66\2\2\u016a\u0168\3\2\2\2\u016b\u016e\3\2\2\2\u016c"+
		"\u016a\3\2\2\2\u016c\u016d\3\2\2\2\u016d\61\3\2\2\2\u016e\u016c\3\2\2"+
		"\2\u016f\u0176\58\35\2\u0170\u0175\5\64\33\2\u0171\u0175\5\66\34\2\u0172"+
		"\u0173\7.\2\2\u0173\u0175\58\35\2\u0174\u0170\3\2\2\2\u0174\u0171\3\2"+
		"\2\2\u0174\u0172\3\2\2\2\u0175\u0178\3\2\2\2\u0176\u0174\3\2\2\2\u0176"+
		"\u0177\3\2\2\2\u0177\63\3\2\2\2\u0178\u0176\3\2\2\2\u0179\u0182\7\22\2"+
		"\2\u017a\u017f\5&\24\2\u017b\u017c\7,\2\2\u017c\u017e\5&\24\2\u017d\u017b"+
		"\3\2\2\2\u017e\u0181\3\2\2\2\u017f\u017d\3\2\2\2\u017f\u0180\3\2\2\2\u0180"+
		"\u0183\3\2\2\2\u0181\u017f\3\2\2\2\u0182\u017a\3\2\2\2\u0182\u0183\3\2"+
		"\2\2\u0183\u0184\3\2\2\2\u0184\u0185\7\23\2\2\u0185\65\3\2\2\2\u0186\u0187"+
		"\7\24\2\2\u0187\u0188\5&\24\2\u0188\u0189\7\25\2\2\u0189\67\3\2\2\2\u018a"+
		"\u018f\7\66\2\2\u018b\u018c\7.\2\2\u018c\u018e\7\66\2\2\u018d\u018b\3"+
		"\2\2\2\u018e\u0191\3\2\2\2\u018f\u018d\3\2\2\2\u018f\u0190\3\2\2\2\u0190"+
		"9\3\2\2\2\u0191\u018f\3\2\2\2\u0192\u0199\5<\37\2\u0193\u0199\7\63\2\2"+
		"\u0194\u0199\7\64\2\2\u0195\u0199\7\65\2\2\u0196\u0199\5> \2\u0197\u0199"+
		"\7(\2\2\u0198\u0192\3\2\2\2\u0198\u0193\3\2\2\2\u0198\u0194\3\2\2\2\u0198"+
		"\u0195\3\2\2\2\u0198\u0196\3\2\2\2\u0198\u0197\3\2\2\2\u0199;\3\2\2\2"+
		"\u019a\u019b\t\6\2\2\u019b=\3\2\2\2\u019c\u019d\t\7\2\2\u019d?\3\2\2\2"+
		"\u019e\u01a0\7\22\2\2\u019f\u01a1\5 \21\2\u01a0\u019f\3\2\2\2\u01a0\u01a1"+
		"\3\2\2\2\u01a1\u01a2\3\2\2\2\u01a2\u01a3\7\23\2\2\u01a3A\3\2\2\2+CHQZ"+
		"fz\u008e\u0092\u009a\u00a0\u00a4\u00ae\u00bd\u00c7\u00cd\u00d3\u00db\u00e0"+
		"\u00e9\u00ec\u00fb\u0112\u0121\u0132\u0136\u013b\u013d\u013f\u0146\u0151"+
		"\u0156\u015c\u0162\u016c\u0174\u0176\u017f\u0182\u018f\u0198\u01a0";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}