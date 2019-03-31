package org.beetl.core.tag;

import java.io.IOException;
import java.util.Properties;

import org.beetl.core.BasicTestCase;
import org.beetl.core.Configuration;
import org.beetl.core.GroupTemplate;
import org.beetl.core.Template;
import org.beetl.core.User;
import org.beetl.core.resource.ClasspathResourceLoader;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

public class HtmlTagTest extends BasicTestCase
{
	
	//用于测试模板和tag 使用不同的定界符 2.4.0
	private static ClasspathResourceLoader newRs;
	public static boolean enableOptimize = true;
	public static GroupTemplate newGt = null;
	static
	{
		Properties ps = new Properties();
		
		ps.setProperty("DELIMITER_STATEMENT_START", "@");
		ps.setProperty("DELIMITER_STATEMENT_END", "null");
		ps.setProperty("DELIMITER_STATEMENT_START2", "<%");
		ps.setProperty("DELIMITER_STATEMENT_END2", "%>");
		
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
	public void testDilimterHtmlTag() throws Exception
	{

		Template t = newGt.getTemplate("/tag/html_dilimeter_template.html");
		this.bind(t, "list", User.getTestUsers());
		String str = t.render();
		AssertJUnit.assertEquals(this.getFileContent("/tag/html_dilimeter_expected.html"), str);

		
	}
	
	
	
	@Test
	public void testHtmlTag() throws Exception
	{

		Template t = gt.getTemplate("/tag/html_template.html");
		this.bind(t, "list", User.getTestUsers());
		String str = t.render();
		AssertJUnit.assertEquals(this.getFileContent("/tag/html_expected.html"), str);

		t = gt.getTemplate("/tag/html_template.html");
		this.bind(t, "list", User.getTestUsers());
		str = t.render();
		AssertJUnit.assertEquals(this.getFileContent("/tag/html_expected.html"), str);

	}

	@Test
	public void testNS() throws Exception
	{

		Template t = gt.getTemplate("/tag/html2_template.html");
		this.bind(t, "list", User.getTestUsers());
		String str = t.render();
		AssertJUnit.assertEquals(this.getFileContent("/tag/html2_expected.html"), str);

		
	}

	@Test
	public void testMutilTagInSamePage() throws Exception
	{

		Template t = gt.getTemplate("/tag/html3_template.html");
		this.bind(t, "list", User.getTestUsers());
		String str = t.render();
		AssertJUnit.assertEquals(this.getFileContent("/tag/html3_expected.html"), str);

	
	}

	@Test
	public void testEmptyTag() throws Exception
	{

		Template t = gt.getTemplate("/tag/html4_template.html");
		this.bind(t, "list", User.getTestUsers());
		String str = t.render();
		AssertJUnit.assertEquals(this.getFileContent("/tag/html4_expected.html"), str);

		
	}

	@Test
	public void testJavaTag() throws Exception
	{

		gt.registerTag("simpleTag", SimpleHtmlTag.class);
		Template t = gt.getTemplate("/tag/html5_template.html");

		String str = t.render();
		AssertJUnit.assertEquals(this.getFileContent("/tag/html5_expected.html"), str);

	
	}

	@Test
	public void testExpTag() throws Exception
	{

		Template t = gt.getTemplate("/tag/html6_template.html");

		String str = t.render();
		AssertJUnit.assertEquals(this.getFileContent("/tag/html6_expected.html"), str);

	
	}

	@Test
	public void testCallMutipleTag() throws Exception
	{

		Template t = gt.getTemplate("/tag/html7_template.html");

		String str = t.render();
		AssertJUnit.assertEquals(this.getFileContent("/tag/html7_expected.html"), str);

	
	}

	@Test
	public void testHolderInAttr() throws Exception
	{

		Template t = gt.getTemplate("/tag/html8_template.html");
		t.binding("a", 1);
		String str = t.render();
		AssertJUnit.assertEquals(this.getFileContent("/tag/html8_expected.html"), str);

	
	}

}
