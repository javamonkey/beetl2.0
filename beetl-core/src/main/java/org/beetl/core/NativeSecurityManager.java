package org.beetl.core;


/**
 * 判断是否允许调用本地方法
 * @author joelli
 *
 */
public interface NativeSecurityManager
{
	public boolean permit(String resourceId, Class c, Object target, String method);
}
