package org.beetl.core.statement;

import org.beetl.core.InferContext;

public abstract class ASTNode implements java.io.Serializable
{
	public GrammarToken token;

	public ASTNode(GrammarToken token)
	{
		this.token = token;
	}

	public abstract void infer(InferContext inferCtx);

}
