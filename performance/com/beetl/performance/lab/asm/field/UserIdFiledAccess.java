package com.beetl.performance.lab.asm.field;

import com.beetl.performance.lab.User;

public class UserIdFiledAccess implements ObjectAccess {

	public UserIdFiledAccess() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Object value(Object o, Object name) {
		// TODO Auto-generated method stub
		return ((User)o).getId();
	}


	

}
