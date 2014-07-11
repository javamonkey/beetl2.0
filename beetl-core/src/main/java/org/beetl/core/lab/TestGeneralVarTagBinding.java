package org.beetl.core.lab;

import org.beetl.core.GeneralVarTagBinding;

public class TestGeneralVarTagBinding extends GeneralVarTagBinding
{

	@Override
	public void render()
	{
		for (int i = 0; i < 5; i++)
		{
			this.bind("value", i);
			this.doBodyRender();
		}

	}

}
