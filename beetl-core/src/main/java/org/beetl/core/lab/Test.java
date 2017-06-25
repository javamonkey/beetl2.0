package org.beetl.core.lab;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.StringWriter;
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
import org.beetl.core.exception.BeetlException;
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
		List list = new ArrayList();
		list.add(null);
		list.add(new TestUser("abc"));
		HashMap map = new HashMap();
		map.put("key", 123);

		for (int i = 0; i < 1; i++) {

			Template t = gt.getTemplate("/hello.txt");
			BeetlException exception = t.validate();
			if(exception!=null){
				StringWriter sw = new StringWriter();
				gt.getErrorHandler().processExcption(exception,sw);
				System.out.println("hello "+sw.toString());
				return ;
			}
//			Template t = gt.getAjaxTemplate("/hello.txt","part1");
			
			t.binding("a",5);
			t.binding("user", new TestUser("a"));
			System.out.println(t.render());
			

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
