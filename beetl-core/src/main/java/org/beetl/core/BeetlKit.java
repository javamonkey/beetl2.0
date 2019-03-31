package org.beetl.core;

import java.io.IOException;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

import org.beetl.core.exception.BeetlException;
import org.beetl.core.exception.ErrorInfo;
import org.beetl.core.resource.StringTemplateResourceLoader;

/**
 *  一个综合展示Beetl功能代码
 * * @author
 * 
 * 
 */
public class BeetlKit {

	/**
	 * BeetlKit 默认使用的GroupTemplate，用户可以设置新的
	 */
	public static GroupTemplate gt = null;
	static {
		StringTemplateResourceLoader resourceLoader = new StringTemplateResourceLoader();
		Configuration cfg;
		try {
			cfg = Configuration.defaultConfiguration();

		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		gt = new GroupTemplate(resourceLoader, cfg);
		gt.setErrorHandler(new ReThrowConsoleErrorHandler());
		
	}

	private static Map<String,Object> emptyMap =  new HashMap<String, Object>();

	/* 模板部分 */

	/** 渲染模板
	 * @param template
	 * @param paras
	 * @return 模板返回值
	 */
	public static String render(String template, Map<String, Object> paras) {
		Template t = gt.getTemplate(template);
		t.binding(paras);
		return t.render();
	}

	/** 渲染模板
	 * @param template
	 * @param writer
	 * @param paras
	 */
	public static void renderTo(String template, Writer writer, Map<String, Object> paras) {
		Template t = gt.getTemplate(template);
		t.binding(paras);
		t.renderTo(writer);
	}

	/* 脚本部分 */
	
	/**
	 * 
	 * @param script
	 * @param paras 返回map，包含的"return" 是返回值，其他均为顶级变量
	 * @return
	 * @throws ScriptEvalError
	 */
	public static Map execute(String script, Map<String, Object> paras)  throws BeetlException{
		 return gt.runScript(script, emptyMap);
	}

	

	/** 执行脚本，和参数，返回脚本里的Root scope的变量
	 * @param script
	 * @return
	 * @throws ScriptEvalError 
	 */
	public static Map execute(String script) throws BeetlException {
		return gt.runScript(script, new HashMap<String, Object>());

	}

	

	/**
	 * @param template
	 *            模板内容
	 * @param initValue
	 *            模板初始化值
	 * @return 模板渲染结果
	 * @throws ScriptEvalError 
	 */
	public static String testTemplate(String template, String initValue) throws BeetlException {
		Map map = execute(initValue);
		String result = render(template, map);
		return result;
	}

	public static void main(String[] args) throws BeetlException {
		BeetlKit.gt.getConf().setStatementStart("@");
		BeetlKit.gt.getConf().setStatementEnd(null);
		String json = "var a=".concat("[1,2,c+1 ]").concat(";");
		Map map;
		try {
			map = BeetlKit.execute(json);
		} catch (BeetlException e) {
			ErrorInfo  info = new ErrorInfo(e);
			System.out.println(info.toString());
		}

	}
}
