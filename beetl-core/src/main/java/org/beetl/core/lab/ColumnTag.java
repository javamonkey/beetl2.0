package org.beetl.core.lab;

import org.beetl.core.GeneralVarTagBinding;

public class ColumnTag extends GeneralVarTagBinding {
	
	@Override
	public void render() {
	
		TestBean bean = new TestBean();
		bean.setId("dfsdf123");
	    this.binds(bean);
	    this.doBodyRender();
	}
}