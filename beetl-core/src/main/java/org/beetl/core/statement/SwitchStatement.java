package org.beetl.core.statement;

import java.util.Map.Entry;
import java.util.TreeMap;

import org.beetl.core.Context;
import org.beetl.core.InferContext;
import org.beetl.core.exception.TempException;

public class SwitchStatement extends Statement
{
	Expression value;
	TreeMap<Expression, BlockStatement> map;
	//为了类型推测方便，实际上只要map就可以了
	Expression[] condtionsList;
	BlockStatement[] blocks;
	//------------
	BlockStatement defaultBlock;

	public SwitchStatement(Expression value, TreeMap<Expression, BlockStatement> map, BlockStatement defaultBlock,
			Token token)
	{
		super(token);
		this.map = map;
		this.value = value;
		this.condtionsList = map.keySet().toArray(new Expression[0]);
		this.blocks = map.values().toArray(new BlockStatement[0]);
		this.defaultBlock = defaultBlock;
	}

	@Override
	public void execute(Context ctx)
	{
		Object o = value.evaluate(ctx);
		if (o == null)
			throw new TempException("不能为空");
		boolean isMatch = false;
		for (Expression exp : condtionsList)
		{
			if (isMatch || o.equals(exp.evaluate(ctx)))
			{
				isMatch = true;
				BlockStatement block = map.get(exp);
				if (block != null)
				{
					block.execute(ctx);
					switch (ctx.gotoFlag)
					{
						case IGoto.NORMAL:
							break;
						case IGoto.RETURN:
							return;
						case IGoto.BREAK:
							ctx.gotoFlag = IGoto.NORMAL;
							return;
					}
				}
				else
				{
					// 匹配下一个Block
					continue;
				}
			}
			else
			{
				continue;
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
		value.infer(inferCtx);
		for (Entry<Expression, BlockStatement> entry : map.entrySet())
		{
			entry.getKey().infer(inferCtx);
			BlockStatement block = entry.getValue();
			if (block != null)
			{
				block.infer(inferCtx);
			}

		}

		if (defaultBlock != null)
		{
			defaultBlock.infer(inferCtx);
		}

	}

}
