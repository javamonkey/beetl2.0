package org.beetl.core.statement;

import org.beetl.core.Context;
import org.beetl.core.InferContext;

public class SafePlaceholderST extends Statement
{

	public Expression exp;
	FormatExpression format;

	public SafePlaceholderST(Expression exp, FormatExpression format, GrammarToken token)
	{
		super(token);
		this.exp = exp;
		this.format = format;
	}

	@Override
	public void execute(Context ctx)
	{
		try
		{
			Object value = exp.evaluate(ctx);
			if (format != null)
			{
				value = format.evaluateValue(value, ctx);
			}
			ctx.byteWriter.write(value);
		}
		catch (Exception ex)
		{
			//
		}

	}

	@Override
	public void infer(InferContext inferCtx)
	{
		// do nothing
	}

}
