package org.beetl.core.script;

import java.util.Map;

import org.beetl.core.BasicTestCase;
import org.testng.annotations.Test;

public class ScriptTest extends BasicTestCase
{
	@Test
	public void testFileFunctionRetrun() throws Exception
	{

		Map result = gt.runScript("/script/testscript.html", null);
		this.assertEquals(result.get("a"), 1);
		this.assertEquals(result.get("b"), "b");
		this.assertEquals(result.get("return"), 5);

	}

	@Test
	public void testFileFunction2() throws Exception
	{

		Map result = gt.runScript("/script/testscript2.html", null);
		this.assertEquals(result.get("name"), "lijz");

	}

}
