package org.beetl.core;

public  abstract class ContextFormat implements Format {

	@Override
	public Object format(Object data, String pattern) {
		throw new UnsupportedOperationException();
	}
	
	public abstract Object format(Object data,String pattern,Context ctx);

}
