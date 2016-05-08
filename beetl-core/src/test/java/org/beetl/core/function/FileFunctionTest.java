package org.beetl.core.function;

import java.io.IOException;
import java.util.Properties;

import org.beetl.core.BasicTestCase;
import org.beetl.core.Configuration;
import org.beetl.core.GroupTemplate;
import org.beetl.core.Template;
import org.beetl.core.resource.ClasspathResourceLoader;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

public class FileFunctionTest extends BasicTestCase
{
	private static ClasspathResourceLoader newRs;
	public static boolean enableOptimize = true;
	public static GroupTemplate newGt = null;
	static
	{
		Properties ps = new Properties();
		ps.setProperty("FUNCTION_TAG_LIMITER", "<%;%>");
		ps.setProperty("DELIMITER_STATEMENT_START", "@");
		ps.setProperty("DELIMITER_STATEMENT_END", "null");
		Configuration cf;
		try
		{
			cf = new Configuration(ps);
//			System.out.println(cf.getStatementStart()+":"+cf.getStatementEnd()+" fn"+cf.getFunctionLimiterStart());
			
		}
		catch (IOException e)
		{
			throw new RuntimeException(e);
		}
		
		
		

		newRs = new ClasspathResourceLoader("/template");

		newGt = new GroupTemplate(newRs, cf);

	}
	@Test
	public void testFunctionDilimter() throws Exception{
		//测试html 方法和注解允许使用特殊符号
		Template t = newGt.getTemplate("/function/dilimter_template.html");

		String str = t.render();
		AssertJUnit.assertEquals(this.getFileContent("/function/dilimter_expected.html"), str);

		t = newGt.getTemplate("/function/dilimter_template.html");

		str = t.render();
		AssertJUnit.assertEquals(this.getFileContent("/function/dilimter_expected.html"), str);

	}
	
	@Test
	public void testFileFunctionRetrun() throws Exception
	{

		Template t = gt.getTemplate("/function/file_template.html");

		String str = t.render();
		AssertJUnit.assertEquals(this.getFileContent("/function/file_expected.html"), str);

		t = gt.getTemplate("/function/file_template.html");

		str = t.render();
		AssertJUnit.assertEquals(this.getFileContent("/function/file_expected.html"), str);
	}

	@Test
	public void testRecurFileFunctionRetrun() throws Exception
	{

		Template t = gt.getTemplate("/function/file_recur_template.html");

		String str = t.render();
		AssertJUnit.assertEquals(this.getFileContent("/function/file_recur_expected.html"), str);

		t = gt.getTemplate("/function/file_recur_template.html");

		str = t.render();
		AssertJUnit.assertEquals(this.getFileContent("/function/file_recur_expected.html"), str);
	}

}
