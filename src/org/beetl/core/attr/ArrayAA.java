package org.beetl.core.attr;



public class ArrayAA implements AA {


	@Override
	public Object value(Object o,  Object attr) {
		int index = ((Number)attr).intValue();
		return ((Object[])o)[index];
	}

	
}
