package org.beetl.core.resourceloader;

import org.beetl.core.BasicTestCase;
import org.beetl.core.resource.ClasspathResourceLoader;
import org.beetl.core.resource.FileResourceLoader;
import org.testng.annotations.Test;

public class ResourceLoaderTest extends BasicTestCase
{

	@Test
	public void testSimple() throws Exception
	{

		FileResourceLoader f = new FileResourceLoader();
		boolean exist = f.exist("/build.xml");
		this.assertTrue(exist);

		ClasspathResourceLoader cp = new ClasspathResourceLoader();
		exist = cp.exist("/template/resourceloader/cp.txt");
		this.assertTrue(exist);
	}

}
