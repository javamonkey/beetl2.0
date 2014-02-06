package org.beetl.core.va;

import java.util.List;

import org.beetl.core.BasicTestCase;
import org.beetl.core.Context;
import org.beetl.core.Template;
import org.beetl.core.User;
import org.beetl.core.VirtualAttributeEval;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

public class SimpleVATest extends BasicTestCase
{
	//	@Test
	//	public void testUserAttribute() throws Exception
	//	{
	//
	//		User user = User.getTestUser();
	//
	//		Template t = gt.getTemplate("/va/va_simple_template.html");
	//		this.bind(t, "user", user);
	//		String str = t.render();
	//		AssertJUnit.assertEquals(this.getFileContent("/va/va_simple_expected.html"), str);
	//
	//		t = gt.getTemplate("/va/va_simple_template.html");
	//		this.bind(t, "user", user);
	//		str = t.render();
	//		AssertJUnit.assertEquals(this.getFileContent("/va/va_simple_expected.html"), str);
	//
	//	}

	//	@Test
	//	public void testMapAttribute() throws Exception
	//	{
	//
	//		User user = User.getTestUser();
	//		Map map = new HashMap();
	//		map.put("name", "joelli");
	//		map.put("salary", 10000.01);
	//
	//		Template t = gt.getTemplate("/va/va_map_template.html");
	//		this.bind(t, "user", user, "map", map);
	//		String str = t.render();
	//		AssertJUnit.assertEquals(this.getFileContent("/va/va_map_expected.html"), str);
	//
	//		t = gt.getTemplate("/va/va_map_template.html");
	//		this.bind(t, "user", user, "map", map);
	//		str = t.render();
	//		AssertJUnit.assertEquals(this.getFileContent("/va/va_map_expected.html"), str);
	//
	//	}

	@Test
	public void testVirtualAttribute() throws Exception
	{

		gt.registerVirtualAttributeEval(new VirtualAttributeEval() {

			@Override
			public Object eval(Object o, String attributeName, Context ctx)
			{
				// TODO Auto-generated method stub
				return attributeName;
			}

			@Override
			public boolean isSupport(Class c, String attributeName)
			{
				if (c == User.class)
					return true;
				else
					return false;
			}

		});

		List list = User.getTestUsers();
		User user = User.getTestUser();
		Template t = gt.getTemplate("/va/va_virtual_template.html");
		this.bind(t, "list", list, "user", user);
		String str = t.render();
		AssertJUnit.assertEquals(this.getFileContent("/va/va_virtual_expected.html"), str);

		t = gt.getTemplate("/va/va_virtual_template.html");
		this.bind(t, "list", list, "user", user);
		str = t.render();
		AssertJUnit.assertEquals(this.getFileContent("/va/va_virtual_expected.html"), str);

	}

}
