package org.beetl.core.statement;

import java.lang.reflect.Method;
import java.util.Collection;
import java.util.Map;

import org.beetl.core.IteratorStatus;
import org.beetl.core.exception.TempException;
import org.beetl.core.util.ObjectUtil;

/**
 * 表达式类型
 * 
 * @author joelli
 * 
 */
public class Type implements java.io.Serializable {
	public Class cls;
	public Type[] types = null;
	public static final Type ObjectType = new Type(Object.class);
	public static final Class[] StringPara = new Class[] { String.class };
	public static final Class[] GetMethodPara = new Class[] {};

	public Type() {

	}

	public Type(Class cls) {
		this.cls = cls;

	}

	public Type(Class cls, Class c1) {
		this.cls = cls;
		types = new Type[] { new Type(c1) };

	}

	public Type(Class cls, Class c1, Class c2) {
		this.cls = cls;
		types = new Type[] { new Type(c1), new Type(c2) };

	}

	public Type(Class cls, Type type) {
		this.cls = cls;
		types = new Type[] { type };

	}

	public Type getType(String attrName) {
		if (Map.class.isAssignableFrom(cls)) {
			if (types != null) {
				return types[1];
			} else {

			}
			return ObjectType;
		} else if (Collection.class.isAssignableFrom(cls)) {
			if (types != null) {
				return types[0];
			} else {
				return ObjectType;
			}

		} else if (cls == IteratorStatus.class) {
			return types[0];
		} else if (cls == Object.class) {
			return new Type(Object.class);
		} else {

			Method m = null;
			try {
				m = cls.getMethod(ObjectUtil.getMethod(attrName), GetMethodPara);
				Class returnCls = m.getReturnType();
				return new Type(returnCls);
			} catch (NoSuchMethodException e1) {

			} catch (SecurityException e1) {

			}

			try {
				m = cls.getMethod("get", StringPara);
				Class returnCls = m.getReturnType();
				return new Type(returnCls);
			} catch (NoSuchMethodException e) {

			} catch (SecurityException e) {

			}

			throw new TempException(cls + " 无" + attrName + "方法");

		}
	}

	public String toString() {
		StringBuilder sb = new StringBuilder(this.cls.toString());
		if (types != null) {
			sb.append("<");
			for (Type t : this.types) {
				sb.append(t).append(",");
			}
			sb.setLength(sb.length() - 1);
			sb.append(">");
		}
		return sb.toString();

	}
}
