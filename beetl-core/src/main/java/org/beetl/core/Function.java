package org.beetl.core;

/**
 * Beetl函数接口，用户可以通过实现此接口来自定一方法，譬如 实现一个将字符创转为大写的函数"str.upcase"
 * <p>
 * 
 * <pre>
 * group.registerFunction(&quot;str.upcase&quot;, new Function() {
 * 
 * 	public String call(Object[] paras, Context ctx) {
 * 		String str = (String) paras[0];
 * 		return str.toUpperCase();
 * 	}
 * 
 * });
 * </pre>
 * 
 * str.upcase接收一个字符串参数，并将其转为大写，如下调用
 * <p>
 * 
 * <pre>
 * hello,this is ${str.upcase(user.name)}
 * </pre>
 * 
 * @author jeolli
 * @since 1.1
 * @see GroupTemplate.registerFunction
 * 
 * 
 */

public interface Function {

	/**
	 * 
	 * @param paras
	 *            beetl传递的参数
	 * @param ctx
	 *            上下文，通过__pw获取Writer， __group 获取GroupTemplate
	 * @return
	 * 
	 */
	public Object call(Object[] paras, Context ctx);

}