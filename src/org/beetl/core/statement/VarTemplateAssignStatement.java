package org.beetl.core.statement;

import org.beetl.core.Context;

public class VarTemplateAssignStatement extends Expression {

	BlockStatement block = null;

	public VarTemplateAssignStatement(BlockStatement block, Token token) {
		super(token);
		this.block = block;
	}

	@Override
	public Object evaluate(Context ctx) {
		// 初始化一个临时的bytewrite
		throw new UnsupportedOperationException();
	}

}
