package org.beetl.core.resourceloader;

import java.util.HashMap;
import java.util.Map;

import org.beetl.core.BasicTestCase;
import org.beetl.core.Configuration;
import org.beetl.core.GroupTemplate;
import org.beetl.core.Template;
import org.beetl.core.resource.AllowAllMatcher;
import org.beetl.core.resource.CompositeResourceLoader;
import org.beetl.core.resource.FileResourceLoader;
import org.beetl.core.resource.StartsWithMatcher;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

public class CompositeResourceLoaderTest extends BasicTestCase
{

	@Test
	public void testSimple() throws Exception
	{

		Configuration conf = Configuration.defaultConfiguration();
		CompositeResourceLoader loader = new CompositeResourceLoader();
		String home = System.getProperty("user.dir");
		String path1 = home + "/src/test/resources/template/resourceloader/var1";
		String path2 = home + "/src/test/resources/template/resourceloader/var2";
		FileResourceLoader fileLoader1 = new FileResourceLoader(path1);
		FileResourceLoader fileLoader2 = new FileResourceLoader(path2);
		Map data = getData();
		// 根据id加载
		MapResourceLoader mapLoader = new MapResourceLoader(data);

		loader.addResourceLoader(new StartsWithMatcher("http:").withoutPrefix(), fileLoader2);
		loader.addResourceLoader(new StartsWithMatcher("db:").withoutPrefix(), mapLoader);
		loader.addResourceLoader(new AllowAllMatcher(), fileLoader1);

		GroupTemplate gt = new GroupTemplate(loader, conf);

		Template t = gt.getTemplate("/xxx.html");
		t.binding("a", "hello");
		String result = t.render();
		;
		AssertJUnit.assertEquals("hellohello--file2:hello--db=hello", result);

	}

	private Map getData()
	{
		Map data = new HashMap();
		data.put("123", "db=${a}");

		return data;
	}

}
