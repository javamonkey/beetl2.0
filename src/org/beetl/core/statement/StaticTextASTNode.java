package org.beetl.core.statement;


import org.beetl.core.Context;

public class StaticTextASTNode extends ASTNode {

	int textIndex;
	public StaticTextASTNode(int textIndex,Token token) {
		super(token);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Object run(Context ctx) {
		// TODO 先不考虑字节还是字符
		ctx.byteWriter.writeStaticContent(ctx.staticTextArray[textIndex]);
		return null;
		
	}

}
