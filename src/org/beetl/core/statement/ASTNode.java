package org.beetl.core.statement;

import org.antlr.v4.runtime.Token;
import org.beetl.core.Context;

public  abstract class ASTNode {
	public Token token ;
	public int refIndex;	
	public Object cachedValue;
	public ASTNode(Token token){
		this.token = token;
	}
	
	/**执行此节点
	 * @param ctx
	 */
	public abstract Object run(Context ctx);
	
	/**
	 * 推测此节点类型
	 * @param ctx
	 */
	public void infer(Context ctx){
		
	}
	
	/**转节点到java代码
	 * @param ctx
	 */
	public void writeCode(Context ctx){
		
	}
	
	
}
