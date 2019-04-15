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

import java.util.Iterator;

import org.beetl.core.Context;
import org.beetl.core.Function;

/**
 * 
 * @author 张健川 dlut.zjc@gmail.com,fixed by leonlau 10181606@qq.com

 */
public class Range implements Function
{
	@Override
	public Iterator<Integer> call(Object[] paras, Context ctx)
	{
		final int param1 = ((Number) paras[0]).intValue();
		final int param2 = ((Number) paras[1]).intValue();

		if (paras.length > 3)
		{
			throw new RuntimeException("参数设置不正确");
		}
		final int param3 = paras.length == 3 ? ((Number) paras[2]).intValue() : 1;
		if (param3 == 0)
		{ //原地踏步走？
			throw new RuntimeException("参数step(步进)非零整数");
		}
		return new Iterator<Integer>() {
			private int start = param1;
			private int end = param2;
			private int step = param3;
			private int currentValue = start;

			@Override
			public boolean hasNext()
			{
				return step > 0 ? currentValue < end : currentValue > end;
			}

			@Override
			public Integer next()
			{
				Integer temp = currentValue;
				currentValue += step;
				return temp;
			}

			@Override
			public void remove()
			{

			}
		};
	}
}
