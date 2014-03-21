package org.beetl.core.statement;

import java.io.IOException;

import org.beetl.core.Context;
import org.beetl.core.InferContext;
import org.beetl.core.exception.TempException;

public final class PlaceholderST extends Statement
{

	public Expression expression;
	public Type type = null;
	FormatExpression format;

	public PlaceholderST(Expression exp, FormatExpression format, GrammarToken token)
	{
		super(token);
		this.format = format;
		this.expression = exp;

	}

	@Override
	public final void execute(Context ctx)
	{
		Object value = expression.evaluate(ctx);
		try
		{
			if (format != null)
			{
				value = format.evaluateValue(value, ctx);
			}
			ctx.byteWriter.write(value);
		}
		catch (IOException e)
		{
			throw new TempException(e.getMessage());
		}

	}

	@Override
	public void infer(InferContext inferCtx)
	{
		expression.infer(inferCtx);
		this.type = expression.type;
	}

}
