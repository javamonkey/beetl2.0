package org.beetl.core.exp;

import org.beetl.core.BasicTestCase;
import org.beetl.core.Template;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

public class ArrayTest extends BasicTestCase
{
	@Test
	public void testInt() throws Exception
	{
		Template t = gt.getTemplate("/exp/array/int_array_template.html");
		int[] array = new int[]
		{ 1, 2 };
		t.binding("array", array);
		String str = t.render();
		AssertJUnit.assertEquals(this.getFileContent("/exp/array/int_array_expected.html"), str);

		t = gt.getTemplate("/exp/array/int_array_template.html");
		t.binding("array", array);
		str = t.render();
		AssertJUnit.assertEquals(this.getFileContent("/exp/array/int_array_expected.html"), str);
	}

}
