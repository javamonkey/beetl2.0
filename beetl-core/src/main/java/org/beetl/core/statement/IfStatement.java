package org.beetl.core.statement;

import org.beetl.core.Context;
import org.beetl.core.InferContext;

public class IfStatement extends Statement
{

	public Expression condtion;
	public Statement ifStatement;
	public Statement elseStatement;

	public IfStatement(Expression condtion, Statement ifStatement, Statement elseStatement, Token token)
	{
		super(token);
		this.condtion = condtion;
		this.ifStatement = ifStatement;
		this.elseStatement = elseStatement;
		// TODO Auto-generated constructor stub
	}

	@Override
	public void execute(Context ctx)
	{
		// TODO Auto-generated method stub
		Object value = condtion.evaluate(ctx);
		if (ASTNodeUtil.isTrue(value, this))
		{
			ifStatement.execute(ctx);
		}
		else
		{
			if (elseStatement != null)
			{
				elseStatement.execute(ctx);
			}
		}

	}

	public void infer(InferContext inferCtx)
	{
		condtion.infer(inferCtx);
		ifStatement.infer(inferCtx);
		if (elseStatement != null)
		{
			elseStatement.infer(inferCtx);
		}
	}

}
