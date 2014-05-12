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

		ClasspathResourceLoader resourceLoader = new ClasspathResourceLoader();
		Configuration cfg = Configuration.defaultConfiguration();
		cfg.setDirectByteOutput(true);
		GroupTemplate gt = new GroupTemplate(resourceLoader, cfg);

		Template t = gt.getTemplate("/org/beetl/core/lab/hello.txt");
		t.binding("list", new String[]
		{ "1", "2" });
		t.binding("user", new TestUser(""));
		ByteArrayOutputStream bs = new ByteArrayOutputStream();
		t.renderTo(bs);
		System.out.println(new String(bs.toByteArray()));

	}
}
