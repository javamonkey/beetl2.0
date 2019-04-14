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
package org.beetl.ext.fn;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.beetl.core.Context;
import org.beetl.core.Function;

/**
 * @author chengql
 * 
 */
public class ParseLong implements Function
{

	@Override
	public Object call(Object[] paras, Context ctx)
	{
		Object o = paras[0];
		String str = "";
		if (o == null)
			throw new NullPointerException("Error:parseLong(null)");
		long result;
		if (o instanceof Number)
		{
			long n = ((Number) o).longValue();
			str = String.valueOf(n);
		}
		else
		{
			str = o.toString();
		}
		if (str.indexOf(".") != -1)
		{
			str = str.split("\\.")[0];
		}
		Pattern pattern = Pattern.compile("-?[0-9]*");
		Matcher isNum = pattern.matcher(str);
		if (o == null || o.equals("") || !isNum.matches())
		{
			throw new RuntimeException("无法正确转换至long格式");
		}
		try
		{
			result = Long.parseLong(str);
		}
		catch (NumberFormatException e)
		{
			throw new RuntimeException("超出long范围");
		}
		return result;
	}

	// public static void main(String[] args)
	// {
	// ParseInt pInt = new ParseInt();
	// Context ctx = new Context();
	// System.out.println(pInt.call(new Object[]
	// { -0.23232 }, ctx));
	// System.out.println(pInt.call(new Object[]
	// { 2332.23213 }, ctx));
	// System.out.println(pInt.call(new Object[]
	// { "-1.023" }, ctx));
	// System.out.println(pInt.call(new Object[]
	// { "abcd" }, ctx));
	// }
}
