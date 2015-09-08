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

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.beetl.core.Context;
import org.beetl.core.Function;

/**
 * 日期函数，如<p>
 * today is ${date()},或者<p>
 * <pre>
 * &lt;% var time = date('2011-1-1','yyyy-MM-dd')  %&gt;
 * </pre>
 * <p>
 * time对象是java.util.Date对象  
 * @author joelli
 *
 */
public class DateFunction implements Function
{

	public Date call(Object[] paras, Context ctx)
	{
		if (paras.length == 0)
		{
			return new Date();
		}
		else
		{
			if (paras.length == 2)
			{

				if (paras[0] instanceof String && paras[1] instanceof String)
				{
					SimpleDateFormat sdf = new SimpleDateFormat((String) paras[1]);
					try
					{
						return sdf.parse((String) paras[0]);
					}
					catch (ParseException e)
					{
						throw new RuntimeException("Parse date Error"+e.getMessage());
					}
				}

			}
			throw new RuntimeException("Parse date Error,Args String,Sting ");
		}

	}
}
