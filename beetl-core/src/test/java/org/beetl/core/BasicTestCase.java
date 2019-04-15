package org.beetl.core;

import java.io.IOException;
import java.io.Reader;

import org.beetl.core.resource.ClasspathResourceLoader;

import junit.framework.TestCase;



public class BasicTestCase extends TestCase {
	// 日志对象

	private static ClasspathResourceLoader rs;
	public static boolean enableOptimize = true;
	public static GroupTemplate gt = null;
	static
	{

		Configuration cf;
		try
		{
			cf = new Configuration();
		}
		catch (IOException e)
		{
			throw new RuntimeException(e);
		}
		cf.setStatementStart("<%");
		cf.setStatementEnd("%>");
		cf.addPkg("org.beetl.core");
		cf.addPkg("org.beetl.core.nativecall");
		cf.setHtmlTagSupport(true);

		// FileResourceLoader rs = new FileResourceLoader(home,
		// cf.getCharset());
		rs = new ClasspathResourceLoader("template/");

		gt = new GroupTemplate(rs, cf);



	}

	public BasicTestCase()
	{

	}

	protected String getFileContent(String path) throws IOException
	{
		Reader fr = rs.getResource(path).openReader();
		StringBuilder temp = new StringBuilder();
		int bufSzie = 1024;
		char[] cs = new char[bufSzie];
		int len = -1;

		while ((len = fr.read(cs)) != -1)
		{
			temp.append(cs, 0, len);

		}
		return temp.toString();
	}

	protected void bind(Template t, Object... objects)
	{
		for (int i = 0; i < objects.length; i = i + 2)
		{
			t.binding(objects[i].toString(), objects[i + 1]);
		}
	}

}
