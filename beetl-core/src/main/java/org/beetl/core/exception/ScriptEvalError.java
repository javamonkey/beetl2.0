package org.beetl.core.exception;

public class ScriptEvalError extends Exception {
	public ScriptEvalError() {

	}
	

	public ScriptEvalError(String message,Throwable t) {
		super(message,t);
	}

	public ScriptEvalError(Throwable t) {
		super(t);
	}
}
