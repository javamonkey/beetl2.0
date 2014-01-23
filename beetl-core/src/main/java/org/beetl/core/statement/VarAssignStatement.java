package org.beetl.core.statement;

import org.beetl.core.Context;
import org.beetl.core.InferContext;

public class VarAssignStatement extends Statement implements IVarIndex
{

	protected int varIndex;
	public Expression exp;

	public VarAssignStatement(Expression exp, Token token)
	{
		super(token);
		this.exp = exp;
	}

	public void execute(Context ctx)
	{
		ctx.vars[varIndex] = exp.evaluate(ctx);

	}

	public int getVarIndex()
	{
		return varIndex;
	}

	public void setVarIndex(int varIndex)
	{
		this.varIndex = varIndex;
	}

	public void infer(InferContext inferCtx)
	{
		exp.infer(inferCtx);
		inferCtx.types[varIndex] = exp.type;
	}

}
