package org.beetl.core.lab;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.beetl.core.Configuration;
import org.beetl.core.Context;
import org.beetl.core.Function;
import org.beetl.core.GroupTemplate;
import org.beetl.core.ResourceLoader;
import org.beetl.core.Template;
import org.beetl.core.resource.ClasspathResourceLoader;
import org.beetl.core.statement.PlaceholderST;

/**
 * http://sports.qq.com/a/20151126/029300.htm
 * 
 * @author xiandafu
 *
 */
public class Test {
	public static void main(String[] args) throws Exception {

		ClasspathResourceLoader resourceLoader = new ClasspathResourceLoader("org/beetl/core/lab/");
		Configuration cfg = Configuration.defaultConfiguration();
		cfg.setDirectByteOutput(true);
		cfg.getResourceMap().put("tagRoot", "/");
		cfg.getPkgList().add("org.beetl.core.lab.");

		GroupTemplate gt = new GroupTemplate(resourceLoader, cfg);
		
		
		cfg.setStatementStart("<%");
		cfg.setStatementEnd("%>");

		// cfg.setPlaceholderStart("{{");
		// cfg.setPlaceholderEnd("}}");
		//
		gt.registerFunction("test", new TestFun());
		gt.registerTag("test", TestTag.class);
		PlaceholderST.output = new PlaceholderST.Output() {

			@Override
			public void write(Context ctx, Object value) throws IOException {
				ctx.byteWriter.writeString(value == null ? "null" : value.toString());

			}

		};
		List list = new ArrayList();
		list.add(null);
		list.add(new TestUser("abc"));
		HashMap map = new HashMap();
		map.put("key", 123);

		for (int i = 0; i < 1; i++) {

			Template t = gt.getTemplate("/hello.txt");
//			Template t = gt.getAjaxTemplate("/hello.txt","part1");
			
			t.binding("a",5);
			t.binding("user", new TestUser("a"));
			
			ByteArrayOutputStream bs = new ByteArrayOutputStream();
			try {
				t.renderTo(bs);
			} catch (Exception ex) {
				ex.printStackTrace();
			}

			System.out.println(new String(bs.toByteArray()));

		}

	}

	public static void testOne() {

	}
	
	public static String getRealPath(ResourceLoader loader,String path){
		String[] paths = path.split("/");
		Map<String,String> paras = new HashMap<String,String>();
		String realPath = "";
		for(String p:paths){
			if(p.length()==0||p.equals("/")){
				continue ;
			}
			
			String temp = realPath +"/"+p;
			boolean exist = loader.exist(temp);
			if(!exist){
				temp = realPath+"/$$";
				exist = loader.exist(temp);
				if(!exist){
					return null;
				}else{
					realPath=temp;
				}
			}else{
				realPath=temp;
				continue ;
			}
			
		}
		return realPath;
		
	}

	public static class TestFun implements Function {

		@Override
		public String[] call(Object[] paras, Context ctx) {
			List list = new ArrayList();
			list.add("hi");
			list.add("joel");
			System.out.println("list -----");
			return (String[]) list.toArray(new String[0]);

		}

	}

}
