// Generated from E:\lijz\javamonkey\bee\research\antlrworks2\projects\beetl\BeetlLexer.g4 by ANTLR 4.1
package org.beetl.core.parser;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.RuleContext;
import org.antlr.v4.runtime.atn.ATN;
import org.antlr.v4.runtime.atn.ATNSimulator;
import org.antlr.v4.runtime.atn.LexerATNSimulator;
import org.antlr.v4.runtime.atn.PredictionContextCache;
import org.antlr.v4.runtime.dfa.DFA;

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
		CharacterLiteral=55, StringLiteral=56, Identifier=57, COMMENT_OPEN=58, 
		PARAS=59, WS1=60, COMMENT_END=61, WS=62, LINE_COMMENT=63;
	public static final int ISLAND = 1;
	public static String[] modeNames = {
		"DEFAULT_MODE", "ISLAND"
	};

	public static final String[] tokenNames = {
		"<INVALID>",
		"'if'", "'for'", "'else'", "'while'", "'switch'", "'select'", "'return'", 
		"'break'", "'continue'", "'var'", "Directive", "'case'", "'default'", 
		"'try'", "'catch'", "'{'", "'}'", "'('", "')'", "'['", "']'", "'++'", 
		"'--'", "'.~'", "'+'", "'-'", "'*'", "'/'", "'%'", "'=='", "'!='", "'='", 
		"'>'", "'<'", "'!'", "'&&'", "'||'", "'?'", "'@'", "'null'", "'true'", 
		"'false'", "';'", "','", "':'", "'.'", "'in'", "'<<'", "'>>'", "'<$'", 
		"HexLiteral", "DecimalLiteral", "OctalLiteral", "FloatingPointLiteral", 
		"CharacterLiteral", "StringLiteral", "Identifier", "COMMENT_OPEN", "PARAS", 
		"WS1", "COMMENT_END", "WS", "LINE_COMMENT"
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
		"UnicodeEscape", "Identifier", "Letter", "JavaIDDigit", "COMMENT_OPEN", 
		"PARAS", "WS1", "COMMENT_END", "WS", "LINE_COMMENT"
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
		case 66: COMMENT_OPEN_action((RuleContext)_localctx, actionIndex); break;

		case 68: WS1_action((RuleContext)_localctx, actionIndex); break;

		case 69: COMMENT_END_action((RuleContext)_localctx, actionIndex); break;

		case 70: WS_action((RuleContext)_localctx, actionIndex); break;

		case 71: LINE_COMMENT_action((RuleContext)_localctx, actionIndex); break;
		}
	}
	private void COMMENT_OPEN_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 0: _mode = ISLAND; _channel = HIDDEN;  break;
		}
	}
	private void WS_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 3: _channel = HIDDEN;  break;
		}
	}
	private void COMMENT_END_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 2: _mode = DEFAULT_MODE; _channel = HIDDEN;  break;
		}
	}
	private void LINE_COMMENT_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 4: _channel = HIDDEN;  break;
		}
	}
	private void WS1_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 1: _channel = HIDDEN;  break;
		}
	}

	public static final String _serializedATN =
		"\3\uacf5\uee8c\u4f5d\u8b0d\u4a45\u78bd\u1b2f\u3378\2A\u023b\b\1\b\1\4"+
		"\2\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n"+
		"\4\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t"+
		" \4!\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t"+
		"+\4,\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64"+
		"\t\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t"+
		"=\4>\t>\4?\t?\4@\t@\4A\tA\4B\tB\4C\tC\4D\tD\4E\tE\4F\tF\4G\tG\4H\tH\4"+
		"I\tI\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3"+
		"\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\b\3\b"+
		"\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3"+
		"\n\3\n\3\n\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f"+
		"\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\5\f\u00e1\n\f\3\r\3\r\3\r\3\r\3\r\3\16"+
		"\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3\20\3\20\3\20"+
		"\3\20\3\20\3\20\3\21\3\21\3\22\3\22\3\23\3\23\3\24\3\24\3\25\3\25\3\26"+
		"\3\26\3\27\3\27\3\27\3\30\3\30\3\30\3\31\3\31\3\31\3\32\3\32\3\33\3\33"+
		"\3\34\3\34\3\35\3\35\3\36\3\36\3\37\3\37\3\37\3 \3 \3 \3!\3!\3\"\3\"\3"+
		"#\3#\3$\3$\3%\3%\3%\3&\3&\3&\3\'\3\'\3(\3(\3)\3)\3)\3)\3)\3*\3*\3*\3*"+
		"\3*\3+\3+\3+\3+\3+\3+\3,\3,\3-\3-\3.\3.\3/\3/\3\60\3\60\3\60\3\61\3\61"+
		"\3\61\3\62\3\62\3\62\3\63\3\63\3\63\3\64\3\64\3\64\6\64\u0158\n\64\r\64"+
		"\16\64\u0159\3\64\5\64\u015d\n\64\3\65\3\65\3\65\7\65\u0162\n\65\f\65"+
		"\16\65\u0165\13\65\5\65\u0167\n\65\3\65\5\65\u016a\n\65\3\66\3\66\6\66"+
		"\u016e\n\66\r\66\16\66\u016f\3\66\5\66\u0173\n\66\3\67\3\67\38\38\39\6"+
		"9\u017a\n9\r9\169\u017b\39\39\79\u0180\n9\f9\169\u0183\139\39\59\u0186"+
		"\n9\39\59\u0189\n9\39\39\69\u018d\n9\r9\169\u018e\39\59\u0192\n9\39\5"+
		"9\u0195\n9\39\69\u0198\n9\r9\169\u0199\39\39\59\u019e\n9\39\69\u01a1\n"+
		"9\r9\169\u01a2\39\39\39\39\39\59\u01aa\n9\39\79\u01ad\n9\f9\169\u01b0"+
		"\139\39\39\79\u01b4\n9\f9\169\u01b7\139\59\u01b9\n9\39\39\59\u01bd\n9"+
		"\39\69\u01c0\n9\r9\169\u01c1\39\59\u01c5\n9\59\u01c7\n9\3:\3:\5:\u01cb"+
		"\n:\3:\6:\u01ce\n:\r:\16:\u01cf\3;\3;\3<\3<\3<\5<\u01d7\n<\3<\3<\3=\3"+
		"=\3=\7=\u01de\n=\f=\16=\u01e1\13=\3=\3=\3>\3>\3>\3>\5>\u01e9\n>\3?\3?"+
		"\3?\3?\3?\3?\3?\3?\3?\5?\u01f4\n?\3@\3@\3@\3@\3@\3@\3@\3A\3A\3A\7A\u0200"+
		"\nA\fA\16A\u0203\13A\3B\3B\3C\3C\3D\3D\3D\3D\3D\3E\3E\3E\3E\3E\3E\7E\u0214"+
		"\nE\fE\16E\u0217\13E\3F\6F\u021a\nF\rF\16F\u021b\3F\3F\3G\3G\3G\3G\3G"+
		"\3H\6H\u0226\nH\rH\16H\u0227\3H\3H\3I\3I\3I\3I\7I\u0230\nI\fI\16I\u0233"+
		"\13I\3I\5I\u0236\nI\3I\3I\3I\3I\2J\4\3\1\6\4\1\b\5\1\n\6\1\f\7\1\16\b"+
		"\1\20\t\1\22\n\1\24\13\1\26\f\1\30\r\1\32\16\1\34\17\1\36\20\1 \21\1\""+
		"\22\1$\23\1&\24\1(\25\1*\26\1,\27\1.\30\1\60\31\1\62\32\1\64\33\1\66\34"+
		"\18\35\1:\36\1<\37\1> \1@!\1B\"\1D#\1F$\1H%\1J&\1L\'\1N(\1P)\1R*\1T+\1"+
		"V,\1X-\1Z.\1\\/\1^\60\1`\61\1b\62\1d\63\1f\64\1h\65\1j\66\1l\67\1n\2\1"+
		"p\2\1r8\1t\2\1v\2\1x9\1z:\1|\2\1~\2\1\u0080\2\1\u0082;\1\u0084\2\1\u0086"+
		"\2\1\u0088<\2\u008a=\1\u008c>\3\u008e?\4\u0090@\5\u0092A\6\4\2\3\20\4"+
		"\2ZZzz\5\2\62;CHch\4\2NNnn\4\2RRrr\4\2--//\4\2GGgg\6\2FFHHffhh\4\2))^"+
		"^\4\2$$^^\n\2$$))^^ddhhppttvv\16\2&&C\\aac|\u00c2\u00d8\u00da\u00f8\u00fa"+
		"\u2001\u3042\u3191\u3302\u3381\u3402\u3d2f\u4e02\ua001\uf902\ufb01\21"+
		"\2\62;\u0662\u066b\u06f2\u06fb\u0968\u0971\u09e8\u09f1\u0a68\u0a71\u0ae8"+
		"\u0af1\u0b68\u0b71\u0be9\u0bf1\u0c68\u0c71\u0ce8\u0cf1\u0d68\u0d71\u0e52"+
		"\u0e5b\u0ed2\u0edb\u1042\u104b\5\2\13\f\16\17\"\"\4\2\f\f\17\17\u025d"+
		"\2\4\3\2\2\2\2\6\3\2\2\2\2\b\3\2\2\2\2\n\3\2\2\2\2\f\3\2\2\2\2\16\3\2"+
		"\2\2\2\20\3\2\2\2\2\22\3\2\2\2\2\24\3\2\2\2\2\26\3\2\2\2\2\30\3\2\2\2"+
		"\2\32\3\2\2\2\2\34\3\2\2\2\2\36\3\2\2\2\2 \3\2\2\2\2\"\3\2\2\2\2$\3\2"+
		"\2\2\2&\3\2\2\2\2(\3\2\2\2\2*\3\2\2\2\2,\3\2\2\2\2.\3\2\2\2\2\60\3\2\2"+
		"\2\2\62\3\2\2\2\2\64\3\2\2\2\2\66\3\2\2\2\28\3\2\2\2\2:\3\2\2\2\2<\3\2"+
		"\2\2\2>\3\2\2\2\2@\3\2\2\2\2B\3\2\2\2\2D\3\2\2\2\2F\3\2\2\2\2H\3\2\2\2"+
		"\2J\3\2\2\2\2L\3\2\2\2\2N\3\2\2\2\2P\3\2\2\2\2R\3\2\2\2\2T\3\2\2\2\2V"+
		"\3\2\2\2\2X\3\2\2\2\2Z\3\2\2\2\2\\\3\2\2\2\2^\3\2\2\2\2`\3\2\2\2\2b\3"+
		"\2\2\2\2d\3\2\2\2\2f\3\2\2\2\2h\3\2\2\2\2j\3\2\2\2\2l\3\2\2\2\2r\3\2\2"+
		"\2\2x\3\2\2\2\2z\3\2\2\2\2\u0082\3\2\2\2\2\u0088\3\2\2\2\3\u008a\3\2\2"+
		"\2\3\u008c\3\2\2\2\3\u008e\3\2\2\2\3\u0090\3\2\2\2\3\u0092\3\2\2\2\4\u0094"+
		"\3\2\2\2\6\u0097\3\2\2\2\b\u009b\3\2\2\2\n\u00a0\3\2\2\2\f\u00a6\3\2\2"+
		"\2\16\u00ad\3\2\2\2\20\u00b4\3\2\2\2\22\u00bb\3\2\2\2\24\u00c1\3\2\2\2"+
		"\26\u00ca\3\2\2\2\30\u00e0\3\2\2\2\32\u00e2\3\2\2\2\34\u00e7\3\2\2\2\36"+
		"\u00ef\3\2\2\2 \u00f3\3\2\2\2\"\u00f9\3\2\2\2$\u00fb\3\2\2\2&\u00fd\3"+
		"\2\2\2(\u00ff\3\2\2\2*\u0101\3\2\2\2,\u0103\3\2\2\2.\u0105\3\2\2\2\60"+
		"\u0108\3\2\2\2\62\u010b\3\2\2\2\64\u010e\3\2\2\2\66\u0110\3\2\2\28\u0112"+
		"\3\2\2\2:\u0114\3\2\2\2<\u0116\3\2\2\2>\u0118\3\2\2\2@\u011b\3\2\2\2B"+
		"\u011e\3\2\2\2D\u0120\3\2\2\2F\u0122\3\2\2\2H\u0124\3\2\2\2J\u0126\3\2"+
		"\2\2L\u0129\3\2\2\2N\u012c\3\2\2\2P\u012e\3\2\2\2R\u0130\3\2\2\2T\u0135"+
		"\3\2\2\2V\u013a\3\2\2\2X\u0140\3\2\2\2Z\u0142\3\2\2\2\\\u0144\3\2\2\2"+
		"^\u0146\3\2\2\2`\u0148\3\2\2\2b\u014b\3\2\2\2d\u014e\3\2\2\2f\u0151\3"+
		"\2\2\2h\u0154\3\2\2\2j\u0166\3\2\2\2l\u016b\3\2\2\2n\u0174\3\2\2\2p\u0176"+
		"\3\2\2\2r\u01c6\3\2\2\2t\u01c8\3\2\2\2v\u01d1\3\2\2\2x\u01d3\3\2\2\2z"+
		"\u01da\3\2\2\2|\u01e8\3\2\2\2~\u01f3\3\2\2\2\u0080\u01f5\3\2\2\2\u0082"+
		"\u01fc\3\2\2\2\u0084\u0204\3\2\2\2\u0086\u0206\3\2\2\2\u0088\u0208\3\2"+
		"\2\2\u008a\u020d\3\2\2\2\u008c\u0219\3\2\2\2\u008e\u021f\3\2\2\2\u0090"+
		"\u0225\3\2\2\2\u0092\u022b\3\2\2\2\u0094\u0095\7k\2\2\u0095\u0096\7h\2"+
		"\2\u0096\5\3\2\2\2\u0097\u0098\7h\2\2\u0098\u0099\7q\2\2\u0099\u009a\7"+
		"t\2\2\u009a\7\3\2\2\2\u009b\u009c\7g\2\2\u009c\u009d\7n\2\2\u009d\u009e"+
		"\7u\2\2\u009e\u009f\7g\2\2\u009f\t\3\2\2\2\u00a0\u00a1\7y\2\2\u00a1\u00a2"+
		"\7j\2\2\u00a2\u00a3\7k\2\2\u00a3\u00a4\7n\2\2\u00a4\u00a5\7g\2\2\u00a5"+
		"\13\3\2\2\2\u00a6\u00a7\7u\2\2\u00a7\u00a8\7y\2\2\u00a8\u00a9\7k\2\2\u00a9"+
		"\u00aa\7v\2\2\u00aa\u00ab\7e\2\2\u00ab\u00ac\7j\2\2\u00ac\r\3\2\2\2\u00ad"+
		"\u00ae\7u\2\2\u00ae\u00af\7g\2\2\u00af\u00b0\7n\2\2\u00b0\u00b1\7g\2\2"+
		"\u00b1\u00b2\7e\2\2\u00b2\u00b3\7v\2\2\u00b3\17\3\2\2\2\u00b4\u00b5\7"+
		"t\2\2\u00b5\u00b6\7g\2\2\u00b6\u00b7\7v\2\2\u00b7\u00b8\7w\2\2\u00b8\u00b9"+
		"\7t\2\2\u00b9\u00ba\7p\2\2\u00ba\21\3\2\2\2\u00bb\u00bc\7d\2\2\u00bc\u00bd"+
		"\7t\2\2\u00bd\u00be\7g\2\2\u00be\u00bf\7c\2\2\u00bf\u00c0\7m\2\2\u00c0"+
		"\23\3\2\2\2\u00c1\u00c2\7e\2\2\u00c2\u00c3\7q\2\2\u00c3\u00c4\7p\2\2\u00c4"+
		"\u00c5\7v\2\2\u00c5\u00c6\7k\2\2\u00c6\u00c7\7p\2\2\u00c7\u00c8\7w\2\2"+
		"\u00c8\u00c9\7g\2\2\u00c9\25\3\2\2\2\u00ca\u00cb\7x\2\2\u00cb\u00cc\7"+
		"c\2\2\u00cc\u00cd\7t\2\2\u00cd\27\3\2\2\2\u00ce\u00cf\7F\2\2\u00cf\u00d0"+
		"\7K\2\2\u00d0\u00d1\7T\2\2\u00d1\u00d2\7G\2\2\u00d2\u00d3\7E\2\2\u00d3"+
		"\u00d4\7V\2\2\u00d4\u00d5\7K\2\2\u00d5\u00d6\7X\2\2\u00d6\u00e1\7G\2\2"+
		"\u00d7\u00d8\7f\2\2\u00d8\u00d9\7k\2\2\u00d9\u00da\7t\2\2\u00da\u00db"+
		"\7g\2\2\u00db\u00dc\7e\2\2\u00dc\u00dd\7v\2\2\u00dd\u00de\7k\2\2\u00de"+
		"\u00df\7x\2\2\u00df\u00e1\7g\2\2\u00e0\u00ce\3\2\2\2\u00e0\u00d7\3\2\2"+
		"\2\u00e1\31\3\2\2\2\u00e2\u00e3\7e\2\2\u00e3\u00e4\7c\2\2\u00e4\u00e5"+
		"\7u\2\2\u00e5\u00e6\7g\2\2\u00e6\33\3\2\2\2\u00e7\u00e8\7f\2\2\u00e8\u00e9"+
		"\7g\2\2\u00e9\u00ea\7h\2\2\u00ea\u00eb\7c\2\2\u00eb\u00ec\7w\2\2\u00ec"+
		"\u00ed\7n\2\2\u00ed\u00ee\7v\2\2\u00ee\35\3\2\2\2\u00ef\u00f0\7v\2\2\u00f0"+
		"\u00f1\7t\2\2\u00f1\u00f2\7{\2\2\u00f2\37\3\2\2\2\u00f3\u00f4\7e\2\2\u00f4"+
		"\u00f5\7c\2\2\u00f5\u00f6\7v\2\2\u00f6\u00f7\7e\2\2\u00f7\u00f8\7j\2\2"+
		"\u00f8!\3\2\2\2\u00f9\u00fa\7}\2\2\u00fa#\3\2\2\2\u00fb\u00fc\7\177\2"+
		"\2\u00fc%\3\2\2\2\u00fd\u00fe\7*\2\2\u00fe\'\3\2\2\2\u00ff\u0100\7+\2"+
		"\2\u0100)\3\2\2\2\u0101\u0102\7]\2\2\u0102+\3\2\2\2\u0103\u0104\7_\2\2"+
		"\u0104-\3\2\2\2\u0105\u0106\7-\2\2\u0106\u0107\7-\2\2\u0107/\3\2\2\2\u0108"+
		"\u0109\7/\2\2\u0109\u010a\7/\2\2\u010a\61\3\2\2\2\u010b\u010c\7\60\2\2"+
		"\u010c\u010d\7\u0080\2\2\u010d\63\3\2\2\2\u010e\u010f\7-\2\2\u010f\65"+
		"\3\2\2\2\u0110\u0111\7/\2\2\u0111\67\3\2\2\2\u0112\u0113\7,\2\2\u0113"+
		"9\3\2\2\2\u0114\u0115\7\61\2\2\u0115;\3\2\2\2\u0116\u0117\7\'\2\2\u0117"+
		"=\3\2\2\2\u0118\u0119\7?\2\2\u0119\u011a\7?\2\2\u011a?\3\2\2\2\u011b\u011c"+
		"\7#\2\2\u011c\u011d\7?\2\2\u011dA\3\2\2\2\u011e\u011f\7?\2\2\u011fC\3"+
		"\2\2\2\u0120\u0121\7@\2\2\u0121E\3\2\2\2\u0122\u0123\7>\2\2\u0123G\3\2"+
		"\2\2\u0124\u0125\7#\2\2\u0125I\3\2\2\2\u0126\u0127\7(\2\2\u0127\u0128"+
		"\7(\2\2\u0128K\3\2\2\2\u0129\u012a\7~\2\2\u012a\u012b\7~\2\2\u012bM\3"+
		"\2\2\2\u012c\u012d\7A\2\2\u012dO\3\2\2\2\u012e\u012f\7B\2\2\u012fQ\3\2"+
		"\2\2\u0130\u0131\7p\2\2\u0131\u0132\7w\2\2\u0132\u0133\7n\2\2\u0133\u0134"+
		"\7n\2\2\u0134S\3\2\2\2\u0135\u0136\7v\2\2\u0136\u0137\7t\2\2\u0137\u0138"+
		"\7w\2\2\u0138\u0139\7g\2\2\u0139U\3\2\2\2\u013a\u013b\7h\2\2\u013b\u013c"+
		"\7c\2\2\u013c\u013d\7n\2\2\u013d\u013e\7u\2\2\u013e\u013f\7g\2\2\u013f"+
		"W\3\2\2\2\u0140\u0141\7=\2\2\u0141Y\3\2\2\2\u0142\u0143\7.\2\2\u0143["+
		"\3\2\2\2\u0144\u0145\7<\2\2\u0145]\3\2\2\2\u0146\u0147\7\60\2\2\u0147"+
		"_\3\2\2\2\u0148\u0149\7k\2\2\u0149\u014a\7p\2\2\u014aa\3\2\2\2\u014b\u014c"+
		"\7>\2\2\u014c\u014d\7>\2\2\u014dc\3\2\2\2\u014e\u014f\7@\2\2\u014f\u0150"+
		"\7@\2\2\u0150e\3\2\2\2\u0151\u0152\7>\2\2\u0152\u0153\7&\2\2\u0153g\3"+
		"\2\2\2\u0154\u0155\7\62\2\2\u0155\u0157\t\2\2\2\u0156\u0158\5n\67\2\u0157"+
		"\u0156\3\2\2\2\u0158\u0159\3\2\2\2\u0159\u0157\3\2\2\2\u0159\u015a\3\2"+
		"\2\2\u015a\u015c\3\2\2\2\u015b\u015d\5p8\2\u015c\u015b\3\2\2\2\u015c\u015d"+
		"\3\2\2\2\u015di\3\2\2\2\u015e\u0167\7\62\2\2\u015f\u0163\4\63;\2\u0160"+
		"\u0162\4\62;\2\u0161\u0160\3\2\2\2\u0162\u0165\3\2\2\2\u0163\u0161\3\2"+
		"\2\2\u0163\u0164\3\2\2\2\u0164\u0167\3\2\2\2\u0165\u0163\3\2\2\2\u0166"+
		"\u015e\3\2\2\2\u0166\u015f\3\2\2\2\u0167\u0169\3\2\2\2\u0168\u016a\5p"+
		"8\2\u0169\u0168\3\2\2\2\u0169\u016a\3\2\2\2\u016ak\3\2\2\2\u016b\u016d"+
		"\7\62\2\2\u016c\u016e\4\629\2\u016d\u016c\3\2\2\2\u016e\u016f\3\2\2\2"+
		"\u016f\u016d\3\2\2\2\u016f\u0170\3\2\2\2\u0170\u0172\3\2\2\2\u0171\u0173"+
		"\5p8\2\u0172\u0171\3\2\2\2\u0172\u0173\3\2\2\2\u0173m\3\2\2\2\u0174\u0175"+
		"\t\3\2\2\u0175o\3\2\2\2\u0176\u0177\t\4\2\2\u0177q\3\2\2\2\u0178\u017a"+
		"\4\62;\2\u0179\u0178\3\2\2\2\u017a\u017b\3\2\2\2\u017b\u0179\3\2\2\2\u017b"+
		"\u017c\3\2\2\2\u017c\u017d\3\2\2\2\u017d\u0181\7\60\2\2\u017e\u0180\4"+
		"\62;\2\u017f\u017e\3\2\2\2\u0180\u0183\3\2\2\2\u0181\u017f\3\2\2\2\u0181"+
		"\u0182\3\2\2\2\u0182\u0185\3\2\2\2\u0183\u0181\3\2\2\2\u0184\u0186\5t"+
		":\2\u0185\u0184\3\2\2\2\u0185\u0186\3\2\2\2\u0186\u0188\3\2\2\2\u0187"+
		"\u0189\5v;\2\u0188\u0187\3\2\2\2\u0188\u0189\3\2\2\2\u0189\u01c7\3\2\2"+
		"\2\u018a\u018c\7\60\2\2\u018b\u018d\4\62;\2\u018c\u018b\3\2\2\2\u018d"+
		"\u018e\3\2\2\2\u018e\u018c\3\2\2\2\u018e\u018f\3\2\2\2\u018f\u0191\3\2"+
		"\2\2\u0190\u0192\5t:\2\u0191\u0190\3\2\2\2\u0191\u0192\3\2\2\2\u0192\u0194"+
		"\3\2\2\2\u0193\u0195\5v;\2\u0194\u0193\3\2\2\2\u0194\u0195\3\2\2\2\u0195"+
		"\u01c7\3\2\2\2\u0196\u0198\4\62;\2\u0197\u0196\3\2\2\2\u0198\u0199\3\2"+
		"\2\2\u0199\u0197\3\2\2\2\u0199\u019a\3\2\2\2\u019a\u019b\3\2\2\2\u019b"+
		"\u019d\5t:\2\u019c\u019e\5v;\2\u019d\u019c\3\2\2\2\u019d\u019e\3\2\2\2"+
		"\u019e\u01c7\3\2\2\2\u019f\u01a1\4\62;\2\u01a0\u019f\3\2\2\2\u01a1\u01a2"+
		"\3\2\2\2\u01a2\u01a0\3\2\2\2\u01a2\u01a3\3\2\2\2\u01a3\u01a4\3\2\2\2\u01a4"+
		"\u01c7\5v;\2\u01a5\u01a6\7\62\2\2\u01a6\u01aa\7z\2\2\u01a7\u01a8\7\62"+
		"\2\2\u01a8\u01aa\7Z\2\2\u01a9\u01a5\3\2\2\2\u01a9\u01a7\3\2\2\2\u01aa"+
		"\u01ae\3\2\2\2\u01ab\u01ad\5n\67\2\u01ac\u01ab\3\2\2\2\u01ad\u01b0\3\2"+
		"\2\2\u01ae\u01ac\3\2\2\2\u01ae\u01af\3\2\2\2\u01af\u01b8\3\2\2\2\u01b0"+
		"\u01ae\3\2\2\2\u01b1\u01b5\7\60\2\2\u01b2\u01b4\5n\67\2\u01b3\u01b2\3"+
		"\2\2\2\u01b4\u01b7\3\2\2\2\u01b5\u01b3\3\2\2\2\u01b5\u01b6\3\2\2\2\u01b6"+
		"\u01b9\3\2\2\2\u01b7\u01b5\3\2\2\2\u01b8\u01b1\3\2\2\2\u01b8\u01b9\3\2"+
		"\2\2\u01b9\u01ba\3\2\2\2\u01ba\u01bc\t\5\2\2\u01bb\u01bd\t\6\2\2\u01bc"+
		"\u01bb\3\2\2\2\u01bc\u01bd\3\2\2\2\u01bd\u01bf\3\2\2\2\u01be\u01c0\4\62"+
		";\2\u01bf\u01be\3\2\2\2\u01c0\u01c1\3\2\2\2\u01c1\u01bf\3\2\2\2\u01c1"+
		"\u01c2\3\2\2\2\u01c2\u01c4\3\2\2\2\u01c3\u01c5\5v;\2\u01c4\u01c3\3\2\2"+
		"\2\u01c4\u01c5\3\2\2\2\u01c5\u01c7\3\2\2\2\u01c6\u0179\3\2\2\2\u01c6\u018a"+
		"\3\2\2\2\u01c6\u0197\3\2\2\2\u01c6\u01a0\3\2\2\2\u01c6\u01a9\3\2\2\2\u01c7"+
		"s\3\2\2\2\u01c8\u01ca\t\7\2\2\u01c9\u01cb\t\6\2\2\u01ca\u01c9\3\2\2\2"+
		"\u01ca\u01cb\3\2\2\2\u01cb\u01cd\3\2\2\2\u01cc\u01ce\4\62;\2\u01cd\u01cc"+
		"\3\2\2\2\u01ce\u01cf\3\2\2\2\u01cf\u01cd\3\2\2\2\u01cf\u01d0\3\2\2\2\u01d0"+
		"u\3\2\2\2\u01d1\u01d2\t\b\2\2\u01d2w\3\2\2\2\u01d3\u01d6\7)\2\2\u01d4"+
		"\u01d7\5|>\2\u01d5\u01d7\n\t\2\2\u01d6\u01d4\3\2\2\2\u01d6\u01d5\3\2\2"+
		"\2\u01d7\u01d8\3\2\2\2\u01d8\u01d9\7)\2\2\u01d9y\3\2\2\2\u01da\u01df\7"+
		"$\2\2\u01db\u01de\5|>\2\u01dc\u01de\n\n\2\2\u01dd\u01db\3\2\2\2\u01dd"+
		"\u01dc\3\2\2\2\u01de\u01e1\3\2\2\2\u01df\u01dd\3\2\2\2\u01df\u01e0\3\2"+
		"\2\2\u01e0\u01e2\3\2\2\2\u01e1\u01df\3\2\2\2\u01e2\u01e3\7$\2\2\u01e3"+
		"{\3\2\2\2\u01e4\u01e5\7^\2\2\u01e5\u01e9\t\13\2\2\u01e6\u01e9\5\u0080"+
		"@\2\u01e7\u01e9\5~?\2\u01e8\u01e4\3\2\2\2\u01e8\u01e6\3\2\2\2\u01e8\u01e7"+
		"\3\2\2\2\u01e9}\3\2\2\2\u01ea\u01eb\7^\2\2\u01eb\u01ec\4\62\65\2\u01ec"+
		"\u01ed\4\629\2\u01ed\u01f4\4\629\2\u01ee\u01ef\7^\2\2\u01ef\u01f0\4\62"+
		"9\2\u01f0\u01f4\4\629\2\u01f1\u01f2\7^\2\2\u01f2\u01f4\4\629\2\u01f3\u01ea"+
		"\3\2\2\2\u01f3\u01ee\3\2\2\2\u01f3\u01f1\3\2\2\2\u01f4\177\3\2\2\2\u01f5"+
		"\u01f6\7^\2\2\u01f6\u01f7\7w\2\2\u01f7\u01f8\5n\67\2\u01f8\u01f9\5n\67"+
		"\2\u01f9\u01fa\5n\67\2\u01fa\u01fb\5n\67\2\u01fb\u0081\3\2\2\2\u01fc\u0201"+
		"\5\u0084B\2\u01fd\u0200\5\u0084B\2\u01fe\u0200\5\u0086C\2\u01ff\u01fd"+
		"\3\2\2\2\u01ff\u01fe\3\2\2\2\u0200\u0203\3\2\2\2\u0201\u01ff\3\2\2\2\u0201"+
		"\u0202\3\2\2\2\u0202\u0083\3\2\2\2\u0203\u0201\3\2\2\2\u0204\u0205\t\f"+
		"\2\2\u0205\u0085\3\2\2\2\u0206\u0207\t\r\2\2\u0207\u0087\3\2\2\2\u0208"+
		"\u0209\7\61\2\2\u0209\u020a\7,\2\2\u020a\u020b\3\2\2\2\u020b\u020c\bD"+
		"\2\2\u020c\u0089\3\2\2\2\u020d\u020e\7B\2\2\u020e\u020f\5\u0082A\2\u020f"+
		"\u0210\7<\2\2\u0210\u0215\5\u0082A\2\u0211\u0212\7\60\2\2\u0212\u0214"+
		"\5\u0082A\2\u0213\u0211\3\2\2\2\u0214\u0217\3\2\2\2\u0215\u0213\3\2\2"+
		"\2\u0215\u0216\3\2\2\2\u0216\u008b\3\2\2\2\u0217\u0215\3\2\2\2\u0218\u021a"+
		"\t\16\2\2\u0219\u0218\3\2\2\2\u021a\u021b\3\2\2\2\u021b\u0219\3\2\2\2"+
		"\u021b\u021c\3\2\2\2\u021c\u021d\3\2\2\2\u021d\u021e\bF\3\2\u021e\u008d"+
		"\3\2\2\2\u021f\u0220\7,\2\2\u0220\u0221\7\61\2\2\u0221\u0222\3\2\2\2\u0222"+
		"\u0223\bG\4\2\u0223\u008f\3\2\2\2\u0224\u0226\t\16\2\2\u0225\u0224\3\2"+
		"\2\2\u0226\u0227\3\2\2\2\u0227\u0225\3\2\2\2\u0227\u0228\3\2\2\2\u0228"+
		"\u0229\3\2\2\2\u0229\u022a\bH\5\2\u022a\u0091\3\2\2\2\u022b\u022c\7\61"+
		"\2\2\u022c\u022d\7\61\2\2\u022d\u0231\3\2\2\2\u022e\u0230\n\17\2\2\u022f"+
		"\u022e\3\2\2\2\u0230\u0233\3\2\2\2\u0231\u022f\3\2\2\2\u0231\u0232\3\2"+
		"\2\2\u0232\u0235\3\2\2\2\u0233\u0231\3\2\2\2\u0234\u0236\7\17\2\2\u0235"+
		"\u0234\3\2\2\2\u0235\u0236\3\2\2\2\u0236\u0237\3\2\2\2\u0237\u0238\7\f"+
		"\2\2\u0238\u0239\3\2\2\2\u0239\u023a\bI\6\2\u023a\u0093\3\2\2\2,\2\3\u00e0"+
		"\u0159\u015c\u0163\u0166\u0169\u016f\u0172\u017b\u0181\u0185\u0188\u018e"+
		"\u0191\u0194\u0199\u019d\u01a2\u01a9\u01ae\u01b5\u01b8\u01bc\u01c1\u01c4"+
		"\u01c6\u01ca\u01cf\u01d6\u01dd\u01df\u01e8\u01f3\u01ff\u0201\u0215\u021b"+
		"\u0227\u0231\u0235";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}