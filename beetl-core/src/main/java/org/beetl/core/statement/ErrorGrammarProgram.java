package org.beetl.core.statement;

import java.io.Writer;

import org.beetl.core.Context;
import org.beetl.core.ErrorHandler;
import org.beetl.core.GroupTemplate;
import org.beetl.core.exception.BeetlException;
import org.beetl.core.util.BeetlUtil;

/**
 * 语法错的时候处理错误
 * @author joelli
 *
 */

public class ErrorGrammarProgram extends Program
{
	BeetlException exception = null;

	public ErrorGrammarProgram(String resourcId, GroupTemplate gt, String cr)
	{
		super();
		this.id = resourcId;
		this.gt = gt;
		this.metaData = new ProgramMetaData() {
			public void initContext(Context ctx)
			{
				//do nothing;
			}

			protected void putGlobaToArray(Context ctx)
			{
				//do nothing;
			}
		};
		this.metaData.lineSeparator = cr;
	}

	public void execute(Context ctx)
	{
		Writer w = BeetlUtil.getWriterByByteWriter(ctx.byteWriter);

		ErrorHandler errorHandler = this.gt.getErrorHandler();

		errorHandler.processExcption(exception, w);
	}

	public BeetlException getException()
	{
		return exception;
	}

	public void setException(BeetlException exception)
	{
		this.exception = exception;
		this.exception.gt = this.gt;
		this.exception.resourceId = this.id;
		this.exception.cr = this.metaData.lineSeparator;
	}

}
