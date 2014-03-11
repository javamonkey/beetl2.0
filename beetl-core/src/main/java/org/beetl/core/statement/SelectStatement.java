package org.beetl.core.statement;

import org.beetl.core.ALU;
import org.beetl.core.Context;
import org.beetl.core.InferContext;
import org.beetl.core.exception.TempException;

public class SelectStatement extends Statement
{

	Expression value;
	Expression[] conditions;
	BlockStatement[] blocks;
	BlockStatement defaultBlock;

	public SelectStatement(Expression value, Expression[] conditions, BlockStatement[] blocks,
			BlockStatement defaultBlock, Token token)
	{
		super(token);
		this.value = value;
		this.conditions = conditions;
		this.blocks = blocks;
		this.defaultBlock = defaultBlock;
	}

	@Override
	public void execute(Context ctx)
	{
		Object base = null;
		if (value != null)
		{
			base = value.evaluate(ctx);
			if (base == null)
				throw new TempException("不能为空");
		}

		boolean isMatch = false;
		for (int i = 0; i < conditions.length; i++)
		{
			Expression exp = conditions[i];
			Object condValue = exp.evaluate(ctx);

			if (value == null)
			{
				if (condValue instanceof Boolean)
				{
					isMatch = (Boolean) condValue;
				}
				else
				{
					throw new TempException("Case 必须是boolean值");
				}
			}
			else
			{
				if (ALU.equals(base, condValue))
				{
					isMatch = true;
				}
			}

			if (isMatch)
			{

				BlockStatement block = this.blocks[i];
				if (block != null)
				{
					block.execute(ctx);
				}

				break;

			}

		}

		if (!isMatch && defaultBlock != null)
		{
			defaultBlock.execute(ctx);
		}

	}

	@Override
	public void infer(InferContext inferCtx)
	{
		if (value != null)
			value.infer(inferCtx);
		for (Expression exp : conditions)
		{
			exp.infer(inferCtx);
		}

		for (BlockStatement block : this.blocks)
		{
			block.infer(inferCtx);
		}
		if (defaultBlock != null)
		{
			defaultBlock.infer(inferCtx);
		}

	}

}
