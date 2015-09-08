/*
 [The "BSD license"]
 Copyright (c) 2011-2014 Joel Li (李家智)
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
package org.beetl.core.om;

import java.math.BigDecimal;

import org.beetl.core.exception.BeetlException;
import org.beetl.core.misc.PrimitiveArrayUtil;

/**访问数组的封装类,attr需要任何能转成int的数值类型
 * @author joelli
 *
 */
public class ArrayAA extends AttributeAccess
{

	public Object value(Object o, Object attr)
	{
		if (attr instanceof Integer || attr instanceof Long || attr instanceof Short || attr instanceof Byte
				|| attr instanceof BigDecimal)
		{
			int index = ((Number) attr).intValue();
			if (index < 0)
			{
				BeetlException ex = new BeetlException(BeetlException.ARRAY_INDEX_ERROR, "索引必须大于或者等于");
				throw ex;
			}

			if (o.getClass().getComponentType().isPrimitive())
			{
				return PrimitiveArrayUtil.getObject(o, index);
			}
			else
			{
				return ((Object[]) o)[index];
			}

		}
		else
		{
			BeetlException ex = new BeetlException(BeetlException.ARRAY_INDEX_ERROR, "该对象是数组，期望是整形或者是BigDecimal类型, 如果对象是动态的的，需要directive dynamic ");
			throw ex;
		}

	}

}
