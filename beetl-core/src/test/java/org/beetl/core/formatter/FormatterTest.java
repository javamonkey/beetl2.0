package org.beetl.core.formatter;

import java.util.HashMap;
import java.util.Map;

import org.beetl.core.BasicTestCase;
import org.beetl.core.Template;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

public class FormatterTest extends BasicTestCase {
	@Test
	public void testCore() throws Exception {

		gt.registerFormat("date.short", new ShortDateFormatter());

		Map map = new HashMap();
		map.put("a", 1.12);
		Template t = gt.getTemplate("/formatter/formatter_template.html");
		t.binding(map);
		String str = t.render();
		AssertJUnit.assertEquals(this.getFileContent("/formatter/formatter_expected.html"), str);

	}

}
