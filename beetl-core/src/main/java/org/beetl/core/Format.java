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
 * 格式化函数，用于模版里占位符里的变量格式化后输出，如:
 * <p></p>
 * ${user.birthday,dateFormat='yyyy-MM-dd'}
 * <p></p>
 * dateFormat为格式化函数，通过groupTemplate的registerFormat函数注册，等号后面的
 * 字符串是需要格式化的样式，如果没有，可以不写，如：
 * <p></p>
 * ${user.birthday,dateFormat},格式化函数应该支持pattern为null的情况
 * 
 * <pre>
 * public Object format(Object data, String pattern) {
 * 	if (data instanceof Date) {
 * 		SimpleDateFormat sdf = null;
 * 		if (pattern == null) {
 * 			sdf = new SimpleDateFormat();
 * 		} else {
 * 			sdf = new SimpleDateFormat(pattern);
 * 		}
 * 		return sdf.format(data);
 * 
 * 	} else {
 * 		throw new RuntimeException(&quot;Arg Error:Type should be Date&quot;);
 * 	}
 * }
 * </pre>
 * 
 * @author joelli
 * 
 */
public interface Format
{

	/**
	 * @param data
	 *            格式化对象
	 * @param pattern
	 *            ，模式，格式换函数需要考虑到pattern为null的情况
	 * @return
	 */
	public Object format(Object data, String pattern);

}
