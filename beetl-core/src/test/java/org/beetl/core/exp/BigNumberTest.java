package org.beetl.core.exp;

import java.math.BigDecimal;

import org.beetl.core.BasicTestCase;
import org.beetl.core.Template;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

public class BigNumberTest extends BasicTestCase {
	// 日志对象

	BigDecimal d1 = new BigDecimal("1.000000000000001");
	int d2 = 2;

	public BigNumberTest() {

	}

	@Test
	public void testAdd() throws Exception {
		Template t = gt.getTemplate("/exp/bignumber/number_add_template.html");
		this.bind(t, "d1", d1, "d2", d2);
		String str = t.render();
		AssertJUnit.assertEquals(this.getFileContent("/exp/bignumber/number_add_expected.html"), str);


	}

	@Test
	public void testMinus() throws Exception {
		Template t = gt.getTemplate("/exp/bignumber/number_minus_template.html");
		this.bind(t, "d1", d1, "d2", d2);
		String str = t.render();
		String expected = getFileContent("/exp/bignumber/number_minus_expected.html");
		AssertJUnit.assertEquals(expected, str);


	}

	@Test
	public void testCompare() throws Exception {
		Template t = gt.getTemplate("/exp/bignumber/number_compare_template.html");
		this.bind(t, "d1", d1, "d2", d2);
		String str = t.render();

		AssertJUnit.assertEquals(this.getFileContent("/exp/bignumber/number_compare_expected.html"), str);

	}

	@Test
	public void testDiv() throws Exception {
		Template t = gt.getTemplate("/exp/bignumber/number_div_template.html");
		this.bind(t, "d1", d1, "d2", d2);
		String str = t.render();

		AssertJUnit.assertEquals(this.getFileContent("/exp/bignumber/number_div_expected.html"), str);


	}

	@Test
	public void testMul() throws Exception {
		Template t = gt.getTemplate("/exp/bignumber/number_mul_template.html");
		this.bind(t, "d1", d1, "d2", d2);
		String str = t.render();

		AssertJUnit.assertEquals(this.getFileContent("/exp/bignumber/number_mul_expected.html"), str);


	}

}
