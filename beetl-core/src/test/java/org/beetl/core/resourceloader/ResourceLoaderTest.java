package org.beetl.core.resourceloader;

import java.util.HashMap;
import java.util.Map;

import org.beetl.core.BasicTestCase;
import org.beetl.core.Template;
import org.beetl.core.resource.ClasspathResourceLoader;
import org.beetl.core.resource.FileResourceLoader;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

public class ResourceLoaderTest extends BasicTestCase
{

	@Test
	public void testSimple() throws Exception
	{

		FileResourceLoader f = new FileResourceLoader();
		boolean exist = f.exist("/build.xml");
		AssertJUnit.assertTrue(exist);

		ClasspathResourceLoader cp = new ClasspathResourceLoader();
		exist = cp.exist("/template/resourceloader/cp.txt");
		AssertJUnit.assertTrue(exist);
	}

	@Test
	public void testExtraLoader() throws Exception
	{

		Map data = getData();
		MapResourceLoader strLoader = new MapResourceLoader(data);
		Template t = gt.getTemplate("db:1", strLoader);
		t.binding("a", "abc");
		String result = t.render();
		AssertJUnit.assertEquals("abc", result);

	}

	@Test
	public void testExtraLoader2() throws Exception
	{

		Map data = getData();
		MapResourceLoader strLoader = new MapResourceLoader(data);
		Template t = gt.getTemplate("db:2", strLoader);
		String result = t.render();
		AssertJUnit.assertEquals("hello", result);

	}

	@Test
	public void testRemove() throws Exception
	{

		Map data = getData();
		MapResourceLoader strLoader = new MapResourceLoader(data);
		Template t = gt.getTemplate("db:2", strLoader);
		String result = t.render();
		gt.removeTemplate("db:2");

		AssertJUnit.assertEquals(false, gt.hasTemplate("db:2"));

	}

	private Map getData()
	{
		Map data = new HashMap();
		data.put("db:1", "${a}");
		data.put("db:2", "<%include('/resourceloader/justtest.txt'){}%>");

		return data;
	}

}
