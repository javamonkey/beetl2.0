/*
 [The "BSD license"]
 Copyright (c) 2011-2013  闲大赋 (李家智)
 All rights reserved.

 Redistribution and use in source and binary forms, with or without
 modification, are permitted provided that the following conditions
 are met:
 1. Redistributions of source code must retain the above copyright
     notice, this list of conditions and the following disclaimer.
 2. Redistributions in binary form must reproduce the above copyright
     notice, this list of conditions and the following disclaimer in the
     documentation and/or other materials provided with the distribution.
 3. The name of the author may not be used to endorse or promote products
     derived from this software without specific prior written permission.

 THIS SOFTWARE IS PROVIDED BY THE AUTHOR ``AS IS'' AND ANY EXPRESS OR
 IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES
 OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED.
 IN NO EVENT SHALL THE AUTHOR BE LIABLE FOR ANY DIRECT, INDIRECT,
 INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT
 NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
 DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY
 THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF
 THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package org.beetl.ext.format;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.beetl.core.Format;

/**
 * 日期格式化函数，如
 * ${date,dateFormat='yyyy-Mm-dd'}，如果没有patten，则使用local 
 * @author joelli
 *
 */
public class DateFormat implements Format
{
	private static final String DEFAULT_KEY = "default";

	private ThreadLocal<Map<String, SimpleDateFormat>> threadlocal = new ThreadLocal<Map<String, SimpleDateFormat>>();

	public Object format(Object data, String pattern)
	{
		if (data == null){
			return null;
		}

		if (Date.class.isAssignableFrom(data.getClass()))
		{
			SimpleDateFormat sdf = null;
			if (pattern == null)
			{
				sdf = getDateFormat(DEFAULT_KEY);
			}
			else
			{
				sdf = getDateFormat(pattern);
			}
			return sdf.format((Date) data);

		}
		else if (data.getClass() == Long.class)
		{
			Date date = new Date((Long) data);
			SimpleDateFormat sdf = null;
			if (pattern == null)
			{
				sdf = getDateFormat(DEFAULT_KEY);
			}
			else
			{
				sdf = getDateFormat(pattern);
			}
			return sdf.format(date);

		}
		else
		{
			throw new RuntimeException("参数错误，输入为日期或者Long:" + data.getClass());
		}

	}

	private SimpleDateFormat getDateFormat(String pattern)
	{
		Map<String, SimpleDateFormat> map = null;
		if ((map = threadlocal.get()) == null)
		{
			/**
			 * 初始化2个空间
			 */
			map = new HashMap<String, SimpleDateFormat>(4, 0.65f);
			threadlocal.set(map);
		}
		SimpleDateFormat format = map.get(pattern);
		if (format == null)
		{
			if (DEFAULT_KEY.equals(pattern))
			{
				format = new SimpleDateFormat();
			}
			else
			{
				format = new SimpleDateFormat(pattern);
			}
			map.put(pattern, format);
		}
		return format;
	}
}
