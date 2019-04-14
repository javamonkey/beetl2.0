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

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;

import org.beetl.core.Context;
import org.beetl.core.Function;
import org.beetl.core.Resource;
import org.beetl.core.exception.BeetlException;

/**
 * ${includeStatic(file)}
 * @author jeolli
 *
 */
public class PrintFile implements Function
{

	public String call(Object[] paras, Context ctx) {
		String path = (String)paras[0];
		
		Resource resource = ctx.gt.getResourceLoader().getResource(path);
		Reader reader = resource.openReader();
		char[] buff = new char[100]; 
		int rc = 0; 
		try {
			while ((rc = reader.read(buff)) !=-1) { 
				ctx.byteWriter.write(buff, rc);
			}
		} catch (IOException e) {
			throw new RuntimeException(e);
		} 
		
		return "";

	}

}
