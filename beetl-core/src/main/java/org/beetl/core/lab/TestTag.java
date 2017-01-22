package org.beetl.core.lab;

import org.beetl.core.GeneralVarTagBinding;

public class TestTag extends GeneralVarTagBinding {

	@Override
	public void render() {
		int limit = Integer.parseInt((String)this.getAttributeValue("limit"));
		for(int i=0;i<limit;i++){
			this.binds(String.valueOf(i));
			this.doBodyRender();
		}

	}

}
