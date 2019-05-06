package org.beetl.core.lab;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.beetl.core.*;
import org.beetl.core.io.NoLockStringWriter;
import org.beetl.core.resource.ClasspathResourceLoader;

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
		cfg.getResourceMap().put("tagRoot", "");
		cfg.getPkgList().add("org.beetl.core.lab.");

		GroupTemplate gt = new GroupTemplate(resourceLoader, cfg);
		gt.registerFunction("bigString", new TestFun());
		gt.registerTag("form",FormTag.class);
		 cfg.setStatementStart("@");
		 cfg.setStatementEnd(null);




		List list = new ArrayList();
		// list.add(new TestUser("abc"));

		HashMap map = new HashMap();
		map.put("key", 123);
		// gt.enableStrict();

		for (int i = 0; i < 1; i++) {

			Template t = gt.getTemplate("/hello.txt");
			// TestUser user = new TestUser("jo");
			// user.lover = new TestUser("dddd");
			// user.friends = list;
			// t.binding("user",user);
			t.binding("$page", new HashMap());
			Long a = 12342343434l;
			Object c = a;
			t.binding("x", a);
			t.binding("y", c);
			// t.binding("user", new TestUser("def"));
			String str = t.render();
			System.out.println(str);



		}

	}

	public static void testOne() {

	}

	public static class FormTag extends  GeneralVarTagBinding{

		@Override
		public void render() {
			Object[] args = this.args;

			this.binds("bac");
			this.doBodyRender();

		}


	}

	public static String getRealPath(ResourceLoader loader, String path) {
		String[] paths = path.split("/");
		Map<String, String> paras = new HashMap<String, String>();
		String realPath = "";
		for (String p : paths) {
			if (p.length() == 0 || p.equals("/")) {
				continue;
			}

			String temp = realPath + "/" + p;
			boolean exist = loader.exist(temp);
			if (!exist) {
				temp = realPath + "/$$";
				exist = loader.exist(temp);
				if (!exist) {
					return null;
				} else {
					realPath = temp;
				}
			} else {
				realPath = temp;
				continue;
			}

		}
		return realPath;

	}

	public static class TestFun implements Function {

		@Override
		public String call(Object[] paras, Context ctx) {
			StringBuilder sb = new StringBuilder();
			for(int i=0;i<1024*1000;i++) {
				sb.append("a");
			}
			sb.append("end");
			return sb.toString();

		}

	}

}
