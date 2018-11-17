package org.beetl.core.statement;

import org.beetl.core.Context;

/**
 * var c 
 * @author joelli
 *
 */
public class VarDefineNode extends Expression implements IVarIndex {

	int varIndex = 0;

	public VarDefineNode(GrammarToken token) {
		super(token);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Object evaluate(Context ctx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setVarIndex(int index) {
		this.varIndex = index;

	}

	@Override
	public int getVarIndex() {
		return varIndex;
	}

}
