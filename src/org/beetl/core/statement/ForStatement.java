package org.beetl.core.statement;

import org.beetl.core.Context;
import org.beetl.core.IteratorStatus;

public class ForStatement extends Statement implements IGoto {
	ASTNode idNode;
	Expression exp;
	Statement forPart;
	Statement elseforPart;
	int varIndex = 0;
	boolean hasGoto = false;

	public ForStatement(VarDefineNode idNode, Expression exp, Statement forPart,
			Statement elseforPart, Token token) {
		super(token);
		this.idNode = idNode;
		this.exp = exp;
		this.elseforPart = elseforPart;
		this.forPart = forPart;
		this.varIndex = ((IVarIndex) idNode).getVarIndex();

	}

	public Object run(Context ctx) {
		IteratorStatus it = IteratorStatus.getIteratorStatus(exp.run(ctx), 0);
		ctx.vars[this.varIndex + 1] = it;
		if (this.hasGoto) {

			while (it.hasNext()) {
				ctx.vars[this.varIndex] = it.next();
				forPart.run(ctx);
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

			if (!it.hasData()) {
				elseforPart.run(ctx);
			}
			return null;

		} else {
			while (it.hasNext()) {
				ctx.vars[this.varIndex] = it.next();
				super.run(ctx);

			}
			if (!it.hasData()) {
				elseforPart.run(ctx);
			}
			return null;
		}

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
