package org.beetl.core.statement;

import org.beetl.core.Context;
import org.beetl.core.attr.AA;
import org.beetl.core.exception.TempException;

public class VarRef extends Expression implements IVarIndex {

	VarAttribute[] attributes;
	Expression safe = null;
	int varIndex;

	public VarRef(VarAttribute[] attributes, Expression safe, Token token) {
		super(token);

		this.attributes = attributes;
		this.safe = safe;
		// TODO Auto-generated constructor stub
	}

	@Override
	public Object run(Context ctx) {
		// TODO Auto-generated method stub
		Object value = ctx.vars[varIndex];
		if (value == null || value == Context.NOT_EXIST_OBJECT) {
			if (safe != null) {
				return safe.run(ctx);
			} else {
				throw new TempException("未定义或者是空" + this.token.text);
			}
		}

		if (attributes.length == 0) {
			return value;
		}
		Object attrExp = null;
		for (VarAttribute attr : attributes) {
			switch (attr.type) {

			case 0: // 普通属性访问
				attrExp = attr.token.text;
				break;
			case 1: // map or list
				attrExp = ((VarSquareAttribute) attr).exp.run(ctx);
				break;
			case 2:
				// 虚拟属性，待定

			}

			AA accessor = (AA) ctx.cachedArray[attr.aaIndex];
			value = accessor.value(value, attrExp);
			if (value == null && safe != null) {
				return safe.run(ctx);
			}
		}
		return value;

	}

	@Override
	public void setVarIndex(int index) {
		this.varIndex = index;

	}

	@Override
	public int getVarIndex() {
		return this.varIndex;
	}

}
