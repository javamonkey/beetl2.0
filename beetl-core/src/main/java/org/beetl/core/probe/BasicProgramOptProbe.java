package org.beetl.core.probe;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.beetl.core.Context;
import org.beetl.core.cache.Cache;
import org.beetl.core.event.ForNodeListener;
import org.beetl.core.event.Listener;
import org.beetl.core.event.ProgramReplaceEvent;
import org.beetl.core.event.VarAttributeNodeListener;
import org.beetl.core.statement.ForStatement;
import org.beetl.core.statement.Program;
import org.beetl.core.statement.VarRef;

/**
 * 子类可继承此类，重载getMore，以及handleMore
 * @author joelli
 *
 */
public class BasicProgramOptProbe extends Probe
{

	Cache cache = null;

	public BasicProgramOptProbe(Program program)
	{
		super(program);

	}

	protected Map<Class, Listener> initProbeNode()
	{
		Map<Class, Listener> map = new HashMap<Class, Listener>();
		map.put(VarRef.class, new VarAttributeNodeListener());
		map.put(ForStatement.class, new ForNodeListener());
		return map;

	}

	@Override
	public void check(Context ctx)
	{
		StatementParser seacher = new StatementParser(program.metaData.statements);
		Map<Class, Listener> map = initProbeNode();
		for (Entry<Class, Listener> entry : map.entrySet())
		{
			seacher.addListener(entry.getKey(), entry.getValue());
		}

		this.initProbeNode();
		seacher.parse();
		this.program.gt.getProgramCache().set(program.id, program);
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
