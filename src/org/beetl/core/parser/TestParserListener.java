package org.beetl.core.parser;

import org.antlr.v4.runtime.misc.NotNull;

public class TestParserListener extends BeetlParserBaseListener {
	@Override public void enterVarDefine(@NotNull BeetlParser.VarDefineContext ctx) {
		
		
	}
	
	@Override public void enterVarDefineValue(@NotNull BeetlParser.VarDefineValueContext ctx) { 
		
		if(ctx.getParent().getRuleIndex()==BeetlParser.RULE_varDeclareList){
			System.out.println("new var "+ctx.Identifier());
		}else{
			System.out.println("set var "+ctx.Identifier());
		}
	}

	
	
}
