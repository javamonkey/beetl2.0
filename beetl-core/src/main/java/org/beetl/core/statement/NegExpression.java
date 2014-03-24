package org.beetl.core.statement;

import org.beetl.core.ALU;
import org.beetl.core.Context;
import org.beetl.core.InferContext;

public class NegExpression extends Expression
{

	Expression exp;

	public NegExpression(Expression exp, GrammarToken token)
	{
		super(token);
		this.exp = exp;

	}

	public final Object evaluate(Context ctx)
	{
		return ALU.negative(exp.evaluate(ctx), exp);

	}

	@Override
	public void infer(InferContext inferCtx)
	{
		exp.infer(inferCtx);

	}

}
