package org.beetl.core;

/**
 * 虚拟属性，通过class注册，这样可以渲染输出而不需要的增加新模型
 * 如user.gender user.~genderDisplayName
 * @author joelli
 * @since 2.0
 *
 */
public interface VirtualClassAttribute
{
	public Object eval(Object o, String attributeName, Context ctx);

}
