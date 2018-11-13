lexer grammar BeetlLexer;
@lexer::members {
	public void notifyListeners(LexerNoViableAltException e) {
		String text = _input.getText(Interval.of(_tokenStartCharIndex, _input.index()));		
		ANTLRErrorListener listener = getErrorListenerDispatch();
		listener.syntaxError(this, null, _tokenStartLine, _tokenStartCharPositionInLine, text, e);
	}
}

If:'if';
For:'for';
Elsefor:'elsefor';
Else:'else';
While:'while';
Switch:'switch';
Select:'select';
Return:'return';
Break:'break';
Continue:'continue';
Var:'var';    
Directive:'DIRECTIVE'|'directive';
Case:'case';
Default:'default';
Try:'try';
Catch:'catch';  
Ajax:'#ajax';
Fragment:'#fragment';
LEFT_BRACE:'{';
RIGHT_BRACE:'}';
LEFT_PAR:'(';
RIGHT_PAR:')';
LEFT_SQBR:'[';
RIGHT_SQBR:']';
INCREASE:'++';
DECREASE:'--';
VIRTUAL:'.~';
ADD:'+';
MIN:'-';
MUlTIP:'*';
DIV:'/';
MOD:'%';
EQUAL:'==';
NOT_EQUAL:'!=';
ASSIN:'=';
LARGE_EQUAL:'>=';
LARGE:'>';
LESS_EQUAL:'<=';
LESS:'<';

NOT:'!';
AND:'&&';
OR:'||';
QUESTOIN:'?';
AT:'@';
NULL:'null';
TRUE:'true';
FALSE:'false';
END:';';
COMMA:',';
COLON:':';
PERIOD:'.';
FOR_IN:'in';
LEFT_TOKEN:'<<';
LEFT_TOKEN2:'<#';
RIGHT_TOKEN:'>>';
LEFT_TEXT_TOKEN	:'<$';
     

// LEXER

HexLiteral : '0' ('x'|'X') HexDigit+ IntegerTypeSuffix? ;

DecimalLiteral : ('0' | '1'..'9' '0'..'9'*) IntegerTypeSuffix? ;

OctalLiteral : '0' ('0'..'7')+ IntegerTypeSuffix? ;

fragment
HexDigit : ('0'..'9'|'a'..'f'|'A'..'F') ;

fragment
IntegerTypeSuffix : ('h'|'H') ;

FloatingPointLiteral
    :   ('0'..'9')+ '.' ('0'..'9')* Exponent? FloatTypeSuffix?
    |   '.' ('0'..'9')+ Exponent? FloatTypeSuffix?
    |   ('0'..'9')+ Exponent FloatTypeSuffix?
    |   ('0'..'9')+ FloatTypeSuffix
    |   ('0x' | '0X') (HexDigit )*
        ('.' (HexDigit)*)?
        ( 'p' | 'P' )
        ( '+' | '-' )?
        ( '0' .. '9' )+
        FloatTypeSuffix?
    ;

fragment
Exponent : ('e'|'E') ('+'|'-')? ('0'..'9')+ ;

fragment
FloatTypeSuffix : ('h'|'H') ;



StringLiteral
    :  '"' ( EscapeSequence | ~('\\'|'"'|'\n'|'\r') )* '"'
    |  '\'' ( EscapeSequence | ~('\''|'\\'|'\n'|'\r') )* '\''
    ;

fragment
EscapeSequence
    :   '\\' ('b'|'t'|'n'|'f'|'r'|'\"'|'\''|'\\')
    |   UnicodeEscape
    |   OctalEscape
    ;

fragment
OctalEscape
    :   '\\' ('0'..'3') ('0'..'7') ('0'..'7')
    |   '\\' ('0'..'7') ('0'..'7')
    |   '\\' ('0'..'7')
    ;

fragment
UnicodeEscape
    :   '\\' 'u' HexDigit HexDigit HexDigit HexDigit
    ;


Identifier
    :   Letter (Letter|JavaIDDigit)*
    ;

/**I found this char range in JavaCC's grammar, but Letter and Digit overlap.
   Still works, but...
 */
fragment
Letter
    :  '\u0024' |
       '\u0041'..'\u005a' |
       '\u005f' |
       '\u0061'..'\u007a' |
       '\u00c0'..'\u00d6' |
       '\u00d8'..'\u00f6' |
       '\u00f8'..'\u00ff' |
       '\u0100'..'\u1fff' |
       '\u3040'..'\u318f' |
       '\u3300'..'\u337f' |
       '\u3400'..'\u3d2d' |
       '\u4e00'..'\u9fff' |
       '\uf900'..'\ufaff'
    ;

fragment
JavaIDDigit
    :  '\u0030'..'\u0039' |
       '\u0660'..'\u0669' |
       '\u06f0'..'\u06f9' |
       '\u0966'..'\u096f' |
       '\u09e6'..'\u09ef' |
       '\u0a66'..'\u0a6f' |
       '\u0ae6'..'\u0aef' |
       '\u0b66'..'\u0b6f' |
       '\u0be7'..'\u0bef' |
       '\u0c66'..'\u0c6f' |
       '\u0ce6'..'\u0cef' |
       '\u0d66'..'\u0d6f' |
       '\u0e50'..'\u0e59' |
       '\u0ed0'..'\u0ed9' |
       '\u1040'..'\u1049'
   ;
 
WS  :   [ \r\t\u000C\n]+ -> channel(HIDDEN)
    ;

LINE_COMMENT
    : '//' ~[\r\n]* ('\r'?'\n'|EOF) -> channel(HIDDEN)
    ;


COMMENT_OPEN
    :   '/*'    ->pushMode(MODE_COMMENT),channel(HIDDEN) 
    ;
mode MODE_COMMENT;

COMMENT_TAG:TYPE_CHAR ->pushMode(MODE_COMMENT_TYPE)  ;

COMMENT_END: COMMENT_END_CHAR  -> popMode,channel(HIDDEN)
;

fragment
    COMMENT_END_CHAR:'*/';
fragment
    TYPE_CHAR:'@type';

ALL_COMMENT_CHAR:.->channel(HIDDEN);

mode MODE_COMMENT_TYPE;
Identifier1:Identifier;
PERIOD1:'.';
LEFT_PAR1:'(';
RIGHT_PAR1:')' -> popMode ;
COMMA1:','; 
LEFT_ANGULAR:'<';
RIGHT_ANGULAR:'>';
WS1  :   [ \r\t\u000C]+ -> channel(HIDDEN);
TYPE_END: [\r\n]  -> popMode,channel(HIDDEN)        ;

