package org.beetl.core.statement;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.beetl.core.Context;
import org.beetl.core.InferContext;

public class JsonMapExpression extends Expression
{

	Map<String, Expression> map;

	public JsonMapExpression(Map<String, Expression> map, Token token)
	{
		super(token);
		this.map = map;
	}

	public Object evaluate(Context ctx)
	{
		if (map.size() == 0)
		{
			return Collections.EMPTY_MAP;
		}
		else
		{
			Map values = new HashMap(map.size());
			for (Entry<String, Expression> entry : map.entrySet())
			{
				values.put(entry.getKey(), entry.getValue().evaluate(ctx));
			}
			return values;

		}
	}

	@Override
	public void infer(InferContext inferCtx)
	{

		for (Expression exp : map.values())
		{
			exp.infer(inferCtx);
		}
		this.type = Type.MapType;

	}

}
