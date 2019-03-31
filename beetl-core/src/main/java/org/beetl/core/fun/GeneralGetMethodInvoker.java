package org.beetl.core.fun;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.beetl.core.exception.BeetlException;

public class GeneralGetMethodInvoker implements MethodInvoker
{
    Method method;
    String name;

    public GeneralGetMethodInvoker(Method m, String name)
    {
        this.method = m;
        this.method.setAccessible(true);
        this.name = name;
    }

    @Override
    public Object get(Object o)
    {
        try
        {
            return method.invoke(o, name);
        }
        catch (IllegalArgumentException e)
        {
            throw new BeetlException(BeetlException.ATTRIBUTE_INVALID, "错误参数", e);

        }
        catch (IllegalAccessException e)
        {
            throw new BeetlException(BeetlException.ATTRIBUTE_INVALID, "无法访问", e);

        }
        catch (InvocationTargetException e)
        {
            Throwable target = e.getTargetException();
            if (target instanceof BeetlException)
            {
                throw (BeetlException) target;
            }
            throw new BeetlException(BeetlException.ATTRIBUTE_INVALID, "属性访问异常", e.getTargetException());
        }
    }

    @Override
    public Class getReturnType()
    {
        return method.getReturnType();
    }

    @Override
    public Method getMethod() {
        return method;
    }

    @Override
    public void set(Object ins, Object value) {
    	
        throw new RuntimeException("Genneral get 不支持");

    }
}