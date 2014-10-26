package org.beetl.core.engine;

import org.beetl.core.Context;
import org.beetl.core.statement.Program;

public abstract class Probe
{
	Program program = null;

	public Program getProgram()
	{
		return program;
	}

	public void setProgram(Program program)
	{
		this.program = program;
	}

	public abstract void check(Context ctx);
}
