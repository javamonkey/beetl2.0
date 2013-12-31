package org.beetl.core.statement;

import org.beetl.core.Context;
import org.beetl.core.attr.AA;

public class VarAttribute extends Expression {
	protected int aaIndex = -1;
	protected short type = 0;
	protected AA aa = null;

	public VarAttribute(Token token) {
		super(token);
	}

	@Override
	public Object evaluate(Context ctx) {
		return null;
	}

	public void setAA(AA aa) {
		this.aa = aa;
	}

}
