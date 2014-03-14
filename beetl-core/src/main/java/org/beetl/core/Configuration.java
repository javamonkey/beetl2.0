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

/**
 * 模板配置
 * 
 * @author joelli
 * 
 */
public class Configuration
{

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

	String errorHandlerClass = "org.beetl.core.DefaultErrorHandler";

	String htmlTagStart = "<" + htmlTagFlag;
	String htmlTagEnd = "</" + htmlTagFlag;

	//类搜索的包名列表
	Set<String> pkgList = new HashSet<String>();

	// 关于引擎的设置

	//	String engine = "org.beetl.core.DefaultTemplateEngine";
	String engine = "org.beetl.core.FastRuntimeEngine";
	String nativeSecurity = "org.beetl.core.DefaultNativeSecurityManager";

	//扩展资源
	Map<String, String> fnMap = new HashMap<String, String>();
	Map<String, String> fnPkgMap = new HashMap<String, String>();

	Map<String, String> formatMap = new HashMap<String, String>();
	Map<String, String> defaultFormatMap = new HashMap<String, String>(0);
	Set<String> generalVirtualAttributeSet = new HashSet<String>();
	Map<String, String> virtualClass = new HashMap<String, String>();
	Map<String, String> tagFactoryMap = new HashMap<String, String>();
	Map<String, String> tagMap = new HashMap<String, String>();

	public static String DELIMITER_PLACEHOLDER_START = "DELIMITER_PLACEHOLDER_START";
	public static String DELIMITER_PLACEHOLDER_END = "DELIMITER_PLACEHOLDER_END";
	public static String DELIMITER_STATEMENT_START = "DELIMITER_STATEMENT_START";
	public static String DELIMITER_STATEMENT_END = "DELIMITER_STATEMENT_END";
	public static String NATIVE_CALL = "NATIVE_CALL";
	//	public static String COMPILE_CLASS = "COMPILE_CLASS";
	public static String DIRECT_BYTE_OUTPUT = "DIRECT_BYTE_OUTPUT";
	public static String TEMPLATE_ROOT = "TEMPLATE_ROOT";
	public static String TEMPLATE_CHARSET = "TEMPLATE_CHARSET";
	//	public static String TEMPLATE_CACHE_CHECK_PERIOD = "TEMPLATE_CACHE_CHECK_PERIOD";
	//	public static String TEMPLATE_CLASS_FOLDER = "TEMPLATE_CLASS_FOLDER";
	public static String ERROR_HANDLER = "ERROR_HANDLER";
	public static String MVC_STRICT = "MVC_STRICT";
	//	public static String DEBUG = "DEBUG";
	//	public static String COMPILE_CLASS_KEEP_SOURCE = "COMPILE_CLASS_KEEP_SOURCE";
	//	public static String BIG_NUMBER_SUPPORT = "BIG_NUMBER_SUPPORT";
	public static String HTML_TAG_SUPPORT = "HTML_TAG_SUPPORT";
	public static String HTML_TAG_FLAG = "HTML_TAG_FLAG";
	public static String IMPORT_PACKAGE = "IMPORT_PACKAGE";
	public static String ENGINE = "ENGINE";
	public static String NATIVE_SECUARTY_MANAGER = "NATIVE_SECUARTY_MANAGER";

	public Configuration() throws IOException
	{
		//总是添加这俩个
		pkgList.add("java.util.");
		pkgList.add("java.lang.");
		//beetl默认
		Properties ps = new Properties();
		ps.load(Configuration.class.getResourceAsStream("/org/beetl/core/beetl-default.properties"));
		parseProperties(ps);
		//应用默认
		//有问题，在eclipse环境下
		InputStream ins = Configuration.class.getResourceAsStream("/beetl.properties");
		if (ins != null)
		{
			ps.clear();
			ps.load(ins);
			parseProperties(ps);
		}

	}

	public Configuration(Properties ps) throws IOException
	{
		this();
		parseProperties(ps);

	}

	public void add(File path) throws IOException
	{
		Properties ps = new Properties();
		ps.load(new FileReader(path));
		parseProperties(ps);
	}

	public void add(String path) throws IOException
	{

		Properties ps = new Properties();
		ps.load(Configuration.class.getResourceAsStream(path));
		parseProperties(ps);

	}

	protected void parseProperties(Properties ps)
	{
		Set<Map.Entry<Object, Object>> set = ps.entrySet();
		for (Map.Entry<Object, Object> entry : set)
		{
			String key = (String) entry.getKey();
			String value = (String) entry.getValue();
			setValue(key, value);
		}
	}

	protected void setValue(String key, String value)
	{
		if (key.equalsIgnoreCase(TEMPLATE_CHARSET))
		{
			this.charset = value;
		}
		else if (key.equalsIgnoreCase(DELIMITER_PLACEHOLDER_START))
		{
			this.placeholderStart = value;

		}
		else if (key.equalsIgnoreCase(DELIMITER_PLACEHOLDER_END))
		{
			if (value == null | value.length() == 0 || value.equals("null"))
			{
				this.placeholderEnd = null;
			}
			else
			{
				this.placeholderEnd = value;
			}
		}
		else if (key.equalsIgnoreCase(DELIMITER_STATEMENT_START))
		{
			this.statementStart = value;
		}
		else if (key.equalsIgnoreCase(DELIMITER_STATEMENT_END))
		{
			this.statementEnd = value;
		}
		else if (key.equalsIgnoreCase(NATIVE_CALL))
		{
			this.nativeCall = isBoolean(value, false);
		}
		else if (key.equalsIgnoreCase(DIRECT_BYTE_OUTPUT))
		{
			this.directByteOutput = isBoolean(value, false);
		}
		else if (key.equalsIgnoreCase(ERROR_HANDLER))
		{
			this.errorHandlerClass = value;
		}
		else if (key.equalsIgnoreCase(MVC_STRICT))
		{
			this.isStrict = isBoolean(value, false);
		}
		else if (key.equalsIgnoreCase(HTML_TAG_SUPPORT))
		{
			this.isHtmlTagSupport = isBoolean(value, false);
		}
		else if (key.equalsIgnoreCase(HTML_TAG_FLAG))
		{
			this.htmlTagFlag = value;
			htmlTagStart = "<" + htmlTagFlag;
			htmlTagEnd = "</" + htmlTagFlag;

		}
		else if (key.equalsIgnoreCase(IMPORT_PACKAGE))
		{
			String[] strs = value.split(";");
			for (String pkg : strs)
			{
				this.pkgList.add(pkg);
			}
		}
		else if (key.equalsIgnoreCase(ENGINE))
		{
			this.engine = value;
		}
		else if (key.equalsIgnoreCase(NATIVE_SECUARTY_MANAGER))
		{
			this.nativeSecurity = value;
		}
		else
		{
			//扩展

			if (key.startsWith("fn.") || key.startsWith("FN."))
			{
				addFunction(key, value);
			}
			else if (key.startsWith("fnp.") || key.startsWith("FNP."))
			{
				addFunctionPackage(key, value);
			}
			else if (key.startsWith("ft.") || key.startsWith("FT."))
			{
				addFormat(key, value);
			}
			else if (key.startsWith("ftc.") || key.startsWith("FTC."))
			{
				addDefaultFormat(key, value);
			}
			else if (key.startsWith("virtual.") || key.startsWith("VIRTUAL."))
			{
				addVirtual(key, value);
			}
			else if (key.startsWith("general_virtual.") || key.startsWith("GENERAL_VIRTUAL."))
			{
				String[] allCls = value.split(";");
				for (String cls : allCls)
				{
					this.generalVirtualAttributeSet.add(cls);
				}
			}
			else if (key.startsWith("tag.") || key.startsWith("TAG."))
			{
				addTag(key, value);
			}
			else if (key.startsWith("tagf.") || key.startsWith("TAGF."))
			{
				addTagFactory(key, value);
			}
		}

	}

	private void addTagFactory(String key, String value)
	{
		String name = this.getExtName(key);
		this.tagFactoryMap.put(name, value);
	}

	private void addTag(String key, String value)
	{
		String name = this.getExtName(key);
		this.tagMap.put(name, value);
	}

	private void addVirtual(String key, String value)
	{
		String name = this.getExtName(key);
		this.virtualClass.put(name, value);
	}

	private void addDefaultFormat(String key, String value)
	{
		String name = this.getExtName(key);
		this.defaultFormatMap.put(name, value);
	}

	private void addFormat(String key, String value)
	{
		String name = this.getExtName(key);
		this.formatMap.put(name, value);
	}

	private void addFunction(String key, String value)
	{
		String name = this.getExtName(key);
		this.fnMap.put(name, value);
	}

	private void addFunctionPackage(String key, String value)
	{
		String name = this.getExtName(key);
		this.fnPkgMap.put(name, value);
	}

	private String getExtName(String key)
	{
		int index = key.indexOf(".");
		String name = key.substring(index + 1);
		return name;
	}

	private boolean isBoolean(String value, boolean defaultValue)
	{

		if (isNotEmpty(value))
		{
			return Boolean.parseBoolean(value);
		}
		else
		{
			return defaultValue;
		}
	}

	public boolean isNotEmpty(String str)
	{
		return str != null && str.length() != 0;
	}

	public String getCharset()
	{
		return charset;
	}

	public static Configuration defaultConfiguration() throws IOException
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
