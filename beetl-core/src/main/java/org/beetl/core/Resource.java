package org.beetl.core;

import java.io.IOException;
import java.io.Reader;

public abstract class Resource
{

	protected ResourceLoader resourceLoader = null;
	protected String id = null;

	public Resource(String id, ResourceLoader loader)
	{
		this.id = id;
		this.resourceLoader = loader;
	}

	/**
	 * 打开Reader
	 * 
	 * @return
	 */
	public abstract Reader openReader();

	/**
	 * 检测资源是否改变
	 * 
	 * @return
	 */
	public abstract boolean isModified();

	/**
	 * 得到Resource对应的ResourceLoader
	 * 
	 * @return
	 */
	public ResourceLoader getResourceLoader()
	{
		return this.resourceLoader;
	}

	public void setResourceLoader(ResourceLoader resourceLoader)
	{
		this.resourceLoader = resourceLoader;
	}

	public String getId()
	{
		return this.id;
	}

	/**
	 * 得到Resource指定行数的内容，用于调试，报错等显示原有模板信息,如果获取不了 返回NUll
	 * 
	 * @param startLine
	 * @param endLine
	 * @return
	 */
	public String getContent(int start, int end) throws IOException
	{

		Reader br = openReader();

		int line = 1;
		int ch;
		boolean hasStart = false;

		StringBuilder sb = new StringBuilder(1024);

		while ((ch = br.read()) != -1)
		{
			if (line == start)
			{
				hasStart = true;
			}

			if (hasStart)
			{
				sb.append((char) ch);
			}

			if (ch == '\r' || ch == '\n')
			{
				line++;
				char temp = (char) ch;
				ch = br.read();
				if (ch != -1)
				{
					if (temp == '\r' && ch == '\n')
					{

						sb.append((char) ch);
					}
					else if (temp == '\n' && ch == '\r')
					{

						sb.append((char) ch);
					}
					else
					{
						if (line != end)
						{
							sb.append((char) ch);
						}
					}

					//检测是否到指定行数了

					if (line == end)
					{
						break;
					}

				}
				else
				{
					//文档末尾
					break;
				}
			}

		}

		return sb.toString();

	}
}
