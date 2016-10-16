package org.beetl.ext.spring;

import java.util.Collections;
import java.util.UUID;

import javax.servlet.FilterChain;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.beetl.core.Context;
import org.beetl.core.Function;
import org.beetl.ext.web.WebVariable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.Expression;
import org.springframework.security.access.expression.ExpressionUtils;
import org.springframework.security.access.expression.SecurityExpressionHandler;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.FilterInvocation;

/**
 * 测试当前用户是否满足指定权限表达式
 *
 * @author Chen Rui
 */
public class AccessExpressionIfFunction implements Function {
	// 设置过滤器链
	private static final FilterChain DUMMY_CHAIN = new FilterChain() {
		@Override
		public void doFilter(ServletRequest request, ServletResponse response) {
			throw new UnsupportedOperationException();
		}
	};

	/**
	 * Spring权限表达式处理器
	 */
	@Autowired
	private SecurityExpressionHandler<FilterInvocation> expressionHandler = null;

	@Override
	public Object call(Object[] paras, Context ctx) {
		// 如果没有安全上下文，固定返回true
		SecurityContext securityContext = SecurityContextHolder.getContext();
		if (securityContext == null) {
			return true;
		}
		// 用户未登录
		Authentication authentication = securityContext.getAuthentication();
		if (authentication == null) {
			authentication = new AnonymousAuthenticationToken(UUID.randomUUID().toString(), "anonymous",
					Collections.<GrantedAuthority> singletonList(new SimpleGrantedAuthority("ROLE_ANONYMOUS")));
		}
		// 未提供表达式，返回true
		if ((paras.length == 0) || (paras[0] == null) || (!(paras[0] instanceof String))) {
			return true;
		}
		String access = (String) paras[0];
		// 否则执行权限表达式进行认证
		WebVariable servlet = (WebVariable) ctx.getGlobal("servlet");
		Expression accessExpression = expressionHandler.getExpressionParser().parseExpression(access);
		return ExpressionUtils.evaluateAsBoolean(accessExpression, expressionHandler.createEvaluationContext(authentication,
				new FilterInvocation(servlet.getRequest(), servlet.getResponse(), AccessExpressionIfFunction.DUMMY_CHAIN)));
	}
}
