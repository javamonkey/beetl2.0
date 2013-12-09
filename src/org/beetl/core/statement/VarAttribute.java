package org.beetl.core.statement;


import org.beetl.core.Context;

public class VarAttribute extends ASTNode implements IAAIndex {
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
	public void setAAIndex(int index) {
		this.aaIndex = index;
		
	}

	@Override
	public int getAAIndex(int index) {
		return this.aaIndex ;
	}
	
	

}
