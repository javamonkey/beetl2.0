package org.beetl.ext.jsp;

import java.io.PrintWriter;
import java.io.Writer;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

import org.beetl.core.io.NoLockStringWriter;

public class BeetlServletResponseWrapper extends HttpServletResponseWrapper
{
	NoLockStringWriter cw = null;
	PrintWriter writer = null;

	public BeetlServletResponseWrapper(HttpServletResponse rsp)
	{
		super(rsp);
	}

	public java.io.PrintWriter getWriter()
	{
		if (writer == null)
		{
			cw = new NoLockStringWriter();
			writer = new PrintWriter(cw);
		}

		return writer;
	}

	public Writer getRealWriter()
	{

		return cw;
	}

}
