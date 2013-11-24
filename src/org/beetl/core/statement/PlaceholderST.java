package org.beetl.core.statement;


import org.beetl.core.Context;

public class PlaceholderST extends ASTNode {

	Expression expression;
	boolean isSafe = false;
	public PlaceholderST(Expression exp,boolean isSafe,Token token) {
		super(token);
		this.expression = exp;
		this.isSafe = isSafe;
		// TODO Auto-generated constructor stub
	}

	@Override
	public Object run(Context ctx) {
		if(isSafe){
			try{
				Object value = expression.run(ctx);
				ctx.byteWriter.writePlaceholderContent(value);
			}catch(Exception ex){
				//什么都不做
			}
		}else{
			Object value = expression.run(ctx);
			ctx.byteWriter.writePlaceholderContent(value);
		
		}
		
		return null;
	}

}
