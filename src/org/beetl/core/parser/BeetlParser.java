// Generated from E:\lijz\javamonkey\bee\research\antlrworks2\projects\beetl\BeetlParser.g4 by ANTLR 4.1
package org.beetl.core.parser;
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
		Elsefor=3, Switch=6, COMMENT_TAG=61, Try=15, LEFT_TEXT_TOKEN=51, OctalLiteral=54, 
		MOD=30, LEFT_ANGULAR=69, INCREASE=23, While=5, NOT=36, ALL_COMMENT_CHAR=63, 
		Case=13, AND=37, RIGHT_TOKEN=50, RIGHT_SQBR=22, DECREASE=24, Identifier=57, 
		Default=14, AT=40, TYPE_END=72, LEFT_TOKEN=49, NOT_EQUAL=32, COMMA=45, 
		EQUAL=31, LESS=35, LEFT_PAR1=66, LEFT_PAR=19, Select=7, PERIOD1=65, MUlTIP=28, 
		Return=8, VIRTUAL=25, If=1, LEFT_SQBR=21, ADD=26, RIGHT_BRACE=18, HexLiteral=52, 
		QUESTOIN=39, Continue=10, LINE_COMMENT=59, Catch=16, PERIOD=47, Identifier1=64, 
		NULL=41, ASSIN=33, COMMENT_OPEN=60, RIGHT_PAR1=67, MIN=27, Directive=12, 
		COMMA1=68, DecimalLiteral=53, For=2, TRUE=42, StringLiteral=56, COLON=46, 
		WS=58, COMMENT_END=62, Break=9, FOR_IN=48, LEFT_BRACE=17, WS1=71, FloatingPointLiteral=55, 
		RIGHT_PAR=20, OR=38, LARGE=34, DIV=29, END=44, RIGHT_ANGULAR=70, Else=4, 
		FALSE=43, Var=11;
	public static final String[] tokenNames = {
		"<INVALID>", "'if'", "'for'", "'elsefor'", "'else'", "'while'", "'switch'", 
		"'select'", "'return'", "'break'", "'continue'", "'var'", "Directive", 
		"'case'", "'default'", "'try'", "'catch'", "'{'", "'}'", "LEFT_PAR", "RIGHT_PAR", 
		"'['", "']'", "'++'", "'--'", "'.~'", "'+'", "'-'", "'*'", "'/'", "'%'", 
		"'=='", "'!='", "'='", "LARGE", "LESS", "'!'", "'&&'", "'||'", "'?'", 
		"'@'", "'null'", "'true'", "'false'", "';'", "COMMA", "':'", "PERIOD", 
		"'in'", "'<<'", "'>>'", "'<$'", "HexLiteral", "DecimalLiteral", "OctalLiteral", 
		"FloatingPointLiteral", "StringLiteral", "Identifier", "WS", "LINE_COMMENT", 
		"COMMENT_OPEN", "COMMENT_TAG", "COMMENT_END", "ALL_COMMENT_CHAR", "Identifier1", 
		"PERIOD1", "LEFT_PAR1", "RIGHT_PAR1", "COMMA1", "LEFT_ANGULAR", "RIGHT_ANGULAR", 
		"WS1", "TYPE_END"
	};
	public static final int
		RULE_prog = 0, RULE_block = 1, RULE_statement = 2, RULE_commentTypeTag = 3, 
		RULE_commentTypeItemTag = 4, RULE_classOrInterfaceType = 5, RULE_typeArguments = 6, 
		RULE_typeArgument = 7, RULE_directiveExp = 8, RULE_g_switchStatment = 9, 
		RULE_g_caseStatment = 10, RULE_g_defaultStatment = 11, RULE_varDeclareList = 12, 
		RULE_assignMent = 13, RULE_switchBlock = 14, RULE_switchBlockStatementGroup = 15, 
		RULE_switchLabel = 16, RULE_forControl = 17, RULE_parExpression = 18, 
		RULE_expressionList = 19, RULE_statementExpression = 20, RULE_textStatment = 21, 
		RULE_textVar = 22, RULE_textformat = 23, RULE_constantsTextStatment = 24, 
		RULE_constantExpression = 25, RULE_expression = 26, RULE_varRef = 27, 
		RULE_varAttribute = 28, RULE_functionCall = 29, RULE_functionTagCall = 30, 
		RULE_functionNs = 31, RULE_nativeCall = 32, RULE_nativeMethod = 33, RULE_nativeArray = 34, 
		RULE_nativeVarRefChain = 35, RULE_json = 36, RULE_jsonKeyValue = 37, RULE_literal = 38, 
		RULE_booleanLiteral = 39, RULE_arguments = 40;
	public static final String[] ruleNames = {
		"prog", "block", "statement", "commentTypeTag", "commentTypeItemTag", 
		"classOrInterfaceType", "typeArguments", "typeArgument", "directiveExp", 
		"g_switchStatment", "g_caseStatment", "g_defaultStatment", "varDeclareList", 
		"assignMent", "switchBlock", "switchBlockStatementGroup", "switchLabel", 
		"forControl", "parExpression", "expressionList", "statementExpression", 
		"textStatment", "textVar", "textformat", "constantsTextStatment", "constantExpression", 
		"expression", "varRef", "varAttribute", "functionCall", "functionTagCall", 
		"functionNs", "nativeCall", "nativeMethod", "nativeArray", "nativeVarRefChain", 
		"json", "jsonKeyValue", "literal", "booleanLiteral", "arguments"
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
		public TerminalNode EOF() { return getToken(BeetlParser.EOF, 0); }
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public ProgContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prog; }
	}

	public final ProgContext prog() throws RecognitionException {
		ProgContext _localctx = new ProgContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_prog);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(85);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					{
					{
					setState(82); statement();
					}
					} 
				}
				setState(87);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			}
			setState(88); match(EOF);
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
	}

	public final BlockContext block() throws RecognitionException {
		BlockContext _localctx = new BlockContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_block);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(90); match(LEFT_BRACE);
			setState(94);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					{
					{
					setState(91); statement();
					}
					} 
				}
				setState(96);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			}
			setState(97); match(RIGHT_BRACE);
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
	public static class ForStContext extends StatementContext {
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public TerminalNode For() { return getToken(BeetlParser.For, 0); }
		public TerminalNode RIGHT_PAR() { return getToken(BeetlParser.RIGHT_PAR, 0); }
		public TerminalNode LEFT_PAR() { return getToken(BeetlParser.LEFT_PAR, 0); }
		public ForControlContext forControl() {
			return getRuleContext(ForControlContext.class,0);
		}
		public TerminalNode Elsefor() { return getToken(BeetlParser.Elsefor, 0); }
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public ForStContext(StatementContext ctx) { copyFrom(ctx); }
	}
	public static class CommentTagStContext extends StatementContext {
		public TerminalNode COMMENT_TAG() { return getToken(BeetlParser.COMMENT_TAG, 0); }
		public CommentTypeTagContext commentTypeTag() {
			return getRuleContext(CommentTypeTagContext.class,0);
		}
		public CommentTagStContext(StatementContext ctx) { copyFrom(ctx); }
	}
	public static class BlockStContext extends StatementContext {
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public BlockStContext(StatementContext ctx) { copyFrom(ctx); }
	}
	public static class StatmentExpStContext extends StatementContext {
		public StatementExpressionContext statementExpression() {
			return getRuleContext(StatementExpressionContext.class,0);
		}
		public TerminalNode END() { return getToken(BeetlParser.END, 0); }
		public StatmentExpStContext(StatementContext ctx) { copyFrom(ctx); }
	}
	public static class ReturnStContext extends StatementContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode Return() { return getToken(BeetlParser.Return, 0); }
		public TerminalNode END() { return getToken(BeetlParser.END, 0); }
		public ReturnStContext(StatementContext ctx) { copyFrom(ctx); }
	}
	public static class BreakStContext extends StatementContext {
		public TerminalNode Break() { return getToken(BeetlParser.Break, 0); }
		public TerminalNode END() { return getToken(BeetlParser.END, 0); }
		public BreakStContext(StatementContext ctx) { copyFrom(ctx); }
	}
	public static class DirectiveStContext extends StatementContext {
		public DirectiveExpContext directiveExp() {
			return getRuleContext(DirectiveExpContext.class,0);
		}
		public TerminalNode Directive() { return getToken(BeetlParser.Directive, 0); }
		public DirectiveStContext(StatementContext ctx) { copyFrom(ctx); }
	}
	public static class TextOutputStContext extends StatementContext {
		public TextStatmentContext textStatment() {
			return getRuleContext(TextStatmentContext.class,0);
		}
		public TextOutputStContext(StatementContext ctx) { copyFrom(ctx); }
	}
	public static class VarStContext extends StatementContext {
		public TerminalNode Var() { return getToken(BeetlParser.Var, 0); }
		public TerminalNode END() { return getToken(BeetlParser.END, 0); }
		public VarDeclareListContext varDeclareList() {
			return getRuleContext(VarDeclareListContext.class,0);
		}
		public VarStContext(StatementContext ctx) { copyFrom(ctx); }
	}
	public static class StaticOutputStContext extends StatementContext {
		public ConstantsTextStatmentContext constantsTextStatment() {
			return getRuleContext(ConstantsTextStatmentContext.class,0);
		}
		public StaticOutputStContext(StatementContext ctx) { copyFrom(ctx); }
	}
	public static class ContinueStContext extends StatementContext {
		public TerminalNode Continue() { return getToken(BeetlParser.Continue, 0); }
		public TerminalNode END() { return getToken(BeetlParser.END, 0); }
		public ContinueStContext(StatementContext ctx) { copyFrom(ctx); }
	}
	public static class IfStContext extends StatementContext {
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public ParExpressionContext parExpression() {
			return getRuleContext(ParExpressionContext.class,0);
		}
		public TerminalNode Else() { return getToken(BeetlParser.Else, 0); }
		public TerminalNode If() { return getToken(BeetlParser.If, 0); }
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public IfStContext(StatementContext ctx) { copyFrom(ctx); }
	}
	public static class TryStContext extends StatementContext {
		public TerminalNode Catch() { return getToken(BeetlParser.Catch, 0); }
		public TerminalNode RIGHT_PAR() { return getToken(BeetlParser.RIGHT_PAR, 0); }
		public TerminalNode LEFT_PAR() { return getToken(BeetlParser.LEFT_PAR, 0); }
		public TerminalNode Try() { return getToken(BeetlParser.Try, 0); }
		public BlockContext block(int i) {
			return getRuleContext(BlockContext.class,i);
		}
		public TerminalNode Identifier() { return getToken(BeetlParser.Identifier, 0); }
		public TerminalNode NOT() { return getToken(BeetlParser.NOT, 0); }
		public List<BlockContext> block() {
			return getRuleContexts(BlockContext.class);
		}
		public TryStContext(StatementContext ctx) { copyFrom(ctx); }
	}
	public static class WhileStContext extends StatementContext {
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public TerminalNode While() { return getToken(BeetlParser.While, 0); }
		public ParExpressionContext parExpression() {
			return getRuleContext(ParExpressionContext.class,0);
		}
		public WhileStContext(StatementContext ctx) { copyFrom(ctx); }
	}
	public static class FunctionStContext extends StatementContext {
		public FunctionTagCallContext functionTagCall() {
			return getRuleContext(FunctionTagCallContext.class,0);
		}
		public FunctionStContext(StatementContext ctx) { copyFrom(ctx); }
	}
	public static class SiwchStContext extends StatementContext {
		public ParExpressionContext parExpression() {
			return getRuleContext(ParExpressionContext.class,0);
		}
		public SwitchBlockContext switchBlock() {
			return getRuleContext(SwitchBlockContext.class,0);
		}
		public TerminalNode Switch() { return getToken(BeetlParser.Switch, 0); }
		public SiwchStContext(StatementContext ctx) { copyFrom(ctx); }
	}
	public static class AssignStContext extends StatementContext {
		public AssignMentContext assignMent() {
			return getRuleContext(AssignMentContext.class,0);
		}
		public TerminalNode END() { return getToken(BeetlParser.END, 0); }
		public AssignStContext(StatementContext ctx) { copyFrom(ctx); }
	}
	public static class SelectStContext extends StatementContext {
		public G_switchStatmentContext g_switchStatment() {
			return getRuleContext(G_switchStatmentContext.class,0);
		}
		public TerminalNode Select() { return getToken(BeetlParser.Select, 0); }
		public SelectStContext(StatementContext ctx) { copyFrom(ctx); }
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_statement);
		try {
			setState(164);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				_localctx = new BlockStContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(99); block();
				}
				break;

			case 2:
				_localctx = new TextOutputStContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(100); textStatment();
				}
				break;

			case 3:
				_localctx = new StaticOutputStContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(101); constantsTextStatment();
				}
				break;

			case 4:
				_localctx = new CommentTagStContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(102); match(COMMENT_TAG);
				setState(103); commentTypeTag();
				}
				break;

			case 5:
				_localctx = new IfStContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(104); match(If);
				setState(105); parExpression();
				setState(106); statement();
				setState(109);
				switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
				case 1:
					{
					setState(107); match(Else);
					setState(108); statement();
					}
					break;
				}
				}
				break;

			case 6:
				_localctx = new ForStContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(111); match(For);
				setState(112); match(LEFT_PAR);
				setState(113); forControl();
				setState(114); match(RIGHT_PAR);
				setState(115); statement();
				setState(118);
				switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
				case 1:
					{
					setState(116); match(Elsefor);
					setState(117); statement();
					}
					break;
				}
				}
				break;

			case 7:
				_localctx = new WhileStContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(120); match(While);
				setState(121); parExpression();
				setState(122); statement();
				}
				break;

			case 8:
				_localctx = new SiwchStContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(124); match(Switch);
				setState(125); parExpression();
				setState(126); switchBlock();
				}
				break;

			case 9:
				_localctx = new SelectStContext(_localctx);
				enterOuterAlt(_localctx, 9);
				{
				setState(128); match(Select);
				setState(129); g_switchStatment();
				}
				break;

			case 10:
				_localctx = new TryStContext(_localctx);
				enterOuterAlt(_localctx, 10);
				{
				setState(130); match(Try);
				setState(132);
				switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
				case 1:
					{
					setState(131); match(NOT);
					}
					break;
				}
				setState(134); block();
				setState(140);
				switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
				case 1:
					{
					setState(135); match(Catch);
					setState(136); match(LEFT_PAR);
					setState(137); match(Identifier);
					setState(138); match(RIGHT_PAR);
					setState(139); block();
					}
					break;
				}
				}
				break;

			case 11:
				_localctx = new ReturnStContext(_localctx);
				enterOuterAlt(_localctx, 11);
				{
				setState(142); match(Return);
				setState(144);
				switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
				case 1:
					{
					setState(143); expression(0);
					}
					break;
				}
				setState(146); match(END);
				}
				break;

			case 12:
				_localctx = new BreakStContext(_localctx);
				enterOuterAlt(_localctx, 12);
				{
				setState(147); match(Break);
				setState(148); match(END);
				}
				break;

			case 13:
				_localctx = new ContinueStContext(_localctx);
				enterOuterAlt(_localctx, 13);
				{
				setState(149); match(Continue);
				setState(150); match(END);
				}
				break;

			case 14:
				_localctx = new VarStContext(_localctx);
				enterOuterAlt(_localctx, 14);
				{
				setState(151); match(Var);
				setState(152); varDeclareList();
				setState(153); match(END);
				}
				break;

			case 15:
				_localctx = new DirectiveStContext(_localctx);
				enterOuterAlt(_localctx, 15);
				{
				setState(155); match(Directive);
				setState(156); directiveExp();
				}
				break;

			case 16:
				_localctx = new AssignStContext(_localctx);
				enterOuterAlt(_localctx, 16);
				{
				setState(157); assignMent();
				setState(158); match(END);
				}
				break;

			case 17:
				_localctx = new FunctionStContext(_localctx);
				enterOuterAlt(_localctx, 17);
				{
				setState(160); functionTagCall();
				}
				break;

			case 18:
				_localctx = new StatmentExpStContext(_localctx);
				enterOuterAlt(_localctx, 18);
				{
				setState(161); statementExpression();
				setState(162); match(END);
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

	public static class CommentTypeTagContext extends ParserRuleContext {
		public TerminalNode COMMA1() { return getToken(BeetlParser.COMMA1, 0); }
		public CommentTypeItemTagContext commentTypeItemTag(int i) {
			return getRuleContext(CommentTypeItemTagContext.class,i);
		}
		public List<CommentTypeItemTagContext> commentTypeItemTag() {
			return getRuleContexts(CommentTypeItemTagContext.class);
		}
		public CommentTypeTagContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_commentTypeTag; }
	}

	public final CommentTypeTagContext commentTypeTag() throws RecognitionException {
		CommentTypeTagContext _localctx = new CommentTypeTagContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_commentTypeTag);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(166); commentTypeItemTag();
			{
			setState(167); match(COMMA1);
			setState(168); commentTypeItemTag();
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

	public static class CommentTypeItemTagContext extends ParserRuleContext {
		public TerminalNode LEFT_PAR1() { return getToken(BeetlParser.LEFT_PAR1, 0); }
		public TerminalNode RIGHT_PAR1() { return getToken(BeetlParser.RIGHT_PAR1, 0); }
		public TerminalNode Identifier1() { return getToken(BeetlParser.Identifier1, 0); }
		public ClassOrInterfaceTypeContext classOrInterfaceType() {
			return getRuleContext(ClassOrInterfaceTypeContext.class,0);
		}
		public CommentTypeItemTagContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_commentTypeItemTag; }
	}

	public final CommentTypeItemTagContext commentTypeItemTag() throws RecognitionException {
		CommentTypeItemTagContext _localctx = new CommentTypeItemTagContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_commentTypeItemTag);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(170); match(LEFT_PAR1);
			setState(171); classOrInterfaceType();
			setState(172); match(RIGHT_PAR1);
			setState(173); match(Identifier1);
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

	public static class ClassOrInterfaceTypeContext extends ParserRuleContext {
		public TerminalNode PERIOD1(int i) {
			return getToken(BeetlParser.PERIOD1, i);
		}
		public TerminalNode Identifier1(int i) {
			return getToken(BeetlParser.Identifier1, i);
		}
		public List<TerminalNode> PERIOD1() { return getTokens(BeetlParser.PERIOD1); }
		public TypeArgumentsContext typeArguments() {
			return getRuleContext(TypeArgumentsContext.class,0);
		}
		public List<TerminalNode> Identifier1() { return getTokens(BeetlParser.Identifier1); }
		public ClassOrInterfaceTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classOrInterfaceType; }
	}

	public final ClassOrInterfaceTypeContext classOrInterfaceType() throws RecognitionException {
		ClassOrInterfaceTypeContext _localctx = new ClassOrInterfaceTypeContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_classOrInterfaceType);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(175); match(Identifier1);
			setState(180);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					{
					{
					setState(176); match(PERIOD1);
					setState(177); match(Identifier1);
					}
					} 
				}
				setState(182);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
			}
			setState(184);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				{
				setState(183); typeArguments();
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

	public static class TypeArgumentsContext extends ParserRuleContext {
		public List<TerminalNode> COMMA1() { return getTokens(BeetlParser.COMMA1); }
		public List<TypeArgumentContext> typeArgument() {
			return getRuleContexts(TypeArgumentContext.class);
		}
		public TerminalNode RIGHT_ANGULAR() { return getToken(BeetlParser.RIGHT_ANGULAR, 0); }
		public TypeArgumentContext typeArgument(int i) {
			return getRuleContext(TypeArgumentContext.class,i);
		}
		public TerminalNode COMMA1(int i) {
			return getToken(BeetlParser.COMMA1, i);
		}
		public TerminalNode LEFT_ANGULAR() { return getToken(BeetlParser.LEFT_ANGULAR, 0); }
		public TypeArgumentsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeArguments; }
	}

	public final TypeArgumentsContext typeArguments() throws RecognitionException {
		TypeArgumentsContext _localctx = new TypeArgumentsContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_typeArguments);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(186); match(LEFT_ANGULAR);
			setState(187); typeArgument();
			setState(192);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					{
					{
					setState(188); match(COMMA1);
					setState(189); typeArgument();
					}
					} 
				}
				setState(194);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
			}
			setState(195); match(RIGHT_ANGULAR);
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

	public static class TypeArgumentContext extends ParserRuleContext {
		public ClassOrInterfaceTypeContext classOrInterfaceType() {
			return getRuleContext(ClassOrInterfaceTypeContext.class,0);
		}
		public TypeArgumentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeArgument; }
	}

	public final TypeArgumentContext typeArgument() throws RecognitionException {
		TypeArgumentContext _localctx = new TypeArgumentContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_typeArgument);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(197); classOrInterfaceType();
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
	}

	public final DirectiveExpContext directiveExp() throws RecognitionException {
		DirectiveExpContext _localctx = new DirectiveExpContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_directiveExp);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(199); match(Identifier);
			setState(201);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				{
				setState(200); match(StringLiteral);
				}
				break;
			}
			setState(203); match(END);
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
	}

	public final G_switchStatmentContext g_switchStatment() throws RecognitionException {
		G_switchStatmentContext _localctx = new G_switchStatmentContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_g_switchStatment);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(209);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				{
				setState(205); match(LEFT_PAR);
				setState(206); ((G_switchStatmentContext)_localctx).base = expression(0);
				setState(207); match(RIGHT_PAR);
				}
				break;
			}
			setState(211); match(LEFT_BRACE);
			setState(215);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					{
					{
					setState(212); g_caseStatment();
					}
					} 
				}
				setState(217);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
			}
			setState(219);
			switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
			case 1:
				{
				setState(218); g_defaultStatment();
				}
				break;
			}
			setState(221); match(RIGHT_BRACE);
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
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode Case() { return getToken(BeetlParser.Case, 0); }
		public List<TerminalNode> COMMA() { return getTokens(BeetlParser.COMMA); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public TerminalNode COLON() { return getToken(BeetlParser.COLON, 0); }
		public TerminalNode COMMA(int i) {
			return getToken(BeetlParser.COMMA, i);
		}
		public G_caseStatmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_g_caseStatment; }
	}

	public final G_caseStatmentContext g_caseStatment() throws RecognitionException {
		G_caseStatmentContext _localctx = new G_caseStatmentContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_g_caseStatment);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(223); match(Case);
			setState(224); expression(0);
			setState(229);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					{
					{
					setState(225); match(COMMA);
					setState(226); expression(0);
					}
					} 
				}
				setState(231);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
			}
			setState(232); match(COLON);
			setState(236);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					{
					{
					setState(233); statement();
					}
					} 
				}
				setState(238);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
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

	public static class G_defaultStatmentContext extends ParserRuleContext {
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public TerminalNode Default() { return getToken(BeetlParser.Default, 0); }
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public TerminalNode COLON() { return getToken(BeetlParser.COLON, 0); }
		public G_defaultStatmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_g_defaultStatment; }
	}

	public final G_defaultStatmentContext g_defaultStatment() throws RecognitionException {
		G_defaultStatmentContext _localctx = new G_defaultStatmentContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_g_defaultStatment);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(239); match(Default);
			setState(240); match(COLON);
			setState(244);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,17,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					{
					{
					setState(241); statement();
					}
					} 
				}
				setState(246);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,17,_ctx);
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
	}

	public final VarDeclareListContext varDeclareList() throws RecognitionException {
		VarDeclareListContext _localctx = new VarDeclareListContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_varDeclareList);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(247); assignMent();
			setState(252);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,18,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					{
					{
					setState(248); match(COMMA);
					setState(249); assignMent();
					}
					} 
				}
				setState(254);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,18,_ctx);
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
		public AssignMentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignMent; }
	 
		public AssignMentContext() { }
		public void copyFrom(AssignMentContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class AssignTemplateVarContext extends AssignMentContext {
		public TerminalNode ASSIN() { return getToken(BeetlParser.ASSIN, 0); }
		public TerminalNode Identifier() { return getToken(BeetlParser.Identifier, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public AssignTemplateVarContext(AssignMentContext ctx) { copyFrom(ctx); }
	}
	public static class AssignGeneralContext extends AssignMentContext {
		public TerminalNode ASSIN() { return getToken(BeetlParser.ASSIN, 0); }
		public TerminalNode Identifier() { return getToken(BeetlParser.Identifier, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public AssignGeneralContext(AssignMentContext ctx) { copyFrom(ctx); }
	}
	public static class AssignIdContext extends AssignMentContext {
		public TerminalNode Identifier() { return getToken(BeetlParser.Identifier, 0); }
		public AssignIdContext(AssignMentContext ctx) { copyFrom(ctx); }
	}

	public final AssignMentContext assignMent() throws RecognitionException {
		AssignMentContext _localctx = new AssignMentContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_assignMent);
		try {
			setState(262);
			switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
			case 1:
				_localctx = new AssignIdContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(255); match(Identifier);
				}
				break;

			case 2:
				_localctx = new AssignGeneralContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(256); match(Identifier);
				setState(257); match(ASSIN);
				setState(258); expression(0);
				}
				break;

			case 3:
				_localctx = new AssignTemplateVarContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(259); match(Identifier);
				setState(260); match(ASSIN);
				setState(261); block();
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
	}

	public final SwitchBlockContext switchBlock() throws RecognitionException {
		SwitchBlockContext _localctx = new SwitchBlockContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_switchBlock);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(264); match(LEFT_BRACE);
			setState(268);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,20,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					{
					{
					setState(265); switchBlockStatementGroup();
					}
					} 
				}
				setState(270);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,20,_ctx);
			}
			setState(274);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,21,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					{
					{
					setState(271); switchLabel();
					}
					} 
				}
				setState(276);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,21,_ctx);
			}
			setState(277); match(RIGHT_BRACE);
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
	}

	public final SwitchBlockStatementGroupContext switchBlockStatementGroup() throws RecognitionException {
		SwitchBlockStatementGroupContext _localctx = new SwitchBlockStatementGroupContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_switchBlockStatementGroup);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(280); 
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,22,_ctx);
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(279); switchLabel();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(282); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,22,_ctx);
			} while ( _alt!=2 && _alt!=-1 );
			setState(287);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,23,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					{
					{
					setState(284); statement();
					}
					} 
				}
				setState(289);
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
	}

	public final SwitchLabelContext switchLabel() throws RecognitionException {
		SwitchLabelContext _localctx = new SwitchLabelContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_switchLabel);
		try {
			setState(296);
			switch ( getInterpreter().adaptivePredict(_input,24,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(290); match(Case);
				setState(291); expression(0);
				setState(292); match(COLON);
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(294); match(Default);
				setState(295); match(COLON);
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
	}

	public final ForControlContext forControl() throws RecognitionException {
		ForControlContext _localctx = new ForControlContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_forControl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(299);
			switch ( getInterpreter().adaptivePredict(_input,25,_ctx) ) {
			case 1:
				{
				setState(298); match(Var);
				}
				break;
			}
			setState(301); match(Identifier);
			setState(302); match(FOR_IN);
			setState(303); expression(0);
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
	}

	public final ParExpressionContext parExpression() throws RecognitionException {
		ParExpressionContext _localctx = new ParExpressionContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_parExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(305); match(LEFT_PAR);
			setState(306); expression(0);
			setState(307); match(RIGHT_PAR);
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
	}

	public final ExpressionListContext expressionList() throws RecognitionException {
		ExpressionListContext _localctx = new ExpressionListContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_expressionList);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(309); expression(0);
			setState(314);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,26,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					{
					{
					setState(310); match(COMMA);
					setState(311); expression(0);
					}
					} 
				}
				setState(316);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,26,_ctx);
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
	}

	public final StatementExpressionContext statementExpression() throws RecognitionException {
		StatementExpressionContext _localctx = new StatementExpressionContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_statementExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(317); expression(0);
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
		public TerminalNode RIGHT_PAR() { return getToken(BeetlParser.RIGHT_PAR, 0); }
		public TerminalNode LEFT_PAR() { return getToken(BeetlParser.LEFT_PAR, 0); }
		public TextVarContext textVar() {
			return getRuleContext(TextVarContext.class,0);
		}
		public TerminalNode NOT() { return getToken(BeetlParser.NOT, 0); }
		public TerminalNode RIGHT_TOKEN() { return getToken(BeetlParser.RIGHT_TOKEN, 0); }
		public TerminalNode LEFT_TOKEN() { return getToken(BeetlParser.LEFT_TOKEN, 0); }
		public TextStatmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_textStatment; }
	}

	public final TextStatmentContext textStatment() throws RecognitionException {
		TextStatmentContext _localctx = new TextStatmentContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_textStatment);
		try {
			setState(330);
			switch ( getInterpreter().adaptivePredict(_input,27,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(319); match(LEFT_TOKEN);
				setState(320); textVar();
				setState(321); match(RIGHT_TOKEN);
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(323); match(LEFT_TOKEN);
				setState(324); match(NOT);
				setState(325); match(LEFT_PAR);
				setState(326); textVar();
				setState(327); match(RIGHT_PAR);
				setState(328); match(RIGHT_TOKEN);
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
		public ExpressionContext b;
		public TerminalNode COMMA() { return getToken(BeetlParser.COMMA, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TextformatContext textformat() {
			return getRuleContext(TextformatContext.class,0);
		}
		public TextVarContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_textVar; }
	}

	public final TextVarContext textVar() throws RecognitionException {
		TextVarContext _localctx = new TextVarContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_textVar);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(332); ((TextVarContext)_localctx).b = expression(0);
			setState(335);
			switch ( getInterpreter().adaptivePredict(_input,28,_ctx) ) {
			case 1:
				{
				setState(333); match(COMMA);
				setState(334); textformat();
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

	public static class TextformatContext extends ParserRuleContext {
		public FunctionNsContext fm;
		public TerminalNode ASSIN() { return getToken(BeetlParser.ASSIN, 0); }
		public TerminalNode StringLiteral() { return getToken(BeetlParser.StringLiteral, 0); }
		public FunctionNsContext functionNs() {
			return getRuleContext(FunctionNsContext.class,0);
		}
		public TextformatContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_textformat; }
	}

	public final TextformatContext textformat() throws RecognitionException {
		TextformatContext _localctx = new TextformatContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_textformat);
		try {
			setState(342);
			switch ( getInterpreter().adaptivePredict(_input,29,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(337); ((TextformatContext)_localctx).fm = functionNs();
				{
				setState(338); match(ASSIN);
				setState(339); match(StringLiteral);
				}
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(341); match(StringLiteral);
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

	public static class ConstantsTextStatmentContext extends ParserRuleContext {
		public TerminalNode RIGHT_TOKEN() { return getToken(BeetlParser.RIGHT_TOKEN, 0); }
		public TerminalNode DecimalLiteral() { return getToken(BeetlParser.DecimalLiteral, 0); }
		public TerminalNode LEFT_TEXT_TOKEN() { return getToken(BeetlParser.LEFT_TEXT_TOKEN, 0); }
		public ConstantsTextStatmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constantsTextStatment; }
	}

	public final ConstantsTextStatmentContext constantsTextStatment() throws RecognitionException {
		ConstantsTextStatmentContext _localctx = new ConstantsTextStatmentContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_constantsTextStatment);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(344); match(LEFT_TEXT_TOKEN);
			setState(345); match(DecimalLiteral);
			setState(346); match(RIGHT_TOKEN);
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
	}

	public final ConstantExpressionContext constantExpression() throws RecognitionException {
		ConstantExpressionContext _localctx = new ConstantExpressionContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_constantExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(348); expression(0);
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
		public ExpressionContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public ExpressionContext(ParserRuleContext parent, int invokingState, int _p) {
			super(parent, invokingState);
			this._p = _p;
		}
		@Override public int getRuleIndex() { return RULE_expression; }
	 
		public ExpressionContext() { }
		public void copyFrom(ExpressionContext ctx) {
			super.copyFrom(ctx);
			this._p = ctx._p;
		}
	}
	public static class NegExpContext extends ExpressionContext {
		public TerminalNode MIN() { return getToken(BeetlParser.MIN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode ADD() { return getToken(BeetlParser.ADD, 0); }
		public NegExpContext(ExpressionContext ctx) { copyFrom(ctx); }
	}
	public static class EqualExpContext extends ExpressionContext {
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public TerminalNode EQUAL() { return getToken(BeetlParser.EQUAL, 0); }
		public TerminalNode NOT_EQUAL() { return getToken(BeetlParser.NOT_EQUAL, 0); }
		public EqualExpContext(ExpressionContext ctx) { copyFrom(ctx); }
	}
	public static class LiteralExpContext extends ExpressionContext {
		public LiteralContext literal() {
			return getRuleContext(LiteralContext.class,0);
		}
		public LiteralExpContext(ExpressionContext ctx) { copyFrom(ctx); }
	}
	public static class ParExpContext extends ExpressionContext {
		public TerminalNode RIGHT_PAR() { return getToken(BeetlParser.RIGHT_PAR, 0); }
		public TerminalNode LEFT_PAR() { return getToken(BeetlParser.LEFT_PAR, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ParExpContext(ExpressionContext ctx) { copyFrom(ctx); }
	}
	public static class NotExpContext extends ExpressionContext {
		public TerminalNode NOT() { return getToken(BeetlParser.NOT, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public NotExpContext(ExpressionContext ctx) { copyFrom(ctx); }
	}
	public static class AddminExpContext extends ExpressionContext {
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode MIN() { return getToken(BeetlParser.MIN, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public TerminalNode ADD() { return getToken(BeetlParser.ADD, 0); }
		public AddminExpContext(ExpressionContext ctx) { copyFrom(ctx); }
	}
	public static class OrExpContext extends ExpressionContext {
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode OR() { return getToken(BeetlParser.OR, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public OrExpContext(ExpressionContext ctx) { copyFrom(ctx); }
	}
	public static class VarRefExpContext extends ExpressionContext {
		public VarRefContext varRef() {
			return getRuleContext(VarRefContext.class,0);
		}
		public TerminalNode NOT() { return getToken(BeetlParser.NOT, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public VarRefExpContext(ExpressionContext ctx) { copyFrom(ctx); }
	}
	public static class AndExpContext extends ExpressionContext {
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode AND() { return getToken(BeetlParser.AND, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public AndExpContext(ExpressionContext ctx) { copyFrom(ctx); }
	}
	public static class FunctionCallExpContext extends ExpressionContext {
		public FunctionCallContext functionCall() {
			return getRuleContext(FunctionCallContext.class,0);
		}
		public FunctionCallExpContext(ExpressionContext ctx) { copyFrom(ctx); }
	}
	public static class TernaryExpContext extends ExpressionContext {
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode QUESTOIN() { return getToken(BeetlParser.QUESTOIN, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public TerminalNode COLON() { return getToken(BeetlParser.COLON, 0); }
		public TernaryExpContext(ExpressionContext ctx) { copyFrom(ctx); }
	}
	public static class MuldivmodExpContext extends ExpressionContext {
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode MUlTIP() { return getToken(BeetlParser.MUlTIP, 0); }
		public TerminalNode DIV() { return getToken(BeetlParser.DIV, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public TerminalNode MOD() { return getToken(BeetlParser.MOD, 0); }
		public MuldivmodExpContext(ExpressionContext ctx) { copyFrom(ctx); }
	}
	public static class JsonExpContext extends ExpressionContext {
		public JsonContext json() {
			return getRuleContext(JsonContext.class,0);
		}
		public JsonExpContext(ExpressionContext ctx) { copyFrom(ctx); }
	}
	public static class NativeCallExpContext extends ExpressionContext {
		public NativeCallContext nativeCall() {
			return getRuleContext(NativeCallContext.class,0);
		}
		public TerminalNode AT() { return getToken(BeetlParser.AT, 0); }
		public NativeCallExpContext(ExpressionContext ctx) { copyFrom(ctx); }
	}
	public static class CompareExpContext extends ExpressionContext {
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode ASSIN() { return getToken(BeetlParser.ASSIN, 0); }
		public TerminalNode LARGE() { return getToken(BeetlParser.LARGE, 0); }
		public TerminalNode LESS() { return getToken(BeetlParser.LESS, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public CompareExpContext(ExpressionContext ctx) { copyFrom(ctx); }
	}

	public final ExpressionContext expression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpressionContext _localctx = new ExpressionContext(_ctx, _parentState, _p);
		ExpressionContext _prevctx = _localctx;
		int _startState = 52;
		enterRecursionRule(_localctx, RULE_expression);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(369);
			switch ( getInterpreter().adaptivePredict(_input,31,_ctx) ) {
			case 1:
				{
				_localctx = new NegExpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(351);
				_la = _input.LA(1);
				if ( !(_la==ADD || _la==MIN) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				setState(352); expression(10);
				}
				break;

			case 2:
				{
				_localctx = new NotExpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(353); match(NOT);
				setState(354); expression(9);
				}
				break;

			case 3:
				{
				_localctx = new LiteralExpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(355); literal();
				}
				break;

			case 4:
				{
				_localctx = new NativeCallExpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(356); match(AT);
				setState(357); nativeCall();
				}
				break;

			case 5:
				{
				_localctx = new FunctionCallExpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(358); functionCall();
				}
				break;

			case 6:
				{
				_localctx = new VarRefExpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(359); varRef();
				setState(362);
				switch ( getInterpreter().adaptivePredict(_input,30,_ctx) ) {
				case 1:
					{
					setState(360); match(NOT);
					setState(361); expression(0);
					}
					break;
				}
				}
				break;

			case 7:
				{
				_localctx = new JsonExpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(364); json();
				}
				break;

			case 8:
				{
				_localctx = new ParExpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(365); match(LEFT_PAR);
				setState(366); expression(0);
				setState(367); match(RIGHT_PAR);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(407);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,36,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(405);
					switch ( getInterpreter().adaptivePredict(_input,35,_ctx) ) {
					case 1:
						{
						_localctx = new MuldivmodExpContext(new ExpressionContext(_parentctx, _parentState, _p));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(371);
						if (!(8 >= _localctx._p)) throw new FailedPredicateException(this, "8 >= $_p");
						setState(372);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << MUlTIP) | (1L << DIV) | (1L << MOD))) != 0)) ) {
						_errHandler.recoverInline(this);
						}
						consume();
						setState(373); expression(9);
						}
						break;

					case 2:
						{
						_localctx = new AddminExpContext(new ExpressionContext(_parentctx, _parentState, _p));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(374);
						if (!(7 >= _localctx._p)) throw new FailedPredicateException(this, "7 >= $_p");
						setState(375);
						_la = _input.LA(1);
						if ( !(_la==ADD || _la==MIN) ) {
						_errHandler.recoverInline(this);
						}
						consume();
						setState(376); expression(8);
						}
						break;

					case 3:
						{
						_localctx = new CompareExpContext(new ExpressionContext(_parentctx, _parentState, _p));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(377);
						if (!(6 >= _localctx._p)) throw new FailedPredicateException(this, "6 >= $_p");
						setState(384);
						switch ( getInterpreter().adaptivePredict(_input,32,_ctx) ) {
						case 1:
							{
							setState(378); match(LESS);
							setState(379); match(ASSIN);
							}
							break;

						case 2:
							{
							setState(380); match(LARGE);
							setState(381); match(ASSIN);
							}
							break;

						case 3:
							{
							setState(382); match(LARGE);
							}
							break;

						case 4:
							{
							setState(383); match(LESS);
							}
							break;
						}
						setState(386); expression(7);
						}
						break;

					case 4:
						{
						_localctx = new EqualExpContext(new ExpressionContext(_parentctx, _parentState, _p));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(387);
						if (!(5 >= _localctx._p)) throw new FailedPredicateException(this, "5 >= $_p");
						setState(388);
						_la = _input.LA(1);
						if ( !(_la==EQUAL || _la==NOT_EQUAL) ) {
						_errHandler.recoverInline(this);
						}
						consume();
						setState(389); expression(6);
						}
						break;

					case 5:
						{
						_localctx = new AndExpContext(new ExpressionContext(_parentctx, _parentState, _p));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(390);
						if (!(4 >= _localctx._p)) throw new FailedPredicateException(this, "4 >= $_p");
						setState(391); match(AND);
						setState(392); expression(5);
						}
						break;

					case 6:
						{
						_localctx = new OrExpContext(new ExpressionContext(_parentctx, _parentState, _p));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(393);
						if (!(3 >= _localctx._p)) throw new FailedPredicateException(this, "3 >= $_p");
						setState(394); match(OR);
						setState(395); expression(4);
						}
						break;

					case 7:
						{
						_localctx = new TernaryExpContext(new ExpressionContext(_parentctx, _parentState, _p));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(396);
						if (!(2 >= _localctx._p)) throw new FailedPredicateException(this, "2 >= $_p");
						setState(397); match(QUESTOIN);
						setState(399);
						switch ( getInterpreter().adaptivePredict(_input,33,_ctx) ) {
						case 1:
							{
							setState(398); expression(0);
							}
							break;
						}
						setState(401); match(COLON);
						setState(403);
						switch ( getInterpreter().adaptivePredict(_input,34,_ctx) ) {
						case 1:
							{
							setState(402); expression(0);
							}
							break;
						}
						}
						break;
					}
					} 
				}
				setState(409);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,36,_ctx);
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
	}

	public final VarRefContext varRef() throws RecognitionException {
		VarRefContext _localctx = new VarRefContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_varRef);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(410); match(Identifier);
			setState(414);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,37,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					{
					{
					setState(411); varAttribute();
					}
					} 
				}
				setState(416);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,37,_ctx);
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
		public VarAttributeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varAttribute; }
	 
		public VarAttributeContext() { }
		public void copyFrom(VarAttributeContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class VarAttributeGeneralContext extends VarAttributeContext {
		public TerminalNode Identifier() { return getToken(BeetlParser.Identifier, 0); }
		public TerminalNode PERIOD() { return getToken(BeetlParser.PERIOD, 0); }
		public VarAttributeGeneralContext(VarAttributeContext ctx) { copyFrom(ctx); }
	}
	public static class VarAttributeArrayOrMapContext extends VarAttributeContext {
		public TerminalNode RIGHT_SQBR() { return getToken(BeetlParser.RIGHT_SQBR, 0); }
		public TerminalNode LEFT_SQBR() { return getToken(BeetlParser.LEFT_SQBR, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public VarAttributeArrayOrMapContext(VarAttributeContext ctx) { copyFrom(ctx); }
	}
	public static class VarAttributeVirtualContext extends VarAttributeContext {
		public TerminalNode Identifier() { return getToken(BeetlParser.Identifier, 0); }
		public TerminalNode VIRTUAL() { return getToken(BeetlParser.VIRTUAL, 0); }
		public VarAttributeVirtualContext(VarAttributeContext ctx) { copyFrom(ctx); }
	}

	public final VarAttributeContext varAttribute() throws RecognitionException {
		VarAttributeContext _localctx = new VarAttributeContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_varAttribute);
		try {
			setState(425);
			switch ( getInterpreter().adaptivePredict(_input,38,_ctx) ) {
			case 1:
				_localctx = new VarAttributeGeneralContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(417); match(PERIOD);
				setState(418); match(Identifier);
				}
				break;

			case 2:
				_localctx = new VarAttributeVirtualContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(419); match(VIRTUAL);
				setState(420); match(Identifier);
				}
				break;

			case 3:
				_localctx = new VarAttributeArrayOrMapContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(421); match(LEFT_SQBR);
				setState(422); expression(0);
				setState(423); match(RIGHT_SQBR);
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
	}

	public final FunctionCallContext functionCall() throws RecognitionException {
		FunctionCallContext _localctx = new FunctionCallContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_functionCall);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(427); functionNs();
			setState(428); match(LEFT_PAR);
			setState(430);
			switch ( getInterpreter().adaptivePredict(_input,39,_ctx) ) {
			case 1:
				{
				setState(429); expressionList();
				}
				break;
			}
			setState(432); match(RIGHT_PAR);
			setState(436);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,40,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					{
					{
					setState(433); varAttribute();
					}
					} 
				}
				setState(438);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,40,_ctx);
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
	}

	public final FunctionTagCallContext functionTagCall() throws RecognitionException {
		FunctionTagCallContext _localctx = new FunctionTagCallContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_functionTagCall);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(439); functionNs();
			setState(440); match(LEFT_PAR);
			setState(442);
			switch ( getInterpreter().adaptivePredict(_input,41,_ctx) ) {
			case 1:
				{
				setState(441); expressionList();
				}
				break;
			}
			setState(444); match(RIGHT_PAR);
			setState(445); block();
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
	}

	public final FunctionNsContext functionNs() throws RecognitionException {
		FunctionNsContext _localctx = new FunctionNsContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_functionNs);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(447); match(Identifier);
			setState(452);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,42,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					{
					{
					setState(448); match(PERIOD);
					setState(449); match(Identifier);
					}
					} 
				}
				setState(454);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,42,_ctx);
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
	}

	public final NativeCallContext nativeCall() throws RecognitionException {
		NativeCallContext _localctx = new NativeCallContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_nativeCall);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(455); nativeVarRefChain();
			setState(462);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,44,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					{
					setState(460);
					switch ( getInterpreter().adaptivePredict(_input,43,_ctx) ) {
					case 1:
						{
						setState(456); nativeMethod();
						}
						break;

					case 2:
						{
						setState(457); nativeArray();
						}
						break;

					case 3:
						{
						setState(458); match(PERIOD);
						setState(459); nativeVarRefChain();
						}
						break;
					}
					} 
				}
				setState(464);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,44,_ctx);
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
	}

	public final NativeMethodContext nativeMethod() throws RecognitionException {
		NativeMethodContext _localctx = new NativeMethodContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_nativeMethod);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(465); match(LEFT_PAR);
			setState(474);
			switch ( getInterpreter().adaptivePredict(_input,46,_ctx) ) {
			case 1:
				{
				setState(466); expression(0);
				setState(471);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,45,_ctx);
				while ( _alt!=2 && _alt!=-1 ) {
					if ( _alt==1 ) {
						{
						{
						setState(467); match(COMMA);
						setState(468); expression(0);
						}
						} 
					}
					setState(473);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,45,_ctx);
				}
				}
				break;
			}
			setState(476); match(RIGHT_PAR);
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
	}

	public final NativeArrayContext nativeArray() throws RecognitionException {
		NativeArrayContext _localctx = new NativeArrayContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_nativeArray);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(478); match(LEFT_SQBR);
			setState(479); expression(0);
			setState(480); match(RIGHT_SQBR);
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
	}

	public final NativeVarRefChainContext nativeVarRefChain() throws RecognitionException {
		NativeVarRefChainContext _localctx = new NativeVarRefChainContext(_ctx, getState());
		enterRule(_localctx, 70, RULE_nativeVarRefChain);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(482); match(Identifier);
			setState(487);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,47,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					{
					{
					setState(483); match(PERIOD);
					setState(484); match(Identifier);
					}
					} 
				}
				setState(489);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,47,_ctx);
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

	public static class JsonContext extends ParserRuleContext {
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode RIGHT_BRACE() { return getToken(BeetlParser.RIGHT_BRACE, 0); }
		public TerminalNode RIGHT_SQBR() { return getToken(BeetlParser.RIGHT_SQBR, 0); }
		public List<JsonKeyValueContext> jsonKeyValue() {
			return getRuleContexts(JsonKeyValueContext.class);
		}
		public TerminalNode LEFT_SQBR() { return getToken(BeetlParser.LEFT_SQBR, 0); }
		public List<TerminalNode> COMMA() { return getTokens(BeetlParser.COMMA); }
		public JsonKeyValueContext jsonKeyValue(int i) {
			return getRuleContext(JsonKeyValueContext.class,i);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public TerminalNode LEFT_BRACE() { return getToken(BeetlParser.LEFT_BRACE, 0); }
		public TerminalNode COMMA(int i) {
			return getToken(BeetlParser.COMMA, i);
		}
		public JsonContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_json; }
	}

	public final JsonContext json() throws RecognitionException {
		JsonContext _localctx = new JsonContext(_ctx, getState());
		enterRule(_localctx, 72, RULE_json);
		try {
			int _alt;
			setState(514);
			switch ( getInterpreter().adaptivePredict(_input,52,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(490); match(LEFT_SQBR);
				setState(499);
				switch ( getInterpreter().adaptivePredict(_input,49,_ctx) ) {
				case 1:
					{
					setState(491); expression(0);
					setState(496);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,48,_ctx);
					while ( _alt!=2 && _alt!=-1 ) {
						if ( _alt==1 ) {
							{
							{
							setState(492); match(COMMA);
							setState(493); expression(0);
							}
							} 
						}
						setState(498);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,48,_ctx);
					}
					}
					break;
				}
				setState(501); match(RIGHT_SQBR);
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(502); match(LEFT_BRACE);
				setState(511);
				switch ( getInterpreter().adaptivePredict(_input,51,_ctx) ) {
				case 1:
					{
					setState(503); jsonKeyValue();
					setState(508);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,50,_ctx);
					while ( _alt!=2 && _alt!=-1 ) {
						if ( _alt==1 ) {
							{
							{
							setState(504); match(COMMA);
							setState(505); jsonKeyValue();
							}
							} 
						}
						setState(510);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,50,_ctx);
					}
					}
					break;
				}
				setState(513); match(RIGHT_BRACE);
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

	public static class JsonKeyValueContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(BeetlParser.Identifier, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode StringLiteral() { return getToken(BeetlParser.StringLiteral, 0); }
		public TerminalNode COLON() { return getToken(BeetlParser.COLON, 0); }
		public JsonKeyValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_jsonKeyValue; }
	}

	public final JsonKeyValueContext jsonKeyValue() throws RecognitionException {
		JsonKeyValueContext _localctx = new JsonKeyValueContext(_ctx, getState());
		enterRule(_localctx, 74, RULE_jsonKeyValue);
		try {
			setState(522);
			switch ( getInterpreter().adaptivePredict(_input,53,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(516); match(StringLiteral);
				setState(517); match(COLON);
				setState(518); expression(0);
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(519); match(Identifier);
				setState(520); match(COLON);
				setState(521); expression(0);
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

	public static class LiteralContext extends ParserRuleContext {
		public TerminalNode StringLiteral() { return getToken(BeetlParser.StringLiteral, 0); }
		public TerminalNode FloatingPointLiteral() { return getToken(BeetlParser.FloatingPointLiteral, 0); }
		public TerminalNode DecimalLiteral() { return getToken(BeetlParser.DecimalLiteral, 0); }
		public TerminalNode NULL() { return getToken(BeetlParser.NULL, 0); }
		public BooleanLiteralContext booleanLiteral() {
			return getRuleContext(BooleanLiteralContext.class,0);
		}
		public LiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_literal; }
	}

	public final LiteralContext literal() throws RecognitionException {
		LiteralContext _localctx = new LiteralContext(_ctx, getState());
		enterRule(_localctx, 76, RULE_literal);
		try {
			setState(529);
			switch ( getInterpreter().adaptivePredict(_input,54,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(524); match(DecimalLiteral);
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(525); match(FloatingPointLiteral);
				}
				break;

			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(526); match(StringLiteral);
				}
				break;

			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(527); booleanLiteral();
				}
				break;

			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(528); match(NULL);
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

	public static class BooleanLiteralContext extends ParserRuleContext {
		public TerminalNode TRUE() { return getToken(BeetlParser.TRUE, 0); }
		public TerminalNode FALSE() { return getToken(BeetlParser.FALSE, 0); }
		public BooleanLiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_booleanLiteral; }
	}

	public final BooleanLiteralContext booleanLiteral() throws RecognitionException {
		BooleanLiteralContext _localctx = new BooleanLiteralContext(_ctx, getState());
		enterRule(_localctx, 78, RULE_booleanLiteral);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(531);
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
	}

	public final ArgumentsContext arguments() throws RecognitionException {
		ArgumentsContext _localctx = new ArgumentsContext(_ctx, getState());
		enterRule(_localctx, 80, RULE_arguments);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(533); match(LEFT_PAR);
			setState(535);
			switch ( getInterpreter().adaptivePredict(_input,55,_ctx) ) {
			case 1:
				{
				setState(534); expressionList();
				}
				break;
			}
			setState(537); match(RIGHT_PAR);
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
		case 26: return expression_sempred((ExpressionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0: return 8 >= _localctx._p;

		case 1: return 7 >= _localctx._p;

		case 2: return 6 >= _localctx._p;

		case 3: return 5 >= _localctx._p;

		case 4: return 4 >= _localctx._p;

		case 5: return 3 >= _localctx._p;

		case 6: return 2 >= _localctx._p;
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\uacf5\uee8c\u4f5d\u8b0d\u4a45\u78bd\u1b2f\u3378\3J\u021e\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\3\2\7\2"+
		"V\n\2\f\2\16\2Y\13\2\3\2\3\2\3\3\3\3\7\3_\n\3\f\3\16\3b\13\3\3\3\3\3\3"+
		"\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\5\4p\n\4\3\4\3\4\3\4\3\4\3\4\3"+
		"\4\3\4\5\4y\n\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\5\4\u0087"+
		"\n\4\3\4\3\4\3\4\3\4\3\4\3\4\5\4\u008f\n\4\3\4\3\4\5\4\u0093\n\4\3\4\3"+
		"\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\5\4"+
		"\u00a7\n\4\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\7\7\u00b5\n"+
		"\7\f\7\16\7\u00b8\13\7\3\7\5\7\u00bb\n\7\3\b\3\b\3\b\3\b\7\b\u00c1\n\b"+
		"\f\b\16\b\u00c4\13\b\3\b\3\b\3\t\3\t\3\n\3\n\5\n\u00cc\n\n\3\n\3\n\3\13"+
		"\3\13\3\13\3\13\5\13\u00d4\n\13\3\13\3\13\7\13\u00d8\n\13\f\13\16\13\u00db"+
		"\13\13\3\13\5\13\u00de\n\13\3\13\3\13\3\f\3\f\3\f\3\f\7\f\u00e6\n\f\f"+
		"\f\16\f\u00e9\13\f\3\f\3\f\7\f\u00ed\n\f\f\f\16\f\u00f0\13\f\3\r\3\r\3"+
		"\r\7\r\u00f5\n\r\f\r\16\r\u00f8\13\r\3\16\3\16\3\16\7\16\u00fd\n\16\f"+
		"\16\16\16\u0100\13\16\3\17\3\17\3\17\3\17\3\17\3\17\3\17\5\17\u0109\n"+
		"\17\3\20\3\20\7\20\u010d\n\20\f\20\16\20\u0110\13\20\3\20\7\20\u0113\n"+
		"\20\f\20\16\20\u0116\13\20\3\20\3\20\3\21\6\21\u011b\n\21\r\21\16\21\u011c"+
		"\3\21\7\21\u0120\n\21\f\21\16\21\u0123\13\21\3\22\3\22\3\22\3\22\3\22"+
		"\3\22\5\22\u012b\n\22\3\23\5\23\u012e\n\23\3\23\3\23\3\23\3\23\3\24\3"+
		"\24\3\24\3\24\3\25\3\25\3\25\7\25\u013b\n\25\f\25\16\25\u013e\13\25\3"+
		"\26\3\26\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\5\27\u014d"+
		"\n\27\3\30\3\30\3\30\5\30\u0152\n\30\3\31\3\31\3\31\3\31\3\31\5\31\u0159"+
		"\n\31\3\32\3\32\3\32\3\32\3\33\3\33\3\34\3\34\3\34\3\34\3\34\3\34\3\34"+
		"\3\34\3\34\3\34\3\34\3\34\5\34\u016d\n\34\3\34\3\34\3\34\3\34\3\34\5\34"+
		"\u0174\n\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34"+
		"\3\34\5\34\u0183\n\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34"+
		"\3\34\3\34\3\34\5\34\u0192\n\34\3\34\3\34\5\34\u0196\n\34\7\34\u0198\n"+
		"\34\f\34\16\34\u019b\13\34\3\35\3\35\7\35\u019f\n\35\f\35\16\35\u01a2"+
		"\13\35\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\5\36\u01ac\n\36\3\37\3"+
		"\37\3\37\5\37\u01b1\n\37\3\37\3\37\7\37\u01b5\n\37\f\37\16\37\u01b8\13"+
		"\37\3 \3 \3 \5 \u01bd\n \3 \3 \3 \3!\3!\3!\7!\u01c5\n!\f!\16!\u01c8\13"+
		"!\3\"\3\"\3\"\3\"\3\"\7\"\u01cf\n\"\f\"\16\"\u01d2\13\"\3#\3#\3#\3#\7"+
		"#\u01d8\n#\f#\16#\u01db\13#\5#\u01dd\n#\3#\3#\3$\3$\3$\3$\3%\3%\3%\7%"+
		"\u01e8\n%\f%\16%\u01eb\13%\3&\3&\3&\3&\7&\u01f1\n&\f&\16&\u01f4\13&\5"+
		"&\u01f6\n&\3&\3&\3&\3&\3&\7&\u01fd\n&\f&\16&\u0200\13&\5&\u0202\n&\3&"+
		"\5&\u0205\n&\3\'\3\'\3\'\3\'\3\'\3\'\5\'\u020d\n\'\3(\3(\3(\3(\3(\5(\u0214"+
		"\n(\3)\3)\3*\3*\5*\u021a\n*\3*\3*\3*\2+\2\4\6\b\n\f\16\20\22\24\26\30"+
		"\32\34\36 \"$&(*,.\60\62\64\668:<>@BDFHJLNPR\2\6\3\2\34\35\3\2\36 \3\2"+
		"!\"\3\2,-\u024f\2W\3\2\2\2\4\\\3\2\2\2\6\u00a6\3\2\2\2\b\u00a8\3\2\2\2"+
		"\n\u00ac\3\2\2\2\f\u00b1\3\2\2\2\16\u00bc\3\2\2\2\20\u00c7\3\2\2\2\22"+
		"\u00c9\3\2\2\2\24\u00d3\3\2\2\2\26\u00e1\3\2\2\2\30\u00f1\3\2\2\2\32\u00f9"+
		"\3\2\2\2\34\u0108\3\2\2\2\36\u010a\3\2\2\2 \u011a\3\2\2\2\"\u012a\3\2"+
		"\2\2$\u012d\3\2\2\2&\u0133\3\2\2\2(\u0137\3\2\2\2*\u013f\3\2\2\2,\u014c"+
		"\3\2\2\2.\u014e\3\2\2\2\60\u0158\3\2\2\2\62\u015a\3\2\2\2\64\u015e\3\2"+
		"\2\2\66\u0173\3\2\2\28\u019c\3\2\2\2:\u01ab\3\2\2\2<\u01ad\3\2\2\2>\u01b9"+
		"\3\2\2\2@\u01c1\3\2\2\2B\u01c9\3\2\2\2D\u01d3\3\2\2\2F\u01e0\3\2\2\2H"+
		"\u01e4\3\2\2\2J\u0204\3\2\2\2L\u020c\3\2\2\2N\u0213\3\2\2\2P\u0215\3\2"+
		"\2\2R\u0217\3\2\2\2TV\5\6\4\2UT\3\2\2\2VY\3\2\2\2WU\3\2\2\2WX\3\2\2\2"+
		"XZ\3\2\2\2YW\3\2\2\2Z[\7\2\2\3[\3\3\2\2\2\\`\7\23\2\2]_\5\6\4\2^]\3\2"+
		"\2\2_b\3\2\2\2`^\3\2\2\2`a\3\2\2\2ac\3\2\2\2b`\3\2\2\2cd\7\24\2\2d\5\3"+
		"\2\2\2e\u00a7\5\4\3\2f\u00a7\5,\27\2g\u00a7\5\62\32\2hi\7?\2\2i\u00a7"+
		"\5\b\5\2jk\7\3\2\2kl\5&\24\2lo\5\6\4\2mn\7\6\2\2np\5\6\4\2om\3\2\2\2o"+
		"p\3\2\2\2p\u00a7\3\2\2\2qr\7\4\2\2rs\7\25\2\2st\5$\23\2tu\7\26\2\2ux\5"+
		"\6\4\2vw\7\5\2\2wy\5\6\4\2xv\3\2\2\2xy\3\2\2\2y\u00a7\3\2\2\2z{\7\7\2"+
		"\2{|\5&\24\2|}\5\6\4\2}\u00a7\3\2\2\2~\177\7\b\2\2\177\u0080\5&\24\2\u0080"+
		"\u0081\5\36\20\2\u0081\u00a7\3\2\2\2\u0082\u0083\7\t\2\2\u0083\u00a7\5"+
		"\24\13\2\u0084\u0086\7\21\2\2\u0085\u0087\7&\2\2\u0086\u0085\3\2\2\2\u0086"+
		"\u0087\3\2\2\2\u0087\u0088\3\2\2\2\u0088\u008e\5\4\3\2\u0089\u008a\7\22"+
		"\2\2\u008a\u008b\7\25\2\2\u008b\u008c\7;\2\2\u008c\u008d\7\26\2\2\u008d"+
		"\u008f\5\4\3\2\u008e\u0089\3\2\2\2\u008e\u008f\3\2\2\2\u008f\u00a7\3\2"+
		"\2\2\u0090\u0092\7\n\2\2\u0091\u0093\5\66\34\2\u0092\u0091\3\2\2\2\u0092"+
		"\u0093\3\2\2\2\u0093\u0094\3\2\2\2\u0094\u00a7\7.\2\2\u0095\u0096\7\13"+
		"\2\2\u0096\u00a7\7.\2\2\u0097\u0098\7\f\2\2\u0098\u00a7\7.\2\2\u0099\u009a"+
		"\7\r\2\2\u009a\u009b\5\32\16\2\u009b\u009c\7.\2\2\u009c\u00a7\3\2\2\2"+
		"\u009d\u009e\7\16\2\2\u009e\u00a7\5\22\n\2\u009f\u00a0\5\34\17\2\u00a0"+
		"\u00a1\7.\2\2\u00a1\u00a7\3\2\2\2\u00a2\u00a7\5> \2\u00a3\u00a4\5*\26"+
		"\2\u00a4\u00a5\7.\2\2\u00a5\u00a7\3\2\2\2\u00a6e\3\2\2\2\u00a6f\3\2\2"+
		"\2\u00a6g\3\2\2\2\u00a6h\3\2\2\2\u00a6j\3\2\2\2\u00a6q\3\2\2\2\u00a6z"+
		"\3\2\2\2\u00a6~\3\2\2\2\u00a6\u0082\3\2\2\2\u00a6\u0084\3\2\2\2\u00a6"+
		"\u0090\3\2\2\2\u00a6\u0095\3\2\2\2\u00a6\u0097\3\2\2\2\u00a6\u0099\3\2"+
		"\2\2\u00a6\u009d\3\2\2\2\u00a6\u009f\3\2\2\2\u00a6\u00a2\3\2\2\2\u00a6"+
		"\u00a3\3\2\2\2\u00a7\7\3\2\2\2\u00a8\u00a9\5\n\6\2\u00a9\u00aa\7F\2\2"+
		"\u00aa\u00ab\5\n\6\2\u00ab\t\3\2\2\2\u00ac\u00ad\7D\2\2\u00ad\u00ae\5"+
		"\f\7\2\u00ae\u00af\7E\2\2\u00af\u00b0\7B\2\2\u00b0\13\3\2\2\2\u00b1\u00b6"+
		"\7B\2\2\u00b2\u00b3\7C\2\2\u00b3\u00b5\7B\2\2\u00b4\u00b2\3\2\2\2\u00b5"+
		"\u00b8\3\2\2\2\u00b6\u00b4\3\2\2\2\u00b6\u00b7\3\2\2\2\u00b7\u00ba\3\2"+
		"\2\2\u00b8\u00b6\3\2\2\2\u00b9\u00bb\5\16\b\2\u00ba\u00b9\3\2\2\2\u00ba"+
		"\u00bb\3\2\2\2\u00bb\r\3\2\2\2\u00bc\u00bd\7G\2\2\u00bd\u00c2\5\20\t\2"+
		"\u00be\u00bf\7F\2\2\u00bf\u00c1\5\20\t\2\u00c0\u00be\3\2\2\2\u00c1\u00c4"+
		"\3\2\2\2\u00c2\u00c0\3\2\2\2\u00c2\u00c3\3\2\2\2\u00c3\u00c5\3\2\2\2\u00c4"+
		"\u00c2\3\2\2\2\u00c5\u00c6\7H\2\2\u00c6\17\3\2\2\2\u00c7\u00c8\5\f\7\2"+
		"\u00c8\21\3\2\2\2\u00c9\u00cb\7;\2\2\u00ca\u00cc\7:\2\2\u00cb\u00ca\3"+
		"\2\2\2\u00cb\u00cc\3\2\2\2\u00cc\u00cd\3\2\2\2\u00cd\u00ce\7.\2\2\u00ce"+
		"\23\3\2\2\2\u00cf\u00d0\7\25\2\2\u00d0\u00d1\5\66\34\2\u00d1\u00d2\7\26"+
		"\2\2\u00d2\u00d4\3\2\2\2\u00d3\u00cf\3\2\2\2\u00d3\u00d4\3\2\2\2\u00d4"+
		"\u00d5\3\2\2\2\u00d5\u00d9\7\23\2\2\u00d6\u00d8\5\26\f\2\u00d7\u00d6\3"+
		"\2\2\2\u00d8\u00db\3\2\2\2\u00d9\u00d7\3\2\2\2\u00d9\u00da\3\2\2\2\u00da"+
		"\u00dd\3\2\2\2\u00db\u00d9\3\2\2\2\u00dc\u00de\5\30\r\2\u00dd\u00dc\3"+
		"\2\2\2\u00dd\u00de\3\2\2\2\u00de\u00df\3\2\2\2\u00df\u00e0\7\24\2\2\u00e0"+
		"\25\3\2\2\2\u00e1\u00e2\7\17\2\2\u00e2\u00e7\5\66\34\2\u00e3\u00e4\7/"+
		"\2\2\u00e4\u00e6\5\66\34\2\u00e5\u00e3\3\2\2\2\u00e6\u00e9\3\2\2\2\u00e7"+
		"\u00e5\3\2\2\2\u00e7\u00e8\3\2\2\2\u00e8\u00ea\3\2\2\2\u00e9\u00e7\3\2"+
		"\2\2\u00ea\u00ee\7\60\2\2\u00eb\u00ed\5\6\4\2\u00ec\u00eb\3\2\2\2\u00ed"+
		"\u00f0\3\2\2\2\u00ee\u00ec\3\2\2\2\u00ee\u00ef\3\2\2\2\u00ef\27\3\2\2"+
		"\2\u00f0\u00ee\3\2\2\2\u00f1\u00f2\7\20\2\2\u00f2\u00f6\7\60\2\2\u00f3"+
		"\u00f5\5\6\4\2\u00f4\u00f3\3\2\2\2\u00f5\u00f8\3\2\2\2\u00f6\u00f4\3\2"+
		"\2\2\u00f6\u00f7\3\2\2\2\u00f7\31\3\2\2\2\u00f8\u00f6\3\2\2\2\u00f9\u00fe"+
		"\5\34\17\2\u00fa\u00fb\7/\2\2\u00fb\u00fd\5\34\17\2\u00fc\u00fa\3\2\2"+
		"\2\u00fd\u0100\3\2\2\2\u00fe\u00fc\3\2\2\2\u00fe\u00ff\3\2\2\2\u00ff\33"+
		"\3\2\2\2\u0100\u00fe\3\2\2\2\u0101\u0109\7;\2\2\u0102\u0103\7;\2\2\u0103"+
		"\u0104\7#\2\2\u0104\u0109\5\66\34\2\u0105\u0106\7;\2\2\u0106\u0107\7#"+
		"\2\2\u0107\u0109\5\4\3\2\u0108\u0101\3\2\2\2\u0108\u0102\3\2\2\2\u0108"+
		"\u0105\3\2\2\2\u0109\35\3\2\2\2\u010a\u010e\7\23\2\2\u010b\u010d\5 \21"+
		"\2\u010c\u010b\3\2\2\2\u010d\u0110\3\2\2\2\u010e\u010c\3\2\2\2\u010e\u010f"+
		"\3\2\2\2\u010f\u0114\3\2\2\2\u0110\u010e\3\2\2\2\u0111\u0113\5\"\22\2"+
		"\u0112\u0111\3\2\2\2\u0113\u0116\3\2\2\2\u0114\u0112\3\2\2\2\u0114\u0115"+
		"\3\2\2\2\u0115\u0117\3\2\2\2\u0116\u0114\3\2\2\2\u0117\u0118\7\24\2\2"+
		"\u0118\37\3\2\2\2\u0119\u011b\5\"\22\2\u011a\u0119\3\2\2\2\u011b\u011c"+
		"\3\2\2\2\u011c\u011a\3\2\2\2\u011c\u011d\3\2\2\2\u011d\u0121\3\2\2\2\u011e"+
		"\u0120\5\6\4\2\u011f\u011e\3\2\2\2\u0120\u0123\3\2\2\2\u0121\u011f\3\2"+
		"\2\2\u0121\u0122\3\2\2\2\u0122!\3\2\2\2\u0123\u0121\3\2\2\2\u0124\u0125"+
		"\7\17\2\2\u0125\u0126\5\66\34\2\u0126\u0127\7\60\2\2\u0127\u012b\3\2\2"+
		"\2\u0128\u0129\7\20\2\2\u0129\u012b\7\60\2\2\u012a\u0124\3\2\2\2\u012a"+
		"\u0128\3\2\2\2\u012b#\3\2\2\2\u012c\u012e\7\r\2\2\u012d\u012c\3\2\2\2"+
		"\u012d\u012e\3\2\2\2\u012e\u012f\3\2\2\2\u012f\u0130\7;\2\2\u0130\u0131"+
		"\7\62\2\2\u0131\u0132\5\66\34\2\u0132%\3\2\2\2\u0133\u0134\7\25\2\2\u0134"+
		"\u0135\5\66\34\2\u0135\u0136\7\26\2\2\u0136\'\3\2\2\2\u0137\u013c\5\66"+
		"\34\2\u0138\u0139\7/\2\2\u0139\u013b\5\66\34\2\u013a\u0138\3\2\2\2\u013b"+
		"\u013e\3\2\2\2\u013c\u013a\3\2\2\2\u013c\u013d\3\2\2\2\u013d)\3\2\2\2"+
		"\u013e\u013c\3\2\2\2\u013f\u0140\5\66\34\2\u0140+\3\2\2\2\u0141\u0142"+
		"\7\63\2\2\u0142\u0143\5.\30\2\u0143\u0144\7\64\2\2\u0144\u014d\3\2\2\2"+
		"\u0145\u0146\7\63\2\2\u0146\u0147\7&\2\2\u0147\u0148\7\25\2\2\u0148\u0149"+
		"\5.\30\2\u0149\u014a\7\26\2\2\u014a\u014b\7\64\2\2\u014b\u014d\3\2\2\2"+
		"\u014c\u0141\3\2\2\2\u014c\u0145\3\2\2\2\u014d-\3\2\2\2\u014e\u0151\5"+
		"\66\34\2\u014f\u0150\7/\2\2\u0150\u0152\5\60\31\2\u0151\u014f\3\2\2\2"+
		"\u0151\u0152\3\2\2\2\u0152/\3\2\2\2\u0153\u0154\5@!\2\u0154\u0155\7#\2"+
		"\2\u0155\u0156\7:\2\2\u0156\u0159\3\2\2\2\u0157\u0159\7:\2\2\u0158\u0153"+
		"\3\2\2\2\u0158\u0157\3\2\2\2\u0159\61\3\2\2\2\u015a\u015b\7\65\2\2\u015b"+
		"\u015c\7\67\2\2\u015c\u015d\7\64\2\2\u015d\63\3\2\2\2\u015e\u015f\5\66"+
		"\34\2\u015f\65\3\2\2\2\u0160\u0161\b\34\1\2\u0161\u0162\t\2\2\2\u0162"+
		"\u0174\5\66\34\2\u0163\u0164\7&\2\2\u0164\u0174\5\66\34\2\u0165\u0174"+
		"\5N(\2\u0166\u0167\7*\2\2\u0167\u0174\5B\"\2\u0168\u0174\5<\37\2\u0169"+
		"\u016c\58\35\2\u016a\u016b\7&\2\2\u016b\u016d\5\66\34\2\u016c\u016a\3"+
		"\2\2\2\u016c\u016d\3\2\2\2\u016d\u0174\3\2\2\2\u016e\u0174\5J&\2\u016f"+
		"\u0170\7\25\2\2\u0170\u0171\5\66\34\2\u0171\u0172\7\26\2\2\u0172\u0174"+
		"\3\2\2\2\u0173\u0160\3\2\2\2\u0173\u0163\3\2\2\2\u0173\u0165\3\2\2\2\u0173"+
		"\u0166\3\2\2\2\u0173\u0168\3\2\2\2\u0173\u0169\3\2\2\2\u0173\u016e\3\2"+
		"\2\2\u0173\u016f\3\2\2\2\u0174\u0199\3\2\2\2\u0175\u0176\6\34\2\3\u0176"+
		"\u0177\t\3\2\2\u0177\u0198\5\66\34\2\u0178\u0179\6\34\3\3\u0179\u017a"+
		"\t\2\2\2\u017a\u0198\5\66\34\2\u017b\u0182\6\34\4\3\u017c\u017d\7%\2\2"+
		"\u017d\u0183\7#\2\2\u017e\u017f\7$\2\2\u017f\u0183\7#\2\2\u0180\u0183"+
		"\7$\2\2\u0181\u0183\7%\2\2\u0182\u017c\3\2\2\2\u0182\u017e\3\2\2\2\u0182"+
		"\u0180\3\2\2\2\u0182\u0181\3\2\2\2\u0183\u0184\3\2\2\2\u0184\u0198\5\66"+
		"\34\2\u0185\u0186\6\34\5\3\u0186\u0187\t\4\2\2\u0187\u0198\5\66\34\2\u0188"+
		"\u0189\6\34\6\3\u0189\u018a\7\'\2\2\u018a\u0198\5\66\34\2\u018b\u018c"+
		"\6\34\7\3\u018c\u018d\7(\2\2\u018d\u0198\5\66\34\2\u018e\u018f\6\34\b"+
		"\3\u018f\u0191\7)\2\2\u0190\u0192\5\66\34\2\u0191\u0190\3\2\2\2\u0191"+
		"\u0192\3\2\2\2\u0192\u0193\3\2\2\2\u0193\u0195\7\60\2\2\u0194\u0196\5"+
		"\66\34\2\u0195\u0194\3\2\2\2\u0195\u0196\3\2\2\2\u0196\u0198\3\2\2\2\u0197"+
		"\u0175\3\2\2\2\u0197\u0178\3\2\2\2\u0197\u017b\3\2\2\2\u0197\u0185\3\2"+
		"\2\2\u0197\u0188\3\2\2\2\u0197\u018b\3\2\2\2\u0197\u018e\3\2\2\2\u0198"+
		"\u019b\3\2\2\2\u0199\u0197\3\2\2\2\u0199\u019a\3\2\2\2\u019a\67\3\2\2"+
		"\2\u019b\u0199\3\2\2\2\u019c\u01a0\7;\2\2\u019d\u019f\5:\36\2\u019e\u019d"+
		"\3\2\2\2\u019f\u01a2\3\2\2\2\u01a0\u019e\3\2\2\2\u01a0\u01a1\3\2\2\2\u01a1"+
		"9\3\2\2\2\u01a2\u01a0\3\2\2\2\u01a3\u01a4\7\61\2\2\u01a4\u01ac\7;\2\2"+
		"\u01a5\u01a6\7\33\2\2\u01a6\u01ac\7;\2\2\u01a7\u01a8\7\27\2\2\u01a8\u01a9"+
		"\5\66\34\2\u01a9\u01aa\7\30\2\2\u01aa\u01ac\3\2\2\2\u01ab\u01a3\3\2\2"+
		"\2\u01ab\u01a5\3\2\2\2\u01ab\u01a7\3\2\2\2\u01ac;\3\2\2\2\u01ad\u01ae"+
		"\5@!\2\u01ae\u01b0\7\25\2\2\u01af\u01b1\5(\25\2\u01b0\u01af\3\2\2\2\u01b0"+
		"\u01b1\3\2\2\2\u01b1\u01b2\3\2\2\2\u01b2\u01b6\7\26\2\2\u01b3\u01b5\5"+
		":\36\2\u01b4\u01b3\3\2\2\2\u01b5\u01b8\3\2\2\2\u01b6\u01b4\3\2\2\2\u01b6"+
		"\u01b7\3\2\2\2\u01b7=\3\2\2\2\u01b8\u01b6\3\2\2\2\u01b9\u01ba\5@!\2\u01ba"+
		"\u01bc\7\25\2\2\u01bb\u01bd\5(\25\2\u01bc\u01bb\3\2\2\2\u01bc\u01bd\3"+
		"\2\2\2\u01bd\u01be\3\2\2\2\u01be\u01bf\7\26\2\2\u01bf\u01c0\5\4\3\2\u01c0"+
		"?\3\2\2\2\u01c1\u01c6\7;\2\2\u01c2\u01c3\7\61\2\2\u01c3\u01c5\7;\2\2\u01c4"+
		"\u01c2\3\2\2\2\u01c5\u01c8\3\2\2\2\u01c6\u01c4\3\2\2\2\u01c6\u01c7\3\2"+
		"\2\2\u01c7A\3\2\2\2\u01c8\u01c6\3\2\2\2\u01c9\u01d0\5H%\2\u01ca\u01cf"+
		"\5D#\2\u01cb\u01cf\5F$\2\u01cc\u01cd\7\61\2\2\u01cd\u01cf\5H%\2\u01ce"+
		"\u01ca\3\2\2\2\u01ce\u01cb\3\2\2\2\u01ce\u01cc\3\2\2\2\u01cf\u01d2\3\2"+
		"\2\2\u01d0\u01ce\3\2\2\2\u01d0\u01d1\3\2\2\2\u01d1C\3\2\2\2\u01d2\u01d0"+
		"\3\2\2\2\u01d3\u01dc\7\25\2\2\u01d4\u01d9\5\66\34\2\u01d5\u01d6\7/\2\2"+
		"\u01d6\u01d8\5\66\34\2\u01d7\u01d5\3\2\2\2\u01d8\u01db\3\2\2\2\u01d9\u01d7"+
		"\3\2\2\2\u01d9\u01da\3\2\2\2\u01da\u01dd\3\2\2\2\u01db\u01d9\3\2\2\2\u01dc"+
		"\u01d4\3\2\2\2\u01dc\u01dd\3\2\2\2\u01dd\u01de\3\2\2\2\u01de\u01df\7\26"+
		"\2\2\u01dfE\3\2\2\2\u01e0\u01e1\7\27\2\2\u01e1\u01e2\5\66\34\2\u01e2\u01e3"+
		"\7\30\2\2\u01e3G\3\2\2\2\u01e4\u01e9\7;\2\2\u01e5\u01e6\7\61\2\2\u01e6"+
		"\u01e8\7;\2\2\u01e7\u01e5\3\2\2\2\u01e8\u01eb\3\2\2\2\u01e9\u01e7\3\2"+
		"\2\2\u01e9\u01ea\3\2\2\2\u01eaI\3\2\2\2\u01eb\u01e9\3\2\2\2\u01ec\u01f5"+
		"\7\27\2\2\u01ed\u01f2\5\66\34\2\u01ee\u01ef\7/\2\2\u01ef\u01f1\5\66\34"+
		"\2\u01f0\u01ee\3\2\2\2\u01f1\u01f4\3\2\2\2\u01f2\u01f0\3\2\2\2\u01f2\u01f3"+
		"\3\2\2\2\u01f3\u01f6\3\2\2\2\u01f4\u01f2\3\2\2\2\u01f5\u01ed\3\2\2\2\u01f5"+
		"\u01f6\3\2\2\2\u01f6\u01f7\3\2\2\2\u01f7\u0205\7\30\2\2\u01f8\u0201\7"+
		"\23\2\2\u01f9\u01fe\5L\'\2\u01fa\u01fb\7/\2\2\u01fb\u01fd\5L\'\2\u01fc"+
		"\u01fa\3\2\2\2\u01fd\u0200\3\2\2\2\u01fe\u01fc\3\2\2\2\u01fe\u01ff\3\2"+
		"\2\2\u01ff\u0202\3\2\2\2\u0200\u01fe\3\2\2\2\u0201\u01f9\3\2\2\2\u0201"+
		"\u0202\3\2\2\2\u0202\u0203\3\2\2\2\u0203\u0205\7\24\2\2\u0204\u01ec\3"+
		"\2\2\2\u0204\u01f8\3\2\2\2\u0205K\3\2\2\2\u0206\u0207\7:\2\2\u0207\u0208"+
		"\7\60\2\2\u0208\u020d\5\66\34\2\u0209\u020a\7;\2\2\u020a\u020b\7\60\2"+
		"\2\u020b\u020d\5\66\34\2\u020c\u0206\3\2\2\2\u020c\u0209\3\2\2\2\u020d"+
		"M\3\2\2\2\u020e\u0214\7\67\2\2\u020f\u0214\79\2\2\u0210\u0214\7:\2\2\u0211"+
		"\u0214\5P)\2\u0212\u0214\7+\2\2\u0213\u020e\3\2\2\2\u0213\u020f\3\2\2"+
		"\2\u0213\u0210\3\2\2\2\u0213\u0211\3\2\2\2\u0213\u0212\3\2\2\2\u0214O"+
		"\3\2\2\2\u0215\u0216\t\5\2\2\u0216Q\3\2\2\2\u0217\u0219\7\25\2\2\u0218"+
		"\u021a\5(\25\2\u0219\u0218\3\2\2\2\u0219\u021a\3\2\2\2\u021a\u021b\3\2"+
		"\2\2\u021b\u021c\7\26\2\2\u021cS\3\2\2\2:W`ox\u0086\u008e\u0092\u00a6"+
		"\u00b6\u00ba\u00c2\u00cb\u00d3\u00d9\u00dd\u00e7\u00ee\u00f6\u00fe\u0108"+
		"\u010e\u0114\u011c\u0121\u012a\u012d\u013c\u014c\u0151\u0158\u016c\u0173"+
		"\u0182\u0191\u0195\u0197\u0199\u01a0\u01ab\u01b0\u01b6\u01bc\u01c6\u01ce"+
		"\u01d0\u01d9\u01dc\u01e9\u01f2\u01f5\u01fe\u0201\u0204\u020c\u0213\u0219";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}