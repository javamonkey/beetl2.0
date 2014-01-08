package org.beetl.core.statement;

import org.beetl.core.Context;
import org.beetl.core.filter.Filter;

public class Program {
	// 模板的所有脚本语句
	public ProgramMetaData metaData = null;
	public Filter filter = null;

	public Program(Filter filter) {
		this.filter = filter;
	}

	public Program() {

	}

	public void execute(Context ctx) {

		if (filter != null) {
			filter.check(ctx);
		}

		for (Statement node : metaData.statements) {
			node.execute(ctx);
		}

	}

}
