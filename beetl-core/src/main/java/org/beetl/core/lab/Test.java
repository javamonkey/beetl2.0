package org.beetl.core.lab;

import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.Map;

import org.beetl.core.Configuration;
import org.beetl.core.GroupTemplate;
import org.beetl.core.Template;
import org.beetl.core.resource.ClasspathResourceLoader;

public class Test
{
	public static void main(String[] args) throws Exception
	{

		ClasspathResourceLoader resourceLoader = new ClasspathResourceLoader();
		Configuration cfg = Configuration.defaultConfiguration();
		cfg.setDirectByteOutput(true);
		GroupTemplate gt = new GroupTemplate(resourceLoader, cfg);
		for (int i = 0; i < 2; i++)
		{
			Template t = gt.getTemplate("/org/beetl/core/lab/hello.txt");
			Map a = new HashMap();
			a.put("a", new HashMap());
			a.put("b", 123);
			a.put("c", "123");

			t.binding("map", a);
			ByteArrayOutputStream bs = new ByteArrayOutputStream();
			t.renderTo(bs);
			System.out.println(new String(bs.toByteArray()));

		}

	}
}
