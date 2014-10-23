package org.beetl.core.engine;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.beetl.core.Context;
import org.beetl.core.Listener;
import org.beetl.core.cache.Cache;
import org.beetl.core.statement.VarRef;

/**
 * 子类可继承此类，重载getMore，以及handleMore
 * @author joelli
 *
 */
public class BasicProgramOptProbe extends Probe
{

	Cache cache = null;

	protected Map<Class, Listener> initProbeNode()
	{
		Map<Class, Listener> map = new HashMap<Class, Listener>();
		map.put(VarRef.class, new VarAttributeNodeListener());
		//map.put(ForStatement.class, new ForNodeListener());
		return map;

	}

	@Override
	public void check(Context ctx)
	{
		StatementParser seacher = new StatementParser(program.metaData.statements, program.gt, program.res.getId());
		Map<Class, Listener> map = initProbeNode();
		for (Entry<Class, Listener> entry : map.entrySet())
		{
			seacher.addListener(entry.getKey(), entry.getValue());
		}

		this.initProbeNode();
		seacher.parse();
		this.program.gt.getProgramCache().set(program.res.getId(), program);
		ProgramReplaceEvent event = new ProgramReplaceEvent(program);
		this.program.gt.fireEvent(event);

	}

	/**
	 * 子类可以继承
	 */
	protected void addMore(StatementParser parser)
	{

	}

}
