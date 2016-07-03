package org.beetl.core.lab;

import org.beetl.core.GeneralVarTagBinding;

public class ColumnTag extends GeneralVarTagBinding {
	
	@Override
	public void render() {
		Integer id = (Integer)this.getAttributeValue("id");
	    this.binds(id+"1002");
	    this.doBodyRender();
	}
}