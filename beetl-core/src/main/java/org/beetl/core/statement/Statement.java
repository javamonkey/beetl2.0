package org.beetl.core.statement;

import org.beetl.core.Context;

public abstract class Statement extends ASTNode
{

	public Statement(Token token)
	{
		super(token);

	}

	public abstract void execute(Context ctx);

}
