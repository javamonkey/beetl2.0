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
 * 默认的本地调用安全管理器，黑名单方式，不允许调用java.lang.Runtime和Process
 * 
 * @author joelli
 *
 */
public class DefaultNativeSecurityManager implements NativeSecurityManager {

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.beetl.core.NativeSecurityManager#permit(java.lang.String,
	 * java.lang.Class, java.lang.Object, java.lang.String)
	 */
	@Override
	public boolean permit(String resourceId, Class c, Object target, String method) {
		if (c.isArray()) {
			// 允许调用，但实际上会在在其后调用中报错。不归此处管理
			return true;
		}
		String name = c.getName();
		String className = null;
		String pkgName = null;
		int i = name.lastIndexOf('.');
		if (i != -1) {
			pkgName = name.substring(0, i);
			className = name.substring(i + 1);

		} else {
			// 无包名，允许调用
			return true;
		}

		if (pkgName.startsWith("java.lang")) {
			if (className.equals("Runtime") || className.equals("Process") || className.equals("ProcessBuilder")
					|| className.equals("System")) {
				return false;
			}
		}

		return true;
	}

}
