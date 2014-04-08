package org.beetl.core.lab;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class ByteCodeRead
{

	int MAGIC = 0xCAFEBABE;
	byte CONS_CLASS = 7;
	byte CONS_UTF8 = 1;
	byte CONS_METHODREF = 10;
	byte CONS_NAME_AND_TYPE = 12;
	byte CONS_DOUBLE = 6;

	final short ALOAD_0 = 42;
	final short ALOAD_1 = 43;
	final short ALOAD_2 = 44;
	final short INVOKE_SPECIAL = 183;
	final short INVOKE_VIRTUAL = 182;
	final short RETURN = 177;
	final short ARETURN = 176;
	final short CHECK_CAST = 192;
	final short INVOKE_STATIC = 184;

	byte[] cached = new byte[256];
	List<Object[]> constPool = new ArrayList<Object[]>();

	/**
	 * 尝试自己写bytecode代码，代替asm.jar,以缩小beetl大小
	 * @param args
	 */
	public static void main(String[] args) throws IOException
	{
		InputStream ins = new FileInputStream("e:/Test.class");
		DataInputStream in = new DataInputStream(ins);
		new ByteCodeRead().parse(in);

	}

	public void parse(DataInputStream in) throws IOException
	{

		//第一个占位用
		constPool.add(new Object[0]);

		int magic = in.readInt();
		p(magic == MAGIC);
		int version = in.readInt();
		p(version);
		int constPoolSize = in.readShort();
		p(constPoolSize);

		for (int i = 1; i < constPoolSize; i++)
		{
			byte tag = in.readByte();
			if (tag == CONS_CLASS)
			{
				int classNameIndex = in.readShort();
				constPool.add(new Object[]
				{ tag, classNameIndex });
			}
			else if (tag == CONS_UTF8)
			{
				int len = in.readShort();
				String str = readString(in, len);
				constPool.add(new Object[]
				{ tag, len, str });
			}
			else if (tag == CONS_METHODREF)
			{
				int classIndex = in.readShort();
				int nameAndTypeIndex = in.readShort();
				constPool.add(new Object[]
				{ tag, classIndex, nameAndTypeIndex });
			}
			else if (tag == CONS_NAME_AND_TYPE)
			{
				int nameIndex = in.readShort();
				int descIndex = in.readShort();
				constPool.add(new Object[]
				{ tag, nameIndex, descIndex });
			}
			else if (tag == CONS_DOUBLE)
			{

			}
			else
			{
				System.out.println("not parsed " + tag);
			}

		}
		{
			//log
			System.out.println("=====constpool=======");
			int j = 1;
			for (Object[] array : constPool)
			{
				System.out.print(j++ + " ");
				for (Object o : array)
				{
					System.out.print(o);
					System.out.print(" ");
				}
				System.out.println();
			}
			System.out.println("============");
		}

		int accessFlag = in.readShort();
		//应该是33 ACC_PUBLIC | ACC_SUPER
		p(accessFlag);

		int classIndex = in.readShort();
		p(classIndex);

		int supperClassIndex = in.readShort();
		p(supperClassIndex);
		int interfaceCount = in.readShort();
		p(interfaceCount);
		if (interfaceCount != 0)
		{
			parseInterface(in, interfaceCount);
		}

		int filedCount = in.readShort();
		p(filedCount);
		if (filedCount != 0)
		{
			parsefiledCount(in, filedCount);
		}

		int methodCount = in.readShort();
		p(methodCount);
		if (methodCount != 0)
		{
			parseMethodCount(in, methodCount);
		}

		int attrCount = in.readShort();
		p(attrCount);
		if (attrCount != 0)
		{
			parseAttrCount(in, attrCount);
		}

	}

	public void parseAttrCount(DataInputStream in, int attrCount)
	{
		System.out.println("parse attr");
	}

	public void parseMethodCount(DataInputStream in, int methodCount) throws IOException
	{
		System.out.println("parse method");
		for (int i = 0; i < methodCount; i++)
		{

			short accessFlag = in.readShort();
			short nameIndex = in.readShort();
			short descIndex = in.readShort();
			System.out.println("====" + this.constPool.get(nameIndex)[2]);
			System.out.println(this.constPool.get(descIndex)[2]);
			System.out.println(accessFlag);
			short attrbuteCount = in.readShort();
			System.out.println(attrbuteCount);
			if (attrbuteCount != 0)
			{
				parseMethodCode(in, attrbuteCount);
			}

		}
	}

	public void parseMethodCode(DataInputStream in, int attrbuteCount) throws IOException
	{
		System.out.println("======= attr ======= ");

		for (int i = 0; i < attrbuteCount; i++)
		{
			short attrNameIndex = in.readShort();
			p(attrNameIndex);
			String attType = (String) this.constPool.get(attrNameIndex)[2];
			p(attType);
			if (attType.equals("Code"))
			{
				int attrLen = in.readInt();
				p("属性长度" + attrLen);
				short maxStack = in.readShort();
				short maxLocals = in.readShort();
				int codeLen = in.readInt();
				p(maxStack);
				p(maxLocals);
				p("代码长度：" + codeLen);
				byte[] codes = new byte[codeLen];
				in.read(codes, 0, codeLen);
				parseCode(codes);
				short exceptionsLen = in.readShort();
				if (exceptionsLen != 0)
				{
					System.out.println("解析异常");
				}

				short attrInfoLen = in.readShort();
				if (attrInfoLen != 0)
				{
					System.out.println("解析属性信息");
				}

			}
			else
			{
				System.out.println("wrong");
			}

		}
	}

	public void parseInterface(DataInputStream in, int interfaceCount)
	{
		System.out.println("parse interface");
	}

	public void parsefiledCount(DataInputStream in, int filedCount)
	{
		System.out.println("parse filed");
	}

	public void p(Object o)
	{
		System.out.println(o);
	}

	public void parseCode(byte[] bs)
	{
		ByteArrayInputStream ins = new ByteArrayInputStream(bs);
		DataInputStream in = new DataInputStream(ins);
		int index = 0;
		while (index < bs.length)
		{
			//一组一组指令解析
			byte cmd = bs[index++];
			int b = 0x0FF & cmd;
			switch (b)
			{
				case ALOAD_0:
					p("ALOAD_0");
					break;
				case ALOAD_1:
				{
					p("ALOAD_0");
					break;
				}
				case INVOKE_SPECIAL:
				{
					int b1 = bs[index++];
					int b2 = bs[index++];
					int i = b1 << 8 | b2;

					//找到常量描述 metodRef
					p("INVOKE_SPECIAL");
					parseConst(i);
					break;
				}
				case INVOKE_STATIC:
				{
					int b1 = bs[index++];
					int b2 = bs[index++];
					int i = b1 << 8 | b2;
					//找到常量描述 metodRef
					p("INVOKE_STATIC");
					parseConst(i);
					break;
				}

				case INVOKE_VIRTUAL:
				{
					int b1 = bs[index++];
					int b2 = bs[index++];
					int i = b1 << 8 | b2;
					//找到常量描述 metodRef
					p("INVOKE_VIRTUAL");
					parseConst(i);
					break;
				}

				case RETURN:
				{
					p("RETURN");
					break;
				}

				case ARETURN:
				{
					p("ARETURN");
					break;
				}
				case CHECK_CAST:
				{
					int b1 = bs[index++];
					int b2 = bs[index++];
					int i = b1 << 8 | b2;
					p("CHECK_CAST");
					parseConst(i);
					break;
				}
				default:
				{
					p("not found the code指令" + b);
				}
			}

		}

	}

	public void parseConst(int index)
	{
		Object[] array = this.constPool.get(index);
		int tag = (Byte) array[0];
		if (tag == CONS_CLASS)
		{
			int nameIndex = (Integer) array[1];
			System.out.print(readUTF8Const(nameIndex));
		}
		else if (tag == CONS_METHODREF)
		{
			int classIndex = (Integer) array[1];
			int nameAndTypeIndex = (Integer) array[2];
			parseConst(classIndex);
			System.out.print(".");
			parseConst(nameAndTypeIndex);
			System.out.println();

		}
		else if (tag == CONS_NAME_AND_TYPE)
		{
			int nameIndex = (Integer) array[1];
			int descIndex = (Integer) array[2];
			System.out.print(readUTF8Const(nameIndex));
			System.out.println(readUTF8Const(descIndex));

		}
		else
		{
			System.out.println("more const need parse");
		}

	}

	public String readUTF8Const(int index)
	{
		Object[] array = this.constPool.get(index);
		return (String) array[2];
	}

	public String readString(DataInputStream in, int len) throws IOException
	{
		if (len < cached.length)
		{
			in.read(cached, 0, len);
			return new String(cached, 0, len);
		}
		else
		{
			byte[] bs = new byte[len];
			in.read(cached, 0, len);
			return new String(bs, 0, len);
		}
	}

}
