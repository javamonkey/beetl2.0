package org.beetl.core.nativecall;

import org.beetl.core.BasicTestCase;
import org.beetl.core.Template;
import org.beetl.core.User;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

public class NativeTest extends BasicTestCase
{

	public static int DEFAULT_AGE = 11;
	public int age = 5;
	public static User[] users = new User[]
	{ User.getTestUser(), User.getTestUser() };

	@Test
	public void testAttr() throws Exception
	{
		NativeTest test = new NativeTest();
		Template t = gt.getTemplate("/nat/nat_attr_template.html");
		this.bind(t, "test", test);
		String str = t.render();
		AssertJUnit.assertEquals(this.getFileContent("/nat/nat_attr_expected.html"), str);

		t = gt.getTemplate("/nat/nat_attr_template.html");
		this.bind(t, "test", test);
		str = t.render();
		AssertJUnit.assertEquals(this.getFileContent("/nat/nat_attr_expected.html"), str);
	}
}
