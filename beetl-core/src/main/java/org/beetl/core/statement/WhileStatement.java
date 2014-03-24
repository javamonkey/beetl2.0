package org.beetl.core.statement;

import org.beetl.core.Context;
import org.beetl.core.InferContext;
import org.beetl.core.exception.BeetlException;

public class WhileStatement extends Statement implements IGoto
{

	Expression exp;
	Statement whileBody;
	public boolean hasGoto = false;

	public WhileStatement(Expression exp, Statement whileBody, GrammarToken token)
	{
		super(token);
		this.exp = exp;
		this.whileBody = whileBody;
		if (this.whileBody instanceof BlockStatement)
		{
			this.hasGoto = ((BlockStatement) whileBody).hasGoto;
		}
	}

	@Override
	public void execute(Context ctx)
	{
		if (this.hasGoto)
		{
			while (true)
			{
				Object result = exp.evaluate(ctx);
				if (result instanceof Boolean)
				{
					if ((Boolean) result)
					{
						whileBody.execute(ctx);
						switch (ctx.gotoFlag)
						{
							case IGoto.NORMAL:
								break;
							case IGoto.CONTINUE:
								ctx.gotoFlag = IGoto.NORMAL;
								continue;
							case IGoto.RETURN:
								return;
							case IGoto.BREAK:
								ctx.gotoFlag = IGoto.NORMAL;
								return;
						}
					}
					else
					{
						break;
					}

				}
				else
				{
					BeetlException be = new BeetlException(BeetlException.BOOLEAN_EXPECTED_ERROR);
					be.token = exp.token;
					throw be;
				}

			}
		}
		else
		{

			while (true)
			{
				Object result = exp.evaluate(ctx);
				if (result instanceof Boolean)
				{
					if ((Boolean) result)
					{
						whileBody.execute(ctx);

					}
					else
					{
						break;
					}

				}
				else
				{
					BeetlException be = new BeetlException(BeetlException.BOOLEAN_EXPECTED_ERROR);
					be.token = exp.token;
					throw be;
				}
			}

		}
	}

	@Override
	public void infer(InferContext inferCtx)
	{
		exp.infer(inferCtx);
		whileBody.infer(inferCtx);

	}

	@Override
	public boolean hasGoto()
	{
		return this.hasGoto;
	}

	@Override
	public void setGoto(boolean occour)
	{
		this.hasGoto = occour;

	}

}
