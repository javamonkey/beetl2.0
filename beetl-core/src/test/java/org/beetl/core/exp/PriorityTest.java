package org.beetl.core.exp;

import org.beetl.core.BasicTestCase;
import org.beetl.core.Template;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

public class PriorityTest extends BasicTestCase {
	@Test
	public void testAll() throws Exception {
		Template t = gt.getTemplate("/exp/priority_all_template.html");
		String str = t.render();
		AssertJUnit.assertEquals(this.getFileContent("/exp/priority_all_expected.html"), str);

	}
}
