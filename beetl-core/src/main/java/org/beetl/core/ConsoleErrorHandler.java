package org.beetl.core;

import java.io.IOException;
import java.io.Writer;

import org.beetl.core.exception.BeetlException;
import org.beetl.core.exception.ErrorInfo;

/** 向控制台输出错误
 * @author joelli
 *
 */
public class ConsoleErrorHandler implements ErrorHandler
{

	@Override
	public void processExcption(BeetlException ex, Writer writer)
	{

		ErrorInfo error = new ErrorInfo(ex);
		int line = error.getErrorTokenLine();
		StringBuilder sb = new StringBuilder(">>").append(error.getType()).append(":")
				.append(error.getErrorTokenText()).append(" 位于").append(line).append("行");
		println(writer, sb.toString());
		ResourceLoader resLoader = ex.gt.getResourceLoader();
		//潜在问题，此时可能得到是一个新的模板，不过可能性很小，忽略！
		Resource res = resLoader.getResource(ex.resourceId);
		//显示前后三行的内容
		int[] range = this.getRange(line);

		String content = null;
		;
		try
		{
			content = res.getContent(range[0], range[1]);
		}
		catch (IOException e)
		{

			//todo:如何处理这种情况？
			e.printStackTrace();

		}
		if (content != null)
		{
			String[] strs = content.split(ex.cr);
			int lineNumber = range[0];
			for (int i = 0; i < strs.length; i++)
			{
				print(writer, "" + lineNumber);
				print(writer, "|");
				println(writer, strs[i]);
				lineNumber++;
			}

		}

		Throwable t = error.getCause();
		if (t != null)
		{
			printThrowable(writer, t);
		}

	}

	protected void println(Writer w, String msg)
	{
		System.out.println(msg);
	}

	protected void print(Writer w, String msg)
	{
		System.out.print(msg);
	}

	protected void printThrowable(Writer w, Throwable t)
	{
		t.printStackTrace();
	}

	protected int[] getRange(int line)
	{
		int startLine = 0;
		int endLine = 0;
		if (line > 3)
		{
			startLine = line - 3;
		}
		else
		{
			startLine = 1;
		}

		endLine = startLine + 6;
		return new int[]
		{ startLine, endLine };
	}

}
