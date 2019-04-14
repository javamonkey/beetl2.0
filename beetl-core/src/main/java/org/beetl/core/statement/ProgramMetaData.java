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
package org.beetl.core.statement;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.beetl.core.Context;
import org.beetl.core.exception.BeetlException;

/**
 * 脚本的描述
 * @author joelli
 *
 */
public class ProgramMetaData implements java.io.Serializable {

	/**
	 * 模板的换行符
	 */
	public String lineSeparator = null;

	/**
	 * 模板的语句
	 */
	public Statement[] statements = null;

	/**
	 * 模板静态数据
	 */
	public Object[] staticTextArray = null;

	/**
	 * 所有变量存放在数组中，数组长度为varIndexSize
	 */
	public int varIndexSize = 0;

	/**
	 *  临时变量存放的起始索引
	 */
	public int tempVarStartIndex = 0;

	public boolean hasGoto = false;

	/**
	 * 为全局变量在数组里分配的位置
	 */
	public Map<String, Integer> globalIndexMap = new HashMap<String, Integer>();

	/**
	 * 全局变量属性，未用到
	 */
	public Map<String, String[]> globalVarAttr = new HashMap<String, String[]>();




	public Map<String, AjaxStatement> ajaxs = null;

	// 是否存在tagFunction,且嵌套
	public boolean hasTagNest = false;

	/**
	 * 模板里的顶级变量映射关系
	 */
	protected Map<String, Integer> templateRootScopeIndexMap = new HashMap<String, Integer>();

	/**
	 * 模板每次渲染前，初始化ctx,如分配变量空间
	 * @param ctx
	 */
	public void initContext(Context ctx) {
		// 模板静态文本部分
		ctx.staticTextArray = staticTextArray;
		// 模板各种缓存存放地

		// 临时标量所在空间
		ctx.tempVarStartIndex = tempVarStartIndex;
		// 分配变量空间,最后一个为模板的返回值
		ctx.vars = new Object[varIndexSize + 1];
		ctx.vars[varIndexSize] = Context.NOT_EXIST_OBJECT;

		// 将全局变量放到数组
		putGlobaToArray(ctx);

	}

	/**
	 * 将模板全局变量转为数组
	 * 
	 * @param ctx
	 */
	protected void putGlobaToArray(Context ctx) {
		Map<String, Object> globalVar = ctx.globalVar;
		if (globalVar == null) {
			for (int i = 0; i < this.tempVarStartIndex; i++) {
				ctx.vars[i] = Context.NOT_EXIST_OBJECT;
			}
			return;
		}

		for (Entry<String, Integer> entry : globalIndexMap.entrySet()) {
			String key = entry.getKey();
			int index = entry.getValue();
			if (globalVar.containsKey(key)) {
				ctx.vars[index] = globalVar.get(key);
			} else {
				// 不存在
				ctx.vars[index] = Context.NOT_EXIST_OBJECT;
			}
		}
	}



	/** 获取模板顶级临时变量的在变量素组里的索引
	 * @return
	 */
	public Map<String, Integer> getTemplateRootScopeIndexMap() {
		return templateRootScopeIndexMap;
	}

	/** 设置模板顶级临时变量的在变量素组里的索引,顶级变量将作为脚本运行需要保存的变量
	 * @param templateRootScopeIndexMap
	 */
	public void setTemplateRootScopeIndexMap(Map<String, Integer> templateRootScopeIndexMap) {
		this.templateRootScopeIndexMap = templateRootScopeIndexMap;
	}

	public AjaxStatement getAjax(String anchor) {

		if (ajaxs == null) {
			BeetlException be = new BeetlException(BeetlException.AJAX_NOT_FOUND, "该模板文件没有发现任何ajax锚点");
			be.pushToken(new GrammarToken(anchor, 0, 0));
			throw be;
		}
		return ajaxs.get(anchor);
	}

}
