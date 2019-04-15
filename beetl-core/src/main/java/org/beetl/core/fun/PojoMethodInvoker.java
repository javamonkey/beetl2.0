package org.beetl.core.fun;

import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.beetl.core.exception.BeetlException;

/**
 * 传入对象，获取对象对应的属性值
 * @author joelli
 *
 */
public class PojoMethodInvoker implements MethodInvoker
{

    PropertyDescriptor pd  = null;

    /**
     * @param m 目标调用方法，应该是一个无参数的get方法
     */
    public PojoMethodInvoker(PropertyDescriptor pd)
    {
        this.pd = pd;
        pd.getReadMethod().setAccessible(true);

    }

    @Override
    public Object get(Object obj)
    {
        try
        {

        	return pd.getReadMethod().invoke(obj, null);
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
        return pd.getPropertyType();
    }

    @Override
    public Method getMethod() {
        return pd.getReadMethod();
    }

    @Override
    public void set(Object ins, Object value) {


        try {
            pd.getWriteMethod().invoke(ins, value);
        } catch (IllegalAccessException e) {
            throw new BeetlException(BeetlException.ATTRIBUTE_INVALID, "无法访问", e);
        } catch (IllegalArgumentException e) {
            throw new BeetlException(BeetlException.ATTRIBUTE_INVALID, "错误参数", e);
        } catch (InvocationTargetException e) {
            Throwable target = e.getTargetException();
            if (target instanceof BeetlException)
            {
                throw (BeetlException) target;
            }
            throw new BeetlException(BeetlException.ATTRIBUTE_INVALID, "属性访问异常", e.getTargetException());
        }
    }


}