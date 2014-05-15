package org.beetl.core.lab;

import java.lang.reflect.Method;

public class TestIO
{

	public static void main(String[] args) throws NoSuchMethodException, SecurityException
	{
		TestIO test = new TestIO();
		Method m = test.getClass().getMethod("testId", new Class[]
		{ int.class });

	}

	public void testId(int id)
	{
		System.out.println(id);
	}

}
