package org.beetl.core.tag;

import org.beetl.core.User;

public class VarBindingSeqSampleTag extends GeneralVarTagBinding
{

	@Override
	public void render()
	{
		this.binds("abc", new User("lijz"));
		this.doBodyRender();

	}

}
