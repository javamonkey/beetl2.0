package org.beetl.core.function;

import org.beetl.core.Context;

public class SampleFunctionPackage
{
	public void test1(Context ctx) throws Exception
	{
		ctx.byteWriter.write("hi");
		//ctx.byteWriter.write(ctx.template.program.metaData.lineSeparator);

	}

	public String test2()
	{
		return "hi";
	}

	public String test3(String input)
	{
		return input;
	}

	public int getAge(int age)
	{
		return age;
	}

	public int getMax(int a, int b)
	{
		return Math.max(a, b);
	}

	public int getMax(int a, int b, int c)
	{
		return Math.max(a, Math.max(b, c));
	}

	public int parseInt(String a)
	{
		return Integer.parseInt(a);
	}

	public int parseInt(double d)
	{
		return (int) d;
	}

}