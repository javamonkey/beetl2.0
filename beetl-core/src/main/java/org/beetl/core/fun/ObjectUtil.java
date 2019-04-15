/*
 [The "BSD license"]
 Copyright (c) 2011-2019  闲大赋 (李家智)
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

import static org.beetl.core.om.ObjectMethodMatchConf.BIGDECIMAL_CONVERT;
import static org.beetl.core.om.ObjectMethodMatchConf.BYTE_CONVERT;
import static org.beetl.core.om.ObjectMethodMatchConf.CHAR_CONVERT;
import static org.beetl.core.om.ObjectMethodMatchConf.DOUBLE_CONVERT;
import static org.beetl.core.om.ObjectMethodMatchConf.FLOAT_CONVERT;
import static org.beetl.core.om.ObjectMethodMatchConf.INT_CONVERT;
import static org.beetl.core.om.ObjectMethodMatchConf.LONG_CONVERT;
import static org.beetl.core.om.ObjectMethodMatchConf.NO_CONVERT;
import static org.beetl.core.om.ObjectMethodMatchConf.SHORT_CONVERT;
import static org.beetl.core.om.ObjectMethodMatchConf.VARIABLE_ARRAY;

import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.beans.BeanInfo;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.beetl.core.exception.BeetlException;
import org.beetl.core.exception.BeetlParserException;
import org.beetl.core.misc.BeetlUtil;
import org.beetl.core.om.ObjectMethodMatchConf;

/**
 * java对象一些操作util类，并缓存一些中间结果以提高性能
 * @author 
 *
 */
public class ObjectUtil
{
	//TODO3.0 改成SoftReference，控制内存大小
	public static Map<Class, Map<String,MethodInvoker>> methodInvokerCache = new ConcurrentHashMap<Class, Map<String,MethodInvoker>>();
	public static Map<Class,GeneralGetMethodInvoker> genneraInvokerCache = new ConcurrentHashMap<Class, GeneralGetMethodInvoker>();

	static Map<Class, Method[]> cacheClassMethodMap = new ConcurrentHashMap<Class, Method[]>();
	public static Map<Class, ObjectInfo> cachedClassInfoMap = new ConcurrentHashMap<Class, ObjectInfo>();
	public static Object[] EMPTY_OBJECT_ARRAY = new Object[0];
	public static Class[] EMPTY_CLASS_ARRAY = new Class[0];


	protected static PropertyDescriptor[] propertyDescriptors(Class<?> c) throws IntrospectionException {

		BeanInfo beanInfo = null;
		beanInfo = Introspector.getBeanInfo(c);
		return beanInfo.getPropertyDescriptors();

	}

	protected static PropertyDescriptor find(PropertyDescriptor[]  pd,String name){
		for(PropertyDescriptor p:pd){
			if(p.getName().equals(name)){
				return p;
			}
		}
		return null;
	}

	/** 得到一个可供调用get属性的invoker,invoker用于封装对对象的属性读取
	 * @param c
	 * @param name
	 * @return
	 */
	public static MethodInvoker getInvokder(Class c, String name)
	{

		MethodInvoker invoker = null;
		Map<String,MethodInvoker> map = methodInvokerCache.get(c);
		if(map!=null){
			invoker = map.get(name);
			if (invoker != null)
			{
				return invoker;
			}
		}

		invoker = genneraInvokerCache.get(c);
		if(invoker!=null){
			return invoker;
		}


		PropertyDescriptor property = null;
		try {
			PropertyDescriptor[]  pd  = propertyDescriptors(c);
			property = find(pd,name);
		} catch (IntrospectionException e) {
			throw new BeetlException(BeetlException.ERROR,"获取类属性错",e);
		}

		if(property!=null){
			invoker = new PojoMethodInvoker(property);
			if(map==null){
				map = new ConcurrentHashMap<String,MethodInvoker>();
				methodInvokerCache.put(c, map);
			}
			map.put(name, invoker);
			return invoker;
		}else{
			Method method = getGetMethod(c, "get", new Class[]
					{ Object.class });
			if (method != null)
			{
				invoker = new GeneralGetMethodInvoker(method, name);
			}else{
				method = getGetMethod(c, "get", new Class[]
						{ String.class });
				if(method!=null){
					invoker = new GeneralGetMethodInvoker(method, name);
				}
			}
			genneraInvokerCache.put(c,(GeneralGetMethodInvoker)invoker);
		}


		if (invoker != null)
		{
			if(map==null){
				map = new ConcurrentHashMap<String,MethodInvoker>();
				methodInvokerCache.put(c, map);
			}
			map.put(name, invoker);
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
	protected static Method getGetMethod(Class c, String methodName, Class... paras)
	{

		//需要优化
		try
		{

			Method m = c.getMethod(methodName, paras);
			m.setAccessible(true);
			return m;
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

	/**看给定的参数是否匹配给定方法的参数 
	 * @param method 
	 * @param paras 输入的参数
	 * @return 如果不为null，则匹配，其包含了匹配信息
	 */
	public static ObjectMethodMatchConf match(Method method, Class[] paras)
	{
		Class[] metodParaTypes = method.getParameterTypes();
		if (paras.length < metodParaTypes.length)
		{

			return null;
		}
		else if (paras.length == metodParaTypes.length)
		{
			//精确匹配或者可变参数
		}
		else if (paras.length > metodParaTypes.length && metodParaTypes.length != 0
				&& metodParaTypes[metodParaTypes.length - 1].isArray())
		{
			//可变参数，
		}
		else
		{
			//不匹配
			return null;
		}

		int[] convert = new int[metodParaTypes.length];

		for (int j = 0; j < paras.length; j++)
		{

			if (paras[j] == null)
			{
				// 认为匹配
				convert[j] = NO_CONVERT;
				continue;
			}

			if (paras[j] == metodParaTypes[j])
			{
				convert[j] = NO_CONVERT;
				continue;
			}

			if (metodParaTypes[j] == Object.class)
			{

				convert[j] = NO_CONVERT;

				continue;
			}
			else if (metodParaTypes[j].isAssignableFrom(paras[j]))
			{
				convert[j] = NO_CONVERT;
				continue;
			}
			else if (metodParaTypes[j].isPrimitive() && Number.class.isAssignableFrom(paras[j]))
			{
				//匹配，但需要类型转化
				if (metodParaTypes[j] == int.class)
				{
					convert[j] = INT_CONVERT;
				}
				else if (metodParaTypes[j] == byte.class)
				{
					convert[j] = BYTE_CONVERT;
				}
				else if (metodParaTypes[j] == char.class)
				{
					convert[j] = CHAR_CONVERT;
				}
				else if (metodParaTypes[j] == long.class)
				{
					convert[j] = LONG_CONVERT;
				}
				else if (metodParaTypes[j] == double.class)
				{
					convert[j] = DOUBLE_CONVERT;
				}
				else if (metodParaTypes[j] == float.class)
				{
					convert[j] = FLOAT_CONVERT;
				}
				else if (metodParaTypes[j] == short.class)
				{
					convert[j] = SHORT_CONVERT;
				}
				continue;

			}
			else if (Number.class.isAssignableFrom(metodParaTypes[j]) && Number.class.isAssignableFrom(paras[j]))
			{
				//匹配，但需要类型转化
				if (metodParaTypes[j] == Integer.class)
				{
					convert[j] = INT_CONVERT;
				}
				else if (metodParaTypes[j] == Byte.class)
				{
					convert[j] = BYTE_CONVERT;
				}
				else if (metodParaTypes[j] == Character.class)
				{
					convert[j] = CHAR_CONVERT;
				}
				else if (metodParaTypes[j] == Long.class)
				{
					convert[j] = LONG_CONVERT;
				}
				else if (metodParaTypes[j] == Double.class)
				{
					convert[j] = DOUBLE_CONVERT;
				}
				else if (metodParaTypes[j] == Float.class)
				{
					convert[j] = FLOAT_CONVERT;
				}
				else if (metodParaTypes[j] == Short.class)
				{
					convert[j] = SHORT_CONVERT;
				}
				else if (metodParaTypes[j] == BigDecimal.class)
				{
					convert[j] = BIGDECIMAL_CONVERT;
				}
				continue;

			}

			else if (metodParaTypes[j] == Boolean.class)
			{
				if (paras[j] == boolean.class)
				{
					convert[j] = NO_CONVERT;
					continue;
				}
			}
			else if (metodParaTypes[j] == boolean.class)
			{
				if (paras[j] == Boolean.class)
				{
					convert[j] = NO_CONVERT;
					continue;
				}
			}
			else if (metodParaTypes[j] == Character.class)
			{
				if (paras[j] == char.class)
				{
					convert[j] = CHAR_CONVERT;
					continue;
				}
			}
			else if (metodParaTypes[j] == char.class)
			{
				if (paras[j] == Character.class)
				{
					convert[j] = CHAR_CONVERT;
					continue;
				}
			}
			else if (metodParaTypes[j].isArray())
			{

				if (paras[j].isArray())
				{
					Class metodParaTypeComponent = metodParaTypes[j].getComponentType();
					Class paraTypeComponent = paras[j].getComponentType();
					if (metodParaTypeComponent == paraTypeComponent)
					{
						//不做转化了
						convert[j] = NO_CONVERT;
						continue;
					}
					return null;
				}
				else if (j == metodParaTypes.length - 1)
				{
					convert[j] = VARIABLE_ARRAY;
					break;
				}
				else
				{
					return null;
				}

			}

			return null;

		}
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
		mc.method.setAccessible(true);
		return mc;

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
	private static Object invoke(Class target, Object o, String methodName, Object[] paras)
			throws IllegalAccessException, IllegalArgumentException, InvocationTargetException
	{

		ObjectInfo info = getObjectInfo(target);
		Class[] parameterType = new Class[paras.length];
		int i = 0;
		for (Object para : paras)
		{
			parameterType[i++] = para == null ? null : para.getClass();
		}
		ObjectMethodMatchConf mf = findMethod(target, methodName, parameterType);
		if (mf == null)
		{
			throw new BeetlParserException(BeetlParserException.NATIVE_CALL_INVALID, "根据参数未找到匹配的方法"+methodName+BeetlUtil.getParameterDescription(parameterType));
		}
		Object result = invoke(o, mf, paras);
		return result;

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
		return invoke(target, null, methodName, paras);

	}

	public static Object invokeObject(Object o, String methodName, Object[] paras) throws IllegalAccessException,
			IllegalArgumentException, InvocationTargetException
	{
		Class target = o.getClass();
		return invoke(target, o, methodName, paras);

	}

	public static Object invoke(Object o, ObjectMethodMatchConf conf, Object[] paras) throws IllegalAccessException,
			IllegalArgumentException, InvocationTargetException
	{

		Object[] targets = conf.convert(paras);

		if (o == null)
		{
			//check static 
			if (!Modifier.isStatic(conf.method.getModifiers()))
			{
				throw new BeetlException(BeetlException.NULL, "该方法是非静态方法，不能静态形式调用");
			}
		}
		conf.method.setAccessible(true);
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

		if (ms == null || ms.size() == 0)
		{
			return null;
		}

		Method temp = null;
		for (int i = 0; i < ms.size(); i++)
		{
			temp = ms.get(i);

			ObjectMethodMatchConf selfMc = match(temp, parameterType);
			if (selfMc != null)
			{

				return selfMc;

			}

		}

		return null;
	}

	/** 针对Class.forName的一个简单封装，根据类名获得类
	 * @param clsName
	 * @return 如果未加载成功，则抛出Runtime异常
	 */
	public static Class getClassByName(String clsName,ClassLoader loader)
	{
		try
		{
			return Class.forName(clsName,true,loader);
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
	public static Object instance(String clsName,ClassLoader loader)
	{
		try
		{
			return Class.forName(clsName,true,loader).newInstance();
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

	/** 实例化一个类，如果不成功，返回null
	 * @param clsName
	 * @return
	 */
	public static Object tryInstance(String clsName,ClassLoader loader)
	{
		try
		{
			return instance(clsName,loader);
		}
		catch (Exception ex)
		{
			return null;
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

	/** 已知属性名，得出get方法，如属性名是name,get方法是getName
	 * 遵循javabean规范
	 * @param attrName
	 * @return
	 * @deprecated 并不遵循java规范
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
	 * @deprecated 并不遵循java规范
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
	 * @deprecated 并不遵循java规范
	 */
	public static String getIsMethod(String attrName)
	{
		StringBuilder mbuffer = new StringBuilder("is");
		mbuffer.append(attrName.substring(0, 1).toUpperCase()).append(attrName.substring(1));
		return mbuffer.toString();
	}

}
