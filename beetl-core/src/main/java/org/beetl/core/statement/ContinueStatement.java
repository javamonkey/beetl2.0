package org.beetl.core.statement;

import org.beetl.core.Context;
import org.beetl.core.InferContext;

public class ContinueStatement extends Statement
{

	public ContinueStatement(GrammarToken token)
	{
		super(token);
		// TODO Auto-generated constructor stub
	}

	@Override
	public final void execute(Context ctx)
	{
		ctx.gotoFlag = IGoto.CONTINUE;

	}

	@Override
	public void infer(InferContext inferCtx)
	{
		// TODO Auto-generated method stub

	}

}
