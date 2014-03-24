package org.beetl.core.statement;

import org.beetl.core.ALU;
import org.beetl.core.Context;
import org.beetl.core.InferContext;

public class AndExpression extends Expression
{

	Expression exp1, exp2;

	public AndExpression(Expression exp1, Expression exp2, GrammarToken token)
	{
		super(token);
		this.exp1 = exp1;
		this.exp2 = exp2;
	}

	public final Object evaluate(Context ctx)
	{
		if (ALU.isTrue(exp1.evaluate(ctx), exp1))
		{
			return ALU.isTrue(exp2.evaluate(ctx), exp2);
		}
		else
		{
			return Boolean.FALSE;
		}
	}

	@Override
	public void infer(InferContext inferCtx)
	{
		exp1.infer(inferCtx);
		exp2.infer(inferCtx);

	}

}
