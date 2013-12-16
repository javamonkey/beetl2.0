package org.beetl.core.statement;

import org.beetl.core.Context;
import org.beetl.core.IteratorStatus;

public class ForStatement extends BlockStatement {
	ASTNode idNode;
	Expression exp;
	Statement[] elsefor;
	int varIndex = 0;

	public ForStatement(ASTNode idNode, Expression exp, Statement[] nodes,
			Statement[] elsefor, Token token) {
		super(nodes, token);
		this.idNode = idNode;
		this.exp = exp;
		this.elsefor = elsefor;
		this.varIndex = ((IVarIndex) idNode).getVarIndex();

	}

	public Object run(Context ctx) {
		IteratorStatus it = IteratorStatus.getIteratorStatus(exp.run(ctx), 0);
		ctx.vars[this.varIndex + 1] = it;
		if (this.hasGoto) {
			while (it.hasNext()) {
				ctx.vars[this.varIndex] = it.next();
				super.run(ctx);
				switch (ctx.gotoFlag) {
				case IGoto.NORMAL:
					break;
				case IGoto.CONTINUE:
					ctx.gotoFlag = IGoto.NORMAL;
					continue;
				case IGoto.RETURN:
					return null;
				case IGoto.BREAK:
					ctx.gotoFlag = IGoto.NORMAL;
					return null;
				}
			}

		} else {
			while (it.hasNext()) {
				ctx.vars[this.varIndex] = it.next();
				super.run(ctx);

			}
		}

		return null;
	}

}
