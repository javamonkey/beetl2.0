package org.beetl.core.util;

import java.io.OutputStreamWriter;
import java.io.Writer;

import org.beetl.core.ByteWriter;
import org.beetl.core.io.ByteWriter_Byte;
import org.beetl.core.io.ByteWriter_Char;

public class BeetlUtil
{
	public static boolean isOutsideOfRoot(String child)
	{
		if (child == null)
			return true;
		char[] array = child.toCharArray();
		int root = 0;
		if (array.length == 0)
			return true;
		int start = 0;
		if (array[0] == '/' || array[0] == '\\')
		{
			start = 1;
		}
		StringBuilder dir = new StringBuilder();
		for (int i = start; i < array.length; i++)
		{
			char c = array[i];

			if (c == '/' || c == '\\')
			{
				if (dir.toString().equals(".."))
				{
					root++;
					if (root == 1)
					{
						return true;
					}
				}
				else if (dir.length() == 0)
				{
					//非法的格式
					return true;
				}
				else
				{
					root--;
				}
				dir.setLength(0);
			}
			else
			{
				dir.append(c);
			}

		}
		if (root <= 0)
		{
			return false;
		}
		else
		{
			return true;
		}

	}

	public static String getRelPath(String siblings, String resourceId)
	{

		String relResourceId = null;
		if (resourceId != null && resourceId.length() != 0)
		{
			char cs = resourceId.charAt(0);
			if (!(cs == '\\' || cs == '/'))
			{
				//相对路径
				int i = siblings.length() - 1;
				for (; i > 0; i--)
				{
					char c = siblings.charAt(i);
					if (c == '\\' || c == '/')
					{
						break;
					}
				}

				String parent = siblings.substring(0, i + 1);

				relResourceId = parent.concat(resourceId);
			}
			else
			{
				relResourceId = resourceId;
			}
			if (BeetlUtil.isOutsideOfRoot(relResourceId))
			{
				throw new RuntimeException("不能访问外部文件或者模板");
			}
			return relResourceId;
		}
		else
		{
			throw new RuntimeException("资源ID为空，参数错");
		}

	}

	public static Writer getWriterByByteWriter(ByteWriter byteWriter)
	{
		Writer w = null;
		if (byteWriter instanceof ByteWriter_Char)
		{
			ByteWriter_Char bw = (ByteWriter_Char) byteWriter;
			w = bw.getW();
		}
		else
		{
			ByteWriter_Byte bw = (ByteWriter_Byte) byteWriter;
			try
			{
				w = new OutputStreamWriter(bw.getOs(), bw.getCs());
			}
			catch (Exception ex)
			{
				throw new RuntimeException(ex);
			}

		}
		return w;
	}
}
