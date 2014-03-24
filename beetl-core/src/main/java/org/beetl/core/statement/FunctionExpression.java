package org.beetl.core.statement;

import java.lang.reflect.Method;

import org.beetl.core.Context;
import org.beetl.core.Function;
import org.beetl.core.InferContext;
import org.beetl.core.exception.BeetlException;

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

	public FunctionExpression(String name, Expression[] exps, VarAttribute[] vas, GrammarToken token)
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
			BeetlException ex = new BeetlException(BeetlException.FUNCTION_NOT_FOUND);
			ex.token = token;
			throw ex;
		}

		Object[] paras = new Object[exps.length];
		for (int i = 0; i < paras.length; i++)
		{
			paras[i] = exps[i].evaluate(ctx);
		}
		Object value = null;
		try
		{
			value = fn.call(paras, ctx);
		}
		catch (BeetlException ex)
		{
			ex.token = this.token;
			throw ex;
		}
		catch (RuntimeException ex)
		{
			BeetlException be = new BeetlException(BeetlException.NATIVE_CALL_EXCEPTION, "调用方法出错 " + name, ex);
			be.token = this.token;
			throw be;
		}

		if (vas == null)
		{
			return value;
		}
		else
		{

			for (VarAttribute attr : vas)
			{

				try
				{
					value = attr.evaluate(ctx, value);
				}
				catch (BeetlException ex)
				{
					ex.token = attr.token;
					throw ex;

				}
				catch (RuntimeException ex)
				{
					BeetlException be = new BeetlException(BeetlException.ATTRIBUTE_INVALID, "属性访问出错", ex);
					be.token = attr.token;
					throw be;
				}

				if (value == null)
				{
					BeetlException be = new BeetlException(BeetlException.ERROR, "空指针 ");
					be.token = attr.token;
					throw be;
				}

			}
			return value;
		}

	}

	public void infer(InferContext inferCtx)
	{
		Function fn = inferCtx.gt.getFunction(name);
		if (fn == null)
		{
			BeetlException ex = new BeetlException(BeetlException.FUNCTION_NOT_FOUND);
			ex.token = token;
			throw ex;
		}
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
			BeetlException ex = new BeetlException(BeetlException.FUNCTION_INVALID);
			ex.token = token;
			throw ex;
		}
		catch (SecurityException e)
		{
			BeetlException ex = new BeetlException(BeetlException.FUNCTION_INVALID);
			ex.token = token;
			throw ex;
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
