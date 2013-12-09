package org.beetl.core.statement;

import org.beetl.core.Context;

public class Program {
	//模板的所有脚本语句
	public ProgramMetaData metaData = null;
	public boolean isOptimized = false;
	public BetterPerformancePolicy policy = new BetterPerformancePolicy();
	
	public void execute(Context ctx){
		metaData.initContext(ctx);
		
		if(!isOptimized){
			policy.before(ctx);
		}
		
		
		
		for(ASTNode node:metaData.statements){
			node.run(ctx);
		}
		
	}
	
	
	
}
