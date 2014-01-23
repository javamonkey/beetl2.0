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

import org.beetl.core.Context;
import org.beetl.core.Function;

/**
 * if else 函数的简单实现
 *${decode(a,1,"a=1",2,"a=2","不知道了")}
 * 如果a是1，这decode输出"a=1",如果a是2，则输出"a==2",
 * 如果是其他值，则输出"不知道了"
 * @author jeolli
 *
 */
public class DecodeFunction implements Function
{

	public Object call(Object[] paras, Context ctx)
	{
		try
		{
			Object o = paras[0];
			int i = 1;
			while (true)
			{
				if (same(o, paras[i]))
				{
					return paras[i + 1];
				}
				else
				{
					if (paras.length - 1 == i + 2)
					{
						//default
						return paras[i + 2];
					}
					else
					{
						i = i + 2;
						continue;
					}
				}
			}
		}
		catch (ArrayIndexOutOfBoundsException ex)
		{

			throw new RuntimeException("decode函数使用错误:DECODE(value, if1, then1, if2,then2, if3,then3, . . . else )");
		}

	}

	private boolean same(Object a, Object b)
	{
		if (a == null && b == null)
			return true;
		else if (a != null && b != null)
		{
			return a.equals(b);
		}
		else
		{
			return false;
		}
	}

	public static void main(String args[])
	{
		DecodeFunction f = new DecodeFunction();
		int a = 5;
		Object result = f.call(new Object[]
		{ a, 1, "a=1", 2, "a=2", "不知道了", 1 }, null);
		System.out.println(result);

	}
}
