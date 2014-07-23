package org.beetl.core.lab;

import java.util.ArrayList;
import java.util.List;

public class MenuItem
{
	String name;
	List<MenuItem> list = new ArrayList<MenuItem>();

	public MenuItem(String name)
	{
		this.name = name;
		for (int i = 0; i < 2; i++)
		{
			MenuItem sub = new MenuItem(name + "_" + i, false);
			list.add(sub);
		}
	}

	public MenuItem(String name, boolean isFirst)
	{
		this.name = name;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public List<MenuItem> getList()
	{
		return list;
	}

	public void setList(List<MenuItem> list)
	{
		this.list = list;
	}

}
