package org.beetl.performance.lab.asm.field;

import org.beetl.performance.lab.User;

public class UserGeneralAccess {
	static final int key = "name".hashCode();

	public Object value(Object o, Object name) {
		switch (name.hashCode()) {
		case 3373707:
			return ((User) o).getName();
		}
		return null;
	}
}
