package com.beetl.test.junit.exp;

import junit.framework.Assert;

import org.beetl.core.Template;

import com.beetl.test.junit.BasicTestCase;

public class GeneralNumberTest extends BasicTestCase
{
	int d1 = 1;
	int d2 = 2;

	public GeneralNumberTest()
	{

	}

	public void testAdd() throws Exception
	{
		Template t = gt.getTemplate("/exp/general_add_template.html");
		this.bind(t, "d1", d1, "d2", d2);
		String str = t.render();
		Assert.assertEquals(this.getFileContent("/exp/general_add_expected.html"), str);

		t = this.gt.getTemplate("/exp/general_add_template.html");
		this.bind(t, "d1", d1, "d2", d2);
		str = t.render();
		Assert.assertEquals(this.getFileContent("/exp/general_add_expected.html"), str);

	}

	public void testMinus() throws Exception
	{
		Template t = gt.getTemplate("/exp/general_minus_template.html");
		this.bind(t, "d1", d1, "d2", d2);
		String str = t.render();
		print(str);
		Assert.assertEquals(this.getFileContent("/exp/general_minus_expected.html"), str);

		t = this.gt.getTemplate("/exp/general_minus_template.html");
		this.bind(t, "d1", d1, "d2", d2);
		str = t.render();
		Assert.assertEquals(this.getFileContent("/exp/general_minus_expected.html"), str);

	}

	public void testCompare() throws Exception
	{
		Template t = gt.getTemplate("/exp/general_compare_template.html");
		this.bind(t, "d1", d1, "d2", d2);
		String str = t.render();
		print(str);
		Assert.assertEquals(this.getFileContent("/exp/general_compare_expected.html"), str);

		t = this.gt.getTemplate("/exp/general_compare_template.html");
		this.bind(t, "d1", d1, "d2", d2);
		str = t.render();

		Assert.assertEquals(this.getFileContent("/exp/general_compare_expected.html"), str);

	}

	public void testDiv() throws Exception
	{
		Template t = gt.getTemplate("/exp/general_div_template.html");
		this.bind(t, "d1", d1, "d2", d2);
		String str = t.render();
		print(str);
		Assert.assertEquals(this.getFileContent("/exp/general_div_expected.html"), str);

		t = this.gt.getTemplate("/exp/general_div_template.html");
		this.bind(t, "d1", d1, "d2", d2);
		str = t.render();

		Assert.assertEquals(this.getFileContent("/exp/general_div_expected.html"), str);

	}

	/*
	public void testMul() throws Exception {
		Template t = gt.getTemplate("/exp/general_mul_template.html");
		this.bind(t, "d1", d1, "d2", d2);
		String str = t.render();
		print(str);
		Assert.assertEquals(
				this.getFileContent("/exp/general_mul_expected.html"), str);

		t = this.gt.getTemplate("/exp/general_mul_template.html");
		this.bind(t, "d1", d1, "d2", d2);
		str = t.render();

		Assert.assertEquals(
				this.getFileContent("/exp/general_mul_expected.html"), str);

	}
	*/
}
