package org.beetl.core.statement;

import org.beetl.core.Context;
import org.beetl.core.InferContext;

public class VarAssignStatementSeq extends Statement
{
	public Statement[] sts;

	public VarAssignStatementSeq(Statement[] sts, GrammarToken token)
	{
		super(token);
		this.sts = sts;
	}

	@Override
	public void execute(Context ctx)
	{
		for (Statement st : sts)
		{
			st.execute(ctx);
		}

	}

	@Override
	public void infer(InferContext inferCtx)
	{
		for (Statement st : sts)
		{
			st.infer(inferCtx);
		}
	}

}
