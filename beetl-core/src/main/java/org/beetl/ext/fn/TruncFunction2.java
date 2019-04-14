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

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.beetl.core.Context;
import org.beetl.core.Function;

/**
 * 截取数字，剩下指定位数,如果输入0，则取整，因为这个仅仅用于输出，所以建议用format函数定制
 * 如
 * ${trunc2(12.333,1)},输出是12.3
 * 
 * 推荐使用
 *
 *
 */

public class TruncFunction2 implements Function
{

	public Object call(Object[] paras, Context ctx)
	{
		Object obj = paras[0];
		
		if(obj==null){
			return null;
		}
		if(obj instanceof Date){
			return truncateDate((Date)obj,(String)(paras.length==1?null:paras[1]));
		}else if(obj instanceof Number){
			return truncateNumber((Number)obj,(Number)(paras.length==1?null:paras[1]));
		}else{
			throw new UnsupportedOperationException("truncate :"+obj.getClass().getName());
		}
		
		
	}
	protected String truncateNumber(Number data,Number pos){
		
		String str = data.toString();
		
		int index = str.indexOf(".");
		if(index==-1){
			return str;
		}
		
		if(pos==null){
			 return str.substring(0,index);
		}else{
			int p = pos.intValue();
			if(p==0){
				throw new IllegalArgumentException("参数不能为0");
			}
			//小数位
			int dig = str.length()-index-1;
			if(dig>=p){
				return str.substring(0,index+p+1);
			}else{
				return str;
			}
			
		}
		
	}
	protected String truncateDate(Date d,String format){
		if(format==null){
			format = "yyyy-MM-dd";
		}
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		return sdf.format(d);
	}

	public static void main(String[] args){
		TruncFunction2 f = new TruncFunction2();
		System.out.println(f.truncateNumber(116.136d, 2));
		System.out.println(f.truncateDate(new Date(), "MM"));
	}

}
