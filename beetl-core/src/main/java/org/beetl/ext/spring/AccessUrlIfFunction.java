package org.beetl.ext.spring;

import java.util.Collections;
import java.util.UUID;

import javax.servlet.ServletContext;

import org.beetl.core.Context;
import org.beetl.core.Function;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.access.WebInvocationPrivilegeEvaluator;
import org.springframework.web.context.ServletContextAware;

/**
 * 测试指定URL当前用户是否满足访问权限<br>
 * <code>urlIf('/system/user_list.html', 'GET')</code><br>
 * 第一参数表示测试URL, 第二参数表示访问方式(默认GET，建议全大写)
 *
 * @author Chen Rui
 */
public class AccessUrlIfFunction implements Function, ServletContextAware {
	/**
	 *
	 * Servlet Context上下文
	 *
	 */
	private ServletContext servletContext = null;

	/**
	 * Web访问权限计算器
	 */
	@Autowired
	private WebInvocationPrivilegeEvaluator privilegeEvaluator = null;

	/**
	 *
	 * Servlet Context上下文
	 *
	 *
	 *
	 * @param servletContext
	 *
	 */
	@Override
	public void setServletContext(ServletContext servletContext) {
		this.servletContext = servletContext;
	}

	@Override
	public Boolean call(Object[] paras, Context ctx) {
		// 如果没有安全上下文，固定返回true
		SecurityContext securityContext = SecurityContextHolder.getContext();
		if (securityContext == null) {
			return true;
		}
		// 用户未登录
		Authentication authentication = getAuthentication(securityContext);

		// 如果未提供URL，固定返回true
		if ((paras.length == 0) || (paras[0] == null) || !(paras[0] instanceof String)) {
			return true;
		}
		String url = (String) paras[0];
		// 默认请求方式为GET，由第二参数给定
		String method = "GET";
		if ((paras.length > 1) && (paras[1] != null) && (paras[1] instanceof String)) {
			method = (String) paras[1];
		}
		return privilegeEvaluator.isAllowed(servletContext.getContextPath(), url, method, authentication);
	}

	/**
	 * 获取到当前登录用户凭证，如果不存在，返回一个匿名凭证
	 *
	 * @param securityContext
	 *            当前安全上下文
	 * @return 当前登录用户凭证，如果不存在，返回一个匿名凭证
	 */
	private Authentication getAuthentication(SecurityContext securityContext) {
		// 用户未登录
		Authentication authentication = securityContext.getAuthentication();
		if (authentication == null) {
			authentication = new AnonymousAuthenticationToken(UUID.randomUUID().toString(), "anonymous",
					Collections.<GrantedAuthority> singletonList(new SimpleGrantedAuthority("ROLE_ANONYMOUS")));
		}
		return authentication;
	}
}
