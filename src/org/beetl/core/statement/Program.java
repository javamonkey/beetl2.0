package org.beetl.core.statement;

import org.beetl.core.Context;

public class Program {
	//模板的所有脚本语句
	ProgramMetaData metaData = null;
	boolean isOptimized = false;
	BetterPerformancePolicy policy = new BetterPerformancePolicy();
	
	public void execute(Context ctx){
		if(!isOptimized){
			policy.before(this, ctx);
		}
		
		metaData.initContext(ctx);
		
		for(ASTNode node:metaData.statements){
			node.run(ctx);
		}
		
	}
	
	
	
}
