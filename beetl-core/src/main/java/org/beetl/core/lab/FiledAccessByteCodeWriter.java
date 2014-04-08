package org.beetl.core.lab;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.beetl.core.resolver.AttributeAccess;

public class FiledAccessByteCodeWriter
{

	static final int MAGIC = 0xCAFEBABE;
	static final byte CONS_CLASS = 7;
	static final byte CONS_UTF8 = 1;
	static final byte CONS_METHODREF = 10;
	static final byte CONS_NAME_AND_TYPE = 12;
	static final byte CONS_DOUBLE = 6;

	static final short ALOAD_0 = 42;
	static final short ALOAD_1 = 43;
	static final short ALOAD_2 = 44;
	static final short INVOKE_SPECIAL = 183;
	static final short INVOKE_VIRTUAL = 182;
	static final short RETURN = 177;
	static final short ARETURN = 176;
	final short CHECK_CAST = 192;
	final short INVOKE_STATIC = 184;

	byte[] cached = new byte[256];
	List<Object[]> constPool = new ArrayList<Object[]>();
	Map<String, Short> utfMap = new HashMap<String, Short>();
	Map<String, Short> classMap = new HashMap<String, Short>();

	String cls = "org/beetl/sample/s01/Test1";
	String parentCls = "org/beetl/core/resolver/AttributeAccess";
	String targetCls = "org/beetl/core/lab/TestUser";
	String targetFunction = "getAge";
	String targetFunctionDesc = "()I";
	String initFunction = "<init>";
	String initFunctionDesc = "()V";
	String valueFunction = "value";
	String valueFunctionDesc = "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;";
	String code = "Code";

	//其他
	String integerClass = "java/lang/Integer";
	String valueOfFunction = "valueOf";
	String intValueOfFunctionDesc = "(I)Ljava/lang/Integer;";
	ASMClassLoader loader = new ASMClassLoader();

	class ASMClassLoader extends ClassLoader
	{
		public Class defineClass(String name, byte[] b)
		{
			return defineClass(name, b, 0, b.length);
		}
	}

	/**
	 * 尝试自己写bytecode代码，代替asm.jar,以缩小beetl大小
	 * @param args
	 */
	public static void main(String[] args) throws Exception
	{
		//		OutputStream ins = new FileOutputStream("e:/Test1.class");
		//		DataOutputStream out = new DataOutputStream(ins);
		//		new FiledAccessByteCodeWriter().write(out);
		//		out.close();
		Object o = new FiledAccessByteCodeWriter().getObject();
		AttributeAccess a = (AttributeAccess) o;
		TestUser user = new TestUser("joelli");
		user.setAge(19);
		System.out.println(a.value(user, "age"));

	}

	public byte[] getClassByte() throws Exception
	{
		ByteArrayOutputStream bs = new ByteArrayOutputStream();
		DataOutputStream out = new DataOutputStream(bs);
		write(out);
		return bs.toByteArray();
	}

	public Object getObject() throws Exception
	{
		FiledAccessByteCodeWriter cw = new FiledAccessByteCodeWriter();
		byte[] bs = cw.getClassByte();
		Class c = loader.defineClass("org.beetl.sample.s01.Test1", bs);
		Object o = c.newInstance();

		return o;

	}

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
		//其他方法
		//.............

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
		out.writeShort(1); //stack
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

		out.writeByte(INVOKE_VIRTUAL);
		int methodIndex = registerMethod(this.targetCls, this.targetFunction, this.targetFunctionDesc);
		out.writeShort(methodIndex);

		out.writeByte(INVOKE_STATIC);
		methodIndex = registerMethod(this.integerClass, this.valueOfFunction, this.intValueOfFunctionDesc);
		out.writeShort(methodIndex);

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
}
