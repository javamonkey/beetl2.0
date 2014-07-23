// Copyright (c) 2013, Webit Team. All Rights Reserved.
package org.beetl.performance.lab;

/**
 * 参考webit，改良了一下
 * 
 * @author Zqq
 */
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
	public static final int BYTE = 9;

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
				if (cls1 == Double.class || cls2 == Double.class) {
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
				else if (cls1 == Byte.class || cls2 == Byte.class) {
					return BYTE;
				} //
			}

			// Note: default to String
			return STRING;
		}
		return NULL;
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
			} else if (cls == Byte.class) {
				return BYTE;
			} else {
				return OBJECT;
			}
		}
		return NULL;
	}

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
			case BYTE:
				return Byte
						.valueOf((byte) (((Number) o1).intValue() + ((Number) o2)
								.intValue()));
			default:
				throw new RuntimeException();
			}
		} else {
			return o1 != null ? o1 : o2;
		}
	}

	public static Object plus(final int type, final Object o1, final Object o2) {
		if (o1 != null && o2 != null) {
			switch (type) {
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
			case BYTE:
				return Byte
						.valueOf((byte) (((Number) o1).intValue() + ((Number) o2)
								.intValue()));
			default:
				throw new RuntimeException();
			}
		} else {
			return o1 != null ? o1 : o2;
		}
	}

	public static Object plusInteger(final Object o1, final Object o2) {
		if (o1 != null && o2 != null) {
			switch (6) {
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
			case BYTE:
				return Byte
						.valueOf((byte) (((Number) o1).intValue() + ((Number) o2)
								.intValue()));
			default:
				throw new RuntimeException();
			}
		} else {
			return o1 != null ? o1 : o2;
		}
	}
}
