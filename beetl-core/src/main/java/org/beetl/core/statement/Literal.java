package org.beetl.core.statement;

import org.beetl.core.Context;
import org.beetl.core.InferContext;

public class Literal extends Expression
{

	public Object obj = null;

	public Literal(Object value, Token token)
	{
		super(token);
		this.obj = value;

		// TODO Auto-generated constructor stub
	}

	@Override
	public Object evaluate(Context ctx)
	{
		return obj;
	}

	public void infer(InferContext inferCtx)
	{
		this.type = new Type(obj.getClass());
	}

}
