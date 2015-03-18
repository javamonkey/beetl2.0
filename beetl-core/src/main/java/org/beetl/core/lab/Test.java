package org.beetl.core.lab;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;

import org.beetl.core.Configuration;
import org.beetl.core.Context;
import org.beetl.core.Function;
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
		cfg.getResourceMap().put("RESOURCE.autoCheck", "true");
		GroupTemplate gt = new GroupTemplate(resourceLoader, cfg);
		cfg.setStatementStart("<%");
		cfg.setStatementEnd("%>");
		gt.registerFunctionPackage("test", new TestUser(""));
		for (int i = 0; i < 1; i++)
		{

			Template t = gt.getTemplate("/org/beetl/core/lab/hello.txt");

			ByteArrayOutputStream bs = new ByteArrayOutputStream();
			try
			{
				t.renderTo(bs);
			}
			catch (Exception ex)
			{
				ex.printStackTrace();
			}

			System.out.println(new String(bs.toByteArray()));

		}

	}

	public static class TestFun implements Function
	{

		@Override
		public List call(Object[] paras, Context ctx)
		{
			List list = new ArrayList();
			list.add("hi");
			list.add("joel");
			System.out.println("list -----");
			return list;
		}

	}
}
