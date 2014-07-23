package org.beetl.performance.lab.asm;

import org.beetl.performance.lab.User;

public class UserAsmAccessor implements ObjectAccess {
	public Object get(Object o, int index) throws ASMCastException {
		User user = null;
		try {
			user = (User) o;
		} catch (Exception ex) {
			throw new ASMCastException();
		}

		switch (index) {
		case 1:
			return user.getName();
		case 2:
			return user.getId();
		}
		throw new RuntimeException();
	}
}
