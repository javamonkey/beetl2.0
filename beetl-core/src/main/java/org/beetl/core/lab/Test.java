package org.beetl.core.lab;

import java.io.ByteArrayOutputStream;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.beetl.core.Configuration;
import org.beetl.core.Context;
import org.beetl.core.Function;
import org.beetl.core.GroupTemplate;
import org.beetl.core.Template;
import org.beetl.core.resource.ClasspathResourceLoader;
/**
 * http://sports.qq.com/a/20151126/029300.htm
 * @author xiandafu
 *
 */
public class Test
{
	public static void main(String[] args) throws Exception
	{
		
		DecimalFormat df = new DecimalFormat("#.##");
		String str =  df.format(BigDecimal.ONE);
		System.out.println(str);
//			TestUser.Info info = TestUser.getInfo();
//			
//			Class c = info.getClass();
//			c.getClassLoader().
//			int m = c.getModifiers();
//			System.out.println(Modifier.isPublic(m));
				ClasspathResourceLoader resourceLoader = new ClasspathResourceLoader();
				Configuration cfg = Configuration.defaultConfiguration();
				cfg.setDirectByteOutput(true);
				cfg.getResourceMap().put("RESOURCE.autoCheck", "true");
				GroupTemplate gt = new GroupTemplate(resourceLoader, cfg);
				cfg.setStatementStart("<%");
				cfg.setStatementEnd("%>");
				gt.registerFunctionPackage("test", new TestUser(""));
				gt.registerTag("table", TestGeneralVarTagBinding.class);
				gt.registerFormat("nf",new NewFormat());
				for (int i = 0; i < 2; i++)
				{
					
					Template t = gt.getTemplate("/org/beetl/core/lab/hello.txt");
					t.binding("$page",new HashMap());
					t.binding("user", new TestUser(""));
					t.binding("cs", new ChargingStation());
					t.binding("info",TestUser.getInfo());
					t.binding("n", new BigDecimal("0.0000"));
					t.binding("bo", "a");
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
