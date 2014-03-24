package org.beetl.core.statement;

import org.beetl.core.Context;
import org.beetl.core.InferContext;
import org.beetl.core.Tag;
import org.beetl.core.TagFactory;
import org.beetl.core.exception.BeetlException;
import org.beetl.core.util.ObjectUtil;

public class TagStatement extends Statement
{
	TagFactory tagFactory;
	Expression[] paras;
	Statement block;

	public TagStatement(TagFactory tagFactory, Expression[] paras, Statement block, GrammarToken token)
	{
		super(token);
		this.tagFactory = tagFactory;
		this.paras = paras;
		this.block = block;

	}

	@Override
	public void execute(Context ctx)
	{
		Tag tag = null;
		try
		{
			tag = this.tagFactory.createTag();
		}
		catch (BeetlException ex)
		{
			ex.token = this.token;
			throw ex;
		}
		catch (RuntimeException ex)
		{
			BeetlException bex = new BeetlException(BeetlException.TAG_INSTANCE_ERROR, ex.getMessage(), ex);
			bex.token = this.token;
			throw bex;
		}

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
		try
		{
			tag.render();
		}
		catch (BeetlException ex)
		{
			ex.token = this.token;
			throw ex;
		}
		catch (RuntimeException ex)
		{
			BeetlException be = new BeetlException(BeetlException.ERROR, "tag执行抛错", ex);
			be.token = this.token;
			throw be;
		}

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
