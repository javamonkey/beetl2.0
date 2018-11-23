package org.beetl.ext.fn;

import java.util.Set;

import org.beetl.core.Configuration;
import org.beetl.core.Context;
import org.beetl.core.Function;

/**
 *  输出模板引擎配置信息，定界符信息，全局变量和当前调用栈
 * @author xiandafu
 *
 */
public class EnvFunction implements Function {

	@Override
	public String call(Object[] paras, Context ctx) {
		StringBuilder sb = new StringBuilder();
		sb.append("resource:" + ctx.getResourceId());
		Set<String> vars = ctx.globalVar.keySet();
		String cr = vars.contains("$page") ? "<br/>" : "\n";
		sb.append(cr);
		sb.append("global:" + ctx.globalVar.keySet());
		// 判断是否是html渲染输出，通常html集成都包含$page

		sb.append(cr);
		Configuration cf = ctx.gt.getConf();
		sb.append("engine:" + cf.getEngine());
		sb.append(cr);
		sb.append("delimeter :").append(cf.getPlaceholderStart()).append(cf.getPlaceholderEnd()).append(" , ")
				.append(cf.getStatementStart()).append(" ").append(getEnd(cf.getStatementEnd()));
		if (cf.getPlaceholderStart2() != null) {
			sb.append(cr);
			sb.append("delimeter 2:").append(cf.getPlaceholderStart2()).append(cf.getPlaceholderEnd2()).append(" , ")
					.append(cf.getStatementStart2()).append(" ").append(getEnd(cf.getStatementEnd2()));
		}


		return sb.toString();

	}

	private String getEnd(String end) {
		if (end == null || end.trim().length() == 0) {
			return "换行";
		}
		return end;
	}

}
