package org.beetl.core.statement;


import org.beetl.core.Context;

public  abstract class ASTNode {
	public Token token ;	
	public ASTNode(Token token){
		this.token = token;
	}
	
	/**执行此节点
	 * @param ctx
	 */
	public abstract Object run(Context ctx);
	
	/**
	 * 节点优化，用于优化引擎
	 * @param ctx
	 */
	public void optimize(Context ctx){
		
	}
	
	
	
	
}
