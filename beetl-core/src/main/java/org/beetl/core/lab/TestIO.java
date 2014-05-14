package org.beetl.core.lab;

import java.lang.reflect.Method;

public class TestIO
{

	public static void main(String[] args) throws Exception
	{
		Object a = new TestIO();
		Method m = a.getClass().getMethod("test", new Class[]
		{ long.class });
		m.invoke(new TestIO(), new Object[]
		{ 1.1 });
	}

	public void test(long l)
	{
		System.out.println("l");
	}

}
