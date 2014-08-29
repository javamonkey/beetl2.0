package org.beetl.core.lab;

import java.io.ByteArrayOutputStream;

import org.apache.commons.lang3.StringUtils;
import org.beetl.core.Configuration;
import org.beetl.core.GroupTemplate;
import org.beetl.core.Template;
import org.beetl.core.resource.ClasspathResourceLoader;

public class Test
{
	public static void main(String[] args) throws Exception
	{

		System.out.println(System.currentTimeMillis());
		ClasspathResourceLoader resourceLoader = new ClasspathResourceLoader();
		Configuration cfg = Configuration.defaultConfiguration();
		cfg.setDirectByteOutput(true);
		GroupTemplate gt = new GroupTemplate(resourceLoader, cfg);
		cfg.setStatementStart("<%");
		cfg.setStatementEnd("%>");
		gt.registerFunctionPackage("strings", new StringUtils());
		gt.registerTag("menu", TestGeneralVarTagBinding.class);
		for (int i = 0; i < 1; i++)
		{

			Template t = gt.getTemplate("/org/beetl/core/lab/hello.txt");
			t.binding("footer", Boolean.TRUE);
			t.binding("user", null);
			t.binding("color", Color.READ);

			ByteArrayOutputStream bs = new ByteArrayOutputStream();
			t.renderTo(bs);
			System.out.println(new String(bs.toByteArray()));

		}

	}
}
