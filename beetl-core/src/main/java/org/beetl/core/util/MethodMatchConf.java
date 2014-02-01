package org.beetl.core.util;

import java.lang.reflect.Method;
import java.math.BigDecimal;

public class MethodMatchConf
{
	public Method method;
	//如何转化
	public int[] convert;
	// 是否需要转化
	public boolean isNeedConvert;
	//todo,取消
	public boolean isExactMatch = true;
	public final static int INT_CONVERT = 1;
	public final static int LONG_CONVERT = 2;
	public final static int DOUBLE_CONVERT = 3;
	public final static int FLOAT_CONVERT = 4;
	public final static int SHORT_CONVERT = 5;
	public final static int BIGDECIMAL_CONVERT = 6;

	public final static int NO_CONVERT = 0;

	public String toString()
	{
		String str = method.toString() + ",";
		for (int i : convert)
		{
			str = str + i + ",";
		}
		return str;
	}

	public Object invoke(Object o, Object[] parameter)
	{
		return null;
	}

	public String getOutputType(int i)
	{
		switch (convert[i])
		{

			case INT_CONVERT:
			{
				return ".intValue()";
			}
			case LONG_CONVERT:
			{
				return ".longValue()";
			}
			case DOUBLE_CONVERT:
			{
				return ".doubleValue()";
			}
			case FLOAT_CONVERT:
			{
				return ".floatValue()";
			}
			case SHORT_CONVERT:
			{
				return ".shortValue()";
			}

			case BIGDECIMAL_CONVERT:
			{
				return ".getBigDecimal()";
			}
			default:
			{
				throw new RuntimeException("not support converty type " + i);
			}

		}
	}

	public Object convert(Object o, int i)
	{
		switch (convert[i])
		{
			case NO_CONVERT:
			{
				return o;
			}
			case INT_CONVERT:
			{
				return ((Number) o).intValue();
			}
			case LONG_CONVERT:
			{
				return ((Number) o).longValue();
			}
			case DOUBLE_CONVERT:
			{
				return ((Number) o).doubleValue();
			}
			case FLOAT_CONVERT:
			{
				return ((Number) o).floatValue();
			}
			case SHORT_CONVERT:
			{
				return ((Number) o).shortValue();
			}

			case BIGDECIMAL_CONVERT:
			{
				return new BigDecimal(o.toString());
			}
			default:
			{
				throw new RuntimeException("not support converty type " + i);
			}

		}
	}

}