package org.beetl.core.statement;

import java.util.Set;

import org.beetl.core.Context;
import org.beetl.core.InferContext;

public class DirectiveStatement extends Statement
{

	String directive;
	Set<String> idList;
	static final String SAFE_OUTPUT_OPEN = "safe_output_open".intern();
	static final String SAFE_OUTPUT_CLOSE = "safe_output_close".intern();

	public DirectiveStatement(String directive, Set<String> idList, GrammarToken token)
	{
		super(token);
		this.directive = directive;
		this.idList = idList;

	}

	@Override
	public void execute(Context ctx)
	{
		if (directive == SAFE_OUTPUT_OPEN)
		{
			ctx.safeOutput = true;
		}
		else if (directive == SAFE_OUTPUT_CLOSE)
		{
			ctx.safeOutput = false;
		}

	}

	@Override
	public void infer(InferContext inferCtx)
	{

	}

	public String getDirective()
	{
		return directive;
	}

	public Set<String> getIdList()
	{
		return idList;
	}

}
