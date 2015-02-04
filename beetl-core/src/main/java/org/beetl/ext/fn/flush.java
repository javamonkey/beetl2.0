package org.beetl.ext.fn;

import java.io.IOException;

import org.beetl.core.Context;
import org.beetl.core.Function;
import org.beetl.core.exception.BeetlException;

public class Flush implements Function
{

	@Override
	public Object call(Object[] paras, Context ctx)
	{
		try
		{
			ctx.byteWriter.flush();
			return null;
		}
		catch (IOException e)
		{
			BeetlException be = new BeetlException(BeetlException.CLIENT_IO_ERROR_ERROR, e.getMessage(), e);
			throw be;
		}
	}

}
