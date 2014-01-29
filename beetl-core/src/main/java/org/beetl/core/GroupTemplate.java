package org.beetl.core;

import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
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

	}

	protected void initTag()
	{

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

	public Function getFunction(String name)
	{
		Function fn = fnMap.get(name);
		return fn;
	}

}
