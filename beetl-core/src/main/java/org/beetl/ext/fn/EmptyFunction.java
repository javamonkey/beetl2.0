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

import java.util.Collection;
import java.util.Map;

import org.beetl.core.Context;
import org.beetl.core.Function;
import org.beetl.core.misc.PrimitiveArrayUtil;

/**
 * 判断全局变量是否为“空”，下列情况属于为空·的情况
 * <ul>
 * 
 * <li>变量不存在</li>
 * <li>变量存在，但为null</li>
 * <li>变量存在，但是字符，其长途为0</li>
 * <li>变量存在，但是空集合</li>
 * <li>变量存在，但是空数组</li>
 * </ul>
 * 参数可以一个到多个,如<p>
 * ${empty("list")}
 * @author joelli
 *
 */
@Deprecated
public class EmptyFunction implements Function {

	@Override
	public Boolean call(Object[] paras, Context ctx) {

		String key = null;
		for (Object o : paras) {
			key = (String) o;
			if (ctx.globalVar.containsKey(key)) {
				Object result = ctx.getGlobal(key);
				if (result != null) {

					if (result instanceof String) {

						if (((String) result).length() != 0) {
							return false;
						}

					} else if (result instanceof Collection) {
						if (((Collection) result).size() != 0) {
							return false;
						}
					} else if (result instanceof Map) {
						if (((Map) result).size() != 0) {
							return false;
						}
					} else if (result.getClass().isArray()) {
						Class ct = result.getClass().getComponentType();
						if (ct.isPrimitive()) {
							return PrimitiveArrayUtil.getSize(result) == 0;
						} else {
							return ((Object[]) result).length == 0;
						}
					} else {
						return false;
					}

				} else {

					continue;
				}

			}

		}

		return true;

	}


}
