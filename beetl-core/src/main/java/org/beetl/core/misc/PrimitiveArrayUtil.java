package org.beetl.core.misc;

public class PrimitiveArrayUtil
{
	public static int getSize(Object o)
	{
		Class type = o.getClass();
		if (type == int[].class)
		{
			return ((int[]) o).length;
		}
		else if (type == long[].class)
		{
			return ((long[]) o).length;
		}
		else if (type == short[].class)
		{
			return ((short[]) o).length;
		}
		else if (type == double[].class)
		{
			return ((double[]) o).length;
		}
		else if (type == float[].class)
		{
			return ((float[]) o).length;
		}
		else if (type == char[].class)
		{
			return ((char[]) o).length;
		}
		else if (type == byte[].class)
		{
			return ((byte[]) o).length;
		}
		else if (type == boolean[].class)
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
		Class type = o.getClass();
		if (type == int[].class)
		{
			return ((int[]) o)[index];
		}
		else if (type == long[].class)
		{
			return ((long[]) o)[index];
		}
		else if (type == short[].class)
		{
			return ((short[]) o)[index];
		}
		else if (type == double[].class)
		{
			return ((double[]) o)[index];
		}
		else if (type == float[].class)
		{
			return ((float[]) o)[index];
		}
		else if (type == char[].class)
		{
			return ((char[]) o)[index];
		}
		else if (type == byte[].class)
		{
			return ((byte[]) o)[index];
		}
		else if (type == boolean[].class)
		{
			return ((boolean[]) o)[index];
		}
		else
		{
			throw new RuntimeException("不支持数组");
		}
	}
}
