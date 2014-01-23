package org.beetl.core.statement;

import org.beetl.core.InferContext;

public class ASTNode implements java.io.Serializable
{
	public Token token;

	public ASTNode(Token token)
	{
		this.token = token;
	}

	public void infer(InferContext inferCtx)
	{
		throw new UnsupportedOperationException();
	}

}
