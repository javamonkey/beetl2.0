package org.beetl.core.statement;

import org.beetl.core.InferContext;

public abstract class ASTNode implements java.io.Serializable
{
	public Token token;

	public ASTNode(Token token)
	{
		this.token = token;
	}

	public abstract void infer(InferContext inferCtx);

}
