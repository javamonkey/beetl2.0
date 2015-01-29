package org.beetl.core.function;

import org.beetl.core.BasicTestCase;
import org.beetl.core.Template;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

public class FileFunctionTest extends BasicTestCase
{
	@Test
	public void testFileFunctionRetrun() throws Exception
	{

		Template t = gt.getTemplate("/function/file_template.html");

		String str = t.render();
		AssertJUnit.assertEquals(this.getFileContent("/function/file_expected.html"), str);

		t = gt.getTemplate("/function/file_template.html");

		str = t.render();
		AssertJUnit.assertEquals(this.getFileContent("/function/file_expected.html"), str);
	}

	@Test
	public void testRecurFileFunctionRetrun() throws Exception
	{

		Template t = gt.getTemplate("/function/file_recur_template.html");

		String str = t.render();
		AssertJUnit.assertEquals(this.getFileContent("/function/file_recur_expected.html"), str);

		t = gt.getTemplate("/function/file_recur_template.html");

		str = t.render();
		AssertJUnit.assertEquals(this.getFileContent("/function/file_recur_expected.html"), str);
	}

}
