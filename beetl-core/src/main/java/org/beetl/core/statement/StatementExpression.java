package org.beetl.core.statement;

import org.beetl.core.Context;
import org.beetl.core.InferContext;

/**
 * 表达式语句，如fun();
 * @author joelli
 *
 */
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
