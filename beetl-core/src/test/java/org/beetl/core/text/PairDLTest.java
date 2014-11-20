package org.beetl.core.text;

import java.io.IOException;

import org.beetl.core.BasicTestCase;
import org.beetl.core.Configuration;
import org.beetl.core.GroupTemplate;
import org.beetl.core.Template;
import org.beetl.core.resource.ClasspathResourceLoader;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

/**
 * 格式验证，确保输出文本不会有多余空格，空行
 * @author joelli
 *
 */
public class PairDLTest extends BasicTestCase
{

	@Test
	public void testSimple() throws Exception
	{

		GroupTemplate newGt = getGt();
		Template t = newGt.getTemplate("/text/simple_pair_template.html");
		String str = t.render();
		AssertJUnit.assertEquals(this.getFileContent("/text/simple_pair_expected.html"), str);

	}

	@Test
	public void testPair() throws Exception
	{

		GroupTemplate newGt = getGt();
		Template t = newGt.getTemplate("/text/pair_template.html");
		String str = t.render();
		AssertJUnit.assertEquals(this.getFileContent("/text/pair_expected.html"), str);

	}

	public GroupTemplate getGt()
	{
		ClasspathResourceLoader rs = new ClasspathResourceLoader("/template");
		Configuration cfg;
		try
		{
			cfg = Configuration.defaultConfiguration();
		}
		catch (IOException e)
		{
			throw new RuntimeException(e);
		}
		cfg.setStatementEnd("%>");
		cfg.setStatementStart("<%");

		GroupTemplate gt = new GroupTemplate(rs, cfg);
		return gt;
	}
}