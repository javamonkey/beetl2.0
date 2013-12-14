package org.beetl.core.statement;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.beetl.core.Context;

public class ProgramMetaData {
	public Statement[] statements = null;

	// 节点辅助访问器，通过替换来获取更好的性能
	public Object[] nodesEval = null;
	// 二元表达式,性能不理想，待定

	// 模板静态数据
	public String[] staticTextArray = null;

	// 所有变量存放在数组中，数组长度为varIndexSize
	public int varIndexSize = 0;
	public int tempVarStartIndex = 0;
	// 为全局变量在数组里分配的位置
	public Map<String, Integer> globalIndexMap = new HashMap<String, Integer>();
	// 全局变量属性
	public Map<String, String[]> globalVarAttr = new HashMap<String, String[]>();

	public void initContext(Context ctx) {
		// 模板静态文本部分
		ctx.staticTextArray = staticTextArray;
		// 模板各种缓存存放地

		// 临时标量所在空间
		ctx.tempVarStartIndex = tempVarStartIndex;
		// 分配变量空间
		ctx.vars = new Object[varIndexSize];
		// 将全局变量放到数组
		putGlobaToArray(ctx);
	}

	/**
	 * 将模板全局变量转为数组
	 * 
	 * @param map
	 */
	protected void putGlobaToArray(Context ctx) {
		Map<String, Object> globalVar = ctx.globalVar;
		for (Entry<String, Integer> entry : globalIndexMap.entrySet()) {
			String key = entry.getKey();
			int index = entry.getValue();
			if (globalVar.containsKey(key)) {
				ctx.vars[index] = globalVar.get(key);
			} else {
				// 不存在
				ctx.vars[index] = ctx.NOT_EXIST_OBJECT;
			}
		}
	}

}
