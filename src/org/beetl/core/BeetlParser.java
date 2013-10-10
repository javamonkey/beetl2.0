// Generated from E:\lijz\javamonkey\bee\research\antlrworks2\projects\beetl\Beetl.g4 by ANTLR 4.1

package org.beetl.core;




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
		T__27=1, T__26=2, T__25=3, T__24=4, T__23=5, T__22=6, T__21=7, T__20=8, 
		T__19=9, T__18=10, T__17=11, T__16=12, T__15=13, T__14=14, T__13=15, T__12=16, 
		T__11=17, T__10=18, T__9=19, T__8=20, T__7=21, T__6=22, T__5=23, T__4=24, 
		T__3=25, T__2=26, T__1=27, T__0=28, BOOLEAN=29, VAR=30, INT=31, DOUBLE=32, 
		NULL=33, ADD=34, MINUS=35, MULTIP=36, DIV=37, MOD=38, EQUAL=39, NOT_EQUAL=40, 
		LARGE=41, LARGE_EQUAL=42, LESS=43, LESS_EQUAL=44, OR=45, AND=46, LEFT_TOKEN=47, 
		RIGHT_TOKEN=48, LEFT_TEXT_TOKEN=49, LEFT_BRACE=50, RIGHT_BRACE=51, Comment=52, 
		LineComment=53, StringLiteral=54, NumericLiteral=55, Identifier=56, WhiteSpace=57, 
		VAR_DEFINE=58, VAR_REFER=59, ASSIGNMENT=60, HOLDER=61, TEXT_HOLDER=62, 
		FOR=63, VAR_TEXT=64, FM=65, DEFAULT_FM=66, SLIST=67, IF=68, EXP=69, COND_EXP=70, 
		FUNCTION=71, TEXT_PROCESS=72, ATTR_NAME=73, VIRTUAL_ATTR_NAME=74, MAP_LIST_INDEX=75, 
		BREAK=76, CONTINUE=77, RETURN=78, NOT=79, SWITCH=80, CASE=81, DEFAULT=82, 
		G_SWITCH=83, G_CASE=84, G_DEFAULT=85, G_CASE_EXPLIST=86, JSON=87, JSONARRAY=88, 
		JSONMAP=89, JSONKEYVALUE=90, CLASS_STATIC_FUNCTION=91, CLASS_FUNCTION=92, 
		CLASS_METHOD=93, CLASS_ARRAY=94, VARIABLE_VAR_REFER=95, TEXT_VAR_REFER=96, 
		MISSING_VARIABLE_VAR_REFER=97, FUNCTION_FULL_NAME=98, SAFE_OUTPUT=99, 
		DIRECT_CALL=100, NEGATOM=101, WHILE=102, DIRECTIVE=103, COND=104, SIMPLE_CASE=105, 
		SIMPLE_LEFT_CASE=106, SIMPLE_RIGHT_CASE=107;
	public static final String[] tokenNames = {
		"<INVALID>", "']'", "'select'", "'default'", "','", "'while'", "'['", 
		"'elsefor'", "'('", "':'", "'if'", "'continue'", "'?'", "'in '", "'break'", 
		"'!('", "'else'", "'.~'", "'case'", "'.'", "')'", "'for'", "'@'", "'='", 
		"'return'", "';'", "'DIRECTIVE'", "'switch'", "'!'", "BOOLEAN", "'var'", 
		"INT", "DOUBLE", "'null'", "'+'", "'-'", "'*'", "'/'", "'%'", "'=='", 
		"'!='", "'>'", "'>='", "'<'", "'<='", "'||'", "'&&'", "'<<'", "'>>'", 
		"'<$'", "'{'", "'}'", "Comment", "LineComment", "StringLiteral", "NumericLiteral", 
		"Identifier", "WhiteSpace", "VAR_DEFINE", "VAR_REFER", "ASSIGNMENT", "HOLDER", 
		"TEXT_HOLDER", "FOR", "VAR_TEXT", "FM", "DEFAULT_FM", "SLIST", "IF", "EXP", 
		"COND_EXP", "FUNCTION", "TEXT_PROCESS", "ATTR_NAME", "VIRTUAL_ATTR_NAME", 
		"MAP_LIST_INDEX", "BREAK", "CONTINUE", "RETURN", "NOT", "SWITCH", "CASE", 
		"DEFAULT", "G_SWITCH", "G_CASE", "G_DEFAULT", "G_CASE_EXPLIST", "JSON", 
		"JSONARRAY", "JSONMAP", "JSONKEYVALUE", "CLASS_STATIC_FUNCTION", "CLASS_FUNCTION", 
		"CLASS_METHOD", "CLASS_ARRAY", "VARIABLE_VAR_REFER", "TEXT_VAR_REFER", 
		"MISSING_VARIABLE_VAR_REFER", "FUNCTION_FULL_NAME", "SAFE_OUTPUT", "DIRECT_CALL", 
		"NEGATOM", "WHILE", "DIRECTIVE", "COND", "SIMPLE_CASE", "SIMPLE_LEFT_CASE", 
		"SIMPLE_RIGHT_CASE"
	};
	public static final int
		RULE_prog = 0, RULE_statements = 1, RULE_statement = 2, RULE_g_switchStatment = 3, 
		RULE_g_caseStatment = 4, RULE_g_defaultStatment = 5, RULE_directive = 6, 
		RULE_returnStatment = 7, RULE_continueStatment = 8, RULE_breakStatment = 9, 
		RULE_messFunction = 10, RULE_textProcessFunction = 11, RULE_functionCall = 12, 
		RULE_statmentBlock = 13, RULE_forStatment = 14, RULE_whileStament = 15, 
		RULE_ifStatment = 16, RULE_constantsTextStatment = 17, RULE_textStatment = 18, 
		RULE_textVar = 19, RULE_textformat = 20, RULE_varDefine = 21, RULE_varAssignMent = 22, 
		RULE_assignMent = 23, RULE_varRef = 24, RULE_safeOutput = 25, RULE_varAttribute = 26, 
		RULE_exp = 27, RULE_condExp = 28, RULE_conditionalOrExpression = 29, RULE_conditionalAndExpression = 30, 
		RULE_condExpNotItem = 31, RULE_condExpItem = 32, RULE_aexpr = 33, RULE_mexpr = 34, 
		RULE_atom = 35, RULE_unaryAtom = 36, RULE_nativeMethod = 37, RULE_classMutileExp = 38, 
		RULE_classNextExp = 39, RULE_classMethod = 40, RULE_classArray = 41, RULE_functionFullName = 42, 
		RULE_switchStatment = 43, RULE_caseStatment = 44, RULE_defaultStatment = 45, 
		RULE_json = 46, RULE_jsonKeyValue = 47;
	public static final String[] ruleNames = {
		"prog", "statements", "statement", "g_switchStatment", "g_caseStatment", 
		"g_defaultStatment", "directive", "returnStatment", "continueStatment", 
		"breakStatment", "messFunction", "textProcessFunction", "functionCall", 
		"statmentBlock", "forStatment", "whileStament", "ifStatment", "constantsTextStatment", 
		"textStatment", "textVar", "textformat", "varDefine", "varAssignMent", 
		"assignMent", "varRef", "safeOutput", "varAttribute", "exp", "condExp", 
		"conditionalOrExpression", "conditionalAndExpression", "condExpNotItem", 
		"condExpItem", "aexpr", "mexpr", "atom", "unaryAtom", "nativeMethod", 
		"classMutileExp", "classNextExp", "classMethod", "classArray", "functionFullName", 
		"switchStatment", "caseStatment", "defaultStatment", "json", "jsonKeyValue"
	};

	@Override
	public String getGrammarFileName() { return "Beetl.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public ATN getATN() { return _ATN; }


	boolean isStrictMVC = false;


	public boolean isTextProcessFunction(TokenStream input){
		return true;
	}


	public BeetlParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class ProgContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(BeetlParser.EOF, 0); }
		public StatementsContext statements() {
			return getRuleContext(StatementsContext.class,0);
		}
		public ProgContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prog; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BeetlListener ) ((BeetlListener)listener).enterProg(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BeetlListener ) ((BeetlListener)listener).exitProg(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BeetlVisitor ) return ((BeetlVisitor<? extends T>)visitor).visitProg(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgContext prog() throws RecognitionException {
		ProgContext _localctx = new ProgContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_prog);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(97);
			switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
			case 1:
				{
				setState(96); statements();
				}
				break;
			}
			setState(99); match(EOF);
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

	public static class StatementsContext extends ParserRuleContext {
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public StatementsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statements; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BeetlListener ) ((BeetlListener)listener).enterStatements(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BeetlListener ) ((BeetlListener)listener).exitStatements(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BeetlVisitor ) return ((BeetlVisitor<? extends T>)visitor).visitStatements(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementsContext statements() throws RecognitionException {
		StatementsContext _localctx = new StatementsContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_statements);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(102); 
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(101); statement();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(104); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			} while ( _alt!=2 && _alt!=-1 );
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
		public SwitchStatmentContext switchStatment() {
			return getRuleContext(SwitchStatmentContext.class,0);
		}
		public TextStatmentContext textStatment() {
			return getRuleContext(TextStatmentContext.class,0);
		}
		public StatmentBlockContext statmentBlock() {
			return getRuleContext(StatmentBlockContext.class,0);
		}
		public ConstantsTextStatmentContext constantsTextStatment() {
			return getRuleContext(ConstantsTextStatmentContext.class,0);
		}
		public MessFunctionContext messFunction() {
			return getRuleContext(MessFunctionContext.class,0);
		}
		public VarDefineContext varDefine() {
			return getRuleContext(VarDefineContext.class,0);
		}
		public DirectiveContext directive() {
			return getRuleContext(DirectiveContext.class,0);
		}
		public ContinueStatmentContext continueStatment() {
			return getRuleContext(ContinueStatmentContext.class,0);
		}
		public WhileStamentContext whileStament() {
			return getRuleContext(WhileStamentContext.class,0);
		}
		public BreakStatmentContext breakStatment() {
			return getRuleContext(BreakStatmentContext.class,0);
		}
		public G_switchStatmentContext g_switchStatment() {
			return getRuleContext(G_switchStatmentContext.class,0);
		}
		public IfStatmentContext ifStatment() {
			return getRuleContext(IfStatmentContext.class,0);
		}
		public ReturnStatmentContext returnStatment() {
			return getRuleContext(ReturnStatmentContext.class,0);
		}
		public ForStatmentContext forStatment() {
			return getRuleContext(ForStatmentContext.class,0);
		}
		public NativeMethodContext nativeMethod() {
			return getRuleContext(NativeMethodContext.class,0);
		}
		public AssignMentContext assignMent() {
			return getRuleContext(AssignMentContext.class,0);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BeetlListener ) ((BeetlListener)listener).enterStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BeetlListener ) ((BeetlListener)listener).exitStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BeetlVisitor ) return ((BeetlVisitor<? extends T>)visitor).visitStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_statement);
		try {
			setState(134);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(106); constantsTextStatment();
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(107); varDefine();
				setState(108); match(25);
				}
				break;

			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(110); assignMent();
				setState(111); match(25);
				}
				break;

			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(113); textStatment();
				}
				break;

			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(114); ifStatment();
				}
				break;

			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(115); forStatment();
				}
				break;

			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(116); whileStament();
				}
				break;

			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(117); statmentBlock();
				}
				break;

			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(118); messFunction();
				}
				break;

			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(119); continueStatment();
				setState(120); match(25);
				}
				break;

			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(122); breakStatment();
				setState(123); match(25);
				}
				break;

			case 12:
				enterOuterAlt(_localctx, 12);
				{
				setState(125); returnStatment();
				setState(126); match(25);
				}
				break;

			case 13:
				enterOuterAlt(_localctx, 13);
				{
				setState(128); switchStatment();
				}
				break;

			case 14:
				enterOuterAlt(_localctx, 14);
				{
				setState(129); g_switchStatment();
				}
				break;

			case 15:
				enterOuterAlt(_localctx, 15);
				{
				setState(130); nativeMethod(true);
				setState(131); match(25);
				}
				break;

			case 16:
				enterOuterAlt(_localctx, 16);
				{
				setState(133); directive();
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

	public static class G_switchStatmentContext extends ParserRuleContext {
		public Token a;
		public ExpContext base;
		public G_caseStatmentContext g_caseStatment(int i) {
			return getRuleContext(G_caseStatmentContext.class,i);
		}
		public List<G_caseStatmentContext> g_caseStatment() {
			return getRuleContexts(G_caseStatmentContext.class);
		}
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public G_defaultStatmentContext g_defaultStatment() {
			return getRuleContext(G_defaultStatmentContext.class,0);
		}
		public G_switchStatmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_g_switchStatment; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BeetlListener ) ((BeetlListener)listener).enterG_switchStatment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BeetlListener ) ((BeetlListener)listener).exitG_switchStatment(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BeetlVisitor ) return ((BeetlVisitor<? extends T>)visitor).visitG_switchStatment(this);
			else return visitor.visitChildren(this);
		}
	}

	public final G_switchStatmentContext g_switchStatment() throws RecognitionException {
		G_switchStatmentContext _localctx = new G_switchStatmentContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_g_switchStatment);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(136); ((G_switchStatmentContext)_localctx).a = match(2);
			setState(141);
			_la = _input.LA(1);
			if (_la==8) {
				{
				setState(137); match(8);
				setState(138); ((G_switchStatmentContext)_localctx).base = exp();
				setState(139); match(20);
				}
			}

			setState(143); match(LEFT_BRACE);
			setState(147);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==18) {
				{
				{
				setState(144); g_caseStatment();
				}
				}
				setState(149);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(151);
			_la = _input.LA(1);
			if (_la==3) {
				{
				setState(150); g_defaultStatment();
				}
			}

			setState(153); match(RIGHT_BRACE);
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
		public Token a;
		public StatementsContext statements() {
			return getRuleContext(StatementsContext.class,0);
		}
		public List<ExpContext> exp() {
			return getRuleContexts(ExpContext.class);
		}
		public ExpContext exp(int i) {
			return getRuleContext(ExpContext.class,i);
		}
		public G_caseStatmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_g_caseStatment; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BeetlListener ) ((BeetlListener)listener).enterG_caseStatment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BeetlListener ) ((BeetlListener)listener).exitG_caseStatment(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BeetlVisitor ) return ((BeetlVisitor<? extends T>)visitor).visitG_caseStatment(this);
			else return visitor.visitChildren(this);
		}
	}

	public final G_caseStatmentContext g_caseStatment() throws RecognitionException {
		G_caseStatmentContext _localctx = new G_caseStatmentContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_g_caseStatment);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(155); ((G_caseStatmentContext)_localctx).a = match(18);
			setState(156); exp();
			setState(161);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==4) {
				{
				{
				setState(157); match(4);
				setState(158); exp();
				}
				}
				setState(163);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(164); match(9);
			setState(165); statements();
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
		public Token a;
		public StatementsContext statements() {
			return getRuleContext(StatementsContext.class,0);
		}
		public G_defaultStatmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_g_defaultStatment; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BeetlListener ) ((BeetlListener)listener).enterG_defaultStatment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BeetlListener ) ((BeetlListener)listener).exitG_defaultStatment(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BeetlVisitor ) return ((BeetlVisitor<? extends T>)visitor).visitG_defaultStatment(this);
			else return visitor.visitChildren(this);
		}
	}

	public final G_defaultStatmentContext g_defaultStatment() throws RecognitionException {
		G_defaultStatmentContext _localctx = new G_defaultStatmentContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_g_defaultStatment);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(167); ((G_defaultStatmentContext)_localctx).a = match(3);
			setState(168); match(9);
			setState(169); statements();
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

	public static class DirectiveContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(BeetlParser.Identifier, 0); }
		public TerminalNode StringLiteral() { return getToken(BeetlParser.StringLiteral, 0); }
		public DirectiveContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_directive; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BeetlListener ) ((BeetlListener)listener).enterDirective(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BeetlListener ) ((BeetlListener)listener).exitDirective(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BeetlVisitor ) return ((BeetlVisitor<? extends T>)visitor).visitDirective(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DirectiveContext directive() throws RecognitionException {
		DirectiveContext _localctx = new DirectiveContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_directive);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(171); match(26);
			setState(172); match(Identifier);
			setState(174);
			_la = _input.LA(1);
			if (_la==StringLiteral) {
				{
				setState(173); match(StringLiteral);
				}
			}

			setState(176); match(25);
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

	public static class ReturnStatmentContext extends ParserRuleContext {
		public ReturnStatmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_returnStatment; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BeetlListener ) ((BeetlListener)listener).enterReturnStatment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BeetlListener ) ((BeetlListener)listener).exitReturnStatment(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BeetlVisitor ) return ((BeetlVisitor<? extends T>)visitor).visitReturnStatment(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ReturnStatmentContext returnStatment() throws RecognitionException {
		ReturnStatmentContext _localctx = new ReturnStatmentContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_returnStatment);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(178); match(24);
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

	public static class ContinueStatmentContext extends ParserRuleContext {
		public ContinueStatmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_continueStatment; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BeetlListener ) ((BeetlListener)listener).enterContinueStatment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BeetlListener ) ((BeetlListener)listener).exitContinueStatment(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BeetlVisitor ) return ((BeetlVisitor<? extends T>)visitor).visitContinueStatment(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ContinueStatmentContext continueStatment() throws RecognitionException {
		ContinueStatmentContext _localctx = new ContinueStatmentContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_continueStatment);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(180); match(11);
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

	public static class BreakStatmentContext extends ParserRuleContext {
		public BreakStatmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_breakStatment; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BeetlListener ) ((BeetlListener)listener).enterBreakStatment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BeetlListener ) ((BeetlListener)listener).exitBreakStatment(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BeetlVisitor ) return ((BeetlVisitor<? extends T>)visitor).visitBreakStatment(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BreakStatmentContext breakStatment() throws RecognitionException {
		BreakStatmentContext _localctx = new BreakStatmentContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_breakStatment);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(182); match(14);
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

	public static class MessFunctionContext extends ParserRuleContext {
		public FunctionCallContext functionCall() {
			return getRuleContext(FunctionCallContext.class,0);
		}
		public TextProcessFunctionContext textProcessFunction() {
			return getRuleContext(TextProcessFunctionContext.class,0);
		}
		public MessFunctionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_messFunction; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BeetlListener ) ((BeetlListener)listener).enterMessFunction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BeetlListener ) ((BeetlListener)listener).exitMessFunction(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BeetlVisitor ) return ((BeetlVisitor<? extends T>)visitor).visitMessFunction(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MessFunctionContext messFunction() throws RecognitionException {
		MessFunctionContext _localctx = new MessFunctionContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_messFunction);
		try {
			setState(189);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(184);
				if (!(isTextProcessFunction(input))) throw new FailedPredicateException(this, "isTextProcessFunction(input)");
				setState(185); textProcessFunction();
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(186); functionCall(true);
				setState(187); match(25);
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

	public static class TextProcessFunctionContext extends ParserRuleContext {
		public Token a;
		public StatmentBlockContext statmentBlock() {
			return getRuleContext(StatmentBlockContext.class,0);
		}
		public FunctionFullNameContext functionFullName() {
			return getRuleContext(FunctionFullNameContext.class,0);
		}
		public List<ExpContext> exp() {
			return getRuleContexts(ExpContext.class);
		}
		public ExpContext exp(int i) {
			return getRuleContext(ExpContext.class,i);
		}
		public TextProcessFunctionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_textProcessFunction; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BeetlListener ) ((BeetlListener)listener).enterTextProcessFunction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BeetlListener ) ((BeetlListener)listener).exitTextProcessFunction(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BeetlVisitor ) return ((BeetlVisitor<? extends T>)visitor).visitTextProcessFunction(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TextProcessFunctionContext textProcessFunction() throws RecognitionException {
		TextProcessFunctionContext _localctx = new TextProcessFunctionContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_textProcessFunction);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(191); functionFullName();
			setState(192); ((TextProcessFunctionContext)_localctx).a = match(8);
			setState(201);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				{
				setState(193); exp();
				setState(198);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==4) {
					{
					{
					setState(194); match(4);
					setState(195); exp();
					}
					}
					setState(200);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			}
			setState(203); match(20);
			setState(204); statmentBlock();
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
		public boolean statmentCall;
		public Token a;
		public FunctionFullNameContext functionFullName() {
			return getRuleContext(FunctionFullNameContext.class,0);
		}
		public List<ExpContext> exp() {
			return getRuleContexts(ExpContext.class);
		}
		public ExpContext exp(int i) {
			return getRuleContext(ExpContext.class,i);
		}
		public FunctionCallContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public FunctionCallContext(ParserRuleContext parent, int invokingState, boolean statmentCall) {
			super(parent, invokingState);
			this.statmentCall = statmentCall;
		}
		@Override public int getRuleIndex() { return RULE_functionCall; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BeetlListener ) ((BeetlListener)listener).enterFunctionCall(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BeetlListener ) ((BeetlListener)listener).exitFunctionCall(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BeetlVisitor ) return ((BeetlVisitor<? extends T>)visitor).visitFunctionCall(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionCallContext functionCall(boolean statmentCall) throws RecognitionException {
		FunctionCallContext _localctx = new FunctionCallContext(_ctx, getState(), statmentCall);
		enterRule(_localctx, 24, RULE_functionCall);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(206); functionFullName();
			setState(207); ((FunctionCallContext)_localctx).a = match(8);
			setState(216);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				{
				setState(208); exp();
				setState(213);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==4) {
					{
					{
					setState(209); match(4);
					setState(210); exp();
					}
					}
					setState(215);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			}
			setState(218); match(20);
			}

					if(isStrictMVC){
						throw new MVCStrictException(_localctx.start);			
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

	public static class StatmentBlockContext extends ParserRuleContext {
		public TerminalNode RIGHT_BRACE() { return getToken(BeetlParser.RIGHT_BRACE, 0); }
		public StatementsContext statements() {
			return getRuleContext(StatementsContext.class,0);
		}
		public TerminalNode LEFT_BRACE() { return getToken(BeetlParser.LEFT_BRACE, 0); }
		public StatmentBlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statmentBlock; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BeetlListener ) ((BeetlListener)listener).enterStatmentBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BeetlListener ) ((BeetlListener)listener).exitStatmentBlock(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BeetlVisitor ) return ((BeetlVisitor<? extends T>)visitor).visitStatmentBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatmentBlockContext statmentBlock() throws RecognitionException {
		StatmentBlockContext _localctx = new StatmentBlockContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_statmentBlock);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(220); match(LEFT_BRACE);
			setState(222);
			switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
			case 1:
				{
				setState(221); statements();
				}
				break;
			}
			setState(224); match(RIGHT_BRACE);
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

	public static class ForStatmentContext extends ParserRuleContext {
		public Token a;
		public ExpContext aaa;
		public StatmentBlockContext c;
		public StatmentBlockContext d;
		public StatmentBlockContext statmentBlock(int i) {
			return getRuleContext(StatmentBlockContext.class,i);
		}
		public List<StatmentBlockContext> statmentBlock() {
			return getRuleContexts(StatmentBlockContext.class);
		}
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public TerminalNode Identifier() { return getToken(BeetlParser.Identifier, 0); }
		public ForStatmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forStatment; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BeetlListener ) ((BeetlListener)listener).enterForStatment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BeetlListener ) ((BeetlListener)listener).exitForStatment(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BeetlVisitor ) return ((BeetlVisitor<? extends T>)visitor).visitForStatment(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ForStatmentContext forStatment() throws RecognitionException {
		ForStatmentContext _localctx = new ForStatmentContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_forStatment);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(226); match(21);
			setState(227); match(8);
			setState(228); ((ForStatmentContext)_localctx).a = match(Identifier);
			setState(229); match(13);
			setState(230); ((ForStatmentContext)_localctx).aaa = exp();
			setState(231); match(20);
			setState(232); ((ForStatmentContext)_localctx).c = statmentBlock();
			setState(235);
			switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
			case 1:
				{
				setState(233); match(7);
				setState(234); ((ForStatmentContext)_localctx).d = statmentBlock();
				}
				break;
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

	public static class WhileStamentContext extends ParserRuleContext {
		public CondExpContext a;
		public CondExpContext condExp() {
			return getRuleContext(CondExpContext.class,0);
		}
		public StatmentBlockContext statmentBlock() {
			return getRuleContext(StatmentBlockContext.class,0);
		}
		public WhileStamentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_whileStament; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BeetlListener ) ((BeetlListener)listener).enterWhileStament(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BeetlListener ) ((BeetlListener)listener).exitWhileStament(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BeetlVisitor ) return ((BeetlVisitor<? extends T>)visitor).visitWhileStament(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WhileStamentContext whileStament() throws RecognitionException {
		WhileStamentContext _localctx = new WhileStamentContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_whileStament);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(237); match(5);
			setState(238); match(8);
			setState(239); ((WhileStamentContext)_localctx).a = condExp();
			setState(240); match(20);
			setState(241); statmentBlock();
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

	public static class IfStatmentContext extends ParserRuleContext {
		public StatementContext l;
		public StatementContext n;
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public CondExpContext condExp() {
			return getRuleContext(CondExpContext.class,0);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public IfStatmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifStatment; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BeetlListener ) ((BeetlListener)listener).enterIfStatment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BeetlListener ) ((BeetlListener)listener).exitIfStatment(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BeetlVisitor ) return ((BeetlVisitor<? extends T>)visitor).visitIfStatment(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IfStatmentContext ifStatment() throws RecognitionException {
		IfStatmentContext _localctx = new IfStatmentContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_ifStatment);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(243); match(10);
			setState(244); match(8);
			setState(245); condExp();
			setState(246); match(20);
			setState(247); ((IfStatmentContext)_localctx).l = statement();
			setState(250);
			switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
			case 1:
				{
				setState(248); match(16);
				setState(249); ((IfStatmentContext)_localctx).n = statement();
				}
				break;
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

	public static class ConstantsTextStatmentContext extends ParserRuleContext {
		public TerminalNode RIGHT_TOKEN() { return getToken(BeetlParser.RIGHT_TOKEN, 0); }
		public TerminalNode Identifier() { return getToken(BeetlParser.Identifier, 0); }
		public TerminalNode LEFT_TEXT_TOKEN() { return getToken(BeetlParser.LEFT_TEXT_TOKEN, 0); }
		public ConstantsTextStatmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constantsTextStatment; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BeetlListener ) ((BeetlListener)listener).enterConstantsTextStatment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BeetlListener ) ((BeetlListener)listener).exitConstantsTextStatment(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BeetlVisitor ) return ((BeetlVisitor<? extends T>)visitor).visitConstantsTextStatment(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConstantsTextStatmentContext constantsTextStatment() throws RecognitionException {
		ConstantsTextStatmentContext _localctx = new ConstantsTextStatmentContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_constantsTextStatment);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(252); match(LEFT_TEXT_TOKEN);
			setState(253); match(Identifier);
			setState(254); match(RIGHT_TOKEN);
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

	public static class TextStatmentContext extends ParserRuleContext {
		public TextVarContext textVar() {
			return getRuleContext(TextVarContext.class,0);
		}
		public TerminalNode RIGHT_TOKEN() { return getToken(BeetlParser.RIGHT_TOKEN, 0); }
		public TerminalNode LEFT_TOKEN() { return getToken(BeetlParser.LEFT_TOKEN, 0); }
		public TextStatmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_textStatment; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BeetlListener ) ((BeetlListener)listener).enterTextStatment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BeetlListener ) ((BeetlListener)listener).exitTextStatment(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BeetlVisitor ) return ((BeetlVisitor<? extends T>)visitor).visitTextStatment(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TextStatmentContext textStatment() throws RecognitionException {
		TextStatmentContext _localctx = new TextStatmentContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_textStatment);
		try {
			setState(266);
			switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(256); match(LEFT_TOKEN);
				setState(257); textVar();
				setState(258); match(RIGHT_TOKEN);
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(260); match(LEFT_TOKEN);
				setState(261); match(15);
				setState(262); textVar();
				setState(263); match(20);
				setState(264); match(RIGHT_TOKEN);
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

	public static class TextVarContext extends ParserRuleContext {
		public ExpContext b;
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public TextformatContext textformat() {
			return getRuleContext(TextformatContext.class,0);
		}
		public TextVarContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_textVar; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BeetlListener ) ((BeetlListener)listener).enterTextVar(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BeetlListener ) ((BeetlListener)listener).exitTextVar(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BeetlVisitor ) return ((BeetlVisitor<? extends T>)visitor).visitTextVar(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TextVarContext textVar() throws RecognitionException {
		TextVarContext _localctx = new TextVarContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_textVar);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(268); ((TextVarContext)_localctx).b = exp();
			setState(271);
			_la = _input.LA(1);
			if (_la==4) {
				{
				setState(269); match(4);
				setState(270); textformat();
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

	public static class TextformatContext extends ParserRuleContext {
		public FunctionFullNameContext fm;
		public FunctionFullNameContext functionFullName() {
			return getRuleContext(FunctionFullNameContext.class,0);
		}
		public TerminalNode StringLiteral() { return getToken(BeetlParser.StringLiteral, 0); }
		public TextformatContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_textformat; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BeetlListener ) ((BeetlListener)listener).enterTextformat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BeetlListener ) ((BeetlListener)listener).exitTextformat(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BeetlVisitor ) return ((BeetlVisitor<? extends T>)visitor).visitTextformat(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TextformatContext textformat() throws RecognitionException {
		TextformatContext _localctx = new TextformatContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_textformat);
		int _la;
		try {
			setState(279);
			switch (_input.LA(1)) {
			case Identifier:
				enterOuterAlt(_localctx, 1);
				{
				setState(273); ((TextformatContext)_localctx).fm = functionFullName();
				setState(276);
				_la = _input.LA(1);
				if (_la==23) {
					{
					setState(274); match(23);
					setState(275); match(StringLiteral);
					}
				}

				}
				break;
			case StringLiteral:
				enterOuterAlt(_localctx, 2);
				{
				setState(278); match(StringLiteral);
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

	public static class VarDefineContext extends ParserRuleContext {
		public Token a;
		public TerminalNode VAR() { return getToken(BeetlParser.VAR, 0); }
		public VarAssignMentContext varAssignMent(int i) {
			return getRuleContext(VarAssignMentContext.class,i);
		}
		public List<VarAssignMentContext> varAssignMent() {
			return getRuleContexts(VarAssignMentContext.class);
		}
		public VarDefineContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varDefine; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BeetlListener ) ((BeetlListener)listener).enterVarDefine(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BeetlListener ) ((BeetlListener)listener).exitVarDefine(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BeetlVisitor ) return ((BeetlVisitor<? extends T>)visitor).visitVarDefine(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VarDefineContext varDefine() throws RecognitionException {
		VarDefineContext _localctx = new VarDefineContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_varDefine);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(281); ((VarDefineContext)_localctx).a = match(VAR);
			/*if(isStrictMVC)	throw new MVCStrictException($a);*/
			setState(283); varAssignMent();
			setState(288);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==4) {
				{
				{
				setState(284); match(4);
				setState(285); varAssignMent();
				}
				}
				setState(290);
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

	public static class VarAssignMentContext extends ParserRuleContext {
		public Token a;
		public StatmentBlockContext statmentBlock() {
			return getRuleContext(StatmentBlockContext.class,0);
		}
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public TerminalNode Identifier() { return getToken(BeetlParser.Identifier, 0); }
		public VarAssignMentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varAssignMent; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BeetlListener ) ((BeetlListener)listener).enterVarAssignMent(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BeetlListener ) ((BeetlListener)listener).exitVarAssignMent(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BeetlVisitor ) return ((BeetlVisitor<? extends T>)visitor).visitVarAssignMent(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VarAssignMentContext varAssignMent() throws RecognitionException {
		VarAssignMentContext _localctx = new VarAssignMentContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_varAssignMent);
		try {
			setState(298);
			switch ( getInterpreter().adaptivePredict(_input,21,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(291); ((VarAssignMentContext)_localctx).a = match(Identifier);
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(292); match(Identifier);
				setState(293); match(23);
				setState(294); exp();
				}
				break;

			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(295); match(Identifier);
				setState(296); match(23);
				setState(297); statmentBlock();
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

	public static class AssignMentContext extends ParserRuleContext {
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public TerminalNode Identifier() { return getToken(BeetlParser.Identifier, 0); }
		public AssignMentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignMent; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BeetlListener ) ((BeetlListener)listener).enterAssignMent(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BeetlListener ) ((BeetlListener)listener).exitAssignMent(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BeetlVisitor ) return ((BeetlVisitor<? extends T>)visitor).visitAssignMent(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssignMentContext assignMent() throws RecognitionException {
		AssignMentContext _localctx = new AssignMentContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_assignMent);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(300); match(Identifier);
			setState(301); match(23);
			setState(302); exp();
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

	public static class VarRefContext extends ParserRuleContext {
		public Token Identifier;
		public SafeOutputContext safeOutput() {
			return getRuleContext(SafeOutputContext.class,0);
		}
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
			if ( listener instanceof BeetlListener ) ((BeetlListener)listener).enterVarRef(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BeetlListener ) ((BeetlListener)listener).exitVarRef(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BeetlVisitor ) return ((BeetlVisitor<? extends T>)visitor).visitVarRef(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VarRefContext varRef() throws RecognitionException {
		VarRefContext _localctx = new VarRefContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_varRef);
		int _la;
		try {
			setState(317);
			switch ( getInterpreter().adaptivePredict(_input,24,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(304);
				if (!(input.LT(1).getText().startsWith("__V"))) throw new FailedPredicateException(this, "input.LT(1).getText().startsWith(\"__V\")");
				setState(305); match(Identifier);
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(306); ((VarRefContext)_localctx).Identifier = match(Identifier);
				 /*if(((VarRefContext)_localctx).Identifier.getText().startsWith("__"))throw new RuntimeException("Can Not call this Variable star with __"); */
				setState(311);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 6) | (1L << 17) | (1L << 19))) != 0)) {
					{
					{
					setState(308); varAttribute();
					}
					}
					setState(313);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(315);
				_la = _input.LA(1);
				if (_la==28) {
					{
					setState(314); safeOutput();
					}
				}

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

	public static class SafeOutputContext extends ParserRuleContext {
		public AtomContext b;
		public AtomContext atom() {
			return getRuleContext(AtomContext.class,0);
		}
		public SafeOutputContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_safeOutput; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BeetlListener ) ((BeetlListener)listener).enterSafeOutput(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BeetlListener ) ((BeetlListener)listener).exitSafeOutput(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BeetlVisitor ) return ((BeetlVisitor<? extends T>)visitor).visitSafeOutput(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SafeOutputContext safeOutput() throws RecognitionException {
		SafeOutputContext _localctx = new SafeOutputContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_safeOutput);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(319); match(28);
			setState(321);
			switch ( getInterpreter().adaptivePredict(_input,25,_ctx) ) {
			case 1:
				{
				setState(320); ((SafeOutputContext)_localctx).b = atom();
				}
				break;
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
		public Token a;
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public TerminalNode Identifier() { return getToken(BeetlParser.Identifier, 0); }
		public VarAttributeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varAttribute; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BeetlListener ) ((BeetlListener)listener).enterVarAttribute(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BeetlListener ) ((BeetlListener)listener).exitVarAttribute(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BeetlVisitor ) return ((BeetlVisitor<? extends T>)visitor).visitVarAttribute(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VarAttributeContext varAttribute() throws RecognitionException {
		VarAttributeContext _localctx = new VarAttributeContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_varAttribute);
		try {
			setState(331);
			switch (_input.LA(1)) {
			case 19:
				enterOuterAlt(_localctx, 1);
				{
				setState(323); match(19);
				setState(324); match(Identifier);
				}
				break;
			case 17:
				enterOuterAlt(_localctx, 2);
				{
				setState(325); match(17);
				setState(326); match(Identifier);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 3);
				{
				setState(327); ((VarAttributeContext)_localctx).a = match(6);
				setState(328); exp();
				setState(329); match(1);
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

	public static class ExpContext extends ParserRuleContext {
		public CondExpContext condExp() {
			return getRuleContext(CondExpContext.class,0);
		}
		public ExpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BeetlListener ) ((BeetlListener)listener).enterExp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BeetlListener ) ((BeetlListener)listener).exitExp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BeetlVisitor ) return ((BeetlVisitor<? extends T>)visitor).visitExp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpContext exp() throws RecognitionException {
		ExpContext _localctx = new ExpContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_exp);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(333); condExp();
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

	public static class CondExpContext extends ParserRuleContext {
		public ConditionalOrExpressionContext c;
		public ExpContext a;
		public ExpContext b;
		public ConditionalOrExpressionContext conditionalOrExpression() {
			return getRuleContext(ConditionalOrExpressionContext.class,0);
		}
		public List<ExpContext> exp() {
			return getRuleContexts(ExpContext.class);
		}
		public ExpContext exp(int i) {
			return getRuleContext(ExpContext.class,i);
		}
		public CondExpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_condExp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BeetlListener ) ((BeetlListener)listener).enterCondExp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BeetlListener ) ((BeetlListener)listener).exitCondExp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BeetlVisitor ) return ((BeetlVisitor<? extends T>)visitor).visitCondExp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CondExpContext condExp() throws RecognitionException {
		CondExpContext _localctx = new CondExpContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_condExp);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(335); ((CondExpContext)_localctx).c = conditionalOrExpression();
			setState(344);
			_la = _input.LA(1);
			if (_la==12) {
				{
				setState(336); match(12);
				setState(338);
				switch ( getInterpreter().adaptivePredict(_input,27,_ctx) ) {
				case 1:
					{
					setState(337); ((CondExpContext)_localctx).a = exp();
					}
					break;
				}
				setState(340); match(9);
				setState(342);
				switch ( getInterpreter().adaptivePredict(_input,28,_ctx) ) {
				case 1:
					{
					setState(341); ((CondExpContext)_localctx).b = exp();
					}
					break;
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

	public static class ConditionalOrExpressionContext extends ParserRuleContext {
		public List<TerminalNode> OR() { return getTokens(BeetlParser.OR); }
		public ConditionalAndExpressionContext conditionalAndExpression(int i) {
			return getRuleContext(ConditionalAndExpressionContext.class,i);
		}
		public List<ConditionalAndExpressionContext> conditionalAndExpression() {
			return getRuleContexts(ConditionalAndExpressionContext.class);
		}
		public TerminalNode OR(int i) {
			return getToken(BeetlParser.OR, i);
		}
		public ConditionalOrExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_conditionalOrExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BeetlListener ) ((BeetlListener)listener).enterConditionalOrExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BeetlListener ) ((BeetlListener)listener).exitConditionalOrExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BeetlVisitor ) return ((BeetlVisitor<? extends T>)visitor).visitConditionalOrExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConditionalOrExpressionContext conditionalOrExpression() throws RecognitionException {
		ConditionalOrExpressionContext _localctx = new ConditionalOrExpressionContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_conditionalOrExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(346); conditionalAndExpression();
			setState(351);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==OR) {
				{
				{
				setState(347); match(OR);
				setState(348); conditionalAndExpression();
				}
				}
				setState(353);
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

	public static class ConditionalAndExpressionContext extends ParserRuleContext {
		public List<CondExpNotItemContext> condExpNotItem() {
			return getRuleContexts(CondExpNotItemContext.class);
		}
		public List<TerminalNode> AND() { return getTokens(BeetlParser.AND); }
		public CondExpNotItemContext condExpNotItem(int i) {
			return getRuleContext(CondExpNotItemContext.class,i);
		}
		public TerminalNode AND(int i) {
			return getToken(BeetlParser.AND, i);
		}
		public ConditionalAndExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_conditionalAndExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BeetlListener ) ((BeetlListener)listener).enterConditionalAndExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BeetlListener ) ((BeetlListener)listener).exitConditionalAndExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BeetlVisitor ) return ((BeetlVisitor<? extends T>)visitor).visitConditionalAndExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConditionalAndExpressionContext conditionalAndExpression() throws RecognitionException {
		ConditionalAndExpressionContext _localctx = new ConditionalAndExpressionContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_conditionalAndExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(354); condExpNotItem();
			setState(359);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==AND) {
				{
				{
				setState(355); match(AND);
				setState(356); condExpNotItem();
				}
				}
				setState(361);
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

	public static class CondExpNotItemContext extends ParserRuleContext {
		public CondExpItemContext condExpItem() {
			return getRuleContext(CondExpItemContext.class,0);
		}
		public CondExpNotItemContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_condExpNotItem; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BeetlListener ) ((BeetlListener)listener).enterCondExpNotItem(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BeetlListener ) ((BeetlListener)listener).exitCondExpNotItem(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BeetlVisitor ) return ((BeetlVisitor<? extends T>)visitor).visitCondExpNotItem(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CondExpNotItemContext condExpNotItem() throws RecognitionException {
		CondExpNotItemContext _localctx = new CondExpNotItemContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_condExpNotItem);
		try {
			setState(365);
			switch ( getInterpreter().adaptivePredict(_input,32,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(362); condExpItem();
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				{
				setState(363); match(28);
				}
				setState(364); condExpItem();
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

	public static class CondExpItemContext extends ParserRuleContext {
		public Token a;
		public AexprContext l;
		public TerminalNode LARGE() { return getToken(BeetlParser.LARGE, 0); }
		public TerminalNode LESS_EQUAL() { return getToken(BeetlParser.LESS_EQUAL, 0); }
		public TerminalNode LESS() { return getToken(BeetlParser.LESS, 0); }
		public TerminalNode LARGE_EQUAL() { return getToken(BeetlParser.LARGE_EQUAL, 0); }
		public TerminalNode EQUAL() { return getToken(BeetlParser.EQUAL, 0); }
		public List<AexprContext> aexpr() {
			return getRuleContexts(AexprContext.class);
		}
		public TerminalNode NOT_EQUAL() { return getToken(BeetlParser.NOT_EQUAL, 0); }
		public AexprContext aexpr(int i) {
			return getRuleContext(AexprContext.class,i);
		}
		public CondExpItemContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_condExpItem; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BeetlListener ) ((BeetlListener)listener).enterCondExpItem(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BeetlListener ) ((BeetlListener)listener).exitCondExpItem(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BeetlVisitor ) return ((BeetlVisitor<? extends T>)visitor).visitCondExpItem(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CondExpItemContext condExpItem() throws RecognitionException {
		CondExpItemContext _localctx = new CondExpItemContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_condExpItem);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(367); aexpr();
			setState(378);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << EQUAL) | (1L << NOT_EQUAL) | (1L << LARGE) | (1L << LARGE_EQUAL) | (1L << LESS) | (1L << LESS_EQUAL))) != 0)) {
				{
				setState(374);
				switch (_input.LA(1)) {
				case EQUAL:
					{
					setState(368); ((CondExpItemContext)_localctx).a = match(EQUAL);
					}
					break;
				case NOT_EQUAL:
					{
					setState(369); ((CondExpItemContext)_localctx).a = match(NOT_EQUAL);
					}
					break;
				case LARGE:
					{
					setState(370); ((CondExpItemContext)_localctx).a = match(LARGE);
					}
					break;
				case LARGE_EQUAL:
					{
					setState(371); ((CondExpItemContext)_localctx).a = match(LARGE_EQUAL);
					}
					break;
				case LESS:
					{
					setState(372); ((CondExpItemContext)_localctx).a = match(LESS);
					}
					break;
				case LESS_EQUAL:
					{
					setState(373); ((CondExpItemContext)_localctx).a = match(LESS_EQUAL);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				 /*if(isStrictMVC)	throw new MVCStrictException(((CondExpItemContext)_localctx).a);*/
				setState(377); ((CondExpItemContext)_localctx).l = aexpr();
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

	public static class AexprContext extends ParserRuleContext {
		public Token a;
		public List<MexprContext> mexpr() {
			return getRuleContexts(MexprContext.class);
		}
		public TerminalNode MINUS() { return getToken(BeetlParser.MINUS, 0); }
		public MexprContext mexpr(int i) {
			return getRuleContext(MexprContext.class,i);
		}
		public TerminalNode ADD() { return getToken(BeetlParser.ADD, 0); }
		public AexprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_aexpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BeetlListener ) ((BeetlListener)listener).enterAexpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BeetlListener ) ((BeetlListener)listener).exitAexpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BeetlVisitor ) return ((BeetlVisitor<? extends T>)visitor).visitAexpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AexprContext aexpr() throws RecognitionException {
		AexprContext _localctx = new AexprContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_aexpr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(380); mexpr();
			setState(388);
			_la = _input.LA(1);
			if (_la==ADD || _la==MINUS) {
				{
				setState(383);
				switch (_input.LA(1)) {
				case ADD:
					{
					setState(381); ((AexprContext)_localctx).a = match(ADD);
					}
					break;
				case MINUS:
					{
					setState(382); ((AexprContext)_localctx).a = match(MINUS);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(385); mexpr();
				/*if(isStrictMVC)	throw new MVCStrictException($a);*/
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

	public static class MexprContext extends ParserRuleContext {
		public Token a;
		public TerminalNode DIV() { return getToken(BeetlParser.DIV, 0); }
		public List<UnaryAtomContext> unaryAtom() {
			return getRuleContexts(UnaryAtomContext.class);
		}
		public TerminalNode MULTIP() { return getToken(BeetlParser.MULTIP, 0); }
		public UnaryAtomContext unaryAtom(int i) {
			return getRuleContext(UnaryAtomContext.class,i);
		}
		public TerminalNode MOD() { return getToken(BeetlParser.MOD, 0); }
		public MexprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mexpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BeetlListener ) ((BeetlListener)listener).enterMexpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BeetlListener ) ((BeetlListener)listener).exitMexpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BeetlVisitor ) return ((BeetlVisitor<? extends T>)visitor).visitMexpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MexprContext mexpr() throws RecognitionException {
		MexprContext _localctx = new MexprContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_mexpr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(390); unaryAtom();
			setState(398);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << MULTIP) | (1L << DIV) | (1L << MOD))) != 0)) {
				{
				setState(394);
				switch (_input.LA(1)) {
				case MULTIP:
					{
					setState(391); ((MexprContext)_localctx).a = match(MULTIP);
					}
					break;
				case DIV:
					{
					setState(392); ((MexprContext)_localctx).a = match(DIV);
					}
					break;
				case MOD:
					{
					setState(393); ((MexprContext)_localctx).a = match(MOD);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				if(isStrictMVC)	throw new MVCStrictException(((MexprContext)_localctx).a);
				setState(397); unaryAtom();
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

	public static class AtomContext extends ParserRuleContext {
		public Token a;
		public TerminalNode BOOLEAN() { return getToken(BeetlParser.BOOLEAN, 0); }
		public FunctionCallContext functionCall() {
			return getRuleContext(FunctionCallContext.class,0);
		}
		public VarRefContext varRef() {
			return getRuleContext(VarRefContext.class,0);
		}
		public TerminalNode INT() { return getToken(BeetlParser.INT, 0); }
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public NativeMethodContext nativeMethod() {
			return getRuleContext(NativeMethodContext.class,0);
		}
		public TerminalNode DOUBLE() { return getToken(BeetlParser.DOUBLE, 0); }
		public JsonContext json() {
			return getRuleContext(JsonContext.class,0);
		}
		public TerminalNode StringLiteral() { return getToken(BeetlParser.StringLiteral, 0); }
		public TerminalNode NULL() { return getToken(BeetlParser.NULL, 0); }
		public AtomContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_atom; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BeetlListener ) ((BeetlListener)listener).enterAtom(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BeetlListener ) ((BeetlListener)listener).exitAtom(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BeetlVisitor ) return ((BeetlVisitor<? extends T>)visitor).visitAtom(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AtomContext atom() throws RecognitionException {
		AtomContext _localctx = new AtomContext(_ctx, getState());
		enterRule(_localctx, 70, RULE_atom);
		try {
			setState(413);
			switch ( getInterpreter().adaptivePredict(_input,39,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(400); match(BOOLEAN);
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(401); match(INT);
				}
				break;

			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(402); match(NULL);
				}
				break;

			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(403); match(DOUBLE);
				}
				break;

			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(404); ((AtomContext)_localctx).a = match(StringLiteral);
				}
				break;

			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(405); varRef();
				}
				break;

			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(406); match(8);
				setState(407); exp();
				setState(408); match(20);
				}
				break;

			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(410); functionCall(false);
				}
				break;

			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(411); nativeMethod(false);
				}
				break;

			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(412); json();
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

	public static class UnaryAtomContext extends ParserRuleContext {
		public AtomContext a;
		public TerminalNode MINUS() { return getToken(BeetlParser.MINUS, 0); }
		public TerminalNode ADD() { return getToken(BeetlParser.ADD, 0); }
		public AtomContext atom() {
			return getRuleContext(AtomContext.class,0);
		}
		public UnaryAtomContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unaryAtom; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BeetlListener ) ((BeetlListener)listener).enterUnaryAtom(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BeetlListener ) ((BeetlListener)listener).exitUnaryAtom(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BeetlVisitor ) return ((BeetlVisitor<? extends T>)visitor).visitUnaryAtom(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UnaryAtomContext unaryAtom() throws RecognitionException {
		UnaryAtomContext _localctx = new UnaryAtomContext(_ctx, getState());
		enterRule(_localctx, 72, RULE_unaryAtom);
		try {
			setState(420);
			switch ( getInterpreter().adaptivePredict(_input,40,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(415); atom();
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(416); match(MINUS);
				setState(417); ((UnaryAtomContext)_localctx).a = atom();
				}
				break;

			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(418); match(ADD);
				setState(419); atom();
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

	public static class NativeMethodContext extends ParserRuleContext {
		public boolean statmentCall;
		public Token a;
		public ClassMutileExpContext classMutileExp() {
			return getRuleContext(ClassMutileExpContext.class,0);
		}
		public TerminalNode Identifier(int i) {
			return getToken(BeetlParser.Identifier, i);
		}
		public List<TerminalNode> Identifier() { return getTokens(BeetlParser.Identifier); }
		public NativeMethodContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public NativeMethodContext(ParserRuleContext parent, int invokingState, boolean statmentCall) {
			super(parent, invokingState);
			this.statmentCall = statmentCall;
		}
		@Override public int getRuleIndex() { return RULE_nativeMethod; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BeetlListener ) ((BeetlListener)listener).enterNativeMethod(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BeetlListener ) ((BeetlListener)listener).exitNativeMethod(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BeetlVisitor ) return ((BeetlVisitor<? extends T>)visitor).visitNativeMethod(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NativeMethodContext nativeMethod(boolean statmentCall) throws RecognitionException {
		NativeMethodContext _localctx = new NativeMethodContext(_ctx, getState(), statmentCall);
		enterRule(_localctx, 74, RULE_nativeMethod);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(422); ((NativeMethodContext)_localctx).a = match(22);
			setState(423); match(Identifier);
			setState(428);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,41,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					{
					{
					setState(424); match(19);
					setState(425); match(Identifier);
					}
					} 
				}
				setState(430);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,41,_ctx);
			}
			setState(432);
			_la = _input.LA(1);
			if (_la==6 || _la==19) {
				{
				setState(431); classMutileExp();
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

	public static class ClassMutileExpContext extends ParserRuleContext {
		public ClassNextExpContext classNextExp(int i) {
			return getRuleContext(ClassNextExpContext.class,i);
		}
		public TerminalNode Identifier(int i) {
			return getToken(BeetlParser.Identifier, i);
		}
		public List<TerminalNode> Identifier() { return getTokens(BeetlParser.Identifier); }
		public List<ClassNextExpContext> classNextExp() {
			return getRuleContexts(ClassNextExpContext.class);
		}
		public ClassMutileExpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classMutileExp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BeetlListener ) ((BeetlListener)listener).enterClassMutileExp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BeetlListener ) ((BeetlListener)listener).exitClassMutileExp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BeetlVisitor ) return ((BeetlVisitor<? extends T>)visitor).visitClassMutileExp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ClassMutileExpContext classMutileExp() throws RecognitionException {
		ClassMutileExpContext _localctx = new ClassMutileExpContext(_ctx, getState());
		enterRule(_localctx, 76, RULE_classMutileExp);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(434); classNextExp();
			setState(440);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==6 || _la==19) {
				{
				setState(438);
				switch ( getInterpreter().adaptivePredict(_input,43,_ctx) ) {
				case 1:
					{
					setState(435); classNextExp();
					}
					break;

				case 2:
					{
					setState(436); match(19);
					setState(437); match(Identifier);
					}
					break;
				}
				}
				setState(442);
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

	public static class ClassNextExpContext extends ParserRuleContext {
		public ClassArrayContext classArray() {
			return getRuleContext(ClassArrayContext.class,0);
		}
		public ClassMethodContext classMethod() {
			return getRuleContext(ClassMethodContext.class,0);
		}
		public ClassNextExpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classNextExp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BeetlListener ) ((BeetlListener)listener).enterClassNextExp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BeetlListener ) ((BeetlListener)listener).exitClassNextExp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BeetlVisitor ) return ((BeetlVisitor<? extends T>)visitor).visitClassNextExp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ClassNextExpContext classNextExp() throws RecognitionException {
		ClassNextExpContext _localctx = new ClassNextExpContext(_ctx, getState());
		enterRule(_localctx, 78, RULE_classNextExp);
		try {
			setState(445);
			switch (_input.LA(1)) {
			case 19:
				enterOuterAlt(_localctx, 1);
				{
				setState(443); classMethod();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 2);
				{
				setState(444); classArray();
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

	public static class ClassMethodContext extends ParserRuleContext {
		public List<ExpContext> exp() {
			return getRuleContexts(ExpContext.class);
		}
		public TerminalNode Identifier() { return getToken(BeetlParser.Identifier, 0); }
		public ExpContext exp(int i) {
			return getRuleContext(ExpContext.class,i);
		}
		public ClassMethodContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classMethod; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BeetlListener ) ((BeetlListener)listener).enterClassMethod(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BeetlListener ) ((BeetlListener)listener).exitClassMethod(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BeetlVisitor ) return ((BeetlVisitor<? extends T>)visitor).visitClassMethod(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ClassMethodContext classMethod() throws RecognitionException {
		ClassMethodContext _localctx = new ClassMethodContext(_ctx, getState());
		enterRule(_localctx, 80, RULE_classMethod);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(447); match(19);
			setState(448); match(Identifier);
			setState(449); match(8);
			setState(458);
			switch ( getInterpreter().adaptivePredict(_input,47,_ctx) ) {
			case 1:
				{
				setState(450); exp();
				setState(455);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==4) {
					{
					{
					setState(451); match(4);
					setState(452); exp();
					}
					}
					setState(457);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			}
			setState(460); match(20);
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

	public static class ClassArrayContext extends ParserRuleContext {
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public ClassArrayContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classArray; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BeetlListener ) ((BeetlListener)listener).enterClassArray(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BeetlListener ) ((BeetlListener)listener).exitClassArray(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BeetlVisitor ) return ((BeetlVisitor<? extends T>)visitor).visitClassArray(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ClassArrayContext classArray() throws RecognitionException {
		ClassArrayContext _localctx = new ClassArrayContext(_ctx, getState());
		enterRule(_localctx, 82, RULE_classArray);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(462); match(6);
			setState(463); exp();
			setState(464); match(1);
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

	public static class FunctionFullNameContext extends ParserRuleContext {
		public Token a;
		public TerminalNode Identifier(int i) {
			return getToken(BeetlParser.Identifier, i);
		}
		public List<TerminalNode> Identifier() { return getTokens(BeetlParser.Identifier); }
		public FunctionFullNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionFullName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BeetlListener ) ((BeetlListener)listener).enterFunctionFullName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BeetlListener ) ((BeetlListener)listener).exitFunctionFullName(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BeetlVisitor ) return ((BeetlVisitor<? extends T>)visitor).visitFunctionFullName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionFullNameContext functionFullName() throws RecognitionException {
		FunctionFullNameContext _localctx = new FunctionFullNameContext(_ctx, getState());
		enterRule(_localctx, 84, RULE_functionFullName);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(466); ((FunctionFullNameContext)_localctx).a = match(Identifier);
			setState(469);
			_la = _input.LA(1);
			if (_la==19) {
				{
				setState(467); match(19);
				setState(468); match(Identifier);
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

	public static class SwitchStatmentContext extends ParserRuleContext {
		public Token a;
		public ExpContext base;
		public CaseStatmentContext caseStatment(int i) {
			return getRuleContext(CaseStatmentContext.class,i);
		}
		public List<CaseStatmentContext> caseStatment() {
			return getRuleContexts(CaseStatmentContext.class);
		}
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public DefaultStatmentContext defaultStatment() {
			return getRuleContext(DefaultStatmentContext.class,0);
		}
		public SwitchStatmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_switchStatment; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BeetlListener ) ((BeetlListener)listener).enterSwitchStatment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BeetlListener ) ((BeetlListener)listener).exitSwitchStatment(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BeetlVisitor ) return ((BeetlVisitor<? extends T>)visitor).visitSwitchStatment(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SwitchStatmentContext switchStatment() throws RecognitionException {
		SwitchStatmentContext _localctx = new SwitchStatmentContext(_ctx, getState());
		enterRule(_localctx, 86, RULE_switchStatment);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(471); ((SwitchStatmentContext)_localctx).a = match(27);
			setState(472); match(8);
			setState(473); ((SwitchStatmentContext)_localctx).base = exp();
			setState(474); match(20);
			setState(475); match(LEFT_BRACE);
			setState(479);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==18) {
				{
				{
				setState(476); caseStatment();
				}
				}
				setState(481);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(483);
			_la = _input.LA(1);
			if (_la==3) {
				{
				setState(482); defaultStatment();
				}
			}

			setState(485); match(RIGHT_BRACE);
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

	public static class CaseStatmentContext extends ParserRuleContext {
		public Token a;
		public StatementsContext statements() {
			return getRuleContext(StatementsContext.class,0);
		}
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public CaseStatmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_caseStatment; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BeetlListener ) ((BeetlListener)listener).enterCaseStatment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BeetlListener ) ((BeetlListener)listener).exitCaseStatment(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BeetlVisitor ) return ((BeetlVisitor<? extends T>)visitor).visitCaseStatment(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CaseStatmentContext caseStatment() throws RecognitionException {
		CaseStatmentContext _localctx = new CaseStatmentContext(_ctx, getState());
		enterRule(_localctx, 88, RULE_caseStatment);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(487); ((CaseStatmentContext)_localctx).a = match(18);
			setState(488); exp();
			setState(489); match(9);
			setState(490); statements();
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

	public static class DefaultStatmentContext extends ParserRuleContext {
		public Token a;
		public StatementsContext statements() {
			return getRuleContext(StatementsContext.class,0);
		}
		public DefaultStatmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_defaultStatment; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BeetlListener ) ((BeetlListener)listener).enterDefaultStatment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BeetlListener ) ((BeetlListener)listener).exitDefaultStatment(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BeetlVisitor ) return ((BeetlVisitor<? extends T>)visitor).visitDefaultStatment(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DefaultStatmentContext defaultStatment() throws RecognitionException {
		DefaultStatmentContext _localctx = new DefaultStatmentContext(_ctx, getState());
		enterRule(_localctx, 90, RULE_defaultStatment);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(492); ((DefaultStatmentContext)_localctx).a = match(3);
			setState(493); match(9);
			setState(494); statements();
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

	public static class JsonContext extends ParserRuleContext {
		public List<JsonKeyValueContext> jsonKeyValue() {
			return getRuleContexts(JsonKeyValueContext.class);
		}
		public List<ExpContext> exp() {
			return getRuleContexts(ExpContext.class);
		}
		public JsonKeyValueContext jsonKeyValue(int i) {
			return getRuleContext(JsonKeyValueContext.class,i);
		}
		public ExpContext exp(int i) {
			return getRuleContext(ExpContext.class,i);
		}
		public JsonContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_json; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BeetlListener ) ((BeetlListener)listener).enterJson(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BeetlListener ) ((BeetlListener)listener).exitJson(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BeetlVisitor ) return ((BeetlVisitor<? extends T>)visitor).visitJson(this);
			else return visitor.visitChildren(this);
		}
	}

	public final JsonContext json() throws RecognitionException {
		JsonContext _localctx = new JsonContext(_ctx, getState());
		enterRule(_localctx, 92, RULE_json);
		int _la;
		try {
			setState(520);
			switch (_input.LA(1)) {
			case 6:
				enterOuterAlt(_localctx, 1);
				{
				setState(496); match(6);
				setState(505);
				switch ( getInterpreter().adaptivePredict(_input,52,_ctx) ) {
				case 1:
					{
					setState(497); exp();
					setState(502);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==4) {
						{
						{
						setState(498); match(4);
						setState(499); exp();
						}
						}
						setState(504);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
					break;
				}
				setState(507); match(1);
				}
				break;
			case LEFT_BRACE:
				enterOuterAlt(_localctx, 2);
				{
				setState(508); match(LEFT_BRACE);
				setState(517);
				_la = _input.LA(1);
				if (_la==StringLiteral || _la==Identifier) {
					{
					setState(509); jsonKeyValue();
					setState(514);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==4) {
						{
						{
						setState(510); match(4);
						setState(511); jsonKeyValue();
						}
						}
						setState(516);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(519); match(RIGHT_BRACE);
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

	public static class JsonKeyValueContext extends ParserRuleContext {
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public TerminalNode Identifier() { return getToken(BeetlParser.Identifier, 0); }
		public TerminalNode StringLiteral() { return getToken(BeetlParser.StringLiteral, 0); }
		public JsonKeyValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_jsonKeyValue; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BeetlListener ) ((BeetlListener)listener).enterJsonKeyValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BeetlListener ) ((BeetlListener)listener).exitJsonKeyValue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BeetlVisitor ) return ((BeetlVisitor<? extends T>)visitor).visitJsonKeyValue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final JsonKeyValueContext jsonKeyValue() throws RecognitionException {
		JsonKeyValueContext _localctx = new JsonKeyValueContext(_ctx, getState());
		enterRule(_localctx, 94, RULE_jsonKeyValue);
		try {
			setState(528);
			switch (_input.LA(1)) {
			case StringLiteral:
				enterOuterAlt(_localctx, 1);
				{
				setState(522); match(StringLiteral);
				setState(523); match(9);
				setState(524); exp();
				}
				break;
			case Identifier:
				enterOuterAlt(_localctx, 2);
				{
				setState(525); match(Identifier);
				setState(526); match(9);
				setState(527); exp();
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
		case 10: return messFunction_sempred((MessFunctionContext)_localctx, predIndex);

		case 24: return varRef_sempred((VarRefContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean messFunction_sempred(MessFunctionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0: return isTextProcessFunction(input);
		}
		return true;
	}
	private boolean varRef_sempred(VarRefContext _localctx, int predIndex) {
		switch (predIndex) {
		case 1: return input.LT(1).getText().startsWith("__V");
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\uacf5\uee8c\u4f5d\u8b0d\u4a45\u78bd\u1b2f\u3378\3m\u0215\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\3\2\5\2d\n\2\3\2\3\2\3\3\6"+
		"\3i\n\3\r\3\16\3j\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4"+
		"\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\5\4\u0089"+
		"\n\4\3\5\3\5\3\5\3\5\3\5\5\5\u0090\n\5\3\5\3\5\7\5\u0094\n\5\f\5\16\5"+
		"\u0097\13\5\3\5\5\5\u009a\n\5\3\5\3\5\3\6\3\6\3\6\3\6\7\6\u00a2\n\6\f"+
		"\6\16\6\u00a5\13\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\b\3\b\3\b\5\b\u00b1\n"+
		"\b\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3\f\3\f\3\f\3\f\3\f\5\f\u00c0\n\f"+
		"\3\r\3\r\3\r\3\r\3\r\7\r\u00c7\n\r\f\r\16\r\u00ca\13\r\5\r\u00cc\n\r\3"+
		"\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16\7\16\u00d6\n\16\f\16\16\16\u00d9\13"+
		"\16\5\16\u00db\n\16\3\16\3\16\3\17\3\17\5\17\u00e1\n\17\3\17\3\17\3\20"+
		"\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\5\20\u00ee\n\20\3\21\3\21\3\21"+
		"\3\21\3\21\3\21\3\22\3\22\3\22\3\22\3\22\3\22\3\22\5\22\u00fd\n\22\3\23"+
		"\3\23\3\23\3\23\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\5\24"+
		"\u010d\n\24\3\25\3\25\3\25\5\25\u0112\n\25\3\26\3\26\3\26\5\26\u0117\n"+
		"\26\3\26\5\26\u011a\n\26\3\27\3\27\3\27\3\27\3\27\7\27\u0121\n\27\f\27"+
		"\16\27\u0124\13\27\3\30\3\30\3\30\3\30\3\30\3\30\3\30\5\30\u012d\n\30"+
		"\3\31\3\31\3\31\3\31\3\32\3\32\3\32\3\32\3\32\7\32\u0138\n\32\f\32\16"+
		"\32\u013b\13\32\3\32\5\32\u013e\n\32\5\32\u0140\n\32\3\33\3\33\5\33\u0144"+
		"\n\33\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\5\34\u014e\n\34\3\35\3\35"+
		"\3\36\3\36\3\36\5\36\u0155\n\36\3\36\3\36\5\36\u0159\n\36\5\36\u015b\n"+
		"\36\3\37\3\37\3\37\7\37\u0160\n\37\f\37\16\37\u0163\13\37\3 \3 \3 \7 "+
		"\u0168\n \f \16 \u016b\13 \3!\3!\3!\5!\u0170\n!\3\"\3\"\3\"\3\"\3\"\3"+
		"\"\3\"\5\"\u0179\n\"\3\"\3\"\5\"\u017d\n\"\3#\3#\3#\5#\u0182\n#\3#\3#"+
		"\3#\5#\u0187\n#\3$\3$\3$\3$\5$\u018d\n$\3$\3$\5$\u0191\n$\3%\3%\3%\3%"+
		"\3%\3%\3%\3%\3%\3%\3%\3%\3%\5%\u01a0\n%\3&\3&\3&\3&\3&\5&\u01a7\n&\3\'"+
		"\3\'\3\'\3\'\7\'\u01ad\n\'\f\'\16\'\u01b0\13\'\3\'\5\'\u01b3\n\'\3(\3"+
		"(\3(\3(\7(\u01b9\n(\f(\16(\u01bc\13(\3)\3)\5)\u01c0\n)\3*\3*\3*\3*\3*"+
		"\3*\7*\u01c8\n*\f*\16*\u01cb\13*\5*\u01cd\n*\3*\3*\3+\3+\3+\3+\3,\3,\3"+
		",\5,\u01d8\n,\3-\3-\3-\3-\3-\3-\7-\u01e0\n-\f-\16-\u01e3\13-\3-\5-\u01e6"+
		"\n-\3-\3-\3.\3.\3.\3.\3.\3/\3/\3/\3/\3\60\3\60\3\60\3\60\7\60\u01f7\n"+
		"\60\f\60\16\60\u01fa\13\60\5\60\u01fc\n\60\3\60\3\60\3\60\3\60\3\60\7"+
		"\60\u0203\n\60\f\60\16\60\u0206\13\60\5\60\u0208\n\60\3\60\5\60\u020b"+
		"\n\60\3\61\3\61\3\61\3\61\3\61\3\61\5\61\u0213\n\61\3\61\2\62\2\4\6\b"+
		"\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\62\64\668:<>@BDFHJLNPRTVX"+
		"Z\\^`\2\2\u023b\2c\3\2\2\2\4h\3\2\2\2\6\u0088\3\2\2\2\b\u008a\3\2\2\2"+
		"\n\u009d\3\2\2\2\f\u00a9\3\2\2\2\16\u00ad\3\2\2\2\20\u00b4\3\2\2\2\22"+
		"\u00b6\3\2\2\2\24\u00b8\3\2\2\2\26\u00bf\3\2\2\2\30\u00c1\3\2\2\2\32\u00d0"+
		"\3\2\2\2\34\u00de\3\2\2\2\36\u00e4\3\2\2\2 \u00ef\3\2\2\2\"\u00f5\3\2"+
		"\2\2$\u00fe\3\2\2\2&\u010c\3\2\2\2(\u010e\3\2\2\2*\u0119\3\2\2\2,\u011b"+
		"\3\2\2\2.\u012c\3\2\2\2\60\u012e\3\2\2\2\62\u013f\3\2\2\2\64\u0141\3\2"+
		"\2\2\66\u014d\3\2\2\28\u014f\3\2\2\2:\u0151\3\2\2\2<\u015c\3\2\2\2>\u0164"+
		"\3\2\2\2@\u016f\3\2\2\2B\u0171\3\2\2\2D\u017e\3\2\2\2F\u0188\3\2\2\2H"+
		"\u019f\3\2\2\2J\u01a6\3\2\2\2L\u01a8\3\2\2\2N\u01b4\3\2\2\2P\u01bf\3\2"+
		"\2\2R\u01c1\3\2\2\2T\u01d0\3\2\2\2V\u01d4\3\2\2\2X\u01d9\3\2\2\2Z\u01e9"+
		"\3\2\2\2\\\u01ee\3\2\2\2^\u020a\3\2\2\2`\u0212\3\2\2\2bd\5\4\3\2cb\3\2"+
		"\2\2cd\3\2\2\2de\3\2\2\2ef\7\2\2\3f\3\3\2\2\2gi\5\6\4\2hg\3\2\2\2ij\3"+
		"\2\2\2jh\3\2\2\2jk\3\2\2\2k\5\3\2\2\2l\u0089\5$\23\2mn\5,\27\2no\7\33"+
		"\2\2o\u0089\3\2\2\2pq\5\60\31\2qr\7\33\2\2r\u0089\3\2\2\2s\u0089\5&\24"+
		"\2t\u0089\5\"\22\2u\u0089\5\36\20\2v\u0089\5 \21\2w\u0089\5\34\17\2x\u0089"+
		"\5\26\f\2yz\5\22\n\2z{\7\33\2\2{\u0089\3\2\2\2|}\5\24\13\2}~\7\33\2\2"+
		"~\u0089\3\2\2\2\177\u0080\5\20\t\2\u0080\u0081\7\33\2\2\u0081\u0089\3"+
		"\2\2\2\u0082\u0089\5X-\2\u0083\u0089\5\b\5\2\u0084\u0085\5L\'\2\u0085"+
		"\u0086\7\33\2\2\u0086\u0089\3\2\2\2\u0087\u0089\5\16\b\2\u0088l\3\2\2"+
		"\2\u0088m\3\2\2\2\u0088p\3\2\2\2\u0088s\3\2\2\2\u0088t\3\2\2\2\u0088u"+
		"\3\2\2\2\u0088v\3\2\2\2\u0088w\3\2\2\2\u0088x\3\2\2\2\u0088y\3\2\2\2\u0088"+
		"|\3\2\2\2\u0088\177\3\2\2\2\u0088\u0082\3\2\2\2\u0088\u0083\3\2\2\2\u0088"+
		"\u0084\3\2\2\2\u0088\u0087\3\2\2\2\u0089\7\3\2\2\2\u008a\u008f\7\4\2\2"+
		"\u008b\u008c\7\n\2\2\u008c\u008d\58\35\2\u008d\u008e\7\26\2\2\u008e\u0090"+
		"\3\2\2\2\u008f\u008b\3\2\2\2\u008f\u0090\3\2\2\2\u0090\u0091\3\2\2\2\u0091"+
		"\u0095\7\64\2\2\u0092\u0094\5\n\6\2\u0093\u0092\3\2\2\2\u0094\u0097\3"+
		"\2\2\2\u0095\u0093\3\2\2\2\u0095\u0096\3\2\2\2\u0096\u0099\3\2\2\2\u0097"+
		"\u0095\3\2\2\2\u0098\u009a\5\f\7\2\u0099\u0098\3\2\2\2\u0099\u009a\3\2"+
		"\2\2\u009a\u009b\3\2\2\2\u009b\u009c\7\65\2\2\u009c\t\3\2\2\2\u009d\u009e"+
		"\7\24\2\2\u009e\u00a3\58\35\2\u009f\u00a0\7\6\2\2\u00a0\u00a2\58\35\2"+
		"\u00a1\u009f\3\2\2\2\u00a2\u00a5\3\2\2\2\u00a3\u00a1\3\2\2\2\u00a3\u00a4"+
		"\3\2\2\2\u00a4\u00a6\3\2\2\2\u00a5\u00a3\3\2\2\2\u00a6\u00a7\7\13\2\2"+
		"\u00a7\u00a8\5\4\3\2\u00a8\13\3\2\2\2\u00a9\u00aa\7\5\2\2\u00aa\u00ab"+
		"\7\13\2\2\u00ab\u00ac\5\4\3\2\u00ac\r\3\2\2\2\u00ad\u00ae\7\34\2\2\u00ae"+
		"\u00b0\7:\2\2\u00af\u00b1\78\2\2\u00b0\u00af\3\2\2\2\u00b0\u00b1\3\2\2"+
		"\2\u00b1\u00b2\3\2\2\2\u00b2\u00b3\7\33\2\2\u00b3\17\3\2\2\2\u00b4\u00b5"+
		"\7\32\2\2\u00b5\21\3\2\2\2\u00b6\u00b7\7\r\2\2\u00b7\23\3\2\2\2\u00b8"+
		"\u00b9\7\20\2\2\u00b9\25\3\2\2\2\u00ba\u00bb\6\f\2\2\u00bb\u00c0\5\30"+
		"\r\2\u00bc\u00bd\5\32\16\2\u00bd\u00be\7\33\2\2\u00be\u00c0\3\2\2\2\u00bf"+
		"\u00ba\3\2\2\2\u00bf\u00bc\3\2\2\2\u00c0\27\3\2\2\2\u00c1\u00c2\5V,\2"+
		"\u00c2\u00cb\7\n\2\2\u00c3\u00c8\58\35\2\u00c4\u00c5\7\6\2\2\u00c5\u00c7"+
		"\58\35\2\u00c6\u00c4\3\2\2\2\u00c7\u00ca\3\2\2\2\u00c8\u00c6\3\2\2\2\u00c8"+
		"\u00c9\3\2\2\2\u00c9\u00cc\3\2\2\2\u00ca\u00c8\3\2\2\2\u00cb\u00c3\3\2"+
		"\2\2\u00cb\u00cc\3\2\2\2\u00cc\u00cd\3\2\2\2\u00cd\u00ce\7\26\2\2\u00ce"+
		"\u00cf\5\34\17\2\u00cf\31\3\2\2\2\u00d0\u00d1\5V,\2\u00d1\u00da\7\n\2"+
		"\2\u00d2\u00d7\58\35\2\u00d3\u00d4\7\6\2\2\u00d4\u00d6\58\35\2\u00d5\u00d3"+
		"\3\2\2\2\u00d6\u00d9\3\2\2\2\u00d7\u00d5\3\2\2\2\u00d7\u00d8\3\2\2\2\u00d8"+
		"\u00db\3\2\2\2\u00d9\u00d7\3\2\2\2\u00da\u00d2\3\2\2\2\u00da\u00db\3\2"+
		"\2\2\u00db\u00dc\3\2\2\2\u00dc\u00dd\7\26\2\2\u00dd\33\3\2\2\2\u00de\u00e0"+
		"\7\64\2\2\u00df\u00e1\5\4\3\2\u00e0\u00df\3\2\2\2\u00e0\u00e1\3\2\2\2"+
		"\u00e1\u00e2\3\2\2\2\u00e2\u00e3\7\65\2\2\u00e3\35\3\2\2\2\u00e4\u00e5"+
		"\7\27\2\2\u00e5\u00e6\7\n\2\2\u00e6\u00e7\7:\2\2\u00e7\u00e8\7\17\2\2"+
		"\u00e8\u00e9\58\35\2\u00e9\u00ea\7\26\2\2\u00ea\u00ed\5\34\17\2\u00eb"+
		"\u00ec\7\t\2\2\u00ec\u00ee\5\34\17\2\u00ed\u00eb\3\2\2\2\u00ed\u00ee\3"+
		"\2\2\2\u00ee\37\3\2\2\2\u00ef\u00f0\7\7\2\2\u00f0\u00f1\7\n\2\2\u00f1"+
		"\u00f2\5:\36\2\u00f2\u00f3\7\26\2\2\u00f3\u00f4\5\34\17\2\u00f4!\3\2\2"+
		"\2\u00f5\u00f6\7\f\2\2\u00f6\u00f7\7\n\2\2\u00f7\u00f8\5:\36\2\u00f8\u00f9"+
		"\7\26\2\2\u00f9\u00fc\5\6\4\2\u00fa\u00fb\7\22\2\2\u00fb\u00fd\5\6\4\2"+
		"\u00fc\u00fa\3\2\2\2\u00fc\u00fd\3\2\2\2\u00fd#\3\2\2\2\u00fe\u00ff\7"+
		"\63\2\2\u00ff\u0100\7:\2\2\u0100\u0101\7\62\2\2\u0101%\3\2\2\2\u0102\u0103"+
		"\7\61\2\2\u0103\u0104\5(\25\2\u0104\u0105\7\62\2\2\u0105\u010d\3\2\2\2"+
		"\u0106\u0107\7\61\2\2\u0107\u0108\7\21\2\2\u0108\u0109\5(\25\2\u0109\u010a"+
		"\7\26\2\2\u010a\u010b\7\62\2\2\u010b\u010d\3\2\2\2\u010c\u0102\3\2\2\2"+
		"\u010c\u0106\3\2\2\2\u010d\'\3\2\2\2\u010e\u0111\58\35\2\u010f\u0110\7"+
		"\6\2\2\u0110\u0112\5*\26\2\u0111\u010f\3\2\2\2\u0111\u0112\3\2\2\2\u0112"+
		")\3\2\2\2\u0113\u0116\5V,\2\u0114\u0115\7\31\2\2\u0115\u0117\78\2\2\u0116"+
		"\u0114\3\2\2\2\u0116\u0117\3\2\2\2\u0117\u011a\3\2\2\2\u0118\u011a\78"+
		"\2\2\u0119\u0113\3\2\2\2\u0119\u0118\3\2\2\2\u011a+\3\2\2\2\u011b\u011c"+
		"\7 \2\2\u011c\u011d\b\27\1\2\u011d\u0122\5.\30\2\u011e\u011f\7\6\2\2\u011f"+
		"\u0121\5.\30\2\u0120\u011e\3\2\2\2\u0121\u0124\3\2\2\2\u0122\u0120\3\2"+
		"\2\2\u0122\u0123\3\2\2\2\u0123-\3\2\2\2\u0124\u0122\3\2\2\2\u0125\u012d"+
		"\7:\2\2\u0126\u0127\7:\2\2\u0127\u0128\7\31\2\2\u0128\u012d\58\35\2\u0129"+
		"\u012a\7:\2\2\u012a\u012b\7\31\2\2\u012b\u012d\5\34\17\2\u012c\u0125\3"+
		"\2\2\2\u012c\u0126\3\2\2\2\u012c\u0129\3\2\2\2\u012d/\3\2\2\2\u012e\u012f"+
		"\7:\2\2\u012f\u0130\7\31\2\2\u0130\u0131\58\35\2\u0131\61\3\2\2\2\u0132"+
		"\u0133\6\32\3\2\u0133\u0140\7:\2\2\u0134\u0135\7:\2\2\u0135\u0139\b\32"+
		"\1\2\u0136\u0138\5\66\34\2\u0137\u0136\3\2\2\2\u0138\u013b\3\2\2\2\u0139"+
		"\u0137\3\2\2\2\u0139\u013a\3\2\2\2\u013a\u013d\3\2\2\2\u013b\u0139\3\2"+
		"\2\2\u013c\u013e\5\64\33\2\u013d\u013c\3\2\2\2\u013d\u013e\3\2\2\2\u013e"+
		"\u0140\3\2\2\2\u013f\u0132\3\2\2\2\u013f\u0134\3\2\2\2\u0140\63\3\2\2"+
		"\2\u0141\u0143\7\36\2\2\u0142\u0144\5H%\2\u0143\u0142\3\2\2\2\u0143\u0144"+
		"\3\2\2\2\u0144\65\3\2\2\2\u0145\u0146\7\25\2\2\u0146\u014e\7:\2\2\u0147"+
		"\u0148\7\23\2\2\u0148\u014e\7:\2\2\u0149\u014a\7\b\2\2\u014a\u014b\58"+
		"\35\2\u014b\u014c\7\3\2\2\u014c\u014e\3\2\2\2\u014d\u0145\3\2\2\2\u014d"+
		"\u0147\3\2\2\2\u014d\u0149\3\2\2\2\u014e\67\3\2\2\2\u014f\u0150\5:\36"+
		"\2\u01509\3\2\2\2\u0151\u015a\5<\37\2\u0152\u0154\7\16\2\2\u0153\u0155"+
		"\58\35\2\u0154\u0153\3\2\2\2\u0154\u0155\3\2\2\2\u0155\u0156\3\2\2\2\u0156"+
		"\u0158\7\13\2\2\u0157\u0159\58\35\2\u0158\u0157\3\2\2\2\u0158\u0159\3"+
		"\2\2\2\u0159\u015b\3\2\2\2\u015a\u0152\3\2\2\2\u015a\u015b\3\2\2\2\u015b"+
		";\3\2\2\2\u015c\u0161\5> \2\u015d\u015e\7/\2\2\u015e\u0160\5> \2\u015f"+
		"\u015d\3\2\2\2\u0160\u0163\3\2\2\2\u0161\u015f\3\2\2\2\u0161\u0162\3\2"+
		"\2\2\u0162=\3\2\2\2\u0163\u0161\3\2\2\2\u0164\u0169\5@!\2\u0165\u0166"+
		"\7\60\2\2\u0166\u0168\5@!\2\u0167\u0165\3\2\2\2\u0168\u016b\3\2\2\2\u0169"+
		"\u0167\3\2\2\2\u0169\u016a\3\2\2\2\u016a?\3\2\2\2\u016b\u0169\3\2\2\2"+
		"\u016c\u0170\5B\"\2\u016d\u016e\7\36\2\2\u016e\u0170\5B\"\2\u016f\u016c"+
		"\3\2\2\2\u016f\u016d\3\2\2\2\u0170A\3\2\2\2\u0171\u017c\5D#\2\u0172\u0179"+
		"\7)\2\2\u0173\u0179\7*\2\2\u0174\u0179\7+\2\2\u0175\u0179\7,\2\2\u0176"+
		"\u0179\7-\2\2\u0177\u0179\7.\2\2\u0178\u0172\3\2\2\2\u0178\u0173\3\2\2"+
		"\2\u0178\u0174\3\2\2\2\u0178\u0175\3\2\2\2\u0178\u0176\3\2\2\2\u0178\u0177"+
		"\3\2\2\2\u0179\u017a\3\2\2\2\u017a\u017b\b\"\1\2\u017b\u017d\5D#\2\u017c"+
		"\u0178\3\2\2\2\u017c\u017d\3\2\2\2\u017dC\3\2\2\2\u017e\u0186\5F$\2\u017f"+
		"\u0182\7$\2\2\u0180\u0182\7%\2\2\u0181\u017f\3\2\2\2\u0181\u0180\3\2\2"+
		"\2\u0182\u0183\3\2\2\2\u0183\u0184\5F$\2\u0184\u0185\b#\1\2\u0185\u0187"+
		"\3\2\2\2\u0186\u0181\3\2\2\2\u0186\u0187\3\2\2\2\u0187E\3\2\2\2\u0188"+
		"\u0190\5J&\2\u0189\u018d\7&\2\2\u018a\u018d\7\'\2\2\u018b\u018d\7(\2\2"+
		"\u018c\u0189\3\2\2\2\u018c\u018a\3\2\2\2\u018c\u018b\3\2\2\2\u018d\u018e"+
		"\3\2\2\2\u018e\u018f\b$\1\2\u018f\u0191\5J&\2\u0190\u018c\3\2\2\2\u0190"+
		"\u0191\3\2\2\2\u0191G\3\2\2\2\u0192\u01a0\7\37\2\2\u0193\u01a0\7!\2\2"+
		"\u0194\u01a0\7#\2\2\u0195\u01a0\7\"\2\2\u0196\u01a0\78\2\2\u0197\u01a0"+
		"\5\62\32\2\u0198\u0199\7\n\2\2\u0199\u019a\58\35\2\u019a\u019b\7\26\2"+
		"\2\u019b\u01a0\3\2\2\2\u019c\u01a0\5\32\16\2\u019d\u01a0\5L\'\2\u019e"+
		"\u01a0\5^\60\2\u019f\u0192\3\2\2\2\u019f\u0193\3\2\2\2\u019f\u0194\3\2"+
		"\2\2\u019f\u0195\3\2\2\2\u019f\u0196\3\2\2\2\u019f\u0197\3\2\2\2\u019f"+
		"\u0198\3\2\2\2\u019f\u019c\3\2\2\2\u019f\u019d\3\2\2\2\u019f\u019e\3\2"+
		"\2\2\u01a0I\3\2\2\2\u01a1\u01a7\5H%\2\u01a2\u01a3\7%\2\2\u01a3\u01a7\5"+
		"H%\2\u01a4\u01a5\7$\2\2\u01a5\u01a7\5H%\2\u01a6\u01a1\3\2\2\2\u01a6\u01a2"+
		"\3\2\2\2\u01a6\u01a4\3\2\2\2\u01a7K\3\2\2\2\u01a8\u01a9\7\30\2\2\u01a9"+
		"\u01ae\7:\2\2\u01aa\u01ab\7\25\2\2\u01ab\u01ad\7:\2\2\u01ac\u01aa\3\2"+
		"\2\2\u01ad\u01b0\3\2\2\2\u01ae\u01ac\3\2\2\2\u01ae\u01af\3\2\2\2\u01af"+
		"\u01b2\3\2\2\2\u01b0\u01ae\3\2\2\2\u01b1\u01b3\5N(\2\u01b2\u01b1\3\2\2"+
		"\2\u01b2\u01b3\3\2\2\2\u01b3M\3\2\2\2\u01b4\u01ba\5P)\2\u01b5\u01b9\5"+
		"P)\2\u01b6\u01b7\7\25\2\2\u01b7\u01b9\7:\2\2\u01b8\u01b5\3\2\2\2\u01b8"+
		"\u01b6\3\2\2\2\u01b9\u01bc\3\2\2\2\u01ba\u01b8\3\2\2\2\u01ba\u01bb\3\2"+
		"\2\2\u01bbO\3\2\2\2\u01bc\u01ba\3\2\2\2\u01bd\u01c0\5R*\2\u01be\u01c0"+
		"\5T+\2\u01bf\u01bd\3\2\2\2\u01bf\u01be\3\2\2\2\u01c0Q\3\2\2\2\u01c1\u01c2"+
		"\7\25\2\2\u01c2\u01c3\7:\2\2\u01c3\u01cc\7\n\2\2\u01c4\u01c9\58\35\2\u01c5"+
		"\u01c6\7\6\2\2\u01c6\u01c8\58\35\2\u01c7\u01c5\3\2\2\2\u01c8\u01cb\3\2"+
		"\2\2\u01c9\u01c7\3\2\2\2\u01c9\u01ca\3\2\2\2\u01ca\u01cd\3\2\2\2\u01cb"+
		"\u01c9\3\2\2\2\u01cc\u01c4\3\2\2\2\u01cc\u01cd\3\2\2\2\u01cd\u01ce\3\2"+
		"\2\2\u01ce\u01cf\7\26\2\2\u01cfS\3\2\2\2\u01d0\u01d1\7\b\2\2\u01d1\u01d2"+
		"\58\35\2\u01d2\u01d3\7\3\2\2\u01d3U\3\2\2\2\u01d4\u01d7\7:\2\2\u01d5\u01d6"+
		"\7\25\2\2\u01d6\u01d8\7:\2\2\u01d7\u01d5\3\2\2\2\u01d7\u01d8\3\2\2\2\u01d8"+
		"W\3\2\2\2\u01d9\u01da\7\35\2\2\u01da\u01db\7\n\2\2\u01db\u01dc\58\35\2"+
		"\u01dc\u01dd\7\26\2\2\u01dd\u01e1\7\64\2\2\u01de\u01e0\5Z.\2\u01df\u01de"+
		"\3\2\2\2\u01e0\u01e3\3\2\2\2\u01e1\u01df\3\2\2\2\u01e1\u01e2\3\2\2\2\u01e2"+
		"\u01e5\3\2\2\2\u01e3\u01e1\3\2\2\2\u01e4\u01e6\5\\/\2\u01e5\u01e4\3\2"+
		"\2\2\u01e5\u01e6\3\2\2\2\u01e6\u01e7\3\2\2\2\u01e7\u01e8\7\65\2\2\u01e8"+
		"Y\3\2\2\2\u01e9\u01ea\7\24\2\2\u01ea\u01eb\58\35\2\u01eb\u01ec\7\13\2"+
		"\2\u01ec\u01ed\5\4\3\2\u01ed[\3\2\2\2\u01ee\u01ef\7\5\2\2\u01ef\u01f0"+
		"\7\13\2\2\u01f0\u01f1\5\4\3\2\u01f1]\3\2\2\2\u01f2\u01fb\7\b\2\2\u01f3"+
		"\u01f8\58\35\2\u01f4\u01f5\7\6\2\2\u01f5\u01f7\58\35\2\u01f6\u01f4\3\2"+
		"\2\2\u01f7\u01fa\3\2\2\2\u01f8\u01f6\3\2\2\2\u01f8\u01f9\3\2\2\2\u01f9"+
		"\u01fc\3\2\2\2\u01fa\u01f8\3\2\2\2\u01fb\u01f3\3\2\2\2\u01fb\u01fc\3\2"+
		"\2\2\u01fc\u01fd\3\2\2\2\u01fd\u020b\7\3\2\2\u01fe\u0207\7\64\2\2\u01ff"+
		"\u0204\5`\61\2\u0200\u0201\7\6\2\2\u0201\u0203\5`\61\2\u0202\u0200\3\2"+
		"\2\2\u0203\u0206\3\2\2\2\u0204\u0202\3\2\2\2\u0204\u0205\3\2\2\2\u0205"+
		"\u0208\3\2\2\2\u0206\u0204\3\2\2\2\u0207\u01ff\3\2\2\2\u0207\u0208\3\2"+
		"\2\2\u0208\u0209\3\2\2\2\u0209\u020b\7\65\2\2\u020a\u01f2\3\2\2\2\u020a"+
		"\u01fe\3\2\2\2\u020b_\3\2\2\2\u020c\u020d\78\2\2\u020d\u020e\7\13\2\2"+
		"\u020e\u0213\58\35\2\u020f\u0210\7:\2\2\u0210\u0211\7\13\2\2\u0211\u0213"+
		"\58\35\2\u0212\u020c\3\2\2\2\u0212\u020f\3\2\2\2\u0213a\3\2\2\2;cj\u0088"+
		"\u008f\u0095\u0099\u00a3\u00b0\u00bf\u00c8\u00cb\u00d7\u00da\u00e0\u00ed"+
		"\u00fc\u010c\u0111\u0116\u0119\u0122\u012c\u0139\u013d\u013f\u0143\u014d"+
		"\u0154\u0158\u015a\u0161\u0169\u016f\u0178\u017c\u0181\u0186\u018c\u0190"+
		"\u019f\u01a6\u01ae\u01b2\u01b8\u01ba\u01bf\u01c9\u01cc\u01d7\u01e1\u01e5"+
		"\u01f8\u01fb\u0204\u0207\u020a\u0212";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}