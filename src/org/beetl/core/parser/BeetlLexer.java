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
		COMMENT_OPEN=60, COMMENT_TAG=61, COMMENT_END=62, Identifier1=63, PERIOD1=64, 
		LEFT_PAR1=65, RIGHT_PAR1=66, COMMA1=67, TYPE_END=68;
	public static final int MODE_COMMENT = 1;
	public static final int MODE_COMMENT_TYPE = 2;
	public static String[] modeNames = {
		"DEFAULT_MODE", "MODE_COMMENT", "MODE_COMMENT_TYPE"
	};

	public static final String[] tokenNames = {
		"<INVALID>",
		"'if'", "'for'", "'else'", "'while'", "'switch'", "'select'", "'return'", 
		"'break'", "'continue'", "'var'", "Directive", "'case'", "'default'", 
		"'try'", "'catch'", "'{'", "'}'", "'('", "')'", "'['", "']'", "'++'", 
		"'--'", "'.~'", "'+'", "'-'", "'*'", "'/'", "'%'", "'=='", "'!='", "'='", 
		"'>'", "'<'", "'!'", "'&&'", "'||'", "'?'", "AT", "'null'", "'true'", 
		"'false'", "';'", "','", "':'", "'.'", "'in'", "'<<'", "'>>'", "'<$'", 
		"HexLiteral", "DecimalLiteral", "OctalLiteral", "FloatingPointLiteral", 
		"CharacterLiteral", "StringLiteral", "Identifier", "WS", "LINE_COMMENT", 
		"COMMENT_OPEN", "COMMENT_TAG", "'*/'", "Identifier1", "PERIOD1", "LEFT_PAR1", 
		"RIGHT_PAR1", "COMMA1", "TYPE_END"
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
		"COMMENT_OPEN", "COMMENT_TAG", "COMMENT_END", "Identifier1", "PERIOD1", 
		"LEFT_PAR1", "RIGHT_PAR1", "COMMA1", "TYPE_END"
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

		case 76: TYPE_END_action((RuleContext)_localctx, actionIndex); break;
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
		case 5: popMode(); _channel = HIDDEN;  break;
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
	private void LINE_COMMENT_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 1: _channel = HIDDEN;  break;
		}
	}

	public static final String _serializedATN =
		"\3\uacf5\uee8c\u4f5d\u8b0d\u4a45\u78bd\u1b2f\u3378\2F\u0246\b\1\b\1\b"+
		"\1\4\2\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n"+
		"\t\n\4\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21"+
		"\4\22\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30"+
		"\4\31\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37"+
		"\4 \t \4!\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t"+
		"*\4+\t+\4,\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63"+
		"\4\64\t\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t"+
		"<\4=\t=\4>\t>\4?\t?\4@\t@\4A\tA\4B\tB\4C\tC\4D\tD\4E\tE\4F\tF\4G\tG\4"+
		"H\tH\4I\tI\4J\tJ\4K\tK\4L\tL\4M\tM\4N\tN\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3"+
		"\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6"+
		"\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3"+
		"\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\f"+
		"\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\5"+
		"\f\u00ec\n\f\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3"+
		"\16\3\17\3\17\3\17\3\17\3\20\3\20\3\20\3\20\3\20\3\20\3\21\3\21\3\22\3"+
		"\22\3\23\3\23\3\24\3\24\3\25\3\25\3\26\3\26\3\27\3\27\3\27\3\30\3\30\3"+
		"\30\3\31\3\31\3\31\3\32\3\32\3\33\3\33\3\34\3\34\3\35\3\35\3\36\3\36\3"+
		"\37\3\37\3\37\3 \3 \3 \3!\3!\3\"\3\"\3#\3#\3$\3$\3%\3%\3%\3&\3&\3&\3\'"+
		"\3\'\3(\3(\3)\3)\3)\3)\3)\3*\3*\3*\3*\3*\3+\3+\3+\3+\3+\3+\3,\3,\3-\3"+
		"-\3.\3.\3/\3/\3\60\3\60\3\60\3\61\3\61\3\61\3\62\3\62\3\62\3\63\3\63\3"+
		"\63\3\64\3\64\3\64\6\64\u0163\n\64\r\64\16\64\u0164\3\64\5\64\u0168\n"+
		"\64\3\65\3\65\3\65\7\65\u016d\n\65\f\65\16\65\u0170\13\65\5\65\u0172\n"+
		"\65\3\65\5\65\u0175\n\65\3\66\3\66\6\66\u0179\n\66\r\66\16\66\u017a\3"+
		"\66\5\66\u017e\n\66\3\67\3\67\38\38\39\69\u0185\n9\r9\169\u0186\39\39"+
		"\79\u018b\n9\f9\169\u018e\139\39\59\u0191\n9\39\59\u0194\n9\39\39\69\u0198"+
		"\n9\r9\169\u0199\39\59\u019d\n9\39\59\u01a0\n9\39\69\u01a3\n9\r9\169\u01a4"+
		"\39\39\59\u01a9\n9\39\69\u01ac\n9\r9\169\u01ad\39\39\39\39\39\59\u01b5"+
		"\n9\39\79\u01b8\n9\f9\169\u01bb\139\39\39\79\u01bf\n9\f9\169\u01c2\13"+
		"9\59\u01c4\n9\39\39\59\u01c8\n9\39\69\u01cb\n9\r9\169\u01cc\39\59\u01d0"+
		"\n9\59\u01d2\n9\3:\3:\5:\u01d6\n:\3:\6:\u01d9\n:\r:\16:\u01da\3;\3;\3"+
		"<\3<\3<\5<\u01e2\n<\3<\3<\3=\3=\3=\7=\u01e9\n=\f=\16=\u01ec\13=\3=\3="+
		"\3>\3>\3>\3>\5>\u01f4\n>\3?\3?\3?\3?\3?\3?\3?\3?\3?\5?\u01ff\n?\3@\3@"+
		"\3@\3@\3@\3@\3@\3A\3A\3A\7A\u020b\nA\fA\16A\u020e\13A\3B\3B\3C\3C\3D\6"+
		"D\u0215\nD\rD\16D\u0216\3D\3D\3E\3E\3E\3E\7E\u021f\nE\fE\16E\u0222\13"+
		"E\3E\5E\u0225\nE\3E\3E\3E\3E\3F\3F\3F\3F\3F\3G\3G\3G\3G\3H\3H\3H\3H\3"+
		"H\3I\3I\3J\3J\3K\3K\3L\3L\3M\3M\3N\3N\3N\3N\2O\5\3\1\7\4\1\t\5\1\13\6"+
		"\1\r\7\1\17\b\1\21\t\1\23\n\1\25\13\1\27\f\1\31\r\1\33\16\1\35\17\1\37"+
		"\20\1!\21\1#\22\1%\23\1\'\24\1)\25\1+\26\1-\27\1/\30\1\61\31\1\63\32\1"+
		"\65\33\1\67\34\19\35\1;\36\1=\37\1? \1A!\1C\"\1E#\1G$\1I%\1K&\1M\'\1O"+
		"(\1Q)\1S*\1U+\1W,\1Y-\1[.\1]/\1_\60\1a\61\1c\62\1e\63\1g\64\1i\65\1k\66"+
		"\1m\67\1o\2\1q\2\1s8\1u\2\1w\2\1y9\1{:\1}\2\1\177\2\1\u0081\2\1\u0083"+
		";\1\u0085\2\1\u0087\2\1\u0089<\2\u008b=\3\u008d>\4\u008f?\5\u0091@\6\u0093"+
		"A\1\u0095B\1\u0097C\1\u0099D\1\u009bE\1\u009dF\7\5\2\3\4\20\4\2ZZzz\5"+
		"\2\62;CHch\4\2NNnn\4\2RRrr\4\2--//\4\2GGgg\6\2FFHHffhh\4\2))^^\4\2$$^"+
		"^\n\2$$))^^ddhhppttvv\16\2&&C\\aac|\u00c2\u00d8\u00da\u00f8\u00fa\u2001"+
		"\u3042\u3191\u3302\u3381\u3402\u3d2f\u4e02\ua001\uf902\ufb01\21\2\62;"+
		"\u0662\u066b\u06f2\u06fb\u0968\u0971\u09e8\u09f1\u0a68\u0a71\u0ae8\u0af1"+
		"\u0b68\u0b71\u0be9\u0bf1\u0c68\u0c71\u0ce8\u0cf1\u0d68\u0d71\u0e52\u0e5b"+
		"\u0ed2\u0edb\u1042\u104b\5\2\13\f\16\17\"\"\4\2\f\f\17\17\u0265\2\5\3"+
		"\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2"+
		"\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3"+
		"\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'"+
		"\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63"+
		"\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2"+
		"?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3"+
		"\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2\2W\3\2\2"+
		"\2\2Y\3\2\2\2\2[\3\2\2\2\2]\3\2\2\2\2_\3\2\2\2\2a\3\2\2\2\2c\3\2\2\2\2"+
		"e\3\2\2\2\2g\3\2\2\2\2i\3\2\2\2\2k\3\2\2\2\2m\3\2\2\2\2s\3\2\2\2\2y\3"+
		"\2\2\2\2{\3\2\2\2\2\u0083\3\2\2\2\2\u0089\3\2\2\2\2\u008b\3\2\2\2\2\u008d"+
		"\3\2\2\2\3\u008f\3\2\2\2\3\u0091\3\2\2\2\4\u0093\3\2\2\2\4\u0095\3\2\2"+
		"\2\4\u0097\3\2\2\2\4\u0099\3\2\2\2\4\u009b\3\2\2\2\4\u009d\3\2\2\2\5\u009f"+
		"\3\2\2\2\7\u00a2\3\2\2\2\t\u00a6\3\2\2\2\13\u00ab\3\2\2\2\r\u00b1\3\2"+
		"\2\2\17\u00b8\3\2\2\2\21\u00bf\3\2\2\2\23\u00c6\3\2\2\2\25\u00cc\3\2\2"+
		"\2\27\u00d5\3\2\2\2\31\u00eb\3\2\2\2\33\u00ed\3\2\2\2\35\u00f2\3\2\2\2"+
		"\37\u00fa\3\2\2\2!\u00fe\3\2\2\2#\u0104\3\2\2\2%\u0106\3\2\2\2\'\u0108"+
		"\3\2\2\2)\u010a\3\2\2\2+\u010c\3\2\2\2-\u010e\3\2\2\2/\u0110\3\2\2\2\61"+
		"\u0113\3\2\2\2\63\u0116\3\2\2\2\65\u0119\3\2\2\2\67\u011b\3\2\2\29\u011d"+
		"\3\2\2\2;\u011f\3\2\2\2=\u0121\3\2\2\2?\u0123\3\2\2\2A\u0126\3\2\2\2C"+
		"\u0129\3\2\2\2E\u012b\3\2\2\2G\u012d\3\2\2\2I\u012f\3\2\2\2K\u0131\3\2"+
		"\2\2M\u0134\3\2\2\2O\u0137\3\2\2\2Q\u0139\3\2\2\2S\u013b\3\2\2\2U\u0140"+
		"\3\2\2\2W\u0145\3\2\2\2Y\u014b\3\2\2\2[\u014d\3\2\2\2]\u014f\3\2\2\2_"+
		"\u0151\3\2\2\2a\u0153\3\2\2\2c\u0156\3\2\2\2e\u0159\3\2\2\2g\u015c\3\2"+
		"\2\2i\u015f\3\2\2\2k\u0171\3\2\2\2m\u0176\3\2\2\2o\u017f\3\2\2\2q\u0181"+
		"\3\2\2\2s\u01d1\3\2\2\2u\u01d3\3\2\2\2w\u01dc\3\2\2\2y\u01de\3\2\2\2{"+
		"\u01e5\3\2\2\2}\u01f3\3\2\2\2\177\u01fe\3\2\2\2\u0081\u0200\3\2\2\2\u0083"+
		"\u0207\3\2\2\2\u0085\u020f\3\2\2\2\u0087\u0211\3\2\2\2\u0089\u0214\3\2"+
		"\2\2\u008b\u021a\3\2\2\2\u008d\u022a\3\2\2\2\u008f\u022f\3\2\2\2\u0091"+
		"\u0233\3\2\2\2\u0093\u0238\3\2\2\2\u0095\u023a\3\2\2\2\u0097\u023c\3\2"+
		"\2\2\u0099\u023e\3\2\2\2\u009b\u0240\3\2\2\2\u009d\u0242\3\2\2\2\u009f"+
		"\u00a0\7k\2\2\u00a0\u00a1\7h\2\2\u00a1\6\3\2\2\2\u00a2\u00a3\7h\2\2\u00a3"+
		"\u00a4\7q\2\2\u00a4\u00a5\7t\2\2\u00a5\b\3\2\2\2\u00a6\u00a7\7g\2\2\u00a7"+
		"\u00a8\7n\2\2\u00a8\u00a9\7u\2\2\u00a9\u00aa\7g\2\2\u00aa\n\3\2\2\2\u00ab"+
		"\u00ac\7y\2\2\u00ac\u00ad\7j\2\2\u00ad\u00ae\7k\2\2\u00ae\u00af\7n\2\2"+
		"\u00af\u00b0\7g\2\2\u00b0\f\3\2\2\2\u00b1\u00b2\7u\2\2\u00b2\u00b3\7y"+
		"\2\2\u00b3\u00b4\7k\2\2\u00b4\u00b5\7v\2\2\u00b5\u00b6\7e\2\2\u00b6\u00b7"+
		"\7j\2\2\u00b7\16\3\2\2\2\u00b8\u00b9\7u\2\2\u00b9\u00ba\7g\2\2\u00ba\u00bb"+
		"\7n\2\2\u00bb\u00bc\7g\2\2\u00bc\u00bd\7e\2\2\u00bd\u00be\7v\2\2\u00be"+
		"\20\3\2\2\2\u00bf\u00c0\7t\2\2\u00c0\u00c1\7g\2\2\u00c1\u00c2\7v\2\2\u00c2"+
		"\u00c3\7w\2\2\u00c3\u00c4\7t\2\2\u00c4\u00c5\7p\2\2\u00c5\22\3\2\2\2\u00c6"+
		"\u00c7\7d\2\2\u00c7\u00c8\7t\2\2\u00c8\u00c9\7g\2\2\u00c9\u00ca\7c\2\2"+
		"\u00ca\u00cb\7m\2\2\u00cb\24\3\2\2\2\u00cc\u00cd\7e\2\2\u00cd\u00ce\7"+
		"q\2\2\u00ce\u00cf\7p\2\2\u00cf\u00d0\7v\2\2\u00d0\u00d1\7k\2\2\u00d1\u00d2"+
		"\7p\2\2\u00d2\u00d3\7w\2\2\u00d3\u00d4\7g\2\2\u00d4\26\3\2\2\2\u00d5\u00d6"+
		"\7x\2\2\u00d6\u00d7\7c\2\2\u00d7\u00d8\7t\2\2\u00d8\30\3\2\2\2\u00d9\u00da"+
		"\7F\2\2\u00da\u00db\7K\2\2\u00db\u00dc\7T\2\2\u00dc\u00dd\7G\2\2\u00dd"+
		"\u00de\7E\2\2\u00de\u00df\7V\2\2\u00df\u00e0\7K\2\2\u00e0\u00e1\7X\2\2"+
		"\u00e1\u00ec\7G\2\2\u00e2\u00e3\7f\2\2\u00e3\u00e4\7k\2\2\u00e4\u00e5"+
		"\7t\2\2\u00e5\u00e6\7g\2\2\u00e6\u00e7\7e\2\2\u00e7\u00e8\7v\2\2\u00e8"+
		"\u00e9\7k\2\2\u00e9\u00ea\7x\2\2\u00ea\u00ec\7g\2\2\u00eb\u00d9\3\2\2"+
		"\2\u00eb\u00e2\3\2\2\2\u00ec\32\3\2\2\2\u00ed\u00ee\7e\2\2\u00ee\u00ef"+
		"\7c\2\2\u00ef\u00f0\7u\2\2\u00f0\u00f1\7g\2\2\u00f1\34\3\2\2\2\u00f2\u00f3"+
		"\7f\2\2\u00f3\u00f4\7g\2\2\u00f4\u00f5\7h\2\2\u00f5\u00f6\7c\2\2\u00f6"+
		"\u00f7\7w\2\2\u00f7\u00f8\7n\2\2\u00f8\u00f9\7v\2\2\u00f9\36\3\2\2\2\u00fa"+
		"\u00fb\7v\2\2\u00fb\u00fc\7t\2\2\u00fc\u00fd\7{\2\2\u00fd \3\2\2\2\u00fe"+
		"\u00ff\7e\2\2\u00ff\u0100\7c\2\2\u0100\u0101\7v\2\2\u0101\u0102\7e\2\2"+
		"\u0102\u0103\7j\2\2\u0103\"\3\2\2\2\u0104\u0105\7}\2\2\u0105$\3\2\2\2"+
		"\u0106\u0107\7\177\2\2\u0107&\3\2\2\2\u0108\u0109\7*\2\2\u0109(\3\2\2"+
		"\2\u010a\u010b\7+\2\2\u010b*\3\2\2\2\u010c\u010d\7]\2\2\u010d,\3\2\2\2"+
		"\u010e\u010f\7_\2\2\u010f.\3\2\2\2\u0110\u0111\7-\2\2\u0111\u0112\7-\2"+
		"\2\u0112\60\3\2\2\2\u0113\u0114\7/\2\2\u0114\u0115\7/\2\2\u0115\62\3\2"+
		"\2\2\u0116\u0117\7\60\2\2\u0117\u0118\7\u0080\2\2\u0118\64\3\2\2\2\u0119"+
		"\u011a\7-\2\2\u011a\66\3\2\2\2\u011b\u011c\7/\2\2\u011c8\3\2\2\2\u011d"+
		"\u011e\7,\2\2\u011e:\3\2\2\2\u011f\u0120\7\61\2\2\u0120<\3\2\2\2\u0121"+
		"\u0122\7\'\2\2\u0122>\3\2\2\2\u0123\u0124\7?\2\2\u0124\u0125\7?\2\2\u0125"+
		"@\3\2\2\2\u0126\u0127\7#\2\2\u0127\u0128\7?\2\2\u0128B\3\2\2\2\u0129\u012a"+
		"\7?\2\2\u012aD\3\2\2\2\u012b\u012c\7@\2\2\u012cF\3\2\2\2\u012d\u012e\7"+
		">\2\2\u012eH\3\2\2\2\u012f\u0130\7#\2\2\u0130J\3\2\2\2\u0131\u0132\7("+
		"\2\2\u0132\u0133\7(\2\2\u0133L\3\2\2\2\u0134\u0135\7~\2\2\u0135\u0136"+
		"\7~\2\2\u0136N\3\2\2\2\u0137\u0138\7A\2\2\u0138P\3\2\2\2\u0139\u013a\7"+
		"B\2\2\u013aR\3\2\2\2\u013b\u013c\7p\2\2\u013c\u013d\7w\2\2\u013d\u013e"+
		"\7n\2\2\u013e\u013f\7n\2\2\u013fT\3\2\2\2\u0140\u0141\7v\2\2\u0141\u0142"+
		"\7t\2\2\u0142\u0143\7w\2\2\u0143\u0144\7g\2\2\u0144V\3\2\2\2\u0145\u0146"+
		"\7h\2\2\u0146\u0147\7c\2\2\u0147\u0148\7n\2\2\u0148\u0149\7u\2\2\u0149"+
		"\u014a\7g\2\2\u014aX\3\2\2\2\u014b\u014c\7=\2\2\u014cZ\3\2\2\2\u014d\u014e"+
		"\7.\2\2\u014e\\\3\2\2\2\u014f\u0150\7<\2\2\u0150^\3\2\2\2\u0151\u0152"+
		"\7\60\2\2\u0152`\3\2\2\2\u0153\u0154\7k\2\2\u0154\u0155\7p\2\2\u0155b"+
		"\3\2\2\2\u0156\u0157\7>\2\2\u0157\u0158\7>\2\2\u0158d\3\2\2\2\u0159\u015a"+
		"\7@\2\2\u015a\u015b\7@\2\2\u015bf\3\2\2\2\u015c\u015d\7>\2\2\u015d\u015e"+
		"\7&\2\2\u015eh\3\2\2\2\u015f\u0160\7\62\2\2\u0160\u0162\t\2\2\2\u0161"+
		"\u0163\5o\67\2\u0162\u0161\3\2\2\2\u0163\u0164\3\2\2\2\u0164\u0162\3\2"+
		"\2\2\u0164\u0165\3\2\2\2\u0165\u0167\3\2\2\2\u0166\u0168\5q8\2\u0167\u0166"+
		"\3\2\2\2\u0167\u0168\3\2\2\2\u0168j\3\2\2\2\u0169\u0172\7\62\2\2\u016a"+
		"\u016e\4\63;\2\u016b\u016d\4\62;\2\u016c\u016b\3\2\2\2\u016d\u0170\3\2"+
		"\2\2\u016e\u016c\3\2\2\2\u016e\u016f\3\2\2\2\u016f\u0172\3\2\2\2\u0170"+
		"\u016e\3\2\2\2\u0171\u0169\3\2\2\2\u0171\u016a\3\2\2\2\u0172\u0174\3\2"+
		"\2\2\u0173\u0175\5q8\2\u0174\u0173\3\2\2\2\u0174\u0175\3\2\2\2\u0175l"+
		"\3\2\2\2\u0176\u0178\7\62\2\2\u0177\u0179\4\629\2\u0178\u0177\3\2\2\2"+
		"\u0179\u017a\3\2\2\2\u017a\u0178\3\2\2\2\u017a\u017b\3\2\2\2\u017b\u017d"+
		"\3\2\2\2\u017c\u017e\5q8\2\u017d\u017c\3\2\2\2\u017d\u017e\3\2\2\2\u017e"+
		"n\3\2\2\2\u017f\u0180\t\3\2\2\u0180p\3\2\2\2\u0181\u0182\t\4\2\2\u0182"+
		"r\3\2\2\2\u0183\u0185\4\62;\2\u0184\u0183\3\2\2\2\u0185\u0186\3\2\2\2"+
		"\u0186\u0184\3\2\2\2\u0186\u0187\3\2\2\2\u0187\u0188\3\2\2\2\u0188\u018c"+
		"\7\60\2\2\u0189\u018b\4\62;\2\u018a\u0189\3\2\2\2\u018b\u018e\3\2\2\2"+
		"\u018c\u018a\3\2\2\2\u018c\u018d\3\2\2\2\u018d\u0190\3\2\2\2\u018e\u018c"+
		"\3\2\2\2\u018f\u0191\5u:\2\u0190\u018f\3\2\2\2\u0190\u0191\3\2\2\2\u0191"+
		"\u0193\3\2\2\2\u0192\u0194\5w;\2\u0193\u0192\3\2\2\2\u0193\u0194\3\2\2"+
		"\2\u0194\u01d2\3\2\2\2\u0195\u0197\7\60\2\2\u0196\u0198\4\62;\2\u0197"+
		"\u0196\3\2\2\2\u0198\u0199\3\2\2\2\u0199\u0197\3\2\2\2\u0199\u019a\3\2"+
		"\2\2\u019a\u019c\3\2\2\2\u019b\u019d\5u:\2\u019c\u019b\3\2\2\2\u019c\u019d"+
		"\3\2\2\2\u019d\u019f\3\2\2\2\u019e\u01a0\5w;\2\u019f\u019e\3\2\2\2\u019f"+
		"\u01a0\3\2\2\2\u01a0\u01d2\3\2\2\2\u01a1\u01a3\4\62;\2\u01a2\u01a1\3\2"+
		"\2\2\u01a3\u01a4\3\2\2\2\u01a4\u01a2\3\2\2\2\u01a4\u01a5\3\2\2\2\u01a5"+
		"\u01a6\3\2\2\2\u01a6\u01a8\5u:\2\u01a7\u01a9\5w;\2\u01a8\u01a7\3\2\2\2"+
		"\u01a8\u01a9\3\2\2\2\u01a9\u01d2\3\2\2\2\u01aa\u01ac\4\62;\2\u01ab\u01aa"+
		"\3\2\2\2\u01ac\u01ad\3\2\2\2\u01ad\u01ab\3\2\2\2\u01ad\u01ae\3\2\2\2\u01ae"+
		"\u01af\3\2\2\2\u01af\u01d2\5w;\2\u01b0\u01b1\7\62\2\2\u01b1\u01b5\7z\2"+
		"\2\u01b2\u01b3\7\62\2\2\u01b3\u01b5\7Z\2\2\u01b4\u01b0\3\2\2\2\u01b4\u01b2"+
		"\3\2\2\2\u01b5\u01b9\3\2\2\2\u01b6\u01b8\5o\67\2\u01b7\u01b6\3\2\2\2\u01b8"+
		"\u01bb\3\2\2\2\u01b9\u01b7\3\2\2\2\u01b9\u01ba\3\2\2\2\u01ba\u01c3\3\2"+
		"\2\2\u01bb\u01b9\3\2\2\2\u01bc\u01c0\7\60\2\2\u01bd\u01bf\5o\67\2\u01be"+
		"\u01bd\3\2\2\2\u01bf\u01c2\3\2\2\2\u01c0\u01be\3\2\2\2\u01c0\u01c1\3\2"+
		"\2\2\u01c1\u01c4\3\2\2\2\u01c2\u01c0\3\2\2\2\u01c3\u01bc\3\2\2\2\u01c3"+
		"\u01c4\3\2\2\2\u01c4\u01c5\3\2\2\2\u01c5\u01c7\t\5\2\2\u01c6\u01c8\t\6"+
		"\2\2\u01c7\u01c6\3\2\2\2\u01c7\u01c8\3\2\2\2\u01c8\u01ca\3\2\2\2\u01c9"+
		"\u01cb\4\62;\2\u01ca\u01c9\3\2\2\2\u01cb\u01cc\3\2\2\2\u01cc\u01ca\3\2"+
		"\2\2\u01cc\u01cd\3\2\2\2\u01cd\u01cf\3\2\2\2\u01ce\u01d0\5w;\2\u01cf\u01ce"+
		"\3\2\2\2\u01cf\u01d0\3\2\2\2\u01d0\u01d2\3\2\2\2\u01d1\u0184\3\2\2\2\u01d1"+
		"\u0195\3\2\2\2\u01d1\u01a2\3\2\2\2\u01d1\u01ab\3\2\2\2\u01d1\u01b4\3\2"+
		"\2\2\u01d2t\3\2\2\2\u01d3\u01d5\t\7\2\2\u01d4\u01d6\t\6\2\2\u01d5\u01d4"+
		"\3\2\2\2\u01d5\u01d6\3\2\2\2\u01d6\u01d8\3\2\2\2\u01d7\u01d9\4\62;\2\u01d8"+
		"\u01d7\3\2\2\2\u01d9\u01da\3\2\2\2\u01da\u01d8\3\2\2\2\u01da\u01db\3\2"+
		"\2\2\u01dbv\3\2\2\2\u01dc\u01dd\t\b\2\2\u01ddx\3\2\2\2\u01de\u01e1\7)"+
		"\2\2\u01df\u01e2\5}>\2\u01e0\u01e2\n\t\2\2\u01e1\u01df\3\2\2\2\u01e1\u01e0"+
		"\3\2\2\2\u01e2\u01e3\3\2\2\2\u01e3\u01e4\7)\2\2\u01e4z\3\2\2\2\u01e5\u01ea"+
		"\7$\2\2\u01e6\u01e9\5}>\2\u01e7\u01e9\n\n\2\2\u01e8\u01e6\3\2\2\2\u01e8"+
		"\u01e7\3\2\2\2\u01e9\u01ec\3\2\2\2\u01ea\u01e8\3\2\2\2\u01ea\u01eb\3\2"+
		"\2\2\u01eb\u01ed\3\2\2\2\u01ec\u01ea\3\2\2\2\u01ed\u01ee\7$\2\2\u01ee"+
		"|\3\2\2\2\u01ef\u01f0\7^\2\2\u01f0\u01f4\t\13\2\2\u01f1\u01f4\5\u0081"+
		"@\2\u01f2\u01f4\5\177?\2\u01f3\u01ef\3\2\2\2\u01f3\u01f1\3\2\2\2\u01f3"+
		"\u01f2\3\2\2\2\u01f4~\3\2\2\2\u01f5\u01f6\7^\2\2\u01f6\u01f7\4\62\65\2"+
		"\u01f7\u01f8\4\629\2\u01f8\u01ff\4\629\2\u01f9\u01fa\7^\2\2\u01fa\u01fb"+
		"\4\629\2\u01fb\u01ff\4\629\2\u01fc\u01fd\7^\2\2\u01fd\u01ff\4\629\2\u01fe"+
		"\u01f5\3\2\2\2\u01fe\u01f9\3\2\2\2\u01fe\u01fc\3\2\2\2\u01ff\u0080\3\2"+
		"\2\2\u0200\u0201\7^\2\2\u0201\u0202\7w\2\2\u0202\u0203\5o\67\2\u0203\u0204"+
		"\5o\67\2\u0204\u0205\5o\67\2\u0205\u0206\5o\67\2\u0206\u0082\3\2\2\2\u0207"+
		"\u020c\5\u0085B\2\u0208\u020b\5\u0085B\2\u0209\u020b\5\u0087C\2\u020a"+
		"\u0208\3\2\2\2\u020a\u0209\3\2\2\2\u020b\u020e\3\2\2\2\u020c\u020a\3\2"+
		"\2\2\u020c\u020d\3\2\2\2\u020d\u0084\3\2\2\2\u020e\u020c\3\2\2\2\u020f"+
		"\u0210\t\f\2\2\u0210\u0086\3\2\2\2\u0211\u0212\t\r\2\2\u0212\u0088\3\2"+
		"\2\2\u0213\u0215\t\16\2\2\u0214\u0213\3\2\2\2\u0215\u0216\3\2\2\2\u0216"+
		"\u0214\3\2\2\2\u0216\u0217\3\2\2\2\u0217\u0218\3\2\2\2\u0218\u0219\bD"+
		"\2\2\u0219\u008a\3\2\2\2\u021a\u021b\7\61\2\2\u021b\u021c\7\61\2\2\u021c"+
		"\u0220\3\2\2\2\u021d\u021f\n\17\2\2\u021e\u021d\3\2\2\2\u021f\u0222\3"+
		"\2\2\2\u0220\u021e\3\2\2\2\u0220\u0221\3\2\2\2\u0221\u0224\3\2\2\2\u0222"+
		"\u0220\3\2\2\2\u0223\u0225\7\17\2\2\u0224\u0223\3\2\2\2\u0224\u0225\3"+
		"\2\2\2\u0225\u0226\3\2\2\2\u0226\u0227\7\f\2\2\u0227\u0228\3\2\2\2\u0228"+
		"\u0229\bE\3\2\u0229\u008c\3\2\2\2\u022a\u022b\7\61\2\2\u022b\u022c\7,"+
		"\2\2\u022c\u022d\3\2\2\2\u022d\u022e\bF\4\2\u022e\u008e\3\2\2\2\u022f"+
		"\u0230\7B\2\2\u0230\u0231\3\2\2\2\u0231\u0232\bG\5\2\u0232\u0090\3\2\2"+
		"\2\u0233\u0234\7,\2\2\u0234\u0235\7\61\2\2\u0235\u0236\3\2\2\2\u0236\u0237"+
		"\bH\6\2\u0237\u0092\3\2\2\2\u0238\u0239\5\u0083A\2\u0239\u0094\3\2\2\2"+
		"\u023a\u023b\5_/\2\u023b\u0096\3\2\2\2\u023c\u023d\5\'\23\2\u023d\u0098"+
		"\3\2\2\2\u023e\u023f\5)\24\2\u023f\u009a\3\2\2\2\u0240\u0241\5[-\2\u0241"+
		"\u009c\3\2\2\2\u0242\u0243\t\17\2\2\u0243\u0244\3\2\2\2\u0244\u0245\b"+
		"N\7\2\u0245\u009e\3\2\2\2+\2\3\4\u00eb\u0164\u0167\u016e\u0171\u0174\u017a"+
		"\u017d\u0186\u018c\u0190\u0193\u0199\u019c\u019f\u01a4\u01a8\u01ad\u01b4"+
		"\u01b9\u01c0\u01c3\u01c7\u01cc\u01cf\u01d1\u01d5\u01da\u01e1\u01e8\u01ea"+
		"\u01f3\u01fe\u020a\u020c\u0216\u0220\u0224";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}