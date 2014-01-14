package org.beetl.core.attr;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.beetl.core.exception.TempException;

/**
 * 默认的，通用的属性读取器
 * 
 * @author joelli
 * 
 */
public class ObjectAA extends AA {

	private Class[] getParasType = new Class[] {};
	private Object[] getParasObjects = new Object[] {};
	static ObjectAA defaultAA = new ObjectAA();
	Map<String, Method> cache = new ConcurrentHashMap<String, Method>();

	public static ObjectAA defaultObjectAA() {
		return defaultAA;
	}

	@Override
	public Object value(Object o, Object name) {
		if (o instanceof Map) {
			return ((Map) o).get(name);
		} else if (o instanceof List) {
			return ((List) o).get(((Number) name).intValue());
		} else if (o.getClass().isArray()) {
			return ((Object[]) o)[(((Number) name).intValue())];
		} else if (isGeneralGet(o.getClass())) {
			// 检测是否是General Get
			return null;
		} else {
			String attrName = (String) name;
			String key = o.getClass() + "_" + name;
			Method cacheMethod = cache.get(key);
			if (cacheMethod != null) {
				try {
					return cacheMethod.invoke(o, getParasObjects);
				} catch (IllegalArgumentException e) {
					throw new TempException(e.getMessage());
				} catch (IllegalAccessException e) {
					throw new TempException(e.getMessage());
				} catch (InvocationTargetException e) {
					throw new TempException(e.getMessage());
				}
			}

			StringBuilder mbuffer = new StringBuilder("get");
			mbuffer.append(attrName.substring(0, 1).toUpperCase()).append(
					attrName.substring(1));

			String getName = mbuffer.toString();
			try {
				Method method = o.getClass().getMethod(mbuffer.toString(),
						getParasType);
				cache.put(o.getClass() + "_" + name, method);
				return method.invoke(o, getParasObjects);
			} catch (NoSuchMethodException e) {
				// throw new TempException(e.getMessage());
			} catch (SecurityException e) {
				// throw new TempException(e.getMessage());
			} catch (IllegalAccessException e) {
				// throw new TempException(e.getMessage());
			} catch (IllegalArgumentException e) {
				// throw new TempException(e.getMessage());
			} catch (InvocationTargetException e) {
				// throw new TempException(e.getMessage());
			}

			attrName = (String) name;
			mbuffer = new StringBuilder("is");
			mbuffer.append(attrName.substring(0, 1).toUpperCase()).append(
					attrName.substring(1));

			getName = mbuffer.toString();
			try {
				Method method = o.getClass().getMethod(mbuffer.toString(),
						getParasType);
				cache.put(o.getClass() + "_" + name, method);
				return method.invoke(o, getParasObjects);
			} catch (NoSuchMethodException e) {
				throw new TempException(e.getMessage());
			} catch (SecurityException e) {
				throw new TempException(e.getMessage());
			} catch (IllegalAccessException e) {
				throw new TempException(e.getMessage());
			} catch (IllegalArgumentException e) {
				throw new TempException(e.getMessage());
			} catch (InvocationTargetException e) {
				throw new TempException(e.getMessage());
			}

			// 反射调用

		}
	}

	protected boolean isGeneralGet(Class c) {
		return false;
	}

}
