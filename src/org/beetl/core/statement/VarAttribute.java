package org.beetl.core.statement;

import org.beetl.core.Context;
import org.beetl.core.attr.AA;

public class VarAttribute extends Expression {
	public int aaIndex = -1;
	public AA aa = null;

	public VarAttribute(Token token) {
		super(token);
	}

	@Override
	public Object evaluate(Context ctx) {
		throw new UnsupportedOperationException();
	}

	public void setAA(AA aa) {
		this.aa = aa;
	}

	@Override
	public void infer(Type[] types, Object temp) {
		Type type = (Type) temp;
		String attrName = token.text;
		this.type = type.getType(attrName);
	}

}
