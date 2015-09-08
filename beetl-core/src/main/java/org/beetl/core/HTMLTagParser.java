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

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * 用于解析htmltag，转化成宏调用
 * 
 * @author joelli
 * @create 2013-6-12
 */
class HTMLTagParser
{

	int index = 0;
	char[] cs = null;
	boolean isStart;
	String tagName = null;
	boolean isEmptyTag = false;
	Map<String, String> expMap = new LinkedHashMap<String, String>();
	Map<String, Character> quatMap = new LinkedHashMap<String, Character>();
	//支持换行，记录属性后是否有换行。
	List<String> crKey = new ArrayList<String>(1);
	boolean hasVarBinding = false;
	String varBidingStr = null;
	// -1非期望
	int status = 0;
	//token 起始索引
	int ts;
	int te;
	String lastKey = null;
	//默认是var
	String bindingAttr = null;
	static char ENT_TAG = '>';
	static char[] ENT_TAGS = new char[]
	{ '/', '>' };
//	char[] cr = new char[]	{ '\n' };
	

	public HTMLTagParser(char[] cs, int index, String bindingAttr, boolean isStart)
	{
		this.cs = cs;
		this.bindingAttr = bindingAttr;
		this.index = index;
		this.isStart = isStart;
		this.ts = index;
		this.te = index;
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
		findTagName();

		findAttrs();
		findBindingFlag();
		if (status != -1)
		{
			findVars();
		}

		endTag();

	}

	public void findTagName()
	{

		idToken();
		if (status == -1)
		{
			throw new RuntimeException("非法标签名");
		}
		StringBuilder tagSb = new StringBuilder();
		tagSb.append(this.subString());
		this.t_consume();
		while (match(':'))
		{
			this.move(1);
			idToken();
			if (status == -1)
			{
				throw new RuntimeException("非法标签名");
			}

			tagSb.append(":").append(this.subString());

			this.t_consume();
		}

		this.tagName = tagSb.toString();

	}

	public boolean match(char c)
	{
		if (cs[index] == c)
		{

			return true;
		}
		else
		{
			return false;
		}
	}
	
	protected boolean matchCR(){
		
		if(index<cs.length){
			if (cs[index ] =='\r'||cs[index ] =='\n')
				return true;
		}
		return false ;
	
	}

	public boolean match(char[] expected)
	{
		int i = 0;
		while (index + i < cs.length && i < expected.length)
		{
			if (cs[index + i] != expected[i])
				return false;
			i++;
		}
		if (i == expected.length)
			return true;
		else
			return false;
	}

	protected void findAttrs()
	{
		findAttr();
		while (status != -1)
		{
			if (match(' ') || matchCR())
			{
				findAttr();
			}

			else
			{
				return;
			}

		}
		t_recover();
		;
	}

	protected void findAttr()
	{
		boolean findCR = this.stripSpaceAndCR();
		idToken();
		if (status == -1)
		{

			return;
		}

		lastKey = this.subString();
		this.t_consume();
		this.stripSpace();
		if (match('='))
		{
			this.move(1);
			boolean isSingleQuat = strToken();
			String value = this.subString();
			this.t_consume();
			this.move(1);
			if (lastKey.equals(this.bindingAttr))
			{
				this.hasVarBinding = true;
				this.varBidingStr = value;
				return;
			}
			this.quatMap.put(lastKey, isSingleQuat ? '\'' : '\"');
			this.expMap.put(lastKey, value);
			if (findCR)
				this.crKey.add(lastKey);

		}
		else
		{
			throw new RuntimeException("没有找到属性");
		}

	}
	


	protected void findBindingFlag()
	{
		this.stripSpace();
		if (!this.match(';'))
		{
			status = -1;
			return;
		}
		this.move(1);
		this.hasVarBinding = true;
	}

	protected void findVars()
	{
		this.stripSpace();
		this.idToken();
		StringBuilder sb = new StringBuilder();
		while (status != -1)
		{
			sb.append(this.subString());
			this.t_consume();
			this.stripSpace();
			if (match(','))
			{

				this.move(1);
				this.stripSpace();
				this.idToken();
				sb.append(",");
			}
			else
			{

				break;
			}

		}
		this.t_consume();
		if (sb.length() != 0)
		{
			sb.setLength(sb.length());
			varBidingStr = sb.toString();
		}

	}

	protected void endTag()
	{
		this.stripSpace();
		if (match(ENT_TAG))
		{
			this.move(1);
			this.isEmptyTag = false;
		}
		else if (this.match(ENT_TAGS))
		{
			this.isEmptyTag = true;
			this.move(2);

		}
		else
		{
			char illegal = cs[index];
			if (illegal == '\r' || illegal == '\n')
			{
				throw new RuntimeException("标签未正确结束:" + this.tagName + ",碰到换行符号");

			}
			else
			{
				throw new RuntimeException("标签未正确结束:" + this.tagName + ",碰到非法符号'" + cs[index] + "'");

			}
		}
	}

	protected boolean strToken()
	{
		this.stripSpace();
		if (match('\''))
		{
			this.move(1);
			this.findOneChar('\'');

			if (status == -1)
			{
				throw new RuntimeException("错误的属性，缺少'");
			}

			return true;

		}
		else if (match('\"'))
		{
			this.move(1);
			this.findOneChar('\"');
			if (status == -1)
			{
				throw new RuntimeException("错误的属性,缺少'");
			}

			return false;
		}
		else
		{
			throw new RuntimeException("属性必须使用双引号或者单引号");
		}

	}

	protected void idToken()
	{

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

				if (isID(c) || isDigit(c))
				{
					i++;
					continue;
				}
				else
				{
					break;
				}

			}

			t_forword(i);

		}
		else
		{
			status = -1;
		}

	}

	protected boolean stripSpaceAndCR()
	{
		ts = index;
		int i = 0;
		boolean findCR = false;

		while (ts < cs.length)
		{
			char c = cs[ts + i];

			if (c == ' ' || c == '\t')
			{
				i++;
				continue;
			}
			else if (c == '\n' || c == '\r')
			{
				i++;
				findCR = true;
			}
			else
			{
				break;
			}

		}
		ts = ts + i;
		te = ts;
		index = te;
		return findCR;
	}

	protected void stripSpace()
	{
		ts = index;
		int i = 0;
		while (ts < cs.length)
		{
			char c = cs[ts + i];

			if (c == ' ' || c == '\t' || c == '\n' || c == '\r')
			{
				i++;
				continue;
			}
			else
			{
				break;
			}

		}
		ts = ts + i;
		te = ts;
		index = te;
	}

	/**前移token指针
	 * @param forward
	 */
	protected void t_forword(int forward)
	{
		te = ts + forward;

	}

	/**
	 * token指针生效
	 */
	protected void t_consume()
	{
		index = te;
		ts = te;
		status = 0;
	}

	/**
	 * token指针前移后生效
	 */
	protected void t_recover()
	{
		te = ts = index;

	}

	/** 索引前移
	 * @param i
	 */
	protected void move(int i)
	{
		index = index + i;
		ts = te = index;
		status = 0;
	}

	protected String subString()
	{
		String str = new String(cs, ts, te - ts);
		return str;
	}

	protected void findOneChar(char c)
	{
		int i = 0;
		while ((this.ts + i) < this.cs.length)
		{
			char ch = this.cs[this.ts + i];

			if (ch != c)
			{
				i++;
				if (ch == '\n' || ch == '\r')
				{
					status = -1;
					this.t_recover();
					return;
				}
			}
			else
			{
				this.t_forword(i);
				return;
			}

		}
		status = -1;
		this.t_recover();
		return;

	}

	public void parserEnd()
	{
		this.findTagName();
		if (match('>'))
		{
			move(1);

		}
		else
		{
			throw new RuntimeException(this.tagName + "结束标签格式错");
		}

	}

	/**
	 * 判断是否是id joelli
	 */
	private boolean isID(char c)
	{
		if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || c == '_')
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

	public boolean isEmptyTag()
	{
		return this.isEmptyTag;
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
		String input = "<#bbsListTag a='1' \nc='${ kk }' var='page,dd' >hello ${a}</#bbsListTag>";
		HTMLTagParser htmltag = new HTMLTagParser(input.toCharArray(), 2, "var", true);
		htmltag.parser();
		System.out.println(htmltag.getTagName());
		System.out.println(htmltag.getExpMap());
		System.out.println(htmltag.isEmptyTag());
		System.out.println(htmltag.hasVarBinding);
		System.out.println(htmltag.varBidingStr);

	}
}
