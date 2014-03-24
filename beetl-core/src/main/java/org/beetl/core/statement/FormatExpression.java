package org.beetl.core.statement;

import org.beetl.core.Context;
import org.beetl.core.Format;
import org.beetl.core.InferContext;
import org.beetl.core.exception.BeetlException;

/**
 * 
 * @author joelli
 *
 */
public class FormatExpression extends Expression
{
	String name;
	String pattern;

	public FormatExpression(String name, String pattern, GrammarToken token)
	{
		super(token);
		this.name = name;
		this.pattern = pattern;
	}

	public Object evaluate(Context ctx)
	{
		throw new UnsupportedOperationException();
	}

	public Object evaluateValue(Object o, Context ctx)
	{

		Format format = null;
		if (name != null)
		{
			format = ctx.gt.getFormat(name);
		}
		else
		{
			if (o == null)
				return null;
			format = ctx.gt.getDefaultFormat(o.getClass());
		}

		if (format == null)
		{
			BeetlException ex = new BeetlException(BeetlException.FORMAT_NOT_FOUND);
			ex.token = token;
			throw ex;
		}

		return format.format(o, pattern);

	}

	public void infer(InferContext inferCtx)
	{
		throw new UnsupportedOperationException();
	}

}
