package org.beetl.core.statement;

import org.beetl.core.Context;
import org.beetl.core.InferContext;

public class ReturnStatement extends Statement
{

	public ReturnStatement(GrammarToken token)
	{
		super(token);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void execute(Context ctx)
	{
		ctx.gotoFlag = IGoto.RETURN;

	}

	@Override
	public void infer(InferContext inferCtx)
	{
		// TODO Auto-generated method stub

	}

}
