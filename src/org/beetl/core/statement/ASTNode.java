package org.beetl.core.statement;

public abstract class ASTNode implements java.io.Serializable {
	public Token token;

	public ASTNode(Token token) {
		this.token = token;
	}

}
