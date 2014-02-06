package org.beetl.core.statement;

import java.lang.reflect.Method;

import org.beetl.core.Context;
import org.beetl.core.InferContext;
import org.beetl.core.VirtualAttributeEval;
import org.beetl.core.util.ObjectUtil;

public class VarVirtualAttribute extends VarAttribute
{
	protected String name = null;

	public VarVirtualAttribute(Token token)
	{
		super(token);
		this.name = token.text;

	}

	public Object evaluate(Context ctx, Object o)
	{

		VirtualAttributeEval vae = ctx.gt.getVirtualAttributeEval(o.getClass(), name);
		return vae.eval(o, name, ctx);

	}

	@Override
	public void infer(InferContext inferCtx)
	{
		Type type = (Type) inferCtx.temp;
		VirtualAttributeEval vae = inferCtx.gt.getVirtualAttributeEval(type.cls, name);
		Method m = ObjectUtil.getGetMethod(vae.getClass(), "eval", new Class[]
		{ Object.class, String.class, Context.class });
		this.type = new Type(m.getReturnType());
	}
}
