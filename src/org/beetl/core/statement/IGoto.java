package org.beetl.core.statement;

public interface IGoto {
	public final static short NORMAL = 0;
	public final static short CONTINUE = 1;
	public final static short BREAK = 2;
	public final static short RETURN = 3;

	public boolean hasGoto();

	public void setGoto(boolean occour);
}
