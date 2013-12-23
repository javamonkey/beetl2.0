package org.beetl.core.statement;

import org.beetl.core.Context;

public class BlockStatement extends Statement implements IGoto {

	Statement[] nodes = null;
	boolean hasGoto = false;

	public BlockStatement(Statement[] nodes, Token token) {
		super(token);
		this.nodes = nodes;
	}

	public Object run(Context ctx) {
		if (this.hasGoto) {
			for (ASTNode node : nodes) {
				node.run(ctx);
				if (ctx.gotoFlag != 0) {
					return null;
				}

			}
		} else {
			for (ASTNode node : nodes) {
				node.run(ctx);
			}
		}

		return null;
	}

	@Override
	public boolean hasGoto() {
		// TODO Auto-generated method stub
		return hasGoto;
	}

	@Override
	public void setGoto(boolean occour) {
		this.hasGoto = occour;

	}

}
