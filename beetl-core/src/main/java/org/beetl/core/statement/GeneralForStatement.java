package org.beetl.core.statement;

import org.beetl.core.Context;
import org.beetl.core.InferContext;

/**
 * @author miaojun
 *
 */
public final class GeneralForStatement extends Statement implements IGoto
{
	public Expression[] expInit;
	public Expression condtion;
	public Expression[] expUpdate;
	public Statement forPart;
	public Statement elseforPart;
	VarAssignStatementSeq varAssignSeq;
	public boolean hasGoto = false;
	public short itType = 0;

	//for(expInit;condtion;expUpdate){}
	public GeneralForStatement(VarAssignStatementSeq varAssignSeq, Expression[] expInit, Expression condtion,
			Expression[] expUpdate, Statement forPart, Statement elseforPart, GrammarToken token)
	{
		super(token);
		this.varAssignSeq = varAssignSeq;
		this.expInit = expInit;
		this.condtion = condtion;
		this.expUpdate = expUpdate;
		this.elseforPart = elseforPart;
		this.forPart = forPart;

	}

	public final void execute(Context ctx)
	{
		if (expInit != null)
		{
			for (Expression exp : expInit)
			{
				exp.evaluate(ctx);
			}
		}
		if (varAssignSeq != null)
		{
			varAssignSeq.execute(ctx);
		}
		//todo 需要提高效率，减少hasLooped赋值，以及每次gotoFlag检测，然而，这个不太常用，目前不优化

		boolean hasLooped = false;
		for (;;)
		{
			boolean bool = (Boolean) condtion.evaluate(ctx);
			if (bool)
			{
				hasLooped = true;
				forPart.execute(ctx);
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

	}

	@Override
	public final boolean hasGoto()
	{
		// TODO Auto-generated method stub
		return hasGoto;
	}

	@Override
	public final void setGoto(boolean occour)
	{
		this.hasGoto = occour;

	}

	@Override
	public void infer(InferContext inferCtx)
	{
		if (expInit != null)
		{
			for (Expression exp : expInit)
			{
				exp.infer(inferCtx);

			}
		}

		if (varAssignSeq != null)
		{
			varAssignSeq.infer(inferCtx);
		}

		if (condtion != null)
		{
			condtion.infer(inferCtx);
		}

		if (expUpdate != null)
		{
			for (Expression exp : expUpdate)
			{
				exp.infer(inferCtx);

			}
		}

		forPart.infer(inferCtx);
		if (elseforPart != null)
		{
			elseforPart.infer(inferCtx);
		}

	}

}
