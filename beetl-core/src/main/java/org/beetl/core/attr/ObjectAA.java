package org.beetl.core.attr;

import java.util.List;
import java.util.Map;

import org.beetl.core.exception.TempException;
import org.beetl.core.util.ObjectUtil;

/**
 * 默认的，通用的属性读取器
 * 
 * @author joelli
 * 
 */
public class ObjectAA extends AA
{

	private Class[] getParasType = new Class[]
	{};
	private Object[] getParasObjects = new Object[]
	{};
	static ObjectAA defaultAA = new ObjectAA();

	public static ObjectAA defaultObjectAA()
	{
		return defaultAA;
	}

	@Override
	public Object value(Object o, Object name)
	{
		if (o instanceof Map)
		{
			return ((Map) o).get(name);
		}
		else if (o instanceof List)
		{
			return ((List) o).get(((Number) name).intValue());
		}
		else if (o.getClass().isArray())
		{
			return ((Object[]) o)[(((Number) name).intValue())];
		}

		else
		{

			Class c = o.getClass();
			MethodInvoker invoker = ObjectUtil.getInvokder(c, (String) name);
			if (invoker != null)
			{
				return invoker.get(o);
			}
			else
			{
				throw new TempException("not found attribute " + name);
			}

		}
	}

	protected boolean isGeneralGet(Class c)
	{
		return false;
	}

}
