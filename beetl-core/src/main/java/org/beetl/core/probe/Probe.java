package org.beetl.core.probe;

import org.beetl.core.Context;
import org.beetl.core.statement.Program;

public abstract class Probe
{
	Program program = null;

	public Probe(Program program)
	{
		this.program = program;
	}

	public abstract void check(Context ctx);
}
