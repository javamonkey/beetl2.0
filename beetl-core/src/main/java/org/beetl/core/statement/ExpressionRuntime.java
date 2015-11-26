package org.beetl.core.statement;

import org.beetl.core.Context;
import org.beetl.core.InferContext;

public class ExpressionRuntime extends Expression {

	public Expression express;
	public ExpressionRuntime(Expression express){
		super(express.token);
		this.express = express;
	}
	
	public Object evaluate(Context ctx){
		//并么有实际运算，
		return new  ExpressionRuntimeObject(this);
	}
	
	@Override
	public void infer(InferContext inferCtx) {
		express.infer(inferCtx);

	}

	public static class ExpressionRuntimeObject {
		ExpressionRuntime runtime ;
		public ExpressionRuntimeObject(ExpressionRuntime runtime){
			this.runtime = runtime;
		}
		
		public Object get(Context ctx){
			return runtime.express.evaluate(ctx);
		}
	}
}
