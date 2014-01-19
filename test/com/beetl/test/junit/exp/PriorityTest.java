package com.beetl.test.junit.exp;

import junit.framework.Assert;

import org.beetl.core.Template;

import com.beetl.test.junit.BasicTestCase;

public class PriorityTest extends BasicTestCase {
	public void testAll() throws Exception {
		Template t = gt.getTemplate("/exp/priority_all_template.html");
		String str = t.render();
		Assert.assertEquals(
				this.getFileContent("/exp/priority_all_expected.html"), str);

		t = this.gt.getTemplate("/exp/priority_all_template.html");

		str = t.render();
		Assert.assertEquals(
				this.getFileContent("/exp/priority_all_expected.html"), str);
	}
}
