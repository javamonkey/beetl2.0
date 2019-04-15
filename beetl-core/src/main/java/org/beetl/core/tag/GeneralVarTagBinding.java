/*
 [The "BSD license"]
 Copyright (c) 2011-2019  闲大赋 (李家智)
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
package org.beetl.core.tag;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 此类子类将可以作为html 标签使用，除了能实现bindVars来初始化绑定的变量外，允许render方法里通过调用
 * 方法bind(name,value) 来绑定变量，或者更常用的是binds(Object... array)如下是一个例子
 * <pre>
 * public class TestGeneralVarTagBinding extends GeneralVarTagBinding
{

	
	public void render()
	{
		for (int i = 0; i &lt; 5; i++)
		{
			this.bind("value", i);// or this.binds(i);
			this.doBodyRender();
		}

	}

}

  </pre>
  此例子会循环渲染标签体5次，并且每次循环都会设置value的值，如下是模板内容
  <pre>
 &lt;#tag ; value&gt;
	${value}
 &lt;/#tag&gt;
 </pre>

 */
public abstract class GeneralVarTagBinding extends Tag {
	/**
	 * 记录了变量名字应该放到Contxt.vars的哪一个位置
	 */
	private LinkedHashMap<String, Integer> name2Index = null;


	public void mapName2Index(LinkedHashMap<String, Integer> map) {
		name2Index = map;
	}

	/**按照标签变量声明的顺序绑定
	 * @param array
	 */
	protected void binds(Object... array) {
		if (name2Index == null) {
			throw new RuntimeException("html标签没有定义绑定变量,但标签实现中试图绑定" + Arrays.asList(array));
		}

		Iterator<Integer> it = name2Index.values().iterator();
		for (int i = 0; i < array.length; i++) {
			int index = it.next();
			ctx.vars[index] = array[i];
		}
	}


	public Object getAttributeValue(String attrName) {
		Map map = (Map) this.args[1];
		return map.get(attrName);

	}

	public String getHtmlTagName() {
		return (String) this.args[0];
	}

	public Map<String, Object> getAttributes() {
		return (Map<String, Object>) this.args[1];
	}

}
