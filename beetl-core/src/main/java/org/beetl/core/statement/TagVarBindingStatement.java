package org.beetl.core.statement;

import org.beetl.core.Context;
import org.beetl.core.InferContext;
import org.beetl.core.Tag;
import org.beetl.core.TagFactory;
import org.beetl.core.TagVarBinding;
import org.beetl.core.exception.BeetlException;

public class TagVarBindingStatement extends TagStatement
{
	IVarIndex[] varIndexs;

	public TagVarBindingStatement(TagFactory tagFactory, Expression[] paras, Statement block,
			VarDefineNode[] varDefine, GrammarToken token)
	{
		super(tagFactory, paras, block, token);
		this.varIndexs = varDefine;
	}

	@Override
	protected void runTag(Tag tag, Context ctx)
	{
		try
		{
			if (tag instanceof TagVarBinding)
			{
				Object[] vars = ((TagVarBinding) tag).bindVars();
				for (int i = 0; i < vars.length; i++)
				{
					ctx.vars[varIndexs[i].getVarIndex()] = vars[i];
				}
			}
			else
			{
				BeetlException be = new BeetlException(BeetlException.ERROR, "tag必须是TagVarBinding子类");
				be.token = this.token;
				throw be;
			}
			tag.render();
		}
		catch (BeetlException ex)
		{
			//BeetlException异常时不要设置token，因为抛出的地方已经设置了
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
		super.infer(inferCtx);
		for (int i = 0; i < varIndexs.length; i++)
		{
			inferCtx.types[varIndexs[i].getVarIndex()] = Type.ObjectType;
		}

	}

}
