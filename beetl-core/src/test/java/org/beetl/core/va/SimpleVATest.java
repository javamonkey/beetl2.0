package org.beetl.core.va;

import java.util.HashMap;
import java.util.Map;

import org.beetl.core.BasicTestCase;
import org.beetl.core.Context;
import org.beetl.core.Function;
import org.beetl.core.Template;
import org.beetl.core.User;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

public class SimpleVATest extends BasicTestCase
{
	@Test
	public void testUserAttribute() throws Exception
	{

		User user = User.getTestUser();

		Template t = gt.getTemplate("/va/va_simple_template.html");
		this.bind(t, "user", user);
		String str = t.render();
		AssertJUnit.assertEquals(this.getFileContent("/va/va_simple_expected.html"), str);

		t = gt.getTemplate("/va/va_simple_template.html");
		this.bind(t, "user", user);
		str = t.render();
		AssertJUnit.assertEquals(this.getFileContent("/va/va_simple_expected.html"), str);

	}

	@Test
	public void testMapAttribute() throws Exception
	{

		User user = User.getTestUser();
		Map map = new HashMap();
		map.put("name", "joelli");
		map.put("salary", 10000.01);

		Template t = gt.getTemplate("/va/va_map_template.html");
		this.bind(t, "user", user, "map", map);
		String str = t.render();
		AssertJUnit.assertEquals(this.getFileContent("/va/va_map_expected.html"), str);

		t = gt.getTemplate("/va/va_map_template.html");
		this.bind(t, "user", user, "map", map);
		str = t.render();
		AssertJUnit.assertEquals(this.getFileContent("/va/va_map_expected.html"), str);

	}

	@Test
	public void testFunctionAttribute() throws Exception
	{

		gt.registerFunction("userArray", new Function() {

			@Override
			public Object call(Object[] paras, Context ctx)
			{
				// TODO Auto-generated method stub
				return new Object[]
				{ User.getTestUser(), "a" };
			}

		});
		Template t = gt.getTemplate("/va/va_fun_template.html");
		String str = t.render();
		AssertJUnit.assertEquals(this.getFileContent("/va/va_fun_expected.html"), str);

		t = gt.getTemplate("/va/va_fun_template.html");
		str = t.render();
		AssertJUnit.assertEquals(this.getFileContent("/va/va_fun_expected.html"), str);

	}

}
