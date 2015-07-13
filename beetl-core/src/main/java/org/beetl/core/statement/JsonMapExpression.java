/*
 [The "BSD license"]
 Copyright (c) 2011-2014 Joel Li (李家智)
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

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.beetl.core.Context;
import org.beetl.core.InferContext;

/**
 * {a:1,b:2}
 * @author joelli
 *
 */
public class JsonMapExpression extends Expression
{

	Map<String, Expression> map;
	public Expression[] array;

	public JsonMapExpression(Map<String, Expression> map, GrammarToken token)
	{
		super(token);
		this.map = map;
		array = map.values().toArray(new Expression[0]);
	}

	public Object evaluate(Context ctx)
	{
		if (map.size() == 0)
		{
			return new LinkedHashMap();
		}
		else
		{
			Map values = new LinkedHashMap(map.size());
			for (Entry<String, Expression> entry : map.entrySet())
			{
				values.put(entry.getKey(), entry.getValue().evaluate(ctx));
			}
			return values;

		}
	}

	@Override
	public void infer(InferContext inferCtx)
	{

		for (Expression exp : array)
		{
			exp.infer(inferCtx);
		}
		this.type = Type.MapType;

	}

}
