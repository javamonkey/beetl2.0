package org.beetl.performance.lab.asm;

import org.beetl.performance.lab.User;

public class Manager extends User {
	@Override
	public Manager getPeer() {
		return new Manager();
	}
}
