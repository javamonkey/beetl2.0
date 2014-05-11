package org.beetl.core.lab;

import org.beetl.core.io.FloatingIOWriter;

public class TestIO
{

	public static void main(String[] args)
	{
		FloatingIOWriter fd = new FloatingIOWriter(1.222333);
		String str = fd.toJavaFormatString();
		System.out.println(str);

	}

}
