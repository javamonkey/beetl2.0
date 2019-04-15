/**
 * 
 */
package org.beetl.core.om.asm;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.beetl.core.om.AttributeAccess;

/**
 * @author laozhaishaozuo@foxmail.com
 *
 */
public class ASMBeanFactory extends ClassLoader {

	private static final Map<Class<?>, AttributeAccess> beanMap = new ConcurrentHashMap<>();

	public static void setUsePropertyDescriptor(boolean usePropertyDescriptor) {
		GeneratedBeanLoader.usePropertyDescriptor = usePropertyDescriptor;
	}

	public static Object value(Object bean, String attrName) {
		Class<?> beanClass = bean.getClass();
		AttributeAccess generatedBean = generateBean(beanClass);
		return generatedBean == null ? null : generatedBean.value(bean, attrName);
	}

	public static synchronized AttributeAccess generateBean(Class<?> beanClass) {
		if (beanMap.containsKey(beanClass)) {
			return beanMap.get(beanClass);
		}
		Class<?> enhanceClass = GeneratedBeanLoader.loadBean(beanClass);
		Object obj = null;
		try {
			obj = enhanceClass.newInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}
		beanMap.put(beanClass, (AttributeAccess) obj);
		return beanMap.get(beanClass);
	}
}
