package org.beetl.core.om.asm;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.beetl.core.exception.BeetlException;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.tree.ClassNode;
import org.objectweb.asm.tree.FieldNode;
import org.objectweb.asm.tree.MethodNode;

/**
 * 
 * 工具类
 * @author laozhaishaozuo@foxmail.com
 *
 */
final class BeanEnhanceUtils {

	private BeanEnhanceUtils() {

	}

	private static Set<String> ignoreSet = new HashSet<>();
	static {
		ignoreSet.add("getClass");// 避免获取到java.lang.Object.getClass()方法
	}

	static ClassDescription getClassDescription(String clazzName) {
		return getClassDescription(clazzName, true);
	}

	/**
	 * 注意，使用propertyDescriptor获取的属性，与字段名称可能不一致
	 * @param clazzName
	 * @param usePropertyDescriptor
	 * @return
	 */
	static ClassDescription getClassDescription(String clazzName, boolean usePropertyDescriptor) {
		ClassDescription classDescription = new ClassDescription();

		ClassReader reader;
		try {
			reader = new ClassReader(clazzName);
			ClassNode cn = new ClassNode();
			reader.accept(cn, 0);
			if (usePropertyDescriptor) {
				classDescription.propertyMap = buildPropertyMap(clazzName);
			} else {
				classDescription.fieldMap = buildFiledMap(cn);
			}
			classDescription.methodNameDescSet = buildMethodNameSet(cn);
		} catch (IOException | ClassNotFoundException | IntrospectionException e) {
			throw new BeetlException(BeetlException.ERROR, "ASM增加功能，生成类:" + clazzName + " 描述错误", e);
		}
		return classDescription;
	}


	protected static PropertyDescriptor[] getPropertyDescriptors(String clazzName)
			throws IntrospectionException, ClassNotFoundException {
		Class<?> beanClassName = BeanEnhanceUtils.class.getClassLoader().loadClass(clazzName);
		BeanInfo beanInfo = Introspector.getBeanInfo(beanClassName);
		return beanInfo.getPropertyDescriptors();

	}

	private static Map<Integer, List<PropertyDescriptor>> buildPropertyMap(String clazzName)
			throws ClassNotFoundException, IntrospectionException {
		PropertyDescriptor[] propDescriptors = getPropertyDescriptors(clazzName);
		List<PropertyDescriptor> propList = new ArrayList<>(propDescriptors.length);
		propList.addAll(Arrays.asList(propDescriptors));
		Map<Integer, List<PropertyDescriptor>> propertyMap = new LinkedHashMap<>();
		// 先对其按照hashCode进行排序，方便后续生产代码
		propList.sort((p1, p2) -> Integer.compare(p1.getName().hashCode(), p2.getName().hashCode()));
		int hashCode = 0;
		List<PropertyDescriptor> props = null;
		for (PropertyDescriptor prop : propList) {
			if (prop.getReadMethod() != null && !ignoreSet.contains(prop.getReadMethod().getName())) {
				hashCode = prop.getName().hashCode();
				System.out.println("hashCode:" + hashCode + ",name:" + prop.getName());
				props = propertyMap.get(hashCode);
				if (props == null) {
					props = new ArrayList<>();
				}
				props.add(prop);
				propertyMap.put(hashCode, props);
			}
		}
		return propertyMap;

	}

	private static Map<Integer, List<FieldNode>> buildFiledMap(ClassNode cn) {
		@SuppressWarnings("unchecked")
		List<FieldNode> fieldList = cn.fields;
		Map<Integer, List<FieldNode>> filedMap = new LinkedHashMap<>();
		// 先对其按照hashCode进行排序，方便后续生产代码
		fieldList.sort((f1, f2) -> Integer.compare(f1.name.hashCode(), f2.name.hashCode()));
		int hashCode = 0;
		List<FieldNode> fileNodes = null;
		for (FieldNode fieldNode : fieldList) {
			hashCode = fieldNode.name.hashCode();
			fileNodes = filedMap.get(hashCode);
			if (fileNodes == null) {
				fileNodes = new ArrayList<>();
			}
			fileNodes.add(fieldNode);
			filedMap.put(hashCode, fileNodes);
		}
		return filedMap;
	}

	/**
	 * 获取类中的方法名，形式如：get(Ljava/lang/Object;)Ljava/lang/Object;
	 * @param clazzName
	 * @return
	 */
	private static Set<String> buildMethodNameSet(ClassNode cn) {
		@SuppressWarnings("unchecked")
		List<MethodNode> methodNodes = cn.methods;
		Set<String> methodNames = new HashSet<>();
		for (MethodNode methodNode : methodNodes) {
			methodNames.add(methodNode.name + methodNode.desc);
		}
		return methodNames;
	}

	static String createGetterMethodName(String propertyName) {
		return "get" + propertyName.substring(0, 1).toUpperCase() + propertyName.substring(1);
	}

	static String getSimpleClassName(String className) {
		return className.substring(className.lastIndexOf(PunctuationConstants.PERIOD) + 1);
	}


	static String getInternalName(final String className) {
		return className.replace(PunctuationConstants.PERIOD_CHAR, PunctuationConstants.SLASH_CHAR);
	}

	static int[] convertIntegerToPrimitiveType(Integer[] source) {
		int[] target = new int[source.length];
		for (int i = 0; i < source.length; i++) {
			target[i] = source[i];
		}
		return target;
	}
}
