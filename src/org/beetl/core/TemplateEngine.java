package org.beetl.core;

import java.io.Reader;

import org.beetl.core.statement.Program;

public interface TemplateEngine {
	public Program createProgram(String id, Reader input, GroupTemplate gt);

}
