package org.beetl.core.statement;

import org.beetl.core.Context;
import org.beetl.core.InferContext;

public class SafePlaceholderST extends Statement
{

	public Expression exp;

	public SafePlaceholderST(Expression exp, Token token)
	{
		super(token);
		this.exp = exp;
	}

	@Override
	public void execute(Context ctx)
	{
		try
		{
			Object value = exp.evaluate(ctx);
			ctx.byteWriter.write(value);
		}
		catch (Exception ex)
		{

		}

	}

	@Override
	public void infer(InferContext inferCtx)
	{
		// do nothing
	}

}
