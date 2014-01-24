package org.beetl.core.statement;

import org.beetl.core.Context;

public class FunctionStatement extends Statement
{

	FunctionExpression fe;

	public FunctionStatement(FunctionExpression fe, Token token)
	{
		super(token);
		this.fe = fe;
	}

	@Override
	public void execute(Context ctx)
	{
		fe.evaluate(ctx);

	}

}
