package org.beetl.core.statement;

import org.beetl.core.Context;
import org.beetl.core.InferContext;

public class VarTemplateAssignStatement extends Expression
{

	public BlockStatement block = null;

	public VarTemplateAssignStatement(BlockStatement block, Token token)
	{
		super(token);
		this.block = block;
	}

	@Override
	public Object evaluate(Context ctx)
	{
		// 初始化一个临时的bytewrite
		throw new UnsupportedOperationException();
	}

	@Override
	public void infer(InferContext inferCtx)
	{
		// 初始化一个临时的bytewrite
		throw new UnsupportedOperationException();

	}

}
