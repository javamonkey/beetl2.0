package org.beetl.core.lab;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TestIO
{

	public static void main(String[] args) throws NoSuchMethodException, SecurityException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException
	{
		TestIO test = new TestIO();
		Method m = test.getClass().getMethod("testId", new Class[]
		{ int.class });
		m.invoke(test, new Object[]
		{ new Long(1) });

	}

	public void testId(int id)
	{
		System.out.println(id);
	}

}
