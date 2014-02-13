package org.beetl.core.type;

import java.util.HashMap;
import java.util.Map;

import org.beetl.core.BasicTestCase;
import org.beetl.core.Template;
import org.beetl.core.User;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

public class DynamicTest extends BasicTestCase
{
	@Test
	public void testDynamicAll() throws Exception
	{

		Map map = new HashMap();
		map.put("name", "joelli");
		map.put("age", 36);
		Template t = gt.getTemplate("/type/dynamic_all_template.html");
		this.bind(t, "user", map);
		String str = t.render();
		AssertJUnit.assertEquals(this.getFileContent("/type/dynamic_all_expected.html"), str);
		User user = User.getTestUser();
		t = gt.getTemplate("/type/dynamic_all_template.html");
		this.bind(t, "user", user);
		str = t.render();
		AssertJUnit.assertEquals(this.getFileContent("/type/dynamic_all_expected.html"), str);

	}

	@Test
	public void testDynamicUser() throws Exception
	{

		Map map = new HashMap();
		map.put("name", "joelli");
		map.put("age", 36);
		Template t = gt.getTemplate("/type/dynamic_user_template.html");
		this.bind(t, "user", map);
		String str = t.render();
		AssertJUnit.assertEquals(this.getFileContent("/type/dynamic_user_expected.html"), str);
		User user = User.getTestUser();
		t = gt.getTemplate("/type/dynamic_user_template.html");
		this.bind(t, "user", user);
		str = t.render();
		AssertJUnit.assertEquals(this.getFileContent("/type/dynamic_user_expected.html"), str);

	}

	@Test
	public void testDynamicUser2() throws Exception
	{

		/*语法兼容1.x*/
		Map map = new HashMap();
		map.put("name", "joelli");
		map.put("age", 36);
		Template t = gt.getTemplate("/type/dynamic_user2_template.html");
		this.bind(t, "user", map);
		String str = t.render();
		AssertJUnit.assertEquals(this.getFileContent("/type/dynamic_user2_expected.html"), str);
		User user = User.getTestUser();
		t = gt.getTemplate("/type/dynamic_user2_template.html");
		this.bind(t, "user", user);
		str = t.render();
		AssertJUnit.assertEquals(this.getFileContent("/type/dynamic_user2_expected.html"), str);

	}
}
