package com.beetl.test.junit;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import junit.framework.TestCase;

import org.beetl.core.Configuration;
import org.beetl.core.GroupTemplate;
import org.beetl.core.Template;
import org.beetl.core.res.FileResourceLoader;

public class BasicTestCase extends TestCase {
	static String home = null;
	public static boolean enableOptimize = true;
	public static GroupTemplate gt = null;
	static {

		home = System.getProperty("user.dir") + File.separator + "template"
				+ File.separator;
		Configuration cf = Configuration.defaultConfiguration();
		cf.setStatementStart("<%");
		cf.setStatementEnd("%>");
		FileResourceLoader rs = new FileResourceLoader(home, cf.getCharset());
		gt = new GroupTemplate(rs, cf);

	}

	public BasicTestCase() {

	}

	protected String getFileContent(String path) throws IOException {
		InputStreamReader fr = new InputStreamReader(new FileInputStream(home
				+ File.separator + path), "UTF-8");

		StringBuilder temp = new StringBuilder();
		int bufSzie = 1024;
		char[] cs = new char[bufSzie];
		int len = -1;

		while ((len = fr.read(cs)) != -1) {
			temp.append(cs, 0, len);

		}
		return temp.toString();
	}

	protected void bind(Template t, Object... objects) {
		for (int i = 0; i < objects.length; i = i + 2) {
			t.binding(objects[i].toString(), objects[i + 1]);
		}
	}

	protected void print(String str) {
		System.out.println(str);
	}

}
