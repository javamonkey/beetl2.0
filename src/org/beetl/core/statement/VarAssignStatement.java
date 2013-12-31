package org.beetl.core.statement;

import org.beetl.core.Context;

public class VarAssignStatement extends Statement implements IVarIndex {

	protected int varIndex;
	Expression exp;

	public VarAssignStatement(Expression exp, Token token) {
		super(token);
		this.varIndex = varIndex;
		this.exp = exp;
	}

	public void execute(Context ctx) {
		ctx.vars[varIndex] = exp.evaluate(ctx);

	}

	public int getVarIndex() {
		return varIndex;
	}

	public void setVarIndex(int varIndex) {
		this.varIndex = varIndex;
	}

}
