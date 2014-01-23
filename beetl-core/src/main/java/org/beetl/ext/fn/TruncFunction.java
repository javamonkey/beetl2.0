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

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.bee.tl.core.BeeNumber;
import org.bee.tl.core.Context;
import org.bee.tl.core.Function;
import org.bee.tl.core.number.NumberFactory;

/**
 * 截取数字，剩下指定位数,如果输入0，则取整
 * 如
 * ${trunc(12.333,1)},输出是12.3
 *
 */
public class TruncFunction implements Function
{

	public BeeNumber call(Object[] paras, Context ctx)
	{
		BeeNumber n = (BeeNumber) paras[0];
		int pos = 0;
		if (paras.length != 1)
		{
			pos = ((BeeNumber) paras[1]).intValue();			
		}
		//@todo ,得到正确的Number工厂
		if (pos == 0)
			return NumberFactory.big.y(n.longValue());
		else
		{
			BigDecimal c = n.getBigDecimal().setScale(pos, RoundingMode.UP);
			
			return NumberFactory.big.y(c);
		}

	}

	public static void main(String[] args)
	{
		
		
		BigDecimal b = new BigDecimal("1212.2632");
		//		b.setScale(0);
		BigDecimal c = b.setScale(1, RoundingMode.UP);

		System.out.println(c);
	}
}
