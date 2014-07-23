package org.beetl.performance.lab.asm;

public interface Access {
	public Object get(Object o, int index) throws ASMCastException;
}
