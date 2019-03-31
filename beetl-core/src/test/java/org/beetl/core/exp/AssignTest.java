package org.beetl.core.exp;

import org.beetl.core.BasicTestCase;
import org.beetl.core.Template;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

public class AssignTest extends BasicTestCase {
	@Test
	public void testId() throws Exception {
		Template t = gt.getTemplate("/exp/assign/id_template.html");
		String str = t.render();
		AssertJUnit.assertEquals(this.getFileContent("/exp/assign/id_expected.html"), str);
	}

	@Test
	public void testVarBlock() throws Exception {
		Template t = gt.getTemplate("/exp/assign/block_template.html");
		String str = t.render();
		AssertJUnit.assertEquals(this.getFileContent("/exp/assign/block_expected.html"), str);

	}

	@Test
	public void testNull() throws Exception {
		Template t = gt.getTemplate("/exp/assign/assign_null_template.html");
		String str = t.render();
		AssertJUnit.assertEquals(this.getFileContent("/exp/assign/assign_null_expected.html"), str);

		t = gt.getTemplate("/exp/assign/assign_null_template.html");
		str = t.render();
		AssertJUnit.assertEquals(this.getFileContent("/exp/assign/assign_null_expected.html"), str);
	}

	@Test
	public void testAsign() throws Exception {
		Template t = gt.getTemplate("/exp/assign/assign_template.html");
		t.binding("d", 100);
		String str = t.render();
		AssertJUnit.assertEquals(this.getFileContent("/exp/assign/assign_expected.html"), str);

	}

	@Test
	public void testLeftAsign() throws Exception {
		Template t = gt.getTemplate("/exp/assign/left_template.html");
		t.binding("d", 100);
		String str = t.render();
		AssertJUnit.assertEquals(this.getFileContent("/exp/assign/left_expected.html"), str);

	}

}
