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
package org.beetl.core;

/**
 * Beetl函数接口，用户可以通过实现此接口来自定一方法，譬如 实现一个将字符创转为大写的函数"str.upcase"
 * <p>
 * 
 * <pre>
 * group.registerFunction(&quot;str.upcase&quot;, new Function() {
 * 
 * 	public String call(Object[] paras, Context ctx) {
 * 		String str = (String) paras[0];
 * 		return str.toUpperCase();
 * 	}
 * 
 * });
 * </pre>
 * 
 * str.upcase接收一个字符串参数，并将其转为大写，如下调用
 * <p>
 * 
 * <pre>
 * hello,this is ${str.upcase(user.name)}
 * </pre>
 * 
 * @author jeolli
 * @since 1.1
 *
 * 
 * 
 */

public interface Function
{

	/**
	 * 
	 * @param paras
	 *            beetl传递的参数
	 * @param ctx
	 *            
	 * @return
	 * 
	 */
	public Object call(Object[] paras, Context ctx);

}