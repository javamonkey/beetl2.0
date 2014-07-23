package org.beetl.performance.lab.asm.field;

import org.beetl.performance.lab.User;

public class UserNameFiledAccess extends FieldAccess {

	public UserNameFiledAccess() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Object value(Object o, Object name) {
		// TODO Auto-generated method stub
		return ((User) o).getName();
	}

}
