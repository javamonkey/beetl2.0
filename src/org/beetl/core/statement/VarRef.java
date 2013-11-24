package org.beetl.core.statement;


import org.beetl.core.Context;
import org.beetl.core.attr.AA;
import org.beetl.core.attr.AAFactory;
import org.beetl.core.exception.TempException;

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
			}else if(attributes.length!=0){
				throw new TempException("未定义或者是空");
			}
		}
		
		if(attributes.length==0){
			return value;
		}
		Object attrExp = null;
		NodeType type = (NodeType)this.cachedValue;
		for(VarAttribute attr:attributes){
			switch(attr.type){
			
			case 0: //普通属性访问
				attrExp = (String)attr.id.token.text;
			case 1: // map or list
				attrExp = attr.expression.run(ctx);
			case 2:
				// 虚拟属性，待定
				
			}
			
			AA accessor  = (AA)attr.cachedValue;
			
			if(accessor==null){
				synchronized(attr){
					if(accessor==null){
						accessor =AAFactory.build(type.classType,value, attrExp);
						attr.cachedValue = accessor;
					}
					
				}
			}
			value = accessor.value(value,  attrExp);
			if(value==null&&safe!=null)	{
				return safe.run(ctx);
			}
		}
		return value;
	
		
	}

}
