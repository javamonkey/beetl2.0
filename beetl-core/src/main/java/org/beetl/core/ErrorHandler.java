package org.beetl.core;

import java.io.Writer;

import org.beetl.core.exception.BeetlException;

/**
 * 当模板语法错或者运行错的时候，GroupTemplate默认将使用DefaultErrorHandler来处理错误
 * 
 * @author joelli
 * @since 2.0
 *
 */
public interface ErrorHandler
{

	/** 处理错误，错误输出到os流
	 * @param beeException
	 * @param os
	 */
	public void processExcption(BeetlException beeExceptionos, Writer writer);

}