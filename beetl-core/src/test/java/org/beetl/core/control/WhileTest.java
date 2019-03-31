package org.beetl.core.control;

import org.beetl.core.BasicTestCase;
import org.beetl.core.Template;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

public class WhileTest extends BasicTestCase
{

	@Test
	public void testWhile() throws Exception
	{
		Template t = gt.getTemplate("/control/while/while_template.html");

		String str = t.render();
		AssertJUnit.assertEquals(this.getFileContent("/control/while/while_expected.html"), str);

		
	}

}