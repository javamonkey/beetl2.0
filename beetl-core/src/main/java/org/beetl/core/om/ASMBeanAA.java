package org.beetl.core.om;

/**
 * 通过字节码生成的,注意，如果属性获取不到，检测是否是否有个get(Object xxx)方法
 */
public class ASMBeanAA extends AttributeAccess {
    @Override
    public Object value(Object o, Object name) {
        throw new UnsupportedOperationException(o.getClass().getName());
    }
}
