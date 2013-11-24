package org.beetl.core.statement;


import org.beetl.core.Context;

public class Literal extends ASTNode {

	public Literal(Object value,Token token) {
		super(token);
		this.cachedValue = value;
		// TODO Auto-generated constructor stub
	}

	@Override
	public Object run(Context ctx) {
		// TODO Auto-generated method stub
		return this.cachedValue;
	}

}
