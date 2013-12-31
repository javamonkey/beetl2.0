package org.beetl.core;

public class TemplateEngineFactory {
	public static TemplateEngine getEngine() {
		return new DefaultTemplateEngine();
	}
}
