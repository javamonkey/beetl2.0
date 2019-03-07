package org.beetl.core.exception;

public class ScriptEvalError extends Exception {
	public ScriptEvalError() {

	}
	

	public ScriptEvalError(String message,BeetlException t) {
		super(message,t);
	}

	public ScriptEvalError(BeetlException t) {
		super(t);
	}
}
