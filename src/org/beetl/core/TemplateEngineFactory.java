package org.beetl.core;

public class TemplateEngineFactory {
	// public static String ENGINE = "org.beetl.core.DefaultTemplateEngine";
	public static String ENGINE = "org.beetl.core.FastRuntimeEngine";

	public static TemplateEngine getEngine() {
		try {
			return (TemplateEngine) Class.forName(ENGINE).newInstance();
		} catch (Exception ex) {
			throw new RuntimeException(ex.getMessage());
		}

	}
}
