package org.beetl.core.statement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.beetl.core.Context;
import org.beetl.core.InferContext;

public class JsonArrayExpression extends Expression
{

	List<Expression> list;

	public JsonArrayExpression(List<Expression> list, Token token)
	{
		super(token);
		this.list = list;
	}

	public Object evaluate(Context ctx)
	{
		if (list.size() == 0)
		{
			return Collections.EMPTY_LIST;
		}
		else
		{
			List values = new ArrayList(list.size());
			for (Expression exp : list)
			{
				values.add(exp.evaluate(ctx));
			}
			return values;

		}
	}

	@Override
	public void infer(InferContext inferCtx)
	{
		List values = new ArrayList(list.size());
		for (Expression exp : list)
		{
			exp.infer(inferCtx);
		}

	}

}
