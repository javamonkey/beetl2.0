package org.beetl.core.nativecall.obj;

public abstract class Request
{
	public abstract int getData();

	public static Request getRequest()
	{
		return new SubRequest();
	}

	private static class SubRequest extends Request
	{

		@Override
		public int getData()
		{
			// TODO Auto-generated method stub
			return 1;
		}

	}
}
