package org.beetl.core.lab;

import java.util.ArrayList;
import java.util.List;

import org.beetl.core.GeneralVarTagBinding;

public class TestGeneralVarTagBinding extends GeneralVarTagBinding
{

	int count = 0;

	@Override
	public void render()
	{
		MenuItem i1 = new MenuItem("第一季");
		MenuItem i2 = new MenuItem("第二季");
		List list = new ArrayList();
		list.add(i1);
		list.add(i2);

		for (int i = 0; i < list.size(); i++)
		{
			MenuItem lexicon = (MenuItem) list.get(i);
			List<MenuItem> lexiconsList = lexicon.getList();
			this.bind("menu", lexicon);

			this.bind("index", i);
			int size = lexiconsList.size();
			for (int k = 0; k < size; k++)
			{
				this.bind("imenu", lexiconsList.get(k));
				this.doBodyRender();
			}

			this.doBodyRender();
		}
	}

	public void doBodyRender()
	{
		super.doBodyRender();
		count++;
	}

}
