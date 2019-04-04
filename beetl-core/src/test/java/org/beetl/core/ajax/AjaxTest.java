package org.beetl.core.ajax;

import org.beetl.core.BasicTestCase;
import org.beetl.core.Template;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

public class AjaxTest extends BasicTestCase {
    @Test
    public void testAll() throws Exception
    {
        //测试渲染整个模板
        Template t = gt.getTemplate("/ajax/ajax_template.html");

        String str = t.render();
        String expected = this.getFileContent("/ajax/ajax_expected.html");
        AssertJUnit.assertEquals(expected, str);


    }

    @Test
    public void testAjax() throws Exception
    {
        //测试渲染ajax部分
        Template t = gt.getAjaxTemplate("/ajax/ajax_template.html","sayHello");
        t.binding("data",new int[]{1,3});
        String str = t.render();
        String expected = this.getFileContent("/ajax/ajax_expected1.html");
        AssertJUnit.assertEquals(expected, str);


    }
}
