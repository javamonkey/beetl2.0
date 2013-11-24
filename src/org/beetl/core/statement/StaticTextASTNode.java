package org.beetl.core.statement;


import org.beetl.core.Context;

public class StaticTextASTNode extends ASTNode {

	public StaticTextASTNode(Token token) {
		super(token);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Object run(Context ctx) {
		// TODO Auto-generated method stub
		ctx.byteWriter.writeStaticContent(this.cachedValue);
		return null;
		
	}

}
