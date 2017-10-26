package org.beetl.ext.simulate;

public class SimulateException extends RuntimeException {
	public  SimulateException(String msg){
		super(msg);
	}
	public  SimulateException(String msg,Throwable cause){
		super(msg,cause);
	}
}
