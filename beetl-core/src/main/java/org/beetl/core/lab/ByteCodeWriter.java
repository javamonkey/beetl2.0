package org.beetl.core.lab;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ByteCodeWriter
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
	String objCls = "java/lang/Object";
	String initFunction = "<init>";
	String initFunctionDesc = "()V";
	String code = "Code";

	/**
	 * 尝试自己写bytecode代码，代替asm.jar,以缩小beetl大小
	 * @param args
	 */
	public static void main(String[] args) throws Exception
	{
		OutputStream ins = new FileOutputStream("e:/Test1.class");
		DataOutputStream out = new DataOutputStream(ins);
		new ByteCodeWriter().write(out);
		out.close();

	}

	public void write(DataOutputStream out) throws Exception
	{

		//第一个占位用
		out.writeInt(MAGIC);
		out.writeShort(0);
		//jdk5
		out.writeShort(49);

		int clsIndex = this.registerClass("org/beetl/core/lab/Test1");
		int parentIndex = this.registerClass("java/lang/Object");

		byte[] initMethod = getInitMethod();
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
		out.writeShort(1); //method count;
		out.write(initMethod);

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
		out.writeShort(0); //stack
		out.writeShort(0); //local var
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
		int index = registerMethod("java/lang/Object", "<init>", "()V");
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
