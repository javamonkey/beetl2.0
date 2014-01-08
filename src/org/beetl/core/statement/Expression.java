package org.beetl.core.statement;

import org.beetl.core.Context;

public class Expression extends ASTNode {

	public Type type = null;

	public Expression(Token token) {
		super(token);
		// TODO Auto-generated constructor stub
	}

	public Object evaluate(Context ctx) {
		// TODO Auto-generated method stub
		return null;
	}

	public Type getType() {
		return this.type;
	}

	public void setType(Type type) {
		this.type = type;
	}

}
