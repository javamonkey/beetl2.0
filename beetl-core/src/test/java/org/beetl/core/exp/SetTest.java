package org.beetl.core.exp;

import org.beetl.core.BasicTestCase;
import org.beetl.core.Template;
import org.beetl.core.User;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
/**
 * 测试赋值操作
 * @author xiandafu
 *
 */
public class SetTest extends BasicTestCase
{
	@Test
	public void testArrayMap() throws Exception
	{
		Template t = gt.getTemplate("/exp/set_template.html");
		int[] c = new int[]{1,2};
		int[][] d = new int[][]{{1,2},{3,4}};
		t.binding("c", c);
		t.binding("d", d);
		String str = t.render();
		AssertJUnit.assertEquals(this.getFileContent("/exp/set_expected.html"), str);

		t = gt.getTemplate("/exp/set_template.html");
		t.binding("c", c);
		t.binding("d", d);
		str = t.render();
		AssertJUnit.assertEquals(this.getFileContent("/exp/set_expected.html"), str);
	}
	
	@Test
	public void testPojo() throws Exception
	{
		Template t = gt.getTemplate("/exp/set_pojo_template.html");
		User user = new User("joelli");
		User lover = new User("lucymiao");
		t.binding("user", user);
		t.binding("lover", lover);
		String str = t.render();
		AssertJUnit.assertEquals(this.getFileContent("/exp/set_pojo_expected.html"), str);

		t = gt.getTemplate("/exp/set_pojo_template.html");
		t.binding("user", user);
		t.binding("lover", lover);
		str = t.render();
		AssertJUnit.assertEquals(this.getFileContent("/exp/set_pojo_expected.html"), str);
	}

}
