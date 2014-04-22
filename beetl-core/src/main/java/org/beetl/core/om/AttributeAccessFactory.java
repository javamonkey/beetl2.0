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

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.beetl.core.exception.BeetlException;

/**
 * 为一个特定类的方法生成AttributeAccess，如果类是
 * <ul>
 * <li>Map,则生成MapAA</li>
 * <li>List,则生成ListAA</li>
 * <li>数组,则生成ArrayAA</li>
 * <li>普通PoJo对象,则通过字节码生成改属性的访问类{@link BCWFactory#getAttribyteBCW(Class, String, String, Class) }</li>
 * </ul>
 * @author joelli
 *
 */
public class AttributeAccessFactory
{

	// 已经为属性生成的访问代理类
	static Map<String, AttributeAccess> pojoCache = new HashMap<String, AttributeAccess>();
	static Map<String, AttributeAccess> generalGetCache = new HashMap<String, AttributeAccess>();

	public static MapAA mapAA = new MapAA();
	public static ListAA listAA = new ListAA();
	public static ArrayAA arrayAA = new ArrayAA();
	public static ObjectAA objectAA = new ObjectAA();

	static public AttributeAccess buildFiledAccessor(Class c, String attrExp)
	{

		if (c == Object.class)
		{
			return objectAA;
		}

		if (Map.class.isAssignableFrom(c))
		{
			return mapAA;
		}

		if (List.class.isAssignableFrom(c))
		{
			return listAA;
		}

		if (c.isArray())
		{
			return arrayAA;
		}
		String name = (String) attrExp;
		String className = c + "$_$" + name;
		AttributeAccess aa = pojoCache.get(className);
		if (aa != null)
			return aa;

		FindResult pojoResult = findCommonInterfaceOrClass(c, name);
		if (pojoResult != null)
		{
			className = pojoResult.c + "$_$" + name;
			aa = pojoCache.get(className);
			if (aa != null)
			{
				return aa;
			}
			else
			{
				aa = AttributeCodeGen.createAAClass(pojoResult.c, name, pojoResult.realMethodName,
						pojoResult.returnType);

				pojoCache.put(className, aa);
				return aa;

			}

		}
		else
		{
			// General Get
			className = c + "$_" + name;
			aa = generalGetCache.get(className);
			if (aa != null)
			{
				return aa;
			}
			else
			{
				FindResult generaGetResult = findResult(c, "get", "get");
				if (generaGetResult != null)
				{
					aa = AttributeCodeGen.createAAClass(generaGetResult.c, "get", "get", Object.class);
					generalGetCache.put(className, aa);
				}
				else
				{
					// 还是没有找到，抛错吧
					BeetlException be = new BeetlException(BeetlException.ATTRIBUTE_NOT_FOUND, name);
					throw be;
				}
			}

		}

		return aa;

	}

	public static FindResult findCommonInterfaceOrClass(Class c, String name)
	{

		FindResult findResult = findResult(c, ObjectUtil.getGetMethod(name), ObjectUtil.getIsMethod(name));
		return findResult;

	}

	private static FindResult findResult(Class c, String getName, String isName)
	{
		FindResult result = null;
		Method[] methods = c.getMethods();
		Method findMethod = null;
		for (Method m : methods)
		{
			String name = m.getName();
			Class[] paras = m.getParameterTypes();
			if (paras.length != 0)
				continue;
			if (name.equals(getName))
			{
				findMethod = m;
				break;
			}
			else if (name.equals(isName))
			{
				findMethod = m;
				break;
			}
		}
		// 判断父接口
		Class[] interfaces = c.getInterfaces();
		for (Class inc : interfaces)
		{
			if (inc.getName().startsWith("java."))
			{
				// java包不需要考虑
				continue;
			}
			result = findResult(inc, getName, isName);
			if (result != null)
			{
				resetFindResult(findMethod, result);
			}
		}

		Class parent = c.getSuperclass();
		if (!parent.getName().startsWith("java."))
		{
			result = findResult(parent, getName, isName);
			if (result != null)
			{
				resetFindResult(findMethod, result);
				return result;
			}
		}

		if (findMethod != null)
		{
			result = new FindResult();
			result.realMethodName = findMethod.getName();
			result.c = c;
			result.returnType = findMethod.getReturnType();
			return result;
		}
		else
		{
			return null;
		}

	}

	private static void resetFindResult(Method m, FindResult parent)
	{
		if (m.getReturnType() == parent.returnType)
		{
			return;
		}
		else
		{
			// 和父接口不一致，模型比较复杂类型推测很难，统一改成Object
			parent.returnType = Object.class;
		}
	}

	static class FindResult
	{

		String realMethodName;
		Class c;
		Class returnType;
	}
}
