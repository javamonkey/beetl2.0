package org.beetl.core;

import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.beetl.core.cache.Cache;
import org.beetl.core.cache.ProgramCacheFactory;
import org.beetl.core.event.Event;
import org.beetl.core.event.Listener;
import org.beetl.core.exception.HTMLTagParserException;
import org.beetl.core.exception.TempException;
import org.beetl.core.statement.Program;
import org.beetl.core.util.ClassSearch;
import org.beetl.core.util.ObjectUtil;

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
	Map<Class, VirtualClassAttribute> virtualClass = new HashMap<Class, VirtualClassAttribute>();
	Map<String, TagFactory> tagFactoryMap = new HashMap<String, TagFactory>();
	ClassSearch classSearch = null;
	NativeSecurityManager nativeSecurity = null;

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
		engine = TemplateEngineFactory.getEngine(conf.getEngine());
		this.initFunction();
		this.initFormatter();
		this.initTag();
		this.initVirtual();
		classSearch = new ClassSearch(conf.getPkgList());
		nativeSecurity = (NativeSecurityManager) ObjectUtil.instnace(conf.getNativeSecurity());
	}

	protected void initFunction()
	{

		Map<String, String> fnMap = this.conf.fnMap;
		for (Entry<String, String> entry : fnMap.entrySet())
		{
			String name = entry.getKey();
			String clsName = entry.getValue();
			System.out.println(name);
			this.registerFunction(name, (Function) ObjectUtil.instnace(clsName));
		}

	}

	protected void initFormatter()
	{

		Map<String, String> formatMap = this.conf.formatMap;
		for (Entry<String, String> entry : formatMap.entrySet())
		{
			String name = entry.getKey();
			String clsName = entry.getValue();
			this.registerFormat(name, (Format) ObjectUtil.instnace(clsName));
		}

		Map<String, String> defaultFormatMap = this.conf.defaultFormatMap;
		Map<String, Format> temp = new HashMap<String, Format>();
		for (Entry<String, String> entry : defaultFormatMap.entrySet())
		{
			String defaultType = entry.getKey();
			String formatClass = entry.getValue();
			Format format = temp.get(formatClass);
			if (format == null)
			{
				format = (Format) ObjectUtil.instnace(formatClass);
				temp.put(formatClass, format);
			}
			this.registerDefaultFormat(ObjectUtil.getClassByName(defaultType), format);
		}

		//原始类型无法通过反射获取，因此不再配置文件里
		Format numberFormat = temp.get("org.beetl.ext.format.NumberFormat");
		this.registerDefaultFormat(short.class, numberFormat);
		this.registerDefaultFormat(long.class, numberFormat);
		this.registerDefaultFormat(int.class, numberFormat);
		this.registerDefaultFormat(float.class, numberFormat);
		this.registerDefaultFormat(double.class, numberFormat);

	}

	protected void initTag()
	{

		Map<String, String> tagMap = this.conf.tagMap;
		for (Entry<String, String> entry : tagMap.entrySet())
		{
			String name = entry.getKey();
			String clsName = entry.getValue();
			this.registerTag(name, ObjectUtil.getClassByName(clsName));
		}

		Map<String, String> tagFactoryMap = this.conf.tagFactoryMap;
		for (Entry<String, String> entry : tagFactoryMap.entrySet())
		{
			String name = entry.getKey();
			String clsName = entry.getValue();
			this.registerTagFactory(name, (TagFactory) ObjectUtil.instnace(clsName));
		}

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
		if (this.conf.isHtmlTagSupport())
		{
			sf.enableHtmlTagSupport(conf.getHtmlTagStart(), conf.getHtmlTagEnd());
		}
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

		Program program = engine.createProgram(res.getId(), scriptReader, sf.textMap, sf.lineSeparator, this);
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

	public void registerTag(String name, Class tagCls)
	{
		this.tagFactoryMap.put(name, new DefaultTagFactory(tagCls));
	}

	public void registerTagFactory(String name, TagFactory tagFactory)
	{
		this.tagFactoryMap.put(name, tagFactory);
	}

	public TagFactory getTagFactory(String name)
	{
		return this.tagFactoryMap.get(name);
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

	public void registerVirtualAttributeClass(Class cls, VirtualClassAttribute virtual)
	{
		this.virtualClass.put(cls, virtual);

	}

	public VirtualClassAttribute getVirtualAttributeEval(Class c, String attributeName)
	{

		VirtualClassAttribute attr = virtualClass.get(c);
		if (attr != null)
			return attr;

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

	public NativeSecurityManager getNativeSecurity()
	{
		return nativeSecurity;
	}

}
