package org.beetl.core.lab;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.Hashtable;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
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

		//		Object obj = new TestUser("");
		//		Method[] ms = obj.getClass().getMethods();
		//		for (Method m : ms)
		//		{
		//			if (m.getName().equals("printUsers1"))
		//			{
		//				Object arrayObj = Array.newInstance(String.class, 2);
		//				Array.set(arrayObj, 0, "Hello");
		//				Array.set(arrayObj, 1, "World");
		//
		//				m.invoke(obj, new Object[]
		//				{ arrayObj });
		//			}
		//		}

		ClasspathResourceLoader resourceLoader = new ClasspathResourceLoader();
		Configuration cfg = Configuration.defaultConfiguration();
		cfg.setDirectByteOutput(true);
		cfg.getResourceMap().put("RESOURCE.autoCheck", "true");
		GroupTemplate gt = new GroupTemplate(resourceLoader, cfg);
		cfg.setStatementStart("<%");
		cfg.setStatementEnd("%>");
		gt.registerFunctionPackage("strings", new StringUtils());
		gt.registerTag("menu", TestGeneralVarTagBinding.class);
		gt.registerFunction("testFun", new TestFun());
		gt.registerFunctionPackage("test", new TestUser(""));
		for (int i = 0; i < 1; i++)
		{

			//			Map result = gt.runScript("/org/beetl/core/lab/hello.txt", Collections.EMPTY_MAP);
			//			System.out.println(result);

			Hashtable table = new Hashtable();
			table.put("a", "b");
			table.put("c", "d");

			TestUser user = new TestUser("lijz");
			List list = new ArrayList();
			list.add(user);

			//	user.setLover(new TestUser("miaojun"));
			Template t = gt.getTemplate("/org/beetl/core/lab/hello.txt");
			t.binding("footer", Boolean.TRUE);
			t.binding("user", user);
			t.binding("date1", new Date(10002));
			t.binding("date2", new Date(10002));
			t.binding("total", 15);
			t.binding("list", list);
			t.binding("array", new int[]
			{ 1, 2, 3 });
			t.binding("table", table.elements());

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
