package org.beetl.core;

import java.util.HashSet;
import java.util.Set;

/**
 * 模板配置
 * 
 * @author joelli
 * 
 */
public class Configuration
{

	// 关于模板的设置

	/* 模板字符集 */
	String charset = "UTF-8";
	/* 模板占位起始符号 */
	String placeholderStart = "${";
	/* 模板占位结束符号 */
	String placeholderEnd = "}";
	/* 控制语句起始符号 */
	String statementStart = "<%";
	/* 控制语句结束符号 */
	String statementEnd = "%>";
	/* html tag 标示符号 */
	String htmlTagFlag = "#";
	/* 是否允许html tag，在web编程中，有可能用到html tag，最好允许 */
	boolean isHtmlTagSupport = false;
	/* 是否允许直接调用class */
	boolean nativeCall = false;
	/* 输出模式，默认是字符集输出，改成byte输出提高性能 */
	boolean directByteOutput = false;
	/* 严格mvc应用，只有变态的的人才打开此选项 */
	boolean isStrict = false;

	String htmlTagStart = "<" + htmlTagFlag;
	String htmlTagEnd = "</" + htmlTagFlag;
	Set<String> pkgList = new HashSet<String>();

	// 关于引擎的设置

	//	String engine = "org.beetl.core.DefaultTemplateEngine";
	String engine = "org.beetl.core.FastRuntimeEngine";
	String nativeSecurity = "org.beetl.core.DefaultNativeSecurityManager";

	public GroupTemplate make()
	{
		return null;
	}

	public Configuration()
	{
		pkgList.add("java.util.");
		pkgList.add("java.lang.");

	}

	public String getCharset()
	{
		return charset;
	}

	public static Configuration defaultConfiguration()
	{
		return new Configuration();
	}

	public String getPlaceholderStart()
	{
		return placeholderStart;
	}

	public void setPlaceholderStart(String placeholderStart)
	{
		this.placeholderStart = placeholderStart;
	}

	public String getPlaceholderEnd()
	{
		return placeholderEnd;
	}

	public void setPlaceholderEnd(String placeholderEnd)
	{
		this.placeholderEnd = placeholderEnd;
	}

	public String getStatementStart()
	{
		return statementStart;
	}

	public void setStatementStart(String statementStart)
	{
		this.statementStart = statementStart;
	}

	public String getStatementEnd()
	{
		return statementEnd;
	}

	public void setStatementEnd(String statementEnd)
	{
		this.statementEnd = statementEnd;
	}

	public String getHtmlTagFlag()
	{
		return htmlTagFlag;
	}

	public void setHtmlTagFlag(String htmlTagFlag)
	{
		this.htmlTagFlag = htmlTagFlag;
	}

	public boolean isHtmlTagSupport()
	{
		return isHtmlTagSupport;
	}

	public void setHtmlTagSupport(boolean isHtmlTagSupport)
	{
		this.isHtmlTagSupport = isHtmlTagSupport;
	}

	public boolean isNativeCall()
	{
		return nativeCall;
	}

	public void setNativeCall(boolean nativeCall)
	{
		this.nativeCall = nativeCall;
	}

	public boolean isDirectByteOutput()
	{
		return directByteOutput;
	}

	public void setDirectByteOutput(boolean directByteOutput)
	{
		this.directByteOutput = directByteOutput;
	}

	public boolean isStrict()
	{
		return isStrict;
	}

	public void setStrict(boolean isStrict)
	{
		this.isStrict = isStrict;
	}

	public String getHtmlTagStart()
	{
		return htmlTagStart;
	}

	public void setHtmlTagStart(String htmlTagStart)
	{
		this.htmlTagStart = htmlTagStart;
	}

	public String getHtmlTagEnd()
	{
		return htmlTagEnd;
	}

	public void setHtmlTagEnd(String htmlTagEnd)
	{
		this.htmlTagEnd = htmlTagEnd;
	}

	public void setCharset(String charset)
	{
		this.charset = charset;
	}

	public Set<String> getPkgList()
	{
		return pkgList;
	}

	public void addPkg(String pkg)
	{
		this.pkgList.add(pkg.concat("."));
	}

	public void setPkgList(Set<String> pkgList)
	{
		this.pkgList = pkgList;
	}

	public String getEngine()
	{
		return engine;
	}

	public void setEngine(String engine)
	{
		this.engine = engine;
	}

	public String getNativeSecurity()
	{
		return nativeSecurity;
	}

	public void setNativeSecurity(String nativeSecurity)
	{
		this.nativeSecurity = nativeSecurity;
	}

}
