package org.beetl.core;

import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.beetl.core.cache.Cache;
import org.beetl.core.cache.ProgramCacheFactory;
import org.beetl.core.event.Event;
import org.beetl.core.event.Listener;
import org.beetl.core.exception.HTMLTagParserException;
import org.beetl.core.exception.TempException;
import org.beetl.core.statement.Program;
import org.beetl.core.util.ClassSearch;
import org.beetl.ext.fn.AssertFunction;
import org.beetl.ext.fn.CheckExistFunction;
import org.beetl.ext.fn.DateFunction;
import org.beetl.ext.fn.DebugFunction;
import org.beetl.ext.fn.DecodeFunction;
import org.beetl.ext.fn.EmptyFunction;
import org.beetl.ext.fn.NVLFunction;
import org.beetl.ext.fn.Print;
import org.beetl.ext.fn.Printf;
import org.beetl.ext.fn.Println;
import org.beetl.ext.fn.QuestionMark;
import org.beetl.ext.fn.TruncFunction;
import org.beetl.ext.format.DateFormat;
import org.beetl.ext.format.NumberFormat;

public class GroupTemplate
{

	/* 模板在运行过程中,class方法，accessory调用等需要的classLoader */
	ClassLoader classLoader = null;
	ResourceLoader resourceLoader = null;
	Configuration conf = null;
	TemplateEngine engine = null;
	Cache programCache = ProgramCacheFactory.defaulCache();
	List<Listener> ls = new ArrayList<Listener>();
	//所有注册的方法
	Map<String, Function> fnMap = new HashMap<String, Function>();
	Map<String, Format> formatMap = new HashMap<String, Format>();
	Map<Class, Format> defaultFormatMap = new HashMap<Class, Format>(0);
	List<VirtualAttributeEval> virtualAttributeList = new ArrayList<VirtualAttributeEval>();
	ClassSearch classSearch = null;

	/**
	 * 使用loader 和 conf初始化GroupTempalte
	 * 
	 * @param loader
	 *            资源加载器
	 * @param conf
	 *            模板引擎配置
	 */

	public GroupTemplate(ResourceLoader loader, Configuration conf)
	{
		this.resourceLoader = loader;
		this.conf = conf;
		engine = TemplateEngineFactory.getEngine();
		this.initFunction();
		this.initFormatter();
		this.initTag();
		this.initVirtual();
		classSearch = new ClassSearch(conf.getPkgList());
	}

	protected void initFunction()
	{
		this.registerFunction("date", new DateFunction());
		this.registerFunction("nvl", new NVLFunction());
		this.registerFunction("debug", new DebugFunction());
		this.registerFunction("exist", new CheckExistFunction());
		this.registerFunction("printf", new Printf());
		this.registerFunction("decode", new DecodeFunction());
		this.registerFunction("assert", new AssertFunction());
		this.registerFunction("print", new Print());
		this.registerFunction("println", new Println());
		this.registerFunction("prinf", new Printf());
		this.registerFunction("trunc", new TruncFunction());
		this.registerFunction("empty", new EmptyFunction());
		this.registerFunction("qmark", new QuestionMark());
	}

	protected void initFormatter()
	{
		// format
		Format dateForamt = new DateFormat();
		Format numberFormat = new NumberFormat();

		this.registerFormat("dateFormat", dateForamt);
		this.registerFormat("numberFormat", numberFormat);

		this.registerDefaultFormat(java.util.Date.class, dateForamt);
		this.registerDefaultFormat(java.sql.Date.class, dateForamt);
		this.registerDefaultFormat(java.sql.Time.class, dateForamt);
		this.registerDefaultFormat(java.sql.Timestamp.class, dateForamt);

		this.registerDefaultFormat(java.lang.Short.class, numberFormat);
		this.registerDefaultFormat(java.lang.Long.class, numberFormat);
		this.registerDefaultFormat(java.lang.Integer.class, numberFormat);
		this.registerDefaultFormat(java.lang.Float.class, numberFormat);
		this.registerDefaultFormat(java.lang.Double.class, numberFormat);
		this.registerDefaultFormat(short.class, numberFormat);
		this.registerDefaultFormat(long.class, numberFormat);
		this.registerDefaultFormat(int.class, numberFormat);
		this.registerDefaultFormat(float.class, numberFormat);
		this.registerDefaultFormat(double.class, numberFormat);

		this.registerDefaultFormat(java.math.BigInteger.class, numberFormat);
		this.registerDefaultFormat(java.math.BigDecimal.class, numberFormat);
		this.registerDefaultFormat(java.util.concurrent.atomic.AtomicLong.class, numberFormat);
		this.registerDefaultFormat(java.util.concurrent.atomic.AtomicInteger.class, numberFormat);

	}

	protected void initTag()
	{

	}

	protected void initVirtual()
	{
		// 可以根据类型做一定优化
		this.registerVirtualAttributeEval(new VirtualAttributeEval() {
			public Integer eval(Object o, String attributeName, Context ctx)
			{
				if (attributeName.equals("size"))
				{
					if (o instanceof Collection)
					{
						return ((Collection) o).size();
					}
					else if (o instanceof Map)
					{
						return ((Map) o).size();
					}
					else if (o.getClass().isArray())
					{
						return ((Object[]) o).length;

					}
					else
					{
						throw new IllegalArgumentException();
					}

				}
				else
				{
					throw new IllegalArgumentException();
				}

			}

			public boolean isSupport(Class c, String attributeName)
			{
				if ((Map.class.isAssignableFrom(c) || Collection.class.isAssignableFrom(c) || c.isArray())
						&& attributeName.equals("size"))
				{
					return true;
				}
				else
				{
					return false;
				}
			}
		});
	}

	/**
	 * 使用loader 和 默认的模板引擎配置来初始化GroupTempalte
	 * 
	 * @param loader
	 *            资源加载器
	 * 
	 */

	protected void setClassLoader(ClassLoader classLoader)
	{

	}

	public Template getTemplate(String key)
	{
		key = key.intern();
		Program program = (Program) this.programCache.get(key);
		if (program == null)
		{
			synchronized (key)
			{
				if (program == null)
				{
					Resource resource = resourceLoader.getResource(key);
					program = this.loadTemplate(resource);
					this.programCache.set(key, program);
				}
			}
		}

		return new Template(this, program, this.conf);

	}

	public Program getProgram(String key)
	{
		Program program = (Program) this.programCache.get(key);
		return program;
	}

	private Program loadTemplate(Resource res)
	{

		Reader reader = res.openReader();
		Transformator sf = new Transformator(conf.placeholderStart, conf.placeholderEnd, conf.statementStart,
				conf.statementEnd);
		Reader scriptReader;
		try
		{
			scriptReader = sf.transform(reader);

		}
		catch (HTMLTagParserException e)
		{
			throw new TempException(e.getMessage());
		}
		catch (IOException e)
		{
			throw new TempException(e.getMessage());
		}

		Program program = engine.createProgram(res.getId(), scriptReader, sf.textMap, this);
		program.metaData.lineSeparator = sf.lineSeparator;
		return program;

	}

	/**
	 * 关闭GroupTemplate，清理所有的资源
	 */
	public void close()
	{

	}

	// /** 为事件类型注册一个监听器
	// * @param type
	// * @param e
	// */
	// public void onEvent(int type,Listener e){
	//
	// }

	public ResourceLoader getResourceLoader()
	{
		return resourceLoader;
	}

	public void setResourceLoader(ResourceLoader resourceLoader)
	{
		this.resourceLoader = resourceLoader;
	}

	public Configuration getConf()
	{
		return conf;
	}

	public void setConf(Configuration conf)
	{
		this.conf = conf;
	}

	public ClassLoader getClassLoader()
	{
		return classLoader;
	}

	public void fireEvent(Event event)
	{
		for (Listener l : this.ls)
		{
			l.onEvent(event);
		}
	}

	public void addListener(Listener listener)
	{
		this.ls.add(listener);
	}

	public Cache getProgramCache()
	{
		return programCache;
	}

	public void registerFunction(String name, Function fn)
	{
		/*
		if (this.containTag(name)) {
			throw new RuntimeException("Function和Tag方法名不能重复:" + name);
		}
		*/
		this.fnMap.put(name, fn);
	}

	/**
	 * 注册一个function包，包名由packageName指定，方法名是对象o里的所有方法
	 * 如果方法定义为void，则方法返回null，如果方法参数最后一个Context，则传入一个Context
	 * 
	 * @param packageName
	 * @param o
	 */
	public void registerFunctionPackage(String packageName, Object o)
	{

		List<FunctionWrapper> list = FunctionWrapper.getFunctionWrapper(packageName, o);
		for (FunctionWrapper fw : list)
		{
			this.registerFunction(fw.functionName, fw);
		}

	}

	/**
	 * 注册一个自定义格式化函数，参考{@link org.bee.tl.ext.DateFormat}
	 * 
	 * @param name
	 * @param format
	 */
	public void registerFormat(String name, Format format)
	{

		this.formatMap.put(name, format);
	}

	public void registerDefaultFormat(Class type, Format format)
	{
		this.defaultFormatMap.put(type, format);
	}

	public Function getFunction(String name)
	{
		Function fn = fnMap.get(name);
		return fn;
	}

	public Format getFormat(String name)
	{
		return formatMap.get(name);
	}

	public Format getDefaultFormat(Class type)
	{
		return this.defaultFormatMap.get(type);

	}

	public void registerVirtualAttributeEval(VirtualAttributeEval e)
	{
		virtualAttributeList.add(e);

	}

	public VirtualAttributeEval getVirtualAttributeEval(Class c, String attributeName)
	{
		for (VirtualAttributeEval eval : virtualAttributeList)
		{
			if (eval.isSupport(c, attributeName))
			{
				return eval;
			}
		}
		return null;
	}

	/** 通过class的简单名字找到class
	 * @param simpleName
	 * @return
	 */
	public Class loadClassBySimpleName(String simpleName)
	{
		return this.classSearch.getClassByName(simpleName);
	}

}
