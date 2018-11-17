package org.beetl.core.statement;

import org.beetl.core.Context;
import org.beetl.core.VirtualClassAttribute;
import org.beetl.core.exception.BeetlException;

/**
 * list.~size
 * @author joelli
 *
 */
public class VarVirtualAttribute extends VarAttribute {
	protected String name = null;

	public VarVirtualAttribute(GrammarToken token) {
		super(token);
		this.name = token.text;

	}

	public Object evaluate(Context ctx, Object o) {

		VirtualClassAttribute vae = ctx.gt.getVirtualAttributeEval(o.getClass(), name);
		if (vae == null) {
			BeetlException be = new BeetlException(BeetlException.VIRTUAL_NOT_FOUND);
			be.pushToken(token);
			throw be;
		}
		return vae.eval(o, name, ctx);

	}

}
