package org.beetl.core.control;

import org.beetl.core.BasicTestCase;
import org.beetl.core.Template;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

public class generalForTest extends BasicTestCase
{
	Integer[] data = new Integer[]
	{ 0, 1, 2 };

	@Test
	public void testGeneral() throws Exception
	{
		Template t = gt.getTemplate("/control/generalFor/general_template.html");

		String str = t.render();
		AssertJUnit.assertEquals(this.getFileContent("/control/generalFor/general_expected.html"), str);

		t = gt.getTemplate("/control/generalFor/general_template.html");
		//this.bind(t, "dataList", data);
		str = t.render();
		AssertJUnit.assertEquals(this.getFileContent("/control/generalFor/general_expected.html"), str);

	}

	@Test
	public void testBreak() throws Exception
	{
		Template t = gt.getTemplate("/control/generalFor/general_break_template.html");

		String str = t.render();
		AssertJUnit.assertEquals(this.getFileContent("/control/generalFor/general_break_expected.html"), str);

		//		t = gt.getTemplate("/control/generalFor/general_break_template.html");
		//		//this.bind(t, "dataList", data);
		//		str = t.render();
		//		AssertJUnit.assertEquals(this.getFileContent("/control/generalFor/general_break_expected.html"), str);

	}

}