parser  grammar BeetlParser;
options { 
    tokenVocab=BeetlLexer;
}


// starting point for parsing a java file
prog
    :    statement*
        EOF
    ;


block
    :   LEFT_BRACE statement* RIGHT_BRACE
    ;


// STATMENT
statement
  
    :   block   #blockSt
    |   textStatment    #textOutputSt
    |   constantsTextStatment #staticOutputSt
    |   COMMENT_TAG commentTypeTag  #commentTagSt
    |   If parExpression statement (Else statement)? #ifSt
    |   For LEFT_PAR forControl RIGHT_PAR statement  ( Elsefor statement)?  #forSt
    |   While parExpression statement   #whileSt
    |   Switch parExpression switchBlock    #siwchSt
    |   Select g_switchStatment #selectSt
    |   Try  block (Catch  LEFT_PAR Identifier? RIGHT_PAR  block   )?    #trySt
    |   Return expression? END  #returnSt
    |   Break END   #breakSt
    |   Continue END    #continueSt
    |   Var varDeclareList END  #varSt
    |   Directive  directiveExp #directiveSt 
    |   assignMent END  #assignSt
    |   functionTagCall #functionTagSt 
    |   statementExpression END   #statmentExpSt 
    |   (Ajax|Fragment) Identifier Identifier? COLON block   #ajaxSt 
    |   END   #end
      
    ;
//注解:@type User user,List<User> userList
commentTypeTag: LEFT_PAR1 commentTypeItemTag (COMMA1 commentTypeItemTag)* RIGHT_PAR1;
commentTypeItemTag:    classOrInterfaceType   Identifier1    
                  ;
classOrInterfaceType: Identifier1 (PERIOD1 Identifier1 )* typeArguments?;
typeArguments
    :   LEFT_ANGULAR typeArgument (COMMA1 typeArgument)* RIGHT_ANGULAR
    ;
typeArgument
    :   classOrInterfaceType 
    ;

//指令  directive object xx,xx,xx                 
directiveExp:  Identifier (StringLiteral|directiveExpIDList)? END;
directiveExpIDList: Identifier (COMMA Identifier)* ;


g_switchStatment
	:	 (LEFT_PAR base=expression RIGHT_PAR)? LEFT_BRACE g_caseStatment* g_defaultStatment? RIGHT_BRACE
	 ;

g_caseStatment 
	:	Case expression (COMMA expression)* COLON statement* ;

g_defaultStatment
	:	Default COLON statement*;	

varDeclareList :  assignMent (COMMA assignMent)* 
;	
assignMent	
	:	Identifier                  #assignId
	|	generalAssignExp            #assignGeneralInSt 
	|	Identifier ASSIN  block     #assignTemplateVar


;

switchBlock
    :   LEFT_BRACE switchBlockStatementGroup* RIGHT_BRACE
    ;

switchBlockStatementGroup
    :   switchLabel+ statement*
    ;

switchLabel
    :   Case expression COLON   
    |   Default COLON
    ;

forControl
    :    forInControl
    |    generalForControl
    ;
   
forInControl: Var?   Identifier FOR_IN expression ;
generalForControl:forInit? ';' expression? ';' forUpdate?;
forInit
    :   Var varDeclareList
    |   expressionList
    ;
forUpdate
    :   expressionList
    ;



// EXPRESSIONS

parExpression
    :   LEFT_PAR expression RIGHT_PAR
    ;

expressionList
    :   expression (COMMA expression)*
    ;

statementExpression
    :   expression
    ;
textStatment:   //表达式输
    
       LEFT_TOKEN textVar RIGHT_TOKEN
      |    LEFT_TOKEN2 textVar RIGHT_TOKEN;
textVar	
:	b=expression  (COMMA textformat)?
;
textformat:
        fm=functionNs (ASSIN StringLiteral)?
        | StringLiteral  ;

constantsTextStatment
	:	LEFT_TEXT_TOKEN  DecimalLiteral RIGHT_TOKEN   ; // 常量输出,代表数组搜应


constantExpression
    :   expression
    ;

 expression
    :   literal        #literalExp
    |   AT nativeCall   #nativeCallExp
    |   functionCall    #functionCallExp
    |   varRef          #varRefExp
    |   json        #jsonExp  
    |   Identifier (INCREASE|DECREASE) #oneIncDec
    |   (ADD|MIN) expression    #negExp
    |   (INCREASE|DECREASE)  Identifier #incDecOne
    |   NOT expression      #notExp
    |   expression (MUlTIP|DIV|MOD) expression #muldivmodExp
    |   expression (ADD|MIN) expression #addminExp
    |   expression (EQUAL | NOT_EQUAL |LESS_EQUAL | LARGE_EQUAL |LARGE |LESS) expression   #compareExp
    |   expression AND expression   #andExp
    |   expression OR expression    #orExp
    |   expression QUESTOIN expression? COLON? expression?  #ternaryExp
    |   LEFT_PAR expression RIGHT_PAR #parExp
    |   generalAssignExp  #assignGeneralInExp
    |   generalAssingSelfExp #assingSelfExp

    ;
    
generalAssignExp: varRef ASSIN expression ;
varRef:Identifier ( varAttribute)*  (safe_output)?
;

generalAssingSelfExp: varRef (ADD|MIN|MUlTIP|DIV)   ASSIN expression;

varAttribute :PERIOD Identifier   #varAttributeGeneral
             | VIRTUAL Identifier #varAttributeVirtual
             |LEFT_SQBR expression RIGHT_SQBR #varAttributeArrayOrMap
             ;
safe_output: NOT safe_allow_exp? ;
safe_allow_exp:literal
              | AT nativeCall
              | functionCall
              | json 
              | varRef
              | LEFT_PAR expression RIGHT_PAR;
    

functionCall: functionNs LEFT_PAR expressionList? RIGHT_PAR (varAttribute)* (safe_output)?; 
functionTagCall:functionNs  LEFT_PAR expressionList? RIGHT_PAR  block ;

functionNs:Identifier (PERIOD Identifier)*;

// NATIVE

nativeCall: nativeVarRefChain (nativeMethod|nativeArray| PERIOD nativeVarRefChain)*;
nativeMethod:  LEFT_PAR (expression (COMMA expression) *)? RIGHT_PAR ;
nativeArray: LEFT_SQBR expression RIGHT_SQBR;
nativeVarRefChain:Identifier (PERIOD Identifier)*;        


json	:	LEFT_SQBR (expression  (COMMA expression)*)? RIGHT_SQBR
	|	LEFT_BRACE (jsonKeyValue (COMMA jsonKeyValue)*)? RIGHT_BRACE
	;
jsonKeyValue
	:	StringLiteral COLON expression  
	|	Identifier COLON expression 
	;
literal
    :   DecimalLiteral 
    |   FloatingPointLiteral  
    |   StringLiteral
    |   booleanLiteral
    |   NULL
    ;


booleanLiteral
    :   TRUE
    |   FALSE
    ;



arguments
    :   LEFT_PAR expressionList? RIGHT_PAR
    ;


