package org.beetl.core.exp;

import org.beetl.core.BasicTestCase;
import org.beetl.core.Template;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

public class CompareTest extends BasicTestCase {
	@Test
	public void testBasic() throws Exception {
		Template t = gt.getTemplate("/exp/compare_template.html");
		String str = t.render();
		AssertJUnit.assertEquals(this.getFileContent("/exp/compare_expected.html"), str);

	}

}
