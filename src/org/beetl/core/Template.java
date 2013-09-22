package org.beetl.core;

import java.io.OutputStream;
import java.io.Writer;

import org.beetl.core.exception.BeetlException;

public interface Template {
	public String getText() throws BeetlException;
	public void getText(Writer w)throws BeetlException;
	public void getText(OutputStream os) throws BeetlException;
}
