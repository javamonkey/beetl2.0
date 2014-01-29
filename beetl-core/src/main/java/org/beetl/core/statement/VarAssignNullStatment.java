package org.beetl.core.statement;

import org.beetl.core.Context;
import org.beetl.core.InferContext;

public class VarAssignNullStatment extends Statement
{

	protected int varIndex;

	public VarAssignNullStatment(int varIndex, Token token)
	{
		super(token);
		this.varIndex = varIndex;
	}

	@Override
	public void execute(Context ctx)
	{
		// TODO Auto-generated method stub
		ctx.vars[varIndex] = null;

	}

	@Override
	public void infer(InferContext inferCtx)
	{
		// TODO Auto-generated method stub

	}

}
