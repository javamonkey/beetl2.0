package org.beetl.core.lab;

import java.io.ByteArrayOutputStream;

import org.beetl.core.Configuration;
import org.beetl.core.GroupTemplate;
import org.beetl.core.Template;
import org.beetl.core.resource.ClasspathResourceLoader;

public class Test
{
	public static void main(String[] args) throws Exception
	{

		char c = 0xc;
		System.out.println(c);
		ClasspathResourceLoader resourceLoader = new ClasspathResourceLoader();
		Configuration cfg = Configuration.defaultConfiguration();
		cfg.setDirectByteOutput(true);
		GroupTemplate gt = new GroupTemplate(resourceLoader, cfg);
		for (int i = 0; i < 2; i++)
		{
			Template t = gt.getTemplate("/org/beetl/core/lab/hello.txt");

			t.binding("array", new Integer[]
			{ 1, 2, 3, 4 });
			t.binding("pt", new TestUser("").getPt());
			ByteArrayOutputStream bs = new ByteArrayOutputStream();
			t.renderTo(bs);
			System.out.println(new String(bs.toByteArray()));

		}

	}

}
