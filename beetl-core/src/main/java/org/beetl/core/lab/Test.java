package org.beetl.core.lab;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.beetl.core.Configuration;
import org.beetl.core.Context;
import org.beetl.core.Function;
import org.beetl.core.GroupTemplate;
import org.beetl.core.Template;
import org.beetl.core.resource.ClasspathResourceLoader;
import org.beetl.core.statement.PlaceholderST;
/**
 * http://sports.qq.com/a/20151126/029300.htm
 * @author xiandafu
 *
 */
public class Test
{
	public static void main(String[] args) throws Exception
	{
		
		
		
				ClasspathResourceLoader resourceLoader = new ClasspathResourceLoader("org/beetl/core/lab/");
				Configuration cfg = Configuration.defaultConfiguration();
				cfg.setDirectByteOutput(true);
				cfg.getResourceMap().put("tagRoot", "/");
				cfg.getPkgList().add("org.beetl.core.lab.");
				
				GroupTemplate gt = new GroupTemplate(resourceLoader, cfg);
				cfg.setStatementStart("<%");
				cfg.setStatementEnd("%>");
				
//				cfg.setPlaceholderStart("{{");
//				cfg.setPlaceholderEnd("}}");
//			
				gt.registerFunction("test", new TestFun());
				PlaceholderST.output = new PlaceholderST.Output(){

					@Override
					public void write(Context ctx, Object value) throws IOException {
						ctx.byteWriter.writeString(value==null?"null":value.toString());
						
					}
					
				};
			
			
				for (int i = 0; i < 1; i++)
				{
					
					Template t = gt.getTemplate("/hello.txt");
					t.binding("$page",new HashMap());
					t.binding("user", new TestUser(""));

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
	
	

	public static void testOne(){
		
	}

	public static class TestFun implements Function
	{

		@Override
		public String[] call(Object[] paras, Context ctx)
		{
			List list = new ArrayList();
			list.add("hi");
			list.add("joel");
			System.out.println("list -----");
			return (String[])list.toArray(new String[0]);
			
		}

	}
	
	
}
