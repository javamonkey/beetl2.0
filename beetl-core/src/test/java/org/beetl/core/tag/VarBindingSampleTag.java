package org.beetl.core.tag;

import java.util.Map;

public class VarBindingSampleTag extends GeneralVarTagBinding
{

	@Override
	public void render()
	{
		Map map = (Map) this.args[1];
		Object value1 = map.get("value");
		String[] array = new String[]
				{ "a", "b" };
		this.binds(value1,array);
		this.doBodyRender();

	}

	

}
