package org.beetl.ext.spring;

import org.beetl.core.Context;
import org.beetl.core.Function;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * 返回当前登录用户的认证凭证
 *
 * @author Chen Rui
 */
public class AuthenticationFunction implements Function {
	@Override
	public Object call(Object[] paras, Context ctx) {
		// 获取安全上下文
		SecurityContext securityContext = SecurityContextHolder.getContext();
		Authentication authentication = securityContext != null ? securityContext.getAuthentication() : null;
		// 获取认证凭证
		return ((authentication == null) || (authentication instanceof AnonymousAuthenticationToken)) ? null : authentication;
	}
}
