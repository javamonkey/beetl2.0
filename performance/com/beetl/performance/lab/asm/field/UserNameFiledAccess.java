package com.beetl.performance.lab.asm.field;

import com.beetl.performance.lab.User;

public class UserNameFiledAccess implements FieldAccess {

	public UserNameFiledAccess() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Object get(Object o, int index, String name) {
		// TODO Auto-generated method stub
		return ((User)o).getName();
	}


	

}
