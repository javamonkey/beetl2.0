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

import java.io.IOException;

import org.beetl.core.BodyContent;
import org.beetl.core.exception.BeetlException;
import org.beetl.core.tag.Tag;

/**
 * cache标签，模板页面可以通过cache标签缓存模板内容<p>
 * <pre>  #： cache(key,timeout,refresh)
 *  模板内容
 *  #：}
 * </pre>
 * beetl将会把key值对应的模板内容放到cacheManger，下次访问时候，如果key值对应的模板内容在，就直接输出，而
 * 不需要再次解析运行模板。如果指定了timeout，则在在timeout秒内，cache都有效，之后cache无效，将再次
 * 解析运行模板<p>
 * 如果指定了refresh，则删除key值对应的模板内容，重新解析运行模板。
 * <p>
 * key值是必须的，timeout，和refresh可选。
 * @author jeolli
 * @since 2.0
 *
 */
public class CacheTag extends Tag
{
	public static CacheManager cacheManager = new SimpleCacheManager();

	@Override
	public void render()
	{

		try
		{
			String key = null;
			long refreshPeriod = 0;
			BodyContent cahcedObject = null;
			key = (String) this.args[0];
			if (this.args.length == 3)
			{
				boolean refreshNow = ((Boolean) this.args[2]).booleanValue();
				if (refreshNow)
				{
					cahcedObject = super.getBodyContent();
					cacheManager.setObject(key, cahcedObject, refreshPeriod);
					cahcedObject.fill(bw);
					return;

				}
			}

			if (this.args.length >= 2)
			{

				refreshPeriod = ((Number) this.args[1]).longValue();

			}
			else
			{
				//默认1小时刷新一次
				refreshPeriod = 60 * 60;
			}

			if (refreshPeriod < 0)
			{
				cahcedObject = super.getBodyContent();
				cacheManager.setObject(key, cahcedObject, refreshPeriod);
				cahcedObject.fill(bw);

			}
			else
			{
				cahcedObject = (BodyContent) cacheManager.getObject(key);
				if (cahcedObject == null)
				{
					cahcedObject = super.getBodyContent();
					cacheManager.setObject(key, cahcedObject, refreshPeriod);
				}
				cahcedObject.fill(this.bw);

			}

			return;
		}
		catch (IOException ex)
		{
			if (!ctx.gt.getConf().isIgnoreClientIOError())
			{
				throw new BeetlException(BeetlException.CLIENT_IO_ERROR_ERROR, "IO Error", ex);
			}

		}

	}
}
