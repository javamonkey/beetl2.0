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
package org.beetl.core;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import org.beetl.core.text.HtmlTagConfig;
import org.beetl.core.text.PlaceHolderDelimeter;
import org.beetl.core.text.ScriptDelimeter;

/**
 * 模板配置，核心文件之一
 * 
 * @author joelli
 * 
 */
public class Configuration {

	/** 模板字符集 */
	String charset = "UTF-8";
	/** 模板占位起始符号 */
	String placeholderStart = "${";
	/** 模板占位结束符号 */
	String placeholderEnd = "}";


	String placeholderStart2 = null;
	/** 模板占位结束符号 */
	String placeholderEnd2 = null;

	/** 控制语句起始符号 */
	String statementStart = "<%";
	/** 控制语句结束符号 */
	String statementEnd = "%>";


	/** 控制语句起始符号 */
	String statementStart2 = null;
	/** 控制语句结束符号 */
	String statementEnd2 = null;

	/** html tag 标示符号 */
	String htmlTagFlag = "#";
	/**是否允许html tag，在web编程中，有可能用到html tag，最好允许 */
	boolean isHtmlTagSupport = false;
	/** 是否允许直接调用class */

	boolean nativeCall = false;
	/** 输出模式，默认是字符集输出，改成byte输出提高性能 */
	boolean directByteOutput = false;
	/** 严格mvc应用，只有变态的的人才打开此选项 */
	boolean isStrict = false;

	/**
	 * 是否忽略客户端的网络异常
	 */
	boolean isIgnoreClientIOError = true;

	/**
	 * 错误处理类
	 */
	String errorHandlerClass = "org.beetl.core.ConsoleErrorHandler";

	/**
	 * HTML标签开始符号
	 */
	String htmlTagStart = "<" + htmlTagFlag;
	/**
	 * HTML标签结束符号
	 */
	String htmlTagEnd = "</" + htmlTagFlag;

	/**
	 *  html 绑定的属性，如&lt;aa var="customer">
	 */
	String htmlTagBindingAttribute = "var";

	/**
	 * 类搜索的包名列表
	 */
	Set<String> pkgList = new HashSet<String>();

	/**
	 * 渲染web 前执行的代码，需要实现WebRenderExt接口，如果为空，则不做操作
	 */
	String webAppExt = null;


	// html方法和html标签是否使用特殊的定界符，如模板使用简介的@和回车,html 标签和html tag使用<%%>
	boolean hasFunctionLimiter = false;
	String functionLimiterStart = null;
	String functionLimiterEnd = null;


	// 关于引擎的设置

	// String engine = "org.beetl.core.DefaultTemplateEngine";
	String engine = "org.beetl.core.FastRuntimeEngine";
	String nativeSecurity = "org.beetl.core.DefaultNativeSecurityManager";
	String resourceLoader = "org.beetl.core.resource.ClasspathResourceLoader";

	// 扩展资源
	Map<String, String> fnMap = new HashMap<String, String>();
	Map<String, String> fnPkgMap = new HashMap<String, String>();

	Map<String, String> formatMap = new HashMap<String, String>();
	Map<String, String> defaultFormatMap = new HashMap<String, String>(0);
	Set<String> generalVirtualAttributeSet = new HashSet<String>();
	Map<String, String> virtualClass = new HashMap<String, String>();
	Map<String, String> tagFactoryMap = new HashMap<String, String>();
	Map<String, String> tagMap = new HashMap<String, String>();
	// 资源loader配置
	Map<String, String> resourceMap = new HashMap<String, String>();

	// 缓冲数组
	int bufferSize = 4096;
	int  buffeerNum = 64;
	

	public static String DELIMITER_PLACEHOLDER_START = "DELIMITER_PLACEHOLDER_START";
	public static String DELIMITER_PLACEHOLDER_END = "DELIMITER_PLACEHOLDER_END";
	public static String DELIMITER_STATEMENT_START = "DELIMITER_STATEMENT_START";
	public static String DELIMITER_STATEMENT_END = "DELIMITER_STATEMENT_END";
	public static String DELIMITER_PLACEHOLDER_START2 = "DELIMITER_PLACEHOLDER_START2";
	public static String DELIMITER_PLACEHOLDER_END2 = "DELIMITER_PLACEHOLDER_END2";
	public static String DELIMITER_STATEMENT_START2 = "DELIMITER_STATEMENT_START2";
	public static String DELIMITER_STATEMENT_END2 = "DELIMITER_STATEMENT_END2";
	public static String NATIVE_CALL = "NATIVE_CALL";
	public static String IGNORE_CLIENT_IO_ERROR = "IGNORE_CLIENT_IO_ERROR";
	public static String DIRECT_BYTE_OUTPUT = "DIRECT_BYTE_OUTPUT";
	public static String TEMPLATE_ROOT = "TEMPLATE_ROOT";
	public static String TEMPLATE_CHARSET = "TEMPLATE_CHARSET";
	public static String ERROR_HANDLER = "ERROR_HANDLER";
	public static String MVC_STRICT = "MVC_STRICT";
	public static String WEBAPP_EXT = "WEBAPP_EXT";
	public static String HTML_TAG_SUPPORT = "HTML_TAG_SUPPORT";
	public static String HTML_TAG_FLAG = "HTML_TAG_FLAG";
	public static String IMPORT_PACKAGE = "IMPORT_PACKAGE";
	public static String ENGINE = "ENGINE";
	public static String NATIVE_SECUARTY_MANAGER = "NATIVE_SECUARTY_MANAGER";
	public static String RESOURCE_LOADER = "RESOURCE_LOADER";
	public static String HTML_TAG_BINDING_ATTRIBUTE = "HTML_TAG_BINDING_ATTRIBUTE";

	public static String BUFFER_SIZE = "buffer.maxSize";
	public static String BUFFER_NUM = "buffer.num";
	

	Properties ps = null;

	PlaceHolderDelimeter pd = null;
	ScriptDelimeter sd = null;
	HtmlTagConfig tagConf = null;

	public Configuration() throws IOException {
		// 总是添加这俩个
		pkgList.add("java.util.");
		pkgList.add("java.lang.");
		// beetl默认
		ps = new Properties();
		ps.load(Configuration.class.getResourceAsStream("/org/beetl/core/beetl-default.properties"));
		parseProperties(ps);
		// 应用默认
		// 有问题，在eclipse环境下
		InputStream ins = Configuration.class.getResourceAsStream("/beetl.properties");
		if (ins != null) {
			ps.clear();
			ps.load(ins);
			parseProperties(ps);
		}


	}

	public Configuration(Properties ps) throws IOException {
		this();
		// this.ps.putAll(myPs);
		parseProperties(ps);


	}


	public void initOther() {

		buildDelimeter();

	}

	public void add(File path) throws IOException {
		Properties ps = new Properties();
		ps.load(new FileReader(path));
		parseProperties(ps);
	}

	public void add(String path) throws IOException {

		Properties ps = new Properties();
		ps.load(Configuration.class.getResourceAsStream(path));
		parseProperties(ps);

	}

	protected void parseProperties(Properties ps) {
		Set<Map.Entry<Object, Object>> set = ps.entrySet();
		for (Map.Entry<Object, Object> entry : set) {
			String key = (String) entry.getKey();
			String value = (String) entry.getValue();
			setValue(key, value == null ? null : value.trim());
		}

		initOther();
	}

	protected void setValue(String key, String value) {
		if (key.equalsIgnoreCase(TEMPLATE_CHARSET)) {
			this.charset = value;
		} else if (key.equalsIgnoreCase(DELIMITER_PLACEHOLDER_START)) {
			this.placeholderStart = value;

		} else if (key.equalsIgnoreCase(DELIMITER_PLACEHOLDER_END)) {

			this.placeholderEnd = value;
		} else if (key.equalsIgnoreCase(DELIMITER_STATEMENT_START)) {
			this.statementStart = value;
		} else if (key.equalsIgnoreCase(DELIMITER_STATEMENT_END)) {
			if (value == null | value.length() == 0 || value.equals("null")) {
				this.statementEnd = null;
			} else {
				this.statementEnd = value;
			}
			/* 第二组定界符号 */
		} else if (key.equalsIgnoreCase(DELIMITER_PLACEHOLDER_START2)) {
			this.placeholderStart2 = value;

		} else if (key.equalsIgnoreCase(DELIMITER_PLACEHOLDER_END2)) {

			this.placeholderEnd2 = value;
		} else if (key.equalsIgnoreCase(DELIMITER_STATEMENT_START2)) {
			this.statementStart2 = value;
		} else if (key.equalsIgnoreCase(DELIMITER_STATEMENT_END2)) {
			if (value == null | value.length() == 0 || value.equals("null")) {
				this.statementEnd2 = null;
			} else {
				this.statementEnd2 = value;
			}

		} else if (key.equalsIgnoreCase(NATIVE_CALL)) {
			this.nativeCall = isBoolean(value, false);
		} else if (key.equalsIgnoreCase(IGNORE_CLIENT_IO_ERROR)) {
			this.isIgnoreClientIOError = isBoolean(value, false);
		} else if (key.equalsIgnoreCase(DIRECT_BYTE_OUTPUT)) {
			this.directByteOutput = isBoolean(value, false);
		} else if (key.equalsIgnoreCase(ERROR_HANDLER)) {
			if (value == null | value.length() == 0 || value.equals("null")) {
				this.errorHandlerClass = null;
			} else {
				this.errorHandlerClass = value;
			}

		} else if (key.equalsIgnoreCase(WEBAPP_EXT)) {
			if (value == null || value.length() == 0) {

				this.webAppExt = null;
			} else {
				this.webAppExt = value;
			}

		} else if (key.equalsIgnoreCase(MVC_STRICT)) {
			this.isStrict = isBoolean(value, false);
		} else if (key.equalsIgnoreCase(HTML_TAG_SUPPORT)) {
			this.isHtmlTagSupport = isBoolean(value, false);
		} else if (key.equalsIgnoreCase(HTML_TAG_FLAG)) {
			this.htmlTagFlag = value;
			htmlTagStart = "<" + htmlTagFlag;
			htmlTagEnd = "</" + htmlTagFlag;

		} else if (key.equalsIgnoreCase(HTML_TAG_BINDING_ATTRIBUTE)) {
			this.htmlTagBindingAttribute = value;
		} else if (key.equalsIgnoreCase(IMPORT_PACKAGE)) {
			String[] strs = value.split(";");
			for (String pkg : strs) {
				this.pkgList.add(pkg);
			}
		} else if (key.equalsIgnoreCase(ENGINE)) {
			this.engine = value;
		} else if (key.equalsIgnoreCase(NATIVE_SECUARTY_MANAGER)) {
			this.nativeSecurity = value;
		} else if (key.equalsIgnoreCase(RESOURCE_LOADER)) {
			this.resourceLoader = value;
		}

		else if (key.equalsIgnoreCase(RESOURCE_LOADER)) {
			this.resourceLoader = value;
		} else if (key.equalsIgnoreCase(BUFFER_SIZE)) {
			this.bufferSize = Integer.parseInt(value);
			if (bufferSize < 256) {
				throw new IllegalStateException("GLOBAL.buffer.maxSize 配置不能小于256");
			}
		} else if (key.equalsIgnoreCase(BUFFER_NUM)) {
			this.buffeerNum =Integer.parseInt(value);
		} else {
			// 扩展

			if (key.startsWith("fn.") || key.startsWith("FN.")) {
				addFunction(key, value);
			} else if (key.startsWith("fnp.") || key.startsWith("FNP.")) {
				addFunctionPackage(key, value);
			} else if (key.startsWith("ft.") || key.startsWith("FT.")) {
				addFormat(key, value);
			} else if (key.startsWith("ftc.") || key.startsWith("FTC.")) {
				addDefaultFormat(key, value);
			} else if (key.startsWith("virtual.") || key.startsWith("VIRTUAL.")) {
				addVirtual(key, value);
			} else if (key.startsWith("general_virtual.") || key.startsWith("GENERAL_VIRTUAL.")) {
				String[] allCls = value.split(";");
				for (String cls : allCls) {
					this.generalVirtualAttributeSet.add(cls);
				}
			} else if (key.startsWith("tag.") || key.startsWith("TAG.")) {
				addTag(key, value);
			} else if (key.startsWith("tagf.") || key.startsWith("TAGF.")) {
				addTagFactory(key, value);
			} else if (key.startsWith("resource.") || key.startsWith("RESOURCE.")) {
				addResource(key, value);
			}
		}

	}

	private void addResource(String key, String value) {
		String name = this.getExtName(key);
		this.resourceMap.put(name, value);
	}

	private void addTagFactory(String key, String value) {
		String name = this.getExtName(key);
		this.tagFactoryMap.put(name, value);
	}

	private void addTag(String key, String value) {
		String name = this.getExtName(key);
		this.tagMap.put(name, value);
	}

	private void addVirtual(String key, String value) {
		String name = this.getExtName(key);
		this.virtualClass.put(name, value);
	}

	private void addDefaultFormat(String key, String value) {
		String name = this.getExtName(key);
		this.defaultFormatMap.put(name, value);
	}

	private void addFormat(String key, String value) {
		String name = this.getExtName(key);
		this.formatMap.put(name, value);
	}

	private void addFunction(String key, String value) {
		String name = this.getExtName(key);
		this.fnMap.put(name, value);
	}

	private void addFunctionPackage(String key, String value) {
		String name = this.getExtName(key);
		this.fnPkgMap.put(name, value);
	}

	private String getExtName(String key) {
		int index = key.indexOf(".");
		String name = key.substring(index + 1);
		return name;
	}

	private boolean isBoolean(String value, boolean defaultValue) {

		if (isNotEmpty(value)) {
			return Boolean.parseBoolean(value);
		} else {
			return defaultValue;
		}
	}

	public boolean isNotEmpty(String str) {
		return str != null && str.length() != 0;
	}

	public String getCharset() {
		return charset;
	}

	public static Configuration defaultConfiguration() throws IOException {
		return new Configuration();
	}

	public String getPlaceholderStart() {
		return placeholderStart;
	}

	public void setPlaceholderStart(String placeholderStart) {

		this.placeholderStart = placeholderStart;
		buildDelimeter();
	}

	public String getPlaceholderEnd() {
		return placeholderEnd;
	}

	public void setPlaceholderEnd(String placeholderEnd) {
		this.placeholderEnd = placeholderEnd;
		buildDelimeter();
	}

	public String getStatementStart() {
		return statementStart;
	}

	public void setStatementStart(String statementStart) {
		this.statementStart = statementStart;
		buildDelimeter();
	}

	public String getStatementEnd() {
		return statementEnd;
	}

	public void setStatementEnd(String statementEnd) {
		this.statementEnd = statementEnd;
		buildDelimeter();
	}


	public String getPlaceholderStart2() {
		return placeholderStart2;
	}

	public void setPlaceholderStart2(String placeholderStart2) {
		this.placeholderStart2 = placeholderStart2;
	}

	public String getPlaceholderEnd2() {
		return placeholderEnd2;
	}

	public void setPlaceholderEnd2(String placeholderEnd2) {
		this.placeholderEnd2 = placeholderEnd2;
	}

	public String getStatementStart2() {
		return statementStart2;
	}

	public void setStatementStart2(String statementStart2) {
		this.statementStart2 = statementStart2;
	}

	public String getStatementEnd2() {
		return statementEnd2;
	}

	public void setStatementEnd2(String statementEnd2) {
		this.statementEnd2 = statementEnd2;
	}


	public String getHtmlTagFlag() {
		return htmlTagFlag;
	}

	public void setHtmlTagFlag(String htmlTagFlag) {
		this.htmlTagFlag = htmlTagFlag;
	}


	public PlaceHolderDelimeter getPlaceHolderDelimeter() {
		return pd;
	}


	public ScriptDelimeter getScriptDelimeter() {
		return sd;
	}


	public HtmlTagConfig getTagConf() {
		return tagConf;
	}

	public void setTagConf(HtmlTagConfig tagConf) {
		this.tagConf = tagConf;
	}


	public boolean isHtmlTagSupport() {
		return isHtmlTagSupport;
	}

	public void setHtmlTagSupport(boolean isHtmlTagSupport) {
		this.isHtmlTagSupport = isHtmlTagSupport;
	}

	public boolean isNativeCall() {
		return nativeCall;
	}

	public void setNativeCall(boolean nativeCall) {
		this.nativeCall = nativeCall;
	}

	public boolean isDirectByteOutput() {
		return directByteOutput;
	}

	public void setDirectByteOutput(boolean directByteOutput) {
		this.directByteOutput = directByteOutput;
	}

	public boolean isStrict() {
		return isStrict;
	}

	public void setStrict(boolean isStrict) {
		this.isStrict = isStrict;
	}

	public String getHtmlTagStart() {
		return htmlTagStart;
	}

	public void setHtmlTagStart(String htmlTagStart) {
		this.htmlTagStart = htmlTagStart;
	}

	public String getHtmlTagEnd() {
		return htmlTagEnd;
	}

	public void setHtmlTagEnd(String htmlTagEnd) {
		this.htmlTagEnd = htmlTagEnd;
	}

	public String getHtmlTagBindingAttribute() {
		return htmlTagBindingAttribute;
	}

	public void setHtmlTagBindingAttribute(String htmlTagBindingAttribute) {
		this.htmlTagBindingAttribute = htmlTagBindingAttribute;
	}

	public void setCharset(String charset) {
		this.charset = charset;
	}

	public Set<String> getPkgList() {
		return pkgList;
	}

	public void addPkg(String pkg) {
		this.pkgList.add(pkg.concat("."));
	}

	public void setPkgList(Set<String> pkgList) {
		this.pkgList = pkgList;
	}

	public String getEngine() {
		return engine;
	}

	public void setEngine(String engine) {
		this.engine = engine;
	}

	public String getNativeSecurity() {
		return nativeSecurity;
	}

	public void setNativeSecurity(String nativeSecurity) {
		this.nativeSecurity = nativeSecurity;
	}


	public String getWebAppExt() {
		return webAppExt;
	}

	public void setWebAppExt(String webAppExt) {
		this.webAppExt = webAppExt;
	}

	public boolean isIgnoreClientIOError() {
		return isIgnoreClientIOError;
	}

	public void setIgnoreClientIOError(boolean isIgnoreClientIOError) {
		this.isIgnoreClientIOError = isIgnoreClientIOError;
	}

	public String getErrorHandlerClass() {
		return errorHandlerClass;
	}

	public void setErrorHandlerClass(String errorHandlerClass) {
		this.errorHandlerClass = errorHandlerClass;
	}

	public Map<String, String> getFnMap() {
		return fnMap;
	}

	public void setFnMap(Map<String, String> fnMap) {
		this.fnMap = fnMap;
	}

	public Map<String, String> getFnPkgMap() {
		return fnPkgMap;
	}

	public void setFnPkgMap(Map<String, String> fnPkgMap) {
		this.fnPkgMap = fnPkgMap;
	}

	public Map<String, String> getFormatMap() {
		return formatMap;
	}

	public void setFormatMap(Map<String, String> formatMap) {
		this.formatMap = formatMap;
	}

	public Map<String, String> getDefaultFormatMap() {
		return defaultFormatMap;
	}

	public void setDefaultFormatMap(Map<String, String> defaultFormatMap) {
		this.defaultFormatMap = defaultFormatMap;
	}

	public Set<String> getGeneralVirtualAttributeSet() {
		return generalVirtualAttributeSet;
	}

	public void setGeneralVirtualAttributeSet(Set<String> generalVirtualAttributeSet) {
		this.generalVirtualAttributeSet = generalVirtualAttributeSet;
	}

	public Map<String, String> getVirtualClass() {
		return virtualClass;
	}

	public void setVirtualClass(Map<String, String> virtualClass) {
		this.virtualClass = virtualClass;
	}

	public Map<String, String> getTagFactoryMap() {
		return tagFactoryMap;
	}

	public void setTagFactoryMap(Map<String, String> tagFactoryMap) {
		this.tagFactoryMap = tagFactoryMap;
	}

	public Map<String, String> getTagMap() {
		return tagMap;
	}

	public void setTagMap(Map<String, String> tagMap) {
		this.tagMap = tagMap;
	}

	public String getProperty(String name) {
		return this.ps.getProperty(name);
	}

	public String getResourceLoader() {
		return resourceLoader;
	}

	public void setResourceLoader(String resourceLoader) {
		this.resourceLoader = resourceLoader;
	}

	public Map<String, String> getResourceMap() {
		return resourceMap;
	}

	public void setResourceMap(Map<String, String> resourceMap) {
		this.resourceMap = resourceMap;
	}

	public Properties getPs() {
		return ps;
	}

	public void setPs(Properties ps) {
		this.ps = ps;
	}

	private void buildDelimeter(){
		if (this.placeholderStart2 != null) {
			pd = new PlaceHolderDelimeter(placeholderStart.toCharArray(), placeholderEnd.toCharArray(),
					placeholderStart2.toCharArray(), placeholderEnd2.toCharArray());
		} else {
			pd = new PlaceHolderDelimeter(placeholderStart.toCharArray(), placeholderEnd.toCharArray());
		}

		if (this.statementStart2 != null) {
			sd = new ScriptDelimeter(statementStart.toCharArray(),
					statementEnd != null ? statementEnd.toCharArray() : null, statementStart2.toCharArray(),
					statementEnd2 != null ? statementEnd2.toCharArray() : null);
		} else {
			sd = new ScriptDelimeter(statementStart.toCharArray(),
					statementEnd != null ? statementEnd.toCharArray() : null);
		}

		if (this.isHtmlTagSupport) {
			tagConf = new HtmlTagConfig(getHtmlTagStart(), getHtmlTagEnd(), getHtmlTagBindingAttribute());
		}
	}


}
