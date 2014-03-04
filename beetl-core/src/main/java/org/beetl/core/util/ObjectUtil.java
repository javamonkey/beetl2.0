package org.beetl.core.util;

import static org.beetl.core.util.MethodMatchConf.BIGDECIMAL_CONVERT;
import static org.beetl.core.util.MethodMatchConf.DOUBLE_CONVERT;
import static org.beetl.core.util.MethodMatchConf.FLOAT_CONVERT;
import static org.beetl.core.util.MethodMatchConf.INT_CONVERT;
import static org.beetl.core.util.MethodMatchConf.LONG_CONVERT;
import static org.beetl.core.util.MethodMatchConf.NO_CONVERT;
import static org.beetl.core.util.MethodMatchConf.SHORT_CONVERT;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.beetl.core.resolver.GeneralGetMethodInvoker;
import org.beetl.core.resolver.MethodInvoker;
import org.beetl.core.resolver.PojoMethodInvoker;

public class ObjectUtil
{
	static Map<String, MethodInvoker> methodInvokerCache = new ConcurrentHashMap<String, MethodInvoker>();
	static Map<Class, Method[]> cacheClassMethodMap = new ConcurrentHashMap<Class, Method[]>();
	public static Object[] EMPTY_OBJECT_ARRAY = new Object[0];
	public static Class[] EMPTY_CLASS_ARRAY = new Class[0];

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

	public static String getMethod(String attrName)
	{
		StringBuilder mbuffer = new StringBuilder("get");
		mbuffer.append(attrName.substring(0, 1).toUpperCase()).append(attrName.substring(1));
		return mbuffer.toString();
	}

	public static String getIsMethod(String attrName)
	{
		StringBuilder mbuffer = new StringBuilder("is");
		mbuffer.append(attrName.substring(0, 1).toUpperCase()).append(attrName.substring(1));
		return mbuffer.toString();
	}

	/** 得到一个可供调用get属性的invoker
	 * @param c
	 * @param name
	 * @return
	 */
	public static MethodInvoker getInvokder(Class c, String name)
	{
		//先检测 get，然后 is，然后是general get

		String key = c + "_" + name;
		MethodInvoker invoker = methodInvokerCache.get(key);
		if (invoker != null)
		{
			return invoker;
		}
		//try get
		String methodName = getMethod(name);
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

	public static Method getGetMethod(Class c, String methodName, Class... paras)
	{
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

	/**得到对象自己的所有public方法
	 * @param o
	 * @return
	 */
	public static Method[] getSelfPublicMethod(Object o)
	{
		Class c = o.getClass();
		Method[] ms = o.getClass().getMethods();
		List list = new ArrayList();
		for (Method m : ms)
		{
			int mod = m.getModifiers();
			if (m.getDeclaringClass().equals(c) && Modifier.isPublic(mod) && !Modifier.isStatic(mod))
			{
				list.add(m);
			}

		}
		return (Method[]) list.toArray(new Method[0]);
	}

	/**看给定的参数是否匹配给定方法的前parameterCount参数 joelli
	 * @param method 
	 * @param parameterType 输入的参数
	 * @param parameterCount 如果为-1，则是精确匹配，输入参数与方法得参数个数必须一致
	 * @return
	 */
	public static MethodMatchConf match(Method method, Class[] parameterType, int parameterCount)
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

			MethodMatchConf mc = new MethodMatchConf();
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

	public static Object invoke(Object o, String methodName, Object[] paras) throws IllegalAccessException,
			IllegalArgumentException, InvocationTargetException
	{
		Class target = o.getClass();
		Class[] parameterType = new Class[paras.length];
		int i = 0;
		for (Object para : paras)
		{
			parameterType[i++] = para.getClass();
		}
		MethodMatchConf mf = findMethod(target, methodName, parameterType);
		Object result = invoke(o, mf, paras);
		return result;
	}

	public static Object invokeStatic(Class target, String methodName, Object[] paras) throws IllegalAccessException,
			IllegalArgumentException, InvocationTargetException
	{

		Class[] parameterType = new Class[paras.length];
		int i = 0;
		for (Object para : paras)
		{
			parameterType[i++] = para.getClass();
		}
		MethodMatchConf mf = findMethod(target, methodName, parameterType);
		Object result = invoke(null, mf, paras);
		return result;
	}

	private static Object invoke(Object o, MethodMatchConf conf, Object[] paras) throws IllegalAccessException,
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
	 * 找到某个类的某个方法，方法名是methodName,参数是parameterType。该方法尽可能找到接口方法，同时，该方法
	 * 试图考虑到带有原始类型或者wrap类型的参数
	 * 
	 * @param target
	 * @param methodName
	 * @param parameterType
	 * @return
	 */
	public static MethodMatchConf findMethod(Class target, String methodName, Class[] parameterType)
	{

		Method[] ms = cacheClassMethodMap.get(target);
		if (ms == null)
		{
			ms = target.getMethods();

		}
		Method temp = null;
		for (int i = 0; i < ms.length; i++)
		{
			temp = ms[i];
			if (temp.getName().equals(methodName))
			{
				MethodMatchConf selfMc = match(temp, parameterType, -1);
				if (selfMc != null && selfMc.isExactMatch)
				{
					Class[] interfaces = target.getInterfaces();
					// 优先返回接口
					for (Class inf : interfaces)
					{
						if (inf.equals(java.io.Serializable.class))
						{
							continue;
						}
						MethodMatchConf interfaceMc = findMethod(inf, methodName, parameterType);
						if (interfaceMc != null)
						{
							return interfaceMc;
						}
					}
					// 在返回父类
					Class parent = target.getSuperclass();
					if (parent != null && !parent.equals(Object.class))
					{
						MethodMatchConf parentMc = findMethod(parent, methodName, parameterType);
						if (parentMc != null)
						{
							return parentMc;
						}
					}
					// 最后返回自己
					return selfMc;

				}
			}

		}

		return null;
	}

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
	//	public void call(long c, Object k)
	//	{
	//		System.out.println(c + "" + k);
	//	}
	//
	//	public static void main(String[] args) throws Exception
	//	{
	//		ObjectUtil o = new ObjectUtil();
	//		Method m = o.getClass().getMethod("call", new Class[]
	//		{ long.class, Object.class });
	//		m.invoke(o, new Object[]
	//		{ new Double(2), "hi" });
	//	}

}
