package org.beetl.core.statement;

import org.beetl.core.Context;
import org.beetl.core.InferContext;
import org.beetl.core.Tag;
import org.beetl.core.TagFactory;
import org.beetl.core.util.ObjectUtil;

public class TagStatement extends Statement
{
	TagFactory tagFactory;
	Expression[] paras;
	Statement block;

	public TagStatement(TagFactory tagFactory, Expression[] paras, Statement block, Token token)
	{
		super(token);
		this.tagFactory = tagFactory;
		this.paras = paras;
		this.block = block;

	}

	@Override
	public void execute(Context ctx)
	{
		Tag tag = this.tagFactory.createTag();
		Object[] args = null;
		if (paras.length == 0)
		{
			args = ObjectUtil.EMPTY_OBJECT_ARRAY;
		}
		else
		{
			args = new Object[paras.length];
			for (int i = 0; i < args.length; i++)
			{
				args[i] = paras[i].evaluate(ctx);
			}

		}

		tag.init(ctx, args, block);
		tag.render();

	}

	@Override
	public void infer(InferContext inferCtx)
	{
		for (Expression exp : paras)
		{
			exp.infer(inferCtx);
		}
		block.infer(inferCtx);

	}

}
