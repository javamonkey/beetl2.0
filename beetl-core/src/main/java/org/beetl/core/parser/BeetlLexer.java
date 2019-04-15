// Generated from BeetlLexer.g4 by ANTLR 4.7.2
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
	static { RuntimeMetaData.checkVersion("4.7.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		If=1, For=2, Elsefor=3, Else=4, While=5, Switch=6, Select=7, Return=8, 
		Break=9, Continue=10, Var=11, Directive=12, Case=13, Default=14, Try=15, 
		Catch=16, Ajax=17, Fragment=18, LEFT_BRACE=19, RIGHT_BRACE=20, LEFT_PAR=21, 
		RIGHT_PAR=22, LEFT_SQBR=23, RIGHT_SQBR=24, INCREASE=25, DECREASE=26, VIRTUAL=27, 
		ADD=28, MIN=29, MUlTIP=30, DIV=31, MOD=32, EQUAL=33, NOT_EQUAL=34, ASSIN=35, 
		LARGE_EQUAL=36, LARGE=37, LESS_EQUAL=38, LESS=39, NOT=40, AND=41, OR=42, 
		QUESTOIN=43, AT=44, NULL=45, TRUE=46, FALSE=47, END=48, COMMA=49, COLON=50, 
		PERIOD=51, FOR_IN=52, LEFT_TOKEN=53, LEFT_TOKEN2=54, RIGHT_TOKEN=55, LEFT_TEXT_TOKEN=56, 
		HexLiteral=57, DecimalLiteral=58, OctalLiteral=59, FloatingPointLiteral=60, 
		StringLiteral=61, Identifier=62, WS=63, LINE_COMMENT=64, COMMENT_OPEN=65, 
		COMMENT_TAG=66, COMMENT_END=67, ALL_COMMENT_CHAR=68, Identifier1=69, PERIOD1=70, 
		LEFT_PAR1=71, RIGHT_PAR1=72, COMMA1=73, LEFT_ANGULAR=74, RIGHT_ANGULAR=75, 
		WS1=76, TYPE_END=77;
	public static final int
		MODE_COMMENT=1, MODE_COMMENT_TYPE=2;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE", "MODE_COMMENT", "MODE_COMMENT_TYPE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"If", "For", "Elsefor", "Else", "While", "Switch", "Select", "Return", 
			"Break", "Continue", "Var", "Directive", "Case", "Default", "Try", "Catch", 
			"Ajax", "Fragment", "LEFT_BRACE", "RIGHT_BRACE", "LEFT_PAR", "RIGHT_PAR", 
			"LEFT_SQBR", "RIGHT_SQBR", "INCREASE", "DECREASE", "VIRTUAL", "ADD", 
			"MIN", "MUlTIP", "DIV", "MOD", "EQUAL", "NOT_EQUAL", "ASSIN", "LARGE_EQUAL", 
			"LARGE", "LESS_EQUAL", "LESS", "NOT", "AND", "OR", "QUESTOIN", "AT", 
			"NULL", "TRUE", "FALSE", "END", "COMMA", "COLON", "PERIOD", "FOR_IN", 
			"LEFT_TOKEN", "LEFT_TOKEN2", "RIGHT_TOKEN", "LEFT_TEXT_TOKEN", "HexLiteral", 
			"DecimalLiteral", "OctalLiteral", "HexDigit", "IntegerTypeSuffix", "FloatingPointLiteral", 
			"Exponent", "FloatTypeSuffix", "StringLiteral", "EscapeSequence", "OctalEscape", 
			"UnicodeEscape", "Identifier", "Letter", "JavaIDDigit", "WS", "LINE_COMMENT", 
			"COMMENT_OPEN", "COMMENT_TAG", "COMMENT_END", "COMMENT_END_CHAR", "TYPE_CHAR", 
			"ALL_COMMENT_CHAR", "Identifier1", "PERIOD1", "LEFT_PAR1", "RIGHT_PAR1", 
			"COMMA1", "LEFT_ANGULAR", "RIGHT_ANGULAR", "WS1", "TYPE_END"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'if'", "'for'", "'elsefor'", "'else'", "'while'", "'switch'", 
			"'select'", "'return'", "'break'", "'continue'", "'var'", null, "'case'", 
			"'default'", "'try'", "'catch'", "'#ajax'", "'#fragment'", "'{'", "'}'", 
			null, null, "'['", "']'", "'++'", "'--'", "'.~'", "'+'", "'-'", "'*'", 
			"'/'", "'%'", "'=='", "'!='", "'='", "'>='", null, "'<='", null, "'!'", 
			"'&&'", "'||'", "'?'", "'@'", "'null'", "'true'", "'false'", "';'", null, 
			"':'", null, "'in'", "'<<'", "'<#'", "'>>'", "'<$'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "If", "For", "Elsefor", "Else", "While", "Switch", "Select", "Return", 
			"Break", "Continue", "Var", "Directive", "Case", "Default", "Try", "Catch", 
			"Ajax", "Fragment", "LEFT_BRACE", "RIGHT_BRACE", "LEFT_PAR", "RIGHT_PAR", 
			"LEFT_SQBR", "RIGHT_SQBR", "INCREASE", "DECREASE", "VIRTUAL", "ADD", 
			"MIN", "MUlTIP", "DIV", "MOD", "EQUAL", "NOT_EQUAL", "ASSIN", "LARGE_EQUAL", 
			"LARGE", "LESS_EQUAL", "LESS", "NOT", "AND", "OR", "QUESTOIN", "AT", 
			"NULL", "TRUE", "FALSE", "END", "COMMA", "COLON", "PERIOD", "FOR_IN", 
			"LEFT_TOKEN", "LEFT_TOKEN2", "RIGHT_TOKEN", "LEFT_TEXT_TOKEN", "HexLiteral", 
			"DecimalLiteral", "OctalLiteral", "FloatingPointLiteral", "StringLiteral", 
			"Identifier", "WS", "LINE_COMMENT", "COMMENT_OPEN", "COMMENT_TAG", "COMMENT_END", 
			"ALL_COMMENT_CHAR", "Identifier1", "PERIOD1", "LEFT_PAR1", "RIGHT_PAR1", 
			"COMMA1", "LEFT_ANGULAR", "RIGHT_ANGULAR", "WS1", "TYPE_END"
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


		public void notifyListeners(LexerNoViableAltException e) {
			String text = _input.getText(Interval.of(_tokenStartCharIndex, _input.index()));		
			ANTLRErrorListener listener = getErrorListenerDispatch();
			listener.syntaxError(this, null, _tokenStartLine, _tokenStartCharPositionInLine, text, e);
		}


	public BeetlLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "BeetlLexer.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2O\u02a2\b\1\b\1\b"+
		"\1\4\2\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n"+
		"\t\n\4\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21"+
		"\4\22\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30"+
		"\4\31\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37"+
		"\4 \t \4!\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t"+
		"*\4+\t+\4,\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63"+
		"\4\64\t\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t"+
		"<\4=\t=\4>\t>\4?\t?\4@\t@\4A\tA\4B\tB\4C\tC\4D\tD\4E\tE\4F\tF\4G\tG\4"+
		"H\tH\4I\tI\4J\tJ\4K\tK\4L\tL\4M\tM\4N\tN\4O\tO\4P\tP\4Q\tQ\4R\tR\4S\t"+
		"S\4T\tT\4U\tU\4V\tV\4W\tW\4X\tX\4Y\tY\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\4"+
		"\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3"+
		"\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t"+
		"\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3"+
		"\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\5\r\u010a\n\r\3\16\3\16\3\16\3\16\3"+
		"\16\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\20\3\20\3\20\3\20\3\21\3"+
		"\21\3\21\3\21\3\21\3\21\3\22\3\22\3\22\3\22\3\22\3\22\3\23\3\23\3\23\3"+
		"\23\3\23\3\23\3\23\3\23\3\23\3\23\3\24\3\24\3\25\3\25\3\26\3\26\3\27\3"+
		"\27\3\30\3\30\3\31\3\31\3\32\3\32\3\32\3\33\3\33\3\33\3\34\3\34\3\34\3"+
		"\35\3\35\3\36\3\36\3\37\3\37\3 \3 \3!\3!\3\"\3\"\3\"\3#\3#\3#\3$\3$\3"+
		"%\3%\3%\3&\3&\3\'\3\'\3\'\3(\3(\3)\3)\3*\3*\3*\3+\3+\3+\3,\3,\3-\3-\3"+
		".\3.\3.\3.\3.\3/\3/\3/\3/\3/\3\60\3\60\3\60\3\60\3\60\3\60\3\61\3\61\3"+
		"\62\3\62\3\63\3\63\3\64\3\64\3\65\3\65\3\65\3\66\3\66\3\66\3\67\3\67\3"+
		"\67\38\38\38\39\39\39\3:\3:\3:\6:\u019a\n:\r:\16:\u019b\3:\5:\u019f\n"+
		":\3;\3;\3;\7;\u01a4\n;\f;\16;\u01a7\13;\5;\u01a9\n;\3;\5;\u01ac\n;\3<"+
		"\3<\6<\u01b0\n<\r<\16<\u01b1\3<\5<\u01b5\n<\3=\3=\3>\3>\3?\6?\u01bc\n"+
		"?\r?\16?\u01bd\3?\3?\7?\u01c2\n?\f?\16?\u01c5\13?\3?\5?\u01c8\n?\3?\5"+
		"?\u01cb\n?\3?\3?\6?\u01cf\n?\r?\16?\u01d0\3?\5?\u01d4\n?\3?\5?\u01d7\n"+
		"?\3?\6?\u01da\n?\r?\16?\u01db\3?\3?\5?\u01e0\n?\3?\6?\u01e3\n?\r?\16?"+
		"\u01e4\3?\3?\3?\3?\3?\5?\u01ec\n?\3?\7?\u01ef\n?\f?\16?\u01f2\13?\3?\3"+
		"?\7?\u01f6\n?\f?\16?\u01f9\13?\5?\u01fb\n?\3?\3?\5?\u01ff\n?\3?\6?\u0202"+
		"\n?\r?\16?\u0203\3?\5?\u0207\n?\5?\u0209\n?\3@\3@\5@\u020d\n@\3@\6@\u0210"+
		"\n@\r@\16@\u0211\3A\3A\3B\3B\3B\7B\u0219\nB\fB\16B\u021c\13B\3B\3B\3B"+
		"\3B\7B\u0222\nB\fB\16B\u0225\13B\3B\5B\u0228\nB\3C\3C\3C\3C\5C\u022e\n"+
		"C\3C\3C\5C\u0232\nC\3D\3D\3D\3D\3D\3D\3D\3D\3D\5D\u023d\nD\3E\3E\3E\3"+
		"E\3E\3E\3E\3F\3F\3F\7F\u0249\nF\fF\16F\u024c\13F\3G\3G\3H\3H\3I\6I\u0253"+
		"\nI\rI\16I\u0254\3I\3I\3J\3J\3J\3J\7J\u025d\nJ\fJ\16J\u0260\13J\3J\5J"+
		"\u0263\nJ\3J\3J\5J\u0267\nJ\3J\3J\3K\3K\3K\3K\3K\3K\3L\3L\3L\3L\3M\3M"+
		"\3M\3M\3M\3N\3N\3N\3O\3O\3O\3O\3O\3O\3P\3P\3P\3P\3Q\3Q\3R\3R\3S\3S\3T"+
		"\3T\3T\3T\3U\3U\3V\3V\3W\3W\3X\6X\u0298\nX\rX\16X\u0299\3X\3X\3Y\3Y\3"+
		"Y\3Y\3Y\2\2Z\5\3\7\4\t\5\13\6\r\7\17\b\21\t\23\n\25\13\27\f\31\r\33\16"+
		"\35\17\37\20!\21#\22%\23\'\24)\25+\26-\27/\30\61\31\63\32\65\33\67\34"+
		"9\35;\36=\37? A!C\"E#G$I%K&M\'O(Q)S*U+W,Y-[.]/_\60a\61c\62e\63g\64i\65"+
		"k\66m\67o8q9s:u;w<y={\2}\2\177>\u0081\2\u0083\2\u0085?\u0087\2\u0089\2"+
		"\u008b\2\u008d@\u008f\2\u0091\2\u0093A\u0095B\u0097C\u0099D\u009bE\u009d"+
		"\2\u009f\2\u00a1F\u00a3G\u00a5H\u00a7I\u00a9J\u00abK\u00adL\u00afM\u00b1"+
		"N\u00b3O\5\2\3\4\21\4\2ZZzz\5\2\62;CHch\4\2JJjj\4\2RRrr\4\2--//\4\2GG"+
		"gg\6\2\f\f\17\17$$^^\6\2\f\f\17\17))^^\7\2ddhhppttvv\4\2))^^\16\2&&C\\"+
		"aac|\u00c2\u00d8\u00da\u00f8\u00fa\u2001\u3042\u3191\u3302\u3381\u3402"+
		"\u3d2f\u4e02\ua001\uf902\ufb01\21\2\62;\u0662\u066b\u06f2\u06fb\u0968"+
		"\u0971\u09e8\u09f1\u0a68\u0a71\u0ae8\u0af1\u0b68\u0b71\u0be9\u0bf1\u0c68"+
		"\u0c71\u0ce8\u0cf1\u0d68\u0d71\u0e52\u0e5b\u0ed2\u0edb\u1042\u104b\5\2"+
		"\13\f\16\17\"\"\4\2\f\f\17\17\5\2\13\13\16\17\"\"\2\u02c5\2\5\3\2\2\2"+
		"\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3"+
		"\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2"+
		"\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2"+
		"\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2"+
		"\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2"+
		"\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2"+
		"\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2\2W\3\2\2\2\2Y"+
		"\3\2\2\2\2[\3\2\2\2\2]\3\2\2\2\2_\3\2\2\2\2a\3\2\2\2\2c\3\2\2\2\2e\3\2"+
		"\2\2\2g\3\2\2\2\2i\3\2\2\2\2k\3\2\2\2\2m\3\2\2\2\2o\3\2\2\2\2q\3\2\2\2"+
		"\2s\3\2\2\2\2u\3\2\2\2\2w\3\2\2\2\2y\3\2\2\2\2\177\3\2\2\2\2\u0085\3\2"+
		"\2\2\2\u008d\3\2\2\2\2\u0093\3\2\2\2\2\u0095\3\2\2\2\2\u0097\3\2\2\2\3"+
		"\u0099\3\2\2\2\3\u009b\3\2\2\2\3\u00a1\3\2\2\2\4\u00a3\3\2\2\2\4\u00a5"+
		"\3\2\2\2\4\u00a7\3\2\2\2\4\u00a9\3\2\2\2\4\u00ab\3\2\2\2\4\u00ad\3\2\2"+
		"\2\4\u00af\3\2\2\2\4\u00b1\3\2\2\2\4\u00b3\3\2\2\2\5\u00b5\3\2\2\2\7\u00b8"+
		"\3\2\2\2\t\u00bc\3\2\2\2\13\u00c4\3\2\2\2\r\u00c9\3\2\2\2\17\u00cf\3\2"+
		"\2\2\21\u00d6\3\2\2\2\23\u00dd\3\2\2\2\25\u00e4\3\2\2\2\27\u00ea\3\2\2"+
		"\2\31\u00f3\3\2\2\2\33\u0109\3\2\2\2\35\u010b\3\2\2\2\37\u0110\3\2\2\2"+
		"!\u0118\3\2\2\2#\u011c\3\2\2\2%\u0122\3\2\2\2\'\u0128\3\2\2\2)\u0132\3"+
		"\2\2\2+\u0134\3\2\2\2-\u0136\3\2\2\2/\u0138\3\2\2\2\61\u013a\3\2\2\2\63"+
		"\u013c\3\2\2\2\65\u013e\3\2\2\2\67\u0141\3\2\2\29\u0144\3\2\2\2;\u0147"+
		"\3\2\2\2=\u0149\3\2\2\2?\u014b\3\2\2\2A\u014d\3\2\2\2C\u014f\3\2\2\2E"+
		"\u0151\3\2\2\2G\u0154\3\2\2\2I\u0157\3\2\2\2K\u0159\3\2\2\2M\u015c\3\2"+
		"\2\2O\u015e\3\2\2\2Q\u0161\3\2\2\2S\u0163\3\2\2\2U\u0165\3\2\2\2W\u0168"+
		"\3\2\2\2Y\u016b\3\2\2\2[\u016d\3\2\2\2]\u016f\3\2\2\2_\u0174\3\2\2\2a"+
		"\u0179\3\2\2\2c\u017f\3\2\2\2e\u0181\3\2\2\2g\u0183\3\2\2\2i\u0185\3\2"+
		"\2\2k\u0187\3\2\2\2m\u018a\3\2\2\2o\u018d\3\2\2\2q\u0190\3\2\2\2s\u0193"+
		"\3\2\2\2u\u0196\3\2\2\2w\u01a8\3\2\2\2y\u01ad\3\2\2\2{\u01b6\3\2\2\2}"+
		"\u01b8\3\2\2\2\177\u0208\3\2\2\2\u0081\u020a\3\2\2\2\u0083\u0213\3\2\2"+
		"\2\u0085\u0227\3\2\2\2\u0087\u0231\3\2\2\2\u0089\u023c\3\2\2\2\u008b\u023e"+
		"\3\2\2\2\u008d\u0245\3\2\2\2\u008f\u024d\3\2\2\2\u0091\u024f\3\2\2\2\u0093"+
		"\u0252\3\2\2\2\u0095\u0258\3\2\2\2\u0097\u026a\3\2\2\2\u0099\u0270\3\2"+
		"\2\2\u009b\u0274\3\2\2\2\u009d\u0279\3\2\2\2\u009f\u027c\3\2\2\2\u00a1"+
		"\u0282\3\2\2\2\u00a3\u0286\3\2\2\2\u00a5\u0288\3\2\2\2\u00a7\u028a\3\2"+
		"\2\2\u00a9\u028c\3\2\2\2\u00ab\u0290\3\2\2\2\u00ad\u0292\3\2\2\2\u00af"+
		"\u0294\3\2\2\2\u00b1\u0297\3\2\2\2\u00b3\u029d\3\2\2\2\u00b5\u00b6\7k"+
		"\2\2\u00b6\u00b7\7h\2\2\u00b7\6\3\2\2\2\u00b8\u00b9\7h\2\2\u00b9\u00ba"+
		"\7q\2\2\u00ba\u00bb\7t\2\2\u00bb\b\3\2\2\2\u00bc\u00bd\7g\2\2\u00bd\u00be"+
		"\7n\2\2\u00be\u00bf\7u\2\2\u00bf\u00c0\7g\2\2\u00c0\u00c1\7h\2\2\u00c1"+
		"\u00c2\7q\2\2\u00c2\u00c3\7t\2\2\u00c3\n\3\2\2\2\u00c4\u00c5\7g\2\2\u00c5"+
		"\u00c6\7n\2\2\u00c6\u00c7\7u\2\2\u00c7\u00c8\7g\2\2\u00c8\f\3\2\2\2\u00c9"+
		"\u00ca\7y\2\2\u00ca\u00cb\7j\2\2\u00cb\u00cc\7k\2\2\u00cc\u00cd\7n\2\2"+
		"\u00cd\u00ce\7g\2\2\u00ce\16\3\2\2\2\u00cf\u00d0\7u\2\2\u00d0\u00d1\7"+
		"y\2\2\u00d1\u00d2\7k\2\2\u00d2\u00d3\7v\2\2\u00d3\u00d4\7e\2\2\u00d4\u00d5"+
		"\7j\2\2\u00d5\20\3\2\2\2\u00d6\u00d7\7u\2\2\u00d7\u00d8\7g\2\2\u00d8\u00d9"+
		"\7n\2\2\u00d9\u00da\7g\2\2\u00da\u00db\7e\2\2\u00db\u00dc\7v\2\2\u00dc"+
		"\22\3\2\2\2\u00dd\u00de\7t\2\2\u00de\u00df\7g\2\2\u00df\u00e0\7v\2\2\u00e0"+
		"\u00e1\7w\2\2\u00e1\u00e2\7t\2\2\u00e2\u00e3\7p\2\2\u00e3\24\3\2\2\2\u00e4"+
		"\u00e5\7d\2\2\u00e5\u00e6\7t\2\2\u00e6\u00e7\7g\2\2\u00e7\u00e8\7c\2\2"+
		"\u00e8\u00e9\7m\2\2\u00e9\26\3\2\2\2\u00ea\u00eb\7e\2\2\u00eb\u00ec\7"+
		"q\2\2\u00ec\u00ed\7p\2\2\u00ed\u00ee\7v\2\2\u00ee\u00ef\7k\2\2\u00ef\u00f0"+
		"\7p\2\2\u00f0\u00f1\7w\2\2\u00f1\u00f2\7g\2\2\u00f2\30\3\2\2\2\u00f3\u00f4"+
		"\7x\2\2\u00f4\u00f5\7c\2\2\u00f5\u00f6\7t\2\2\u00f6\32\3\2\2\2\u00f7\u00f8"+
		"\7F\2\2\u00f8\u00f9\7K\2\2\u00f9\u00fa\7T\2\2\u00fa\u00fb\7G\2\2\u00fb"+
		"\u00fc\7E\2\2\u00fc\u00fd\7V\2\2\u00fd\u00fe\7K\2\2\u00fe\u00ff\7X\2\2"+
		"\u00ff\u010a\7G\2\2\u0100\u0101\7f\2\2\u0101\u0102\7k\2\2\u0102\u0103"+
		"\7t\2\2\u0103\u0104\7g\2\2\u0104\u0105\7e\2\2\u0105\u0106\7v\2\2\u0106"+
		"\u0107\7k\2\2\u0107\u0108\7x\2\2\u0108\u010a\7g\2\2\u0109\u00f7\3\2\2"+
		"\2\u0109\u0100\3\2\2\2\u010a\34\3\2\2\2\u010b\u010c\7e\2\2\u010c\u010d"+
		"\7c\2\2\u010d\u010e\7u\2\2\u010e\u010f\7g\2\2\u010f\36\3\2\2\2\u0110\u0111"+
		"\7f\2\2\u0111\u0112\7g\2\2\u0112\u0113\7h\2\2\u0113\u0114\7c\2\2\u0114"+
		"\u0115\7w\2\2\u0115\u0116\7n\2\2\u0116\u0117\7v\2\2\u0117 \3\2\2\2\u0118"+
		"\u0119\7v\2\2\u0119\u011a\7t\2\2\u011a\u011b\7{\2\2\u011b\"\3\2\2\2\u011c"+
		"\u011d\7e\2\2\u011d\u011e\7c\2\2\u011e\u011f\7v\2\2\u011f\u0120\7e\2\2"+
		"\u0120\u0121\7j\2\2\u0121$\3\2\2\2\u0122\u0123\7%\2\2\u0123\u0124\7c\2"+
		"\2\u0124\u0125\7l\2\2\u0125\u0126\7c\2\2\u0126\u0127\7z\2\2\u0127&\3\2"+
		"\2\2\u0128\u0129\7%\2\2\u0129\u012a\7h\2\2\u012a\u012b\7t\2\2\u012b\u012c"+
		"\7c\2\2\u012c\u012d\7i\2\2\u012d\u012e\7o\2\2\u012e\u012f\7g\2\2\u012f"+
		"\u0130\7p\2\2\u0130\u0131\7v\2\2\u0131(\3\2\2\2\u0132\u0133\7}\2\2\u0133"+
		"*\3\2\2\2\u0134\u0135\7\177\2\2\u0135,\3\2\2\2\u0136\u0137\7*\2\2\u0137"+
		".\3\2\2\2\u0138\u0139\7+\2\2\u0139\60\3\2\2\2\u013a\u013b\7]\2\2\u013b"+
		"\62\3\2\2\2\u013c\u013d\7_\2\2\u013d\64\3\2\2\2\u013e\u013f\7-\2\2\u013f"+
		"\u0140\7-\2\2\u0140\66\3\2\2\2\u0141\u0142\7/\2\2\u0142\u0143\7/\2\2\u0143"+
		"8\3\2\2\2\u0144\u0145\7\60\2\2\u0145\u0146\7\u0080\2\2\u0146:\3\2\2\2"+
		"\u0147\u0148\7-\2\2\u0148<\3\2\2\2\u0149\u014a\7/\2\2\u014a>\3\2\2\2\u014b"+
		"\u014c\7,\2\2\u014c@\3\2\2\2\u014d\u014e\7\61\2\2\u014eB\3\2\2\2\u014f"+
		"\u0150\7\'\2\2\u0150D\3\2\2\2\u0151\u0152\7?\2\2\u0152\u0153\7?\2\2\u0153"+
		"F\3\2\2\2\u0154\u0155\7#\2\2\u0155\u0156\7?\2\2\u0156H\3\2\2\2\u0157\u0158"+
		"\7?\2\2\u0158J\3\2\2\2\u0159\u015a\7@\2\2\u015a\u015b\7?\2\2\u015bL\3"+
		"\2\2\2\u015c\u015d\7@\2\2\u015dN\3\2\2\2\u015e\u015f\7>\2\2\u015f\u0160"+
		"\7?\2\2\u0160P\3\2\2\2\u0161\u0162\7>\2\2\u0162R\3\2\2\2\u0163\u0164\7"+
		"#\2\2\u0164T\3\2\2\2\u0165\u0166\7(\2\2\u0166\u0167\7(\2\2\u0167V\3\2"+
		"\2\2\u0168\u0169\7~\2\2\u0169\u016a\7~\2\2\u016aX\3\2\2\2\u016b\u016c"+
		"\7A\2\2\u016cZ\3\2\2\2\u016d\u016e\7B\2\2\u016e\\\3\2\2\2\u016f\u0170"+
		"\7p\2\2\u0170\u0171\7w\2\2\u0171\u0172\7n\2\2\u0172\u0173\7n\2\2\u0173"+
		"^\3\2\2\2\u0174\u0175\7v\2\2\u0175\u0176\7t\2\2\u0176\u0177\7w\2\2\u0177"+
		"\u0178\7g\2\2\u0178`\3\2\2\2\u0179\u017a\7h\2\2\u017a\u017b\7c\2\2\u017b"+
		"\u017c\7n\2\2\u017c\u017d\7u\2\2\u017d\u017e\7g\2\2\u017eb\3\2\2\2\u017f"+
		"\u0180\7=\2\2\u0180d\3\2\2\2\u0181\u0182\7.\2\2\u0182f\3\2\2\2\u0183\u0184"+
		"\7<\2\2\u0184h\3\2\2\2\u0185\u0186\7\60\2\2\u0186j\3\2\2\2\u0187\u0188"+
		"\7k\2\2\u0188\u0189\7p\2\2\u0189l\3\2\2\2\u018a\u018b\7>\2\2\u018b\u018c"+
		"\7>\2\2\u018cn\3\2\2\2\u018d\u018e\7>\2\2\u018e\u018f\7%\2\2\u018fp\3"+
		"\2\2\2\u0190\u0191\7@\2\2\u0191\u0192\7@\2\2\u0192r\3\2\2\2\u0193\u0194"+
		"\7>\2\2\u0194\u0195\7&\2\2\u0195t\3\2\2\2\u0196\u0197\7\62\2\2\u0197\u0199"+
		"\t\2\2\2\u0198\u019a\5{=\2\u0199\u0198\3\2\2\2\u019a\u019b\3\2\2\2\u019b"+
		"\u0199\3\2\2\2\u019b\u019c\3\2\2\2\u019c\u019e\3\2\2\2\u019d\u019f\5}"+
		">\2\u019e\u019d\3\2\2\2\u019e\u019f\3\2\2\2\u019fv\3\2\2\2\u01a0\u01a9"+
		"\7\62\2\2\u01a1\u01a5\4\63;\2\u01a2\u01a4\4\62;\2\u01a3\u01a2\3\2\2\2"+
		"\u01a4\u01a7\3\2\2\2\u01a5\u01a3\3\2\2\2\u01a5\u01a6\3\2\2\2\u01a6\u01a9"+
		"\3\2\2\2\u01a7\u01a5\3\2\2\2\u01a8\u01a0\3\2\2\2\u01a8\u01a1\3\2\2\2\u01a9"+
		"\u01ab\3\2\2\2\u01aa\u01ac\5}>\2\u01ab\u01aa\3\2\2\2\u01ab\u01ac\3\2\2"+
		"\2\u01acx\3\2\2\2\u01ad\u01af\7\62\2\2\u01ae\u01b0\4\629\2\u01af\u01ae"+
		"\3\2\2\2\u01b0\u01b1\3\2\2\2\u01b1\u01af\3\2\2\2\u01b1\u01b2\3\2\2\2\u01b2"+
		"\u01b4\3\2\2\2\u01b3\u01b5\5}>\2\u01b4\u01b3\3\2\2\2\u01b4\u01b5\3\2\2"+
		"\2\u01b5z\3\2\2\2\u01b6\u01b7\t\3\2\2\u01b7|\3\2\2\2\u01b8\u01b9\t\4\2"+
		"\2\u01b9~\3\2\2\2\u01ba\u01bc\4\62;\2\u01bb\u01ba\3\2\2\2\u01bc\u01bd"+
		"\3\2\2\2\u01bd\u01bb\3\2\2\2\u01bd\u01be\3\2\2\2\u01be\u01bf\3\2\2\2\u01bf"+
		"\u01c3\7\60\2\2\u01c0\u01c2\4\62;\2\u01c1\u01c0\3\2\2\2\u01c2\u01c5\3"+
		"\2\2\2\u01c3\u01c1\3\2\2\2\u01c3\u01c4\3\2\2\2\u01c4\u01c7\3\2\2\2\u01c5"+
		"\u01c3\3\2\2\2\u01c6\u01c8\5\u0081@\2\u01c7\u01c6\3\2\2\2\u01c7\u01c8"+
		"\3\2\2\2\u01c8\u01ca\3\2\2\2\u01c9\u01cb\5\u0083A\2\u01ca\u01c9\3\2\2"+
		"\2\u01ca\u01cb\3\2\2\2\u01cb\u0209\3\2\2\2\u01cc\u01ce\7\60\2\2\u01cd"+
		"\u01cf\4\62;\2\u01ce\u01cd\3\2\2\2\u01cf\u01d0\3\2\2\2\u01d0\u01ce\3\2"+
		"\2\2\u01d0\u01d1\3\2\2\2\u01d1\u01d3\3\2\2\2\u01d2\u01d4\5\u0081@\2\u01d3"+
		"\u01d2\3\2\2\2\u01d3\u01d4\3\2\2\2\u01d4\u01d6\3\2\2\2\u01d5\u01d7\5\u0083"+
		"A\2\u01d6\u01d5\3\2\2\2\u01d6\u01d7\3\2\2\2\u01d7\u0209\3\2\2\2\u01d8"+
		"\u01da\4\62;\2\u01d9\u01d8\3\2\2\2\u01da\u01db\3\2\2\2\u01db\u01d9\3\2"+
		"\2\2\u01db\u01dc\3\2\2\2\u01dc\u01dd\3\2\2\2\u01dd\u01df\5\u0081@\2\u01de"+
		"\u01e0\5\u0083A\2\u01df\u01de\3\2\2\2\u01df\u01e0\3\2\2\2\u01e0\u0209"+
		"\3\2\2\2\u01e1\u01e3\4\62;\2\u01e2\u01e1\3\2\2\2\u01e3\u01e4\3\2\2\2\u01e4"+
		"\u01e2\3\2\2\2\u01e4\u01e5\3\2\2\2\u01e5\u01e6\3\2\2\2\u01e6\u0209\5\u0083"+
		"A\2\u01e7\u01e8\7\62\2\2\u01e8\u01ec\7z\2\2\u01e9\u01ea\7\62\2\2\u01ea"+
		"\u01ec\7Z\2\2\u01eb\u01e7\3\2\2\2\u01eb\u01e9\3\2\2\2\u01ec\u01f0\3\2"+
		"\2\2\u01ed\u01ef\5{=\2\u01ee\u01ed\3\2\2\2\u01ef\u01f2\3\2\2\2\u01f0\u01ee"+
		"\3\2\2\2\u01f0\u01f1\3\2\2\2\u01f1\u01fa\3\2\2\2\u01f2\u01f0\3\2\2\2\u01f3"+
		"\u01f7\7\60\2\2\u01f4\u01f6\5{=\2\u01f5\u01f4\3\2\2\2\u01f6\u01f9\3\2"+
		"\2\2\u01f7\u01f5\3\2\2\2\u01f7\u01f8\3\2\2\2\u01f8\u01fb\3\2\2\2\u01f9"+
		"\u01f7\3\2\2\2\u01fa\u01f3\3\2\2\2\u01fa\u01fb\3\2\2\2\u01fb\u01fc\3\2"+
		"\2\2\u01fc\u01fe\t\5\2\2\u01fd\u01ff\t\6\2\2\u01fe\u01fd\3\2\2\2\u01fe"+
		"\u01ff\3\2\2\2\u01ff\u0201\3\2\2\2\u0200\u0202\4\62;\2\u0201\u0200\3\2"+
		"\2\2\u0202\u0203\3\2\2\2\u0203\u0201\3\2\2\2\u0203\u0204\3\2\2\2\u0204"+
		"\u0206\3\2\2\2\u0205\u0207\5\u0083A\2\u0206\u0205\3\2\2\2\u0206\u0207"+
		"\3\2\2\2\u0207\u0209\3\2\2\2\u0208\u01bb\3\2\2\2\u0208\u01cc\3\2\2\2\u0208"+
		"\u01d9\3\2\2\2\u0208\u01e2\3\2\2\2\u0208\u01eb\3\2\2\2\u0209\u0080\3\2"+
		"\2\2\u020a\u020c\t\7\2\2\u020b\u020d\t\6\2\2\u020c\u020b\3\2\2\2\u020c"+
		"\u020d\3\2\2\2\u020d\u020f\3\2\2\2\u020e\u0210\4\62;\2\u020f\u020e\3\2"+
		"\2\2\u0210\u0211\3\2\2\2\u0211\u020f\3\2\2\2\u0211\u0212\3\2\2\2\u0212"+
		"\u0082\3\2\2\2\u0213\u0214\t\4\2\2\u0214\u0084\3\2\2\2\u0215\u021a\7$"+
		"\2\2\u0216\u0219\5\u0087C\2\u0217\u0219\n\b\2\2\u0218\u0216\3\2\2\2\u0218"+
		"\u0217\3\2\2\2\u0219\u021c\3\2\2\2\u021a\u0218\3\2\2\2\u021a\u021b\3\2"+
		"\2\2\u021b\u021d\3\2\2\2\u021c\u021a\3\2\2\2\u021d\u0228\7$\2\2\u021e"+
		"\u0223\7)\2\2\u021f\u0222\5\u0087C\2\u0220\u0222\n\t\2\2\u0221\u021f\3"+
		"\2\2\2\u0221\u0220\3\2\2\2\u0222\u0225\3\2\2\2\u0223\u0221\3\2\2\2\u0223"+
		"\u0224\3\2\2\2\u0224\u0226\3\2\2\2\u0225\u0223\3\2\2\2\u0226\u0228\7)"+
		"\2\2\u0227\u0215\3\2\2\2\u0227\u021e\3\2\2\2\u0228\u0086\3\2\2\2\u0229"+
		"\u022d\7^\2\2\u022a\u022e\t\n\2\2\u022b\u022e\3\2\2\2\u022c\u022e\t\13"+
		"\2\2\u022d\u022a\3\2\2\2\u022d\u022b\3\2\2\2\u022d\u022c\3\2\2\2\u022e"+
		"\u0232\3\2\2\2\u022f\u0232\5\u008bE\2\u0230\u0232\5\u0089D\2\u0231\u0229"+
		"\3\2\2\2\u0231\u022f\3\2\2\2\u0231\u0230\3\2\2\2\u0232\u0088\3\2\2\2\u0233"+
		"\u0234\7^\2\2\u0234\u0235\4\62\65\2\u0235\u0236\4\629\2\u0236\u023d\4"+
		"\629\2\u0237\u0238\7^\2\2\u0238\u0239\4\629\2\u0239\u023d\4\629\2\u023a"+
		"\u023b\7^\2\2\u023b\u023d\4\629\2\u023c\u0233\3\2\2\2\u023c\u0237\3\2"+
		"\2\2\u023c\u023a\3\2\2\2\u023d\u008a\3\2\2\2\u023e\u023f\7^\2\2\u023f"+
		"\u0240\7w\2\2\u0240\u0241\5{=\2\u0241\u0242\5{=\2\u0242\u0243\5{=\2\u0243"+
		"\u0244\5{=\2\u0244\u008c\3\2\2\2\u0245\u024a\5\u008fG\2\u0246\u0249\5"+
		"\u008fG\2\u0247\u0249\5\u0091H\2\u0248\u0246\3\2\2\2\u0248\u0247\3\2\2"+
		"\2\u0249\u024c\3\2\2\2\u024a\u0248\3\2\2\2\u024a\u024b\3\2\2\2\u024b\u008e"+
		"\3\2\2\2\u024c\u024a\3\2\2\2\u024d\u024e\t\f\2\2\u024e\u0090\3\2\2\2\u024f"+
		"\u0250\t\r\2\2\u0250\u0092\3\2\2\2\u0251\u0253\t\16\2\2\u0252\u0251\3"+
		"\2\2\2\u0253\u0254\3\2\2\2\u0254\u0252\3\2\2\2\u0254\u0255\3\2\2\2\u0255"+
		"\u0256\3\2\2\2\u0256\u0257\bI\2\2\u0257\u0094\3\2\2\2\u0258\u0259\7\61"+
		"\2\2\u0259\u025a\7\61\2\2\u025a\u025e\3\2\2\2\u025b\u025d\n\17\2\2\u025c"+
		"\u025b\3\2\2\2\u025d\u0260\3\2\2\2\u025e\u025c\3\2\2\2\u025e\u025f\3\2"+
		"\2\2\u025f\u0266\3\2\2\2\u0260\u025e\3\2\2\2\u0261\u0263\7\17\2\2\u0262"+
		"\u0261\3\2\2\2\u0262\u0263\3\2\2\2\u0263\u0264\3\2\2\2\u0264\u0267\7\f"+
		"\2\2\u0265\u0267\7\2\2\3\u0266\u0262\3\2\2\2\u0266\u0265\3\2\2\2\u0267"+
		"\u0268\3\2\2\2\u0268\u0269\bJ\2\2\u0269\u0096\3\2\2\2\u026a\u026b\7\61"+
		"\2\2\u026b\u026c\7,\2\2\u026c\u026d\3\2\2\2\u026d\u026e\bK\3\2\u026e\u026f"+
		"\bK\2\2\u026f\u0098\3\2\2\2\u0270\u0271\5\u009fO\2\u0271\u0272\3\2\2\2"+
		"\u0272\u0273\bL\4\2\u0273\u009a\3\2\2\2\u0274\u0275\5\u009dN\2\u0275\u0276"+
		"\3\2\2\2\u0276\u0277\bM\5\2\u0277\u0278\bM\2\2\u0278\u009c\3\2\2\2\u0279"+
		"\u027a\7,\2\2\u027a\u027b\7\61\2\2\u027b\u009e\3\2\2\2\u027c\u027d\7B"+
		"\2\2\u027d\u027e\7v\2\2\u027e\u027f\7{\2\2\u027f\u0280\7r\2\2\u0280\u0281"+
		"\7g\2\2\u0281\u00a0\3\2\2\2\u0282\u0283\13\2\2\2\u0283\u0284\3\2\2\2\u0284"+
		"\u0285\bP\2\2\u0285\u00a2\3\2\2\2\u0286\u0287\5\u008dF\2\u0287\u00a4\3"+
		"\2\2\2\u0288\u0289\7\60\2\2\u0289\u00a6\3\2\2\2\u028a\u028b\7*\2\2\u028b"+
		"\u00a8\3\2\2\2\u028c\u028d\7+\2\2\u028d\u028e\3\2\2\2\u028e\u028f\bT\5"+
		"\2\u028f\u00aa\3\2\2\2\u0290\u0291\7.\2\2\u0291\u00ac\3\2\2\2\u0292\u0293"+
		"\7>\2\2\u0293\u00ae\3\2\2\2\u0294\u0295\7@\2\2\u0295\u00b0\3\2\2\2\u0296"+
		"\u0298\t\20\2\2\u0297\u0296\3\2\2\2\u0298\u0299\3\2\2\2\u0299\u0297\3"+
		"\2\2\2\u0299\u029a\3\2\2\2\u029a\u029b\3\2\2\2\u029b\u029c\bX\2\2\u029c"+
		"\u00b2\3\2\2\2\u029d\u029e\t\17\2\2\u029e\u029f\3\2\2\2\u029f\u02a0\b"+
		"Y\5\2\u02a0\u02a1\bY\2\2\u02a1\u00b4\3\2\2\2\60\2\3\4\u0109\u019b\u019e"+
		"\u01a5\u01a8\u01ab\u01b1\u01b4\u01bd\u01c3\u01c7\u01ca\u01d0\u01d3\u01d6"+
		"\u01db\u01df\u01e4\u01eb\u01f0\u01f7\u01fa\u01fe\u0203\u0206\u0208\u020c"+
		"\u0211\u0218\u021a\u0221\u0223\u0227\u022d\u0231\u023c\u0248\u024a\u0254"+
		"\u025e\u0262\u0266\u0299\6\2\3\2\7\3\2\7\4\2\6\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}