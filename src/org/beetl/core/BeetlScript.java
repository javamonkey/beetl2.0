package org.beetl.core;

import java.io.Reader;

import org.beetl.core.exception.BeetlException;

/**
 * beetl脚本，模板将转为beetl脚本并被执行,核心类之一
 * @author joelli
 *
 */
public class BeetlScript {
	
	GroupTemplate gt;
	public BeetlScript(GroupTemplate gt){
		this.gt = gt ;
	}
	
	/**解析脚本
	 * @param reader
	 * @throws BeetlException
	 */
	public void parse(Reader reader) throws BeetlException{
		
	}
	
	/**执行脚本，输出到bw
	 * @param ctx
	 * @param bt
	 */
	public void execute(Context ctx,ByteWriter bw) throws BeetlException{
		//gt.fireEvent(e)
		
		
	}
}
