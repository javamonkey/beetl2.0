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
package org.beetl.core.om;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.beetl.core.exception.BeetlException;

/**
 * 传入对象，获取对象对应的属性值 
 * @author joelli
 *
 */
public class PojoMethodInvoker implements MethodInvoker
{

	public Method method;
	public Method setMethod;
	private boolean isCheck = false;

	/**
	 * @param m 目标调用方法，应该是一个无参数的get方法
	 */
	public PojoMethodInvoker(Method m)
	{
		this.method = m;

	}

	@Override
	public Object get(Object obj)
	{
		try
		{
			return method.invoke(obj, null);
		}
		catch (IllegalArgumentException e)
		{
			throw new BeetlException(BeetlException.ATTRIBUTE_INVALID, "错误参数", e);

		}
		catch (IllegalAccessException e)
		{
			throw new BeetlException(BeetlException.ATTRIBUTE_INVALID, "无法访问", e);

		}
		catch (InvocationTargetException e)
		{
			Throwable target = e.getTargetException();
			if (target instanceof BeetlException)
			{
				throw (BeetlException) target;
			}
			throw new BeetlException(BeetlException.ATTRIBUTE_INVALID, "属性访问异常", e.getTargetException());
		}
	}

	@Override
	public Class getReturnType()
	{
		return method.getReturnType();
	}

	@Override
	public Method getMethod() {
		return method;
	}

	@Override
	public void set(Object ins, Object value) {
		checkSetterMethod();
		if(setMethod==null){
			throw new BeetlException(BeetlException.ATTRIBUTE_INVALID, "属性访问异常");
		}
		try {
			setMethod.invoke(ins, value);
		} catch (IllegalAccessException e) {
			throw new BeetlException(BeetlException.ATTRIBUTE_INVALID, "错误参数", e);
		} catch (IllegalArgumentException e) {
			throw new BeetlException(BeetlException.ATTRIBUTE_INVALID, "无法访问", e);
		} catch (InvocationTargetException e) {
			Throwable target = e.getTargetException();
			if (target instanceof BeetlException)
			{
				throw (BeetlException) target;
			}
			throw new BeetlException(BeetlException.ATTRIBUTE_INVALID, "属性访问异常", e.getTargetException());
		}	
		
	}
	
	private void checkSetterMethod(){
		if(isCheck){
			return ;
		}
		synchronized(method){
			if(isCheck){
				return ;
			}
			Class c = this.method.getDeclaringClass();
			Class type = this.method.getReturnType();
			String name = this.method.getName();
			String setName = null;
			if(name.startsWith("is")){
				setName="set"+name.substring(2);
			}else{
				//getXXX-->setXXX
				setName="set"+name.substring(3);
			}
			try{
				setMethod = c.getMethod(setName, type);
			}catch(Exception ex ){
				setMethod = null;
			}
			isCheck = true;
		}
		
	}

}
