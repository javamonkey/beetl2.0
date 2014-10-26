package org.beetl.core.engine;

import org.beetl.core.Context;
import org.beetl.core.statement.Program;

public class FilterProgram extends Program
{
	Probe filter = null;
	Program copyProgram;

	public FilterProgram(Program program, Program copyProgram, Probe filter)
	{
		this.metaData = program.metaData;
		this.filter = filter;
		this.res = program.res;
		this.gt = program.gt;
		this.rs = program.rs;
		this.copyProgram = copyProgram;

	}

	public Program getCopy()
	{
		return this.copyProgram;
	}

	public void execute(Context ctx)
	{

		filter.check(ctx);
		super.execute(ctx);

	}
}