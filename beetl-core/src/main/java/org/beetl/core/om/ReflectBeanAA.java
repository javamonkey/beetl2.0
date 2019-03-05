package org.beetl.core.om;

/**
 * 通过反射获取bean属性，注意，如果属性获取不到，检测是否是否有个get(Object xxx)方法
 */
public class ReflectBeanAA extends AttributeAccess {
    @Override
    public Object value(Object o, Object name) {
        throw new UnsupportedOperationException(o.getClass().getName());
    }
}
