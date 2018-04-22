package org.beetl.core;

public class TemplateEngineFactory
{
	// public static String ENGINE = "org.beetl.core.DefaultTemplateEngine";

	/**
	 * 也可以使用org.beetl.core.DefaultTemplateEngine
	 */
	public static String ENGINE = "org.beetl.core.DefaultTemplateEngine";

	public static TemplateEngine getEngine(String engine)
	{
		try
		{
			return (TemplateEngine) Class.forName(engine).newInstance();
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
			throw new RuntimeException(ex.getMessage());
		}

	}
}
