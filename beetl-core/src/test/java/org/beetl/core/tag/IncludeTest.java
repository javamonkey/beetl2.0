package org.beetl.core.tag;

import org.beetl.core.BasicTestCase;
import org.beetl.core.Template;
import org.beetl.core.User;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

public class IncludeTest extends BasicTestCase
{
	@Test
	public void testInclude() throws Exception
	{

		User user = User.getTestUser();

		Template t = gt.getTemplate("/tag/include_template.html");
		this.bind(t, "user", user);
		String str = t.render();
		AssertJUnit.assertEquals(this.getFileContent("/tag/include_expected.html"), str);

	

	}

	@Test
	public void testIncludeRel() throws Exception
	{

		User user = User.getTestUser();

		Template t = gt.getTemplate("/tag/main_include_template.html");
		this.bind(t, "user", user);
		String str = t.render();
		AssertJUnit.assertEquals(this.getFileContent("/tag/main_include_expected.html"), str);

		t = gt.getTemplate("/tag/main_include_template.html");
		this.bind(t, "user", user);
		str = t.render();
		AssertJUnit.assertEquals(this.getFileContent("/tag/main_include_expected.html"), str);

	}

}
