package org.beetl.core.filter;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

import org.beetl.core.Context;
import org.beetl.core.InferContext;
import org.beetl.core.IteratorStatus;
import org.beetl.core.attr.AA;
import org.beetl.core.attr.AAFactory;
import org.beetl.core.cache.Cache;
import org.beetl.core.event.ProgramReplaceEvent;
import org.beetl.core.statement.ASTNode;
import org.beetl.core.statement.Expression;
import org.beetl.core.statement.ForStatement;
import org.beetl.core.statement.Literal;
import org.beetl.core.statement.Program;
import org.beetl.core.statement.Type;
import org.beetl.core.statement.VarAttribute;
import org.beetl.core.statement.VarRef;
import org.beetl.core.statement.VarSquareAttribute;
import org.beetl.core.statement.VarVirtualAttribute;
import org.beetl.core.util.NumberUtil;

/**
 * 子类可继承此类，重载getMore，以及handleMore
 * @author joelli
 *
 */
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
		Class[] more = this.getMore();

		Class[] allMatchClasses = null;

		if (more == null)
		{
			allMatchClasses = matchClasses;
		}
		else
		{
			allMatchClasses = new Class[matchClasses.length + more.length];
			System.arraycopy(matchClasses, 0, allMatchClasses, 0, matchClasses.length);
			System.arraycopy(matchClasses, matchClasses.length, more, 0, more.length);

		}
		seacher.match(program.metaData.statements, matchClasses, this);
		// 替换成性能较好的
		this.program.gt.getProgramCache().set(program.id, program);
		ProgramReplaceEvent event = new ProgramReplaceEvent(program);
		this.program.gt.fireEvent(event);

	}

	protected Class[] getMore()
	{
		return null;
	}

	protected void handleMore(ASTNode current, Stack<ASTNode> stack)
	{

	}

	@Override
	public ASTNode on(Stack<ASTNode> stack)
	{
		Object o = stack.peek();
		if (o instanceof VarRef)
		{
			VarRef ref = (VarRef) o;
			VarAttribute[] attrs = ref.attributes;
			for (int i = 0; i < attrs.length; i++)
			{
				VarAttribute attr = attrs[i];
				if (attr.getClass() == VarAttribute.class)
				{
					Type type = attr.type;

					String name = attr.token != null ? attr.token.text : null;
					// 换成速度较快的属性访问类
					AA aa = AAFactory.buildFiledAccessor(type.cls, name);
					attr.aa = aa;

				}
				else if (attr.getClass() == VarSquareAttribute.class)
				{
					Type type = attr.type;
					Class c = type.cls;
					if (Map.class.isAssignableFrom(c))
					{
						attr.setAA(AAFactory.mapAA);
					}
					else if (List.class.isAssignableFrom(c) || Set.class.isAssignableFrom(c))
					{
						attr.setAA(AAFactory.listAA);
					}

					else if (c.isArray())
					{
						attr.setAA(AAFactory.arrayAA);
					}
					else
					{
						Expression exp = ((VarSquareAttribute) attr).exp;
						if (exp instanceof Literal)
						{
							Literal literal = (Literal) exp;
							if (literal.obj instanceof String)
							{
								String attributeName = (String) literal.obj;
								AA aa = AAFactory.buildFiledAccessor(c, attributeName);
								ref.attributes[i] = new VarSquareAttribute2((VarSquareAttribute) attrs[i],
										attributeName, aa);
							}
						}

					}
				}
				else if (attr.getClass() == VarVirtualAttribute.class)
				{
					//对虚拟属性~size做优化
					if (attr.token.text.equals("size"))
					{
						//优化
						Class c = attr.type.cls;

						if (Map.class.isAssignableFrom(c))
						{
							ref.attributes[i] = new MapSizeVirtualAttribute((VarVirtualAttribute) attr);
						}
						else if (Collection.class.isAssignableFrom(c))
						{
							ref.attributes[i] = new CollectionSizeVirtualAttribute((VarVirtualAttribute) attr);
						}

						else if (c.isArray())
						{
							ref.attributes[i] = new ArraySizeVirtualAttribute((VarVirtualAttribute) attr);
						}

					}
				}

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
		else
		{
			this.handleMore((ASTNode) o, stack);
		}

		return null;

	}

	class CollectionSizeVirtualAttribute extends VarVirtualAttribute
	{
		VarVirtualAttribute old;

		public CollectionSizeVirtualAttribute(VarVirtualAttribute old)
		{
			super(old.token);
			this.old = old;
		}

		public Object evaluate(Context ctx, Object o)
		{
			return NumberUtil.valueOf(((Collection) o).size());
		}

		@Override
		public void infer(InferContext inferCtx)
		{
			super.infer(inferCtx);
		}
	}

	class MapSizeVirtualAttribute extends VarVirtualAttribute
	{
		VarVirtualAttribute old;

		public MapSizeVirtualAttribute(VarVirtualAttribute old)
		{
			super(old.token);
			this.old = old;
		}

		public Object evaluate(Context ctx, Object o)
		{
			return NumberUtil.valueOf(((Map) o).size());
		}

		@Override
		public void infer(InferContext inferCtx)
		{
			super.infer(inferCtx);
		}
	}

	class ArraySizeVirtualAttribute extends VarVirtualAttribute
	{
		VarVirtualAttribute old;

		public ArraySizeVirtualAttribute(VarVirtualAttribute old)
		{
			super(old.token);
			this.old = old;
		}

		public Object evaluate(Context ctx, Object o)
		{

			return NumberUtil.valueOf(((Object[]) o).length);
		}

		@Override
		public void infer(InferContext inferCtx)
		{
			super.infer(inferCtx);
		}
	}

	class VarSquareAttribute2 extends VarSquareAttribute
	{
		String name;

		public VarSquareAttribute2(VarSquareAttribute var, String name, AA aa)
		{
			super(var.exp, var.token);
			this.name = name;
			this.aa = aa;
		}

		public Object evaluate(Context ctx, Object o)
		{
			return aa.value(o, name);
		}

		@Override
		public void infer(InferContext inferCtx)
		{
			super.infer(inferCtx);
		}

	}

}
