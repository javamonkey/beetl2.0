package org.beetl.core.tag;

import org.beetl.core.BasicTestCase;
import org.beetl.core.Template;
import org.beetl.core.User;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

public class HtmlTagTest extends BasicTestCase
{
	//	@Test
	//	public void testHtmlTag() throws Exception
	//	{
	//
	//		//将默认搜索路径更改到tag目录下
	//		gt.registerTag("htmltag", MyHTMLTagSupportWrapper.class);
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
	//		//将默认搜索路径更改到tag目录下
	//		gt.registerTag("htmltag", MyHTMLTagSupportWrapper.class);
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

	@Test
	public void testMutilTagInSamePage() throws Exception
	{

		//将默认搜索路径更改到tag目录下
		gt.registerTag("htmltag", MyHTMLTagSupportWrapper.class);

		Template t = gt.getTemplate("/tag/html3_template.html");
		this.bind(t, "list", User.getTestUsers());
		String str = t.render();
		AssertJUnit.assertEquals(this.getFileContent("/tag/html3_expected.html"), str);

		t = gt.getTemplate("/tag/html3_template.html");
		this.bind(t, "list", User.getTestUsers());
		str = t.render();
		AssertJUnit.assertEquals(this.getFileContent("/tag/html3_expected.html"), str);

	}

}
