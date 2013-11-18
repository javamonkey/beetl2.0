package org.beetl.core;

/**
 * 为引擎提供一个无关乎字节还是字符输出的Writer
 * @author joelli
 *
 */
public class ByteWriter {
	public void write(String str){
		System.out.println(str);
	}
	public void writeStaticContent(Object o){
		if(o!=null)
		System.out.println(o.toString());
	
	}
	
	public void writePlaceholderContent(Object o){
		if(o!=null)
		System.out.println(o.toString());
	}
}
