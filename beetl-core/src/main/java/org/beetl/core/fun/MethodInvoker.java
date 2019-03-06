package org.beetl.core.fun;

import java.lang.reflect.Method;

/**
 * 传入对象，获取对象对应的属性值 {@link PojoMethodInvoker}
 * @author joelli
 *
 */
public interface MethodInvoker
{
    /**
     * @param o 传入的Pojo对象
     * @return 返回值
     */
    public Object get(Object o);

    /**
     * @return 改调用预期的返回类型
     */
    public Class getReturnType();

    public Method getMethod();

    public void set(Object ins,Object value);
}