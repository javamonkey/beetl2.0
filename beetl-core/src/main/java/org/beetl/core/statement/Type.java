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

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.beetl.core.BodyContent;
import org.beetl.core.IteratorStatus;
import org.beetl.core.exception.BeetlException;
import org.beetl.core.om.MethodInvoker;
import org.beetl.core.om.ObjectUtil;

/**
 * 表达式类型
 * 
 * @author joelli
 * 
 */
public class Type implements java.io.Serializable
{
	public Class cls;
	public Type[] types = null;
	public static final Type ObjectType = new Type(Object.class);
	public static final Type BooleanType = new Type(Boolean.class);
	public static final Type StringType = new Type(String.class);
	public static final Type NumberType = new Type(Number.class);

	public static final Type ListType = new Type(List.class);
	public static final Type MapType = new Type(Map.class);
	public static final Type NULLType = new Type(NULLClass.class);
	public static final Type BodyContentType = new Type(BodyContent.class);
	public static final Type mapEntryType = new Type(Entry.class);

	public static final Type IntegerType = new Type(Integer.class);
	public static final Type ShortType = new Type(Short.class);
	public static final Type FloatType = new Type(Float.class);
	public static final Type DoubleType = new Type(Double.class);

	public static final Class[] StringPara = new Class[]
	{ String.class };
	public static final Class[] GetMethodPara = new Class[]
	{};

	public Type()
	{

	}

	public Type(Class cls)
	{
		this.cls = cls;

	}

	public Type(Class cls, Class c1)
	{
		this.cls = cls;
		types = new Type[]
		{ new Type(c1) };

	}

	public Type(Class cls, Class c1, Class c2)
	{
		this.cls = cls;
		types = new Type[]
		{ new Type(c1), new Type(c2) };

	}

	public Type(Class cls, Type type)
	{
		this.cls = cls;
		types = new Type[]
		{ type };

	}

	public Type getType(String attrName) throws BeetlException
	{
		if (Map.class.isAssignableFrom(cls))
		{
			if (types != null)
			{
				return types[1];
			}
			else
			{

			}
			return ObjectType;
		}
		else if (Collection.class.isAssignableFrom(cls))
		{
			if (types != null)
			{
				return types[0];
			}
			else
			{
				return ObjectType;
			}

		}
		else if (cls == IteratorStatus.class)
		{
			return types[0];
		}
		else if (cls == Object.class)
		{
			return new Type(Object.class);
		}
		else
		{

			MethodInvoker invoker = ObjectUtil.getInvokder(cls, attrName);
			if (invoker == null)
			{

				BeetlException be = new BeetlException(BeetlException.GET_CALL_ERROR);
				throw be;

			}
			Class returnCls = invoker.getReturnType();
			if (returnCls == Object.class)
			{
				return Type.ObjectType;
			}
			else
			{
				return new Type(returnCls);
			}

		}
	}

	public String toString()
	{
		StringBuilder sb = new StringBuilder(this.cls.toString());
		if (types != null)
		{
			sb.append("<");
			for (Type t : this.types)
			{
				sb.append(t).append(",");
			}
			sb.setLength(sb.length() - 1);
			sb.append(">");
		}
		return sb.toString();

	}

	public boolean equals(Object o)
	{
		Type t = (Type) o;
		if (t.cls == this.cls)
		{
			//还需要考虑x,y?
			return true;
		}
		else
		{
			return false;
		}
	}

	public Type copy()
	{
		Type type = new Type(this.cls);

		if (types != null)
		{
			Type[] copyTypes = new Type[types.length];
			for (int i = 0; i < types.length; i++)
			{
				copyTypes[i] = new Type(types[i].cls);
			}
			type.types = copyTypes;
		}
		return type;

	}

	public class NULLClass
	{

	}
}
