package org.beetl.ext.web;

import javax.servlet.http.HttpSession;

/**
 * wrap session ,so beetl can access it 
 * @author joelli
 * @since 1.1
 *
 */
public class SessionWrapper
{
	HttpSession session = null;

	public SessionWrapper(HttpSession session)
	{
		this.session = session;
	}

	public Object get(String key)
	{
		return session.getAttribute((String) key);
	}

}
