package org.beetl.core.statement;

import org.beetl.core.Context;

public class VarAssignStatementSeq extends Statement {
	public Statement[] sts;

	public VarAssignStatementSeq(Statement[] sts, Token token) {
		super(token);
		this.sts = sts;
	}

	@Override
	public void execute(Context ctx) {
		for (Statement st : sts) {
			st.execute(ctx);
		}

	}

	@Override
	public void infer(Type[] types, Object temp) {
		for (Statement st : sts) {
			st.infer(types, temp);
		}
	}

}
