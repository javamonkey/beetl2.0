package org.beetl.core.statement;

import java.util.LinkedHashMap;

import org.beetl.core.Context;
import org.beetl.core.InferContext;
import org.beetl.core.Tag;
import org.beetl.core.exception.BeetlException;
import org.beetl.ext.tag.HTMLTagVarBindingWrapper;

public class TagVarBindingStatement extends TagStatement
{
	VarDefineNode[] varIndexs;

	public TagVarBindingStatement(String tagName, Expression[] paras, Statement block, VarDefineNode[] varDefine,
			GrammarToken token)
	{
		super(tagName, paras, block, token);
		this.varIndexs = varDefine;
	}

	@Override
	protected void runTag(Tag tag, Context ctx)
	{
		try
		{
			if (tag instanceof HTMLTagVarBindingWrapper)
			{
				HTMLTagVarBindingWrapper htmlTag = (HTMLTagVarBindingWrapper) tag;
				//初始化
				Object[] vars = htmlTag.bindVars();
				if (vars != null)
				{
					for (int i = 0; i < vars.length; i++)
					{
						ctx.vars[varIndexs[i].getVarIndex()] = vars[i];
					}
				}

				LinkedHashMap<String, Integer> indexMap = new LinkedHashMap<String, Integer>(this.varIndexs.length);
				for (VarDefineNode node : this.varIndexs)
				{
					indexMap.put(node.token.text, node.varIndex);
				}
				htmlTag.mapName2Index(indexMap);

			}
			else
			{
				BeetlException be = new BeetlException(BeetlException.ERROR, "tag必须是HTMLTagVarBindingWrapper");
				be.pushToken(this.token);
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
			be.pushToken(token);
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
		for (int i = 0; i < varIndexs.length; i++)
		{
			inferCtx.types[varIndexs[i].getVarIndex()] = Type.ObjectType;
		}
		block.infer(inferCtx);
	}

}
