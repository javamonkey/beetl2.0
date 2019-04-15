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

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.beetl.core.Context;
import org.beetl.core.Function;

/**
 * 截取数字，剩下指定位数,如果输入0，则取整，因为这个仅仅用于输出，所以建议用format函数定制
 * 如
 * ${trunc(12.333,1)},输出是12.3
 * 
 * 推荐使用trunc2
 *
 *
 */

public class TruncFunction implements Function
{

	public Number call(Object[] paras, Context ctx)
	{
		Number n = (Number) paras[0];
		int pos = 0;
		if (paras.length != 1)
		{
			pos = ((Number) paras[1]).intValue();
		}

		if (pos == 0)
			return n.longValue();
		else
		{

			if (n instanceof BigDecimal)
			{
				BigDecimal c = ((BigDecimal) n).setScale(pos, RoundingMode.UP);
				return c;
			}
			else
			{
				//todo:还原成输入类型
				BigDecimal c = new BigDecimal(n.doubleValue());
				return ((BigDecimal) c).setScale(pos, RoundingMode.UP).doubleValue();

			}

		}

	}


}
