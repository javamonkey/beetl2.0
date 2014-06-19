package org.beetl.core.exp;

import org.beetl.core.BasicTestCase;
import org.beetl.core.Template;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

public class TernaryTest extends BasicTestCase
{
	@Test
	public void testId() throws Exception
	{
		Template t = gt.getTemplate("/exp/ternary_template.html");
		String str = t.render();
		AssertJUnit.assertEquals(this.getFileContent("/exp/ternary_expected.html"), str);

		t = gt.getTemplate("/exp/ternary_template.html");
		str = t.render();
		AssertJUnit.assertEquals(this.getFileContent("/exp/ternary_expected.html"), str);
	}

}
