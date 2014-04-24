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

import org.beetl.core.lab.TestUser;
import org.beetl.core.misc.ByteClassLoader;

/** 可以设置{@link BCWFactory#defaultFactory} 来选择不同的字节码生成器，默认采用{@link FieldAccessBCW}
 * @author joelli
 *
 */
public class BCWFactory
{

	public static BCWFactory defaultFactory = new BCWFactory();

	public BCWFactory getBCWFactory()
	{
		return defaultFactory;
	}

	/** 获得字节码
	 * @return
	 * @throws Exception
	 */
	public BCW getAttribyteBCW(Class c, String name, String methodName, Class returnType)
	{
		FieldAccessBCW f = new FieldAccessBCW(c, name, methodName, returnType);
		return f;
	}

	public static void main(String[] args) throws Exception
	{
		{
			//			IteratorStatus it = new IteratorStatus(Collections.EMPTY_LIST);
			//			BCWFactory f = new BCWFactory();
			//			BCW bcw = f.getAttribyteBCW(IteratorStatus.class, "even", "getEven", boolean.class);
			//			byte[] bs = bcw.getClassByte();
			//			ByteClassLoader loader = new ByteClassLoader(AttributeAccess.class.getClassLoader());
			//			Class c = loader.defineClass("org.beetl.core.IteratorStatus_even", bs);
			//			AttributeAccess a = (AttributeAccess) c.newInstance();
			//			Object result = a.value(it, "even");
			//			System.out.println(result);
		}

		{
			//			System.out.println(boolean.class);
			TestUser it = new TestUser("");
			BCWFactory f = new BCWFactory();
			BCW bcw = f.getAttribyteBCW(TestUser.class, "bir", "getBir", java.util.Date.class);
			byte[] bs = bcw.getClassByte();
			ByteClassLoader loader = new ByteClassLoader(AttributeAccess.class.getClassLoader());
			Class c = loader.defineClass("org.beetl.core.lab.TestUser_bir", bs);
			AttributeAccess a = (AttributeAccess) c.newInstance();
			Object result = a.value(it, "ok");
			System.out.println(result);
		}

	}
}
