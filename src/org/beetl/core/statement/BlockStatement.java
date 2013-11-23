package org.beetl.core.statement;

import org.antlr.v4.runtime.Token;
import org.beetl.core.Context;

public class BlockStatement extends ASTNode {

	ASTNode[] nodes = null;
	public BlockStatement(ASTNode[] nodes,Token token) {
		super(token);
		
		// TODO Auto-generated constructor stub
	}
	public  Object run(Context ctx){
		for(ASTNode node:nodes){
			node.run(ctx);
		}
		return null;
	}


}
