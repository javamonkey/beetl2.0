package org.beetl.core.lab;

import java.io.IOException;
import java.net.URL;

public class Test
{

	/**
	 * @param args
	 */
	public static void main(String[] args) throws IOException
	{
		//		ResourceLoader rs = new ClasspathResourceLoader("/org/beetl/core/lab/");
		//		Configuration cf = new Configuration();
		//		GroupTemplate gt = new GroupTemplate(rs, cf);
		//		Template t = gt.getTemplate("/grammer.txt");
		//		String result = t.render();
		//		System.out.println(result);

		URL url = Test.class.getResource("/org/beetl/core/lab/test.class");
		//url = Test.class.getResource("/org/antlr/runtime/ANTLRFileStream.class");

		System.out.println(url.getFile());
		System.out.println(url.getProtocol());

	}
}
