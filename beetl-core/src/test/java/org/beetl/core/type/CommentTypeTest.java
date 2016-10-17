package org.beetl.core.type;

import java.util.List;

import org.beetl.core.BasicTestCase;
import org.beetl.core.Template;
import org.beetl.core.User;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

public class CommentTypeTest extends BasicTestCase
{
	@Test
	public void testTypel() throws Exception
	{
		User user = User.getTestUser();
		List list = User.getTestUsers();

		Template t = gt.getTemplate("/type/commenttype_template.html");
		this.bind(t, "me", user, "list", list);
		String str = t.render();
		AssertJUnit.assertEquals(this.getFileContent("/type/commenttype_expected.html"), str);

		t = gt.getTemplate("/type/commenttype_template.html");
		this.bind(t, "me", user, "list", list);
		str = t.render();
		AssertJUnit.assertEquals(this.getFileContent("/type/commenttype_expected.html"), str);

	}

}
