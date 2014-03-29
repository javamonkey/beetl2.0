package org.beetl.core.exception;

import org.beetl.core.statement.GrammarToken;

public class NativeNotAllowedException extends BeetlException
{

	public NativeNotAllowedException(GrammarToken token)
	{
		super(BeetlException.NATIVE_NOT_ALLOWED);
		this.token = token;
		// TODO Auto-generated constructor stub
	}

}
