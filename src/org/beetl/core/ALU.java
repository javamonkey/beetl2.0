package org.beetl.core;

import java.math.BigDecimal;

public class ALU {

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

	public static int getBaseType(final Object o1, final Object o2) {
		if (o1 != null && o2 != null) {
			final Class cls1;
			final Class cls2;

			if ((cls1 = o1.getClass()) == String.class
					|| (cls2 = o2.getClass()) == String.class) {
				return STRING;
			} //
			else if (cls1 == Character.class && cls2 == Character.class) {
				return CHAR;
			} //
			if (o1 instanceof Number && o2 instanceof Number) {

				if (cls1 == BigDecimal.class || cls2 == BigDecimal.class) {
					return HS;
				} //
				else if (cls1 == Double.class || cls2 == Double.class) {
					return DOUBLE;
				}//
				else if (cls1 == Float.class || cls2 == Float.class) {
					return FLOAT;
				} //
				else if (cls1 == Long.class || cls2 == Long.class) {
					return LONG;
				} //
				else if (cls1 == Integer.class || cls2 == Integer.class) {
					return INTEGER;
				} //
				else if (cls1 == Short.class || cls2 == Short.class) {
					return SHORT;
				} //

			}

			// Note: default to String
			return STRING;
		}
		return NULL;
	}

	public static int getBaseType(Class cls1, Class cls2) {
		if ((cls1 == String.class || (cls2 == String.class))) {
			return STRING;
		} //
		else if (cls1 == Character.class && cls2 == Character.class) {
			return CHAR;
		} //
		if (Number.class.isAssignableFrom(cls1)
				&& Number.class.isAssignableFrom(cls2)) {

			if (cls1 == BigDecimal.class || cls2 == BigDecimal.class) {
				return HS;
			} //
			else if (cls1 == Double.class || cls2 == Double.class) {
				return DOUBLE;
			}//
			else if (cls1 == Float.class || cls2 == Float.class) {
				return FLOAT;
			} //
			else if (cls1 == Long.class || cls2 == Long.class) {
				return LONG;
			} //
			else if (cls1 == Integer.class || cls2 == Integer.class) {
				return INTEGER;
			} //
			else if (cls1 == Short.class || cls2 == Short.class) {
				return SHORT;
			} //

		}

		return OBJECT;
	}

	public static Class getBaseTypeClass(Class cls1, Class cls2) {
		int type = getBaseType(cls1, cls2);
		switch (type) {
		case INTEGER:
			return Integer.class;
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

	public static int getNumberType(final Number o1) {
		if (o1 != null) {
			final Class cls;
			if ((cls = o1.getClass()) == Integer.class) {
				return INTEGER;
			} else if (cls == Long.class) {
				return LONG;
			} else if (cls == Short.class) {
				return SHORT;
			} else if (cls == Float.class) {
				return FLOAT;
			} else if (cls == Double.class) {
				return DOUBLE;
			} else if (cls == BigDecimal.class) {
				return HS;
			}
		}
		return NULL;
	}

	public static int getBaseType(final Object o1) {
		if (o1 != null) {
			final Class cls;
			if ((cls = o1.getClass()) == String.class) {
				return STRING;
			} else if (cls == Integer.class) {
				return INTEGER;
			} else if (cls == Long.class) {
				return LONG;
			} else if (cls == Short.class) {
				return SHORT;
			} else if (cls == Float.class) {
				return FLOAT;
			} else if (cls == Double.class) {
				return DOUBLE;
			} else if (cls == Character.class) {
				return CHAR;
			} else if (cls == BigDecimal.class) {
				return HS;
			} else {
				return OBJECT;
			}
		}
		return NULL;
	}

	// +1
	public static Object plusOne(final Object o1) {
		if (o1 != null) {
			if (o1 instanceof Number) {
				final Number num;
				switch (getNumberType(num = (Number) o1)) {
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
			} else {
				throw new RuntimeException("value not a number");
			}
		}
		throw ValueIsNullException(o1);
	}

	// -1

	public static Object minusOne(final Object o1) {
		if (o1 != null) {
			if (o1 instanceof Number) {
				final Number num;
				switch (getNumberType(num = (Number) o1)) {
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
			} else {
				throw new RuntimeException("value not a number");
			}
		}
		throw ValueIsNullException(o1);
	}

	// ///////////////////////////
	// +

	public static Object plus(final Object o1, final Object o2) {
		if (o1 != null && o2 != null) {
			switch (getBaseType(o1, o2)) {
			case STRING:

				return String.valueOf(o1).concat(String.valueOf(o2));
			case INTEGER:
				return Integer.valueOf(((Number) o1).intValue()
						+ ((Number) o2).intValue());
			case LONG:
				return Long.valueOf(((Number) o1).longValue()
						+ ((Number) o2).longValue());
			case DOUBLE:
				return Double.valueOf(((Number) o1).doubleValue()
						+ ((Number) o2).doubleValue());
			case FLOAT:
				return Float.valueOf(((Number) o1).floatValue()
						+ ((Number) o2).floatValue());
			case SHORT:
				return Short
						.valueOf((short) (((Number) o1).intValue() + ((Number) o2)
								.intValue()));
			case CHAR:
				return Character
						.valueOf((char) (((Number) o1).intValue() + ((Number) o2)
								.intValue()));
			case HS:
				BigDecimal b1 = getBigDecimal(o1),
				b2 = getBigDecimal(o2);
				return b1.add(b2);

			default:
				throw UnsupportedTypeException(o1, o2);
			}
		} else {
			return o1 != null ? o1 : o2;
		}
	}

	// -

	public static Object minus(final Object o1, final Object o2) {
		if (o1 != null && o2 != null) {
			switch (getBaseType(o1, o2)) {
			// case STRING:
			// return String.valueOf(o1) + String.valueOf(o2);
			case INTEGER:
				return Integer.valueOf(((Number) o1).intValue()
						- ((Number) o2).intValue());
			case LONG:
				return Long.valueOf(((Number) o1).longValue()
						- ((Number) o2).longValue());
			case DOUBLE:
				return Double.valueOf(((Number) o1).doubleValue()
						- ((Number) o2).doubleValue());
			case FLOAT:
				return Float.valueOf(((Number) o1).floatValue()
						- ((Number) o2).floatValue());
			case SHORT:
				return Short
						.valueOf((short) (((Number) o1).intValue() - ((Number) o2)
								.intValue()));
			case CHAR:
				return Character
						.valueOf((char) (((Number) o1).intValue() - ((Number) o2)
								.intValue()));
			case HS:
				BigDecimal b1 = getBigDecimal(o1),
				b2 = getBigDecimal(o2);
				return b1.subtract(b2);
			default:
				throw UnsupportedTypeException(o1, o2);
			}
		} else {
			throw ValueIsNullException(o1, o2);
		}
	}

	// 负
	public static Object negative(final Object o1) {
		if (o1 != null) {
			switch (getBaseType(o1)) {
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
				return bd.negate();

			default:
				throw new RuntimeException("value not a number");
			}
		} else {
			throw ValueIsNullException(o1);
		}
	}

	// *

	public static Object mult(final Object o1, final Object o2) {
		if (o1 != null && o2 != null) {
			switch (getBaseType(o1, o2)) {
			// case STRING:
			// return String.valueOf(o1) + String.valueOf(o2);
			case INTEGER:
				return Integer.valueOf(((Number) o1).intValue()
						* ((Number) o2).intValue());
			case LONG:
				return Long.valueOf(((Number) o1).longValue()
						* ((Number) o2).longValue());
			case DOUBLE:
				return Double.valueOf(((Number) o1).doubleValue()
						* ((Number) o2).doubleValue());
			case FLOAT:
				return Float.valueOf(((Number) o1).floatValue()
						* ((Number) o2).floatValue());
			case SHORT:
				return Short
						.valueOf((short) (((Number) o1).intValue() * ((Number) o2)
								.intValue()));
			case HS:
				BigDecimal b1 = getBigDecimal(o1),
				b2 = getBigDecimal(o2);
				return b1.multiply(b2);
			default:
				throw UnsupportedTypeException(o1, o2);
			}
		} else {
			throw ValueIsNullException(o1, o2);
		}
	}

	// /
	// @todo: 对0的判断
	public static Object div(final Object o1, final Object o2) {
		if (o1 != null && o2 != null) {
			switch (getBaseType(o1, o2)) {
			case INTEGER:

				return Integer.valueOf(((Number) o1).intValue()
						/ ((Number) o2).intValue());
			case LONG:
				return Long.valueOf(((Number) o1).longValue()
						/ ((Number) o2).longValue());
			case DOUBLE:
				return Double.valueOf(((Number) o1).doubleValue()
						/ ((Number) o2).doubleValue());
			case FLOAT:
				return Float.valueOf(((Number) o1).floatValue()
						/ ((Number) o2).floatValue());
			case SHORT:
				return Short
						.valueOf((short) (((Number) o1).intValue() / ((Number) o2)
								.intValue()));
			case HS:
				BigDecimal b1 = getBigDecimal(o1),
				b2 = getBigDecimal(o2);
				return b1.divide(b2);
			default:
				throw UnsupportedTypeException(o1, o2);
			}
		} else {
			throw ValueIsNullException(o1, o2);
		}
	}

	// %

	public static Object mod(final Object o1, final Object o2) {
		if (o1 != null && o2 != null) {
			switch (getBaseType(o1, o2)) {
			// case STRING:
			// return String.valueOf(o1) + String.valueOf(o2);
			case INTEGER:
				return Integer.valueOf(((Number) o1).intValue()
						% ((Number) o2).intValue());
			case LONG:
				return Long.valueOf(((Number) o1).longValue()
						% ((Number) o2).longValue());
			case DOUBLE:
				return Double.valueOf(((Number) o1).doubleValue()
						% ((Number) o2).doubleValue());
			case FLOAT:
				return Float.valueOf(((Number) o1).floatValue()
						% ((Number) o2).floatValue());
			case SHORT:
				return Short
						.valueOf((short) (((Number) o1).intValue() % ((Number) o2)
								.intValue()));
			case HS:
				BigDecimal b1 = getBigDecimal(o1),
				b2 = getBigDecimal(o2);
				return b1.divide(b2);
			default:
				throw UnsupportedTypeException(o1, o2);
			}
		} else {
			throw ValueIsNullException(o1, o2);
		}
	}

	// /////////////////////////

	// ///////////////
	// &&
	public static Object and(final Object o1, final Object o2) {
		return isTrue(o1) ? o2 : o1;
	}

	// ||
	public static Object or(final Object o1, final Object o2) {
		return isTrue(o1) ? o1 : o2;
	}

	// !
	public static boolean not(final Object o1) {
		return !isTrue(o1);
	}

	// ==
	public static boolean equals(final Object o1, final Object o2) {
		if (o1 == o2) {
			return true;
		}
		if (o1 == null || o2 == null) {
			return false;
		}
		if (o1.equals(o2)) {
			return true;
		}
		if (o1 instanceof Number && o2 instanceof Number) {
			switch (getBaseType(o1, o2)) {
			// case STRING:
			// case CHAR:

			case SHORT:
			case INTEGER:
				return ((Number) o1).intValue() == ((Number) o2).intValue();
			case LONG:
				return ((Number) o1).longValue() == ((Number) o2).longValue();
			case DOUBLE:
				return ((Number) o1).doubleValue() == ((Number) o2)
						.doubleValue();
			case FLOAT:
				return ((Number) o1).floatValue() == ((Number) o2).floatValue();

			case HS:
				BigDecimal b1 = getBigDecimal(o1),
				b2 = getBigDecimal(o2);
				return b1.equals(b2);
			}
		}

		return false;
	}

	// !=

	public static boolean notEquals(final Object o1, final Object o2) {
		return !equals(o1, o2);
	}

	// >
	public static boolean greater(final Object o1, final Object o2) {
		if (o1 != null && o2 != null) {
			switch (getBaseType(o1, o2)) {
			// case STRING:
			case CHAR:
				return (o1 instanceof Number ? ((Number) o1).intValue()
						: (int) ((Character) o1).charValue()) > (o2 instanceof Number ? ((Number) o2)
						.intValue() : (int) ((Character) o2).charValue());

			case SHORT:
			case INTEGER:
				return ((Number) o1).intValue() > ((Number) o2).intValue();
			case LONG:
				return ((Number) o1).longValue() > ((Number) o2).longValue();
			case DOUBLE:
				return ((Number) o1).doubleValue() > ((Number) o2)
						.doubleValue();
			case FLOAT:
				return ((Number) o1).floatValue() > ((Number) o2).floatValue();
			case HS:
				BigDecimal b1 = getBigDecimal(o1),
				b2 = getBigDecimal(o2);
				return b1.compareTo(b2) > 0;
			default:
				throw UnsupportedTypeException(o1, o2);
			}
		} else {
			throw ValueIsNullException(o1, o2);
		}
	}

	// >=

	public static boolean greaterEquals(final Object o1, final Object o2) {
		if (o1 != null && o2 != null) {
			switch (getBaseType(o1, o2)) {
			// case STRING:
			case CHAR:
				return (o1 instanceof Number ? ((Number) o1).intValue()
						: (int) ((Character) o1).charValue()) >= (o2 instanceof Number ? ((Number) o2)
						.intValue() : (int) ((Character) o2).charValue());

			case SHORT:
			case INTEGER:
				return ((Number) o1).intValue() >= ((Number) o2).intValue();
			case LONG:
				return ((Number) o1).longValue() >= ((Number) o2).longValue();
			case DOUBLE:
				return ((Number) o1).doubleValue() >= ((Number) o2)
						.doubleValue();
			case FLOAT:
				return ((Number) o1).floatValue() >= ((Number) o2).floatValue();
			case HS:
				BigDecimal b1 = getBigDecimal(o1),
				b2 = getBigDecimal(o2);
				return b1.compareTo(b2) >= 0;
			default:
				throw UnsupportedTypeException(o1, o2);
			}
		} else {
			throw ValueIsNullException(o1, o2);
		}
	}

	// <

	public static boolean less(final Object o1, final Object o2) {
		if (o1 != null && o2 != null) {
			switch (getBaseType(o1, o2)) {
			// case STRING:
			case CHAR:
				return (o1 instanceof Number ? ((Number) o1).intValue()
						: (int) ((Character) o1).charValue()) < (o2 instanceof Number ? ((Number) o2)
						.intValue() : (int) ((Character) o2).charValue());

			case SHORT:
			case INTEGER:
				return ((Number) o1).intValue() < ((Number) o2).intValue();
			case LONG:
				return ((Number) o1).longValue() < ((Number) o2).longValue();
			case DOUBLE:
				return ((Number) o1).doubleValue() < ((Number) o2)
						.doubleValue();
			case FLOAT:
				return ((Number) o1).floatValue() < ((Number) o2).floatValue();
			case HS:
				BigDecimal b1 = getBigDecimal(o1),
				b2 = getBigDecimal(o2);
				return b1.compareTo(b2) < 0;
			default:
				throw UnsupportedTypeException(o1, o2);
			}
		} else {
			throw ValueIsNullException(o1, o2);
		}
	}

	// <=

	public static boolean lessEquals(final Object o1, final Object o2) {
		if (o1 != null && o2 != null) {
			switch (getBaseType(o1, o2)) {
			// case STRING:
			case CHAR:
				return (o1 instanceof Number ? ((Number) o1).intValue()
						: (int) ((Character) o1).charValue()) <= (o2 instanceof Number ? ((Number) o2)
						.intValue() : (int) ((Character) o2).charValue());

			case SHORT:
			case INTEGER:
				return ((Number) o1).intValue() <= ((Number) o2).intValue();
			case LONG:
				return ((Number) o1).longValue() <= ((Number) o2).longValue();
			case DOUBLE:
				return ((Number) o1).doubleValue() <= ((Number) o2)
						.doubleValue();
			case FLOAT:
				return ((Number) o1).floatValue() <= ((Number) o2).floatValue();
			case HS:
				BigDecimal b1 = getBigDecimal(o1),
				b2 = getBigDecimal(o2);
				return b1.compareTo(b2) <= 0;
			default:
				throw UnsupportedTypeException(o1, o2);
			}
		} else {
			throw ValueIsNullException(o1, o2);
		}
	}

	// *******************

	private static RuntimeException UnsupportedTypeException(final Object o1,
			final Object o2) {
		throw new RuntimeException("error");
	}

	private static RuntimeException ValueIsNullException(final Object o1) {
		return new RuntimeException("value is null");
	}

	private static RuntimeException ValueIsNullException(final Object o1,
			final Object o2) {
		if (o1 == null) {
			if (o2 == null) {
				return new RuntimeException("left & right values are null");
			} else {
				return new RuntimeException("left value is null");
			}
		} else if (o2 == null) {
			return new RuntimeException("right value is null");
		} else {
			return new RuntimeException("left & right values are not null");
		}
	}

	private static BigDecimal getBigDecimal(Object o) {
		if (o instanceof BigDecimal) {
			return (BigDecimal) o;
		} else {
			return new BigDecimal(o.toString());
		}
	}

	public static boolean isTrue(final Object o) {
		if (Boolean.TRUE == o) {
			return true;
		} else if (Boolean.FALSE == o || o == null) {
			return false;
		} else if (o instanceof Boolean) {
			return ((Boolean) o).booleanValue();
		} else {
			throw new RuntimeException("error");
		}
	}
}
