package org.beetl.core.statement;


import org.beetl.core.Context;

public class IfStatement extends ASTNode {

	Expression condtion;
	ASTNode ifStatement;
	ASTNode elseStatement;
	public IfStatement(Expression condtion,ASTNode ifStatement,ASTNode elseStatement,Token token) {
		super(token);
		this.condtion = condtion;
		this.ifStatement = ifStatement;
		this.elseStatement = elseStatement;
		// TODO Auto-generated constructor stub
	}

	@Override
	public Object run(Context ctx) {
		// TODO Auto-generated method stub
		Object value = condtion.run(ctx);
		if(ASTNodeUtil.isTrue(value, this)){
			ifStatement.run(ctx);
		}else{
			if(elseStatement!=null){
				elseStatement.run(ctx);
			}
		}
		
		return null;
	}

}
