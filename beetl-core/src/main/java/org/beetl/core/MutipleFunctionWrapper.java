package org.beetl.core;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;

import org.beetl.core.exception.TempException;
import org.beetl.core.util.MethodMatchConf;
import org.beetl.core.util.ObjectUtil;

public class MutipleFunctionWrapper extends FunctionWrapper
{

	Method[] ms = null;
	HashMap<Integer, List<MethodContext>> map = new HashMap<Integer, List<MethodContext>>();

	public MutipleFunctionWrapper(Object target, Method[] ms)
	{
		this.ms = ms;

	}

	@Override
	public Object call(Object[] paras, Context ctx)
	{
		List<MethodContext> list = map.get(paras.length);
		if (list == null)
		{
			throw new TempException("没有发现方法");
		}

		try
		{

			Class[] parameterType = null;
			Class[] parameterContextType = null;
			Class[] parameterNoContextType = null;

			for (MethodContext mc : list)
			{

				if (mc.contextRequired)
				{
					if (parameterContextType == null)
					{
						parameterContextType = new Class[paras.length + 1];
						int i = 0;
						for (Object para : paras)
						{
							parameterContextType[i++] = para != null ? para.getClass() : null;
						}

						parameterContextType[i] = Context.class;

					}
					parameterType = parameterContextType;
				}
				else
				{
					if (parameterNoContextType == null)
					{
						parameterNoContextType = new Class[paras.length];
						int i = 0;
						for (Object para : paras)
						{
							parameterNoContextType[i++] = para != null ? para.getClass() : null;
						}

					}
					parameterType = parameterNoContextType;
				}

				MethodMatchConf conf = ObjectUtil.match(mc.m, parameterType, -1);
				if (conf == null)
				{
					continue;
				}

				if (!conf.isNeedConvert)
				{
					if (mc.contextRequired)
					{
						Object[] newParas = this.getContextParas(paras, ctx);
						return mc.m.invoke(target, newParas);
					}
					else
					{
						return mc.m.invoke(target, paras);
					}

				}
				else
				{
					Object[] newParas = new Object[paras.length + (mc.contextRequired ? 1 : 0)];
					for (int j = 0; j < paras.length; j++)
					{
						if (conf.convert[j] != 0)
						{
							newParas[j] = conf.convert(paras[j], j);
						}
						else
						{
							newParas[j] = paras[j];
						}
					}

					if (mc.contextRequired)
					{
						newParas[newParas.length - 1] = ctx;
					}
					return mc.m.invoke(target, newParas);

				}

			}
		}
		catch (IllegalArgumentException e)
		{
			throw new TempException("参数不匹配" + e.getMessage());
		}
		catch (IllegalAccessException e)
		{
			throw new TempException("不能调用方法" + e.getMessage());
		}
		catch (InvocationTargetException e)
		{
			throw new TempException("不可能发生" + e.getMessage());
		}

		throw new TempException("找不到方法");

	}

	class MethodContext
	{
		public Method m;
		public boolean contextRequired;
		public Class[] parasType;
	}

}
