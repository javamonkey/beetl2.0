package org.beetl.core;

import java.io.Reader;
import java.util.Map;

import org.beetl.core.statement.Program;

public interface TemplateEngine {
	public Program createProgram(String id, Reader input,
			Map<String, String> textMap, GroupTemplate gt);

}
