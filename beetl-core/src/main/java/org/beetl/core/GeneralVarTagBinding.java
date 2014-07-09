package org.beetl.core;

import java.util.Map;

public abstract class GeneralVarTagBinding extends Tag implements TagVarBinding
{
	private Map<String, Integer> name2Index = null;

	@Override
	public Object[] bindVars()
	{
		// TODO Auto-generated method stub
		return null;
	}

	public void mapName2Index(Map<String, Integer> map)
	{
		name2Index = map;
	}

	protected void bind(String name, Object value)
	{
		if (name2Index == null)
		{
			throw new RuntimeException();
		}
		Integer index = name2Index.get(name);
		if (index == null)
		{
			throw new RuntimeException();
		}
		ctx.vars[index] = value;
	}

}
