package org.beetl.core.statement;

/**
 * a.[]
 * 
 * @author joelli
 * 
 */
public class VarSquareAttribute extends VarAttribute {
	protected short type = 1;
	Expression exp;

	public VarSquareAttribute(Expression exp, Token token) {
		super(token);
		this.exp = exp;
	}

}
