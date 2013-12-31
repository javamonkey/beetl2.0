package org.beetl.core.statement;


public abstract class ASTNode {
	public Token token;

	public ASTNode(Token token) {
		this.token = token;
	}

}
