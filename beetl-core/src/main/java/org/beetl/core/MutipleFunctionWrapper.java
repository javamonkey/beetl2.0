package org.beetl.core;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.beetl.core.exception.BeetlException;
import org.beetl.core.util.MethodMatchConf;
import org.beetl.core.util.ObjectUtil;

public class MutipleFunctionWrapper extends FunctionWrapper
{

	Method[] ms = null;
	HashMap<Integer, List<MethodContext>> map = new HashMap<Integer, List<MethodContext>>();

	public MutipleFunctionWrapper(String funName, Object target, Method[] ms)
	{
		super(funName);
		this.ms = ms;
		this.target = target;
		for (Method m : ms)
		{
			Class[] paraType = m.getParameterTypes();
			MethodContext mc = new MethodContext();
			mc.m = m;
			mc.parasType = paraType;
			if (paraType.length != 0 && paraType[paraType.length - 1] == Context.class)
			{
				mc.contextRequired = true;
			}
			List<MethodContext> list = map.get(paraType.length);
			if (list == null)
			{
				list = new ArrayList<MethodContext>();
				map.put(paraType.length, list);
			}
			list.add(mc);

		}

	}

	@Override
	public Object call(Object[] paras, Context ctx)
	{
		List<MethodContext> list = map.get(paras.length);
		if (list == null)
		{
			BeetlException ex = new BeetlException(BeetlException.NATIVE_CALL_INVALID, "未发现方法 " + this.functionName);
			throw ex;
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

			BeetlException ex = new BeetlException(BeetlException.NATIVE_CALL_EXCEPTION, "参数不匹配 " + this.functionName,
					e);
			throw ex;
		}
		catch (IllegalAccessException e)
		{
			BeetlException ex = new BeetlException(BeetlException.NATIVE_CALL_EXCEPTION, "非法访问方法 " + this.functionName,
					e);
			throw ex;

		}
		catch (InvocationTargetException e)
		{
			BeetlException ex = new BeetlException(BeetlException.NATIVE_CALL_EXCEPTION, "调用方法出错 " + this.functionName,
					e);
			throw ex;

		}
		BeetlException ex = new BeetlException(BeetlException.NATIVE_CALL_INVALID, "找不到方法 " + this.functionName);
		throw ex;

	}

	class MethodContext
	{
		public Method m;
		public boolean contextRequired;
		public Class[] parasType;
	}

}
