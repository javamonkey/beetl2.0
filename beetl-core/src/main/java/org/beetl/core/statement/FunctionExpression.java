package org.beetl.core.statement;

import java.lang.reflect.Method;

import org.beetl.core.Context;
import org.beetl.core.Function;
import org.beetl.core.InferContext;
import org.beetl.core.exception.TempException;

/**
 * 
 * @author joelli
 *
 */
public class FunctionExpression extends Expression
{
	String name;
	Expression[] exps;
	VarAttribute[] vas;

	public FunctionExpression(String name, Expression[] exps, VarAttribute[] vas, Token token)
	{
		super(token);
		this.name = name;
		this.exps = exps;
		this.vas = vas;
	}

	public Object evaluate(Context ctx)
	{
		Function fn = ctx.gt.getFunction(name);
		if (fn == null)
		{
			throw new TempException("fn:" + name + "isNull");
		}

		Object[] paras = new Object[exps.length];
		for (int i = 0; i < paras.length; i++)
		{
			paras[i] = exps[i].evaluate(ctx);
		}
		Object value = fn.call(paras, ctx);
		if (vas == null)
		{
			return value;
		}
		else
		{

			for (VarAttribute attr : vas)
			{

				value = attr.evaluate(ctx, value);
				if (value == null)
				{
					throw new TempException("null" + attr.name);
				}

			}
			return value;
		}

	}

	public void infer(InferContext inferCtx)
	{
		Function fn = inferCtx.gt.getFunction(name);
		for (Expression exp : exps)
		{
			exp.infer(inferCtx);
		}

		Method call = null;

		try
		{
			call = fn.getClass().getMethod("call", Object[].class, Context.class);
		}
		catch (NoSuchMethodException e)
		{
			throw new TempException(fn.getClass() + "没有找到call方法 ");
		}
		catch (SecurityException e)
		{
			throw new TempException(fn.getClass() + "call方法不允许反射调用 ");
		}

		Class c = call.getReturnType();
		Type lastType = new Type(c);
		if (vas != null)
		{
			this.type = lastType;
			return;
		}
		else
		{

			Type t = null;
			for (VarAttribute attr : vas)
			{
				inferCtx.temp = lastType;
				attr.infer(inferCtx);
				t = lastType;
				lastType = attr.type;
				attr.type = t;

			}
			this.type = lastType;
		}

	}

}
