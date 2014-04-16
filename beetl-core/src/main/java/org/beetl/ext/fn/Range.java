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

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import org.beetl.core.Context;
import org.beetl.core.Function;
import org.stringtemplate.v4.compiler.STParser.ifstat_return;

/**
 * 
 * @author 张健川 dlut.zjc@gmail.com
 * @create 2014-04-16
 */
public class Range implements Function
{

	@Override
	public Collection<Integer> call(Object[] paras, Context ctx)
	{
		int step = 1;
		if (paras.length > 2)
		{
			step = ((Number) paras[2]).intValue();
		}
		Collection<Integer> collection = new ArrayList<Integer>();
		int min = ((Number) paras[0]).intValue();
		int max = ((Number) paras[1]).intValue();
		if ((step < 0 && min < max) || ((step > 0) && (min > max)) || min == max)
		{
			throw new RuntimeException("最值设定方式不正确");
		}
		if (min < max)
		{
			for (int i = min; i < max; i += step)
			{
				collection.add(i);
			}
		}
		else
		{
			for (int i = min; i > max; i += step)
			{
				collection.add(i);
			}
		}
		return collection;
	}

	public static void main(String[] args)
	{
		Context ctx = new Context();
		Range range = new Range();
		System.out.println(range.call(new Object[]
		{ 52, 54, 1 }, ctx));
	}
}
