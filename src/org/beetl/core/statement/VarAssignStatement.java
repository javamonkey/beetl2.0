package org.beetl.core.statement;

import org.beetl.core.Context;

public class VarAssignStatement extends ASTNode {

	protected int varIndex;
	Expression exp;
	public VarAssignStatement(Expression exp,Token token) {
		super(token);
		this.varIndex = varIndex;
		this.exp = exp;
	}

	@Override
	public Object run(Context ctx) {
		ctx.vars[varIndex] = exp.run(ctx);
		return null;
	}

	public int getVarIndex() {
		return varIndex;
	}

	public void setVarIndex(int varIndex) {
		this.varIndex = varIndex;
	}
	
	

}
