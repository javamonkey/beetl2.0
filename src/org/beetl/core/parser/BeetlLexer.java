// Generated from E:\lijz\javamonkey\bee\research\antlrworks2\projects\beetl\BeetlLexer.g4 by ANTLR 4.1
package org.beetl.core.parser;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class BeetlLexer extends Lexer {
	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		If=1, For=2, Else=3, While=4, Switch=5, Select=6, Return=7, Break=8, Continue=9, 
		Var=10, Directive=11, Case=12, Default=13, Try=14, Catch=15, LEFT_BRACE=16, 
		RIGHT_BRACE=17, LEFT_PAR=18, RIGHT_PAR=19, LEFT_SQBR=20, RIGHT_SQBR=21, 
		INCREASE=22, DECREASE=23, VIRTUAL=24, ADD=25, MIN=26, MUlTIP=27, DIV=28, 
		MOD=29, EQUAL=30, NOT_EQUAL=31, ASSIN=32, LARGE=33, LESS=34, NOT=35, AND=36, 
		OR=37, QUESTOIN=38, AT=39, NULL=40, TRUE=41, FALSE=42, END=43, COMMA=44, 
		COLON=45, PERIOD=46, FOR_IN=47, LEFT_TOKEN=48, RIGHT_TOKEN=49, LEFT_TEXT_TOKEN=50, 
		HexLiteral=51, DecimalLiteral=52, OctalLiteral=53, FloatingPointLiteral=54, 
		CharacterLiteral=55, StringLiteral=56, Identifier=57, WS=58, LINE_COMMENT=59, 
		COMMENT_OPEN=60, COMMENT_TAG=61, COMMENT_END=62, ALL_COMMENT_CHAR=63, 
		Identifier1=64, PERIOD1=65, LEFT_PAR1=66, RIGHT_PAR1=67, COMMA1=68, LEFT_ANGULAR=69, 
		RIGHT_ANGULAR=70, WS1=71, TYPE_END=72;
	public static final int MODE_COMMENT = 1;
	public static final int MODE_COMMENT_TYPE = 2;
	public static String[] modeNames = {
		"DEFAULT_MODE", "MODE_COMMENT", "MODE_COMMENT_TYPE"
	};

	public static final String[] tokenNames = {
		"<INVALID>",
		"'if'", "'for'", "'else'", "'while'", "'switch'", "'select'", "'return'", 
		"'break'", "'continue'", "'var'", "Directive", "'case'", "'default'", 
		"'try'", "'catch'", "'{'", "'}'", "LEFT_PAR", "RIGHT_PAR", "'['", "']'", 
		"'++'", "'--'", "'.~'", "'+'", "'-'", "'*'", "'/'", "'%'", "'=='", "'!='", 
		"'='", "LARGE", "LESS", "'!'", "'&&'", "'||'", "'?'", "'@'", "'null'", 
		"'true'", "'false'", "';'", "COMMA", "':'", "PERIOD", "'in'", "'<<'", 
		"'>>'", "'<$'", "HexLiteral", "DecimalLiteral", "OctalLiteral", "FloatingPointLiteral", 
		"CharacterLiteral", "StringLiteral", "Identifier", "WS", "LINE_COMMENT", 
		"COMMENT_OPEN", "COMMENT_TAG", "COMMENT_END", "ALL_COMMENT_CHAR", "Identifier1", 
		"PERIOD1", "LEFT_PAR1", "RIGHT_PAR1", "COMMA1", "LEFT_ANGULAR", "RIGHT_ANGULAR", 
		"WS1", "TYPE_END"
	};
	public static final String[] ruleNames = {
		"If", "For", "Else", "While", "Switch", "Select", "Return", "Break", "Continue", 
		"Var", "Directive", "Case", "Default", "Try", "Catch", "LEFT_BRACE", "RIGHT_BRACE", 
		"LEFT_PAR", "RIGHT_PAR", "LEFT_SQBR", "RIGHT_SQBR", "INCREASE", "DECREASE", 
		"VIRTUAL", "ADD", "MIN", "MUlTIP", "DIV", "MOD", "EQUAL", "NOT_EQUAL", 
		"ASSIN", "LARGE", "LESS", "NOT", "AND", "OR", "QUESTOIN", "AT", "NULL", 
		"TRUE", "FALSE", "END", "COMMA", "COLON", "PERIOD", "FOR_IN", "LEFT_TOKEN", 
		"RIGHT_TOKEN", "LEFT_TEXT_TOKEN", "HexLiteral", "DecimalLiteral", "OctalLiteral", 
		"HexDigit", "IntegerTypeSuffix", "FloatingPointLiteral", "Exponent", "FloatTypeSuffix", 
		"CharacterLiteral", "StringLiteral", "EscapeSequence", "OctalEscape", 
		"UnicodeEscape", "Identifier", "Letter", "JavaIDDigit", "WS", "LINE_COMMENT", 
		"COMMENT_OPEN", "COMMENT_TAG", "COMMENT_END", "COMMENT_END_CHAR", "TYPE_CHAR", 
		"ALL_COMMENT_CHAR", "Identifier1", "PERIOD1", "LEFT_PAR1", "RIGHT_PAR1", 
		"COMMA1", "LEFT_ANGULAR", "RIGHT_ANGULAR", "WS1", "TYPE_END"
	};


	public BeetlLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "BeetlLexer.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	@Override
	public void action(RuleContext _localctx, int ruleIndex, int actionIndex) {
		switch (ruleIndex) {
		case 66: WS_action((RuleContext)_localctx, actionIndex); break;

		case 67: LINE_COMMENT_action((RuleContext)_localctx, actionIndex); break;

		case 68: COMMENT_OPEN_action((RuleContext)_localctx, actionIndex); break;

		case 69: COMMENT_TAG_action((RuleContext)_localctx, actionIndex); break;

		case 70: COMMENT_END_action((RuleContext)_localctx, actionIndex); break;

		case 73: ALL_COMMENT_CHAR_action((RuleContext)_localctx, actionIndex); break;

		case 81: WS1_action((RuleContext)_localctx, actionIndex); break;

		case 82: TYPE_END_action((RuleContext)_localctx, actionIndex); break;
		}
	}
	private void COMMENT_OPEN_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 2: pushMode(MODE_COMMENT); _channel = HIDDEN;  break;
		}
	}
	private void COMMENT_TAG_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 3: pushMode(MODE_COMMENT_TYPE);  break;
		}
	}
	private void TYPE_END_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 7: popMode(); _channel = HIDDEN;  break;
		}
	}
	private void WS_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 0: _channel = HIDDEN;  break;
		}
	}
	private void COMMENT_END_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 4: popMode(); _channel = HIDDEN;  break;
		}
	}
	private void ALL_COMMENT_CHAR_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 5: _channel = HIDDEN;  break;
		}
	}
	private void LINE_COMMENT_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 1: _channel = HIDDEN;  break;
		}
	}
	private void WS1_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 6: _channel = HIDDEN;  break;
		}
	}

	public static final String _serializedATN =
		"\3\uacf5\uee8c\u4f5d\u8b0d\u4a45\u78bd\u1b2f\u3378\2J\u0269\b\1\b\1\b"+
		"\1\4\2\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n"+
		"\t\n\4\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21"+
		"\4\22\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30"+
		"\4\31\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37"+
		"\4 \t \4!\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t"+
		"*\4+\t+\4,\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63"+
		"\4\64\t\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t"+
		"<\4=\t=\4>\t>\4?\t?\4@\t@\4A\tA\4B\tB\4C\tC\4D\tD\4E\tE\4F\tF\4G\tG\4"+
		"H\tH\4I\tI\4J\tJ\4K\tK\4L\tL\4M\tM\4N\tN\4O\tO\4P\tP\4Q\tQ\4R\tR\4S\t"+
		"S\4T\tT\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3"+
		"\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\b"+
		"\3\b\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3"+
		"\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f"+
		"\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\5\f\u00f8\n\f\3\r\3\r\3\r\3\r\3\r"+
		"\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3\20\3\20"+
		"\3\20\3\20\3\20\3\20\3\21\3\21\3\22\3\22\3\23\3\23\3\24\3\24\3\25\3\25"+
		"\3\26\3\26\3\27\3\27\3\27\3\30\3\30\3\30\3\31\3\31\3\31\3\32\3\32\3\33"+
		"\3\33\3\34\3\34\3\35\3\35\3\36\3\36\3\37\3\37\3\37\3 \3 \3 \3!\3!\3\""+
		"\3\"\3#\3#\3$\3$\3%\3%\3%\3&\3&\3&\3\'\3\'\3(\3(\3)\3)\3)\3)\3)\3*\3*"+
		"\3*\3*\3*\3+\3+\3+\3+\3+\3+\3,\3,\3-\3-\3.\3.\3/\3/\3\60\3\60\3\60\3\61"+
		"\3\61\3\61\3\62\3\62\3\62\3\63\3\63\3\63\3\64\3\64\3\64\6\64\u016f\n\64"+
		"\r\64\16\64\u0170\3\64\5\64\u0174\n\64\3\65\3\65\3\65\7\65\u0179\n\65"+
		"\f\65\16\65\u017c\13\65\5\65\u017e\n\65\3\65\5\65\u0181\n\65\3\66\3\66"+
		"\6\66\u0185\n\66\r\66\16\66\u0186\3\66\5\66\u018a\n\66\3\67\3\67\38\3"+
		"8\39\69\u0191\n9\r9\169\u0192\39\39\79\u0197\n9\f9\169\u019a\139\39\5"+
		"9\u019d\n9\39\59\u01a0\n9\39\39\69\u01a4\n9\r9\169\u01a5\39\59\u01a9\n"+
		"9\39\59\u01ac\n9\39\69\u01af\n9\r9\169\u01b0\39\39\59\u01b5\n9\39\69\u01b8"+
		"\n9\r9\169\u01b9\39\39\39\39\39\59\u01c1\n9\39\79\u01c4\n9\f9\169\u01c7"+
		"\139\39\39\79\u01cb\n9\f9\169\u01ce\139\59\u01d0\n9\39\39\59\u01d4\n9"+
		"\39\69\u01d7\n9\r9\169\u01d8\39\59\u01dc\n9\59\u01de\n9\3:\3:\5:\u01e2"+
		"\n:\3:\6:\u01e5\n:\r:\16:\u01e6\3;\3;\3<\3<\3<\5<\u01ee\n<\3<\3<\3=\3"+
		"=\3=\7=\u01f5\n=\f=\16=\u01f8\13=\3=\3=\3>\3>\3>\3>\5>\u0200\n>\3?\3?"+
		"\3?\3?\3?\3?\3?\3?\3?\5?\u020b\n?\3@\3@\3@\3@\3@\3@\3@\3A\3A\3A\7A\u0217"+
		"\nA\fA\16A\u021a\13A\3B\3B\3C\3C\3D\6D\u0221\nD\rD\16D\u0222\3D\3D\3E"+
		"\3E\3E\3E\7E\u022b\nE\fE\16E\u022e\13E\3E\5E\u0231\nE\3E\3E\3E\3E\3F\3"+
		"F\3F\3F\3F\3G\3G\3G\3G\3H\3H\3H\3H\3I\3I\3I\3J\3J\3J\3J\3J\3J\3K\3K\3"+
		"K\3K\3L\3L\3M\3M\3N\3N\3O\3O\3P\3P\3Q\3Q\3R\3R\3S\6S\u0260\nS\rS\16S\u0261"+
		"\3S\3S\3T\3T\3T\3T\2U\5\3\1\7\4\1\t\5\1\13\6\1\r\7\1\17\b\1\21\t\1\23"+
		"\n\1\25\13\1\27\f\1\31\r\1\33\16\1\35\17\1\37\20\1!\21\1#\22\1%\23\1\'"+
		"\24\1)\25\1+\26\1-\27\1/\30\1\61\31\1\63\32\1\65\33\1\67\34\19\35\1;\36"+
		"\1=\37\1? \1A!\1C\"\1E#\1G$\1I%\1K&\1M\'\1O(\1Q)\1S*\1U+\1W,\1Y-\1[.\1"+
		"]/\1_\60\1a\61\1c\62\1e\63\1g\64\1i\65\1k\66\1m\67\1o\2\1q\2\1s8\1u\2"+
		"\1w\2\1y9\1{:\1}\2\1\177\2\1\u0081\2\1\u0083;\1\u0085\2\1\u0087\2\1\u0089"+
		"<\2\u008b=\3\u008d>\4\u008f?\5\u0091@\6\u0093\2\1\u0095\2\1\u0097A\7\u0099"+
		"B\1\u009bC\1\u009dD\1\u009fE\1\u00a1F\1\u00a3G\1\u00a5H\1\u00a7I\b\u00a9"+
		"J\t\5\2\3\4\21\4\2ZZzz\5\2\62;CHch\4\2NNnn\4\2RRrr\4\2--//\4\2GGgg\6\2"+
		"FFHHffhh\4\2))^^\4\2$$^^\n\2$$))^^ddhhppttvv\16\2&&C\\aac|\u00c2\u00d8"+
		"\u00da\u00f8\u00fa\u2001\u3042\u3191\u3302\u3381\u3402\u3d2f\u4e02\ua001"+
		"\uf902\ufb01\21\2\62;\u0662\u066b\u06f2\u06fb\u0968\u0971\u09e8\u09f1"+
		"\u0a68\u0a71\u0ae8\u0af1\u0b68\u0b71\u0be9\u0bf1\u0c68\u0c71\u0ce8\u0cf1"+
		"\u0d68\u0d71\u0e52\u0e5b\u0ed2\u0edb\u1042\u104b\5\2\13\f\16\17\"\"\4"+
		"\2\f\f\17\17\5\2\13\13\16\17\"\"\u0287\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2"+
		"\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2"+
		"\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3"+
		"\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2"+
		"\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67"+
		"\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2"+
		"\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2"+
		"\2Q\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2\2W\3\2\2\2\2Y\3\2\2\2\2[\3\2\2\2\2]"+
		"\3\2\2\2\2_\3\2\2\2\2a\3\2\2\2\2c\3\2\2\2\2e\3\2\2\2\2g\3\2\2\2\2i\3\2"+
		"\2\2\2k\3\2\2\2\2m\3\2\2\2\2s\3\2\2\2\2y\3\2\2\2\2{\3\2\2\2\2\u0083\3"+
		"\2\2\2\2\u0089\3\2\2\2\2\u008b\3\2\2\2\2\u008d\3\2\2\2\3\u008f\3\2\2\2"+
		"\3\u0091\3\2\2\2\3\u0097\3\2\2\2\4\u0099\3\2\2\2\4\u009b\3\2\2\2\4\u009d"+
		"\3\2\2\2\4\u009f\3\2\2\2\4\u00a1\3\2\2\2\4\u00a3\3\2\2\2\4\u00a5\3\2\2"+
		"\2\4\u00a7\3\2\2\2\4\u00a9\3\2\2\2\5\u00ab\3\2\2\2\7\u00ae\3\2\2\2\t\u00b2"+
		"\3\2\2\2\13\u00b7\3\2\2\2\r\u00bd\3\2\2\2\17\u00c4\3\2\2\2\21\u00cb\3"+
		"\2\2\2\23\u00d2\3\2\2\2\25\u00d8\3\2\2\2\27\u00e1\3\2\2\2\31\u00f7\3\2"+
		"\2\2\33\u00f9\3\2\2\2\35\u00fe\3\2\2\2\37\u0106\3\2\2\2!\u010a\3\2\2\2"+
		"#\u0110\3\2\2\2%\u0112\3\2\2\2\'\u0114\3\2\2\2)\u0116\3\2\2\2+\u0118\3"+
		"\2\2\2-\u011a\3\2\2\2/\u011c\3\2\2\2\61\u011f\3\2\2\2\63\u0122\3\2\2\2"+
		"\65\u0125\3\2\2\2\67\u0127\3\2\2\29\u0129\3\2\2\2;\u012b\3\2\2\2=\u012d"+
		"\3\2\2\2?\u012f\3\2\2\2A\u0132\3\2\2\2C\u0135\3\2\2\2E\u0137\3\2\2\2G"+
		"\u0139\3\2\2\2I\u013b\3\2\2\2K\u013d\3\2\2\2M\u0140\3\2\2\2O\u0143\3\2"+
		"\2\2Q\u0145\3\2\2\2S\u0147\3\2\2\2U\u014c\3\2\2\2W\u0151\3\2\2\2Y\u0157"+
		"\3\2\2\2[\u0159\3\2\2\2]\u015b\3\2\2\2_\u015d\3\2\2\2a\u015f\3\2\2\2c"+
		"\u0162\3\2\2\2e\u0165\3\2\2\2g\u0168\3\2\2\2i\u016b\3\2\2\2k\u017d\3\2"+
		"\2\2m\u0182\3\2\2\2o\u018b\3\2\2\2q\u018d\3\2\2\2s\u01dd\3\2\2\2u\u01df"+
		"\3\2\2\2w\u01e8\3\2\2\2y\u01ea\3\2\2\2{\u01f1\3\2\2\2}\u01ff\3\2\2\2\177"+
		"\u020a\3\2\2\2\u0081\u020c\3\2\2\2\u0083\u0213\3\2\2\2\u0085\u021b\3\2"+
		"\2\2\u0087\u021d\3\2\2\2\u0089\u0220\3\2\2\2\u008b\u0226\3\2\2\2\u008d"+
		"\u0236\3\2\2\2\u008f\u023b\3\2\2\2\u0091\u023f\3\2\2\2\u0093\u0243\3\2"+
		"\2\2\u0095\u0246\3\2\2\2\u0097\u024c\3\2\2\2\u0099\u0250\3\2\2\2\u009b"+
		"\u0252\3\2\2\2\u009d\u0254\3\2\2\2\u009f\u0256\3\2\2\2\u00a1\u0258\3\2"+
		"\2\2\u00a3\u025a\3\2\2\2\u00a5\u025c\3\2\2\2\u00a7\u025f\3\2\2\2\u00a9"+
		"\u0265\3\2\2\2\u00ab\u00ac\7k\2\2\u00ac\u00ad\7h\2\2\u00ad\6\3\2\2\2\u00ae"+
		"\u00af\7h\2\2\u00af\u00b0\7q\2\2\u00b0\u00b1\7t\2\2\u00b1\b\3\2\2\2\u00b2"+
		"\u00b3\7g\2\2\u00b3\u00b4\7n\2\2\u00b4\u00b5\7u\2\2\u00b5\u00b6\7g\2\2"+
		"\u00b6\n\3\2\2\2\u00b7\u00b8\7y\2\2\u00b8\u00b9\7j\2\2\u00b9\u00ba\7k"+
		"\2\2\u00ba\u00bb\7n\2\2\u00bb\u00bc\7g\2\2\u00bc\f\3\2\2\2\u00bd\u00be"+
		"\7u\2\2\u00be\u00bf\7y\2\2\u00bf\u00c0\7k\2\2\u00c0\u00c1\7v\2\2\u00c1"+
		"\u00c2\7e\2\2\u00c2\u00c3\7j\2\2\u00c3\16\3\2\2\2\u00c4\u00c5\7u\2\2\u00c5"+
		"\u00c6\7g\2\2\u00c6\u00c7\7n\2\2\u00c7\u00c8\7g\2\2\u00c8\u00c9\7e\2\2"+
		"\u00c9\u00ca\7v\2\2\u00ca\20\3\2\2\2\u00cb\u00cc\7t\2\2\u00cc\u00cd\7"+
		"g\2\2\u00cd\u00ce\7v\2\2\u00ce\u00cf\7w\2\2\u00cf\u00d0\7t\2\2\u00d0\u00d1"+
		"\7p\2\2\u00d1\22\3\2\2\2\u00d2\u00d3\7d\2\2\u00d3\u00d4\7t\2\2\u00d4\u00d5"+
		"\7g\2\2\u00d5\u00d6\7c\2\2\u00d6\u00d7\7m\2\2\u00d7\24\3\2\2\2\u00d8\u00d9"+
		"\7e\2\2\u00d9\u00da\7q\2\2\u00da\u00db\7p\2\2\u00db\u00dc\7v\2\2\u00dc"+
		"\u00dd\7k\2\2\u00dd\u00de\7p\2\2\u00de\u00df\7w\2\2\u00df\u00e0\7g\2\2"+
		"\u00e0\26\3\2\2\2\u00e1\u00e2\7x\2\2\u00e2\u00e3\7c\2\2\u00e3\u00e4\7"+
		"t\2\2\u00e4\30\3\2\2\2\u00e5\u00e6\7F\2\2\u00e6\u00e7\7K\2\2\u00e7\u00e8"+
		"\7T\2\2\u00e8\u00e9\7G\2\2\u00e9\u00ea\7E\2\2\u00ea\u00eb\7V\2\2\u00eb"+
		"\u00ec\7K\2\2\u00ec\u00ed\7X\2\2\u00ed\u00f8\7G\2\2\u00ee\u00ef\7f\2\2"+
		"\u00ef\u00f0\7k\2\2\u00f0\u00f1\7t\2\2\u00f1\u00f2\7g\2\2\u00f2\u00f3"+
		"\7e\2\2\u00f3\u00f4\7v\2\2\u00f4\u00f5\7k\2\2\u00f5\u00f6\7x\2\2\u00f6"+
		"\u00f8\7g\2\2\u00f7\u00e5\3\2\2\2\u00f7\u00ee\3\2\2\2\u00f8\32\3\2\2\2"+
		"\u00f9\u00fa\7e\2\2\u00fa\u00fb\7c\2\2\u00fb\u00fc\7u\2\2\u00fc\u00fd"+
		"\7g\2\2\u00fd\34\3\2\2\2\u00fe\u00ff\7f\2\2\u00ff\u0100\7g\2\2\u0100\u0101"+
		"\7h\2\2\u0101\u0102\7c\2\2\u0102\u0103\7w\2\2\u0103\u0104\7n\2\2\u0104"+
		"\u0105\7v\2\2\u0105\36\3\2\2\2\u0106\u0107\7v\2\2\u0107\u0108\7t\2\2\u0108"+
		"\u0109\7{\2\2\u0109 \3\2\2\2\u010a\u010b\7e\2\2\u010b\u010c\7c\2\2\u010c"+
		"\u010d\7v\2\2\u010d\u010e\7e\2\2\u010e\u010f\7j\2\2\u010f\"\3\2\2\2\u0110"+
		"\u0111\7}\2\2\u0111$\3\2\2\2\u0112\u0113\7\177\2\2\u0113&\3\2\2\2\u0114"+
		"\u0115\7*\2\2\u0115(\3\2\2\2\u0116\u0117\7+\2\2\u0117*\3\2\2\2\u0118\u0119"+
		"\7]\2\2\u0119,\3\2\2\2\u011a\u011b\7_\2\2\u011b.\3\2\2\2\u011c\u011d\7"+
		"-\2\2\u011d\u011e\7-\2\2\u011e\60\3\2\2\2\u011f\u0120\7/\2\2\u0120\u0121"+
		"\7/\2\2\u0121\62\3\2\2\2\u0122\u0123\7\60\2\2\u0123\u0124\7\u0080\2\2"+
		"\u0124\64\3\2\2\2\u0125\u0126\7-\2\2\u0126\66\3\2\2\2\u0127\u0128\7/\2"+
		"\2\u01288\3\2\2\2\u0129\u012a\7,\2\2\u012a:\3\2\2\2\u012b\u012c\7\61\2"+
		"\2\u012c<\3\2\2\2\u012d\u012e\7\'\2\2\u012e>\3\2\2\2\u012f\u0130\7?\2"+
		"\2\u0130\u0131\7?\2\2\u0131@\3\2\2\2\u0132\u0133\7#\2\2\u0133\u0134\7"+
		"?\2\2\u0134B\3\2\2\2\u0135\u0136\7?\2\2\u0136D\3\2\2\2\u0137\u0138\7@"+
		"\2\2\u0138F\3\2\2\2\u0139\u013a\7>\2\2\u013aH\3\2\2\2\u013b\u013c\7#\2"+
		"\2\u013cJ\3\2\2\2\u013d\u013e\7(\2\2\u013e\u013f\7(\2\2\u013fL\3\2\2\2"+
		"\u0140\u0141\7~\2\2\u0141\u0142\7~\2\2\u0142N\3\2\2\2\u0143\u0144\7A\2"+
		"\2\u0144P\3\2\2\2\u0145\u0146\7B\2\2\u0146R\3\2\2\2\u0147\u0148\7p\2\2"+
		"\u0148\u0149\7w\2\2\u0149\u014a\7n\2\2\u014a\u014b\7n\2\2\u014bT\3\2\2"+
		"\2\u014c\u014d\7v\2\2\u014d\u014e\7t\2\2\u014e\u014f\7w\2\2\u014f\u0150"+
		"\7g\2\2\u0150V\3\2\2\2\u0151\u0152\7h\2\2\u0152\u0153\7c\2\2\u0153\u0154"+
		"\7n\2\2\u0154\u0155\7u\2\2\u0155\u0156\7g\2\2\u0156X\3\2\2\2\u0157\u0158"+
		"\7=\2\2\u0158Z\3\2\2\2\u0159\u015a\7.\2\2\u015a\\\3\2\2\2\u015b\u015c"+
		"\7<\2\2\u015c^\3\2\2\2\u015d\u015e\7\60\2\2\u015e`\3\2\2\2\u015f\u0160"+
		"\7k\2\2\u0160\u0161\7p\2\2\u0161b\3\2\2\2\u0162\u0163\7>\2\2\u0163\u0164"+
		"\7>\2\2\u0164d\3\2\2\2\u0165\u0166\7@\2\2\u0166\u0167\7@\2\2\u0167f\3"+
		"\2\2\2\u0168\u0169\7>\2\2\u0169\u016a\7&\2\2\u016ah\3\2\2\2\u016b\u016c"+
		"\7\62\2\2\u016c\u016e\t\2\2\2\u016d\u016f\5o\67\2\u016e\u016d\3\2\2\2"+
		"\u016f\u0170\3\2\2\2\u0170\u016e\3\2\2\2\u0170\u0171\3\2\2\2\u0171\u0173"+
		"\3\2\2\2\u0172\u0174\5q8\2\u0173\u0172\3\2\2\2\u0173\u0174\3\2\2\2\u0174"+
		"j\3\2\2\2\u0175\u017e\7\62\2\2\u0176\u017a\4\63;\2\u0177\u0179\4\62;\2"+
		"\u0178\u0177\3\2\2\2\u0179\u017c\3\2\2\2\u017a\u0178\3\2\2\2\u017a\u017b"+
		"\3\2\2\2\u017b\u017e\3\2\2\2\u017c\u017a\3\2\2\2\u017d\u0175\3\2\2\2\u017d"+
		"\u0176\3\2\2\2\u017e\u0180\3\2\2\2\u017f\u0181\5q8\2\u0180\u017f\3\2\2"+
		"\2\u0180\u0181\3\2\2\2\u0181l\3\2\2\2\u0182\u0184\7\62\2\2\u0183\u0185"+
		"\4\629\2\u0184\u0183\3\2\2\2\u0185\u0186\3\2\2\2\u0186\u0184\3\2\2\2\u0186"+
		"\u0187\3\2\2\2\u0187\u0189\3\2\2\2\u0188\u018a\5q8\2\u0189\u0188\3\2\2"+
		"\2\u0189\u018a\3\2\2\2\u018an\3\2\2\2\u018b\u018c\t\3\2\2\u018cp\3\2\2"+
		"\2\u018d\u018e\t\4\2\2\u018er\3\2\2\2\u018f\u0191\4\62;\2\u0190\u018f"+
		"\3\2\2\2\u0191\u0192\3\2\2\2\u0192\u0190\3\2\2\2\u0192\u0193\3\2\2\2\u0193"+
		"\u0194\3\2\2\2\u0194\u0198\7\60\2\2\u0195\u0197\4\62;\2\u0196\u0195\3"+
		"\2\2\2\u0197\u019a\3\2\2\2\u0198\u0196\3\2\2\2\u0198\u0199\3\2\2\2\u0199"+
		"\u019c\3\2\2\2\u019a\u0198\3\2\2\2\u019b\u019d\5u:\2\u019c\u019b\3\2\2"+
		"\2\u019c\u019d\3\2\2\2\u019d\u019f\3\2\2\2\u019e\u01a0\5w;\2\u019f\u019e"+
		"\3\2\2\2\u019f\u01a0\3\2\2\2\u01a0\u01de\3\2\2\2\u01a1\u01a3\7\60\2\2"+
		"\u01a2\u01a4\4\62;\2\u01a3\u01a2\3\2\2\2\u01a4\u01a5\3\2\2\2\u01a5\u01a3"+
		"\3\2\2\2\u01a5\u01a6\3\2\2\2\u01a6\u01a8\3\2\2\2\u01a7\u01a9\5u:\2\u01a8"+
		"\u01a7\3\2\2\2\u01a8\u01a9\3\2\2\2\u01a9\u01ab\3\2\2\2\u01aa\u01ac\5w"+
		";\2\u01ab\u01aa\3\2\2\2\u01ab\u01ac\3\2\2\2\u01ac\u01de\3\2\2\2\u01ad"+
		"\u01af\4\62;\2\u01ae\u01ad\3\2\2\2\u01af\u01b0\3\2\2\2\u01b0\u01ae\3\2"+
		"\2\2\u01b0\u01b1\3\2\2\2\u01b1\u01b2\3\2\2\2\u01b2\u01b4\5u:\2\u01b3\u01b5"+
		"\5w;\2\u01b4\u01b3\3\2\2\2\u01b4\u01b5\3\2\2\2\u01b5\u01de\3\2\2\2\u01b6"+
		"\u01b8\4\62;\2\u01b7\u01b6\3\2\2\2\u01b8\u01b9\3\2\2\2\u01b9\u01b7\3\2"+
		"\2\2\u01b9\u01ba\3\2\2\2\u01ba\u01bb\3\2\2\2\u01bb\u01de\5w;\2\u01bc\u01bd"+
		"\7\62\2\2\u01bd\u01c1\7z\2\2\u01be\u01bf\7\62\2\2\u01bf\u01c1\7Z\2\2\u01c0"+
		"\u01bc\3\2\2\2\u01c0\u01be\3\2\2\2\u01c1\u01c5\3\2\2\2\u01c2\u01c4\5o"+
		"\67\2\u01c3\u01c2\3\2\2\2\u01c4\u01c7\3\2\2\2\u01c5\u01c3\3\2\2\2\u01c5"+
		"\u01c6\3\2\2\2\u01c6\u01cf\3\2\2\2\u01c7\u01c5\3\2\2\2\u01c8\u01cc\7\60"+
		"\2\2\u01c9\u01cb\5o\67\2\u01ca\u01c9\3\2\2\2\u01cb\u01ce\3\2\2\2\u01cc"+
		"\u01ca\3\2\2\2\u01cc\u01cd\3\2\2\2\u01cd\u01d0\3\2\2\2\u01ce\u01cc\3\2"+
		"\2\2\u01cf\u01c8\3\2\2\2\u01cf\u01d0\3\2\2\2\u01d0\u01d1\3\2\2\2\u01d1"+
		"\u01d3\t\5\2\2\u01d2\u01d4\t\6\2\2\u01d3\u01d2\3\2\2\2\u01d3\u01d4\3\2"+
		"\2\2\u01d4\u01d6\3\2\2\2\u01d5\u01d7\4\62;\2\u01d6\u01d5\3\2\2\2\u01d7"+
		"\u01d8\3\2\2\2\u01d8\u01d6\3\2\2\2\u01d8\u01d9\3\2\2\2\u01d9\u01db\3\2"+
		"\2\2\u01da\u01dc\5w;\2\u01db\u01da\3\2\2\2\u01db\u01dc\3\2\2\2\u01dc\u01de"+
		"\3\2\2\2\u01dd\u0190\3\2\2\2\u01dd\u01a1\3\2\2\2\u01dd\u01ae\3\2\2\2\u01dd"+
		"\u01b7\3\2\2\2\u01dd\u01c0\3\2\2\2\u01det\3\2\2\2\u01df\u01e1\t\7\2\2"+
		"\u01e0\u01e2\t\6\2\2\u01e1\u01e0\3\2\2\2\u01e1\u01e2\3\2\2\2\u01e2\u01e4"+
		"\3\2\2\2\u01e3\u01e5\4\62;\2\u01e4\u01e3\3\2\2\2\u01e5\u01e6\3\2\2\2\u01e6"+
		"\u01e4\3\2\2\2\u01e6\u01e7\3\2\2\2\u01e7v\3\2\2\2\u01e8\u01e9\t\b\2\2"+
		"\u01e9x\3\2\2\2\u01ea\u01ed\7)\2\2\u01eb\u01ee\5}>\2\u01ec\u01ee\n\t\2"+
		"\2\u01ed\u01eb\3\2\2\2\u01ed\u01ec\3\2\2\2\u01ee\u01ef\3\2\2\2\u01ef\u01f0"+
		"\7)\2\2\u01f0z\3\2\2\2\u01f1\u01f6\7$\2\2\u01f2\u01f5\5}>\2\u01f3\u01f5"+
		"\n\n\2\2\u01f4\u01f2\3\2\2\2\u01f4\u01f3\3\2\2\2\u01f5\u01f8\3\2\2\2\u01f6"+
		"\u01f4\3\2\2\2\u01f6\u01f7\3\2\2\2\u01f7\u01f9\3\2\2\2\u01f8\u01f6\3\2"+
		"\2\2\u01f9\u01fa\7$\2\2\u01fa|\3\2\2\2\u01fb\u01fc\7^\2\2\u01fc\u0200"+
		"\t\13\2\2\u01fd\u0200\5\u0081@\2\u01fe\u0200\5\177?\2\u01ff\u01fb\3\2"+
		"\2\2\u01ff\u01fd\3\2\2\2\u01ff\u01fe\3\2\2\2\u0200~\3\2\2\2\u0201\u0202"+
		"\7^\2\2\u0202\u0203\4\62\65\2\u0203\u0204\4\629\2\u0204\u020b\4\629\2"+
		"\u0205\u0206\7^\2\2\u0206\u0207\4\629\2\u0207\u020b\4\629\2\u0208\u0209"+
		"\7^\2\2\u0209\u020b\4\629\2\u020a\u0201\3\2\2\2\u020a\u0205\3\2\2\2\u020a"+
		"\u0208\3\2\2\2\u020b\u0080\3\2\2\2\u020c\u020d\7^\2\2\u020d\u020e\7w\2"+
		"\2\u020e\u020f\5o\67\2\u020f\u0210\5o\67\2\u0210\u0211\5o\67\2\u0211\u0212"+
		"\5o\67\2\u0212\u0082\3\2\2\2\u0213\u0218\5\u0085B\2\u0214\u0217\5\u0085"+
		"B\2\u0215\u0217\5\u0087C\2\u0216\u0214\3\2\2\2\u0216\u0215\3\2\2\2\u0217"+
		"\u021a\3\2\2\2\u0218\u0216\3\2\2\2\u0218\u0219\3\2\2\2\u0219\u0084\3\2"+
		"\2\2\u021a\u0218\3\2\2\2\u021b\u021c\t\f\2\2\u021c\u0086\3\2\2\2\u021d"+
		"\u021e\t\r\2\2\u021e\u0088\3\2\2\2\u021f\u0221\t\16\2\2\u0220\u021f\3"+
		"\2\2\2\u0221\u0222\3\2\2\2\u0222\u0220\3\2\2\2\u0222\u0223\3\2\2\2\u0223"+
		"\u0224\3\2\2\2\u0224\u0225\bD\2\2\u0225\u008a\3\2\2\2\u0226\u0227\7\61"+
		"\2\2\u0227\u0228\7\61\2\2\u0228\u022c\3\2\2\2\u0229\u022b\n\17\2\2\u022a"+
		"\u0229\3\2\2\2\u022b\u022e\3\2\2\2\u022c\u022a\3\2\2\2\u022c\u022d\3\2"+
		"\2\2\u022d\u0230\3\2\2\2\u022e\u022c\3\2\2\2\u022f\u0231\7\17\2\2\u0230"+
		"\u022f\3\2\2\2\u0230\u0231\3\2\2\2\u0231\u0232\3\2\2\2\u0232\u0233\7\f"+
		"\2\2\u0233\u0234\3\2\2\2\u0234\u0235\bE\3\2\u0235\u008c\3\2\2\2\u0236"+
		"\u0237\7\61\2\2\u0237\u0238\7,\2\2\u0238\u0239\3\2\2\2\u0239\u023a\bF"+
		"\4\2\u023a\u008e\3\2\2\2\u023b\u023c\5\u0095J\2\u023c\u023d\3\2\2\2\u023d"+
		"\u023e\bG\5\2\u023e\u0090\3\2\2\2\u023f\u0240\5\u0093I\2\u0240\u0241\3"+
		"\2\2\2\u0241\u0242\bH\6\2\u0242\u0092\3\2\2\2\u0243\u0244\7,\2\2\u0244"+
		"\u0245\7\61\2\2\u0245\u0094\3\2\2\2\u0246\u0247\7B\2\2\u0247\u0248\7v"+
		"\2\2\u0248\u0249\7{\2\2\u0249\u024a\7r\2\2\u024a\u024b\7g\2\2\u024b\u0096"+
		"\3\2\2\2\u024c\u024d\13\2\2\2\u024d\u024e\3\2\2\2\u024e\u024f\bK\7\2\u024f"+
		"\u0098\3\2\2\2\u0250\u0251\5\u0083A\2\u0251\u009a\3\2\2\2\u0252\u0253"+
		"\7\60\2\2\u0253\u009c\3\2\2\2\u0254\u0255\7*\2\2\u0255\u009e\3\2\2\2\u0256"+
		"\u0257\7+\2\2\u0257\u00a0\3\2\2\2\u0258\u0259\7.\2\2\u0259\u00a2\3\2\2"+
		"\2\u025a\u025b\7>\2\2\u025b\u00a4\3\2\2\2\u025c\u025d\7@\2\2\u025d\u00a6"+
		"\3\2\2\2\u025e\u0260\t\20\2\2\u025f\u025e\3\2\2\2\u0260\u0261\3\2\2\2"+
		"\u0261\u025f\3\2\2\2\u0261\u0262\3\2\2\2\u0262\u0263\3\2\2\2\u0263\u0264"+
		"\bS\b\2\u0264\u00a8\3\2\2\2\u0265\u0266\t\17\2\2\u0266\u0267\3\2\2\2\u0267"+
		"\u0268\bT\t\2\u0268\u00aa\3\2\2\2,\2\3\4\u00f7\u0170\u0173\u017a\u017d"+
		"\u0180\u0186\u0189\u0192\u0198\u019c\u019f\u01a5\u01a8\u01ab\u01b0\u01b4"+
		"\u01b9\u01c0\u01c5\u01cc\u01cf\u01d3\u01d8\u01db\u01dd\u01e1\u01e6\u01ed"+
		"\u01f4\u01f6\u01ff\u020a\u0216\u0218\u0222\u022c\u0230\u0261";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}