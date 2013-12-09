package org.beetl.core.statement;


import org.beetl.core.Context;

public class Literal extends Expression {

	Object obj = null;
	public Literal(Object value,Token token) {
		super(token);
		this.obj = value;
		
		// TODO Auto-generated constructor stub
	}

	@Override
	public Object run(Context ctx) {
		return obj;
	}

}
