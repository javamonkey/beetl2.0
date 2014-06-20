package org.beetl.core.tag;

import java.util.Map;

import org.beetl.core.Tag;
import org.beetl.core.TagVarBinding;

public class VarBindingSampleTag extends Tag implements TagVarBinding
{

	@Override
	public void render()
	{
		this.doBodyRender();

	}

	@Override
	public Object[] bindVars()
	{
		Map map = (Map) this.args[1];
		String[] array = new String[]
		{ "a", "b" };

		return new Object[]
		{ map.get("value"), array };
	}

}
