package org.beetl.core.om;

import java.util.List;
import java.util.Map;

import org.beetl.core.exception.BeetlException;
import org.beetl.core.fun.MethodInvoker;
import org.beetl.core.fun.ObjectUtil;
import org.beetl.core.misc.PrimitiveArrayUtil;

public class ObjectSetterUtil {

	protected static void set(Object o, Object key, Object value) {

		if (o instanceof Map) {
			((Map) o).put(key, value);
		} else if (o instanceof List) {
			try {
				((List) o).set(((Number) key).intValue(), value);
			} catch (IndexOutOfBoundsException ex) {
				BeetlException be = new BeetlException(BeetlException.ATTRIBUTE_INVALID, ex);
				throw be;
			} catch (ClassCastException ex) {
				throw new ClassCastException("目标位为java.util.List,无法设置属性:" + key);
			}

		} else if (o.getClass().isArray()) {
			try {
				if (o.getClass().getComponentType().isPrimitive()) {
					PrimitiveArrayUtil.setObject(o, (((Number) key).intValue()), value);
				} else {
					((Object[]) o)[(((Number) key).intValue())] = value;
				}

			} catch (ClassCastException ex) {
				throw new ClassCastException("类型为数组,无此属性:" + key);
			}

		}

		else {

			Class c = o.getClass();
			MethodInvoker invoker = ObjectUtil.getInvokder(c, (String) key);
			if (invoker != null) {

				invoker.set(o, value);
			} else {
				BeetlException ex = new BeetlException(BeetlException.ATTRIBUTE_NOT_FOUND, (String) key);
				throw ex;
			}

		}
	}

}

