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

import static org.beetl.core.om.ObjectMethodMatchConf.BIGDECIMAL_CONVERT;
import static org.beetl.core.om.ObjectMethodMatchConf.DOUBLE_CONVERT;
import static org.beetl.core.om.ObjectMethodMatchConf.FLOAT_CONVERT;
import static org.beetl.core.om.ObjectMethodMatchConf.INT_CONVERT;
import static org.beetl.core.om.ObjectMethodMatchConf.LONG_CONVERT;
import static org.beetl.core.om.ObjectMethodMatchConf.NO_CONVERT;
import static org.beetl.core.om.ObjectMethodMatchConf.SHORT_CONVERT;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * java对象一些操作util类，并缓存一些中间结果以提高性能
 * @author 
 *
 */
public class ObjectUtil
{
	static Map<String, MethodInvoker> methodInvokerCache = new ConcurrentHashMap<String, MethodInvoker>();
	//	static Map<Class, Method[]> cacheClassMethodMap = new ConcurrentHashMap<Class, Method[]>();
	public static Map<Class, ObjectInfo> cachedClassInfoMap = new ConcurrentHashMap<Class, ObjectInfo>();
	public static Object[] EMPTY_OBJECT_ARRAY = new Object[0];
	public static Class[] EMPTY_CLASS_ARRAY = new Class[0];

	/**深度复制一个对象，该对象及其属性都必须实现java.io.Serializable方法。此方法用于
	 * TypeEngine引擎复制一个Program，并做优化用
	 * @param o
	 * @return
	 */
	public static Object copy(Object o)
	{
		if (o instanceof java.io.Serializable)
		{
			try
			{
				ByteArrayOutputStream bs = new ByteArrayOutputStream(128);
				ObjectOutputStream dos = new ObjectOutputStream(bs);
				dos.writeObject(o);
				ByteArrayInputStream is = new ByteArrayInputStream(bs.toByteArray());
				ObjectInputStream ios = new ObjectInputStream(is);
				Object copy = ios.readObject();
				return copy;

			}
			catch (IOException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			catch (ClassNotFoundException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		return null;
	}

	/** 已知属性名，得出get方法，如属性名是name,get方法是getName
	 * 遵循javabean规范
	 * @param attrName
	 * @return
	 */
	public static String getGetMethod(String attrName)
	{
		StringBuilder mbuffer = new StringBuilder("get");
		mbuffer.append(attrName.substring(0, 1).toUpperCase()).append(attrName.substring(1));
		return mbuffer.toString();
	}

	/** 已知属性名，得出set方法，如属性名是name,get方法是setName
	 * 遵循javabean规范
	 * @param attrName
	 * @return
	 */
	public static String getSetMethod(String attrName)
	{
		StringBuilder mbuffer = new StringBuilder("set");
		mbuffer.append(attrName.substring(0, 1).toUpperCase()).append(attrName.substring(1));
		return mbuffer.toString();
	}

	/** 已知属性名，得出is方法，如属性名是boy,is方法是isBoy
	 * 遵循javabean规范
	 * @param attrName
	 * @return
	 */
	public static String getIsMethod(String attrName)
	{
		StringBuilder mbuffer = new StringBuilder("is");
		mbuffer.append(attrName.substring(0, 1).toUpperCase()).append(attrName.substring(1));
		return mbuffer.toString();
	}

	/** 得到一个可供调用get属性的invoker,invoker用于封装对对象的属性读取
	 * @param c
	 * @param name
	 * @return
	 */
	public static MethodInvoker getInvokder(Class c, String name)
	{
		//先检测 get，然后 is，然后是general get

		String key = c.toString().concat("_").concat(name);
		MethodInvoker invoker = methodInvokerCache.get(key);
		if (invoker != null)
		{
			return invoker;
		}
		//try get
		String methodName = getGetMethod(name);
		Method method = getGetMethod(c, methodName, null);
		if (method != null)
		{
			invoker = new PojoMethodInvoker(method);
		}
		else
		{
			methodName = getIsMethod(name);
			method = getGetMethod(c, methodName, null);
			if (method != null)
			{
				invoker = new PojoMethodInvoker(method);
			}
			else
			{
				method = getGetMethod(c, "get", new Class[]
				{ String.class });
				if (method != null)
				{
					invoker = new GeneralGetMethodInvoker(method, name);
				}
			}

		}

		if (invoker != null)
		{
			methodInvokerCache.put(key, invoker);
			return invoker;
		}
		else
		{
			return null;
		}

	}

	/** 获取对象的某个方法，如果无此方法，则仅仅返回null
	 * @param c 对象
	 * @param methodName 方法名
	 * @param paras 参数列表
	 * @return
	 */
	public static Method getGetMethod(Class c, String methodName, Class... paras)
	{
		//需要优化
		try
		{
			return c.getMethod(methodName, paras);
		}
		catch (SecurityException e)
		{
			return null;
		}
		catch (NoSuchMethodException e)
		{
			return null;
		}
	}

	/**看给定的参数是否匹配给定方法的前parameterCount参数 
	 * @param method 
	 * @param parameterType 输入的参数
	 * @param parameterCount 如果为-1，则是精确匹配，输入参数与方法得参数个数必须一致
	 * @return 如果不为null，则匹配，其包含了匹配信息
	 */
	public static ObjectMethodMatchConf match(Method method, Class[] parameterType, int parameterCount)
	{
		Class[] paras = method.getParameterTypes();
		if (parameterCount == -1)
		{
			if (parameterType.length != paras.length)
			{
				return null;
			}
			parameterCount = parameterType.length;
		}

		if (parameterType.length > parameterCount)
		{
			return null;
		}

		int[] convert = new int[parameterCount];

		boolean isMatch = true;

		for (int j = 0; j < parameterType.length; j++)
		{

			if (parameterType[j] == null)
			{
				// 认为匹配
				convert[j] = NO_CONVERT;
				continue;
			}

			if (parameterType[j] == paras[j])
			{
				convert[j] = NO_CONVERT;
				continue;
			}

			if (paras[j] == Object.class)
			{

				convert[j] = NO_CONVERT;

				continue;
			}
			else if (paras[j].isAssignableFrom(parameterType[j]))
			{
				convert[j] = NO_CONVERT;
				continue;
			}

			else if (paras[j].isPrimitive() && Number.class.isAssignableFrom(parameterType[j]))
			{

				if (paras[j] == int.class)
				{
					convert[j] = INT_CONVERT;
				}
				else if (paras[j] == long.class)
				{
					convert[j] = LONG_CONVERT;
				}
				else if (paras[j] == double.class)
				{
					convert[j] = DOUBLE_CONVERT;
				}
				else if (paras[j] == float.class)
				{
					convert[j] = FLOAT_CONVERT;
				}
				else if (paras[j] == short.class)
				{
					convert[j] = SHORT_CONVERT;
				}
			}
			else if (Number.class.isAssignableFrom(paras[j]) && Number.class.isAssignableFrom(parameterType[j]))
			{
				if (paras[j] == Integer.class)
				{
					convert[j] = INT_CONVERT;
				}
				else if (paras[j] == Long.class)
				{
					convert[j] = LONG_CONVERT;
				}
				else if (paras[j] == Double.class)
				{
					convert[j] = DOUBLE_CONVERT;
				}
				else if (paras[j] == Float.class)
				{
					convert[j] = FLOAT_CONVERT;
				}
				else if (paras[j] == Short.class)
				{
					convert[j] = SHORT_CONVERT;
				}
				else if (paras[j] == BigDecimal.class)
				{
					convert[j] = BIGDECIMAL_CONVERT;
				}
				else
				{
					throw new RuntimeException("不支持的类型转化");
				}
			}
			else if (paras[j] == Boolean.class)
			{
				if (parameterType[j] == boolean.class || parameterType[j] == Boolean.class)
				{
					convert[j] = NO_CONVERT;
				}
			}
			else if (paras[j] == boolean.class)
			{
				if (parameterType[j] == boolean.class || parameterType[j] == Boolean.class)
				{
					convert[j] = NO_CONVERT;
				}
			}
			else
			{
				isMatch = false;
			}
		}

		if (isMatch)
		{

			ObjectMethodMatchConf mc = new ObjectMethodMatchConf();
			mc.method = method;
			mc.convert = convert;
			for (int c : convert)
			{
				if (c != 0)
				{
					mc.isNeedConvert = true;
					break;
				}
			}
			if (parameterType.length != parameterCount)
			{
				mc.isExactMatch = false;
			}
			return mc;
		}
		else
		{
			return null;
		}

	}

	/** Beetl 本地方法调用即调用此类，需要考虑到多态。beetl自动调用第一个匹配到的函数，而不会像java那样，调用最合适的匹配到的函数
	 * @param o 对象实例
	 * @param methodName 方法名
	 * @param paras 方法参数
	 * @return
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 * @throws InvocationTargetException
	 */
	public static Object invoke(Object o, String methodName, Object[] paras) throws IllegalAccessException,
			IllegalArgumentException, InvocationTargetException
	{
		Class target = o.getClass();
		ObjectInfo info = getObjectInfo(target);
		List<Method> list = info.getMethods(methodName);
		if (list.size() == 1)
		{
			//只有一个方法，就是它了
			Method m = list.get(0);
			return m.invoke(o, paras);

		}
		else
		{
			//多个方法，找到匹配的方法
			Class[] parameterType = new Class[paras.length];
			int i = 0;
			for (Object para : paras)
			{
				parameterType[i++] = para.getClass();
			}
			ObjectMethodMatchConf mf = findMethod(target, methodName, parameterType);
			Object result = invoke(o, mf, paras);
			return result;
		}

	}

	/** 调用类的静态方法，只知道方法名和参数，beetl将自动匹配到能调用的方法
	 * @param target
	 * @param methodName
	 * @param paras
	 * @return
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 * @throws InvocationTargetException
	 */
	public static Object invokeStatic(Class target, String methodName, Object[] paras) throws IllegalAccessException,
			IllegalArgumentException, InvocationTargetException
	{

		ObjectInfo info = getObjectInfo(target);
		List<Method> list = info.getMethods(methodName);
		if (list.size() == 1)
		{
			//只有一个方法，就是它了
			Method m = list.get(0);
			return m.invoke(null, paras);

		}
		else
		{
			//多个方法，找到匹配的方法
			Class[] parameterType = new Class[paras.length];
			int i = 0;
			for (Object para : paras)
			{
				parameterType[i++] = para.getClass();
			}
			ObjectMethodMatchConf mf = findMethod(target, methodName, parameterType);
			Object result = invoke(null, mf, paras);
			return result;
		}

	}

	private static Object invoke(Object o, ObjectMethodMatchConf conf, Object[] paras) throws IllegalAccessException,
			IllegalArgumentException, InvocationTargetException
	{

		Object[] targets = null;
		if (conf.isNeedConvert)
		{
			targets = new Object[paras.length];
			for (int i = 0; i < paras.length; i++)
			{
				if (conf.convert[i] != 0)
				{
					targets[i] = conf.convert(paras[i], i);
				}
				else
				{
					targets[i] = paras[i];
				}
			}

			return conf.method.invoke(o, targets);

		}
		else
		{
			targets = paras;
		}
		return conf.method.invoke(o, targets);
	}

	/**
	 * 找到某个类的某个方法，方法名是methodName,参数是parameterType。该方法
	 * 试图考虑到带有原始类型或者wrap类型的参数
	 * 
	 * @param target
	 * @param methodName
	 * @param parameterType
	 * @return
	 */
	public static ObjectMethodMatchConf findMethod(Class target, String methodName, Class[] parameterType)
	{

		List<Method> ms = getObjectInfo(target).getMethods(methodName);

		Method temp = null;
		for (int i = 0; i < ms.size(); i++)
		{
			temp = ms.get(i);
			if (temp.getName().equals(methodName))
			{
				ObjectMethodMatchConf selfMc = match(temp, parameterType, -1);
				if (selfMc != null && selfMc.isExactMatch)
				{

					return selfMc;

				}
			}

		}

		return null;
	}

	/** 针对Class.forName的一个简单封装，根据类名获得类
	 * @param clsName
	 * @return 如果未加载成功，则抛出Runtime异常
	 */
	public static Class getClassByName(String clsName)
	{
		try
		{
			return Class.forName(clsName);
		}

		catch (ClassNotFoundException e)
		{
			throw new RuntimeException(e);
		}
	}

	/**针对Class.forName(clsname).newInstance()的一个简单封装
	 * @param clsName
	 * @return 如果未能创建实例，则抛出runtime异常
	 */
	public static Object instnace(String clsName)
	{
		try
		{
			return Class.forName(clsName).newInstance();
		}
		catch (InstantiationException e)
		{
			throw new RuntimeException(e);
		}
		catch (IllegalAccessException e)
		{
			throw new RuntimeException(e);
		}
		catch (ClassNotFoundException e)
		{
			throw new RuntimeException(e);
		}
	}

	/**
	 * 获取一个ObjectInfo
	 * @param c
	 * @return
	 */
	public static ObjectInfo getObjectInfo(Class c)
	{
		ObjectInfo info = cachedClassInfoMap.get(c);
		if (info == null)
		{
			synchronized (c)
			{

				info = new ObjectInfo(c);
				cachedClassInfoMap.put(c, info);
			}
		}
		return info;
	}

}
