package org.beetl.core.safe;

import org.beetl.core.BasicTestCase;
import org.beetl.core.Template;
import org.beetl.core.User;
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

		
	}

	@Test
	public void testSafeExp() throws Exception
	{

		Template t = gt.getTemplate("/safe/safe_exp_template.html");
		t.binding("test", new User("joel"));
		String str = t.render();
		AssertJUnit.assertEquals(this.getFileContent("/safe/safe_exp_expected.html"), str);

		t = gt.getTemplate("/safe/safe_exp_template.html");
		t.binding("test", new User("joel"));
		str = t.render();
		AssertJUnit.assertEquals(this.getFileContent("/safe/safe_exp_expected.html"), str);

	}

}
