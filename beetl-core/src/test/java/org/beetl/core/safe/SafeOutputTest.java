package org.beetl.core.safe;

import org.beetl.core.BasicTestCase;
import org.beetl.core.Template;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

public class SafeOutputTest extends BasicTestCase
{

	@Test
	public void testSimple() throws Exception
	{

		Template t = gt.getTemplate("/safe/safe_template.html");
		String str = t.render();
		AssertJUnit.assertEquals(this.getFileContent("/safe/safe_expected.html"), str);

		t = gt.getTemplate("/safe/safe_template.html");
		str = t.render();
		AssertJUnit.assertEquals(this.getFileContent("/safe/safe_expected.html"), str);

	}

}
