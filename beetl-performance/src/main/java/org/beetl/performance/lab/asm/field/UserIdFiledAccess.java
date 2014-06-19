package org.beetl.performance.lab.asm.field;

import org.beetl.performance.lab.User;

public class UserIdFiledAccess extends FieldAccess {

	public Object value(Object o, Object name) {
		// TODO Auto-generated method stub
		return ((User) o).get((String)name);
	}

}
