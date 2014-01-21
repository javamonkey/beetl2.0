package org.beetl.core.statement;

import java.io.IOException;

import org.beetl.core.Context;
import org.beetl.core.exception.TempException;

public final class PlaceholderST extends Statement
{

	public Expression expression;

	public PlaceholderST(Expression exp, Token token)
	{
		super(token);
		this.expression = exp;

	}

	@Override
	public final void execute(Context ctx)
	{
		Object value = expression.evaluate(ctx);
		try
		{
			ctx.byteWriter.write(value);
		}
		catch (IOException e)
		{
			throw new TempException(e.getMessage());
		}

	}

	@Override
	public void infer(Type[] types, Object temp)
	{
		expression.infer(types, temp);
	}

}
