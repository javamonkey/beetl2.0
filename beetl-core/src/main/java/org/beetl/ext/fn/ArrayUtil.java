/*
 [The "BSD license"]
 Copyright (c) 2011-2013  闲大赋 (李家智)
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
package org.beetl.ext.fn;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/**
 * 
 * @author 张健川  dlut.zjc@gmail.com
 */
public class ArrayUtil
{
	public Object[] range(Object arrayOrCollection, int start, int end)
	{
		if (arrayOrCollection.getClass().isArray())
		{
			Object[] array = (Object[]) arrayOrCollection;
			if (start >= end || start < 0 || end > array.length)
				throw new RuntimeException("start,end参数设置不正确");
			Object[] newArray = new Object[end - start];
			int index = 0;
			for (int i = start; i < end; i++)
			{
				newArray[index++] = array[i];
			}
			return newArray;
		}
		else if (arrayOrCollection instanceof Collection)
		{
			Collection<Object> collections = (Collection<Object>) arrayOrCollection;
			if (start >= end || start < 0 || end > collections.size())
				throw new RuntimeException("start,end参数设置不正确");
			Object[] array = new Object[end - start];
			Iterator<Object> iterator = collections.iterator();
			int i = 0;
			int index = 0;
			while (iterator.hasNext())
			{
				if (i >= start && i < end)
				{
					array[index] = iterator.next();
					index++;
				}
				else
				{
					if (i >= end)
						break;
					iterator.next();
				}
				i++;
			}
			return array;
		}
		return null;
	}

	public Object remove(Object arrayOrCollection, Object item)
	{
		if (arrayOrCollection != null)
		{
			if (arrayOrCollection.getClass().isArray())
			{
				Object[] oldArray = (Object[]) arrayOrCollection;
				Object[] newArray = new Object[oldArray.length - 1];
				Class type = arrayOrCollection.getClass().getComponentType();
				if (!(item.getClass().equals(type)))
				{
					throw new RuntimeException("item类型不正确");
				}
				else
				{
					int flag = 0;
					for (int i = 0; i < oldArray.length; i++)
					{
						if (oldArray[i] == item || oldArray[i].equals(item))
						{
							flag = 1;
							continue;
						}
						if (i - flag == oldArray.length - 1)
							return oldArray;
						newArray[i - flag] = oldArray[i];
					}
					return newArray;
				}
			}
			else if (arrayOrCollection instanceof Collection)
			{
				((Collection) arrayOrCollection).remove(item);
				return arrayOrCollection;
			}
		}
		return null;
	}

	public Object add(Object o, Object item)
	{
		return this.add(o, item, 0);
	}

	public Object add(Object o, Object item, int index)
	{

		if (o != null)
		{
			if (o.getClass().isArray())
			{
				Object[] oldArray = (Object[]) o;
				Object[] newArray = new Object[oldArray.length + 1];

				Class type = o.getClass().getComponentType();
				if (!(item.getClass().equals(type)) || index < 0 || index > oldArray.length)
				{
					throw new RuntimeException("item或者index参数不正确");
				}
				else
				{
					int flag = 0;
					for (int i = 0; i < oldArray.length + 1; i++)
					{
						if (i != index)
						{
							newArray[i] = oldArray[i - flag];
						}
						else
						{
							newArray[i] = item;
							flag = 1;
						}
					}
				}
				return newArray;
			}
			else if (o instanceof Collection)
			{
				Collection<Object> collection = (Collection<Object>) o;
				((Collection) o).add(item);
				return collection;
			}
		}
		return null;
	}

	public Boolean contain(Object arrayOrCollection, Object item)
	{
		if (arrayOrCollection != null)
		{
			if (arrayOrCollection.getClass().isArray())
			{
				Object[] array = (Object[]) arrayOrCollection;
				Class type = arrayOrCollection.getClass().getComponentType();
				if (!(item.getClass().equals(type)))
				{
					throw new RuntimeException("item或者index参数不正确");
				}
				else
				{
					for (int i = 0; i < array.length; i++)
					{
						if (array[i].equals(item) || array[i] == item)
						{
							return true;
						}
					}
					return false;
				}
			}
			else if (arrayOrCollection instanceof Collection)
			{
				Collection<Object> collection = (Collection<Object>) arrayOrCollection;
				return collection.contains(item);
			}
		}
		return false;
	}

	public Object[] toArray(Object... objects)
	{
		return objects;
	}

	public Object[] collection2Array(Collection cols)
	{
		return cols.toArray();
	}

	public static void main(String[] args)
	{
		ArrayUtil util = new ArrayUtil();
		List list = Arrays.asList(new String[]
		{ "a", "b", "c", "d" });
		Object[] o = (Object[]) util.range(list.toArray(), 0, 2);
		int a = 1;
	}
}
