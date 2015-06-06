/*
 [The "BSD license"]
 Copyright (c) 2011-2013 Joel Li (李家智)
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
package org.beetl.ext.fn;

import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *  操作字符串的简便方法，如：<p>
 *  ${strutil.startWith("hello",'he')}
 * @author joeli
 *
 */
public class StringUtil
{
	public String trim(String str)
	{
		if (str == null)
			throw new NullPointerException("Error:trim(null)");
		return str.trim();
	}

	public boolean startWith(String str, String key)
	{
		if (str == null)
			throw new NullPointerException("Error:startWith(null)");
		return str.startsWith(key);
	}

	public boolean endWith(String str, String key)
	{
		if (str == null)
			throw new NullPointerException("Error:endWith(null)");
		return str.endsWith(key);
	}

	public int length(String str)
	{
		if (str == null)
			throw new NullPointerException("Error:length(null)");
		return str.length();
	}

	public String subStringTo(String str, int start, int end)
	{
		if (str == null)
			throw new NullPointerException("Error:subStringTo(null)");
		return str.substring(start, end);
	}

	public String subString(String str, int start)
	{
		if (str == null)
			throw new NullPointerException("Error:subString(null)");
		return str.substring(start);
	}

	public String[] split(String str, String key)
	{
		if (str == null)
			throw new NullPointerException("Error: split(null)");
		return str.split(key);
	}

	public boolean contain(String str, String key)
	{
		if (str == null)
			throw new NullPointerException("Error: contain(null)");
		return str.indexOf(key) != -1;
	}

	public String toUpperCase(String str)
	{
		if (str == null)
			throw new NullPointerException("Error:toUpperCase(null)");
		return str.toUpperCase();
	}

	public String toLowerCase(String str)
	{
		if (str == null)
			throw new NullPointerException("Error:toLowerCase(null)");
		return str.toLowerCase();
	}

	public String replace(String str, String oldValue, String newValue)
	{
		if (str == null)
			throw new NullPointerException("Error:replace(null)");
		return str.replace(oldValue, newValue);
	}

	public String format(String str, Object[] args)
	{
		if (str == null)
			throw new NullPointerException("Error:format(null)");
		String result = MessageFormat.format(str, args);
		return result;
	}

	public String formatDate(Date o, String args)
	{
		if (o == null)
			throw new NullPointerException("Error:formatDate(null)");
		SimpleDateFormat sd = new SimpleDateFormat(args);
		return sd.format(o);
	}

	public int index(String str, String search)
	{
		if (str == null)
			throw new NullPointerException("Error:index(null)");
		return str.indexOf(search);
	}

	public int lastIndex(String str, String search)
	{
		if (str == null)
			throw new NullPointerException("Error:lastIndex(null)");
		return str.lastIndexOf(search);
	}

}
