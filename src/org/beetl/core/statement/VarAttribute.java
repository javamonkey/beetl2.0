package org.beetl.core.statement;


import org.beetl.core.Context;

public class VarAttribute extends ASTNode {
	ASTNode id ;
	Expression expression;
	char type;
	public VarAttribute(ASTNode id,Expression expression,char type,Token token) {
		super(token);
		this.id = id ;
		this.expression = expression;
		this.type = type;
	}

	@Override
	public Object run(Context ctx) {
		return null;
	}
	
	

}
