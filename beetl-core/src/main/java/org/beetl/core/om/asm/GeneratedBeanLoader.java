package org.beetl.core.om.asm;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 用来加载生成bean的ClassLoader
 * @author laozhaishaozuo@foxmail.com
 *
 */
public class GeneratedBeanLoader extends ClassLoader {

	private static GeneratedBeanLoader loader = new GeneratedBeanLoader();
	static boolean usePropertyDescriptor = true;

	/**
	 * 生成并加载增强类
	 * @param beanClass
	 * @return
	 */
	static Class<?> loadBean(final Class<?> beanClass) {
		String generatedBeanName = EnhanceClassGenerator.createGeneratedClassName(beanClass);
		return createAndLoadGeneratedClass(beanClass, generatedBeanName);
	}

	/**
	 * 根据类名加载类
	 * @param clazzName
	 * @return
	 */
	static Class<?> loadBean(final String clazzName) {
		Class<?> clazz = null;
		try {
			clazz = GeneratedBeanLoader.getSystemClassLoader().loadClass(clazzName);
		} catch (Throwable throwable) {
			// Do nothing
			throwable.printStackTrace();
		}
		return clazz;
	}

	/**
	 * 使用asm生成，并加载了
	 * 
	 * @param beanClass
	 * @param generatedBeanName
	 * @return
	 */
	private static Class<?> createAndLoadGeneratedClass(final Class<?> beanClass, final String generatedBeanName) {
		Class<?> generatedClass = null;
		try {
			byte[] code = EnhanceClassGenerator.generate(beanClass, usePropertyDescriptor);
			// TODO 是否需要
			// writeClassToFile(code, beanClass, generatedBeanName);
			generatedClass = loader.defineClass(generatedBeanName, code, 0, code.length);
			code = null;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return generatedClass;
	}

	private static void writeClassToFile(final byte[] code, final Class<?> beanClass, final String generatedBeanName) {
		try {
			String classPath = beanClass.getResource("").getPath();
			// 将二进制流写到本地磁盘上
			File file = new File(classPath, BeanEnhanceUtils.getSimpleClassName(generatedBeanName) + ".class");
			System.out.println(file.getAbsolutePath());
			FileOutputStream fos = new FileOutputStream(file);
			fos.write(code);
			fos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
