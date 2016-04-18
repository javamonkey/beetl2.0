package org.beetl.core.engine;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

import org.beetl.core.Context;
import org.beetl.core.Event;
import org.beetl.core.GroupTemplate;
import org.beetl.core.InferContext;
import org.beetl.core.Listener;
import org.beetl.core.exception.BeetlException;
import org.beetl.core.misc.BeetlUtil;
import org.beetl.core.misc.NumberUtil;
import org.beetl.core.misc.PrimitiveArrayUtil;
import org.beetl.core.om.AttributeAccess;
import org.beetl.core.om.AttributeAccessFactory;
import org.beetl.core.statement.Expression;
import org.beetl.core.statement.Literal;
import org.beetl.core.statement.Type;
import org.beetl.core.statement.VarAttribute;
import org.beetl.core.statement.VarRef;
import org.beetl.core.statement.VarSquareAttribute;
import org.beetl.core.statement.VarVirtualAttribute;

public class VarAttributeNodeListener implements Listener
{

	@Override
	public Object onEvent(Event e)
	{
		Stack stack = (Stack) e.getEventTaget();
	
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
					try
					{
						GroupTemplate gt = (GroupTemplate)((Map)stack.get(0)).get("groupTemplate");
						AttributeAccess aa = AttributeAccessFactory.buildFiledAccessor(type.cls, name,gt);
						attr.aa = aa;
					}
					catch (BeetlException ex)
					{
						ex.pushToken(attr.token);
						throw ex;
					}

				}
				else if (attr.getClass() == VarSquareAttribute.class)
				{
					Type type = attr.type;
					Class c = type.cls;
					if (Map.class.isAssignableFrom(c))
					{
						attr.setAA(AttributeAccessFactory.mapAA);
					}
					else if (List.class.isAssignableFrom(c) || Set.class.isAssignableFrom(c))
					{
						attr.setAA(AttributeAccessFactory.listAA);
					}

					else if (c.isArray())
					{
						attr.setAA(AttributeAccessFactory.arrayAA);
					}
					else
					{
						Expression exp = ((VarSquareAttribute) attr).exp;
						if (exp instanceof Literal)
						{
							Literal literal = (Literal) exp;
							if (literal.obj instanceof String)
							{

								try
								{
									String attributeName = (String) literal.obj;
									GroupTemplate gt = (GroupTemplate)((Map)stack.get(0)).get("groupTemplate");
									AttributeAccess aa = AttributeAccessFactory.buildFiledAccessor(c, attributeName,gt);
									ref.attributes[i] = new VarSquareAttribute2((VarSquareAttribute) attrs[i],
											attributeName, aa);
								}
								catch (BeetlException ex)
								{
									ex.pushToken(attr.token);
									throw ex;
								}

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

			if (o.getClass().getComponentType().isPrimitive())
			{
				return PrimitiveArrayUtil.getSize(o);
			}
			else
			{
				return NumberUtil.valueOf(((Object[]) o).length);

			}
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

		public VarSquareAttribute2(VarSquareAttribute var, String name, AttributeAccess aa)
		{
			super(var.exp, var.token);
			this.name = name;
			this.aa = aa;
		}

		public Object evaluate(Context ctx, Object o)
		{
			try{
				return aa.value(o, name);
			}catch(ClassCastException ex){
				throw BeetlUtil.throwCastException(ex, ctx.gt);
			}
			
		}

		@Override
		public void infer(InferContext inferCtx)
		{
			super.infer(inferCtx);
		}

	}
}
