package org.beetl.ext.nutz;

import java.io.Writer;

import org.beetl.core.ConsoleErrorHandler;
import org.beetl.core.exception.BeetlException;
import org.nutz.log.Log;
import org.nutz.log.Logs;

/**
 * 通过日志框架来输出日志
 * 
 * @author wendal
 *
 */
public class LogErrorHandler extends ConsoleErrorHandler {

	private static final Log log = Logs.get();

	public void processExcption(BeetlException ex, Writer writer) {
		log.info(ex.getMessage(), ex);
		super.processExcption(ex, writer);
		throw ex;
	}

	protected void println(Writer w, String msg) {
		log.info(msg);
	}

	protected void print(Writer w, String msg) {
		log.info(msg);
	}

	protected void printThrowable(Writer w, Throwable t) {
		// 不进行打印, processExcption已经打印过了
	}
}
