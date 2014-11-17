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

import org.beetl.core.Context;
import org.beetl.core.exception.BeetlException;
import org.beetl.core.om.ObjectUtil;

/**
 * 对单个native方法的封装
 * @author joelli
 *
 */
public class SingleFunctionWrapper extends FunctionWrapper
{
	Method m;

	public SingleFunctionWrapper(String funName, Class cls, Object target, Method m)
	{
		super(funName);
		this.target = target;
		this.cls = cls;
		this.m = m;
		this.requiredContext = this.checkContextRequried(m.getParameterTypes());

	}

	@Override
	public Object call(Object[] paras, Context ctx)
	{
		try
		{
			if (!this.requiredContext)
			{
				if (target != null)
				{
					return ObjectUtil.invokeObject(this.target, m.getName(), paras);

				}
				else
				{
					return ObjectUtil.invokeStatic(this.cls, m.getName(), paras);
				}

			}
			else
			{

				Object[] newParas = getContextParas(paras, ctx);
				if (target != null)
				{
					return ObjectUtil.invokeObject(this.target, m.getName(), newParas);

				}
				else
				{
					return ObjectUtil.invokeStatic(this.cls, m.getName(), newParas);
				}

			}

		}
		catch (InvocationTargetException ex)
		{
			Throwable t = ex.getTargetException();
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
		catch (BeetlException ex)
		{
			throw ex;
		}
		catch (Exception ex)
		{
			BeetlException be = new BeetlException(BeetlException.NATIVE_CALL_EXCEPTION, "调用方法出错 " + this.functionName,
					ex);
			throw be;
		}

	}

	public Class getReturnType()
	{
		return m.getReturnType();
	}

}
