package org.beetl.core.lab;

import org.beetl.core.util.ObjectUtil;

public class Test
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		Class c = short.class;
		System.out.println(c);
		String clsName = "java.util.concurrent.atomic.AtomicLong";
		Class c1 = ObjectUtil.getClassByName(clsName);
		System.out.println(c1);

	}

}
