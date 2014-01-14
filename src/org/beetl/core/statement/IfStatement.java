package org.beetl.core.statement;

import org.beetl.core.Context;

public class IfStatement extends Statement {

	public Expression condtion;
	public Statement ifStatement;
	public Statement elseStatement;

	public IfStatement(Expression condtion, Statement ifStatement,
			Statement elseStatement, Token token) {
		super(token);
		this.condtion = condtion;
		this.ifStatement = ifStatement;
		this.elseStatement = elseStatement;
		// TODO Auto-generated constructor stub
	}

	@Override
	public void execute(Context ctx) {
		// TODO Auto-generated method stub
		Object value = condtion.evaluate(ctx);
		if (ASTNodeUtil.isTrue(value, this)) {
			ifStatement.execute(ctx);
		} else {
			if (elseStatement != null) {
				elseStatement.execute(ctx);
			}
		}

	}

	public void infer(Type[] types, Object temp) {
		condtion.infer(types, temp);
		ifStatement.infer(types, temp);
		if (elseStatement != null) {
			elseStatement.infer(types, temp);
		}
	}

}
