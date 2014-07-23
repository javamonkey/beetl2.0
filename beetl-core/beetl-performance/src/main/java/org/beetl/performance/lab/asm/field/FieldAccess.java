package org.beetl.performance.lab.asm.field;

public abstract class FieldAccess {

	public Class returnType;

	public abstract Object value(Object o, Object name);
}
