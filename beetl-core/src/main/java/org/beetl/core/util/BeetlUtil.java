package org.beetl.core.util;

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
}
