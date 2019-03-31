package org.beetl.core.tag;

import java.util.Map;

public class VarBindingLoopSampleTag extends GeneralVarTagBinding
{

	@Override
	public void render()
	{
		Map attributes = (Map) this.args[1];
		int loop = Integer.parseInt((String) attributes.get("value"));
		String[] array = new String[]
				{ "a", "b" };
		Object paras1 = array;
		for (int i = 0; i < loop; i++)
		{
			this.binds(paras1);
			this.doBodyRender();
		}

	}

	

}
