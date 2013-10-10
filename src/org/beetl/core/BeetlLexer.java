// Generated from E:\lijz\javamonkey\bee\research\antlrworks2\projects\beetl\Beetl.g4 by ANTLR 4.1

package org.beetl.core;




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
		T__27=1, T__26=2, T__25=3, T__24=4, T__23=5, T__22=6, T__21=7, T__20=8, 
		T__19=9, T__18=10, T__17=11, T__16=12, T__15=13, T__14=14, T__13=15, T__12=16, 
		T__11=17, T__10=18, T__9=19, T__8=20, T__7=21, T__6=22, T__5=23, T__4=24, 
		T__3=25, T__2=26, T__1=27, T__0=28, BOOLEAN=29, VAR=30, INT=31, DOUBLE=32, 
		NULL=33, ADD=34, MINUS=35, MULTIP=36, DIV=37, MOD=38, EQUAL=39, NOT_EQUAL=40, 
		LARGE=41, LARGE_EQUAL=42, LESS=43, LESS_EQUAL=44, OR=45, AND=46, LEFT_TOKEN=47, 
		RIGHT_TOKEN=48, LEFT_TEXT_TOKEN=49, LEFT_BRACE=50, RIGHT_BRACE=51, Comment=52, 
		LineComment=53, StringLiteral=54, NumericLiteral=55, Identifier=56, WhiteSpace=57;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"<INVALID>",
		"']'", "'select'", "'default'", "','", "'while'", "'['", "'elsefor'", 
		"'('", "':'", "'if'", "'continue'", "'?'", "'in '", "'break'", "'!('", 
		"'else'", "'.~'", "'case'", "'.'", "')'", "'for'", "'@'", "'='", "'return'", 
		"';'", "'DIRECTIVE'", "'switch'", "'!'", "BOOLEAN", "'var'", "INT", "DOUBLE", 
		"'null'", "'+'", "'-'", "'*'", "'/'", "'%'", "'=='", "'!='", "'>'", "'>='", 
		"'<'", "'<='", "'||'", "'&&'", "'<<'", "'>>'", "'<$'", "'{'", "'}'", "Comment", 
		"LineComment", "StringLiteral", "NumericLiteral", "Identifier", "WhiteSpace"
	};
	public static final String[] ruleNames = {
		"T__27", "T__26", "T__25", "T__24", "T__23", "T__22", "T__21", "T__20", 
		"T__19", "T__18", "T__17", "T__16", "T__15", "T__14", "T__13", "T__12", 
		"T__11", "T__10", "T__9", "T__8", "T__7", "T__6", "T__5", "T__4", "T__3", 
		"T__2", "T__1", "T__0", "BOOLEAN", "VAR", "INT", "DOUBLE", "NULL", "ID_START", 
		"ADD", "MINUS", "MULTIP", "DIV", "MOD", "EQUAL", "NOT_EQUAL", "LARGE", 
		"LARGE_EQUAL", "LESS", "LESS_EQUAL", "OR", "AND", "LEFT_TOKEN", "RIGHT_TOKEN", 
		"LEFT_TEXT_TOKEN", "LEFT_BRACE", "RIGHT_BRACE", "Comment", "LineComment", 
		"StringLiteral", "ESC", "UNICODE", "HEX", "HexEscapeSequence", "UnicodeEscapeSequence", 
		"NumericLiteral", "HexIntegerLiteral", "HexDigit", "DecimalLiteral", "DecimalDigit", 
		"ExponentPart", "Identifier", "IdentifierStart", "IdentifierPart", "UnicodeLetter", 
		"UnicodeCombiningMark", "UnicodeDigit", "UnicodeConnectorPunctuation", 
		"WhiteSpace"
	};


	boolean isStrictMVC = false;


	public boolean isTextProcessFunction(TokenStream input){
		return true;
	}



	public BeetlLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Beetl.g4"; }

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
		case 52: Comment_action((RuleContext)_localctx, actionIndex); break;

		case 53: LineComment_action((RuleContext)_localctx, actionIndex); break;

		case 73: WhiteSpace_action((RuleContext)_localctx, actionIndex); break;
		}
	}
	private void LineComment_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 1: skip();  break;
		}
	}
	private void WhiteSpace_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 2: skip();  break;
		}
	}
	private void Comment_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 0: _channel = HIDDEN;  break;
		}
	}

	public static final String _serializedATN =
		"\3\uacf5\uee8c\u4f5d\u8b0d\u4a45\u78bd\u1b2f\u3378\2;\u01f6\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t="+
		"\4>\t>\4?\t?\4@\t@\4A\tA\4B\tB\4C\tC\4D\tD\4E\tE\4F\tF\4G\tG\4H\tH\4I"+
		"\tI\4J\tJ\4K\tK\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3"+
		"\4\3\4\3\4\3\4\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\b\3\b\3\b\3\b"+
		"\3\b\3\b\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3"+
		"\f\3\f\3\f\3\f\3\r\3\r\3\16\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3"+
		"\17\3\20\3\20\3\20\3\21\3\21\3\21\3\21\3\21\3\22\3\22\3\22\3\23\3\23\3"+
		"\23\3\23\3\23\3\24\3\24\3\25\3\25\3\26\3\26\3\26\3\26\3\27\3\27\3\30\3"+
		"\30\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\32\3\32\3\33\3\33\3\33\3\33\3"+
		"\33\3\33\3\33\3\33\3\33\3\33\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\35\3"+
		"\35\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\5\36\u0118\n\36\3\37"+
		"\3\37\3\37\3\37\3 \6 \u011f\n \r \16 \u0120\3!\6!\u0124\n!\r!\16!\u0125"+
		"\3!\3!\6!\u012a\n!\r!\16!\u012b\3\"\3\"\3\"\3\"\3\"\3#\6#\u0134\n#\r#"+
		"\16#\u0135\3$\3$\3%\3%\3&\3&\3\'\3\'\3(\3(\3)\3)\3)\3*\3*\3*\3+\3+\3,"+
		"\3,\3,\3-\3-\3.\3.\3.\3/\3/\3/\3\60\3\60\3\60\3\61\3\61\3\61\3\62\3\62"+
		"\3\62\3\63\3\63\3\63\3\64\3\64\3\65\3\65\3\66\3\66\3\66\3\66\7\66\u0169"+
		"\n\66\f\66\16\66\u016c\13\66\3\66\3\66\3\66\3\66\3\66\3\67\3\67\3\67\3"+
		"\67\7\67\u0177\n\67\f\67\16\67\u017a\13\67\3\67\3\67\38\38\38\78\u0181"+
		"\n8\f8\168\u0184\138\38\38\39\39\39\59\u018b\n9\3:\3:\3:\3:\3:\3:\3;\3"+
		";\3<\3<\3<\3<\3=\3=\3=\3=\3=\3=\3>\3>\5>\u01a1\n>\3?\3?\3?\6?\u01a6\n"+
		"?\r?\16?\u01a7\3@\3@\5@\u01ac\n@\3A\6A\u01af\nA\rA\16A\u01b0\3A\3A\7A"+
		"\u01b5\nA\fA\16A\u01b8\13A\3A\5A\u01bb\nA\3A\5A\u01be\nA\3A\6A\u01c1\n"+
		"A\rA\16A\u01c2\3A\5A\u01c6\nA\5A\u01c8\nA\3B\3B\3C\3C\5C\u01ce\nC\3C\6"+
		"C\u01d1\nC\rC\16C\u01d2\3D\3D\7D\u01d7\nD\fD\16D\u01da\13D\3E\3E\3E\3"+
		"E\5E\u01e0\nE\3F\3F\3F\5F\u01e5\nF\3G\3G\3H\3H\3I\3I\3J\3J\3K\3K\3K\3"+
		"K\5K\u01f3\nK\3K\3K\3\u016aL\3\3\1\5\4\1\7\5\1\t\6\1\13\7\1\r\b\1\17\t"+
		"\1\21\n\1\23\13\1\25\f\1\27\r\1\31\16\1\33\17\1\35\20\1\37\21\1!\22\1"+
		"#\23\1%\24\1\'\25\1)\26\1+\27\1-\30\1/\31\1\61\32\1\63\33\1\65\34\1\67"+
		"\35\19\36\1;\37\1= \1?!\1A\"\1C#\1E\2\1G$\1I%\1K&\1M\'\1O(\1Q)\1S*\1U"+
		"+\1W,\1Y-\1[.\1]/\1_\60\1a\61\1c\62\1e\63\1g\64\1i\65\1k\66\2m\67\3o8"+
		"\1q\2\1s\2\1u\2\1w\2\1y\2\1{9\1}\2\1\177\2\1\u0081\2\1\u0083\2\1\u0085"+
		"\2\1\u0087:\1\u0089\2\1\u008b\2\1\u008d\2\1\u008f\2\1\u0091\2\1\u0093"+
		"\2\1\u0095;\4\3\2\21\4\2C\\c|\5\2\f\f\17\17\u202a\u202b\4\2$$^^\n\2$$"+
		"\61\61^^ddhhppttvv\5\2\62;CHch\4\2ZZzz\4\2CHch\4\2GGgg\4\2--//\4\2&&a"+
		"a\u0104\2C\\c|\u00ac\u00ac\u00b7\u00b7\u00bc\u00bc\u00c2\u00d8\u00da\u00f8"+
		"\u00fa\u0221\u0224\u0235\u0252\u02af\u02b2\u02ba\u02bd\u02c3\u02d2\u02d3"+
		"\u02e2\u02e6\u02f0\u02f0\u037c\u037c\u0388\u0388\u038a\u038c\u038e\u038e"+
		"\u0390\u03a3\u03a5\u03d0\u03d2\u03d9\u03dc\u03f5\u0402\u0483\u048e\u04c6"+
		"\u04c9\u04ca\u04cd\u04ce\u04d2\u04f7\u04fa\u04fb\u0533\u0558\u055b\u055b"+
		"\u0563\u0589\u05d2\u05ec\u05f2\u05f4\u0623\u063c\u0642\u064c\u0673\u06d5"+
		"\u06d7\u06d7\u06e7\u06e8\u06fc\u06fe\u0712\u0712\u0714\u072e\u0782\u07a7"+
		"\u0907\u093b\u093f\u093f\u0952\u0952\u095a\u0963\u0987\u098e\u0991\u0992"+
		"\u0995\u09aa\u09ac\u09b2\u09b4\u09b4\u09b8\u09bb\u09de\u09df\u09e1\u09e3"+
		"\u09f2\u09f3\u0a07\u0a0c\u0a11\u0a12\u0a15\u0a2a\u0a2c\u0a32\u0a34\u0a35"+
		"\u0a37\u0a38\u0a3a\u0a3b\u0a5b\u0a5e\u0a60\u0a60\u0a74\u0a76\u0a87\u0a8d"+
		"\u0a8f\u0a8f\u0a91\u0a93\u0a95\u0aaa\u0aac\u0ab2\u0ab4\u0ab5\u0ab7\u0abb"+
		"\u0abf\u0abf\u0ad2\u0ad2\u0ae2\u0ae2\u0b07\u0b0e\u0b11\u0b12\u0b15\u0b2a"+
		"\u0b2c\u0b32\u0b34\u0b35\u0b38\u0b3b\u0b3f\u0b3f\u0b5e\u0b5f\u0b61\u0b63"+
		"\u0b87\u0b8c\u0b90\u0b92\u0b94\u0b97\u0b9b\u0b9c\u0b9e\u0b9e\u0ba0\u0ba1"+
		"\u0ba5\u0ba6\u0baa\u0bac\u0bb0\u0bb7\u0bb9\u0bbb\u0c07\u0c0e\u0c10\u0c12"+
		"\u0c14\u0c2a\u0c2c\u0c35\u0c37\u0c3b\u0c62\u0c63\u0c87\u0c8e\u0c90\u0c92"+
		"\u0c94\u0caa\u0cac\u0cb5\u0cb7\u0cbb\u0ce0\u0ce0\u0ce2\u0ce3\u0d07\u0d0e"+
		"\u0d10\u0d12\u0d14\u0d2a\u0d2c\u0d3b\u0d62\u0d63\u0d87\u0d98\u0d9c\u0db3"+
		"\u0db5\u0dbd\u0dbf\u0dbf\u0dc2\u0dc8\u0e03\u0e32\u0e34\u0e35\u0e42\u0e48"+
		"\u0e83\u0e84\u0e86\u0e86\u0e89\u0e8a\u0e8c\u0e8c\u0e8f\u0e8f\u0e96\u0e99"+
		"\u0e9b\u0ea1\u0ea3\u0ea5\u0ea7\u0ea7\u0ea9\u0ea9\u0eac\u0ead\u0eaf\u0eb2"+
		"\u0eb4\u0eb5\u0ebf\u0ec6\u0ec8\u0ec8\u0ede\u0edf\u0f02\u0f02\u0f42\u0f6c"+
		"\u0f8a\u0f8d\u1002\u1023\u1025\u1029\u102b\u102c\u1052\u1057\u10a2\u10c7"+
		"\u10d2\u10f8\u1102\u115b\u1161\u11a4\u11aa\u11fb\u1202\u1208\u120a\u1248"+
		"\u124a\u124a\u124c\u124f\u1252\u1258\u125a\u125a\u125c\u125f\u1262\u1288"+
		"\u128a\u128a\u128c\u128f\u1292\u12b0\u12b2\u12b2\u12b4\u12b7\u12ba\u12c0"+
		"\u12c2\u12c2\u12c4\u12c7\u12ca\u12d0\u12d2\u12d8\u12da\u12f0\u12f2\u1310"+
		"\u1312\u1312\u1314\u1317\u131a\u1320\u1322\u1348\u134a\u135c\u13a2\u13f6"+
		"\u1403\u1678\u1683\u169c\u16a2\u16ec\u1782\u17b5\u1822\u1879\u1882\u18aa"+
		"\u1e02\u1e9d\u1ea2\u1efb\u1f02\u1f17\u1f1a\u1f1f\u1f22\u1f47\u1f4a\u1f4f"+
		"\u1f52\u1f59\u1f5b\u1f5b\u1f5d\u1f5d\u1f5f\u1f5f\u1f61\u1f7f\u1f82\u1fb6"+
		"\u1fb8\u1fbe\u1fc0\u1fc0\u1fc4\u1fc6\u1fc8\u1fce\u1fd2\u1fd5\u1fd8\u1fdd"+
		"\u1fe2\u1fee\u1ff4\u1ff6\u1ff8\u1ffe\u2081\u2081\u2104\u2104\u2109\u2109"+
		"\u210c\u2115\u2117\u2117\u211b\u211f\u2126\u2126\u2128\u2128\u212a\u212a"+
		"\u212c\u212f\u2131\u2133\u2135\u213b\u2162\u2185\u3007\u3009\u3023\u302b"+
		"\u3033\u3037\u303a\u303c\u3043\u3096\u309f\u30a0\u30a3\u30fc\u30fe\u3100"+
		"\u3107\u312e\u3133\u3190\u31a2\u31b9\u3402\u3402\u4db7\u4db7\u4e02\u4e02"+
		"\u9fa7\u9fa7\ua002\ua48e\uac02\uac02\ud7a5\ud7a5\uf902\ufa2f\ufb02\ufb08"+
		"\ufb15\ufb19\ufb1f\ufb1f\ufb21\ufb2a\ufb2c\ufb38\ufb3a\ufb3e\ufb40\ufb40"+
		"\ufb42\ufb43\ufb45\ufb46\ufb48\ufbb3\ufbd5\ufd3f\ufd52\ufd91\ufd94\ufdc9"+
		"\ufdf2\ufdfd\ufe72\ufe74\ufe76\ufe76\ufe78\ufefe\uff23\uff3c\uff43\uff5c"+
		"\uff68\uffc0\uffc4\uffc9\uffcc\uffd1\uffd4\uffd9\uffdc\uffdef\2\u0302"+
		"\u0350\u0362\u0364\u0485\u0488\u0593\u05a3\u05a5\u05bb\u05bd\u05bf\u05c1"+
		"\u05c1\u05c3\u05c4\u05c6\u05c6\u064d\u0657\u0672\u0672\u06d8\u06de\u06e1"+
		"\u06e6\u06e9\u06ea\u06ec\u06ef\u0713\u0713\u0732\u074c\u07a8\u07b2\u0903"+
		"\u0905\u093e\u093e\u0940\u094f\u0953\u0956\u0964\u0965\u0983\u0985\u09be"+
		"\u09c6\u09c9\u09ca\u09cd\u09cf\u09d9\u09d9\u09e4\u09e5\u0a04\u0a04\u0a3e"+
		"\u0a3e\u0a40\u0a44\u0a49\u0a4a\u0a4d\u0a4f\u0a72\u0a73\u0a83\u0a85\u0abe"+
		"\u0abe\u0ac0\u0ac7\u0ac9\u0acb\u0acd\u0acf\u0b03\u0b05\u0b3e\u0b3e\u0b40"+
		"\u0b45\u0b49\u0b4a\u0b4d\u0b4f\u0b58\u0b59\u0b84\u0b85\u0bc0\u0bc4\u0bc8"+
		"\u0bca\u0bcc\u0bcf\u0bd9\u0bd9\u0c03\u0c05\u0c40\u0c46\u0c48\u0c4a\u0c4c"+
		"\u0c4f\u0c57\u0c58\u0c84\u0c85\u0cc0\u0cc6\u0cc8\u0cca\u0ccc\u0ccf\u0cd7"+
		"\u0cd8\u0d04\u0d05\u0d40\u0d45\u0d48\u0d4a\u0d4c\u0d4f\u0d59\u0d59\u0d84"+
		"\u0d85\u0dcc\u0dcc\u0dd1\u0dd6\u0dd8\u0dd8\u0dda\u0de1\u0df4\u0df5\u0e33"+
		"\u0e33\u0e36\u0e3c\u0e49\u0e50\u0eb3\u0eb3\u0eb6\u0ebb\u0ebd\u0ebe\u0eca"+
		"\u0ecf\u0f1a\u0f1b\u0f37\u0f37\u0f39\u0f39\u0f3b\u0f3b\u0f40\u0f41\u0f73"+
		"\u0f86\u0f88\u0f89\u0f92\u0f99\u0f9b\u0fbe\u0fc8\u0fc8\u102e\u1034\u1038"+
		"\u103b\u1058\u105b\u17b6\u17d5\u18ab\u18ab\u20d2\u20de\u20e3\u20e3\u302c"+
		"\u3031\u309b\u309c\ufb20\ufb20\ufe22\ufe25\26\2\62;\u0662\u066b\u06f2"+
		"\u06fb\u0968\u0971\u09e8\u09f1\u0a68\u0a71\u0ae8\u0af1\u0b68\u0b71\u0be9"+
		"\u0bf1\u0c68\u0c71\u0ce8\u0cf1\u0d68\u0d71\u0e52\u0e5b\u0ed2\u0edb\u0f22"+
		"\u0f2b\u1042\u104b\u136b\u1373\u17e2\u17eb\u1812\u181b\uff12\uff1b\t\2"+
		"aa\u2041\u2042\u30fd\u30fd\ufe35\ufe36\ufe4f\ufe51\uff41\uff41\uff67\uff67"+
		"\6\2\f\f\16\17\"\"\u00a2\u00a2\u0201\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2"+
		"\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23"+
		"\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2"+
		"\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2"+
		"\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3"+
		"\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2"+
		"\2\2\2C\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2"+
		"\2Q\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2\2W\3\2\2\2\2Y\3\2\2\2\2[\3\2\2\2\2]"+
		"\3\2\2\2\2_\3\2\2\2\2a\3\2\2\2\2c\3\2\2\2\2e\3\2\2\2\2g\3\2\2\2\2i\3\2"+
		"\2\2\2k\3\2\2\2\2m\3\2\2\2\2o\3\2\2\2\2{\3\2\2\2\2\u0087\3\2\2\2\2\u0095"+
		"\3\2\2\2\3\u0097\3\2\2\2\5\u0099\3\2\2\2\7\u00a0\3\2\2\2\t\u00a8\3\2\2"+
		"\2\13\u00aa\3\2\2\2\r\u00b0\3\2\2\2\17\u00b2\3\2\2\2\21\u00ba\3\2\2\2"+
		"\23\u00bc\3\2\2\2\25\u00be\3\2\2\2\27\u00c1\3\2\2\2\31\u00ca\3\2\2\2\33"+
		"\u00cc\3\2\2\2\35\u00d0\3\2\2\2\37\u00d6\3\2\2\2!\u00d9\3\2\2\2#\u00de"+
		"\3\2\2\2%\u00e1\3\2\2\2\'\u00e6\3\2\2\2)\u00e8\3\2\2\2+\u00ea\3\2\2\2"+
		"-\u00ee\3\2\2\2/\u00f0\3\2\2\2\61\u00f2\3\2\2\2\63\u00f9\3\2\2\2\65\u00fb"+
		"\3\2\2\2\67\u0105\3\2\2\29\u010c\3\2\2\2;\u0117\3\2\2\2=\u0119\3\2\2\2"+
		"?\u011e\3\2\2\2A\u0123\3\2\2\2C\u012d\3\2\2\2E\u0133\3\2\2\2G\u0137\3"+
		"\2\2\2I\u0139\3\2\2\2K\u013b\3\2\2\2M\u013d\3\2\2\2O\u013f\3\2\2\2Q\u0141"+
		"\3\2\2\2S\u0144\3\2\2\2U\u0147\3\2\2\2W\u0149\3\2\2\2Y\u014c\3\2\2\2["+
		"\u014e\3\2\2\2]\u0151\3\2\2\2_\u0154\3\2\2\2a\u0157\3\2\2\2c\u015a\3\2"+
		"\2\2e\u015d\3\2\2\2g\u0160\3\2\2\2i\u0162\3\2\2\2k\u0164\3\2\2\2m\u0172"+
		"\3\2\2\2o\u017d\3\2\2\2q\u0187\3\2\2\2s\u018c\3\2\2\2u\u0192\3\2\2\2w"+
		"\u0194\3\2\2\2y\u0198\3\2\2\2{\u01a0\3\2\2\2}\u01a2\3\2\2\2\177\u01ab"+
		"\3\2\2\2\u0081\u01c7\3\2\2\2\u0083\u01c9\3\2\2\2\u0085\u01cb\3\2\2\2\u0087"+
		"\u01d4\3\2\2\2\u0089\u01df\3\2\2\2\u008b\u01e4\3\2\2\2\u008d\u01e6\3\2"+
		"\2\2\u008f\u01e8\3\2\2\2\u0091\u01ea\3\2\2\2\u0093\u01ec\3\2\2\2\u0095"+
		"\u01f2\3\2\2\2\u0097\u0098\7_\2\2\u0098\4\3\2\2\2\u0099\u009a\7u\2\2\u009a"+
		"\u009b\7g\2\2\u009b\u009c\7n\2\2\u009c\u009d\7g\2\2\u009d\u009e\7e\2\2"+
		"\u009e\u009f\7v\2\2\u009f\6\3\2\2\2\u00a0\u00a1\7f\2\2\u00a1\u00a2\7g"+
		"\2\2\u00a2\u00a3\7h\2\2\u00a3\u00a4\7c\2\2\u00a4\u00a5\7w\2\2\u00a5\u00a6"+
		"\7n\2\2\u00a6\u00a7\7v\2\2\u00a7\b\3\2\2\2\u00a8\u00a9\7.\2\2\u00a9\n"+
		"\3\2\2\2\u00aa\u00ab\7y\2\2\u00ab\u00ac\7j\2\2\u00ac\u00ad\7k\2\2\u00ad"+
		"\u00ae\7n\2\2\u00ae\u00af\7g\2\2\u00af\f\3\2\2\2\u00b0\u00b1\7]\2\2\u00b1"+
		"\16\3\2\2\2\u00b2\u00b3\7g\2\2\u00b3\u00b4\7n\2\2\u00b4\u00b5\7u\2\2\u00b5"+
		"\u00b6\7g\2\2\u00b6\u00b7\7h\2\2\u00b7\u00b8\7q\2\2\u00b8\u00b9\7t\2\2"+
		"\u00b9\20\3\2\2\2\u00ba\u00bb\7*\2\2\u00bb\22\3\2\2\2\u00bc\u00bd\7<\2"+
		"\2\u00bd\24\3\2\2\2\u00be\u00bf\7k\2\2\u00bf\u00c0\7h\2\2\u00c0\26\3\2"+
		"\2\2\u00c1\u00c2\7e\2\2\u00c2\u00c3\7q\2\2\u00c3\u00c4\7p\2\2\u00c4\u00c5"+
		"\7v\2\2\u00c5\u00c6\7k\2\2\u00c6\u00c7\7p\2\2\u00c7\u00c8\7w\2\2\u00c8"+
		"\u00c9\7g\2\2\u00c9\30\3\2\2\2\u00ca\u00cb\7A\2\2\u00cb\32\3\2\2\2\u00cc"+
		"\u00cd\7k\2\2\u00cd\u00ce\7p\2\2\u00ce\u00cf\7\"\2\2\u00cf\34\3\2\2\2"+
		"\u00d0\u00d1\7d\2\2\u00d1\u00d2\7t\2\2\u00d2\u00d3\7g\2\2\u00d3\u00d4"+
		"\7c\2\2\u00d4\u00d5\7m\2\2\u00d5\36\3\2\2\2\u00d6\u00d7\7#\2\2\u00d7\u00d8"+
		"\7*\2\2\u00d8 \3\2\2\2\u00d9\u00da\7g\2\2\u00da\u00db\7n\2\2\u00db\u00dc"+
		"\7u\2\2\u00dc\u00dd\7g\2\2\u00dd\"\3\2\2\2\u00de\u00df\7\60\2\2\u00df"+
		"\u00e0\7\u0080\2\2\u00e0$\3\2\2\2\u00e1\u00e2\7e\2\2\u00e2\u00e3\7c\2"+
		"\2\u00e3\u00e4\7u\2\2\u00e4\u00e5\7g\2\2\u00e5&\3\2\2\2\u00e6\u00e7\7"+
		"\60\2\2\u00e7(\3\2\2\2\u00e8\u00e9\7+\2\2\u00e9*\3\2\2\2\u00ea\u00eb\7"+
		"h\2\2\u00eb\u00ec\7q\2\2\u00ec\u00ed\7t\2\2\u00ed,\3\2\2\2\u00ee\u00ef"+
		"\7B\2\2\u00ef.\3\2\2\2\u00f0\u00f1\7?\2\2\u00f1\60\3\2\2\2\u00f2\u00f3"+
		"\7t\2\2\u00f3\u00f4\7g\2\2\u00f4\u00f5\7v\2\2\u00f5\u00f6\7w\2\2\u00f6"+
		"\u00f7\7t\2\2\u00f7\u00f8\7p\2\2\u00f8\62\3\2\2\2\u00f9\u00fa\7=\2\2\u00fa"+
		"\64\3\2\2\2\u00fb\u00fc\7F\2\2\u00fc\u00fd\7K\2\2\u00fd\u00fe\7T\2\2\u00fe"+
		"\u00ff\7G\2\2\u00ff\u0100\7E\2\2\u0100\u0101\7V\2\2\u0101\u0102\7K\2\2"+
		"\u0102\u0103\7X\2\2\u0103\u0104\7G\2\2\u0104\66\3\2\2\2\u0105\u0106\7"+
		"u\2\2\u0106\u0107\7y\2\2\u0107\u0108\7k\2\2\u0108\u0109\7v\2\2\u0109\u010a"+
		"\7e\2\2\u010a\u010b\7j\2\2\u010b8\3\2\2\2\u010c\u010d\7#\2\2\u010d:\3"+
		"\2\2\2\u010e\u010f\7v\2\2\u010f\u0110\7t\2\2\u0110\u0111\7w\2\2\u0111"+
		"\u0118\7g\2\2\u0112\u0113\7h\2\2\u0113\u0114\7c\2\2\u0114\u0115\7n\2\2"+
		"\u0115\u0116\7u\2\2\u0116\u0118\7g\2\2\u0117\u010e\3\2\2\2\u0117\u0112"+
		"\3\2\2\2\u0118<\3\2\2\2\u0119\u011a\7x\2\2\u011a\u011b\7c\2\2\u011b\u011c"+
		"\7t\2\2\u011c>\3\2\2\2\u011d\u011f\4\62;\2\u011e\u011d\3\2\2\2\u011f\u0120"+
		"\3\2\2\2\u0120\u011e\3\2\2\2\u0120\u0121\3\2\2\2\u0121@\3\2\2\2\u0122"+
		"\u0124\4\62;\2\u0123\u0122\3\2\2\2\u0124\u0125\3\2\2\2\u0125\u0123\3\2"+
		"\2\2\u0125\u0126\3\2\2\2\u0126\u0127\3\2\2\2\u0127\u0129\7\60\2\2\u0128"+
		"\u012a\4\62;\2\u0129\u0128\3\2\2\2\u012a\u012b\3\2\2\2\u012b\u0129\3\2"+
		"\2\2\u012b\u012c\3\2\2\2\u012cB\3\2\2\2\u012d\u012e\7p\2\2\u012e\u012f"+
		"\7w\2\2\u012f\u0130\7n\2\2\u0130\u0131\7n\2\2\u0131D\3\2\2\2\u0132\u0134"+
		"\t\2\2\2\u0133\u0132\3\2\2\2\u0134\u0135\3\2\2\2\u0135\u0133\3\2\2\2\u0135"+
		"\u0136\3\2\2\2\u0136F\3\2\2\2\u0137\u0138\7-\2\2\u0138H\3\2\2\2\u0139"+
		"\u013a\7/\2\2\u013aJ\3\2\2\2\u013b\u013c\7,\2\2\u013cL\3\2\2\2\u013d\u013e"+
		"\7\61\2\2\u013eN\3\2\2\2\u013f\u0140\7\'\2\2\u0140P\3\2\2\2\u0141\u0142"+
		"\7?\2\2\u0142\u0143\7?\2\2\u0143R\3\2\2\2\u0144\u0145\7#\2\2\u0145\u0146"+
		"\7?\2\2\u0146T\3\2\2\2\u0147\u0148\7@\2\2\u0148V\3\2\2\2\u0149\u014a\7"+
		"@\2\2\u014a\u014b\7?\2\2\u014bX\3\2\2\2\u014c\u014d\7>\2\2\u014dZ\3\2"+
		"\2\2\u014e\u014f\7>\2\2\u014f\u0150\7?\2\2\u0150\\\3\2\2\2\u0151\u0152"+
		"\7~\2\2\u0152\u0153\7~\2\2\u0153^\3\2\2\2\u0154\u0155\7(\2\2\u0155\u0156"+
		"\7(\2\2\u0156`\3\2\2\2\u0157\u0158\7>\2\2\u0158\u0159\7>\2\2\u0159b\3"+
		"\2\2\2\u015a\u015b\7@\2\2\u015b\u015c\7@\2\2\u015cd\3\2\2\2\u015d\u015e"+
		"\7>\2\2\u015e\u015f\7&\2\2\u015ff\3\2\2\2\u0160\u0161\7}\2\2\u0161h\3"+
		"\2\2\2\u0162\u0163\7\177\2\2\u0163j\3\2\2\2\u0164\u0165\7\61\2\2\u0165"+
		"\u0166\7,\2\2\u0166\u016a\3\2\2\2\u0167\u0169\13\2\2\2\u0168\u0167\3\2"+
		"\2\2\u0169\u016c\3\2\2\2\u016a\u016b\3\2\2\2\u016a\u0168\3\2\2\2\u016b"+
		"\u016d\3\2\2\2\u016c\u016a\3\2\2\2\u016d\u016e\7,\2\2\u016e\u016f\7\61"+
		"\2\2\u016f\u0170\3\2\2\2\u0170\u0171\b\66\2\2\u0171l\3\2\2\2\u0172\u0173"+
		"\7\61\2\2\u0173\u0174\7\61\2\2\u0174\u0178\3\2\2\2\u0175\u0177\n\3\2\2"+
		"\u0176\u0175\3\2\2\2\u0177\u017a\3\2\2\2\u0178\u0176\3\2\2\2\u0178\u0179"+
		"\3\2\2\2\u0179\u017b\3\2\2\2\u017a\u0178\3\2\2\2\u017b\u017c\b\67\3\2"+
		"\u017cn\3\2\2\2\u017d\u0182\7$\2\2\u017e\u0181\5q9\2\u017f\u0181\n\4\2"+
		"\2\u0180\u017e\3\2\2\2\u0180\u017f\3\2\2\2\u0181\u0184\3\2\2\2\u0182\u0180"+
		"\3\2\2\2\u0182\u0183\3\2\2\2\u0183\u0185\3\2\2\2\u0184\u0182\3\2\2\2\u0185"+
		"\u0186\7$\2\2\u0186p\3\2\2\2\u0187\u018a\7^\2\2\u0188\u018b\t\5\2\2\u0189"+
		"\u018b\5s:\2\u018a\u0188\3\2\2\2\u018a\u0189\3\2\2\2\u018br\3\2\2\2\u018c"+
		"\u018d\7w\2\2\u018d\u018e\5u;\2\u018e\u018f\5u;\2\u018f\u0190\5u;\2\u0190"+
		"\u0191\5u;\2\u0191t\3\2\2\2\u0192\u0193\t\6\2\2\u0193v\3\2\2\2\u0194\u0195"+
		"\7z\2\2\u0195\u0196\5\177@\2\u0196\u0197\5\177@\2\u0197x\3\2\2\2\u0198"+
		"\u0199\7w\2\2\u0199\u019a\5\177@\2\u019a\u019b\5\177@\2\u019b\u019c\5"+
		"\177@\2\u019c\u019d\5\177@\2\u019dz\3\2\2\2\u019e\u01a1\5\u0081A\2\u019f"+
		"\u01a1\5}?\2\u01a0\u019e\3\2\2\2\u01a0\u019f\3\2\2\2\u01a1|\3\2\2\2\u01a2"+
		"\u01a3\7\62\2\2\u01a3\u01a5\t\7\2\2\u01a4\u01a6\5\177@\2\u01a5\u01a4\3"+
		"\2\2\2\u01a6\u01a7\3\2\2\2\u01a7\u01a5\3\2\2\2\u01a7\u01a8\3\2\2\2\u01a8"+
		"~\3\2\2\2\u01a9\u01ac\5\u0083B\2\u01aa\u01ac\t\b\2\2\u01ab\u01a9\3\2\2"+
		"\2\u01ab\u01aa\3\2\2\2\u01ac\u0080\3\2\2\2\u01ad\u01af\5\u0083B\2\u01ae"+
		"\u01ad\3\2\2\2\u01af\u01b0\3\2\2\2\u01b0\u01ae\3\2\2\2\u01b0\u01b1\3\2"+
		"\2\2\u01b1\u01b2\3\2\2\2\u01b2\u01b6\7\60\2\2\u01b3\u01b5\5\u0083B\2\u01b4"+
		"\u01b3\3\2\2\2\u01b5\u01b8\3\2\2\2\u01b6\u01b4\3\2\2\2\u01b6\u01b7\3\2"+
		"\2\2\u01b7\u01ba\3\2\2\2\u01b8\u01b6\3\2\2\2\u01b9\u01bb\5\u0085C\2\u01ba"+
		"\u01b9\3\2\2\2\u01ba\u01bb\3\2\2\2\u01bb\u01c8\3\2\2\2\u01bc\u01be\7\60"+
		"\2\2\u01bd\u01bc\3\2\2\2\u01bd\u01be\3\2\2\2\u01be\u01c0\3\2\2\2\u01bf"+
		"\u01c1\5\u0083B\2\u01c0\u01bf\3\2\2\2\u01c1\u01c2\3\2\2\2\u01c2\u01c0"+
		"\3\2\2\2\u01c2\u01c3\3\2\2\2\u01c3\u01c5\3\2\2\2\u01c4\u01c6\5\u0085C"+
		"\2\u01c5\u01c4\3\2\2\2\u01c5\u01c6\3\2\2\2\u01c6\u01c8\3\2\2\2\u01c7\u01ae"+
		"\3\2\2\2\u01c7\u01bd\3\2\2\2\u01c8\u0082\3\2\2\2\u01c9\u01ca\4\62;\2\u01ca"+
		"\u0084\3\2\2\2\u01cb\u01cd\t\t\2\2\u01cc\u01ce\t\n\2\2\u01cd\u01cc\3\2"+
		"\2\2\u01cd\u01ce\3\2\2\2\u01ce\u01d0\3\2\2\2\u01cf\u01d1\5\u0083B\2\u01d0"+
		"\u01cf\3\2\2\2\u01d1\u01d2\3\2\2\2\u01d2\u01d0\3\2\2\2\u01d2\u01d3\3\2"+
		"\2\2\u01d3\u0086\3\2\2\2\u01d4\u01d8\5\u0089E\2\u01d5\u01d7\5\u008bF\2"+
		"\u01d6\u01d5\3\2\2\2\u01d7\u01da\3\2\2\2\u01d8\u01d6\3\2\2\2\u01d8\u01d9"+
		"\3\2\2\2\u01d9\u0088\3\2\2\2\u01da\u01d8\3\2\2\2\u01db\u01e0\5\u008dG"+
		"\2\u01dc\u01e0\t\13\2\2\u01dd\u01de\7^\2\2\u01de\u01e0\5y=\2\u01df\u01db"+
		"\3\2\2\2\u01df\u01dc\3\2\2\2\u01df\u01dd\3\2\2\2\u01e0\u008a\3\2\2\2\u01e1"+
		"\u01e5\5\u0089E\2\u01e2\u01e5\5\u0091I\2\u01e3\u01e5\5\u0093J\2\u01e4"+
		"\u01e1\3\2\2\2\u01e4\u01e2\3\2\2\2\u01e4\u01e3\3\2\2\2\u01e5\u008c\3\2"+
		"\2\2\u01e6\u01e7\t\f\2\2\u01e7\u008e\3\2\2\2\u01e8\u01e9\t\r\2\2\u01e9"+
		"\u0090\3\2\2\2\u01ea\u01eb\t\16\2\2\u01eb\u0092\3\2\2\2\u01ec\u01ed\t"+
		"\17\2\2\u01ed\u0094\3\2\2\2\u01ee\u01f3\7\13\2\2\u01ef\u01f0\7^\2\2\u01f0"+
		"\u01f3\7x\2\2\u01f1\u01f3\t\20\2\2\u01f2\u01ee\3\2\2\2\u01f2\u01ef\3\2"+
		"\2\2\u01f2\u01f1\3\2\2\2\u01f3\u01f4\3\2\2\2\u01f4\u01f5\bK\4\2\u01f5"+
		"\u0096\3\2\2\2\35\2\u0117\u0120\u0125\u012b\u0135\u016a\u0178\u0180\u0182"+
		"\u018a\u01a0\u01a7\u01ab\u01b0\u01b6\u01ba\u01bd\u01c2\u01c5\u01c7\u01cd"+
		"\u01d2\u01d8\u01df\u01e4\u01f2";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}