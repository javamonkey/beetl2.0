package org.beetl.core.control;

import org.beetl.core.BasicTestCase;
import org.beetl.core.Template;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

public class SwitchTest extends BasicTestCase
{
	Integer[] data = new Integer[]
	{ 0, 1, 2 };

	@Test
	public void testSwitch() throws Exception
	{
		Template t = gt.getTemplate("/control/swi/switch_template.html");
		this.bind(t, "dataList", data);
		String str = t.render();
		AssertJUnit.assertEquals(this.getFileContent("/control/swi/switch_expected.html"), str);

		
	}

	@Test
	public void testSwitch2() throws Exception
	{
		Template t = gt.getTemplate("/control/swi/switch2_template.html");
		this.bind(t, "dataList", data);
		String str = t.render();
		AssertJUnit.assertEquals(this.getFileContent("/control/swi/switch2_expected.html"), str);

	
	}

	@Test
	public void testDefault() throws Exception
	{
		Template t = gt.getTemplate("/control/swi/default_template.html");
		this.bind(t, "dataList", data);
		String str = t.render();
		AssertJUnit.assertEquals(this.getFileContent("/control/swi/default_expected.html"), str);

		t = gt.getTemplate("/control/swi/default_template.html");
		this.bind(t, "dataList", data);
		str = t.render();
		AssertJUnit.assertEquals(this.getFileContent("/control/swi/default_expected.html"), str);

	}

}