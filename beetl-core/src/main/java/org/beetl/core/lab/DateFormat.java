package org.beetl.core.lab;

import java.util.Date;

public class DateFormat
{
	public String simple(long i)
	{
		return new Date(i).toGMTString();
	}
}
