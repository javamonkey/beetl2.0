package org.beetl.core.statement;

import org.beetl.core.Context;
import org.beetl.core.InferContext;

public class FunctionStatement extends Statement
{

	FunctionExpression fe;

	public FunctionStatement(FunctionExpression fe, GrammarToken token)
	{
		super(token);
		this.fe = fe;
	}

	@Override
	public void execute(Context ctx)
	{
		fe.evaluate(ctx);

	}

	@Override
	public void infer(InferContext inferCtx)
	{
		fe.infer(inferCtx);

	}

}
