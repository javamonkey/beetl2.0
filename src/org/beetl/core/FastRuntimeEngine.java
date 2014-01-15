package org.beetl.core;

import java.io.Reader;
import java.util.Map;

import org.beetl.core.filter.AAFilter;
import org.beetl.core.filter.Filter;
import org.beetl.core.filter.TypeBindingFilter;
import org.beetl.core.statement.Program;
import org.beetl.core.statement.Statement;

public class FastRuntimeEngine extends DefaultTemplateEngine {

	@Override
	public Program createProgram(String id, Reader reader,
			Map<Integer, String> textMap, GroupTemplate gt) {

		Program program = super.createProgram(id, reader, textMap, gt);
		Filter nextFilter = new AAFilter(program);
		Filter filter = new TypeBindingFilter(program, nextFilter);
		FilterProgram filterProgram = new FilterProgram(program, filter);
		return filterProgram;
	}

	class FilterProgram extends Program {
		Filter filter = null;

		public FilterProgram(Program program, Filter filter) {
			this.metaData = program.metaData;
			this.filter = filter;

		}

		public void execute(Context ctx) {

			filter.check(ctx);
			for (Statement node : metaData.statements) {
				node.execute(ctx);
			}

		}
	}
}
