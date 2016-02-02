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

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 生成一个方法调用的字节码,如对User对象name属性，则生成如下代码
 * <pre>
 * public User$_name implements AttributeAccess{
 * 	public Object value(Object o, Object name){
 *      return ((User)o).getName();
 * 	}
 * }
 * </pre>
 * @author joelli
 *
 */
public class FieldAccessBCW implements BCW
{

	static final int MAGIC = 0xCAFEBABE;
	static final byte CONS_CLASS = 7;
	static final byte CONS_UTF8 = 1;
	static final byte CONS_METHODREF = 10;
	static final byte CONS_INTERFACE_METHODREF = 11;

	static final byte CONS_NAME_AND_TYPE = 12;
	static final byte CONS_DOUBLE = 6;

	static final short ALOAD_0 = 42;
	static final short ALOAD_1 = 43;
	static final short ALOAD_2 = 44;
	static final short INVOKE_SPECIAL = 183;
	static final short INVOKE_VIRTUAL = 182;
	static final short INVOKE_INTERFACE = 185;

	static final short RETURN = 177;
	static final short ARETURN = 176;
	static final short CHECK_CAST = 192;
	static final short INVOKE_STATIC = 184;
	static final String parentCls = "org/beetl/core/om/AttributeAccess";
	static final String initFunction = "<init>";
	static final String initFunctionDesc = "()V";
	static final String valueFunction = "value";
	static final String valueFunctionDesc = "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;";
	static final String code = "Code";

	//outbox,inbox
	static final String integerClass = "org/beetl/core/misc/NumberUtil"; //优化过的拆箱
	static final String valueOfFunction = "valueOf";
	static final String intValueOfFunctionDesc = "(I)Ljava/lang/Integer;";

	static final String shortClass = "java/lang/Short";
	static final String shortValueOfFunctionDesc = "(S)Ljava/lang/Short;";

	static final String booleanClass = "java/lang/Boolean";
	static final String booleanValueOfFunctionDesc = "(Z)Ljava/lang/Boolean;";

	static final String doubleClass = "java/lang/Double";
	static final String doubleValueOfFunctionDesc = "(D)Ljava/lang/Double;";

	static String floatClass = "java/lang/Float";
	static String floatValueOfFunctionDesc = "(F)Ljava/lang/Float;";

	
	static String longClass = "java/lang/Long";
	static String longValueOfFunctionDesc = "(J)Ljava/lang/Long;";

	static String byteClass = "java/lang/Byte";
	static String byteValueOfFunctionDesc = "(B)Ljava/lang/Byte;";

	byte[] cached = new byte[256];
	List<Object[]> constPool = new ArrayList<Object[]>();
	Map<String, Short> utfMap = new HashMap<String, Short>();
	Map<String, Short> classMap = new HashMap<String, Short>();

	String cls = "org/beetl/sample/s01/Test1";
	String targetCls = "org/beetl/core/lab/TestUser";
	String targetFunction = "getAge";
	String targetFunctionDesc = "()I";
	String retByteCodeType = "I";
	boolean isGeneralGet = false;
	boolean isInterface = false;

	//	static ASMClassLoader loader = new ASMClassLoader();
	//
	//	static class ASMClassLoader extends ClassLoader
	//	{
	//		public Class defineClass(String name, byte[] b)
	//		{
	//			return defineClass(name, b, 0, b.length);
	//		}
	//	}
	//
	//	/**
	//	 * 尝试自己写bytecode代码，代替asm.jar,以缩小beetl大小
	//	 * @param args
	//	 */
	//	public static void main(String[] args) throws Exception
	//	{
	//		Class c = TestUser.class;
	//		String name = "contacts";
	//		String methodName = "getContacts";
	//		Class returnType = String[].class;
	//		FiledAccessByteCodeWriter cw = new FiledAccessByteCodeWriter(c, name, methodName, returnType);
	//		byte[] bs = cw.getClassByte();
	//
	//		//		OutputStream ins = new FileOutputStream("e:/Test1.class");
	//		//		ins.write(bs);
	//		//		ins.close();
	//		TestUser user = new TestUser("joelli");
	//		Class fieldAccessorClass = loader.defineClass(c.getName() + "_" + name, bs);
	//		AttributeAccess ac = (AttributeAccess) fieldAccessorClass.newInstance();
	//		Object result = ac.value(user, name);
	//		System.out.println(result);
	//
	//	}

	public FieldAccessBCW(Class c, String name, String methodName, Class returnType)
	{
		if (c.isInterface())
			isInterface = true;
		String cname = c.getName().replace(".", "/");
		this.targetCls = cname;
		this.cls = cname + "_" + name;
		this.targetFunction = methodName;
		String[] returnArray = this.getRetrunTypeDesc(returnType);
		String returnTypeClass = returnArray[0];
		this.retByteCodeType = returnArray[1];
		this.targetFunctionDesc = "()" + returnTypeClass;

	}

	public FieldAccessBCW(Class c, String name, String methodName, Class returnType, Class paremterType)
	{

		if (c.isInterface())
			isInterface = true;
		String cname = c.getName().replace(".", "/");
		this.targetCls = cname;
		this.cls = cname + "_" + name;
		this.targetFunction = methodName;
		String[] returnArray = this.getRetrunTypeDesc(returnType);
		String returnTypeClass = returnArray[0];
		this.retByteCodeType = returnArray[1];
		this.targetFunctionDesc = "(Ljava/lang/String;)" + returnTypeClass;
		isGeneralGet = true;

	}

	public byte[] getClassByte() throws Exception
	{
		ByteArrayOutputStream bs = new ByteArrayOutputStream();
		DataOutputStream out = new DataOutputStream(bs);
		write(out);

		return bs.toByteArray();
	}

	//	public Object getObject() throws Exception
	//	{
	//		FiledAccessByteCodeWriter cw = new FiledAccessByteCodeWriter();
	//		byte[] bs = cw.getClassByte();
	//		Class c = loader.defineClass("org.beetl.sample.s01.Test1", bs);
	//		Object o = c.newInstance();
	//
	//		return o;
	//
	//	}

	public void write(DataOutputStream out) throws Exception
	{

		//第一个占位用
		out.writeInt(MAGIC);
		out.writeShort(0);
		//jdk5
		out.writeShort(49);

		int clsIndex = this.registerClass(this.cls);
		int parentIndex = this.registerClass(this.parentCls);

		byte[] initMethod = getInitMethod();
		byte[] valueMethod = this.getProxyMethod();

		//constpool-size
		out.writeShort(this.constPool.size() + 1);
		writeConstPool(out);
		out.writeShort(33);//public class
		out.writeShort(clsIndex);
		out.writeShort(parentIndex);
		out.writeShort(0); //interface count;
		out.writeShort(0); //filed count;
		//写方法
		out.writeShort(2); //method count;
		out.write(initMethod);
		out.write(valueMethod);

		out.writeShort(0); //class-attribute-info

	}

	public void writeConstPool(DataOutputStream out) throws Exception
	{
		for (Object[] array : this.constPool)
		{
			int tag = (Byte) array[0];
			out.writeByte(tag);
			switch (tag)
			{
				case CONS_CLASS:
					out.writeShort((Short) array[1]);
					break;
				case CONS_UTF8:
					out.writeShort((Short) array[1]);
					byte[] content = (byte[]) array[2];
					out.write(content);
					break;
				case CONS_INTERFACE_METHODREF:
					//class & nameAndType
					out.writeShort((Short) array[1]);
					out.writeShort((Short) array[2]);
					break;
				case CONS_METHODREF:
					//class & nameAndType
					out.writeShort((Short) array[1]);
					out.writeShort((Short) array[2]);
					break;
				case CONS_NAME_AND_TYPE:
					//name & desc 
					out.writeShort((Short) array[1]);
					out.writeShort((Short) array[2]);
					break;
				default:
					throw new RuntimeException("tag=" + tag);

			}
		}
	}

	public byte[] getProxyMethod() throws Exception
	{
		ByteArrayOutputStream bs = new ByteArrayOutputStream();
		DataOutputStream out = new DataOutputStream(bs);
		out.writeShort(1); //public 
		int nameIndex = this.registerUTFString(this.valueFunction);
		out.writeShort(nameIndex);
		int descIndex = this.registerUTFString(this.valueFunctionDesc);
		out.writeShort(descIndex);
		out.writeShort(1); //attributeCount
		byte[] initCodeAttr = proxyCodeAttr();
		out.write(initCodeAttr);
		return bs.toByteArray();
	}

	public byte[] proxyCodeAttr() throws Exception
	{
		ByteArrayOutputStream bs = new ByteArrayOutputStream();
		DataOutputStream out = new DataOutputStream(bs);
		int index = this.registerUTFString("Code");
		out.writeShort(index);
		byte[] codes = proxyCodes();
		//属性长度
		int attrlen = 4 + 4 + codes.length + 4;
		out.writeInt(attrlen);
		if (this.retByteCodeType.equals("D") || this.retByteCodeType.equals("J"))
		{
			out.writeShort(2 + (this.isGeneralGet ? 1 : 0));
		}
		else
		{
			out.writeShort(1 + (this.isGeneralGet ? 1 : 0)); //stack,default 1,long or double shoud be 2.
		}

		out.writeShort(3); //local var
		out.writeInt(codes.length);
		out.write(codes); //codes;
		out.writeShort(0); //exceptions
		out.writeShort(0); //attr-info
		return bs.toByteArray();

	}

	public byte[] proxyCodes() throws Exception
	{
		ByteArrayOutputStream bs = new ByteArrayOutputStream();
		DataOutputStream out = new DataOutputStream(bs);
		out.writeByte(ALOAD_1);

		out.writeByte(this.CHECK_CAST);
		short classIndex = this.registerClass(this.targetCls);
		out.writeShort(classIndex);

		if (this.isGeneralGet)
		{
			out.writeByte(ALOAD_2);
			out.writeByte(this.CHECK_CAST);
			classIndex = this.registerClass("java/lang/String");
			out.writeShort(classIndex);

		}
		int methodIndex = 0;
		if (this.isInterface)
		{
			out.writeByte(INVOKE_INTERFACE);
			methodIndex = this.registerInterfaceMethod(this.targetCls, this.targetFunction, this.targetFunctionDesc);
			out.writeShort(methodIndex);
			out.writeByte(1);
			out.writeByte(0);
		}
		else
		{
			out.writeByte(INVOKE_VIRTUAL);
			methodIndex = registerMethod(this.targetCls, this.targetFunction, this.targetFunctionDesc);
			out.writeShort(methodIndex);
		}

		if (this.retByteCodeType.equals("I"))
		{
			out.writeByte(INVOKE_STATIC);
			methodIndex = registerMethod(this.integerClass, this.valueOfFunction, this.intValueOfFunctionDesc);
			out.writeShort(methodIndex);

		}
		else if (this.retByteCodeType.equals("S"))
		{
			out.writeByte(INVOKE_STATIC);
			methodIndex = registerMethod(this.shortClass, this.valueOfFunction, this.shortValueOfFunctionDesc);
			out.writeShort(methodIndex);
		}
		else if (this.retByteCodeType.equals("D"))
		{
			out.writeByte(INVOKE_STATIC);
			methodIndex = registerMethod(this.doubleClass, this.valueOfFunction, this.doubleValueOfFunctionDesc);
			out.writeShort(methodIndex);
		}
		else if (this.retByteCodeType.equals("F"))
		{
			out.writeByte(INVOKE_STATIC);
			methodIndex = registerMethod(this.floatClass, this.valueOfFunction, this.floatValueOfFunctionDesc);
			out.writeShort(methodIndex);
		}
		else if (this.retByteCodeType.equals("J"))
		{
			out.writeByte(INVOKE_STATIC);
			methodIndex = registerMethod(this.longClass, this.valueOfFunction, this.longValueOfFunctionDesc);
			out.writeShort(methodIndex);
		}
		else if (this.retByteCodeType.equals("Z"))
		{
			out.writeByte(INVOKE_STATIC);
			methodIndex = registerMethod(this.booleanClass, this.valueOfFunction, this.booleanValueOfFunctionDesc);
			out.writeShort(methodIndex);
		}
		else if (this.retByteCodeType.equals("B"))
		{
			out.writeByte(INVOKE_STATIC);
			methodIndex = registerMethod(this.byteClass, this.valueOfFunction, this.byteValueOfFunctionDesc);
			out.writeShort(methodIndex);
		}

		out.writeByte(ARETURN - 256);
		return bs.toByteArray();

	}

	public byte[] getInitMethod() throws Exception
	{
		ByteArrayOutputStream bs = new ByteArrayOutputStream();
		DataOutputStream out = new DataOutputStream(bs);
		out.writeShort(1); //public 
		int nameIndex = this.registerUTFString("<init>");
		out.writeShort(nameIndex);
		int descIndex = this.registerUTFString("()V");
		out.writeShort(descIndex);
		out.writeShort(1); //attributeCount
		byte[] initCodeAttr = initCodeAttr();
		out.write(initCodeAttr);
		return bs.toByteArray();

	}

	public byte[] initCodeAttr() throws Exception
	{
		ByteArrayOutputStream bs = new ByteArrayOutputStream();
		DataOutputStream out = new DataOutputStream(bs);
		int index = this.registerUTFString("Code");
		out.writeShort(index);
		byte[] codes = initCodes();
		//属性长度
		int attrlen = 4 + 4 + codes.length + 4;
		out.writeInt(attrlen);
		out.writeShort(1); //stack
		out.writeShort(1); //local var
		out.writeInt(codes.length);
		out.write(codes); //codes;
		out.writeShort(0); //exceptions
		out.writeShort(0); //attr-info
		return bs.toByteArray();

	}

	public byte[] initCodes() throws Exception
	{
		ByteArrayOutputStream bs = new ByteArrayOutputStream();
		DataOutputStream out = new DataOutputStream(bs);
		out.writeByte(ALOAD_0);
		out.writeByte(INVOKE_SPECIAL);
		int index = registerMethod(this.parentCls, "<init>", "()V");
		out.writeShort(index);
		out.writeByte(RETURN - 256);
		return bs.toByteArray();

	}

	public short registerClass(String clsName)
	{
		Short index = classMap.get(clsName);
		if (index != null)
			return index;
		short clsNameIndex = registerUTFString(clsName);
		Object[] array = new Object[]
		{ this.CONS_CLASS, clsNameIndex };
		this.constPool.add(array);
		index = getCurrentIndex();
		classMap.put(clsName, index);
		return index;
	}

	public short registerMethod(String clsName, String method, String desc)
	{

		short clsNameIndex = this.registerClass(clsName);
		short nameAndTypeIndex = registerNameAndType(method, desc);

		Object[] array = new Object[]
		{ this.CONS_METHODREF, clsNameIndex, nameAndTypeIndex };
		this.constPool.add(array);
		return getCurrentIndex();
	}

	public short registerInterfaceMethod(String clsName, String method, String desc)
	{

		short clsNameIndex = this.registerClass(clsName);
		short nameAndTypeIndex = registerNameAndType(method, desc);

		Object[] array = new Object[]
		{ this.CONS_INTERFACE_METHODREF, clsNameIndex, nameAndTypeIndex };
		this.constPool.add(array);
		return getCurrentIndex();
	}

	public short registerNameAndType(String method, String desc)
	{
		short nameIndex = registerUTFString(method);
		short descIndex = registerUTFString(desc);
		Object[] array = new Object[]
		{ this.CONS_NAME_AND_TYPE, nameIndex, descIndex };
		this.constPool.add(array);
		return getCurrentIndex();
	}

	public short registerUTFString(String str)
	{
		Short index = this.utfMap.get(str);
		if (index != null)
			return index;
		try
		{
			byte[] bs = str.getBytes("UTF-8");
			short len = (short) bs.length;
			Object[] array = new Object[]
			{ CONS_UTF8, len, bs };
			this.constPool.add(array);
			index = getCurrentIndex();
			this.utfMap.put(str, index);
			return index;
		}
		catch (UnsupportedEncodingException e)
		{
			//not happen
			throw new RuntimeException(e);
		}

	}

	public short getCurrentIndex()
	{
		return (short) (this.constPool.size());
	}

	private String[] getRetrunTypeDesc(Class c)
	{
		StringBuilder sb = new StringBuilder();
		String returnType = "";
		if (c.isArray())
		{
			sb.append(c.getName().replace(".", "/"));
		}
		else if (c == int.class)
		{
			sb.append("I");
			returnType = "I";
		}
		else if (c == boolean.class)
		{
			sb.append("Z");
			returnType = "Z";
		}
		else if (c == char.class)
		{
			sb.append("C");
			returnType = "C";
		}
		else if (c == short.class)
		{
			sb.append("S");
			returnType = "S";
		}
		else if (c == float.class)
		{
			sb.append("F");
			returnType = "F";
		}
		else if (c == long.class)
		{
			sb.append("J");
			returnType = "J";
		}
		else if (c == double.class)
		{
			sb.append("D");
			returnType = "D";
		}
		else if (c == byte.class)
		{
			sb.append("B");
			returnType = "B";
		}
		else
		{
			sb.append("L").append(c.getName().replace(".", "/")).append(";");
			returnType = "L";
		}
		return new String[]
		{ sb.toString(), returnType };
	}
}
