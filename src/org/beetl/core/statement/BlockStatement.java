package org.beetl.core.statement;

import org.beetl.core.Context;

public class BlockStatement extends Statement {

	ASTNode[] nodes = null;

	public BlockStatement(ASTNode[] nodes, Token token) {
		super(token);

		// TODO Auto-generated constructor stub
	}

	public Object run(Context ctx) {
		for (ASTNode node : nodes) {
			node.run(ctx);
		}
		return null;
	}

}
