package org.beetl.core.lab;

import java.io.IOException;

import org.beetl.core.Configuration;
import org.beetl.core.GroupTemplate;
import org.beetl.core.ResourceLoader;
import org.beetl.core.Template;
import org.beetl.core.resource.ClasspathResourceLoader;

public class Test
{

	/**
	 * @param args
	 */
	public static void main(String[] args) throws IOException
	{
		ResourceLoader rs = new ClasspathResourceLoader("/org/beetl/core/lab/");
		Configuration cf = new Configuration();
		GroupTemplate gt = new GroupTemplate(rs, cf);
		Template t = gt.getTemplate("/grammer.txt");
		String result = t.render();
		System.out.println(result);

	}

}
