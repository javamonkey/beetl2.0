package org.beetl.core.statement;

import org.beetl.core.Context;

public class VarTemplateAssignStatement extends ASTNode{

	BlockStatement block = null;
	
	public VarTemplateAssignStatement(BlockStatement block,Token token) {
		super(token);
		this.block = block;
	}

	@Override
	public Object run(Context ctx) {
		//初始化一个临时的bytewrite
		throw new UnsupportedOperationException();
	}

}
