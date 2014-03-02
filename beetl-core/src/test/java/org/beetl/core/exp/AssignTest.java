package org.beetl.core.exp;

import org.beetl.core.BasicTestCase;
import org.beetl.core.Template;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

public class AssignTest extends BasicTestCase
{
	@Test
	public void testId() throws Exception
	{
		Template t = gt.getTemplate("/exp/assign/id_template.html");
		String str = t.render();
		AssertJUnit.assertEquals(this.getFileContent("/exp/assign/id_expected.html"), str);

		t = gt.getTemplate("/exp/assign/id_template.html");
		str = t.render();
		AssertJUnit.assertEquals(this.getFileContent("/exp/assign/id_expected.html"), str);
	}
}
