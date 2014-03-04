package org.beetl.core.statement;

import org.beetl.core.ByteWriter;
import org.beetl.core.Context;
import org.beetl.core.InferContext;

public class ContentBodyExpression extends Expression
{

	public BlockStatement block;

	public ContentBodyExpression(BlockStatement block, Token token)
	{
		super(token);
		// TODO Auto-generated constructor stub
	}

	public Object evaluate(Context ctx)
	{
		ByteWriter real = ctx.byteWriter;
		ByteWriter temp = real.getTempWriter();
		ctx.byteWriter = temp;
		block.execute(ctx);
		ctx.byteWriter = real;
		return temp.getTempConent();

	}

	@Override
	public void infer(InferContext inferCtx)
	{
		block.infer(inferCtx);
		this.type = Type.BodyContentType;

	}

}
