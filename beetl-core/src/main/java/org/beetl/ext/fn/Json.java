package org.beetl.ext.fn;

import java.lang.reflect.Method;

import org.beetl.core.Context;
import org.beetl.core.Function;
import org.beetl.core.exception.BeetlException;

public class Json implements Function
{

	Object tool = getTool();
	String template = "<script>console.log(TEMPLATE);</script>";

	@Override
	public Object call(Object[] paras, Context ctx)
	{
		if (tool == null)
		{

			return "找不到JSonTool工具,https://git.oschina.net/xiandafu/beetl-json/attach_files 下载并放到classpath下";
		}
		Object o = paras[0];

		String policy = "";
		if (paras.length == 2)
		{
			policy = paras[1].toString();
		}

		Method m;
		try
		{
			m = tool.getClass().getMethod("serialize", new Class[]
			{ Object.class, String.class });
		}

		catch (Exception e)
		{
			throw new BeetlException(BeetlException.NATIVE_CALL_EXCEPTION, "BTJsonTool出错");
		}
		String json;
		try
		{
			json = (String) m.invoke(tool, new Object[]
			{ o, policy });
		}

		catch (Exception e)
		{
			throw new BeetlException(BeetlException.NATIVE_CALL_EXCEPTION, "BTJsonTool 序列化对象出错",e);

		}
		return json;

	}

	static Object getTool()
	{
		try
		{
			Class c = Class.forName("org.beetl.json.JsonTool");
			return c.newInstance();
		}
		catch (Exception ex)
		{
			return null;
		}

	}

}
