package org.beetl.core.statement;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

import org.beetl.core.Context;
import org.beetl.core.InferContext;
import org.beetl.core.exception.TempException;

/**
 * @xxx.xx()[0].xxx
 * @author joelli
 *
 */
public class NativeCallExpression extends Expression
{

	InstanceNode insNode;
	ClassNode clsNode;
	List<NativeNode> chain;

	public NativeCallExpression(InstanceNode insNode, List<NativeNode> chain, Token token)
	{
		super(token);
		this.insNode = insNode;
	}

	public NativeCallExpression(ClassNode clsNode, List<NativeNode> chain, Token token)
	{
		super(token);
		this.clsNode = clsNode;
	}

	public Object evaluate(Context ctx)
	{
		Class targetCls = null;
		Object targetObj = null;
		if (insNode != null)
		{
			targetObj = insNode.ref.evaluate(ctx);
			//todo check nullpointer
			targetCls = targetObj.getClass();
		}
		else
		{
			targetObj = ctx.gt.loadClassBySimpleName(this.clsNode.cls);
		}
		for (NativeNode node : chain)
		{
			if (node instanceof NativeAtrributeNode)
			{
				String attr = ((NativeAtrributeNode) node).attribute;
				try
				{
					Field f = targetCls.getField(attr);
					targetObj = f.get(targetObj);
					if (targetObj != null)
					{
						targetCls = targetObj.getClass();
					}
					else
					{
						targetCls = null;
					}
				}
				catch (SecurityException e)
				{
					throw new TempException("can not access filed" + attr);
				}
				catch (NoSuchFieldException e)
				{
					throw new TempException(" no such filed" + attr);
				}
				catch (IllegalArgumentException e)
				{
					throw new TempException(" can not get attribute" + attr);
				}
				catch (IllegalAccessException e)
				{
					throw new TempException(" can not access attribute" + attr);
				}

			}
			else if (node instanceof NativeArrayNode)
			{
				if (!targetCls.isArray())
				{
					throw new TempException(" must be array");
				}
				Expression exp = ((NativeArrayNode) node).exp;
				Object value = exp.evaluate(ctx);
				if (value instanceof Number)
				{
					int index = ((Number) value).intValue();
					targetObj = ((Object[]) targetObj)[index];
					if (targetObj != null)
					{
						targetCls = targetObj.getClass();
					}
					else
					{
						//todo or component of array
						targetCls = null;
					}
				}
				else
				{
					throw new TempException(" array index mustbe number");
				}
			}
			else if (node instanceof NativeMethodNode)
			{
				NativeMethodNode methodNode = (NativeMethodNode) node;
				String method = methodNode.method;
				Expression[] expList = methodNode.paras;
				Object[] args = expList.length == 0 ? null : new Object[expList.length];
				Class[] argTypes = expList.length == 0 ? null : new Class[expList.length];

				for (int i = 0; i < expList.length; i++)
				{
					args[i] = expList[i].evaluate(ctx);
					if (args[i] != null)
					{
						argTypes[i] = args[i].getClass();
					}
				}
				try
				{
					Method m = targetCls.getMethod(method, argTypes);
					targetObj = m.invoke(targetObj, args);
					if (targetObj != null)
					{
						targetCls = targetObj.getClass();
					}
					else
					{
						targetCls = null;
					}

				}
				catch (SecurityException e)
				{
					throw new TempException(" can not get method" + e.getMessage());
				}
				catch (NoSuchMethodException e)
				{
					throw new TempException(" no such method" + e.getMessage());
				}
				catch (IllegalArgumentException e)
				{
					throw new TempException(" illegal parameter for  method" + e.getMessage());
				}
				catch (IllegalAccessException e)
				{
					throw new TempException(" illegal access  method" + e.getMessage());
				}
				catch (InvocationTargetException e)
				{
					throw new TempException("native call message" + e.getTargetException().getMessage());
				}
			}

		}
		return targetObj;
	}

	@Override
	public void infer(InferContext inferCtx)
	{

	}

	public class NativeNode
	{

	}

	public class NativeAtrributeNode extends NativeNode
	{
		public String attribute;

		public NativeAtrributeNode(String attriute)
		{
			this.attribute = attribute;
		}

		public String attribute()
		{
			return this.attribute;
		}
	}

	public class NativeArrayNode extends NativeNode
	{
		public Expression exp;

		public NativeArrayNode(Expression expression)
		{
			this.exp = expression;
		}

	}

	public class NativeMethodNode extends NativeNode
	{
		public String method;
		public Expression[] paras;

		public NativeMethodNode(String method, Expression[] paras)
		{
			this.method = method;
			this.paras = paras;
		}

	}

	public class InstanceNode
	{
		public VarRef ref;

		public InstanceNode(VarRef ref)
		{
			this.ref = ref;
		}
	}

	public class ClassNode
	{
		public String cls = null;

		public ClassNode(String cls)
		{
			this.cls = cls;
		}

	}

}
