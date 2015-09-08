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
				gt.registerTag("table", TestGeneralVarTagBinding.class);
				for (int i = 0; i < 2; i++)
				{
					
					Template t = gt.getTemplate("/org/beetl/core/lab/hello.txt");
					if(i==0){
						t.binding("user", new TestUser(""));
					}else{
						t.binding("user", new Object());
					}
					
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

	public static String parse(String attr)
	{
		String q = "\"";
		StringBuilder sb = new StringBuilder(attr.length() + 10);
		int start = 0;
		int end = 0;
		int index = -1;
		while ((index = attr.indexOf("${", start)) != -1)
		{
			end = attr.indexOf("}", index);
			if (end == -1)
				throw new RuntimeException("aa");
			if (index != 0)
			{
				sb.append(q).append(attr.substring(start, index)).append(q).append("+");
			}

			sb.append("(").append(attr.substring(index + 2, end)).append(")").append("+");
			start = end + 1;
		}
		if (start == 0)
		{
			return sb.append(q).append(attr).append(q).toString();
		}
		if (start != attr.length())
		{

			sb.append(q).append(attr.substring(start, attr.length())).append(q);
		}
		else
		{
			sb.setLength(sb.length() - 1);
		}
		return sb.toString();

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
