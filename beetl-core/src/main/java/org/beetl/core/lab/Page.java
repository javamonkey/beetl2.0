package org.beetl.core.lab;

import java.util.ArrayList;
import java.util.List;

public class Page{
	
	public List<TestUser> data = new ArrayList<TestUser>();

	public List<TestUser> getData() {
		return data;
	}

	public void setData(List<TestUser> data) {
		this.data = data;
	}
	
	
}