package org.beetl.core.tag;

import org.beetl.core.BasicTestCase;
import org.beetl.core.Template;
import org.beetl.core.User;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

public class DeleteTagTest extends BasicTestCase
{
	@Test
	public void testDeleteTag() throws Exception
	{

		User user = User.getTestUser();

		Template t = gt.getTemplate("/tag/delete_template.html");
		String old = this.getFileContent("/tag/delete_template.html");
		this.bind(t, "user", user);
		String str = t.render();
		AssertJUnit.assertEquals(this.getFileContent("/tag/delete_expected.html"), str);

		

	}

}
