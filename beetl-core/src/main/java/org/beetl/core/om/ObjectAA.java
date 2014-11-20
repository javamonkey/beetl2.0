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

import java.util.List;
import java.util.Map;

import org.beetl.core.exception.BeetlException;
import org.beetl.core.misc.PrimitiveArrayUtil;

/**
 * 默认的，通用的属性读取器,适用于map.list,[] ,以及通常pojo
 * 该方法是属性获取通用方法，根据object类型来选择适当的调用方法
 * 
 * @author joelli
 * 
 */
public class ObjectAA extends AttributeAccess
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
			try
			{
				return ((List) o).get(((Number) name).intValue());
			}
			catch (ClassCastException ex)
			{
				throw new ClassCastException("类型为java.util.List,无此属性:" + name);
			}

		}
		else if (o.getClass().isArray())
		{
			try
			{
				if (o.getClass().getComponentType().isPrimitive())
				{
					return PrimitiveArrayUtil.getObject(o, (((Number) name).intValue()));
				}
				else
				{
					return ((Object[]) o)[(((Number) name).intValue())];
				}

			}
			catch (ClassCastException ex)
			{
				throw new ClassCastException("类型为数组,无此属性:" + name);
			}

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
				BeetlException ex = new BeetlException(BeetlException.ATTRIBUTE_NOT_FOUND, (String) name);
				throw ex;
			}

		}
	}

}
