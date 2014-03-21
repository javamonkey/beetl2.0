package org.beetl.core.statement;

import org.beetl.core.Context;
import org.beetl.core.InferContext;

public class StatementExpression extends Statement
{

	Expression exp;

	public StatementExpression(Expression exp, GrammarToken token)
	{
		super(token);
		this.exp = exp;

	}

	@Override
	public void execute(Context ctx)
	{
		exp.evaluate(ctx);

	}

	@Override
	public void infer(InferContext inferCtx)
	{
		exp.infer(inferCtx);

	}

}
