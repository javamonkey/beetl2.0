package org.beetl.core.statement;


import org.beetl.core.Context;

public class VarAttribute extends ASTNode implements INodeEvalIndex {
	protected int aaIndex = -1;
	protected short type = 0;
	public VarAttribute(Token token) {
		super(token);	
	}

	@Override
	public Object run(Context ctx) {
		return null;
	}

	@Override
	public void setNEI(int index) {
		this.aaIndex = index;
		
	}

	@Override
	public int getNEI(int index) {
		return this.aaIndex ;
	}
	
	

}
