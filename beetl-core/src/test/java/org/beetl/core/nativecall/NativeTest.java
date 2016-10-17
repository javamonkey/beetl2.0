package org.beetl.core.nativecall;

import java.util.List;

import org.beetl.core.BasicTestCase;
import org.beetl.core.Configuration;
import org.beetl.core.GroupTemplate;
import org.beetl.core.Template;
import org.beetl.core.User;
import org.beetl.core.nativecall.obj.Request;
import org.beetl.core.resource.StringTemplateResourceLoader;
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

	@Test
	public void testMethod() throws Exception
	{
		NativeTest test = new NativeTest();
		Template t = gt.getTemplate("/nat/nat_method_template.html");
		this.bind(t, "test", test);
		String str = t.render();
		AssertJUnit.assertEquals(this.getFileContent("/nat/nat_method_expected.html"), str);

		t = gt.getTemplate("/nat/nat_method_template.html");
		this.bind(t, "test", test);
		str = t.render();
		AssertJUnit.assertEquals(this.getFileContent("/nat/nat_method_expected.html"), str);
	}

	@Test
	public void testArray() throws Exception
	{
		NativeTest test = new NativeTest();
		Template t = gt.getTemplate("/nat/nat_array_template.html");
		this.bind(t, "test", test);
		String str = t.render();
		AssertJUnit.assertEquals(this.getFileContent("/nat/nat_array_expected.html"), str);

		t = gt.getTemplate("/nat/nat_array_template.html");
		this.bind(t, "test", test);
		str = t.render();
		AssertJUnit.assertEquals(this.getFileContent("/nat/nat_array_expected.html"), str);
	}

	@Test
	public void testMethodParameter() throws Exception
	{
		NativeTest test = new NativeTest();
		Template t = gt.getTemplate("/nat/nat_method2_template.html");
		this.bind(t, "test", test);
		String str = t.render();
		AssertJUnit.assertEquals(this.getFileContent("/nat/nat_method2_expected.html"), str);

		t = gt.getTemplate("/nat/nat_method2_template.html");
		this.bind(t, "test", test);
		str = t.render();
		AssertJUnit.assertEquals(this.getFileContent("/nat/nat_method2_expected.html"), str);
	}

	@Test
	public void testAll() throws Exception
	{
		NativeTest test = new NativeTest();
		Template t = gt.getTemplate("/nat/all_template.html");
		this.bind(t, "test", test);
		String str = t.render();
		AssertJUnit.assertEquals(this.getFileContent("/nat/all_expected.html"), str);

		t = gt.getTemplate("/nat/all_template.html");
		this.bind(t, "test", test);
		str = t.render();
		AssertJUnit.assertEquals(this.getFileContent("/nat/all_expected.html"), str);
	}

	@Test
	public void testObjectReturn() throws Exception
	{
		NativeTest test = new NativeTest();
		Template t = gt.getTemplate("/nat/object_template.html");
		this.bind(t, "test", test);
		String str = t.render();
		AssertJUnit.assertEquals(this.getFileContent("/nat/object_expected.html"), str);

		t = gt.getTemplate("/nat/object_template.html");
		this.bind(t, "test", test);
		str = t.render();
		AssertJUnit.assertEquals(this.getFileContent("/nat/object_expected.html"), str);
	}

	@Test
	public void testPrivateMethodCall() throws Exception
	{

		Template t = gt.getTemplate("/nat/nat_private_method_template.html");
		this.bind(t, "test", Request.getRequest());
		String str = t.render();
		AssertJUnit.assertEquals(this.getFileContent("/nat/nat_private_method_expected.html"), str);

		t = gt.getTemplate("/nat/nat_private_method_template.html");
		this.bind(t, "test", Request.getRequest());
		str = t.render();
		AssertJUnit.assertEquals(this.getFileContent("/nat/nat_private_method_expected.html"), str);
	}
	
	
	@Test
	public void testSecurity() throws Exception
	{

		StringTemplateResourceLoader resourceLoader = new StringTemplateResourceLoader();
		Configuration cfg = Configuration.defaultConfiguration();
		GroupTemplate gt = new GroupTemplate(resourceLoader, cfg);
		Template t = gt.getTemplate("hello,${@java.lang.System.currentTimeMillis()}");
	
		String str = t.render();
		AssertJUnit.assertEquals("hello,", str);
	
	}

	public String getText()
	{
		return "text";
	}

	public static String getDefaultText()
	{
		return "defaultText";
	}

	public User[] getMyFriends()
	{
		return users;
	}

	public static List<User> getUsers()
	{
		return User.getTestUsers();
	}

	public String getData(int i, String c)
	{
		return i + ":" + c;
	}

	public static String getData(int i, String c, double d)
	{
		return i + ":" + c + ":" + d;
	}

	public static Object getValue(String tt)
	{
		return 1;
	}
}
