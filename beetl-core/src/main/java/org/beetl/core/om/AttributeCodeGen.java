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

import java.io.File;
import java.io.FileOutputStream;

import org.beetl.core.GroupTemplate;
import org.beetl.core.misc.ByteClassLoader;

/** 生成一个属性访问类，此类将调用BCWFactory来获取字节码，因此，可以设置
 * {@link BCWFactory#defaultFactory} 按照其他方式生成字节码，比如，不用默认的
 * one filed ,one AttributeClass 方式，采用节省内存的One Class,One AttributeClass方式
 * @author joelli
 *
 */
public class AttributeCodeGen
{

	
	public static AttributeAccess createAAClass(Class c, String name, String methodName, Class returnType,GroupTemplate gt)
	{
		try
		{
			BCW bcw = BCWFactory.defaultFactory.getAttribyteBCW(c, name, methodName, returnType);
			byte[] bs = bcw.getClassByte();
			String clsName = c.getName() + "_" + name;
			return instance(bs, clsName,gt);
		}
		catch (Exception ex)
		{
			throw new RuntimeException(ex);
		}

	}

	public static AttributeAccess createAAClass(Class c, String name, String methodName, Class returnType,
			Class parameterType,GroupTemplate gt)
	{
		try
		{
			BCW bcw = BCWFactory.defaultFactory.getAttribyteBCW(c, name, methodName, returnType, parameterType);
			byte[] bs = bcw.getClassByte();
			String clsName = c.getName() + "_" + name;
			return instance(bs, clsName,gt);

		}
		catch (Exception ex)
		{
			throw new RuntimeException(ex);
		}

	}

	private static AttributeAccess instance(byte[] bs, String clsName,GroupTemplate gt)
	{
//		javap -c xxxx 
//		try{
//			FileOutputStream fos = new FileOutputStream(new File("d:/"+clsName+".class"));
//			fos.write(bs);
//			fos.close();
//		}catch(Exception ex){
//			ex.printStackTrace();
//		}
		
		Class fieldAccessorClass =  gt.getByteLoader().defineClass(clsName, bs);
		AttributeAccess ac;
		try
		{
			ac = (AttributeAccess) fieldAccessorClass.newInstance();
			return ac;
		}
		catch (Exception e)
		{
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}

	}

}
