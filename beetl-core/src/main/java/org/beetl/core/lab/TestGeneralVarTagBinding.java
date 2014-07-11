package org.beetl.core.lab;

import org.beetl.core.GeneralVarTagBinding;

public class TestGeneralVarTagBinding extends GeneralVarTagBinding
{

	@Override
	public void render()
	{
		int limit = Integer.parseInt((String) this.getAttributeValue("limit"));
		for (int i = 0; i < limit; i++)
		{
			this.bind("value", new TestUser("a"));
			this.doBodyRender();
		}

	}

}
