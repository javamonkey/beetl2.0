package org.beetl.core.statement;

import org.beetl.core.Context;
import org.beetl.core.InferContext;

public class TernaryExpression extends Expression
{

	public Expression condtion;
	public Expression a;
	public Expression b;

	public TernaryExpression(Expression condtion, Expression a, Expression b, GrammarToken token)
	{
		super(token);
		this.condtion = condtion;
		this.a = a;
		this.b = b;

	}

	public Object evaluate(Context ctx)
	{
		boolean cond = (Boolean) condtion.evaluate(ctx);
		if (cond)
		{
			if (a != null)
			{
				return a.evaluate(ctx);
			}
			else
			{
				return null;
			}
		}
		else
		{
			if (b != null)
			{
				return b.evaluate(ctx);
			}
			else
			{
				return null;
			}
		}

	}

	public void infer(InferContext inferCtx)
	{
		condtion.infer(inferCtx);
		if (a != null)
		{
			a.infer(inferCtx);
			if (b == null)
			{
				this.type = a.type;
				return;
			}
		}
		if (b != null)
		{
			b.infer(inferCtx);
			if (a == null)
			{
				this.type = b.type;
				return;
			}
		}

		if (a.type.equals(b.type))
		{
			this.type = a.type;
		}
		else
		{
			// 能优化成共同的接口或者父类？
			this.type = Type.ObjectType;
		}

	}

}
