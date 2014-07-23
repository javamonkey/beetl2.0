package org.beetl.performance.lab.asm;

import org.beetl.performance.lab.PrivateTest;

public class PrivateTestGet {
	Object get = null;
	public String getName(Object o){
		return ((PrivateTest)o).getName();
	}
}
