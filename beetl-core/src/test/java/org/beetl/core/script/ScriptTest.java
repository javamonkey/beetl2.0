package org.beetl.core.script;

import java.util.Map;

import org.beetl.core.BasicTestCase;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

public class ScriptTest extends BasicTestCase
{
	@Test
	public void testFileFunctionRetrun() throws Exception
	{

		Map result = gt.runScript("/script/testscript.html", null);
		AssertJUnit.assertEquals(result.get("a"), 1);
		AssertJUnit.assertEquals(result.get("b"), "b");
		AssertJUnit.assertEquals(result.get("return"), 5);

	}

	@Test
	public void testFileFunction2() throws Exception
	{

		Map result = gt.runScript("/script/testscript2.html", null);
		AssertJUnit.assertEquals(result.get("name"), "lijz");

	}

}
