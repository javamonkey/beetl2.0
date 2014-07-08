package org.beetl.core.statement;

import java.lang.reflect.Method;

import org.beetl.core.Context;
import org.beetl.core.InferContext;
import org.beetl.core.VirtualClassAttribute;
import org.beetl.core.exception.BeetlException;
import org.beetl.core.om.ObjectUtil;

/**
 * list.~size
 * @author joelli
 *
 */
public class VarVirtualAttribute extends VarAttribute
{
	protected String name = null;

	public VarVirtualAttribute(GrammarToken token)
	{
		super(token);
		this.name = token.text;

	}

	public Object evaluate(Context ctx, Object o)
	{

		VirtualClassAttribute vae = ctx.gt.getVirtualAttributeEval(o.getClass(), name);
		if (vae == null)
		{
			BeetlException be = new BeetlException(BeetlException.VIRTUAL_NOT_FOUND);
			be.pushToken(token);
			throw be;
		}
		return vae.eval(o, name, ctx);

	}

	@Override
	public void infer(InferContext inferCtx)
	{
		Type type = (Type) inferCtx.temp;
		VirtualClassAttribute vae = inferCtx.gt.getVirtualAttributeEval(type.cls, name);
		if (vae == null)
		{
			this.type = Type.ObjectType;
		}
		else
		{
			Method m = ObjectUtil.getGetMethod(vae.getClass(), "eval", new Class[]
			{ Object.class, String.class, Context.class });
			this.type = new Type(m.getReturnType());
		}

	}
}
