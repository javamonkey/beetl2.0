package org.beetl.core.statement;

import org.antlr.v4.runtime.Token;
import org.beetl.core.Context;

public class VarRef extends ASTNode {

	VarAttribute[] attributes ;
	Expression safe =  null;
	public VarRef(int varIndex,VarAttribute[] attributes,Expression safe,Token token) {
		super(token);
		this.refIndex = varIndex;
		this.attributes = attributes;
		this.safe = safe;
		// TODO Auto-generated constructor stub
	}

	@Override
	public Object run(Context ctx) {
		// TODO Auto-generated method stub
		Object value = ctx.vars[refIndex];
		if(value==null||value==Context.NOT_EXIST_OBJECT){
			if(safe!=null){
				return safe.run(ctx);
			}
		}
		
		if(attributes.length==0){
			return value;
		}
		
		for(VarAttribute attr:attributes){
			switch(attr.type){
			case 0:
				String name = (String)attr.cachedValue;
				
			case 1:
			case 2:
			}
				
		}
		
	}

}
