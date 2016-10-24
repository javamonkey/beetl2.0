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
import java.util.List;

import org.beetl.core.Context;
import org.beetl.core.exception.BeetlException;
import org.beetl.core.misc.BeetlUtil;
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
	String methodName = null;
	MethodContext[] mcs = null;

	public MutipleFunctionWrapper(String funName, Class cls, Object target, Method[] ms)
	{
		super(funName);
		this.ms = ms;
		this.target = target;
		this.cls = cls;
		int index = this.functionName.lastIndexOf(".");
		if (index != -1)
		{
			methodName = functionName.substring(index + 1);
		}
		else
		{
			methodName = functionName;
		}
		List<MethodContext> list = new ArrayList<MethodContext>();
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

			list.add(mc);

		}
		mcs = (MethodContext[]) list.toArray(new MethodContext[0]);

	}

	@Override
	public Object call(Object[] paras, Context ctx)
	{
		Class[] parameterType = null;
		try
		{

			//比较慢的情况，要考虑到底哪个方法适合调用
			
			Class[] parameterContextType = null;
			Class[] parameterNoContextType = null;

			for (MethodContext mc : mcs)
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
				Object[] newParas = null;
				if (mc.contextRequired)
				{
					newParas = this.getContextParas(paras, ctx);

				}
				else
				{
					newParas = paras;
				}

				newParas = conf.convert(newParas);
				return mc.m.invoke(target, newParas);

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
			Throwable t = e.getTargetException();
			if (t instanceof BeetlException)
			{
				throw (BeetlException) t;
			}
			else
			{
				BeetlException be = new BeetlException(BeetlException.NATIVE_CALL_EXCEPTION, "调用方法出错 "
						+ this.functionName, t);
				throw be;
			}

		}
		BeetlException ex = new BeetlException(BeetlException.NATIVE_CALL_INVALID, "找不到方法 " + this.functionName+BeetlUtil.getParameterDescription(parameterType));
		throw ex;

	}

	public Class getReturnType(Class[] parameterType)
	{

		Class[] parameterContextType = null;
		Class[] parameterNoContextType = null;

		for (MethodContext mc : mcs)
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
