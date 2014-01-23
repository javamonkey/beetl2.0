package org.beetl.core.filter;

import java.util.Collection;
import java.util.Map;
import java.util.Stack;

import org.beetl.core.Context;
import org.beetl.core.IteratorStatus;
import org.beetl.core.attr.AA;
import org.beetl.core.attr.AAFactory;
import org.beetl.core.cache.Cache;
import org.beetl.core.event.ProgramReplaceEvent;
import org.beetl.core.statement.ASTNode;
import org.beetl.core.statement.Expression;
import org.beetl.core.statement.ForStatement;
import org.beetl.core.statement.Program;
import org.beetl.core.statement.Type;
import org.beetl.core.statement.VarAttribute;
import org.beetl.core.statement.VarRef;

public class AAFilter extends Filter implements Executor
{

	Cache cache = null;

	public AAFilter(Program program)
	{
		super(program);

	}

	@Override
	public void check(Context ctx)
	{
		StatementSeacher seacher = new StatementSeacher();
		// 优化VarRef，和循环
		Class[] matchClasses = new Class[]
		{ VarRef.class, ForStatement.class };
		seacher.match(program.metaData.statements, matchClasses, this);
		// 替换成性能较好的
		this.program.gt.getProgramCache().set(program.id, program);
		ProgramReplaceEvent event = new ProgramReplaceEvent(program);
		this.program.gt.fireEvent(event);

	}

	@Override
	public ASTNode on(Stack<ASTNode> stack)
	{
		Object o = stack.peek();
		if (o instanceof VarRef)
		{
			VarRef ref = (VarRef) o;
			VarAttribute[] attrs = ref.attributes;
			for (VarAttribute attr : attrs)
			{
				Type type = attr.type;
				String name = attr.token != null ? attr.token.text : null;
				// 换成速度较快的属性访问类
				AA aa = AAFactory.buildFiledAccessor(type.cls, name);
				attr.aa = aa;

			}

		}
		else if (o instanceof ForStatement)
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
