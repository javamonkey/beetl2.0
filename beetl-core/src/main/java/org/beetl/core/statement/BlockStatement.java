package org.beetl.core.statement;

import org.beetl.core.Context;

public class BlockStatement extends Statement implements IGoto
{

	public Statement[] nodes = null;
	boolean hasGoto = false;

	public BlockStatement(Statement[] nodes, Token token)
	{
		super(token);
		this.nodes = nodes;
	}

	public void execute(Context ctx)
	{
		if (this.hasGoto)
		{
			for (Statement node : nodes)
			{
				node.execute(ctx);
				if (ctx.gotoFlag != 0)
				{
					return;
				}

			}
		}
		else
		{
			for (Statement node : nodes)
			{
				node.execute(ctx);
			}
		}

		return;
	}

	@Override
	public boolean hasGoto()
	{
		// TODO Auto-generated method stub
		return hasGoto;
	}

	@Override
	public void setGoto(boolean occour)
	{
		this.hasGoto = occour;

	}

	@Override
	public void infer(Type[] types, Object temp)
	{
		for (Statement st : nodes)
		{
			st.infer(types, temp);
		}
	}

}
