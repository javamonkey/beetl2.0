package org.beetl.core.statement;

import org.beetl.core.Context;
import org.beetl.core.InferContext;

public class Literal extends Expression implements Comparable
{

	public Object obj = null;
	public static final Literal NULLLiteral = new Literal(null, null);

	public Literal(Object value, GrammarToken token)
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
		if (obj != null)
		{
			if (obj instanceof Number)
			{
				this.type = Type.NumberType;
			}
			else
			{
				this.type = new Type(obj.getClass());
			}

		}
		else
		{
			this.type = Type.NULLType;
		}

	}

	@Override
	public int compareTo(Object o)
	{
		Literal l = (Literal) o;
		Comparable a = (Comparable) this.obj;
		return a.compareTo(l.obj);

	}
}
