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
		Switch=5, Try=14, LEFT_TEXT_TOKEN=50, OctalLiteral=53, MOD=29, CharacterLiteral=55, 
		PARAS=61, INCREASE=22, While=4, NOT=35, Case=12, AND=36, RIGHT_TOKEN=49, 
		RIGHT_SQBR=21, DECREASE=23, Identifier=57, Default=13, AT=39, NOT_EQUAL=31, 
		COMMA=44, LEFT_TOKEN=48, EQUAL=30, LESS=34, LEFT_PAR=18, Select=6, MUlTIP=27, 
		Return=7, VIRTUAL=24, If=1, LEFT_SQBR=20, ADD=25, RIGHT_BRACE=17, HexLiteral=51, 
		QUESTOIN=38, Continue=9, LINE_COMMENT=59, Catch=15, PERIOD=46, NULL=40, 
		ASSIN=32, COMMENT_OPEN=60, MIN=26, Directive=11, DecimalLiteral=52, For=2, 
		TRUE=41, StringLiteral=56, COLON=45, WS=58, COMMENT_END=63, Break=8, FOR_IN=47, 
		LEFT_BRACE=16, WS1=62, FloatingPointLiteral=54, RIGHT_PAR=19, OR=37, LARGE=33, 
		DIV=28, END=43, Else=3, FALSE=42, Var=10;
	public static final String[] tokenNames = {
		"<INVALID>", "'if'", "'for'", "'else'", "'while'", "'switch'", "'select'", 
		"'return'", "'break'", "'continue'", "'var'", "Directive", "'case'", "'default'", 
		"'try'", "'catch'", "'{'", "'}'", "'('", "')'", "'['", "']'", "'++'", 
		"'--'", "'.~'", "'+'", "'-'", "'*'", "'/'", "'%'", "'=='", "'!='", "'='", 
		"'>'", "'<'", "'!'", "'&&'", "'||'", "'?'", "'@'", "'null'", "'true'", 
		"'false'", "';'", "','", "':'", "'.'", "'in'", "'<<'", "'>>'", "'<$'", 
		"HexLiteral", "DecimalLiteral", "OctalLiteral", "FloatingPointLiteral", 
		"CharacterLiteral", "StringLiteral", "Identifier", "WS", "LINE_COMMENT", 
		"COMMENT_OPEN", "PARAS", "WS1", "COMMENT_END"
	};
	public static final int
		RULE_prog = 0, RULE_block = 1, RULE_statement = 2, RULE_directiveExp = 3, 
		RULE_g_switchStatment = 4, RULE_g_caseStatment = 5, RULE_g_defaultStatment = 6, 
		RULE_varDeclareList = 7, RULE_assignMent = 8, RULE_switchBlock = 9, RULE_switchBlockStatementGroup = 10, 
		RULE_switchLabel = 11, RULE_forControl = 12, RULE_parExpression = 13, 
		RULE_expressionList = 14, RULE_statementExpression = 15, RULE_textStatment = 16, 
		RULE_textVar = 17, RULE_textformat = 18, RULE_constantsTextStatment = 19, 
		RULE_constantExpression = 20, RULE_expression = 21, RULE_varRef = 22, 
		RULE_varAttribute = 23, RULE_functionCall = 24, RULE_functionTagCall = 25, 
		RULE_functionNs = 26, RULE_nativeCall = 27, RULE_nativeMethod = 28, RULE_nativeArray = 29, 
		RULE_nativeVarRefChain = 30, RULE_json = 31, RULE_jsonKeyValue = 32, RULE_literal = 33, 
		RULE_integerLiteral = 34, RULE_booleanLiteral = 35, RULE_arguments = 36;
	public static final String[] ruleNames = {
		"prog", "block", "statement", "directiveExp", "g_switchStatment", "g_caseStatment", 
		"g_defaultStatment", "varDeclareList", "assignMent", "switchBlock", "switchBlockStatementGroup", 
		"switchLabel", "forControl", "parExpression", "expressionList", "statementExpression", 
		"textStatment", "textVar", "textformat", "constantsTextStatment", "constantExpression", 
		"expression", "varRef", "varAttribute", "functionCall", "functionTagCall", 
		"functionNs", "nativeCall", "nativeMethod", "nativeArray", "nativeVarRefChain", 
		"json", "jsonKeyValue", "literal", "integerLiteral", "booleanLiteral", 
		"arguments"
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
			setState(77);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << If) | (1L << For) | (1L << While) | (1L << Switch) | (1L << Select) | (1L << Return) | (1L << Break) | (1L << Continue) | (1L << Var) | (1L << Directive) | (1L << Try) | (1L << LEFT_BRACE) | (1L << LEFT_PAR) | (1L << LEFT_SQBR) | (1L << INCREASE) | (1L << DECREASE) | (1L << ADD) | (1L << MIN) | (1L << NOT) | (1L << AT) | (1L << NULL) | (1L << TRUE) | (1L << FALSE) | (1L << LEFT_TOKEN) | (1L << LEFT_TEXT_TOKEN) | (1L << HexLiteral) | (1L << DecimalLiteral) | (1L << OctalLiteral) | (1L << FloatingPointLiteral) | (1L << CharacterLiteral) | (1L << StringLiteral) | (1L << Identifier) | (1L << PARAS))) != 0)) {
				{
				{
				setState(74); statement();
				}
				}
				setState(79);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(80); match(EOF);
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
		enterRule(_localctx, 2, RULE_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(82); match(LEFT_BRACE);
			setState(86);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << If) | (1L << For) | (1L << While) | (1L << Switch) | (1L << Select) | (1L << Return) | (1L << Break) | (1L << Continue) | (1L << Var) | (1L << Directive) | (1L << Try) | (1L << LEFT_BRACE) | (1L << LEFT_PAR) | (1L << LEFT_SQBR) | (1L << INCREASE) | (1L << DECREASE) | (1L << ADD) | (1L << MIN) | (1L << NOT) | (1L << AT) | (1L << NULL) | (1L << TRUE) | (1L << FALSE) | (1L << LEFT_TOKEN) | (1L << LEFT_TEXT_TOKEN) | (1L << HexLiteral) | (1L << DecimalLiteral) | (1L << OctalLiteral) | (1L << FloatingPointLiteral) | (1L << CharacterLiteral) | (1L << StringLiteral) | (1L << Identifier) | (1L << PARAS))) != 0)) {
				{
				{
				setState(83); statement();
				}
				}
				setState(88);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(89); match(RIGHT_BRACE);
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
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public TerminalNode For() { return getToken(BeetlParser.For, 0); }
		public TerminalNode RIGHT_PAR() { return getToken(BeetlParser.RIGHT_PAR, 0); }
		public TerminalNode LEFT_PAR() { return getToken(BeetlParser.LEFT_PAR, 0); }
		public ForControlContext forControl() {
			return getRuleContext(ForControlContext.class,0);
		}
		public ForStContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BeetlParserListener ) ((BeetlParserListener)listener).enterForSt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BeetlParserListener ) ((BeetlParserListener)listener).exitForSt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BeetlParserVisitor ) return ((BeetlParserVisitor<? extends T>)visitor).visitForSt(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BlockStContext extends StatementContext {
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public BlockStContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BeetlParserListener ) ((BeetlParserListener)listener).enterBlockSt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BeetlParserListener ) ((BeetlParserListener)listener).exitBlockSt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BeetlParserVisitor ) return ((BeetlParserVisitor<? extends T>)visitor).visitBlockSt(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class StatmentExpStContext extends StatementContext {
		public StatementExpressionContext statementExpression() {
			return getRuleContext(StatementExpressionContext.class,0);
		}
		public TerminalNode END() { return getToken(BeetlParser.END, 0); }
		public StatmentExpStContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BeetlParserListener ) ((BeetlParserListener)listener).enterStatmentExpSt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BeetlParserListener ) ((BeetlParserListener)listener).exitStatmentExpSt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BeetlParserVisitor ) return ((BeetlParserVisitor<? extends T>)visitor).visitStatmentExpSt(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ReturnStContext extends StatementContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode Return() { return getToken(BeetlParser.Return, 0); }
		public TerminalNode END() { return getToken(BeetlParser.END, 0); }
		public ReturnStContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BeetlParserListener ) ((BeetlParserListener)listener).enterReturnSt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BeetlParserListener ) ((BeetlParserListener)listener).exitReturnSt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BeetlParserVisitor ) return ((BeetlParserVisitor<? extends T>)visitor).visitReturnSt(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BreakStContext extends StatementContext {
		public TerminalNode Break() { return getToken(BeetlParser.Break, 0); }
		public TerminalNode END() { return getToken(BeetlParser.END, 0); }
		public BreakStContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BeetlParserListener ) ((BeetlParserListener)listener).enterBreakSt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BeetlParserListener ) ((BeetlParserListener)listener).exitBreakSt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BeetlParserVisitor ) return ((BeetlParserVisitor<? extends T>)visitor).visitBreakSt(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class DirectiveStContext extends StatementContext {
		public DirectiveExpContext directiveExp() {
			return getRuleContext(DirectiveExpContext.class,0);
		}
		public TerminalNode Directive() { return getToken(BeetlParser.Directive, 0); }
		public DirectiveStContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BeetlParserListener ) ((BeetlParserListener)listener).enterDirectiveSt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BeetlParserListener ) ((BeetlParserListener)listener).exitDirectiveSt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BeetlParserVisitor ) return ((BeetlParserVisitor<? extends T>)visitor).visitDirectiveSt(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class TextOutputStContext extends StatementContext {
		public TextStatmentContext textStatment() {
			return getRuleContext(TextStatmentContext.class,0);
		}
		public TextOutputStContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BeetlParserListener ) ((BeetlParserListener)listener).enterTextOutputSt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BeetlParserListener ) ((BeetlParserListener)listener).exitTextOutputSt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BeetlParserVisitor ) return ((BeetlParserVisitor<? extends T>)visitor).visitTextOutputSt(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class VarStContext extends StatementContext {
		public TerminalNode Var() { return getToken(BeetlParser.Var, 0); }
		public TerminalNode END() { return getToken(BeetlParser.END, 0); }
		public VarDeclareListContext varDeclareList() {
			return getRuleContext(VarDeclareListContext.class,0);
		}
		public VarStContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BeetlParserListener ) ((BeetlParserListener)listener).enterVarSt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BeetlParserListener ) ((BeetlParserListener)listener).exitVarSt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BeetlParserVisitor ) return ((BeetlParserVisitor<? extends T>)visitor).visitVarSt(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class StaticOutputStContext extends StatementContext {
		public ConstantsTextStatmentContext constantsTextStatment() {
			return getRuleContext(ConstantsTextStatmentContext.class,0);
		}
		public StaticOutputStContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BeetlParserListener ) ((BeetlParserListener)listener).enterStaticOutputSt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BeetlParserListener ) ((BeetlParserListener)listener).exitStaticOutputSt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BeetlParserVisitor ) return ((BeetlParserVisitor<? extends T>)visitor).visitStaticOutputSt(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ContinueStContext extends StatementContext {
		public TerminalNode Continue() { return getToken(BeetlParser.Continue, 0); }
		public TerminalNode END() { return getToken(BeetlParser.END, 0); }
		public ContinueStContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BeetlParserListener ) ((BeetlParserListener)listener).enterContinueSt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BeetlParserListener ) ((BeetlParserListener)listener).exitContinueSt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BeetlParserVisitor ) return ((BeetlParserVisitor<? extends T>)visitor).visitContinueSt(this);
			else return visitor.visitChildren(this);
		}
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
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BeetlParserListener ) ((BeetlParserListener)listener).enterIfSt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BeetlParserListener ) ((BeetlParserListener)listener).exitIfSt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BeetlParserVisitor ) return ((BeetlParserVisitor<? extends T>)visitor).visitIfSt(this);
			else return visitor.visitChildren(this);
		}
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
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BeetlParserListener ) ((BeetlParserListener)listener).enterTrySt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BeetlParserListener ) ((BeetlParserListener)listener).exitTrySt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BeetlParserVisitor ) return ((BeetlParserVisitor<? extends T>)visitor).visitTrySt(this);
			else return visitor.visitChildren(this);
		}
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
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BeetlParserListener ) ((BeetlParserListener)listener).enterWhileSt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BeetlParserListener ) ((BeetlParserListener)listener).exitWhileSt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BeetlParserVisitor ) return ((BeetlParserVisitor<? extends T>)visitor).visitWhileSt(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class FunctionStContext extends StatementContext {
		public FunctionTagCallContext functionTagCall() {
			return getRuleContext(FunctionTagCallContext.class,0);
		}
		public FunctionStContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BeetlParserListener ) ((BeetlParserListener)listener).enterFunctionSt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BeetlParserListener ) ((BeetlParserListener)listener).exitFunctionSt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BeetlParserVisitor ) return ((BeetlParserVisitor<? extends T>)visitor).visitFunctionSt(this);
			else return visitor.visitChildren(this);
		}
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
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BeetlParserListener ) ((BeetlParserListener)listener).enterSiwchSt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BeetlParserListener ) ((BeetlParserListener)listener).exitSiwchSt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BeetlParserVisitor ) return ((BeetlParserVisitor<? extends T>)visitor).visitSiwchSt(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class CommentParasStContext extends StatementContext {
		public TerminalNode PARAS() { return getToken(BeetlParser.PARAS, 0); }
		public CommentParasStContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BeetlParserListener ) ((BeetlParserListener)listener).enterCommentParasSt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BeetlParserListener ) ((BeetlParserListener)listener).exitCommentParasSt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BeetlParserVisitor ) return ((BeetlParserVisitor<? extends T>)visitor).visitCommentParasSt(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AssignStContext extends StatementContext {
		public AssignMentContext assignMent() {
			return getRuleContext(AssignMentContext.class,0);
		}
		public TerminalNode END() { return getToken(BeetlParser.END, 0); }
		public AssignStContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BeetlParserListener ) ((BeetlParserListener)listener).enterAssignSt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BeetlParserListener ) ((BeetlParserListener)listener).exitAssignSt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BeetlParserVisitor ) return ((BeetlParserVisitor<? extends T>)visitor).visitAssignSt(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SelectStContext extends StatementContext {
		public G_switchStatmentContext g_switchStatment() {
			return getRuleContext(G_switchStatmentContext.class,0);
		}
		public TerminalNode Select() { return getToken(BeetlParser.Select, 0); }
		public SelectStContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BeetlParserListener ) ((BeetlParserListener)listener).enterSelectSt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BeetlParserListener ) ((BeetlParserListener)listener).exitSelectSt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BeetlParserVisitor ) return ((BeetlParserVisitor<? extends T>)visitor).visitSelectSt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_statement);
		int _la;
		try {
			setState(152);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				_localctx = new BlockStContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(91); block();
				}
				break;

			case 2:
				_localctx = new TextOutputStContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(92); textStatment();
				}
				break;

			case 3:
				_localctx = new StaticOutputStContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(93); constantsTextStatment();
				}
				break;

			case 4:
				_localctx = new CommentParasStContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(94); match(PARAS);
				}
				break;

			case 5:
				_localctx = new IfStContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(95); match(If);
				setState(96); parExpression();
				setState(97); statement();
				setState(100);
				switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
				case 1:
					{
					setState(98); match(Else);
					setState(99); statement();
					}
					break;
				}
				}
				break;

			case 6:
				_localctx = new ForStContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(102); match(For);
				setState(103); match(LEFT_PAR);
				setState(104); forControl();
				setState(105); match(RIGHT_PAR);
				setState(106); statement();
				}
				break;

			case 7:
				_localctx = new WhileStContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(108); match(While);
				setState(109); parExpression();
				setState(110); statement();
				}
				break;

			case 8:
				_localctx = new SiwchStContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(112); match(Switch);
				setState(113); parExpression();
				setState(114); switchBlock();
				}
				break;

			case 9:
				_localctx = new SelectStContext(_localctx);
				enterOuterAlt(_localctx, 9);
				{
				setState(116); match(Select);
				setState(117); g_switchStatment();
				}
				break;

			case 10:
				_localctx = new TryStContext(_localctx);
				enterOuterAlt(_localctx, 10);
				{
				setState(118); match(Try);
				setState(120);
				_la = _input.LA(1);
				if (_la==NOT) {
					{
					setState(119); match(NOT);
					}
				}

				setState(122); block();
				setState(128);
				_la = _input.LA(1);
				if (_la==Catch) {
					{
					setState(123); match(Catch);
					setState(124); match(LEFT_PAR);
					setState(125); match(Identifier);
					setState(126); match(RIGHT_PAR);
					setState(127); block();
					}
				}

				}
				break;

			case 11:
				_localctx = new ReturnStContext(_localctx);
				enterOuterAlt(_localctx, 11);
				{
				setState(130); match(Return);
				setState(132);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LEFT_BRACE) | (1L << LEFT_PAR) | (1L << LEFT_SQBR) | (1L << INCREASE) | (1L << DECREASE) | (1L << ADD) | (1L << MIN) | (1L << NOT) | (1L << AT) | (1L << NULL) | (1L << TRUE) | (1L << FALSE) | (1L << HexLiteral) | (1L << DecimalLiteral) | (1L << OctalLiteral) | (1L << FloatingPointLiteral) | (1L << CharacterLiteral) | (1L << StringLiteral) | (1L << Identifier))) != 0)) {
					{
					setState(131); expression(0);
					}
				}

				setState(134); match(END);
				}
				break;

			case 12:
				_localctx = new BreakStContext(_localctx);
				enterOuterAlt(_localctx, 12);
				{
				setState(135); match(Break);
				setState(136); match(END);
				}
				break;

			case 13:
				_localctx = new ContinueStContext(_localctx);
				enterOuterAlt(_localctx, 13);
				{
				setState(137); match(Continue);
				setState(138); match(END);
				}
				break;

			case 14:
				_localctx = new VarStContext(_localctx);
				enterOuterAlt(_localctx, 14);
				{
				setState(139); match(Var);
				setState(140); varDeclareList();
				setState(141); match(END);
				}
				break;

			case 15:
				_localctx = new DirectiveStContext(_localctx);
				enterOuterAlt(_localctx, 15);
				{
				setState(143); match(Directive);
				setState(144); directiveExp();
				}
				break;

			case 16:
				_localctx = new AssignStContext(_localctx);
				enterOuterAlt(_localctx, 16);
				{
				setState(145); assignMent();
				setState(146); match(END);
				}
				break;

			case 17:
				_localctx = new FunctionStContext(_localctx);
				enterOuterAlt(_localctx, 17);
				{
				setState(148); functionTagCall();
				}
				break;

			case 18:
				_localctx = new StatmentExpStContext(_localctx);
				enterOuterAlt(_localctx, 18);
				{
				setState(149); statementExpression();
				setState(150); match(END);
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
		enterRule(_localctx, 6, RULE_directiveExp);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(154); match(Identifier);
			setState(156);
			_la = _input.LA(1);
			if (_la==StringLiteral) {
				{
				setState(155); match(StringLiteral);
				}
			}

			setState(158); match(END);
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
		enterRule(_localctx, 8, RULE_g_switchStatment);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(164);
			_la = _input.LA(1);
			if (_la==LEFT_PAR) {
				{
				setState(160); match(LEFT_PAR);
				setState(161); ((G_switchStatmentContext)_localctx).base = expression(0);
				setState(162); match(RIGHT_PAR);
				}
			}

			setState(166); match(LEFT_BRACE);
			setState(170);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Case) {
				{
				{
				setState(167); g_caseStatment();
				}
				}
				setState(172);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(174);
			_la = _input.LA(1);
			if (_la==Default) {
				{
				setState(173); g_defaultStatment();
				}
			}

			setState(176); match(RIGHT_BRACE);
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
		enterRule(_localctx, 10, RULE_g_caseStatment);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(178); match(Case);
			setState(179); expression(0);
			setState(184);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(180); match(COMMA);
				setState(181); expression(0);
				}
				}
				setState(186);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(187); match(COLON);
			setState(188); statement();
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
		enterRule(_localctx, 12, RULE_g_defaultStatment);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(190); match(Default);
			setState(191); match(COLON);
			setState(192); statement();
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
		enterRule(_localctx, 14, RULE_varDeclareList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(194); assignMent();
			setState(199);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(195); match(COMMA);
				setState(196); assignMent();
				}
				}
				setState(201);
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
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BeetlParserListener ) ((BeetlParserListener)listener).enterAssignTemplateVar(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BeetlParserListener ) ((BeetlParserListener)listener).exitAssignTemplateVar(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BeetlParserVisitor ) return ((BeetlParserVisitor<? extends T>)visitor).visitAssignTemplateVar(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AssignGeneralContext extends AssignMentContext {
		public TerminalNode ASSIN() { return getToken(BeetlParser.ASSIN, 0); }
		public TerminalNode Identifier() { return getToken(BeetlParser.Identifier, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public AssignGeneralContext(AssignMentContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BeetlParserListener ) ((BeetlParserListener)listener).enterAssignGeneral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BeetlParserListener ) ((BeetlParserListener)listener).exitAssignGeneral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BeetlParserVisitor ) return ((BeetlParserVisitor<? extends T>)visitor).visitAssignGeneral(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AssignIdContext extends AssignMentContext {
		public TerminalNode Identifier() { return getToken(BeetlParser.Identifier, 0); }
		public AssignIdContext(AssignMentContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BeetlParserListener ) ((BeetlParserListener)listener).enterAssignId(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BeetlParserListener ) ((BeetlParserListener)listener).exitAssignId(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BeetlParserVisitor ) return ((BeetlParserVisitor<? extends T>)visitor).visitAssignId(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssignMentContext assignMent() throws RecognitionException {
		AssignMentContext _localctx = new AssignMentContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_assignMent);
		try {
			setState(209);
			switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
			case 1:
				_localctx = new AssignIdContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(202); match(Identifier);
				}
				break;

			case 2:
				_localctx = new AssignGeneralContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(203); match(Identifier);
				setState(204); match(ASSIN);
				setState(205); expression(0);
				}
				break;

			case 3:
				_localctx = new AssignTemplateVarContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(206); match(Identifier);
				setState(207); match(ASSIN);
				setState(208); block();
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
		enterRule(_localctx, 18, RULE_switchBlock);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(211); match(LEFT_BRACE);
			setState(215);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					{
					{
					setState(212); switchBlockStatementGroup();
					}
					} 
				}
				setState(217);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
			}
			setState(221);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Case || _la==Default) {
				{
				{
				setState(218); switchLabel();
				}
				}
				setState(223);
				_errHandler.sync(this);
				_la = _input.LA(1);
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
		enterRule(_localctx, 20, RULE_switchBlockStatementGroup);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(227); 
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(226); switchLabel();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(229); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
			} while ( _alt!=2 && _alt!=-1 );
			setState(234);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << If) | (1L << For) | (1L << While) | (1L << Switch) | (1L << Select) | (1L << Return) | (1L << Break) | (1L << Continue) | (1L << Var) | (1L << Directive) | (1L << Try) | (1L << LEFT_BRACE) | (1L << LEFT_PAR) | (1L << LEFT_SQBR) | (1L << INCREASE) | (1L << DECREASE) | (1L << ADD) | (1L << MIN) | (1L << NOT) | (1L << AT) | (1L << NULL) | (1L << TRUE) | (1L << FALSE) | (1L << LEFT_TOKEN) | (1L << LEFT_TEXT_TOKEN) | (1L << HexLiteral) | (1L << DecimalLiteral) | (1L << OctalLiteral) | (1L << FloatingPointLiteral) | (1L << CharacterLiteral) | (1L << StringLiteral) | (1L << Identifier) | (1L << PARAS))) != 0)) {
				{
				{
				setState(231); statement();
				}
				}
				setState(236);
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
		enterRule(_localctx, 22, RULE_switchLabel);
		try {
			setState(243);
			switch (_input.LA(1)) {
			case Case:
				enterOuterAlt(_localctx, 1);
				{
				setState(237); match(Case);
				setState(238); expression(0);
				setState(239); match(COLON);
				}
				break;
			case Default:
				enterOuterAlt(_localctx, 2);
				{
				setState(241); match(Default);
				setState(242); match(COLON);
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
		enterRule(_localctx, 24, RULE_forControl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(246);
			_la = _input.LA(1);
			if (_la==Var) {
				{
				setState(245); match(Var);
				}
			}

			setState(248); match(Identifier);
			setState(249); match(FOR_IN);
			setState(250); expression(0);
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
		enterRule(_localctx, 26, RULE_parExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(252); match(LEFT_PAR);
			setState(253); expression(0);
			setState(254); match(RIGHT_PAR);
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
		enterRule(_localctx, 28, RULE_expressionList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(256); expression(0);
			setState(261);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(257); match(COMMA);
				setState(258); expression(0);
				}
				}
				setState(263);
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
		enterRule(_localctx, 30, RULE_statementExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(264); expression(0);
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
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BeetlParserListener ) ((BeetlParserListener)listener).enterTextStatment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BeetlParserListener ) ((BeetlParserListener)listener).exitTextStatment(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BeetlParserVisitor ) return ((BeetlParserVisitor<? extends T>)visitor).visitTextStatment(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TextStatmentContext textStatment() throws RecognitionException {
		TextStatmentContext _localctx = new TextStatmentContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_textStatment);
		try {
			setState(277);
			switch ( getInterpreter().adaptivePredict(_input,21,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(266); match(LEFT_TOKEN);
				setState(267); textVar();
				setState(268); match(RIGHT_TOKEN);
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(270); match(LEFT_TOKEN);
				setState(271); match(NOT);
				setState(272); match(LEFT_PAR);
				setState(273); textVar();
				setState(274); match(RIGHT_PAR);
				setState(275); match(RIGHT_TOKEN);
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
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BeetlParserListener ) ((BeetlParserListener)listener).enterTextVar(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BeetlParserListener ) ((BeetlParserListener)listener).exitTextVar(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BeetlParserVisitor ) return ((BeetlParserVisitor<? extends T>)visitor).visitTextVar(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TextVarContext textVar() throws RecognitionException {
		TextVarContext _localctx = new TextVarContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_textVar);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(279); ((TextVarContext)_localctx).b = expression(0);
			setState(282);
			_la = _input.LA(1);
			if (_la==COMMA) {
				{
				setState(280); match(COMMA);
				setState(281); textformat();
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
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BeetlParserListener ) ((BeetlParserListener)listener).enterTextformat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BeetlParserListener ) ((BeetlParserListener)listener).exitTextformat(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BeetlParserVisitor ) return ((BeetlParserVisitor<? extends T>)visitor).visitTextformat(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TextformatContext textformat() throws RecognitionException {
		TextformatContext _localctx = new TextformatContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_textformat);
		try {
			setState(289);
			switch (_input.LA(1)) {
			case Identifier:
				enterOuterAlt(_localctx, 1);
				{
				setState(284); ((TextformatContext)_localctx).fm = functionNs();
				{
				setState(285); match(ASSIN);
				setState(286); match(StringLiteral);
				}
				}
				break;
			case StringLiteral:
				enterOuterAlt(_localctx, 2);
				{
				setState(288); match(StringLiteral);
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

	public static class ConstantsTextStatmentContext extends ParserRuleContext {
		public IntegerLiteralContext integerLiteral() {
			return getRuleContext(IntegerLiteralContext.class,0);
		}
		public TerminalNode RIGHT_TOKEN() { return getToken(BeetlParser.RIGHT_TOKEN, 0); }
		public TerminalNode LEFT_TEXT_TOKEN() { return getToken(BeetlParser.LEFT_TEXT_TOKEN, 0); }
		public ConstantsTextStatmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constantsTextStatment; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BeetlParserListener ) ((BeetlParserListener)listener).enterConstantsTextStatment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BeetlParserListener ) ((BeetlParserListener)listener).exitConstantsTextStatment(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BeetlParserVisitor ) return ((BeetlParserVisitor<? extends T>)visitor).visitConstantsTextStatment(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConstantsTextStatmentContext constantsTextStatment() throws RecognitionException {
		ConstantsTextStatmentContext _localctx = new ConstantsTextStatmentContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_constantsTextStatment);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(291); match(LEFT_TEXT_TOKEN);
			setState(292); integerLiteral();
			setState(293); match(RIGHT_TOKEN);
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
		enterRule(_localctx, 40, RULE_constantExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(295); expression(0);
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
		public JsonContext json() {
			return getRuleContext(JsonContext.class,0);
		}
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
		int _startState = 42;
		enterRecursionRule(_localctx, RULE_expression);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(314);
			switch ( getInterpreter().adaptivePredict(_input,24,_ctx) ) {
			case 1:
				{
				setState(298);
				_la = _input.LA(1);
				if ( !(_la==ADD || _la==MIN) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				setState(299); expression(12);
				}
				break;

			case 2:
				{
				setState(300);
				_la = _input.LA(1);
				if ( !(_la==INCREASE || _la==DECREASE) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				setState(301); expression(11);
				}
				break;

			case 3:
				{
				setState(302); match(NOT);
				setState(303); expression(10);
				}
				break;

			case 4:
				{
				setState(304); literal();
				}
				break;

			case 5:
				{
				setState(305); match(AT);
				setState(306); nativeCall();
				}
				break;

			case 6:
				{
				setState(307); functionCall();
				}
				break;

			case 7:
				{
				setState(308); varRef();
				}
				break;

			case 8:
				{
				setState(309); json();
				}
				break;

			case 9:
				{
				setState(310); match(LEFT_PAR);
				setState(311); expression(0);
				setState(312); match(RIGHT_PAR);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(359);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,30,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(357);
					switch ( getInterpreter().adaptivePredict(_input,29,_ctx) ) {
					case 1:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState, _p);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(316);
						if (!(9 >= _localctx._p)) throw new FailedPredicateException(this, "9 >= $_p");
						setState(317);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << MUlTIP) | (1L << DIV) | (1L << MOD))) != 0)) ) {
						_errHandler.recoverInline(this);
						}
						consume();
						setState(318); expression(10);
						}
						break;

					case 2:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState, _p);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(319);
						if (!(8 >= _localctx._p)) throw new FailedPredicateException(this, "8 >= $_p");
						setState(320);
						_la = _input.LA(1);
						if ( !(_la==ADD || _la==MIN) ) {
						_errHandler.recoverInline(this);
						}
						consume();
						setState(321); expression(9);
						}
						break;

					case 3:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState, _p);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(322);
						if (!(7 >= _localctx._p)) throw new FailedPredicateException(this, "7 >= $_p");
						setState(329);
						switch ( getInterpreter().adaptivePredict(_input,25,_ctx) ) {
						case 1:
							{
							setState(323); match(LESS);
							setState(324); match(ASSIN);
							}
							break;

						case 2:
							{
							setState(325); match(LARGE);
							setState(326); match(ASSIN);
							}
							break;

						case 3:
							{
							setState(327); match(LARGE);
							}
							break;

						case 4:
							{
							setState(328); match(LESS);
							}
							break;
						}
						setState(331); expression(8);
						}
						break;

					case 4:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState, _p);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(332);
						if (!(6 >= _localctx._p)) throw new FailedPredicateException(this, "6 >= $_p");
						setState(333);
						_la = _input.LA(1);
						if ( !(_la==EQUAL || _la==NOT_EQUAL) ) {
						_errHandler.recoverInline(this);
						}
						consume();
						setState(334); expression(7);
						}
						break;

					case 5:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState, _p);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(335);
						if (!(5 >= _localctx._p)) throw new FailedPredicateException(this, "5 >= $_p");
						setState(336); match(AND);
						setState(337); expression(6);
						}
						break;

					case 6:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState, _p);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(338);
						if (!(4 >= _localctx._p)) throw new FailedPredicateException(this, "4 >= $_p");
						setState(339); match(OR);
						setState(340); expression(5);
						}
						break;

					case 7:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState, _p);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(341);
						if (!(13 >= _localctx._p)) throw new FailedPredicateException(this, "13 >= $_p");
						setState(342);
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
						setState(343);
						if (!(3 >= _localctx._p)) throw new FailedPredicateException(this, "3 >= $_p");
						setState(344); match(QUESTOIN);
						setState(346);
						_la = _input.LA(1);
						if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LEFT_BRACE) | (1L << LEFT_PAR) | (1L << LEFT_SQBR) | (1L << INCREASE) | (1L << DECREASE) | (1L << ADD) | (1L << MIN) | (1L << NOT) | (1L << AT) | (1L << NULL) | (1L << TRUE) | (1L << FALSE) | (1L << HexLiteral) | (1L << DecimalLiteral) | (1L << OctalLiteral) | (1L << FloatingPointLiteral) | (1L << CharacterLiteral) | (1L << StringLiteral) | (1L << Identifier))) != 0)) {
							{
							setState(345); expression(0);
							}
						}

						setState(348); match(COLON);
						setState(350);
						switch ( getInterpreter().adaptivePredict(_input,27,_ctx) ) {
						case 1:
							{
							setState(349); expression(0);
							}
							break;
						}
						}
						break;

					case 9:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState, _p);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(352);
						if (!(2 >= _localctx._p)) throw new FailedPredicateException(this, "2 >= $_p");
						setState(353); match(NOT);
						setState(355);
						switch ( getInterpreter().adaptivePredict(_input,28,_ctx) ) {
						case 1:
							{
							setState(354); expression(0);
							}
							break;
						}
						}
						break;
					}
					} 
				}
				setState(361);
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
		enterRule(_localctx, 44, RULE_varRef);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(362); match(Identifier);
			setState(366);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,31,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					{
					{
					setState(363); varAttribute();
					}
					} 
				}
				setState(368);
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
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BeetlParserListener ) ((BeetlParserListener)listener).enterVarAttributeGeneral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BeetlParserListener ) ((BeetlParserListener)listener).exitVarAttributeGeneral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BeetlParserVisitor ) return ((BeetlParserVisitor<? extends T>)visitor).visitVarAttributeGeneral(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class VarAttributeArrayOrMapContext extends VarAttributeContext {
		public TerminalNode RIGHT_SQBR() { return getToken(BeetlParser.RIGHT_SQBR, 0); }
		public TerminalNode LEFT_SQBR() { return getToken(BeetlParser.LEFT_SQBR, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public VarAttributeArrayOrMapContext(VarAttributeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BeetlParserListener ) ((BeetlParserListener)listener).enterVarAttributeArrayOrMap(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BeetlParserListener ) ((BeetlParserListener)listener).exitVarAttributeArrayOrMap(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BeetlParserVisitor ) return ((BeetlParserVisitor<? extends T>)visitor).visitVarAttributeArrayOrMap(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class VarAttributeVirtualContext extends VarAttributeContext {
		public TerminalNode Identifier() { return getToken(BeetlParser.Identifier, 0); }
		public TerminalNode VIRTUAL() { return getToken(BeetlParser.VIRTUAL, 0); }
		public VarAttributeVirtualContext(VarAttributeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BeetlParserListener ) ((BeetlParserListener)listener).enterVarAttributeVirtual(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BeetlParserListener ) ((BeetlParserListener)listener).exitVarAttributeVirtual(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BeetlParserVisitor ) return ((BeetlParserVisitor<? extends T>)visitor).visitVarAttributeVirtual(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VarAttributeContext varAttribute() throws RecognitionException {
		VarAttributeContext _localctx = new VarAttributeContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_varAttribute);
		try {
			setState(377);
			switch (_input.LA(1)) {
			case PERIOD:
				_localctx = new VarAttributeGeneralContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(369); match(PERIOD);
				setState(370); match(Identifier);
				}
				break;
			case VIRTUAL:
				_localctx = new VarAttributeVirtualContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(371); match(VIRTUAL);
				setState(372); match(Identifier);
				}
				break;
			case LEFT_SQBR:
				_localctx = new VarAttributeArrayOrMapContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(373); match(LEFT_SQBR);
				setState(374); expression(0);
				setState(375); match(RIGHT_SQBR);
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
		enterRule(_localctx, 48, RULE_functionCall);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(379); functionNs();
			setState(380); match(LEFT_PAR);
			setState(382);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LEFT_BRACE) | (1L << LEFT_PAR) | (1L << LEFT_SQBR) | (1L << INCREASE) | (1L << DECREASE) | (1L << ADD) | (1L << MIN) | (1L << NOT) | (1L << AT) | (1L << NULL) | (1L << TRUE) | (1L << FALSE) | (1L << HexLiteral) | (1L << DecimalLiteral) | (1L << OctalLiteral) | (1L << FloatingPointLiteral) | (1L << CharacterLiteral) | (1L << StringLiteral) | (1L << Identifier))) != 0)) {
				{
				setState(381); expressionList();
				}
			}

			setState(384); match(RIGHT_PAR);
			setState(388);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,34,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					{
					{
					setState(385); varAttribute();
					}
					} 
				}
				setState(390);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,34,_ctx);
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
		enterRule(_localctx, 50, RULE_functionTagCall);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(391); functionNs();
			setState(392); match(LEFT_PAR);
			setState(394);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LEFT_BRACE) | (1L << LEFT_PAR) | (1L << LEFT_SQBR) | (1L << INCREASE) | (1L << DECREASE) | (1L << ADD) | (1L << MIN) | (1L << NOT) | (1L << AT) | (1L << NULL) | (1L << TRUE) | (1L << FALSE) | (1L << HexLiteral) | (1L << DecimalLiteral) | (1L << OctalLiteral) | (1L << FloatingPointLiteral) | (1L << CharacterLiteral) | (1L << StringLiteral) | (1L << Identifier))) != 0)) {
				{
				setState(393); expressionList();
				}
			}

			setState(396); match(RIGHT_PAR);
			setState(397); block();
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
		enterRule(_localctx, 52, RULE_functionNs);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(399); match(Identifier);
			setState(404);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==PERIOD) {
				{
				{
				setState(400); match(PERIOD);
				setState(401); match(Identifier);
				}
				}
				setState(406);
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
		enterRule(_localctx, 54, RULE_nativeCall);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(407); nativeVarRefChain();
			setState(414);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,38,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					{
					setState(412);
					switch (_input.LA(1)) {
					case LEFT_PAR:
						{
						setState(408); nativeMethod();
						}
						break;
					case LEFT_SQBR:
						{
						setState(409); nativeArray();
						}
						break;
					case PERIOD:
						{
						setState(410); match(PERIOD);
						setState(411); nativeVarRefChain();
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					} 
				}
				setState(416);
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
		enterRule(_localctx, 56, RULE_nativeMethod);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(417); match(LEFT_PAR);
			setState(426);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LEFT_BRACE) | (1L << LEFT_PAR) | (1L << LEFT_SQBR) | (1L << INCREASE) | (1L << DECREASE) | (1L << ADD) | (1L << MIN) | (1L << NOT) | (1L << AT) | (1L << NULL) | (1L << TRUE) | (1L << FALSE) | (1L << HexLiteral) | (1L << DecimalLiteral) | (1L << OctalLiteral) | (1L << FloatingPointLiteral) | (1L << CharacterLiteral) | (1L << StringLiteral) | (1L << Identifier))) != 0)) {
				{
				setState(418); expression(0);
				setState(423);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(419); match(COMMA);
					setState(420); expression(0);
					}
					}
					setState(425);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(428); match(RIGHT_PAR);
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
		enterRule(_localctx, 58, RULE_nativeArray);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(430); match(LEFT_SQBR);
			setState(431); expression(0);
			setState(432); match(RIGHT_SQBR);
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
		enterRule(_localctx, 60, RULE_nativeVarRefChain);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(434); match(Identifier);
			setState(439);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,41,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					{
					{
					setState(435); match(PERIOD);
					setState(436); match(Identifier);
					}
					} 
				}
				setState(441);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,41,_ctx);
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
		public JsonKeyValueContext jsonKeyValue(int i) {
			return getRuleContext(JsonKeyValueContext.class,i);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public TerminalNode LEFT_BRACE() { return getToken(BeetlParser.LEFT_BRACE, 0); }
		public JsonContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_json; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BeetlParserListener ) ((BeetlParserListener)listener).enterJson(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BeetlParserListener ) ((BeetlParserListener)listener).exitJson(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BeetlParserVisitor ) return ((BeetlParserVisitor<? extends T>)visitor).visitJson(this);
			else return visitor.visitChildren(this);
		}
	}

	public final JsonContext json() throws RecognitionException {
		JsonContext _localctx = new JsonContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_json);
		int _la;
		try {
			setState(466);
			switch (_input.LA(1)) {
			case LEFT_SQBR:
				enterOuterAlt(_localctx, 1);
				{
				setState(442); match(LEFT_SQBR);
				setState(451);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LEFT_BRACE) | (1L << LEFT_PAR) | (1L << LEFT_SQBR) | (1L << INCREASE) | (1L << DECREASE) | (1L << ADD) | (1L << MIN) | (1L << NOT) | (1L << AT) | (1L << NULL) | (1L << TRUE) | (1L << FALSE) | (1L << HexLiteral) | (1L << DecimalLiteral) | (1L << OctalLiteral) | (1L << FloatingPointLiteral) | (1L << CharacterLiteral) | (1L << StringLiteral) | (1L << Identifier))) != 0)) {
					{
					setState(443); expression(0);
					setState(448);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMMA) {
						{
						{
						setState(444); match(COMMA);
						setState(445); expression(0);
						}
						}
						setState(450);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(453); match(RIGHT_SQBR);
				}
				break;
			case LEFT_BRACE:
				enterOuterAlt(_localctx, 2);
				{
				setState(454); match(LEFT_BRACE);
				setState(463);
				_la = _input.LA(1);
				if (_la==StringLiteral || _la==Identifier) {
					{
					setState(455); jsonKeyValue();
					setState(460);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMMA) {
						{
						{
						setState(456); match(COMMA);
						setState(457); jsonKeyValue();
						}
						}
						setState(462);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(465); match(RIGHT_BRACE);
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
		public TerminalNode Identifier() { return getToken(BeetlParser.Identifier, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode StringLiteral() { return getToken(BeetlParser.StringLiteral, 0); }
		public JsonKeyValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_jsonKeyValue; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BeetlParserListener ) ((BeetlParserListener)listener).enterJsonKeyValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BeetlParserListener ) ((BeetlParserListener)listener).exitJsonKeyValue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BeetlParserVisitor ) return ((BeetlParserVisitor<? extends T>)visitor).visitJsonKeyValue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final JsonKeyValueContext jsonKeyValue() throws RecognitionException {
		JsonKeyValueContext _localctx = new JsonKeyValueContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_jsonKeyValue);
		try {
			setState(474);
			switch (_input.LA(1)) {
			case StringLiteral:
				enterOuterAlt(_localctx, 1);
				{
				setState(468); match(StringLiteral);
				setState(469); match(COLON);
				setState(470); expression(0);
				}
				break;
			case Identifier:
				enterOuterAlt(_localctx, 2);
				{
				setState(471); match(Identifier);
				setState(472); match(COLON);
				setState(473); expression(0);
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
		enterRule(_localctx, 66, RULE_literal);
		try {
			setState(482);
			switch (_input.LA(1)) {
			case HexLiteral:
			case DecimalLiteral:
			case OctalLiteral:
				enterOuterAlt(_localctx, 1);
				{
				setState(476); integerLiteral();
				}
				break;
			case FloatingPointLiteral:
				enterOuterAlt(_localctx, 2);
				{
				setState(477); match(FloatingPointLiteral);
				}
				break;
			case CharacterLiteral:
				enterOuterAlt(_localctx, 3);
				{
				setState(478); match(CharacterLiteral);
				}
				break;
			case StringLiteral:
				enterOuterAlt(_localctx, 4);
				{
				setState(479); match(StringLiteral);
				}
				break;
			case TRUE:
			case FALSE:
				enterOuterAlt(_localctx, 5);
				{
				setState(480); booleanLiteral();
				}
				break;
			case NULL:
				enterOuterAlt(_localctx, 6);
				{
				setState(481); match(NULL);
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
		enterRule(_localctx, 68, RULE_integerLiteral);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(484);
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
		enterRule(_localctx, 70, RULE_booleanLiteral);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(486);
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
		enterRule(_localctx, 72, RULE_arguments);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(488); match(LEFT_PAR);
			setState(490);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LEFT_BRACE) | (1L << LEFT_PAR) | (1L << LEFT_SQBR) | (1L << INCREASE) | (1L << DECREASE) | (1L << ADD) | (1L << MIN) | (1L << NOT) | (1L << AT) | (1L << NULL) | (1L << TRUE) | (1L << FALSE) | (1L << HexLiteral) | (1L << DecimalLiteral) | (1L << OctalLiteral) | (1L << FloatingPointLiteral) | (1L << CharacterLiteral) | (1L << StringLiteral) | (1L << Identifier))) != 0)) {
				{
				setState(489); expressionList();
				}
			}

			setState(492); match(RIGHT_PAR);
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
		case 21: return expression_sempred((ExpressionContext)_localctx, predIndex);
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
		"\3\uacf5\uee8c\u4f5d\u8b0d\u4a45\u78bd\u1b2f\u3378\3A\u01f1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\3\2\7\2N\n\2\f\2\16\2Q\13\2\3\2\3"+
		"\2\3\3\3\3\7\3W\n\3\f\3\16\3Z\13\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4"+
		"\3\4\3\4\5\4g\n\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4"+
		"\3\4\3\4\3\4\3\4\3\4\5\4{\n\4\3\4\3\4\3\4\3\4\3\4\3\4\5\4\u0083\n\4\3"+
		"\4\3\4\5\4\u0087\n\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3"+
		"\4\3\4\3\4\3\4\3\4\3\4\5\4\u009b\n\4\3\5\3\5\5\5\u009f\n\5\3\5\3\5\3\6"+
		"\3\6\3\6\3\6\5\6\u00a7\n\6\3\6\3\6\7\6\u00ab\n\6\f\6\16\6\u00ae\13\6\3"+
		"\6\5\6\u00b1\n\6\3\6\3\6\3\7\3\7\3\7\3\7\7\7\u00b9\n\7\f\7\16\7\u00bc"+
		"\13\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\t\3\t\3\t\7\t\u00c8\n\t\f\t\16\t\u00cb"+
		"\13\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\5\n\u00d4\n\n\3\13\3\13\7\13\u00d8\n"+
		"\13\f\13\16\13\u00db\13\13\3\13\7\13\u00de\n\13\f\13\16\13\u00e1\13\13"+
		"\3\13\3\13\3\f\6\f\u00e6\n\f\r\f\16\f\u00e7\3\f\7\f\u00eb\n\f\f\f\16\f"+
		"\u00ee\13\f\3\r\3\r\3\r\3\r\3\r\3\r\5\r\u00f6\n\r\3\16\5\16\u00f9\n\16"+
		"\3\16\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3\20\3\20\3\20\7\20\u0106\n\20"+
		"\f\20\16\20\u0109\13\20\3\21\3\21\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3"+
		"\22\3\22\3\22\3\22\5\22\u0118\n\22\3\23\3\23\3\23\5\23\u011d\n\23\3\24"+
		"\3\24\3\24\3\24\3\24\5\24\u0124\n\24\3\25\3\25\3\25\3\25\3\26\3\26\3\27"+
		"\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27"+
		"\3\27\3\27\5\27\u013d\n\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27"+
		"\3\27\3\27\3\27\3\27\5\27\u014c\n\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27"+
		"\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\5\27\u015d\n\27\3\27\3\27\5\27"+
		"\u0161\n\27\3\27\3\27\3\27\5\27\u0166\n\27\7\27\u0168\n\27\f\27\16\27"+
		"\u016b\13\27\3\30\3\30\7\30\u016f\n\30\f\30\16\30\u0172\13\30\3\31\3\31"+
		"\3\31\3\31\3\31\3\31\3\31\3\31\5\31\u017c\n\31\3\32\3\32\3\32\5\32\u0181"+
		"\n\32\3\32\3\32\7\32\u0185\n\32\f\32\16\32\u0188\13\32\3\33\3\33\3\33"+
		"\5\33\u018d\n\33\3\33\3\33\3\33\3\34\3\34\3\34\7\34\u0195\n\34\f\34\16"+
		"\34\u0198\13\34\3\35\3\35\3\35\3\35\3\35\7\35\u019f\n\35\f\35\16\35\u01a2"+
		"\13\35\3\36\3\36\3\36\3\36\7\36\u01a8\n\36\f\36\16\36\u01ab\13\36\5\36"+
		"\u01ad\n\36\3\36\3\36\3\37\3\37\3\37\3\37\3 \3 \3 \7 \u01b8\n \f \16 "+
		"\u01bb\13 \3!\3!\3!\3!\7!\u01c1\n!\f!\16!\u01c4\13!\5!\u01c6\n!\3!\3!"+
		"\3!\3!\3!\7!\u01cd\n!\f!\16!\u01d0\13!\5!\u01d2\n!\3!\5!\u01d5\n!\3\""+
		"\3\"\3\"\3\"\3\"\3\"\5\"\u01dd\n\"\3#\3#\3#\3#\3#\3#\5#\u01e5\n#\3$\3"+
		"$\3%\3%\3&\3&\5&\u01ed\n&\3&\3&\3&\2\'\2\4\6\b\n\f\16\20\22\24\26\30\32"+
		"\34\36 \"$&(*,.\60\62\64\668:<>@BDFHJ\2\b\3\2\33\34\3\2\30\31\3\2\35\37"+
		"\3\2 !\3\2\65\67\3\2+,\u0224\2O\3\2\2\2\4T\3\2\2\2\6\u009a\3\2\2\2\b\u009c"+
		"\3\2\2\2\n\u00a6\3\2\2\2\f\u00b4\3\2\2\2\16\u00c0\3\2\2\2\20\u00c4\3\2"+
		"\2\2\22\u00d3\3\2\2\2\24\u00d5\3\2\2\2\26\u00e5\3\2\2\2\30\u00f5\3\2\2"+
		"\2\32\u00f8\3\2\2\2\34\u00fe\3\2\2\2\36\u0102\3\2\2\2 \u010a\3\2\2\2\""+
		"\u0117\3\2\2\2$\u0119\3\2\2\2&\u0123\3\2\2\2(\u0125\3\2\2\2*\u0129\3\2"+
		"\2\2,\u013c\3\2\2\2.\u016c\3\2\2\2\60\u017b\3\2\2\2\62\u017d\3\2\2\2\64"+
		"\u0189\3\2\2\2\66\u0191\3\2\2\28\u0199\3\2\2\2:\u01a3\3\2\2\2<\u01b0\3"+
		"\2\2\2>\u01b4\3\2\2\2@\u01d4\3\2\2\2B\u01dc\3\2\2\2D\u01e4\3\2\2\2F\u01e6"+
		"\3\2\2\2H\u01e8\3\2\2\2J\u01ea\3\2\2\2LN\5\6\4\2ML\3\2\2\2NQ\3\2\2\2O"+
		"M\3\2\2\2OP\3\2\2\2PR\3\2\2\2QO\3\2\2\2RS\7\2\2\3S\3\3\2\2\2TX\7\22\2"+
		"\2UW\5\6\4\2VU\3\2\2\2WZ\3\2\2\2XV\3\2\2\2XY\3\2\2\2Y[\3\2\2\2ZX\3\2\2"+
		"\2[\\\7\23\2\2\\\5\3\2\2\2]\u009b\5\4\3\2^\u009b\5\"\22\2_\u009b\5(\25"+
		"\2`\u009b\7?\2\2ab\7\3\2\2bc\5\34\17\2cf\5\6\4\2de\7\5\2\2eg\5\6\4\2f"+
		"d\3\2\2\2fg\3\2\2\2g\u009b\3\2\2\2hi\7\4\2\2ij\7\24\2\2jk\5\32\16\2kl"+
		"\7\25\2\2lm\5\6\4\2m\u009b\3\2\2\2no\7\6\2\2op\5\34\17\2pq\5\6\4\2q\u009b"+
		"\3\2\2\2rs\7\7\2\2st\5\34\17\2tu\5\24\13\2u\u009b\3\2\2\2vw\7\b\2\2w\u009b"+
		"\5\n\6\2xz\7\20\2\2y{\7%\2\2zy\3\2\2\2z{\3\2\2\2{|\3\2\2\2|\u0082\5\4"+
		"\3\2}~\7\21\2\2~\177\7\24\2\2\177\u0080\7;\2\2\u0080\u0081\7\25\2\2\u0081"+
		"\u0083\5\4\3\2\u0082}\3\2\2\2\u0082\u0083\3\2\2\2\u0083\u009b\3\2\2\2"+
		"\u0084\u0086\7\t\2\2\u0085\u0087\5,\27\2\u0086\u0085\3\2\2\2\u0086\u0087"+
		"\3\2\2\2\u0087\u0088\3\2\2\2\u0088\u009b\7-\2\2\u0089\u008a\7\n\2\2\u008a"+
		"\u009b\7-\2\2\u008b\u008c\7\13\2\2\u008c\u009b\7-\2\2\u008d\u008e\7\f"+
		"\2\2\u008e\u008f\5\20\t\2\u008f\u0090\7-\2\2\u0090\u009b\3\2\2\2\u0091"+
		"\u0092\7\r\2\2\u0092\u009b\5\b\5\2\u0093\u0094\5\22\n\2\u0094\u0095\7"+
		"-\2\2\u0095\u009b\3\2\2\2\u0096\u009b\5\64\33\2\u0097\u0098\5 \21\2\u0098"+
		"\u0099\7-\2\2\u0099\u009b\3\2\2\2\u009a]\3\2\2\2\u009a^\3\2\2\2\u009a"+
		"_\3\2\2\2\u009a`\3\2\2\2\u009aa\3\2\2\2\u009ah\3\2\2\2\u009an\3\2\2\2"+
		"\u009ar\3\2\2\2\u009av\3\2\2\2\u009ax\3\2\2\2\u009a\u0084\3\2\2\2\u009a"+
		"\u0089\3\2\2\2\u009a\u008b\3\2\2\2\u009a\u008d\3\2\2\2\u009a\u0091\3\2"+
		"\2\2\u009a\u0093\3\2\2\2\u009a\u0096\3\2\2\2\u009a\u0097\3\2\2\2\u009b"+
		"\7\3\2\2\2\u009c\u009e\7;\2\2\u009d\u009f\7:\2\2\u009e\u009d\3\2\2\2\u009e"+
		"\u009f\3\2\2\2\u009f\u00a0\3\2\2\2\u00a0\u00a1\7-\2\2\u00a1\t\3\2\2\2"+
		"\u00a2\u00a3\7\24\2\2\u00a3\u00a4\5,\27\2\u00a4\u00a5\7\25\2\2\u00a5\u00a7"+
		"\3\2\2\2\u00a6\u00a2\3\2\2\2\u00a6\u00a7\3\2\2\2\u00a7\u00a8\3\2\2\2\u00a8"+
		"\u00ac\7\22\2\2\u00a9\u00ab\5\f\7\2\u00aa\u00a9\3\2\2\2\u00ab\u00ae\3"+
		"\2\2\2\u00ac\u00aa\3\2\2\2\u00ac\u00ad\3\2\2\2\u00ad\u00b0\3\2\2\2\u00ae"+
		"\u00ac\3\2\2\2\u00af\u00b1\5\16\b\2\u00b0\u00af\3\2\2\2\u00b0\u00b1\3"+
		"\2\2\2\u00b1\u00b2\3\2\2\2\u00b2\u00b3\7\23\2\2\u00b3\13\3\2\2\2\u00b4"+
		"\u00b5\7\16\2\2\u00b5\u00ba\5,\27\2\u00b6\u00b7\7.\2\2\u00b7\u00b9\5,"+
		"\27\2\u00b8\u00b6\3\2\2\2\u00b9\u00bc\3\2\2\2\u00ba\u00b8\3\2\2\2\u00ba"+
		"\u00bb\3\2\2\2\u00bb\u00bd\3\2\2\2\u00bc\u00ba\3\2\2\2\u00bd\u00be\7/"+
		"\2\2\u00be\u00bf\5\6\4\2\u00bf\r\3\2\2\2\u00c0\u00c1\7\17\2\2\u00c1\u00c2"+
		"\7/\2\2\u00c2\u00c3\5\6\4\2\u00c3\17\3\2\2\2\u00c4\u00c9\5\22\n\2\u00c5"+
		"\u00c6\7.\2\2\u00c6\u00c8\5\22\n\2\u00c7\u00c5\3\2\2\2\u00c8\u00cb\3\2"+
		"\2\2\u00c9\u00c7\3\2\2\2\u00c9\u00ca\3\2\2\2\u00ca\21\3\2\2\2\u00cb\u00c9"+
		"\3\2\2\2\u00cc\u00d4\7;\2\2\u00cd\u00ce\7;\2\2\u00ce\u00cf\7\"\2\2\u00cf"+
		"\u00d4\5,\27\2\u00d0\u00d1\7;\2\2\u00d1\u00d2\7\"\2\2\u00d2\u00d4\5\4"+
		"\3\2\u00d3\u00cc\3\2\2\2\u00d3\u00cd\3\2\2\2\u00d3\u00d0\3\2\2\2\u00d4"+
		"\23\3\2\2\2\u00d5\u00d9\7\22\2\2\u00d6\u00d8\5\26\f\2\u00d7\u00d6\3\2"+
		"\2\2\u00d8\u00db\3\2\2\2\u00d9\u00d7\3\2\2\2\u00d9\u00da\3\2\2\2\u00da"+
		"\u00df\3\2\2\2\u00db\u00d9\3\2\2\2\u00dc\u00de\5\30\r\2\u00dd\u00dc\3"+
		"\2\2\2\u00de\u00e1\3\2\2\2\u00df\u00dd\3\2\2\2\u00df\u00e0\3\2\2\2\u00e0"+
		"\u00e2\3\2\2\2\u00e1\u00df\3\2\2\2\u00e2\u00e3\7\23\2\2\u00e3\25\3\2\2"+
		"\2\u00e4\u00e6\5\30\r\2\u00e5\u00e4\3\2\2\2\u00e6\u00e7\3\2\2\2\u00e7"+
		"\u00e5\3\2\2\2\u00e7\u00e8\3\2\2\2\u00e8\u00ec\3\2\2\2\u00e9\u00eb\5\6"+
		"\4\2\u00ea\u00e9\3\2\2\2\u00eb\u00ee\3\2\2\2\u00ec\u00ea\3\2\2\2\u00ec"+
		"\u00ed\3\2\2\2\u00ed\27\3\2\2\2\u00ee\u00ec\3\2\2\2\u00ef\u00f0\7\16\2"+
		"\2\u00f0\u00f1\5,\27\2\u00f1\u00f2\7/\2\2\u00f2\u00f6\3\2\2\2\u00f3\u00f4"+
		"\7\17\2\2\u00f4\u00f6\7/\2\2\u00f5\u00ef\3\2\2\2\u00f5\u00f3\3\2\2\2\u00f6"+
		"\31\3\2\2\2\u00f7\u00f9\7\f\2\2\u00f8\u00f7\3\2\2\2\u00f8\u00f9\3\2\2"+
		"\2\u00f9\u00fa\3\2\2\2\u00fa\u00fb\7;\2\2\u00fb\u00fc\7\61\2\2\u00fc\u00fd"+
		"\5,\27\2\u00fd\33\3\2\2\2\u00fe\u00ff\7\24\2\2\u00ff\u0100\5,\27\2\u0100"+
		"\u0101\7\25\2\2\u0101\35\3\2\2\2\u0102\u0107\5,\27\2\u0103\u0104\7.\2"+
		"\2\u0104\u0106\5,\27\2\u0105\u0103\3\2\2\2\u0106\u0109\3\2\2\2\u0107\u0105"+
		"\3\2\2\2\u0107\u0108\3\2\2\2\u0108\37\3\2\2\2\u0109\u0107\3\2\2\2\u010a"+
		"\u010b\5,\27\2\u010b!\3\2\2\2\u010c\u010d\7\62\2\2\u010d\u010e\5$\23\2"+
		"\u010e\u010f\7\63\2\2\u010f\u0118\3\2\2\2\u0110\u0111\7\62\2\2\u0111\u0112"+
		"\7%\2\2\u0112\u0113\7\24\2\2\u0113\u0114\5$\23\2\u0114\u0115\7\25\2\2"+
		"\u0115\u0116\7\63\2\2\u0116\u0118\3\2\2\2\u0117\u010c\3\2\2\2\u0117\u0110"+
		"\3\2\2\2\u0118#\3\2\2\2\u0119\u011c\5,\27\2\u011a\u011b\7.\2\2\u011b\u011d"+
		"\5&\24\2\u011c\u011a\3\2\2\2\u011c\u011d\3\2\2\2\u011d%\3\2\2\2\u011e"+
		"\u011f\5\66\34\2\u011f\u0120\7\"\2\2\u0120\u0121\7:\2\2\u0121\u0124\3"+
		"\2\2\2\u0122\u0124\7:\2\2\u0123\u011e\3\2\2\2\u0123\u0122\3\2\2\2\u0124"+
		"\'\3\2\2\2\u0125\u0126\7\64\2\2\u0126\u0127\5F$\2\u0127\u0128\7\63\2\2"+
		"\u0128)\3\2\2\2\u0129\u012a\5,\27\2\u012a+\3\2\2\2\u012b\u012c\b\27\1"+
		"\2\u012c\u012d\t\2\2\2\u012d\u013d\5,\27\2\u012e\u012f\t\3\2\2\u012f\u013d"+
		"\5,\27\2\u0130\u0131\7%\2\2\u0131\u013d\5,\27\2\u0132\u013d\5D#\2\u0133"+
		"\u0134\7)\2\2\u0134\u013d\58\35\2\u0135\u013d\5\62\32\2\u0136\u013d\5"+
		".\30\2\u0137\u013d\5@!\2\u0138\u0139\7\24\2\2\u0139\u013a\5,\27\2\u013a"+
		"\u013b\7\25\2\2\u013b\u013d\3\2\2\2\u013c\u012b\3\2\2\2\u013c\u012e\3"+
		"\2\2\2\u013c\u0130\3\2\2\2\u013c\u0132\3\2\2\2\u013c\u0133\3\2\2\2\u013c"+
		"\u0135\3\2\2\2\u013c\u0136\3\2\2\2\u013c\u0137\3\2\2\2\u013c\u0138\3\2"+
		"\2\2\u013d\u0169\3\2\2\2\u013e\u013f\6\27\2\3\u013f\u0140\t\4\2\2\u0140"+
		"\u0168\5,\27\2\u0141\u0142\6\27\3\3\u0142\u0143\t\2\2\2\u0143\u0168\5"+
		",\27\2\u0144\u014b\6\27\4\3\u0145\u0146\7$\2\2\u0146\u014c\7\"\2\2\u0147"+
		"\u0148\7#\2\2\u0148\u014c\7\"\2\2\u0149\u014c\7#\2\2\u014a\u014c\7$\2"+
		"\2\u014b\u0145\3\2\2\2\u014b\u0147\3\2\2\2\u014b\u0149\3\2\2\2\u014b\u014a"+
		"\3\2\2\2\u014c\u014d\3\2\2\2\u014d\u0168\5,\27\2\u014e\u014f\6\27\5\3"+
		"\u014f\u0150\t\5\2\2\u0150\u0168\5,\27\2\u0151\u0152\6\27\6\3\u0152\u0153"+
		"\7&\2\2\u0153\u0168\5,\27\2\u0154\u0155\6\27\7\3\u0155\u0156\7\'\2\2\u0156"+
		"\u0168\5,\27\2\u0157\u0158\6\27\b\3\u0158\u0168\t\3\2\2\u0159\u015a\6"+
		"\27\t\3\u015a\u015c\7(\2\2\u015b\u015d\5,\27\2\u015c\u015b\3\2\2\2\u015c"+
		"\u015d\3\2\2\2\u015d\u015e\3\2\2\2\u015e\u0160\7/\2\2\u015f\u0161\5,\27"+
		"\2\u0160\u015f\3\2\2\2\u0160\u0161\3\2\2\2\u0161\u0168\3\2\2\2\u0162\u0163"+
		"\6\27\n\3\u0163\u0165\7%\2\2\u0164\u0166\5,\27\2\u0165\u0164\3\2\2\2\u0165"+
		"\u0166\3\2\2\2\u0166\u0168\3\2\2\2\u0167\u013e\3\2\2\2\u0167\u0141\3\2"+
		"\2\2\u0167\u0144\3\2\2\2\u0167\u014e\3\2\2\2\u0167\u0151\3\2\2\2\u0167"+
		"\u0154\3\2\2\2\u0167\u0157\3\2\2\2\u0167\u0159\3\2\2\2\u0167\u0162\3\2"+
		"\2\2\u0168\u016b\3\2\2\2\u0169\u0167\3\2\2\2\u0169\u016a\3\2\2\2\u016a"+
		"-\3\2\2\2\u016b\u0169\3\2\2\2\u016c\u0170\7;\2\2\u016d\u016f\5\60\31\2"+
		"\u016e\u016d\3\2\2\2\u016f\u0172\3\2\2\2\u0170\u016e\3\2\2\2\u0170\u0171"+
		"\3\2\2\2\u0171/\3\2\2\2\u0172\u0170\3\2\2\2\u0173\u0174\7\60\2\2\u0174"+
		"\u017c\7;\2\2\u0175\u0176\7\32\2\2\u0176\u017c\7;\2\2\u0177\u0178\7\26"+
		"\2\2\u0178\u0179\5,\27\2\u0179\u017a\7\27\2\2\u017a\u017c\3\2\2\2\u017b"+
		"\u0173\3\2\2\2\u017b\u0175\3\2\2\2\u017b\u0177\3\2\2\2\u017c\61\3\2\2"+
		"\2\u017d\u017e\5\66\34\2\u017e\u0180\7\24\2\2\u017f\u0181\5\36\20\2\u0180"+
		"\u017f\3\2\2\2\u0180\u0181\3\2\2\2\u0181\u0182\3\2\2\2\u0182\u0186\7\25"+
		"\2\2\u0183\u0185\5\60\31\2\u0184\u0183\3\2\2\2\u0185\u0188\3\2\2\2\u0186"+
		"\u0184\3\2\2\2\u0186\u0187\3\2\2\2\u0187\63\3\2\2\2\u0188\u0186\3\2\2"+
		"\2\u0189\u018a\5\66\34\2\u018a\u018c\7\24\2\2\u018b\u018d\5\36\20\2\u018c"+
		"\u018b\3\2\2\2\u018c\u018d\3\2\2\2\u018d\u018e\3\2\2\2\u018e\u018f\7\25"+
		"\2\2\u018f\u0190\5\4\3\2\u0190\65\3\2\2\2\u0191\u0196\7;\2\2\u0192\u0193"+
		"\7\60\2\2\u0193\u0195\7;\2\2\u0194\u0192\3\2\2\2\u0195\u0198\3\2\2\2\u0196"+
		"\u0194\3\2\2\2\u0196\u0197\3\2\2\2\u0197\67\3\2\2\2\u0198\u0196\3\2\2"+
		"\2\u0199\u01a0\5> \2\u019a\u019f\5:\36\2\u019b\u019f\5<\37\2\u019c\u019d"+
		"\7\60\2\2\u019d\u019f\5> \2\u019e\u019a\3\2\2\2\u019e\u019b\3\2\2\2\u019e"+
		"\u019c\3\2\2\2\u019f\u01a2\3\2\2\2\u01a0\u019e\3\2\2\2\u01a0\u01a1\3\2"+
		"\2\2\u01a19\3\2\2\2\u01a2\u01a0\3\2\2\2\u01a3\u01ac\7\24\2\2\u01a4\u01a9"+
		"\5,\27\2\u01a5\u01a6\7.\2\2\u01a6\u01a8\5,\27\2\u01a7\u01a5\3\2\2\2\u01a8"+
		"\u01ab\3\2\2\2\u01a9\u01a7\3\2\2\2\u01a9\u01aa\3\2\2\2\u01aa\u01ad\3\2"+
		"\2\2\u01ab\u01a9\3\2\2\2\u01ac\u01a4\3\2\2\2\u01ac\u01ad\3\2\2\2\u01ad"+
		"\u01ae\3\2\2\2\u01ae\u01af\7\25\2\2\u01af;\3\2\2\2\u01b0\u01b1\7\26\2"+
		"\2\u01b1\u01b2\5,\27\2\u01b2\u01b3\7\27\2\2\u01b3=\3\2\2\2\u01b4\u01b9"+
		"\7;\2\2\u01b5\u01b6\7\60\2\2\u01b6\u01b8\7;\2\2\u01b7\u01b5\3\2\2\2\u01b8"+
		"\u01bb\3\2\2\2\u01b9\u01b7\3\2\2\2\u01b9\u01ba\3\2\2\2\u01ba?\3\2\2\2"+
		"\u01bb\u01b9\3\2\2\2\u01bc\u01c5\7\26\2\2\u01bd\u01c2\5,\27\2\u01be\u01bf"+
		"\7.\2\2\u01bf\u01c1\5,\27\2\u01c0\u01be\3\2\2\2\u01c1\u01c4\3\2\2\2\u01c2"+
		"\u01c0\3\2\2\2\u01c2\u01c3\3\2\2\2\u01c3\u01c6\3\2\2\2\u01c4\u01c2\3\2"+
		"\2\2\u01c5\u01bd\3\2\2\2\u01c5\u01c6\3\2\2\2\u01c6\u01c7\3\2\2\2\u01c7"+
		"\u01d5\7\27\2\2\u01c8\u01d1\7\22\2\2\u01c9\u01ce\5B\"\2\u01ca\u01cb\7"+
		".\2\2\u01cb\u01cd\5B\"\2\u01cc\u01ca\3\2\2\2\u01cd\u01d0\3\2\2\2\u01ce"+
		"\u01cc\3\2\2\2\u01ce\u01cf\3\2\2\2\u01cf\u01d2\3\2\2\2\u01d0\u01ce\3\2"+
		"\2\2\u01d1\u01c9\3\2\2\2\u01d1\u01d2\3\2\2\2\u01d2\u01d3\3\2\2\2\u01d3"+
		"\u01d5\7\23\2\2\u01d4\u01bc\3\2\2\2\u01d4\u01c8\3\2\2\2\u01d5A\3\2\2\2"+
		"\u01d6\u01d7\7:\2\2\u01d7\u01d8\7/\2\2\u01d8\u01dd\5,\27\2\u01d9\u01da"+
		"\7;\2\2\u01da\u01db\7/\2\2\u01db\u01dd\5,\27\2\u01dc\u01d6\3\2\2\2\u01dc"+
		"\u01d9\3\2\2\2\u01ddC\3\2\2\2\u01de\u01e5\5F$\2\u01df\u01e5\78\2\2\u01e0"+
		"\u01e5\79\2\2\u01e1\u01e5\7:\2\2\u01e2\u01e5\5H%\2\u01e3\u01e5\7*\2\2"+
		"\u01e4\u01de\3\2\2\2\u01e4\u01df\3\2\2\2\u01e4\u01e0\3\2\2\2\u01e4\u01e1"+
		"\3\2\2\2\u01e4\u01e2\3\2\2\2\u01e4\u01e3\3\2\2\2\u01e5E\3\2\2\2\u01e6"+
		"\u01e7\t\6\2\2\u01e7G\3\2\2\2\u01e8\u01e9\t\7\2\2\u01e9I\3\2\2\2\u01ea"+
		"\u01ec\7\24\2\2\u01eb\u01ed\5\36\20\2\u01ec\u01eb\3\2\2\2\u01ec\u01ed"+
		"\3\2\2\2\u01ed\u01ee\3\2\2\2\u01ee\u01ef\7\25\2\2\u01efK\3\2\2\2\64OX"+
		"fz\u0082\u0086\u009a\u009e\u00a6\u00ac\u00b0\u00ba\u00c9\u00d3\u00d9\u00df"+
		"\u00e7\u00ec\u00f5\u00f8\u0107\u0117\u011c\u0123\u013c\u014b\u015c\u0160"+
		"\u0165\u0167\u0169\u0170\u017b\u0180\u0186\u018c\u0196\u019e\u01a0\u01a9"+
		"\u01ac\u01b9\u01c2\u01c5\u01ce\u01d1\u01d4\u01dc\u01e4\u01ec";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}