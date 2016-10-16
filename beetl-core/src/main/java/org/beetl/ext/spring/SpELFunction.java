package org.beetl.ext.spring;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.beetl.core.Context;
import org.beetl.core.Function;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.expression.BeanFactoryResolver;
import org.springframework.context.expression.MapAccessor;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

/**
 * SpEL表达式函数,spring.spel()
 *
 * @author Chen Rui
 */
public class SpELFunction implements Function, ApplicationContextAware, DisposableBean {
	/**
	 * 表达式解析器，使用SpEL实现
	 */
	private ExpressionParser parser = new SpelExpressionParser();
	/**
	 * 表达式缓存
	 */
	private Map<String, Expression> expressionCache = new HashMap<String, Expression>();

	/**
	 * Spring应用程序上下文
	 */
	private ApplicationContext applicationContext = null;

	/**
	 * Spring 应用程序上下文
	 *
	 * @param applicationContext
	 *            Spring 应用程序上下文
	 */
	@Override
	public void setApplicationContext(ApplicationContext applicationContext) {
		this.applicationContext = applicationContext;
	}

	/**
	 * 方法调用
	 *
	 * @param args
	 *            方法参数列表
	 * @param context
	 *            Beetl执行上下文
	 * @return SpEL表达式执行结果
	 */
	@Override
	public Object call(Object[] args, Context context) {
		// 只能有一个参数且只能为字符串
		if ((args.length >= 1) && (args[0] instanceof String) && (args[0] != null)) {
			String spel = (String) args[0];
			Expression expression = getExpression(spel);
			// 如果有第二参数，取他作为根对象
			if ((args.length >= 2) && (args[1] != null)) {
				return expression.getValue(createEvaluationContext(args[1], context));
			} else {
				return expression.getValue(createEvaluationContext(Collections.emptyMap(), context));
			}
		}
		return null;
	}

	/**
	 * 使用spel表达式获取表达式对象，使用表达式缓存
	 *
	 * @param spel
	 *            表达式
	 * @return 表达式对象
	 */
	private synchronized Expression getExpression(String spel) {
		Expression expression = expressionCache.get(spel);
		if (expression == null) {
			expression = parser.parseExpression(spel);
			expressionCache.put(spel, expression);
		}
		return expression;
	}

	/**
	 * 创建SpEL执行上下文
	 *
	 * @param rootObject
	 *            SpEL表达式根对象
	 * @param context
	 *            Beetl上下文对象
	 * @return SpEL表达式执行上下文
	 */
	private EvaluationContext createEvaluationContext(Object rootObject, Context beetlContext) {
		StandardEvaluationContext context = new StandardEvaluationContext(rootObject);

		// 允许使用#context访问Beetl上下文
		context.setVariable("context", beetlContext);
		// 允许使用#global访问Beetl上下文的全局变量
		context.setVariable("global", beetlContext.globalVar);
		// 注册WebRender定义的全局变量
		context.setVariable("ctxPath", beetlContext.getGlobal("ctxPath"));
		context.setVariable("servlet", beetlContext.getGlobal("servlet"));
		context.setVariable("parameter", beetlContext.getGlobal("parameter"));
		context.setVariable("request", beetlContext.getGlobal("request"));
		context.setVariable("session", beetlContext.getGlobal("session"));
		// 允许使用属性格式访问Map
		context.addPropertyAccessor(new MapAccessor());
		// 允许访问Spring容器Bean
		context.setBeanResolver(new BeanFactoryResolver(applicationContext));

		return context;
	}

	/**
	 * 在关闭时清空表达式缓存
	 */
	@Override
	public void destroy() {
		expressionCache.clear();
	}
}
