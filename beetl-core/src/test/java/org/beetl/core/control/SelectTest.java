package org.beetl.core.control;

import org.beetl.core.BasicTestCase;
import org.beetl.core.Template;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

public class SelectTest extends BasicTestCase
{
	Integer[] data = new Integer[]
	{ 0, 1, 2 };

	@Test
	public void testSwitch() throws Exception
	{
		Template t = gt.getTemplate("/control/select/select_template.html");
		this.bind(t, "dataList", data);
		String str = t.render();
		AssertJUnit.assertEquals(this.getFileContent("/control/select/select_expected.html"), str);


	}

	@Test
	public void testSelect2() throws Exception
	{
		Template t = gt.getTemplate("/control/select/select2_template.html");
		this.bind(t, "dataList", data);
		String str = t.render();
		AssertJUnit.assertEquals(this.getFileContent("/control/select/select2_expected.html"), str);

	
	}

	@Test
	public void testDefault() throws Exception
	{
		Template t = gt.getTemplate("/control/select/default_template.html");
		this.bind(t, "dataList", data);
		String str = t.render();
		AssertJUnit.assertEquals(this.getFileContent("/control/select/default_expected.html"), str);

		
	}

}