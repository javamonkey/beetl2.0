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
package org.beetl.core.om;

import java.util.*;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 为一个特定类的方法生成AttributeAccess，如果类是
 * <ul>
 * <li>Map,则生成MapAA</li>
 * <li>List,则生成ListAA</li>
 * <li>数组,则生成ArrayAA</li>
 * <li>普通PoJo对象,</li>
 * </ul>
 *
 * @author joelli
 */
public class DefaultAAFactory {

    protected  ListAA listAA = new ListAA();
    protected  MapAA mapAA = new MapAA();
    protected  ArrayAA arrayAA = new ArrayAA();
    protected  MapEntryAA mapEntryAA = new MapEntryAA();
    /**
     *  可以替换成自己的实现，比如，允许属性上增加注解来设定返回的属性值
     *
     */

    protected  ReflectBeanAA reflectBeanAA = new  ReflectBeanAA();
    protected  Map<Class, AttributeAccess> classAttrs = new ConcurrentHashMap<Class, AttributeAccess>();




    public DefaultAAFactory(){
        classAttrs.put(HashMap.class, mapAA);
        classAttrs.put(ConcurrentHashMap.class, mapAA);
        classAttrs.put(LinkedHashMap.class, mapAA);

        classAttrs.put(ArrayList.class, listAA);
        classAttrs.put(Entry.class, mapEntryAA);

    }

    public  AttributeAccess buildFiledAccessor(Class c) {

        AttributeAccess aa = classAttrs.get(c);
        if (aa != null) {
            return aa;
        }
        if (c.isArray()) {
            return arrayAA;
        }

        if (Map.class.isAssignableFrom(c)) {
            return mapAA;
        }

        if (List.class.isAssignableFrom(c)) {
            return listAA;
        }

        if(Map.Entry.class.isAssignableFrom(c)){
            return mapEntryAA;
        }


        aa = registerClass(c);
        return aa;

    }

    protected  AttributeAccess registerClass(Class c) {
        classAttrs.put(c,reflectBeanAA);
        return reflectBeanAA;
    }

    public ListAA getListAA() {
        return listAA;
    }

    public void setListAA(ListAA listAA) {
        this.listAA = listAA;
    }
}
