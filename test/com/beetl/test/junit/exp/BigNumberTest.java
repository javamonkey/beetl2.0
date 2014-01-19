package com.beetl.test.junit.exp;

import java.math.BigDecimal;

import junit.framework.Assert;

import org.beetl.core.Template;

import com.beetl.test.junit.BasicTestCase;

public class BigNumberTest extends BasicTestCase {
	BigDecimal d1 = new BigDecimal("1.000000000000001");
	int d2 = 2;

	public BigNumberTest() {

	}

	public void testAdd() throws Exception {
		Template t = gt.getTemplate("/exp/bignumber/number_add_template.html");
		this.bind(t, "d1", d1, "d2", d2);
		String str = t.render();
		Assert.assertEquals(
				this.getFileContent("/exp/bignumber/number_add_expected.html"),
				str);

		t = this.gt.getTemplate("/exp/bignumber/number_add_template.html");
		this.bind(t, "d1", d1, "d2", d2);
		str = t.render();
		Assert.assertEquals(
				this.getFileContent("/exp/bignumber/number_add_expected.html"),
				str);

	}

	public void testMinus() throws Exception {
		Template t = gt
				.getTemplate("/exp/bignumber/number_minus_template.html");
		this.bind(t, "d1", d1, "d2", d2);
		String str = t.render();
		print(str);
		Assert.assertEquals(this
				.getFileContent("/exp/bignumber/number_minus_expected.html"),
				str);

		t = this.gt.getTemplate("/exp/bignumber/number_minus_template.html");
		this.bind(t, "d1", d1, "d2", d2);
		str = t.render();

		Assert.assertEquals(this
				.getFileContent("/exp/bignumber/number_minus_expected.html"),
				str);

	}

	public void testCompare() throws Exception {
		Template t = gt
				.getTemplate("/exp/bignumber/number_compare_template.html");
		this.bind(t, "d1", d1, "d2", d2);
		String str = t.render();
		print(str);
		Assert.assertEquals(this
				.getFileContent("/exp/bignumber/number_compare_expected.html"),
				str);

		t = this.gt.getTemplate("/exp/bignumber/number_compare_template.html");
		this.bind(t, "d1", d1, "d2", d2);
		str = t.render();

		Assert.assertEquals(this
				.getFileContent("/exp/bignumber/number_compare_expected.html"),
				str);

	}

	public void testDiv() throws Exception {
		Template t = gt.getTemplate("/exp/bignumber/number_div_template.html");
		this.bind(t, "d1", d1, "d2", d2);
		String str = t.render();
		print(str);
		Assert.assertEquals(
				this.getFileContent("/exp/bignumber/number_div_expected.html"),
				str);

		t = this.gt.getTemplate("/exp/bignumber/number_div_template.html");
		this.bind(t, "d1", d1, "d2", d2);
		str = t.render();

		Assert.assertEquals(
				this.getFileContent("/exp/bignumber/number_div_expected.html"),
				str);

	}

	public void testMul() throws Exception {
		Template t = gt.getTemplate("/exp/bignumber/number_mul_template.html");
		this.bind(t, "d1", d1, "d2", d2);
		String str = t.render();
		print(str);
		Assert.assertEquals(
				this.getFileContent("/exp/bignumber/number_mul_expected.html"),
				str);

		t = this.gt.getTemplate("/exp/bignumber/number_mul_template.html");
		this.bind(t, "d1", d1, "d2", d2);
		str = t.render();

		Assert.assertEquals(
				this.getFileContent("/exp/bignumber/number_mul_expected.html"),
				str);

	}

}
