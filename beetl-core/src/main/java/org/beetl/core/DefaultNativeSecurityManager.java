package org.beetl.core;


public class DefaultNativeSecurityManager implements NativeSecurityManager
{

	@Override
	public boolean permit(String resourceId, Class c, Object target, String method)
	{
		String name = c.getSimpleName();
		String pkg = c.getPackage().getName();
		if (pkg.startsWith("java.lang"))
		{
			if (name.equals("Runtime") || name.equals("Process") || name.equals("ProcessBuilder")
					|| name.equals("System"))
			{
				return false;
			}
		}

		return true;
	}

}
