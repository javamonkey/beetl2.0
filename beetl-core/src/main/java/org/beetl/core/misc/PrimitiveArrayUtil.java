package org.beetl.core.misc;

public class PrimitiveArrayUtil
{
	public static int getSize(Object o)
	{
		if (o == int[].class)
		{
			return ((int[]) o).length;
		}
		else if (o == long[].class)
		{
			return ((long[]) o).length;
		}
		else if (o == short[].class)
		{
			return ((short[]) o).length;
		}
		else if (o == double[].class)
		{
			return ((double[]) o).length;
		}
		else if (o == float[].class)
		{
			return ((float[]) o).length;
		}
		else if (o == char[].class)
		{
			return ((char[]) o).length;
		}
		else if (o == byte[].class)
		{
			return ((byte[]) o).length;
		}
		else if (o == boolean[].class)
		{
			return ((boolean[]) o).length;
		}
		else
		{
			throw new RuntimeException("不支持数组");
		}
	}

	public static Object getObject(Object o, int index)
	{
		if (o == int[].class)
		{
			return ((int[]) o)[index];
		}
		else if (o == long[].class)
		{
			return ((long[]) o)[index];
		}
		else if (o == short[].class)
		{
			return ((short[]) o)[index];
		}
		else if (o == double[].class)
		{
			return ((double[]) o)[index];
		}
		else if (o == float[].class)
		{
			return ((float[]) o)[index];
		}
		else if (o == char[].class)
		{
			return ((char[]) o)[index];
		}
		else if (o == byte[].class)
		{
			return ((byte[]) o)[index];
		}
		else if (o == boolean[].class)
		{
			return ((boolean[]) o)[index];
		}
		else
		{
			throw new RuntimeException("不支持数组");
		}
	}
}
