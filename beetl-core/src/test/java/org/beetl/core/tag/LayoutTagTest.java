package org.beetl.core.tag;

import org.beetl.core.BasicTestCase;
import org.beetl.core.Template;
import org.beetl.core.User;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

public class LayoutTagTest extends BasicTestCase
{
	@Test
	public void testLayout() throws Exception
	{

		User user = User.getTestUser();

		Template t = gt.getTemplate("/tag/layout_template.html");
		this.bind(t, "user", user);
		String str = t.render();
		AssertJUnit.assertEquals(this.getFileContent("/tag/layout_expected.html"), str);
				
	}

	@Test
	public void testLayoutInclude() throws Exception
	{

		User user = User.getTestUser();

		Template t = gt.getTemplate("/tag/layoutinclude_template.html");
		this.bind(t, "user", user);
		String str = t.render();
		AssertJUnit.assertEquals(this.getFileContent("/tag/layoutinclude_expected.html"), str);

	
	}

}
