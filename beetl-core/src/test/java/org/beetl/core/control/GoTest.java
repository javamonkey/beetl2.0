package org.beetl.core.control;

import org.beetl.core.BasicTestCase;
import org.beetl.core.Template;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

public class GoTest extends BasicTestCase
{
	Integer[] data = new Integer[]
	{ 0, 1, 2 };

	@Test
	public void testContinue() throws Exception
	{
		Template t = gt.getTemplate("/control/go/continue_template.html");
		this.bind(t, "dataList", data);
		String str = t.render();
		AssertJUnit.assertEquals(this.getFileContent("/control/go/continue_expected.html"), str);

	}

	@Test
	public void testBreak() throws Exception
	{
		Template t = gt.getTemplate("/control/go/break_template.html");
		this.bind(t, "dataList", data);
		String str = t.render();
		AssertJUnit.assertEquals(this.getFileContent("/control/go/break_expected.html"), str);

		t = gt.getTemplate("/control/go/break_template.html");
		this.bind(t, "dataList", data);
		str = t.render();
		AssertJUnit.assertEquals(this.getFileContent("/control/go/break_expected.html"), str);

	}

	@Test
	public void testBreak2() throws Exception
	{
		Template t = gt.getTemplate("/control/go/break2_template.html");
		this.bind(t, "dataList", data);
		String str = t.render();
		AssertJUnit.assertEquals(this.getFileContent("/control/go/break2_expected.html"), str);

		t = gt.getTemplate("/control/go/break2_template.html");
		this.bind(t, "dataList", data);
		str = t.render();
		AssertJUnit.assertEquals(this.getFileContent("/control/go/break2_expected.html"), str);

	}

	@Test
	public void testBreak3() throws Exception
	{
		Template t = gt.getTemplate("/control/go/break3_template.html");
		this.bind(t, "dataList", data);
		String str = t.render();
		AssertJUnit.assertEquals(this.getFileContent("/control/go/break3_expected.html"), str);

		t = gt.getTemplate("/control/go/break3_template.html");
		this.bind(t, "dataList", data);
		str = t.render();
		AssertJUnit.assertEquals(this.getFileContent("/control/go/break3_expected.html"), str);

	}

	@Test
	public void testReturn() throws Exception
	{
		Template t = gt.getTemplate("/control/go/return_template.html");
		this.bind(t, "dataList", data);
		String str = t.render();
		AssertJUnit.assertEquals(this.getFileContent("/control/go/return_expected.html"), str);

		t = gt.getTemplate("/control/go/return_template.html");
		this.bind(t, "dataList", data);
		str = t.render();
		AssertJUnit.assertEquals(this.getFileContent("/control/go/return_expected.html"), str);

	}

	@Test
	public void testContinueAndReturn() throws Exception
	{
		Template t = gt.getTemplate("/control/go/continue_return_template.html");
		this.bind(t, "dataList", data);
		String str = t.render();
		AssertJUnit.assertEquals(this.getFileContent("/control/go/continue_return_expected.html"), str);

		t = gt.getTemplate("/control/go/continue_return_template.html");
		this.bind(t, "dataList", data);
		str = t.render();
		AssertJUnit.assertEquals(this.getFileContent("/control/go/continue_return_expected.html"), str);

	}

}