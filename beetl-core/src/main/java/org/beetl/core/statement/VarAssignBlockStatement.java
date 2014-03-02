package org.beetl.core.statement;

import org.beetl.core.ByteWriter;
import org.beetl.core.Context;
import org.beetl.core.InferContext;

public class VarAssignBlockStatement extends Statement implements IVarIndex
{
	protected int varIndex;
	public BlockStatement block;

	public VarAssignBlockStatement(BlockStatement block, Token token)
	{
		super(token);
		this.block = block;
		// TODO Auto-generated constructor stub
	}

	public void execute(Context ctx)
	{

		ByteWriter real = ctx.byteWriter;
		ByteWriter temp = real.getTempWriter();
		ctx.byteWriter = temp;
		block.execute(ctx);
		ctx.vars[varIndex] = temp.getTempConent();
		ctx.byteWriter = real;

	}

	public int getVarIndex()
	{
		return varIndex;
	}

	public void setVarIndex(int varIndex)
	{
		this.varIndex = varIndex;
	}

	public void infer(InferContext inferCtx)
	{
		block.infer(inferCtx);
		inferCtx.types[varIndex] = Type.BodyContentType;
	}

}
