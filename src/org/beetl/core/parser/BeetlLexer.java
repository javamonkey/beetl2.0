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
		If=1, For=2, Elsefor=3, Else=4, While=5, Switch=6, Select=7, Return=8, 
		Break=9, Continue=10, Var=11, Directive=12, Case=13, Default=14, Try=15, 
		Catch=16, LEFT_BRACE=17, RIGHT_BRACE=18, LEFT_PAR=19, RIGHT_PAR=20, LEFT_SQBR=21, 
		RIGHT_SQBR=22, INCREASE=23, DECREASE=24, VIRTUAL=25, ADD=26, MIN=27, MUlTIP=28, 
		DIV=29, MOD=30, EQUAL=31, NOT_EQUAL=32, ASSIN=33, LARGE=34, LESS=35, NOT=36, 
		AND=37, OR=38, QUESTOIN=39, AT=40, NULL=41, TRUE=42, FALSE=43, END=44, 
		COMMA=45, COLON=46, PERIOD=47, FOR_IN=48, LEFT_TOKEN=49, RIGHT_TOKEN=50, 
		LEFT_TEXT_TOKEN=51, HexLiteral=52, DecimalLiteral=53, OctalLiteral=54, 
		FloatingPointLiteral=55, CharacterLiteral=56, StringLiteral=57, Identifier=58, 
		WS=59, LINE_COMMENT=60, COMMENT_OPEN=61, COMMENT_TAG=62, COMMENT_END=63, 
		ALL_COMMENT_CHAR=64, Identifier1=65, PERIOD1=66, LEFT_PAR1=67, RIGHT_PAR1=68, 
		COMMA1=69, LEFT_ANGULAR=70, RIGHT_ANGULAR=71, WS1=72, TYPE_END=73;
	public static final int MODE_COMMENT = 1;
	public static final int MODE_COMMENT_TYPE = 2;
	public static String[] modeNames = {
		"DEFAULT_MODE", "MODE_COMMENT", "MODE_COMMENT_TYPE"
	};

	public static final String[] tokenNames = {
		"<INVALID>",
		"'if'", "'for'", "'elsefor'", "'else'", "'while'", "'switch'", "'select'", 
		"'return'", "'break'", "'continue'", "'var'", "Directive", "'case'", "'default'", 
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
		"If", "For", "Elsefor", "Else", "While", "Switch", "Select", "Return", 
		"Break", "Continue", "Var", "Directive", "Case", "Default", "Try", "Catch", 
		"LEFT_BRACE", "RIGHT_BRACE", "LEFT_PAR", "RIGHT_PAR", "LEFT_SQBR", "RIGHT_SQBR", 
		"INCREASE", "DECREASE", "VIRTUAL", "ADD", "MIN", "MUlTIP", "DIV", "MOD", 
		"EQUAL", "NOT_EQUAL", "ASSIN", "LARGE", "LESS", "NOT", "AND", "OR", "QUESTOIN", 
		"AT", "NULL", "TRUE", "FALSE", "END", "COMMA", "COLON", "PERIOD", "FOR_IN", 
		"LEFT_TOKEN", "RIGHT_TOKEN", "LEFT_TEXT_TOKEN", "HexLiteral", "DecimalLiteral", 
		"OctalLiteral", "HexDigit", "IntegerTypeSuffix", "FloatingPointLiteral", 
		"Exponent", "FloatTypeSuffix", "CharacterLiteral", "StringLiteral", "EscapeSequence", 
		"OctalEscape", "UnicodeEscape", "Identifier", "Letter", "JavaIDDigit", 
		"WS", "LINE_COMMENT", "COMMENT_OPEN", "COMMENT_TAG", "COMMENT_END", "COMMENT_END_CHAR", 
		"TYPE_CHAR", "ALL_COMMENT_CHAR", "Identifier1", "PERIOD1", "LEFT_PAR1", 
		"RIGHT_PAR1", "COMMA1", "LEFT_ANGULAR", "RIGHT_ANGULAR", "WS1", "TYPE_END"
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
		case 67: WS_action((RuleContext)_localctx, actionIndex); break;

		case 68: LINE_COMMENT_action((RuleContext)_localctx, actionIndex); break;

		case 69: COMMENT_OPEN_action((RuleContext)_localctx, actionIndex); break;

		case 70: COMMENT_TAG_action((RuleContext)_localctx, actionIndex); break;

		case 71: COMMENT_END_action((RuleContext)_localctx, actionIndex); break;

		case 74: ALL_COMMENT_CHAR_action((RuleContext)_localctx, actionIndex); break;

		case 82: WS1_action((RuleContext)_localctx, actionIndex); break;

		case 83: TYPE_END_action((RuleContext)_localctx, actionIndex); break;
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
		"\3\uacf5\uee8c\u4f5d\u8b0d\u4a45\u78bd\u1b2f\u3378\2K\u0273\b\1\b\1\b"+
		"\1\4\2\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n"+
		"\t\n\4\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21"+
		"\4\22\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30"+
		"\4\31\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37"+
		"\4 \t \4!\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t"+
		"*\4+\t+\4,\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63"+
		"\4\64\t\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t"+
		"<\4=\t=\4>\t>\4?\t?\4@\t@\4A\tA\4B\tB\4C\tC\4D\tD\4E\tE\4F\tF\4G\tG\4"+
		"H\tH\4I\tI\4J\tJ\4K\tK\4L\tL\4M\tM\4N\tN\4O\tO\4P\tP\4Q\tQ\4R\tR\4S\t"+
		"S\4T\tT\4U\tU\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4"+
		"\3\4\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3"+
		"\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\n\3\n"+
		"\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\f\3\f"+
		"\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3"+
		"\r\3\r\3\r\5\r\u0102\n\r\3\16\3\16\3\16\3\16\3\16\3\17\3\17\3\17\3\17"+
		"\3\17\3\17\3\17\3\17\3\20\3\20\3\20\3\20\3\21\3\21\3\21\3\21\3\21\3\21"+
		"\3\22\3\22\3\23\3\23\3\24\3\24\3\25\3\25\3\26\3\26\3\27\3\27\3\30\3\30"+
		"\3\30\3\31\3\31\3\31\3\32\3\32\3\32\3\33\3\33\3\34\3\34\3\35\3\35\3\36"+
		"\3\36\3\37\3\37\3 \3 \3 \3!\3!\3!\3\"\3\"\3#\3#\3$\3$\3%\3%\3&\3&\3&\3"+
		"\'\3\'\3\'\3(\3(\3)\3)\3*\3*\3*\3*\3*\3+\3+\3+\3+\3+\3,\3,\3,\3,\3,\3"+
		",\3-\3-\3.\3.\3/\3/\3\60\3\60\3\61\3\61\3\61\3\62\3\62\3\62\3\63\3\63"+
		"\3\63\3\64\3\64\3\64\3\65\3\65\3\65\6\65\u0179\n\65\r\65\16\65\u017a\3"+
		"\65\5\65\u017e\n\65\3\66\3\66\3\66\7\66\u0183\n\66\f\66\16\66\u0186\13"+
		"\66\5\66\u0188\n\66\3\66\5\66\u018b\n\66\3\67\3\67\6\67\u018f\n\67\r\67"+
		"\16\67\u0190\3\67\5\67\u0194\n\67\38\38\39\39\3:\6:\u019b\n:\r:\16:\u019c"+
		"\3:\3:\7:\u01a1\n:\f:\16:\u01a4\13:\3:\5:\u01a7\n:\3:\5:\u01aa\n:\3:\3"+
		":\6:\u01ae\n:\r:\16:\u01af\3:\5:\u01b3\n:\3:\5:\u01b6\n:\3:\6:\u01b9\n"+
		":\r:\16:\u01ba\3:\3:\5:\u01bf\n:\3:\6:\u01c2\n:\r:\16:\u01c3\3:\3:\3:"+
		"\3:\3:\5:\u01cb\n:\3:\7:\u01ce\n:\f:\16:\u01d1\13:\3:\3:\7:\u01d5\n:\f"+
		":\16:\u01d8\13:\5:\u01da\n:\3:\3:\5:\u01de\n:\3:\6:\u01e1\n:\r:\16:\u01e2"+
		"\3:\5:\u01e6\n:\5:\u01e8\n:\3;\3;\5;\u01ec\n;\3;\6;\u01ef\n;\r;\16;\u01f0"+
		"\3<\3<\3=\3=\3=\5=\u01f8\n=\3=\3=\3>\3>\3>\7>\u01ff\n>\f>\16>\u0202\13"+
		">\3>\3>\3?\3?\3?\3?\5?\u020a\n?\3@\3@\3@\3@\3@\3@\3@\3@\3@\5@\u0215\n"+
		"@\3A\3A\3A\3A\3A\3A\3A\3B\3B\3B\7B\u0221\nB\fB\16B\u0224\13B\3C\3C\3D"+
		"\3D\3E\6E\u022b\nE\rE\16E\u022c\3E\3E\3F\3F\3F\3F\7F\u0235\nF\fF\16F\u0238"+
		"\13F\3F\5F\u023b\nF\3F\3F\3F\3F\3G\3G\3G\3G\3G\3H\3H\3H\3H\3I\3I\3I\3"+
		"I\3J\3J\3J\3K\3K\3K\3K\3K\3K\3L\3L\3L\3L\3M\3M\3N\3N\3O\3O\3P\3P\3Q\3"+
		"Q\3R\3R\3S\3S\3T\6T\u026a\nT\rT\16T\u026b\3T\3T\3U\3U\3U\3U\2V\5\3\1\7"+
		"\4\1\t\5\1\13\6\1\r\7\1\17\b\1\21\t\1\23\n\1\25\13\1\27\f\1\31\r\1\33"+
		"\16\1\35\17\1\37\20\1!\21\1#\22\1%\23\1\'\24\1)\25\1+\26\1-\27\1/\30\1"+
		"\61\31\1\63\32\1\65\33\1\67\34\19\35\1;\36\1=\37\1? \1A!\1C\"\1E#\1G$"+
		"\1I%\1K&\1M\'\1O(\1Q)\1S*\1U+\1W,\1Y-\1[.\1]/\1_\60\1a\61\1c\62\1e\63"+
		"\1g\64\1i\65\1k\66\1m\67\1o8\1q\2\1s\2\1u9\1w\2\1y\2\1{:\1};\1\177\2\1"+
		"\u0081\2\1\u0083\2\1\u0085<\1\u0087\2\1\u0089\2\1\u008b=\2\u008d>\3\u008f"+
		"?\4\u0091@\5\u0093A\6\u0095\2\1\u0097\2\1\u0099B\7\u009bC\1\u009dD\1\u009f"+
		"E\1\u00a1F\1\u00a3G\1\u00a5H\1\u00a7I\1\u00a9J\b\u00abK\t\5\2\3\4\21\4"+
		"\2ZZzz\5\2\62;CHch\4\2NNnn\4\2RRrr\4\2--//\4\2GGgg\6\2FFHHffhh\4\2))^"+
		"^\4\2$$^^\n\2$$))^^ddhhppttvv\16\2&&C\\aac|\u00c2\u00d8\u00da\u00f8\u00fa"+
		"\u2001\u3042\u3191\u3302\u3381\u3402\u3d2f\u4e02\ua001\uf902\ufb01\21"+
		"\2\62;\u0662\u066b\u06f2\u06fb\u0968\u0971\u09e8\u09f1\u0a68\u0a71\u0ae8"+
		"\u0af1\u0b68\u0b71\u0be9\u0bf1\u0c68\u0c71\u0ce8\u0cf1\u0d68\u0d71\u0e52"+
		"\u0e5b\u0ed2\u0edb\u1042\u104b\5\2\13\f\16\17\"\"\4\2\f\f\17\17\5\2\13"+
		"\13\16\17\"\"\u0291\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2"+
		"\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3"+
		"\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2"+
		"\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2"+
		"/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2"+
		"\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2"+
		"G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S\3"+
		"\2\2\2\2U\3\2\2\2\2W\3\2\2\2\2Y\3\2\2\2\2[\3\2\2\2\2]\3\2\2\2\2_\3\2\2"+
		"\2\2a\3\2\2\2\2c\3\2\2\2\2e\3\2\2\2\2g\3\2\2\2\2i\3\2\2\2\2k\3\2\2\2\2"+
		"m\3\2\2\2\2o\3\2\2\2\2u\3\2\2\2\2{\3\2\2\2\2}\3\2\2\2\2\u0085\3\2\2\2"+
		"\2\u008b\3\2\2\2\2\u008d\3\2\2\2\2\u008f\3\2\2\2\3\u0091\3\2\2\2\3\u0093"+
		"\3\2\2\2\3\u0099\3\2\2\2\4\u009b\3\2\2\2\4\u009d\3\2\2\2\4\u009f\3\2\2"+
		"\2\4\u00a1\3\2\2\2\4\u00a3\3\2\2\2\4\u00a5\3\2\2\2\4\u00a7\3\2\2\2\4\u00a9"+
		"\3\2\2\2\4\u00ab\3\2\2\2\5\u00ad\3\2\2\2\7\u00b0\3\2\2\2\t\u00b4\3\2\2"+
		"\2\13\u00bc\3\2\2\2\r\u00c1\3\2\2\2\17\u00c7\3\2\2\2\21\u00ce\3\2\2\2"+
		"\23\u00d5\3\2\2\2\25\u00dc\3\2\2\2\27\u00e2\3\2\2\2\31\u00eb\3\2\2\2\33"+
		"\u0101\3\2\2\2\35\u0103\3\2\2\2\37\u0108\3\2\2\2!\u0110\3\2\2\2#\u0114"+
		"\3\2\2\2%\u011a\3\2\2\2\'\u011c\3\2\2\2)\u011e\3\2\2\2+\u0120\3\2\2\2"+
		"-\u0122\3\2\2\2/\u0124\3\2\2\2\61\u0126\3\2\2\2\63\u0129\3\2\2\2\65\u012c"+
		"\3\2\2\2\67\u012f\3\2\2\29\u0131\3\2\2\2;\u0133\3\2\2\2=\u0135\3\2\2\2"+
		"?\u0137\3\2\2\2A\u0139\3\2\2\2C\u013c\3\2\2\2E\u013f\3\2\2\2G\u0141\3"+
		"\2\2\2I\u0143\3\2\2\2K\u0145\3\2\2\2M\u0147\3\2\2\2O\u014a\3\2\2\2Q\u014d"+
		"\3\2\2\2S\u014f\3\2\2\2U\u0151\3\2\2\2W\u0156\3\2\2\2Y\u015b\3\2\2\2["+
		"\u0161\3\2\2\2]\u0163\3\2\2\2_\u0165\3\2\2\2a\u0167\3\2\2\2c\u0169\3\2"+
		"\2\2e\u016c\3\2\2\2g\u016f\3\2\2\2i\u0172\3\2\2\2k\u0175\3\2\2\2m\u0187"+
		"\3\2\2\2o\u018c\3\2\2\2q\u0195\3\2\2\2s\u0197\3\2\2\2u\u01e7\3\2\2\2w"+
		"\u01e9\3\2\2\2y\u01f2\3\2\2\2{\u01f4\3\2\2\2}\u01fb\3\2\2\2\177\u0209"+
		"\3\2\2\2\u0081\u0214\3\2\2\2\u0083\u0216\3\2\2\2\u0085\u021d\3\2\2\2\u0087"+
		"\u0225\3\2\2\2\u0089\u0227\3\2\2\2\u008b\u022a\3\2\2\2\u008d\u0230\3\2"+
		"\2\2\u008f\u0240\3\2\2\2\u0091\u0245\3\2\2\2\u0093\u0249\3\2\2\2\u0095"+
		"\u024d\3\2\2\2\u0097\u0250\3\2\2\2\u0099\u0256\3\2\2\2\u009b\u025a\3\2"+
		"\2\2\u009d\u025c\3\2\2\2\u009f\u025e\3\2\2\2\u00a1\u0260\3\2\2\2\u00a3"+
		"\u0262\3\2\2\2\u00a5\u0264\3\2\2\2\u00a7\u0266\3\2\2\2\u00a9\u0269\3\2"+
		"\2\2\u00ab\u026f\3\2\2\2\u00ad\u00ae\7k\2\2\u00ae\u00af\7h\2\2\u00af\6"+
		"\3\2\2\2\u00b0\u00b1\7h\2\2\u00b1\u00b2\7q\2\2\u00b2\u00b3\7t\2\2\u00b3"+
		"\b\3\2\2\2\u00b4\u00b5\7g\2\2\u00b5\u00b6\7n\2\2\u00b6\u00b7\7u\2\2\u00b7"+
		"\u00b8\7g\2\2\u00b8\u00b9\7h\2\2\u00b9\u00ba\7q\2\2\u00ba\u00bb\7t\2\2"+
		"\u00bb\n\3\2\2\2\u00bc\u00bd\7g\2\2\u00bd\u00be\7n\2\2\u00be\u00bf\7u"+
		"\2\2\u00bf\u00c0\7g\2\2\u00c0\f\3\2\2\2\u00c1\u00c2\7y\2\2\u00c2\u00c3"+
		"\7j\2\2\u00c3\u00c4\7k\2\2\u00c4\u00c5\7n\2\2\u00c5\u00c6\7g\2\2\u00c6"+
		"\16\3\2\2\2\u00c7\u00c8\7u\2\2\u00c8\u00c9\7y\2\2\u00c9\u00ca\7k\2\2\u00ca"+
		"\u00cb\7v\2\2\u00cb\u00cc\7e\2\2\u00cc\u00cd\7j\2\2\u00cd\20\3\2\2\2\u00ce"+
		"\u00cf\7u\2\2\u00cf\u00d0\7g\2\2\u00d0\u00d1\7n\2\2\u00d1\u00d2\7g\2\2"+
		"\u00d2\u00d3\7e\2\2\u00d3\u00d4\7v\2\2\u00d4\22\3\2\2\2\u00d5\u00d6\7"+
		"t\2\2\u00d6\u00d7\7g\2\2\u00d7\u00d8\7v\2\2\u00d8\u00d9\7w\2\2\u00d9\u00da"+
		"\7t\2\2\u00da\u00db\7p\2\2\u00db\24\3\2\2\2\u00dc\u00dd\7d\2\2\u00dd\u00de"+
		"\7t\2\2\u00de\u00df\7g\2\2\u00df\u00e0\7c\2\2\u00e0\u00e1\7m\2\2\u00e1"+
		"\26\3\2\2\2\u00e2\u00e3\7e\2\2\u00e3\u00e4\7q\2\2\u00e4\u00e5\7p\2\2\u00e5"+
		"\u00e6\7v\2\2\u00e6\u00e7\7k\2\2\u00e7\u00e8\7p\2\2\u00e8\u00e9\7w\2\2"+
		"\u00e9\u00ea\7g\2\2\u00ea\30\3\2\2\2\u00eb\u00ec\7x\2\2\u00ec\u00ed\7"+
		"c\2\2\u00ed\u00ee\7t\2\2\u00ee\32\3\2\2\2\u00ef\u00f0\7F\2\2\u00f0\u00f1"+
		"\7K\2\2\u00f1\u00f2\7T\2\2\u00f2\u00f3\7G\2\2\u00f3\u00f4\7E\2\2\u00f4"+
		"\u00f5\7V\2\2\u00f5\u00f6\7K\2\2\u00f6\u00f7\7X\2\2\u00f7\u0102\7G\2\2"+
		"\u00f8\u00f9\7f\2\2\u00f9\u00fa\7k\2\2\u00fa\u00fb\7t\2\2\u00fb\u00fc"+
		"\7g\2\2\u00fc\u00fd\7e\2\2\u00fd\u00fe\7v\2\2\u00fe\u00ff\7k\2\2\u00ff"+
		"\u0100\7x\2\2\u0100\u0102\7g\2\2\u0101\u00ef\3\2\2\2\u0101\u00f8\3\2\2"+
		"\2\u0102\34\3\2\2\2\u0103\u0104\7e\2\2\u0104\u0105\7c\2\2\u0105\u0106"+
		"\7u\2\2\u0106\u0107\7g\2\2\u0107\36\3\2\2\2\u0108\u0109\7f\2\2\u0109\u010a"+
		"\7g\2\2\u010a\u010b\7h\2\2\u010b\u010c\7c\2\2\u010c\u010d\7w\2\2\u010d"+
		"\u010e\7n\2\2\u010e\u010f\7v\2\2\u010f \3\2\2\2\u0110\u0111\7v\2\2\u0111"+
		"\u0112\7t\2\2\u0112\u0113\7{\2\2\u0113\"\3\2\2\2\u0114\u0115\7e\2\2\u0115"+
		"\u0116\7c\2\2\u0116\u0117\7v\2\2\u0117\u0118\7e\2\2\u0118\u0119\7j\2\2"+
		"\u0119$\3\2\2\2\u011a\u011b\7}\2\2\u011b&\3\2\2\2\u011c\u011d\7\177\2"+
		"\2\u011d(\3\2\2\2\u011e\u011f\7*\2\2\u011f*\3\2\2\2\u0120\u0121\7+\2\2"+
		"\u0121,\3\2\2\2\u0122\u0123\7]\2\2\u0123.\3\2\2\2\u0124\u0125\7_\2\2\u0125"+
		"\60\3\2\2\2\u0126\u0127\7-\2\2\u0127\u0128\7-\2\2\u0128\62\3\2\2\2\u0129"+
		"\u012a\7/\2\2\u012a\u012b\7/\2\2\u012b\64\3\2\2\2\u012c\u012d\7\60\2\2"+
		"\u012d\u012e\7\u0080\2\2\u012e\66\3\2\2\2\u012f\u0130\7-\2\2\u01308\3"+
		"\2\2\2\u0131\u0132\7/\2\2\u0132:\3\2\2\2\u0133\u0134\7,\2\2\u0134<\3\2"+
		"\2\2\u0135\u0136\7\61\2\2\u0136>\3\2\2\2\u0137\u0138\7\'\2\2\u0138@\3"+
		"\2\2\2\u0139\u013a\7?\2\2\u013a\u013b\7?\2\2\u013bB\3\2\2\2\u013c\u013d"+
		"\7#\2\2\u013d\u013e\7?\2\2\u013eD\3\2\2\2\u013f\u0140\7?\2\2\u0140F\3"+
		"\2\2\2\u0141\u0142\7@\2\2\u0142H\3\2\2\2\u0143\u0144\7>\2\2\u0144J\3\2"+
		"\2\2\u0145\u0146\7#\2\2\u0146L\3\2\2\2\u0147\u0148\7(\2\2\u0148\u0149"+
		"\7(\2\2\u0149N\3\2\2\2\u014a\u014b\7~\2\2\u014b\u014c\7~\2\2\u014cP\3"+
		"\2\2\2\u014d\u014e\7A\2\2\u014eR\3\2\2\2\u014f\u0150\7B\2\2\u0150T\3\2"+
		"\2\2\u0151\u0152\7p\2\2\u0152\u0153\7w\2\2\u0153\u0154\7n\2\2\u0154\u0155"+
		"\7n\2\2\u0155V\3\2\2\2\u0156\u0157\7v\2\2\u0157\u0158\7t\2\2\u0158\u0159"+
		"\7w\2\2\u0159\u015a\7g\2\2\u015aX\3\2\2\2\u015b\u015c\7h\2\2\u015c\u015d"+
		"\7c\2\2\u015d\u015e\7n\2\2\u015e\u015f\7u\2\2\u015f\u0160\7g\2\2\u0160"+
		"Z\3\2\2\2\u0161\u0162\7=\2\2\u0162\\\3\2\2\2\u0163\u0164\7.\2\2\u0164"+
		"^\3\2\2\2\u0165\u0166\7<\2\2\u0166`\3\2\2\2\u0167\u0168\7\60\2\2\u0168"+
		"b\3\2\2\2\u0169\u016a\7k\2\2\u016a\u016b\7p\2\2\u016bd\3\2\2\2\u016c\u016d"+
		"\7>\2\2\u016d\u016e\7>\2\2\u016ef\3\2\2\2\u016f\u0170\7@\2\2\u0170\u0171"+
		"\7@\2\2\u0171h\3\2\2\2\u0172\u0173\7>\2\2\u0173\u0174\7&\2\2\u0174j\3"+
		"\2\2\2\u0175\u0176\7\62\2\2\u0176\u0178\t\2\2\2\u0177\u0179\5q8\2\u0178"+
		"\u0177\3\2\2\2\u0179\u017a\3\2\2\2\u017a\u0178\3\2\2\2\u017a\u017b\3\2"+
		"\2\2\u017b\u017d\3\2\2\2\u017c\u017e\5s9\2\u017d\u017c\3\2\2\2\u017d\u017e"+
		"\3\2\2\2\u017el\3\2\2\2\u017f\u0188\7\62\2\2\u0180\u0184\4\63;\2\u0181"+
		"\u0183\4\62;\2\u0182\u0181\3\2\2\2\u0183\u0186\3\2\2\2\u0184\u0182\3\2"+
		"\2\2\u0184\u0185\3\2\2\2\u0185\u0188\3\2\2\2\u0186\u0184\3\2\2\2\u0187"+
		"\u017f\3\2\2\2\u0187\u0180\3\2\2\2\u0188\u018a\3\2\2\2\u0189\u018b\5s"+
		"9\2\u018a\u0189\3\2\2\2\u018a\u018b\3\2\2\2\u018bn\3\2\2\2\u018c\u018e"+
		"\7\62\2\2\u018d\u018f\4\629\2\u018e\u018d\3\2\2\2\u018f\u0190\3\2\2\2"+
		"\u0190\u018e\3\2\2\2\u0190\u0191\3\2\2\2\u0191\u0193\3\2\2\2\u0192\u0194"+
		"\5s9\2\u0193\u0192\3\2\2\2\u0193\u0194\3\2\2\2\u0194p\3\2\2\2\u0195\u0196"+
		"\t\3\2\2\u0196r\3\2\2\2\u0197\u0198\t\4\2\2\u0198t\3\2\2\2\u0199\u019b"+
		"\4\62;\2\u019a\u0199\3\2\2\2\u019b\u019c\3\2\2\2\u019c\u019a\3\2\2\2\u019c"+
		"\u019d\3\2\2\2\u019d\u019e\3\2\2\2\u019e\u01a2\7\60\2\2\u019f\u01a1\4"+
		"\62;\2\u01a0\u019f\3\2\2\2\u01a1\u01a4\3\2\2\2\u01a2\u01a0\3\2\2\2\u01a2"+
		"\u01a3\3\2\2\2\u01a3\u01a6\3\2\2\2\u01a4\u01a2\3\2\2\2\u01a5\u01a7\5w"+
		";\2\u01a6\u01a5\3\2\2\2\u01a6\u01a7\3\2\2\2\u01a7\u01a9\3\2\2\2\u01a8"+
		"\u01aa\5y<\2\u01a9\u01a8\3\2\2\2\u01a9\u01aa\3\2\2\2\u01aa\u01e8\3\2\2"+
		"\2\u01ab\u01ad\7\60\2\2\u01ac\u01ae\4\62;\2\u01ad\u01ac\3\2\2\2\u01ae"+
		"\u01af\3\2\2\2\u01af\u01ad\3\2\2\2\u01af\u01b0\3\2\2\2\u01b0\u01b2\3\2"+
		"\2\2\u01b1\u01b3\5w;\2\u01b2\u01b1\3\2\2\2\u01b2\u01b3\3\2\2\2\u01b3\u01b5"+
		"\3\2\2\2\u01b4\u01b6\5y<\2\u01b5\u01b4\3\2\2\2\u01b5\u01b6\3\2\2\2\u01b6"+
		"\u01e8\3\2\2\2\u01b7\u01b9\4\62;\2\u01b8\u01b7\3\2\2\2\u01b9\u01ba\3\2"+
		"\2\2\u01ba\u01b8\3\2\2\2\u01ba\u01bb\3\2\2\2\u01bb\u01bc\3\2\2\2\u01bc"+
		"\u01be\5w;\2\u01bd\u01bf\5y<\2\u01be\u01bd\3\2\2\2\u01be\u01bf\3\2\2\2"+
		"\u01bf\u01e8\3\2\2\2\u01c0\u01c2\4\62;\2\u01c1\u01c0\3\2\2\2\u01c2\u01c3"+
		"\3\2\2\2\u01c3\u01c1\3\2\2\2\u01c3\u01c4\3\2\2\2\u01c4\u01c5\3\2\2\2\u01c5"+
		"\u01e8\5y<\2\u01c6\u01c7\7\62\2\2\u01c7\u01cb\7z\2\2\u01c8\u01c9\7\62"+
		"\2\2\u01c9\u01cb\7Z\2\2\u01ca\u01c6\3\2\2\2\u01ca\u01c8\3\2\2\2\u01cb"+
		"\u01cf\3\2\2\2\u01cc\u01ce\5q8\2\u01cd\u01cc\3\2\2\2\u01ce\u01d1\3\2\2"+
		"\2\u01cf\u01cd\3\2\2\2\u01cf\u01d0\3\2\2\2\u01d0\u01d9\3\2\2\2\u01d1\u01cf"+
		"\3\2\2\2\u01d2\u01d6\7\60\2\2\u01d3\u01d5\5q8\2\u01d4\u01d3\3\2\2\2\u01d5"+
		"\u01d8\3\2\2\2\u01d6\u01d4\3\2\2\2\u01d6\u01d7\3\2\2\2\u01d7\u01da\3\2"+
		"\2\2\u01d8\u01d6\3\2\2\2\u01d9\u01d2\3\2\2\2\u01d9\u01da\3\2\2\2\u01da"+
		"\u01db\3\2\2\2\u01db\u01dd\t\5\2\2\u01dc\u01de\t\6\2\2\u01dd\u01dc\3\2"+
		"\2\2\u01dd\u01de\3\2\2\2\u01de\u01e0\3\2\2\2\u01df\u01e1\4\62;\2\u01e0"+
		"\u01df\3\2\2\2\u01e1\u01e2\3\2\2\2\u01e2\u01e0\3\2\2\2\u01e2\u01e3\3\2"+
		"\2\2\u01e3\u01e5\3\2\2\2\u01e4\u01e6\5y<\2\u01e5\u01e4\3\2\2\2\u01e5\u01e6"+
		"\3\2\2\2\u01e6\u01e8\3\2\2\2\u01e7\u019a\3\2\2\2\u01e7\u01ab\3\2\2\2\u01e7"+
		"\u01b8\3\2\2\2\u01e7\u01c1\3\2\2\2\u01e7\u01ca\3\2\2\2\u01e8v\3\2\2\2"+
		"\u01e9\u01eb\t\7\2\2\u01ea\u01ec\t\6\2\2\u01eb\u01ea\3\2\2\2\u01eb\u01ec"+
		"\3\2\2\2\u01ec\u01ee\3\2\2\2\u01ed\u01ef\4\62;\2\u01ee\u01ed\3\2\2\2\u01ef"+
		"\u01f0\3\2\2\2\u01f0\u01ee\3\2\2\2\u01f0\u01f1\3\2\2\2\u01f1x\3\2\2\2"+
		"\u01f2\u01f3\t\b\2\2\u01f3z\3\2\2\2\u01f4\u01f7\7)\2\2\u01f5\u01f8\5\177"+
		"?\2\u01f6\u01f8\n\t\2\2\u01f7\u01f5\3\2\2\2\u01f7\u01f6\3\2\2\2\u01f8"+
		"\u01f9\3\2\2\2\u01f9\u01fa\7)\2\2\u01fa|\3\2\2\2\u01fb\u0200\7$\2\2\u01fc"+
		"\u01ff\5\177?\2\u01fd\u01ff\n\n\2\2\u01fe\u01fc\3\2\2\2\u01fe\u01fd\3"+
		"\2\2\2\u01ff\u0202\3\2\2\2\u0200\u01fe\3\2\2\2\u0200\u0201\3\2\2\2\u0201"+
		"\u0203\3\2\2\2\u0202\u0200\3\2\2\2\u0203\u0204\7$\2\2\u0204~\3\2\2\2\u0205"+
		"\u0206\7^\2\2\u0206\u020a\t\13\2\2\u0207\u020a\5\u0083A\2\u0208\u020a"+
		"\5\u0081@\2\u0209\u0205\3\2\2\2\u0209\u0207\3\2\2\2\u0209\u0208\3\2\2"+
		"\2\u020a\u0080\3\2\2\2\u020b\u020c\7^\2\2\u020c\u020d\4\62\65\2\u020d"+
		"\u020e\4\629\2\u020e\u0215\4\629\2\u020f\u0210\7^\2\2\u0210\u0211\4\62"+
		"9\2\u0211\u0215\4\629\2\u0212\u0213\7^\2\2\u0213\u0215\4\629\2\u0214\u020b"+
		"\3\2\2\2\u0214\u020f\3\2\2\2\u0214\u0212\3\2\2\2\u0215\u0082\3\2\2\2\u0216"+
		"\u0217\7^\2\2\u0217\u0218\7w\2\2\u0218\u0219\5q8\2\u0219\u021a\5q8\2\u021a"+
		"\u021b\5q8\2\u021b\u021c\5q8\2\u021c\u0084\3\2\2\2\u021d\u0222\5\u0087"+
		"C\2\u021e\u0221\5\u0087C\2\u021f\u0221\5\u0089D\2\u0220\u021e\3\2\2\2"+
		"\u0220\u021f\3\2\2\2\u0221\u0224\3\2\2\2\u0222\u0220\3\2\2\2\u0222\u0223"+
		"\3\2\2\2\u0223\u0086\3\2\2\2\u0224\u0222\3\2\2\2\u0225\u0226\t\f\2\2\u0226"+
		"\u0088\3\2\2\2\u0227\u0228\t\r\2\2\u0228\u008a\3\2\2\2\u0229\u022b\t\16"+
		"\2\2\u022a\u0229\3\2\2\2\u022b\u022c\3\2\2\2\u022c\u022a\3\2\2\2\u022c"+
		"\u022d\3\2\2\2\u022d\u022e\3\2\2\2\u022e\u022f\bE\2\2\u022f\u008c\3\2"+
		"\2\2\u0230\u0231\7\61\2\2\u0231\u0232\7\61\2\2\u0232\u0236\3\2\2\2\u0233"+
		"\u0235\n\17\2\2\u0234\u0233\3\2\2\2\u0235\u0238\3\2\2\2\u0236\u0234\3"+
		"\2\2\2\u0236\u0237\3\2\2\2\u0237\u023a\3\2\2\2\u0238\u0236\3\2\2\2\u0239"+
		"\u023b\7\17\2\2\u023a\u0239\3\2\2\2\u023a\u023b\3\2\2\2\u023b\u023c\3"+
		"\2\2\2\u023c\u023d\7\f\2\2\u023d\u023e\3\2\2\2\u023e\u023f\bF\3\2\u023f"+
		"\u008e\3\2\2\2\u0240\u0241\7\61\2\2\u0241\u0242\7,\2\2\u0242\u0243\3\2"+
		"\2\2\u0243\u0244\bG\4\2\u0244\u0090\3\2\2\2\u0245\u0246\5\u0097K\2\u0246"+
		"\u0247\3\2\2\2\u0247\u0248\bH\5\2\u0248\u0092\3\2\2\2\u0249\u024a\5\u0095"+
		"J\2\u024a\u024b\3\2\2\2\u024b\u024c\bI\6\2\u024c\u0094\3\2\2\2\u024d\u024e"+
		"\7,\2\2\u024e\u024f\7\61\2\2\u024f\u0096\3\2\2\2\u0250\u0251\7B\2\2\u0251"+
		"\u0252\7v\2\2\u0252\u0253\7{\2\2\u0253\u0254\7r\2\2\u0254\u0255\7g\2\2"+
		"\u0255\u0098\3\2\2\2\u0256\u0257\13\2\2\2\u0257\u0258\3\2\2\2\u0258\u0259"+
		"\bL\7\2\u0259\u009a\3\2\2\2\u025a\u025b\5\u0085B\2\u025b\u009c\3\2\2\2"+
		"\u025c\u025d\7\60\2\2\u025d\u009e\3\2\2\2\u025e\u025f\7*\2\2\u025f\u00a0"+
		"\3\2\2\2\u0260\u0261\7+\2\2\u0261\u00a2\3\2\2\2\u0262\u0263\7.\2\2\u0263"+
		"\u00a4\3\2\2\2\u0264\u0265\7>\2\2\u0265\u00a6\3\2\2\2\u0266\u0267\7@\2"+
		"\2\u0267\u00a8\3\2\2\2\u0268\u026a\t\20\2\2\u0269\u0268\3\2\2\2\u026a"+
		"\u026b\3\2\2\2\u026b\u0269\3\2\2\2\u026b\u026c\3\2\2\2\u026c\u026d\3\2"+
		"\2\2\u026d\u026e\bT\b\2\u026e\u00aa\3\2\2\2\u026f\u0270\t\17\2\2\u0270"+
		"\u0271\3\2\2\2\u0271\u0272\bU\t\2\u0272\u00ac\3\2\2\2,\2\3\4\u0101\u017a"+
		"\u017d\u0184\u0187\u018a\u0190\u0193\u019c\u01a2\u01a6\u01a9\u01af\u01b2"+
		"\u01b5\u01ba\u01be\u01c3\u01ca\u01cf\u01d6\u01d9\u01dd\u01e2\u01e5\u01e7"+
		"\u01eb\u01f0\u01f7\u01fe\u0200\u0209\u0214\u0220\u0222\u022c\u0236\u023a"+
		"\u026b";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}