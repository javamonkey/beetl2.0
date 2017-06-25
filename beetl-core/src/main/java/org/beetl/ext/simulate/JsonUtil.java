package org.beetl.ext.simulate;

/**
 * 模拟测试中，json工具，beetl不自带json工具，建议使用jackson或则fastjson
 * @author xiandafu
 *
 */
public interface JsonUtil {
	public String toJson(Object o) throws Exception;
	public Object toObject(String str,Class c) throws Exception;
}
