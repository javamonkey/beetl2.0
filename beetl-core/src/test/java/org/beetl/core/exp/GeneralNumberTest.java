package org.beetl.core.exp;

import org.beetl.core.BasicTestCase;
import org.beetl.core.Template;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

public class GeneralNumberTest extends BasicTestCase {

	int d1 = 1;
	int d2 = 2;

	public GeneralNumberTest() {

	}

	@Test
	public void testAdd() throws Exception {
		Template t = gt.getTemplate("/exp/general_add_template.html");
		this.bind(t, "d1", d1, "d2", d2);
		String str = t.render();
		AssertJUnit.assertEquals(this.getFileContent("/exp/general_add_expected.html"), str);


	}

	@Test
	public void testMinus() throws Exception {
		Template t = gt.getTemplate("/exp/general_minus_template.html");
		this.bind(t, "d1", d1, "d2", d2);
		String str = t.render();

		AssertJUnit.assertEquals(this.getFileContent("/exp/general_minus_expected.html"), str);

	}

	@Test
	public void testCompare() throws Exception {
		Template t = gt.getTemplate("/exp/general_compare_template.html");
		this.bind(t, "d1", d1, "d2", d2);
		String str = t.render();

		AssertJUnit.assertEquals(this.getFileContent("/exp/general_compare_expected.html"), str);


	}

	@Test
	public void testDiv() throws Exception {
		Template t = gt.getTemplate("/exp/general_div_template.html");
		this.bind(t, "d1", d1, "d2", d2);
		String str = t.render();

		AssertJUnit.assertEquals(this.getFileContent("/exp/general_div_expected.html"), str);

		t = gt.getTemplate("/exp/general_div_template.html");
		this.bind(t, "d1", d1, "d2", d2);
		str = t.render();

		AssertJUnit.assertEquals(this.getFileContent("/exp/general_div_expected.html"), str);

	}

	@Test
	public void testMul() throws Exception {
		Template t = gt.getTemplate("/exp/general_mul_template.html");
		this.bind(t, "d1", d1, "d2", d2);
		String str = t.render();

		AssertJUnit.assertEquals(this.getFileContent("/exp/general_mul_expected.html"), str);

		t = gt.getTemplate("/exp/general_mul_template.html");
		this.bind(t, "d1", d1, "d2", d2);
		str = t.render();

		AssertJUnit.assertEquals(this.getFileContent("/exp/general_mul_expected.html"), str);

	}

}
