package org.beetl.core.statement;

import org.beetl.core.Context;

public class VarAssignStatementSeq extends Statement {
	Statement[] sts;

	public VarAssignStatementSeq(Statement[] sts, Token token) {
		super(token);
		this.sts = sts;
	}

	@Override
	public Object run(Context ctx) {
		for (Statement st : sts) {
			st.run(ctx);
		}
		return null;
	}

}
