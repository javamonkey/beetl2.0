/*
 [The "BSD license"]
 Copyright (c) 2011-2014 Joel Li (李家智)
 All rights reserved.

 Redistribution and use in source and binary forms, with or without
 modification, are permitted provided that the following conditions
 are met:
 1. Redistributions of source code must retain the above copyright
     notice, this list of conditions and the following disclaimer.
 2. Redistributions in binary form must reproduce the above copyright
     notice, this list of conditions and the following disclaimer in the
     documentation and/or other materials provided with the distribution.
 3. The name of the author may not be used to endorse or promote products
     derived from this software without specific prior written permission.

 THIS SOFTWARE IS PROVIDED BY THE AUTHOR ``AS IS'' AND ANY EXPRESS OR
 IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES
 OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED.
 IN NO EVENT SHALL THE AUTHOR BE LIABLE FOR ANY DIRECT, INDIRECT,
 INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT
 NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
 DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY
 THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF
 THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package org.beetl.core.fun;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.beetl.core.Context;
import org.beetl.core.exception.BeetlException;
import org.beetl.core.om.ObjectMethodMatchConf;
import org.beetl.core.om.ObjectUtil;

/**
 * 此Function代表了一个类有多个同名方法。当模板调用的时候，自动寻找最合适的Native方法调用，
 * @author joeli
 *
 */
public class MutipleFunctionWrapper extends FunctionWrapper
{

	Method[] ms = null;
	HashMap<Integer, List<MethodContext>> map = new HashMap<Integer, List<MethodContext>>();
	String methodName = null;

	public MutipleFunctionWrapper(String funName, Object target, Method[] ms)
	{
		super(funName);
		this.ms = ms;
		this.target = target;
		int index = this.functionName.lastIndexOf(".");
		if (index != -1)
		{
			methodName = functionName.substring(index + 1);
		}
		else
		{
			methodName = functionName;
		}
		for (Method m : ms)
		{
			Class[] paraType = m.getParameterTypes();
			MethodContext mc = new MethodContext();
			mc.m = m;
			mc.parasType = paraType;
			int len = paraType.length;
			if (paraType.length != 0 && paraType[paraType.length - 1] == Context.class)
			{
				mc.contextRequired = true;
				len--;
			}
			List<MethodContext> list = map.get(len);
			if (list == null)
			{
				list = new ArrayList<MethodContext>();
				//根据长度快速找到应该调用的方法
				map.put(len, list);
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
			if (list.size() == 1)
			{
				MethodContext mc = list.get(0);
				Object[] newArgs = paras;
				if (mc.contextRequired)
				{
					newArgs = new Object[paras.length + 1];
					System.arraycopy(paras, 0, newArgs, 0, paras.length);
					newArgs[paras.length] = ctx;

				}

				return ObjectUtil.invokeObject(target, this.methodName, newArgs);

			}
			else
			{
				//比较慢的情况，要考虑到底哪个方法适合调用
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

					ObjectMethodMatchConf conf = ObjectUtil.match(mc.m, parameterType);
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
							newParas[j] = conf.convert(paras[j], j);
						}

						if (mc.contextRequired)
						{
							newParas[newParas.length - 1] = ctx;
						}
						return mc.m.invoke(target, newParas);

					}

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

	public Class getReturnType(Class[] parameterType)
	{

		Class[] parameterContextType = null;
		Class[] parameterNoContextType = null;
		List<MethodContext> list = map.get(parameterType.length);
		for (MethodContext mc : list)
		{

			if (mc.contextRequired)
			{
				parameterContextType = new Class[parameterType.length + 1];
				System.arraycopy(parameterType, 0, parameterContextType, 0, parameterType.length);

			}
			else
			{
				parameterContextType = parameterType;
			}

			ObjectMethodMatchConf matchConf = ObjectUtil.findMethod(target.getClass(), this.methodName,
					parameterContextType);
			if (matchConf != null)
			{
				return matchConf.method.getReturnType();
			}

		}
		//如果找不到合适类型，则认为调用返回Object
		return Object.class;

	}

	class MethodContext
	{
		public Method m;
		public boolean contextRequired;
		public Class[] parasType;
	}

}
