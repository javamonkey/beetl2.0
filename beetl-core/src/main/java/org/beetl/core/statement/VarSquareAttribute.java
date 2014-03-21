package org.beetl.core.statement;

import org.beetl.core.Context;
import org.beetl.core.InferContext;

/**
 * a.[]
 * 
 * @author joelli
 * 
 */
public class VarSquareAttribute extends VarAttribute
{
	public Expression exp;

	public VarSquareAttribute(Expression exp, GrammarToken token)
	{
		super(token);
		this.exp = exp;
	}

	@Override
	public Object evaluate(Context ctx)
	{
		throw new UnsupportedOperationException();
	}

	public Object evaluate(Context ctx, Object o)
	{
		Object value = exp.evaluate(ctx);
		return aa.value(o, value);
	}

	public void infer(InferContext inferCtx)
	{
		Type type = (Type) inferCtx.temp;
		Type[] tps = type.types;
		if (tps != null)
		{
			if (tps.length == 1)
			{
				this.type = tps[0];
				return;
			}
			else if (tps.length == 2)
			{
				this.type = tps[1];
				return;
			}
		}
		this.type = Type.ObjectType;

	}

}
