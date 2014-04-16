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
package org.beetl.core.misc;

import java.io.File;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;

import org.beetl.core.ByteWriter;
import org.beetl.core.io.ByteWriter_Byte;
import org.beetl.core.io.ByteWriter_Char;

/**
 * Beetl使用方法
 * @author joelli
 *
 */
public class BeetlUtil
{
	/**判断一个路径是否指到外部了，比如../../test.txt就指到外部
	 * @param child
	 * @return
	 */
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

	/** 相对路径计算
	 * @param siblings 当前路径
	 * @param resourceId 相对路径
	 * @return 绝对路径
	 */
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

	public static String getWebRoot()
	{
		String path = BeetlUtil.class.getResource("/").getFile();
		try
		{
			String root = new File(path).getParentFile().getParentFile().getCanonicalPath();
			return root;
		}
		catch (IOException e)
		{
			throw new RuntimeException(e);
		}

	}
}
