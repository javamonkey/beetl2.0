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

import java.math.BigDecimal;

import org.beetl.core.exception.BeetlException;
import org.beetl.core.statement.ASTNode;
import org.beetl.core.statement.GrammarToken;

/**
 * 用于算数表达式，对于加法，允许null值，但其他则不允许，将抛出异常
 * 参考了webit
 * @author joelli
 *
 */
public class ALU
{

	public static final int NULL = 0;
	public static final int OBJECT = 1;
	public static final int STRING = 2;
	public static final int DOUBLE = 3;
	public static final int FLOAT = 4;
	public static final int LONG = 5;
	public static final int INTEGER = 6;
	public static final int SHORT = 7;
	public static final int CHAR = 8;
	public static final int HS = 9;
	
	public static int scale = 12 ;
	public static int round =  BigDecimal.ROUND_HALF_DOWN;

	public static int getBaseType(final Object o1, final Object o2)
	{
		if (o1 != null && o2 != null)
		{
			final Class cls1;
			final Class cls2;

			if ((cls1 = o1.getClass()) == String.class || (cls2 = o2.getClass()) == String.class)
			{
				return STRING;
			} //
			else if (cls1 == Character.class && cls2 == Character.class)
			{
				return CHAR;
			} //
			if (o1 instanceof Number && o2 instanceof Number)
			{

				if (cls1 == BigDecimal.class || cls2 == BigDecimal.class)
				{
					return HS;
				} //
				else if (cls1 == Double.class || cls2 == Double.class)
				{
					return DOUBLE;
				}//
				else if (cls1 == Float.class || cls2 == Float.class)
				{
					return FLOAT;
				} //
				else if (cls1 == Long.class || cls2 == Long.class)
				{
					return LONG;
				} //
				else if (cls1 == Integer.class || cls2 == Integer.class)
				{
					return INTEGER;
				} //
				else if (cls1 == Short.class || cls2 == Short.class)
				{
					return SHORT;
				} //

			}

			// Note: default to String
			return STRING;
		}
		return NULL;
	}

	public static int getBaseType(Class cls1, Class cls2)
	{

		if ((cls1 == String.class || (cls2 == String.class)))
		{
			return STRING;
		} //
		else if (cls1 == Character.class && cls2 == Character.class)
		{
			return CHAR;
		} //
		if (Number.class.isAssignableFrom(cls1) && Number.class.isAssignableFrom(cls2))
		{

			if (cls1 == BigDecimal.class || cls2 == BigDecimal.class)
			{
				return HS;
			} //
			else if (cls1 == Double.class || cls2 == Double.class)
			{
				return DOUBLE;
			}//
			else if (cls1 == Float.class || cls2 == Float.class)
			{
				return FLOAT;
			} //
			else if (cls1 == Long.class || cls2 == Long.class)
			{
				return LONG;
			} //
			else if (cls1 == Integer.class || cls2 == Integer.class)
			{
				return INTEGER;
			} //
			else if (cls1 == Short.class || cls2 == Short.class)
			{
				return SHORT;
			} //

		}

		return OBJECT;
	}

	public static Class getBaseTypeClass(Class cls1, Class cls2)
	{
		int type = getBaseType(cls1, cls2);
		switch (type)
		{
			case INTEGER:
				return Integer.class;
			case STRING:
				return String.class;
			case LONG:
				return Long.class;
			case DOUBLE:
				return Double.class;
			case FLOAT:
				return Float.class;
			case SHORT:
				return Short.class;
			case HS:
				return BigDecimal.class;
			default:
				return Object.class;

		}
	}

	public static int getNumberType(final Number o1)
	{
		if (o1 != null)
		{
			final Class cls;
			if ((cls = o1.getClass()) == Integer.class)
			{
				return INTEGER;
			}
			else if (cls == Long.class)
			{
				return LONG;
			}
			else if (cls == Short.class)
			{
				return SHORT;
			}
			else if (cls == Float.class)
			{
				return FLOAT;
			}
			else if (cls == Double.class)
			{
				return DOUBLE;
			}
			else if (cls == BigDecimal.class)
			{
				return HS;
			}
		}
		return NULL;
	}

	public static int getBaseType(final Object o1)
	{
		if (o1 != null)
		{
			final Class cls;
			if ((cls = o1.getClass()) == String.class)
			{
				return STRING;
			}
			else if (cls == Integer.class)
			{
				return INTEGER;
			}
			else if (cls == Long.class)
			{
				return LONG;
			}
			else if (cls == Short.class)
			{
				return SHORT;
			}
			else if (cls == Float.class)
			{
				return FLOAT;
			}
			else if (cls == Double.class)
			{
				return DOUBLE;
			}
			else if (cls == Character.class)
			{
				return CHAR;
			}
			else if (cls == BigDecimal.class)
			{
				return HS;
			}
			else
			{
				return OBJECT;
			}
		}
		return NULL;
	}

	public static Object plusOne(final Object o1, ASTNode node)
	{
		if (o1 != null)
		{
			if (o1 instanceof Number)
			{
				final Number num;
				switch (getNumberType(num = (Number) o1))
				{
					case INTEGER:
						return Integer.valueOf(num.intValue() + 1);
					case LONG:
						return Long.valueOf(num.longValue() + 1L);
					case DOUBLE:
						return Double.valueOf(num.doubleValue() + 1D);
					case FLOAT:
						return Float.valueOf(num.floatValue() + 1F);
					case SHORT:
						return Short.valueOf((short) (num.intValue() + 1));
					case HS:
						BigDecimal bd = (BigDecimal) o1;
						return bd.add(BigDecimal.ONE);

				}
			}
			else
			{

				throw numberExpectedException(o1, node);
			}
		}
		throw valueIsNullException(o1, node);
	}

	public static Object minusOne(final Object o1, ASTNode node)
	{
		if (o1 != null)
		{
			if (o1 instanceof Number)
			{
				final Number num;
				switch (getNumberType(num = (Number) o1))
				{
					case INTEGER:
						return Integer.valueOf(num.intValue() - 1);
					case LONG:
						return Long.valueOf(num.longValue() - 1l);
					case DOUBLE:
						return Double.valueOf(num.doubleValue() - 1d);
					case FLOAT:
						return Float.valueOf(num.floatValue() - 1f);
					case SHORT:
						return Short.valueOf((short) (num.intValue() - 1));
					case HS:
						BigDecimal bd = (BigDecimal) o1;
						return bd.min(BigDecimal.ONE);
				}
			}
			else
			{
				throw numberExpectedException(o1, node);
			}
		}
		throw valueIsNullException(o1, node);
	}

	// ///////////////////////////
	// +

	/**不同于js，数字类型允许一个为null，beetl中，如果数字相加，有一个是null，则抛出异常
	 * 
	 * @param o1
	 * @param o2
	 * @return
	 */
	public static Object plus(final Object o1, final Object o2, final ASTNode node1, final ASTNode node2)
	{
		if (o1 != null && o2 != null)
		{
			switch (getBaseType(o1, o2))
			{
				case STRING:

					return String.valueOf(o1).concat(String.valueOf(o2));
				case INTEGER:
					return Integer.valueOf(((Number) o1).intValue() + ((Number) o2).intValue());
				case LONG:
					return Long.valueOf(((Number) o1).longValue() + ((Number) o2).longValue());
				case DOUBLE:
					return Double.valueOf(((Number) o1).doubleValue() + ((Number) o2).doubleValue());
				case FLOAT:
					return Float.valueOf(((Number) o1).floatValue() + ((Number) o2).floatValue());
				case SHORT:
					return Short.valueOf((short) (((Number) o1).intValue() + ((Number) o2).intValue()));
				case CHAR:
					return Character.valueOf((char) (((Number) o1).intValue() + ((Number) o2).intValue()));
				case HS:
					BigDecimal b1 = getBigDecimal(o1),
					b2 = getBigDecimal(o2);
					return b1.add(b2);

				default:
					throw UnsupportedTypeException(o1, o2, node1, node2, "+");
			}
		}
		else if (o1 != null)
		{
			switch (getBaseType(o1))
			{
				case STRING:
					return o1;
				default:
				{
					throw valueIsNullException(o1, o2, node1, node2);
				}
			}
		}
		else if (o2 != null)
		{
			switch (getBaseType(o2))
			{
				case STRING:
					return o2;
				default:
				{
					throw valueIsNullException(o1, o2, node1, node2);
				}
			}
		}
		else
		{
			return o1 != null ? o1 : o2;
		}
	}

	// -

	public static Object minus(final Object o1, final Object o2, final ASTNode node1, final ASTNode node2)
	{
		if (o1 != null && o2 != null)
		{
			switch (getBaseType(o1, o2))
			{
			// case STRING:
			// return String.valueOf(o1) + String.valueOf(o2);
				case INTEGER:
					return Integer.valueOf(((Number) o1).intValue() - ((Number) o2).intValue());
				case LONG:
					return Long.valueOf(((Number) o1).longValue() - ((Number) o2).longValue());
				case DOUBLE:
					return Double.valueOf(((Number) o1).doubleValue() - ((Number) o2).doubleValue());
				case FLOAT:
					return Float.valueOf(((Number) o1).floatValue() - ((Number) o2).floatValue());
				case SHORT:
					return Short.valueOf((short) (((Number) o1).intValue() - ((Number) o2).intValue()));
				case CHAR:
					return Character.valueOf((char) (((Number) o1).intValue() - ((Number) o2).intValue()));
				case HS:
					BigDecimal b1 = getBigDecimal(o1),
					b2 = getBigDecimal(o2);
					return b1.subtract(b2);
				default:
					throw UnsupportedTypeException(o1, o2, node1, node2, "-");
			}
		}
		else
		{
			throw valueIsNullException(o1, o2, node1, node2);
		}
	}

	// 负
	public static Object negative(final Object o1, ASTNode node)
	{
		if (o1 != null)
		{
			switch (getBaseType(o1))
			{
			// case STRING:
			// return String.valueOf(o1) + String.valueOf(o2);
				case INTEGER:
					return -((Number) o1).intValue();
				case LONG:
					return -((Number) o1).longValue();
				case DOUBLE:
					return -((Number) o1).doubleValue();
				case FLOAT:
					return -((Number) o1).floatValue();
				case SHORT:
					return -((Number) o1).shortValue();
				case HS:
					BigDecimal bd = (BigDecimal) o1;
					return bd;

				default:
					throw new RuntimeException("value not a number");
			}
		}
		else
		{
			throw valueIsNullException(o1, node);
		}
	}

	// *

	public static Object mult(final Object o1, final Object o2, final ASTNode node1, final ASTNode node2)
	{
		if (o1 != null && o2 != null)
		{
			switch (getBaseType(o1, o2))
			{
			// case STRING:
			// return String.valueOf(o1) + String.valueOf(o2);
				case INTEGER:
					return Integer.valueOf(((Number) o1).intValue() * ((Number) o2).intValue());
				case LONG:
					return Long.valueOf(((Number) o1).longValue() * ((Number) o2).longValue());
				case DOUBLE:
					return Double.valueOf(((Number) o1).doubleValue() * ((Number) o2).doubleValue());
				case FLOAT:
					return Float.valueOf(((Number) o1).floatValue() * ((Number) o2).floatValue());
				case SHORT:
					return Short.valueOf((short) (((Number) o1).intValue() * ((Number) o2).intValue()));
				case HS:
					BigDecimal b1 = getBigDecimal(o1),
					b2 = getBigDecimal(o2);
					return b1.multiply(b2);
				default:
					throw UnsupportedTypeException(o1, o2, node1, node2, "*");
			}
		}
		else
		{
			throw valueIsNullException(o1, o2, node1, node2);
		}
	}

	// /
	// @todo: 对0的判断
	public static Object div(final Object o1, final Object o2, final ASTNode node1, final ASTNode node2)
	{
		if (o1 != null && o2 != null)
		{
			switch (getBaseType(o1, o2))
			{
				case INTEGER:
				case LONG:
				case DOUBLE:
				case FLOAT:
				case SHORT:
					double c = ((Number) o2).doubleValue();
					if (c == 0)
					{
						BeetlException ex = new BeetlException(BeetlException.DIV_ZERO_ERROR);
						ex.pushToken(node2.token);
						throw ex;
					}
					double a = ((Number) o1).doubleValue() / ((Number) o2).doubleValue();
					return trim(a, (Number) o1, (Number) o2);
				case HS:
					BigDecimal b1 = getBigDecimal(o1),
					b2 = getBigDecimal(o2);
					BigDecimal b= b1.divide(b2, scale, round);
					return b.stripTrailingZeros();
//					return b1.divide(b2);
				default:
					throw UnsupportedTypeException(o1, o2, node1, node2, "/");
			}
		}
		else
		{
			throw valueIsNullException(o1, o2, node1, node2);
		}
	}

	private static Number trim(double d, Number a1, Number a2)
	{

		Number n1 = null;
		Number n2 = null;

		if (a1 instanceof BigDecimal || a2 instanceof BigDecimal)
		{
			return d;
		}
		else if (n1 instanceof Double || n2 instanceof Double)
		{
			return d;
		}
		else if (n1 instanceof Float || n2 instanceof Float)
		{
			return (float) d;
		}
		else if (n1 instanceof Long || n2 instanceof Long)
		{
			if (d != (long) d)
			{
				return d;
			}
			else
			{
				return (long) d;
			}

		}
		else if (n1 instanceof Integer || n2 instanceof Integer)
		{
			if (d != (int) d)
			{
				return d;
			}
			else
			{
				return (int) d;
			}
		}
		else
		{
			if (d != (short) d)
			{
				return d;
			}
			else
			{
				return (short) d;
			}
		}
	}

	// %

	public static Object mod(final Object o1, final Object o2, final ASTNode node1, final ASTNode node2)
	{
		if (o1 != null && o2 != null)
		{
			switch (getBaseType(o1, o2))
			{
			// case STRING:
			// return String.valueOf(o1) + String.valueOf(o2);
				case INTEGER:
					return Integer.valueOf(((Number) o1).intValue() % ((Number) o2).intValue());
				case LONG:
					return Long.valueOf(((Number) o1).longValue() % ((Number) o2).longValue());
				case DOUBLE:
					return Double.valueOf(((Number) o1).doubleValue() % ((Number) o2).doubleValue());
				case FLOAT:
					return Float.valueOf(((Number) o1).floatValue() % ((Number) o2).floatValue());
				case SHORT:
					return Short.valueOf((short) (((Number) o1).intValue() % ((Number) o2).intValue()));
				case HS:
					BigDecimal b1 = getBigDecimal(o1),
					b2 = getBigDecimal(o2);
					return b1.divide(b2);
				default:
					throw UnsupportedTypeException(o1, o2, node1, node2, "%");
			}
		}
		else
		{
			throw valueIsNullException(o1, o2, node1, node2);
		}
	}

	public static boolean equals(final Object o1, final Object o2)
	{
		if (o1 == o2)
		{
			return true;
		}
		if (o1 == null || o2 == null)
		{
			return false;
		}
		if (o1.equals(o2))
		{
			return true;
		}
		if (o1 instanceof Number && o2 instanceof Number)
		{
			switch (getBaseType(o1, o2))
			{
			// case STRING:
			// case CHAR:

				case SHORT:
				case INTEGER:
					return ((Number) o1).intValue() == ((Number) o2).intValue();
				case LONG:
					return ((Number) o1).longValue() == ((Number) o2).longValue();
				case DOUBLE:
					return ((Number) o1).doubleValue() == ((Number) o2).doubleValue();
				case FLOAT:
					return ((Number) o1).floatValue() == ((Number) o2).floatValue();

				case HS:
					BigDecimal b1 = getBigDecimal(o1),
					b2 = getBigDecimal(o2);
					return b1.compareTo(b2)==0;
			}
		}
		else if (o1 instanceof Enum)
		{
			return (o1.toString()).equals(o2);
		}
		else if (o2 instanceof Enum)
		{
			return (o2.toString()).equals(o1);
		}

		return false;
	}

	// !=

	public static boolean notEquals(final Object o1, final Object o2)
	{
		return !equals(o1, o2);
	}

	// >
	public static boolean greater(final Object o1, final Object o2, final ASTNode node1, final ASTNode node2)
	{
		if (o1 != null && o2 != null)
		{
			switch (getBaseType(o1, o2))
			{
			// case STRING:
				case CHAR:
					return (o1 instanceof Number ? ((Number) o1).intValue() : (int) ((Character) o1).charValue()) > (o2 instanceof Number ? ((Number) o2)
							.intValue() : (int) ((Character) o2).charValue());

				case SHORT:
				case INTEGER:
					return ((Number) o1).intValue() > ((Number) o2).intValue();
				case LONG:
					return ((Number) o1).longValue() > ((Number) o2).longValue();
				case DOUBLE:
					return ((Number) o1).doubleValue() > ((Number) o2).doubleValue();
				case FLOAT:
					return ((Number) o1).floatValue() > ((Number) o2).floatValue();
				case HS:
					BigDecimal b1 = getBigDecimal(o1),
					b2 = getBigDecimal(o2);
					return b1.compareTo(b2) > 0;
				default:
					int result = compareObject(o1, o2, node1, node2, ">");
					if (result == -2)
						throw UnsupportedTypeException(o1, o2, node1, node2, ">");
					else
						return result > 0;
			}
		}
		else
		{
			throw valueIsNullException(o1, o2, node1, node2);
		}
	}

	// >=

	public static boolean greaterEquals(final Object o1, final Object o2, final ASTNode node1, final ASTNode node2)
	{
		if (o1 != null && o2 != null)
		{
			switch (getBaseType(o1, o2))
			{
			// case STRING:
				case CHAR:
					return (o1 instanceof Number ? ((Number) o1).intValue() : (int) ((Character) o1).charValue()) >= (o2 instanceof Number ? ((Number) o2)
							.intValue() : (int) ((Character) o2).charValue());

				case SHORT:
				case INTEGER:
					return ((Number) o1).intValue() >= ((Number) o2).intValue();
				case LONG:
					return ((Number) o1).longValue() >= ((Number) o2).longValue();
				case DOUBLE:
					return ((Number) o1).doubleValue() >= ((Number) o2).doubleValue();
				case FLOAT:
					return ((Number) o1).floatValue() >= ((Number) o2).floatValue();
				case HS:
					BigDecimal b1 = getBigDecimal(o1),
					b2 = getBigDecimal(o2);
					return b1.compareTo(b2) >= 0;
				default:
					int result = compareObject(o1, o2, node1, node2, ">=");
					if (result == -2)
						throw UnsupportedTypeException(o1, o2, node1, node2, ">=");
					else
						return result >= 0;
			}
		}
		else
		{
			throw valueIsNullException(o1, o2, node1, node2);
		}
	}

	// <

	public static boolean less(final Object o1, final Object o2, final ASTNode node1, final ASTNode node2)
	{
		if (o1 != null && o2 != null)
		{
			switch (getBaseType(o1, o2))
			{
			// case STRING:
				case CHAR:
					return (o1 instanceof Number ? ((Number) o1).intValue() : (int) ((Character) o1).charValue()) < (o2 instanceof Number ? ((Number) o2)
							.intValue() : (int) ((Character) o2).charValue());

				case SHORT:
				case INTEGER:
					return ((Number) o1).intValue() < ((Number) o2).intValue();
				case LONG:
					return ((Number) o1).longValue() < ((Number) o2).longValue();
				case DOUBLE:
					return ((Number) o1).doubleValue() < ((Number) o2).doubleValue();
				case FLOAT:
					return ((Number) o1).floatValue() < ((Number) o2).floatValue();
				case HS:
					BigDecimal b1 = getBigDecimal(o1),
					b2 = getBigDecimal(o2);
					return b1.compareTo(b2) < 0;
				default:
					int result = compareObject(o1, o2, node1, node2, "<");
					if (result == -2)
						throw UnsupportedTypeException(o1, o2, node1, node2, "<");
					else
						return result < 0;
			}
		}
		else
		{
			throw valueIsNullException(o1, o2, node1, node2);
		}
	}

	// <=

	public static boolean lessEquals(final Object o1, final Object o2, final ASTNode node1, final ASTNode node2)
	{
		if (o1 != null && o2 != null)
		{
			switch (getBaseType(o1, o2))
			{
			// case STRING:
				case CHAR:
					return (o1 instanceof Number ? ((Number) o1).intValue() : (int) ((Character) o1).charValue()) <= (o2 instanceof Number ? ((Number) o2)
							.intValue() : (int) ((Character) o2).charValue());

				case SHORT:
				case INTEGER:
					return ((Number) o1).intValue() <= ((Number) o2).intValue();
				case LONG:
					return ((Number) o1).longValue() <= ((Number) o2).longValue();
				case DOUBLE:
					return ((Number) o1).doubleValue() <= ((Number) o2).doubleValue();
				case FLOAT:
					return ((Number) o1).floatValue() <= ((Number) o2).floatValue();
				case HS:
					BigDecimal b1 = getBigDecimal(o1),
					b2 = getBigDecimal(o2);
					return b1.compareTo(b2) <= 0;
				default:
					int result = compareObject(o1, o2, node1, node2, "<=");
					if (result == -2)
						throw UnsupportedTypeException(o1, o2, node1, node2, "<=");
					else
						return result <= 0;
			}
		}
		else
		{
			throw valueIsNullException(o1, o2, node1, node2);
		}
	}

	// *******************

	private static int compareObject(Object a, Object b, final ASTNode node1, final ASTNode node2, String type)
	{
		if (a instanceof Comparable && b instanceof Comparable)
		{
			Comparable ac = (Comparable) a;
			try
			{
				int result = ac.compareTo(b);
				if (result > 0)
					return 1;
				else if (result < 0)
					return -1;
				return result;
			}

			catch (RuntimeException e)
			{
				BeetlException ex = new BeetlException(BeetlException.EXPRESSION_NOT_COMPATIBLE, e);
				GrammarToken token = GrammarToken.createToken(node1.token.text + " " + node2.token.text,
						node1.token.line);
				ex.pushToken(token);
				throw ex;
			}

		}
		else
		{
			return -2;
		}
	}

	private static RuntimeException UnsupportedTypeException(final Object o1, final Object o2, final ASTNode node1,
			final ASTNode node2, String type)
	{
		BeetlException ex = new BeetlException(BeetlException.EXPRESSION_NOT_COMPATIBLE, o1.getClass() + type
				+ o2.getClass());
		GrammarToken token = GrammarToken.createToken(node1.token.text + type + node2.token.text, node1.token.line);
		ex.pushToken(token);
		throw ex;
	}

	private static RuntimeException numberExpectedException(final Object o1, ASTNode node1)
	{
		BeetlException ex = new BeetlException(BeetlException.NUMBER_EXPECTED_ERROR);
		ex.pushToken(node1.token);

		throw ex;
	}

	private static RuntimeException valueIsNullException(final Object o1, ASTNode node1)
	{
		BeetlException ex = new BeetlException(BeetlException.NULL);
		ex.pushToken(node1.token);
		throw ex;
	}

	private static BeetlException valueIsNullException(final Object o1, final Object o2, final ASTNode node1,
			final ASTNode node2)
	{
		BeetlException ex = null;
		if (o1 == null)
		{
			ex = new BeetlException(BeetlException.NULL);
			ex.pushToken(node1.token);
		}
		else
		{
			ex = new BeetlException(BeetlException.NULL);
			ex.pushToken(node2.token);
		}
		throw ex;

	}

	private static BigDecimal getBigDecimal(Object o)
	{
		if (o instanceof BigDecimal)
		{
			return (BigDecimal) o;
		}
		else
		{
			return new BigDecimal(o.toString());
		}
	}

	/** 
	 * @param o
	 * @param node
	 * @return
	 */
	public static Boolean isTrue(final Object o, ASTNode node)
	{

		if (o == null)
		{
			BeetlException be = new BeetlException(BeetlException.NULL);
			be.pushToken(node.token);
			throw be;
		}

		if (Boolean.TRUE == o)
		{
			return Boolean.TRUE;
		}
		else if (Boolean.FALSE == o)
		{
			return Boolean.FALSE;
		}
		else if (o instanceof Boolean)
		{
			return ((Boolean) o);
		}
		else
		{
			BeetlException ex = new BeetlException(BeetlException.BOOLEAN_EXPECTED_ERROR, o.getClass().toString());
			ex.pushToken(node.token);
			throw ex;
		}
	}
}
