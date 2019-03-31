package org.beetl.core.control;

import org.beetl.core.BasicTestCase;
import org.beetl.core.Template;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

public class TryCatchTest extends BasicTestCase
{

	@Test
	public void testGenera() throws Exception
	{
		Template t = gt.getTemplate("/control/trycatch/general_template.html");
		String str = t.render();
		AssertJUnit.assertEquals(this.getFileContent("/control/trycatch/general_expected.html"), str);
		
	}

	@Test
	public void testNoError() throws Exception
	{
		Template t = gt.getTemplate("/control/trycatch/noerror_template.html");
		String str = t.render();
		AssertJUnit.assertEquals(this.getFileContent("/control/trycatch/noerror_expected.html"), str);

		
	}

}