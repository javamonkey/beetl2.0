package org.beetl.core.om.asm;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

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

	static ClassDescription getClassDescription(String clazzName) {
		ClassDescription classDescription = new ClassDescription();

		ClassReader reader;
		try {
			reader = new ClassReader(clazzName);
			ClassNode cn = new ClassNode();
			reader.accept(cn, 0);

			classDescription.fieldMap = buildFiledMap(cn);

			classDescription.methodNameDescSet = buildMethodNameSet(cn);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return classDescription;
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
