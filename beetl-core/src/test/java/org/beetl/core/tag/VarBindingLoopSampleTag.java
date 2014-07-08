package org.beetl.core.tag;

import java.util.Map;

import org.beetl.core.Tag;
import org.beetl.core.TagVarBinding;

public class VarBindingLoopSampleTag extends Tag implements TagVarBinding
{

	@Override
	public void render()
	{
		Map attributes = (Map) this.args[1];
		int loop = Integer.parseInt((String) attributes.get("value"));
		for (int i = 0; i < loop; i++)
		{
			this.doBodyRender();
		}

	}

	@Override
	public Object[] bindVars()
	{
		String[] array = new String[]
		{ "a", "b" };
		return new Object[]
		{ array };
	}

}
