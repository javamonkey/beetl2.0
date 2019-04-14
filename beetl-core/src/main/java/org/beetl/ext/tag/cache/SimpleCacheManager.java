/*
 [The "BSD license"]
 Copyright (c) 2011-2013  闲大赋 (李家智)
 All rights reserved.

 Redistribution and use in source and binary forms, with or without
 modification, are permitted provided that the following conditions
 are met:
 1. Redistributions of source code must retain the above copyright
     notice, this list of conditions and the following disclaimer.
 2. Redistributions in binary form must reproduce the above copyright
     notice, this list of conditions and the following disclaimer in the
     documentation and/or other materials provided with the distribution.
 3. The name of the author may not be used to endorse or promote products
     derived from this software without specific prior written permission.

 THIS SOFTWARE IS PROVIDED BY THE AUTHOR ``AS IS'' AND ANY EXPRESS OR
 IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES
 OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED.
 IN NO EVENT SHALL THE AUTHOR BE LIABLE FOR ANY DIRECT, INDIRECT,
 INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT
 NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
 DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY
 THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF
 THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package org.beetl.ext.tag.cache;

import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 简单实现
 * @author jeolli
 *
 */
public class SimpleCacheManager implements CacheManager
{

	
	protected ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
	protected Map<String, CachedEntry> map = new HashMap<String, CachedEntry>();

	public Object getObject(String key)
	{
		lock.readLock().lock();
		try
		{
			CachedEntry entry = map.get(key);
			if (entry != null)
			{
				if (entry.disableTime < System.currentTimeMillis())
				{
					//过期了,不删除，等待调用set方法
					return null;
				}
				else
				{
					Object o = entry.sr.get();
					return o;
				}
			}
			else
			{
				return null;
			}
		}
		finally
		{
			lock.readLock().unlock();
		}
		// TODO Auto-generated method stub

	}

	public void setObject(String key, Object value, long period)
	{
		lock.writeLock().lock();
		try
		{
			CachedEntry entry = new CachedEntry();
			entry.sr = new SoftReference(value);
			if (period == 0)
			{
				entry.disableTime = Long.MAX_VALUE;
			}
			else
			{
				entry.disableTime = System.currentTimeMillis() + period * 1000;
			}

			map.put(key, entry);

		}
		finally
		{
			lock.writeLock().unlock();
		}

	}

	static class CachedEntry
	{
		public SoftReference sr;
		public long disableTime;
	}

	public boolean isDisable(String key)
	{
		lock.readLock().lock();
		try
		{
			CachedEntry entry = map.get(key);
			if (entry != null&&entry.sr.get()!=null)
			{
				if (entry.disableTime < System.currentTimeMillis())
				{
					return true;
				}
				else
				{
					return false;
				}
			}
			else
			{
				return true;
			}
		}
		finally
		{
			lock.readLock().unlock();
		}
	}

	public void clearAll()
	{
		lock.writeLock().lock();
		try
		{
			map.clear();
		}
		finally
		{
			lock.writeLock().unlock();
		}

	}

	public void clearAll(String... keys)
	{
		lock.writeLock().lock();
		try
		{
			for (String key : keys)
			{
				map.remove(key);
			}
		}
		finally
		{
			lock.writeLock().unlock();
		}

	}

	public void clearAll(String key)
	{
		lock.writeLock().lock();
		try
		{
			map.remove(key);
		}
		finally
		{
			lock.writeLock().unlock();
		}

	}

}
