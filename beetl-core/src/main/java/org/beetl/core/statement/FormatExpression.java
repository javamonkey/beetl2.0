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

import org.beetl.core.Context;
import org.beetl.core.ContextFormat;
import org.beetl.core.Format;
import org.beetl.core.exception.BeetlException;

/** ${date,dateFormat='yyyy-mm-dd'}
 * @author joelli
 *
 */
public class FormatExpression extends Expression {
	String name;
	String pattern;

	/**${date,name=pattern}
	 * @param name
	 * @param pattern
	 * @param token
	 */
	public FormatExpression(String name, String pattern, GrammarToken token) {
		super(token);
		this.name = name;
		this.pattern = pattern;
	}

	public Object evaluate(Context ctx) {
		throw new UnsupportedOperationException();
	}

	public Object evaluateValue(Object o, Context ctx) {

		Format format = null;
		if (name != null) {
			format = ctx.gt.getFormat(name);
		} else {
			if (o == null) return null;
			format = ctx.gt.getDefaultFormat(o.getClass());
		}

		if (format == null) {
			BeetlException ex = new BeetlException(BeetlException.FORMAT_NOT_FOUND);
			ex.pushToken(token);
			throw ex;
		}
		try {
			if (format instanceof ContextFormat) {
				return ((ContextFormat) format).format(o, pattern, ctx);
			} else {
				return format.format(o, pattern);
			}

		} catch (Exception e) {
			BeetlException ex = new BeetlException(BeetlException.NATIVE_CALL_EXCEPTION, "调用格式化函数抛出异常", e);
			ex.pushToken(token);
			throw ex;
		}

	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPattern() {
		return pattern;
	}

	public void setPattern(String pattern) {
		this.pattern = pattern;
	}


}
