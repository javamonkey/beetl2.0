package org.beetl.core.statement;

public class ASTNode implements java.io.Serializable
{
	public Token token;

	public ASTNode(Token token)
	{
		this.token = token;
	}

	public void infer(Type[] types, Object temp)
	{
		throw new UnsupportedOperationException();
	}

}
