package org.beetl.core.lang;

import org.beetl.core.BasicTestCase;
import org.beetl.core.Template;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

public class ConfigTest extends BasicTestCase {

	@Test
	public void testSimple() throws Exception {

		Template t = gt.getTemplate("/lang/config_template.html");
		String str = t.render();
		AssertJUnit.assertEquals(this.getFileContent("/lang/config_expected.html"), str);

	}

	@Test
	public void testMoreProperties() throws Exception {
		Template t = gt.getTemplate("/lang/my_config_template.html");
		String str = t.render();
		AssertJUnit.assertEquals(this.getFileContent("/lang/my_config_expected.html"), str);

	}
}
