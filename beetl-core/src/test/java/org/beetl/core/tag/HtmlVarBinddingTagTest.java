package org.beetl.core.tag;

import org.beetl.core.BasicTestCase;
import org.beetl.core.Template;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

public class HtmlVarBinddingTagTest extends BasicTestCase
{

	@Test
	public void testEmptyTag() throws Exception
	{

		//将默认搜索路径更改到tag目录下
		gt.registerTag("tagbinding", VarBindingSampleTag.class);

		Template t = gt.getTemplate("/tag/binding/tagbinding_template.html");
		String str = t.render();
		AssertJUnit.assertEquals(this.getFileContent("/tag/binding/tagbinding_expected.html"), str);

	
	}

	@Test
	public void testLoopTag() throws Exception
	{

		//将默认搜索路径更改到tag目录下
		gt.registerTag("tagloopbinding", VarBindingLoopSampleTag.class);
		//todo 会多出一个空行
		Template t = gt.getTemplate("/tag/binding/tagloopbinding_template.html");
		String str = t.render();
		AssertJUnit.assertEquals(this.getFileContent("/tag/binding/tagloopbinding_expected.html"), str);

	
	}

	@Test
	public void testTagSeq() throws Exception
	{

		//测试按照顺序绑定
		gt.registerTag("tagseqbinding", VarBindingSeqSampleTag.class);
		//todo 会多出一个空行
		Template t = gt.getTemplate("/tag/binding/tagseqbinding_template.html");
		String str = t.render();
		AssertJUnit.assertEquals(this.getFileContent("/tag/binding/tagseqbinding_expected.html"), str);

		
	}

	@Test
	public void testBindingByAttribute() throws Exception
	{

		//测试通过特殊属性绑定
		gt.registerTag("tagseqbinding", VarBindingSeqSampleTag.class);
		//todo 会多出一个空行
		Template t = gt.getTemplate("/tag/binding/tagAttr_template.html");
		String str = t.render();
		AssertJUnit.assertEquals(this.getFileContent("/tag/binding/tagAttr_expected.html"), str);

	
	}
	
	@Test
	public void testBindingExport() throws Exception
	{

		//测试通过特殊属性绑定
		gt.registerTag("tagseqbinding", VarBindingSeqSampleTag.class);
		//todo 会多出一个空行
		Template t = gt.getTemplate("/tag/binding/tagAttrExport_template.html");
		String str = t.render();
		AssertJUnit.assertEquals(this.getFileContent("/tag/binding/tagAttrExport_expected.html"), str);

	
	}

}
