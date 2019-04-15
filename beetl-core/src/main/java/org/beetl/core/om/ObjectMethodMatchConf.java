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

import java.lang.reflect.Array;
import java.lang.reflect.Method;
import java.math.BigDecimal;

/**
 * 用于本地调用类型转化
 *
 * @author joelli
 */
public class ObjectMethodMatchConf {
    public final static int INT_CONVERT = 1;
    public final static int LONG_CONVERT = 2;
    public final static int DOUBLE_CONVERT = 3;
    public final static int FLOAT_CONVERT = 4;
    public final static int SHORT_CONVERT = 5;
    public final static int BIGDECIMAL_CONVERT = 6;
    public final static int BYTE_CONVERT = 7;
    public final static int CHAR_CONVERT = 8;
    public final static int NO_CONVERT = 0;
    //可变数组
    public final static int VARIABLE_ARRAY = 9;
    public Method method;
    //如何转化
    public int[] convert;
    // 是否需要转化
    public boolean isNeedConvert;

    public String toString() {
        String str = method.toString() + ",";
        for (int i : convert) {
            str = str + i + ",";
        }
        return str;
    }

    public Object[] convert(Object[] args) {
        if (isNeedConvert) {
            Object[] newArgs = new Object[convert.length];
            for (int i = 0; i < convert.length; i++) {
                if (convert[i] != VARIABLE_ARRAY) {
                    Object obj = this.convert(args[i], i);
                    newArgs[i] = obj;
                } else {
                    Class c = this.method.getParameterTypes()[i].getComponentType();
                    Object arrayObj = Array.newInstance(c, args.length - i);
                    Object[] objs = new Object[args.length - i];
                    for (int j = 0; j < objs.length; j++) {

                        Array.set(arrayObj, j, args[i + j]);
                    }
                    newArgs[i] = arrayObj;

                }

            }
            return newArgs;
        } else {
            return args;
        }

    }

    private Object convert(Object o, int i) {
        switch (convert[i]) {
            case NO_CONVERT: {
                return o;
            }
            case INT_CONVERT: {
                return ((Number) o).intValue();
            }
            case BYTE_CONVERT: {
                return ((Number) o).byteValue();
            }
            case CHAR_CONVERT: {
                return ((Character) o).charValue();
            }
            case LONG_CONVERT: {
                return ((Number) o).longValue();
            }
            case DOUBLE_CONVERT: {
                return ((Number) o).doubleValue();
            }
            case FLOAT_CONVERT: {
                return ((Number) o).floatValue();
            }
            case SHORT_CONVERT: {
                return ((Number) o).shortValue();
            }

            case BIGDECIMAL_CONVERT: {
                return new BigDecimal(o.toString());
            }
            default: {
                throw new RuntimeException("not support converty type " + i);
            }

        }
    }
}