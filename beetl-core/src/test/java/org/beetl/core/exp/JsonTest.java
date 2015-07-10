package org.beetl.core.exp;

import org.beetl.core.BasicTestCase;
import org.beetl.core.Template;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

public class JsonTest extends BasicTestCase
{
	@Test
	public void testSimple() throws Exception
	{
		Template t = gt.getTemplate("/exp/json/json_template.html");
		String str = t.render();
		AssertJUnit.assertEquals(this.getFileContent("/exp/json/json_expected.html"), str);

		t = gt.getTemplate("/exp/json/json_template.html");
		str = t.render();
		AssertJUnit.assertEquals(this.getFileContent("/exp/json/json_expected.html"), str);
	}

	@Test
	public void testData() throws Exception
	{
		Template t = gt.getTemplate("/exp/json/data_template.html");
		String str = t.render();
		AssertJUnit.assertEquals(this.getFileContent("/exp/json/data_expected.html"), str);

		t = gt.getTemplate("/exp/json/data_template.html");
		str = t.render();
		AssertJUnit.assertEquals(this.getFileContent("/exp/json/data_expected.html"), str);
	}

	@Test
	public void testOrder() throws Exception
	{
		Template t = gt.getTemplate("/exp/json/order_template.html");
		String str = t.render();
		AssertJUnit.assertEquals(this.getFileContent("/exp/json/order_expected.html"), str);

		t = gt.getTemplate("/exp/json/order_template.html");
		str = t.render();
		AssertJUnit.assertEquals(this.getFileContent("/exp/json/order_expected.html"), str);
	}
}
