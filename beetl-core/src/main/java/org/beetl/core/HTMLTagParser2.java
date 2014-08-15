/*
 [The "BSD license"]
 Copyright (c) 2011-2014 Joel Li (李家智)
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
package org.beetl.core;

import java.util.HashMap;
import java.util.Map;

/**
 * 用于解析htmltag，转化成宏调用
 * 
 * @author joelli
 * @create 2013-6-12
 */
class HTMLTagParser2
{

	int index = 0;
	char[] cs = null;
	boolean isStart;
	String tagName = null;
	boolean isEmptyTag = false;
	Map<String, String> expMap = new HashMap<String, String>();
	Map<String, Character> quatMap = new HashMap<String, Character>();
	boolean hasVarBinding = false;
	String varBidingStr = null;
	//0开始 1 属性name 2 属性value 3 绑定 4 绑定变量 5 结束符号 99 结束
	int status = 0;
	//token 起始索引
	int ts;
	int te;

	public HTMLTagParser2(char[] cs, int index, boolean isStart)
	{
		this.cs = cs;
		this.index = index;
		this.isStart = isStart;
	}

	public void parser()
	{
		if (isStart)
		{
			parserStart();
		}
		else
		{
			parserEnd();
		}

	}

	public void parserStart()
	{
		findTagName2();
		findAttrs();
		findBindingFlag();
		findVars();
		endTag();

	}

	public void findTagName2()
	{
		stripSpace();
		StringBuilder tagSb = new StringBuilder();
		idToken();
		tagSb.append(this.subString());
		while (match(':'))
		{

			idToken();
			tagSb.append(":").append(this.subString());
		}

	}

	public boolean match(char c)
	{
		if (cs[index] == c)
		{
			movePoint(1);
			this.resetPoint();
			return true;
		}
		else
		{
			return false;
		}
	}

	protected void findAttrs()
	{
		while (findAttr())
			;
	}

	protected boolean findAttr()
	{
		this.stripSpace();
		idToken();
		String key = this.subString();
		this.resetPoint();
		this.stripSpace();
		if (match('='))
		{
			this.stripSpace();

		}

	}

	protected void findAttrValue()
	{

	}

	protected void findBindingFlag()
	{

	}

	protected void findVars()
	{

	}

	protected void endTag()
	{

	}

	protected void strToken()
	{

	}

	protected void idToken()
	{
		ts = index;

		if (ts > cs.length)
		{
			throw new RuntimeException("解析错");
		}
		char c = cs[ts];

		if (this.isID(c))
		{
			int i = 1;
			while (ts < cs.length)
			{
				c = cs[ts + i];
				i++;
				if (isID(c) || isDigit(c))
				{
					continue;
				}
				else
				{
					break;
				}

			}

			movePoint(i);

		}
		else
		{
			throw new RuntimeException("解析错");
		}

	}

	protected void stripSpace()
	{
		ts = index;
		int i = 0;
		while (ts < cs.length)
		{
			char c = cs[ts + i];
			i++;
			if (c == ' ')
			{
				continue;
			}
			else
			{
				break;
			}

		}
		movePoint(i);
		resetPoint();
	}

	protected void movePoint(int i)
	{
		te = ts + i;

	}

	protected void resetPoint()
	{
		index = te;
		ts = te;
	}

	protected String subString()
	{
		String str = new String(cs, ts, te - ts);
		resetPoint();
		return str;
	}

	protected void find(char[] cs)
	{

	}

	public void parserEnd()
	{

	}

	private boolean findTagName()
	{
		int start = index;
		boolean hasLetter = false;
		char c = 0;
		while (start < cs.length)
		{
			c = cs[start];
			start++;
			if (isStart)
			{
				if (hasLetter)
				{
					if (c == ' ')
					{
						this.tagName = new String(cs, index, start - index - 1).trim();
						index = start;
						return true;
					}
					else if (c == '>')
					{
						this.tagName = new String(cs, index, start - index - 1).trim();
						index = start;
						return false;
					}
					else if (c == '/' && cs[start] == '>')
					{
						this.tagName = new String(cs, index, start - index - 1);
						index = start + 1;
						isEmptyTag = true;
						return false;
					}
					else if (!isID(c))
					{
						throw new RuntimeException("解析出错，html tag不合法：" + new String(cs, index, start - index));
					}

				}
				else if (c != ' ')
				{
					if (!isID(c))
					{
						throw new RuntimeException("解析出错，html tag不合法：" + new String(cs, index, start - index));
					}
					hasLetter = true;
				}
			}
			else
			{
				// </@input>
				if (hasLetter && c == '>')
				{
					this.tagName = new String(cs, index, start - index - 1).trim();
					index = start;
					return false;
				}
				else if (c != ' ')
				{
					if (!isID(c))
					{
						throw new RuntimeException("解析出错，html tag不合法：" + new String(cs, index, start - index));
					}
					hasLetter = true;

				}
			}

		}
		throw new RuntimeException("ERROR");
	}

	public boolean isEmptyTag()
	{
		return this.isEmptyTag;
	}

	/**
	 * 判断是否是id joelli
	 */
	private boolean isID(char c)
	{
		if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || c == '_' || c == ':' || (c >= '0' && c <= '9'))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	private boolean isDigit(char c)
	{
		return c > '0' && c < '9';
	}

	private boolean enxt()
	{
		StringBuilder keySb = new StringBuilder();
		StringBuilder expSb = new StringBuilder();
		String key = null;
		String exp = null;
		//0 属性 1 属性值采用的双引号或者单引号 2 属性值
		int status = 0;
		char quot = '\'';

		while (index < cs.length)
		{
			char ch = cs[index];
			index++;
			switch (status)
			{
				case 0: //开始
				{
					if (ch == '>')
					{
						return false;
					}
					else if (ch == '/')
					{
						//emtyp tag
						status = 4;
						continue;
					}
					else if (ch == ';')
					{
						//标签绑定变量
						status = 5;
						continue;
					}
					else if (ch != '=')
					{
						if (ch == ' ')
						{
							continue;
						}
						else if (!isID(ch))
						{
							throw new RuntimeException("解析出错，html tag '" + this.tagName + "' 属性不合法：" + keySb.toString()
									+ ch);
						}
						keySb.append(ch);
						continue;
					}
					else
					{
						key = keySb.toString().trim();
						status = 1;
						continue;
					}

				}
				case 1:
				{
					if (ch == '\'')
					{
						quot = '\'';
						status = 2;

					}
					else if (ch == '\"')
					{
						quot = '\"';
						status = 2;
					}
					else if (ch != ' ')
					{
						throw new RuntimeException("解析出错，html tag '" + this.tagName + "' 属性不合法：" + keySb.toString());

					}
					continue;
				}
				case 2:
				{
					if (ch == quot)
					{
						if (cs[index - 1] != '\\')
						{
							// 结束
							exp = expSb.toString().trim();
							status = 3;
							continue;

						}
						else
						{
							// escape
							expSb.append(ch);
							continue;
						}
					}
					else
					{
						expSb.append(ch);
						continue;
					}
				}

				case 3:
				{
					this.expMap.put(key, exp);
					quatMap.put(key, Character.valueOf(quot));
					// 继续往前，如果碰到了'>'或者'/>'者表示结束，如果碰到其他分空字符，则是下一个属性
					if (ch == '>')
					{
						return false;
					}
					else if (ch == '/' && cs[index] == '>')
					{
						this.isEmptyTag = true;
						index = index + 1;
						return false;

					}
					else
					{
						index--;
						return true;
					}

				}
				case 4:
				{
					if (ch == ' ')
					{
						continue;
					}
					else if (ch == '>')
					{
						this.isEmptyTag = true;
						return false;
					}
					else
					{
						throw new RuntimeException("解析出错，html tag '" + this.tagName + "' 错误的结尾");

					}

				}
				case 5:
				{
					if (ch == '>')
					{
						hasVarBinding = true;
						this.varBidingStr = keySb.toString().trim();
						return false;
					}
					else if (ch == '/' && cs[index] == '>')
					{
						this.isEmptyTag = true;
						index++;
						hasVarBinding = true;
						this.varBidingStr = keySb.toString().trim();
						return false;

					}
					else
					{
						keySb.append(ch);
					}
				}

			}
		}
		throw new RuntimeException("解析出错，html tag '" + this.tagName + "' 属性不合法");

	}

	public int getIndex()
	{
		return index;
	}

	public String getTagName()
	{
		return tagName;
	}

	public Map<String, String> getExpMap()
	{
		return expMap;
	}

	public Map<String, Character> getQuatMap()
	{
		return this.quatMap;
	}

	public void setExpMap(Map<String, String> expMap)
	{
		this.expMap = expMap;
	}

	public static void main(String[] args)
	{
		String input = "<#a k='1'; c>fff</#a>";
		HTMLTagParser2 htmltag = new HTMLTagParser2(input.toCharArray(), 2, true);
		htmltag.parser();
		System.out.println(htmltag.getTagName());
		System.out.println(htmltag.getExpMap());
		System.out.println(htmltag.isEmptyTag());

	}
}
