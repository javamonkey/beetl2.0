package org.beetl.core.lab;

import org.beetl.core.GeneralVarTagBinding;

public class ColumnTag extends GeneralVarTagBinding {
	
	@Override
	public void render() {
		String id = (String)this.getAttributeValue("id");
	    this.binds(id+"1002");
	    this.doBodyRender();
	}
}