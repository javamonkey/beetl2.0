package org.beetl.core.tag;

import org.beetl.core.BasicTestCase;
import org.beetl.core.Template;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

public class HtmlTagTest extends BasicTestCase
{
	//	@Test
	//	public void testHtmlTag() throws Exception
	//	{
	//
	//		Template t = gt.getTemplate("/tag/html_template.html");
	//		this.bind(t, "list", User.getTestUsers());
	//		String str = t.render();
	//		AssertJUnit.assertEquals(this.getFileContent("/tag/html_expected.html"), str);
	//
	//		t = gt.getTemplate("/tag/html_template.html");
	//		this.bind(t, "list", User.getTestUsers());
	//		str = t.render();
	//		AssertJUnit.assertEquals(this.getFileContent("/tag/html_expected.html"), str);
	//
	//	}
	//
	//	@Test
	//	public void testNS() throws Exception
	//	{
	//
	//		Template t = gt.getTemplate("/tag/html2_template.html");
	//		this.bind(t, "list", User.getTestUsers());
	//		String str = t.render();
	//		AssertJUnit.assertEquals(this.getFileContent("/tag/html2_expected.html"), str);
	//
	//		t = gt.getTemplate("/tag/html2_template.html");
	//		this.bind(t, "list", User.getTestUsers());
	//		str = t.render();
	//		AssertJUnit.assertEquals(this.getFileContent("/tag/html2_expected.html"), str);
	//
	//	}
	//
	//	@Test
	//	public void testMutilTagInSamePage() throws Exception
	//	{
	//
	//		Template t = gt.getTemplate("/tag/html3_template.html");
	//		this.bind(t, "list", User.getTestUsers());
	//		String str = t.render();
	//		AssertJUnit.assertEquals(this.getFileContent("/tag/html3_expected.html"), str);
	//
	//		t = gt.getTemplate("/tag/html3_template.html");
	//		this.bind(t, "list", User.getTestUsers());
	//		str = t.render();
	//		AssertJUnit.assertEquals(this.getFileContent("/tag/html3_expected.html"), str);
	//
	//	}
	//
	//	@Test
	//	public void testEmptyTag() throws Exception
	//	{
	//
	//		Template t = gt.getTemplate("/tag/html4_template.html");
	//		this.bind(t, "list", User.getTestUsers());
	//		String str = t.render();
	//		AssertJUnit.assertEquals(this.getFileContent("/tag/html4_expected.html"), str);
	//
	//		t = gt.getTemplate("/tag/html4_template.html");
	//		this.bind(t, "list", User.getTestUsers());
	//		str = t.render();
	//		AssertJUnit.assertEquals(this.getFileContent("/tag/html4_expected.html"), str);
	//
	//	}

	//	@Test
	//	public void testJavaTag() throws Exception
	//	{
	//
	//		gt.registerTag("simpleTag", SimpleHtmlTag.class);
	//		Template t = gt.getTemplate("/tag/html5_template.html");
	//
	//		String str = t.render();
	//		AssertJUnit.assertEquals(this.getFileContent("/tag/html5_expected.html"), str);
	//
	//		t = gt.getTemplate("/tag/html5_template.html");
	//		str = t.render();
	//		AssertJUnit.assertEquals(this.getFileContent("/tag/html5_expected.html"), str);
	//
	//	}

	//	@Test
	//	public void testExpTag() throws Exception
	//	{
	//
	//		Template t = gt.getTemplate("/tag/html6_template.html");
	//
	//		String str = t.render();
	//		AssertJUnit.assertEquals(this.getFileContent("/tag/html6_expected.html"), str);
	//
	//		t = gt.getTemplate("/tag/html6_template.html");
	//		str = t.render();
	//		AssertJUnit.assertEquals(this.getFileContent("/tag/html6_expected.html"), str);
	//
	//	}

	@Test
	public void testCallMutipleTag() throws Exception
	{

		Template t = gt.getTemplate("/tag/html7_template.html");

		String str = t.render();
		AssertJUnit.assertEquals(this.getFileContent("/tag/html7_expected.html"), str);

		t = gt.getTemplate("/tag/html7_template.html");
		str = t.render();
		AssertJUnit.assertEquals(this.getFileContent("/tag/html7_expected.html"), str);

	}

}
