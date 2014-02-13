package org.beetl.core.event;

import java.util.Collection;
import java.util.Map;
import java.util.Stack;

import org.beetl.core.IteratorStatus;
import org.beetl.core.statement.Expression;
import org.beetl.core.statement.ForStatement;

public class ForNodeListener implements Listener
{

	@Override
	public Object onEvent(Event e)
	{
		Stack stack = (Stack) e.getEventTaget();
		Object o = stack.peek();
		if (o instanceof ForStatement)
		{
			ForStatement f = (ForStatement) o;
			Expression exp = f.exp;
			if (Map.class.isAssignableFrom(exp.type.cls))
			{
				f.itType = IteratorStatus.MAP;
			}
			else if (Collection.class.isAssignableFrom(exp.type.cls))
			{
				f.itType = IteratorStatus.COLLECTION;
			}
			else if (Iterable.class.isAssignableFrom(exp.type.cls))
			{
				f.itType = IteratorStatus.ITERABLE;
			}
			else if (exp.type.cls.isArray())
			{
				f.itType = IteratorStatus.ARRAY;
			}
			else
			{
				// 运行时刻判断
				f.itType = IteratorStatus.GENERAL;
			}

		}
		return null;

	}

}
