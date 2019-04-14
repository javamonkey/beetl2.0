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

/**
 *  cache标签的接口，默认使用SimpleCacheManager，用户可以实现自定义的CacheManager
 *  并调用CacheTag.cacheManager = yourCacheManager来实现
 *    
 * @author joelli
 *
 */
public interface CacheManager
{
	/**
	 * 获取key值对应的对象
	 * @param key
	 * @return
	 */
	public Object getObject(String key);

	/**
	 * @param key
	 * @param value
	 * @param period 多少秒后过期
	 */
	public void setObject(String key, Object value, long period);

	/**
	 * 查看key值对应的对象是否存在
	 * @param key
	 * @return
	 */
	public boolean isDisable(String key);

	/**
	 * 清除cache
	 */
	public void clearAll();

	/**
	 * 删除key对应的对象
	 * @param key
	 */
	public void clearAll(String key);

	/**
	 * 删除keys对应的所有缓存对象
	 * @param keys
	 */
	public void clearAll(String... keys);

}
