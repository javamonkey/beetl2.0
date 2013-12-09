package org.beetl.core.statement;

import org.beetl.core.Context;

public class VarAssignNullStatment extends ASTNode{

	protected int varIndex ;
	public VarAssignNullStatment(int varIndex,Token token) {
		super(token);
		this.varIndex = varIndex;
	}

	@Override
	public Object run(Context ctx) {
		// TODO Auto-generated method stub
		ctx.vars[varIndex] = null;
		return null;
	}

}
