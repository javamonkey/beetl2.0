package org.beetl.core.statement;

import org.beetl.core.Context;
import org.beetl.core.GroupTemplate;

public class Program
{
	// 模板的所有脚本语句
	public ProgramMetaData metaData = null;
	public String id = null;
	public GroupTemplate gt = null;

	public Program()
	{

	}

	public void execute(Context ctx)
	{

		for (Statement node : metaData.statements)
		{
			node.execute(ctx);
		}

	}

}
