package org.beetl.core;

import java.io.IOException;
import java.io.OutputStream;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Map;
import java.util.Set;

import org.beetl.core.exception.BeetlException;
import org.beetl.core.io.ByteWriter_Byte;
import org.beetl.core.io.ByteWriter_Char;
import org.beetl.core.statement.Program;
import org.beetl.core.util.BeetlUtil;

public class Template
{
	public Program program;
	public Configuration cf;
	public GroupTemplate gt;

	Context ctx = new Context();

	protected Template(GroupTemplate gt, Program program, Configuration cf)
	{
		this.program = program;
		this.cf = cf;
		this.gt = gt;
	}

	/**
	 * 获取模板输出的文本，结果是一个String
	 * 
	 * @return
	 * @throws BeetlException
	 */
	public String render() throws BeetlException
	{
		StringWriter sw = new StringWriter();
		renderTo(sw);
		return sw.toString();
	}

	/**
	 * 获取模板输出的文本,输出到Writer里
	 * 
	 * @param w
	 * @throws BeetlException
	 */
	public void renderTo(Writer writer) throws BeetlException
	{
		ByteWriter_Char byteWriter = new ByteWriter_Char(writer, cf.charset);
		this.renderTo(byteWriter);

	}

	/**
	 * 获取模板输出的文本,输出到OutputStream里,tempalte必须在二进制输出模式下才能使用
	 * 
	 * @param os
	 * @throws BeetlException
	 */
	public void renderTo(OutputStream os) throws BeetlException
	{
		ByteWriter_Byte byteWriter = new ByteWriter_Byte(os, cf.charset);
		this.renderTo(byteWriter);
	}

	public void renderTo(ByteWriter byteWriter)
	{

		try
		{
			ctx.byteWriter = byteWriter;
			ctx.byteOutputMode = cf.directByteOutput;
			ctx.gt = this.gt;
			ctx.template = this;
			program.metaData.initContext(ctx);
			program.execute(ctx);
			byteWriter.flush();
		}
		catch (BeetlException e)
		{
			Writer w = BeetlUtil.getWriterByByteWriter(ctx.byteWriter);
			ErrorHandler errorHandler = this.gt.getErrorHandler();
			errorHandler.processExcption(e, w);
		}
		catch (IOException e)
		{
			if (!ctx.gt.conf.isIgnoreClientIOError)
			{
				throw new RuntimeException(e);
			}
			else
			{
				//do  nothing ,just ignore
			}

		}

	}

	/**
	 * 为模板绑定变量，此变量在模板编译的时候,根据infer标记来决定是否要推测期类型，如果dynamic为true，
	 * 则表示模板引擎优化不需要推测其类型，默认总是false，即变量总是对应同一个类型。如果为true，则认为: 因为变量可能能对应不同java类型，
	 * 或者变量是容器，但容器里的元素是不同类型
	 * 
	 * @param varName
	 * @param o
	 */
	public void binding(String varName, Object o, boolean dynamic)
	{
		ctx.set(varName, o, dynamic);
		// ctx.globalVar.put(varName, o);
		if (dynamic)
		{
			ctx.objectKeys.add(varName);
		}
	}

	/**
	 * 为模板绑定一个变量，infer是true
	 * 
	 * @param varName
	 *            变量名称，必须符合jaavascript 命名规范
	 * @param o
	 *            模板变量
	 */
	public void binding(String varName, Object o)
	{
		this.binding(varName, o, false);
	}

	public void dynamic(Set<String> objectKeys)
	{
		this.ctx.objectKeys = objectKeys;
	}

	public void dynamic(String key)
	{
		this.ctx.objectKeys.add(key);
	}

	/**
	 * 为模板绑定多个变量，map的key，value对应了变量名称和变量值。key必须符合javascript命名规范
	 * 
	 * @param map
	 */
	public void binding(Map map)
	{
		ctx.globalVar = map;
	}

	public void fastRender(Map map, ByteWriter byteWriter)
	{
		if (ctx.isInit)
		{
			ctx.globalVar = map;
			// 重用
			for (int i = ctx.tempVarStartIndex; i < ctx.vars.length; i++)
			{
				ctx.vars[i] = null;
			}
			ctx.byteWriter = byteWriter;
			program.metaData.replaceGlobal(ctx);
			program.execute(ctx);
		}
		else
		{
			ctx.globalVar = map;
			renderTo(byteWriter);
		}

	}

}
