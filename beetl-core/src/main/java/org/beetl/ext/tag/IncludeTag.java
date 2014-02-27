package org.beetl.ext.tag;

import java.util.Map;
import java.util.Map.Entry;

import org.beetl.core.ByteWriter;
import org.beetl.core.Tag;
import org.beetl.core.Template;

public class IncludeTag extends Tag
{

	@Override
	public void render()
	{
		String resourceId = (String) this.args[0];
		Template t = this.group.getTemplate(resourceId);
		//快速复制父模板的变量
		t.binding(this.ctx.globalVar);
		if (ctx.objectKeys != null && ctx.objectKeys.size() != 0)
		{
			t.dynamic(ctx.objectKeys);
		}

		if (this.args.length == 2)
		{
			Map<String, Object> map = (Map<String, Object>) this.args[1];
			for (Entry<String, Object> entry : map.entrySet())
			{
				t.binding((String) entry.getKey(), entry.getValue());
			}

		}

		ByteWriter bw = ctx.byteWriter;
		t.renderTo(bw);

	}

}
