package org.beetl.core.filter;

import org.beetl.core.Context;
import org.beetl.core.statement.Program;

public abstract class Filter {
	Program program = null;

	public Filter(Program program) {
		this.program = program;
	}

	public abstract void check(Context ctx);
}
