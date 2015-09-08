package org.beetl.core;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.beetl.core.resource.StringTemplateResourceLoader;
import org.beetl.ext.fn.GetValueFunction;

/**
 * beetl小工具,加载classpath下的beetl.properties 来配置模板引擎，通常用于简单测试，或者性能要求不高的场景 
 * 不要用于生产环境
 * * @author
 * 
 * 
 */
public class BeetlKit
{

	/**
	 * BeetlKit 默认使用的GroupTemplate，用户可以设置新的
	 */
	public static GroupTemplate gt = null;
	static
	{
		StringTemplateResourceLoader resourceLoader = new StringTemplateResourceLoader();
		Configuration cfg;
		try
		{
			cfg = Configuration.defaultConfiguration();

		}
		catch (IOException e)
		{
			throw new RuntimeException(e);
		}
		gt = new GroupTemplate(resourceLoader, cfg);
		gt.registerFunction("beetlKit", new GetValueFunction());
		gt.setErrorHandler(new ConsoleErrorHandler() {
			protected void println(Writer w, String msg)
			{
				try
				{
					w.write(msg);
					w.write('\n');
				}
				catch (IOException e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			protected void print(Writer w, String msg)
			{
				try
				{
					w.write(msg);
				}
				catch (IOException e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			protected void printThrowable(Writer w, Throwable t)
			{

				t.printStackTrace(new PrintWriter(w));
			}

			protected String getResourceName(String resourceId)
			{
				if (resourceId.length() > 10)
				{
					return resourceId.substring(0, 10).concat("...");
				}
				else
				{
					return resourceId;
				}
			}
		});
	}

	/* 模板部分 */

	/** 渲染模板
	 * @param template
	 * @param paras
	 * @return 模板返回值
	 */
	public static String render(String template, Map<String, Object> paras)
	{
		Template t = gt.getTemplate(template);
		t.binding(paras);
		return t.render();
	}

	/** 渲染模板
	 * @param template
	 * @param writer
	 * @param paras
	 */
	public static void renderTo(String template, Writer writer, Map<String, Object> paras)
	{
		Template t = gt.getTemplate(template);
		t.binding(paras);
		t.renderTo(writer);
	}

	/* 脚本部分 */
	public static void execute(String script, Map<String, Object> paras)
	{
		execute(script, paras, null);
	}

	/**执行某个脚本，返回指定的的变量
	 * @param script
	 * @param paras
	 * @param locals 指定的变量，只能是全局的，或者是root scope的
	 * @return
	 */
	public static Map execute(String script, Map<String, Object> paras, String[] locals)
	{
		String start = gt.getConf().getStatementStart();
		String end = gt.getConf().getStatementEnd();
		StringBuilder sb = new StringBuilder(script.length() + start.length() + end.length());
		sb.append(start).append(script);
		if (locals != null)
		{
			sb.append("beetlKit(");
			for (String varName : locals)
			{
				sb.append("'").append(varName).append("',").append(varName).append("!,");
			}
			sb.setLength(sb.length() - 1);
			sb.append(");");
		}

		sb.append(end);
		Template t = gt.getTemplate(sb.toString());
		t.binding(paras);
		HashMap map = new HashMap();
		t.binding("beetlKitMap", map);
		t.render();
		return map;

	}

	/** 执行脚本，和参数，返回脚本里的Root scope的变量
	 * @param script
	 * @return
	 */
	public static Map executeAndReturnRootScopeVars(String script)
	{
		String start = gt.getConf().getStatementStart();
		String end = gt.getConf().getStatementEnd();
		StringBuilder sb = new StringBuilder(script.length() + start.length() + end.length());
		sb.append(start).append(script);

		sb.append(end);
		Template t = gt.getTemplate(sb.toString());
		//		t.binding(paras);
		t.render();
		Map<String, Integer> idnexMap = t.program.metaData.getTemplateRootScopeIndexMap();
		Object[] values = t.ctx.vars;
		Map<String, Object> result = new HashMap<String, Object>();
		for (Entry<String, Integer> entry : idnexMap.entrySet())
		{
			String name = entry.getKey();
			int index = entry.getValue();
			Object value = values[index];
			result.put(name, value);
		}
		return result;

	}

	/* 模板自测试部分 */

	/**
	 * @param template
	 *            模板内容
	 * @param initValue
	 *            模板初始化值
	 * @return 模板渲染结果
	 */
	public static String testTemplate(String template, String initValue)
	{
		Map map = executeAndReturnRootScopeVars(initValue);
		String result = render(template, map);
		return result;
	}

	public static void main(String[] args)
	{
		String template = "${a}";
		String initValue = "var a=1,c=2+1";
		String result = testTemplate(template, initValue);
		System.out.println(result);

	}
}
