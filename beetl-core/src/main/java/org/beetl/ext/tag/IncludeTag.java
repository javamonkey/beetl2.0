package org.beetl.ext.tag;

import java.util.Map;
import java.util.Map.Entry;

import org.beetl.core.ByteWriter;
import org.beetl.core.Tag;
import org.beetl.core.Template;
import org.beetl.core.util.BeetlUtil;

public class IncludeTag extends Tag
{

	@Override
	public void render()
	{
		String resourceId = BeetlUtil.getRelPath(ctx.getResourceId(), (String) this.args[0]);
		;

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

	protected String getRelResourceId()
	{

		String resourceId = ((String) this.args[0]);
		String relResourceId = null;
		if (resourceId != null && resourceId.length() != 0)
		{
			char cs = resourceId.charAt(0);
			if (!(cs == '\\' || cs == '/'))
			{
				//相对路径
				String siblings = this.ctx.getResourceId();
				int i = siblings.length() - 1;
				for (; i > 0; i--)
				{
					char c = siblings.charAt(i);
					if (c == '\\' || c == '/')
					{
						break;
					}
				}

				String parent = siblings.substring(0, i + 1);

				relResourceId = parent.concat(resourceId);
			}
			else
			{
				relResourceId = resourceId;
			}
			if (BeetlUtil.isOutsideOfRoot(relResourceId))
			{
				throw new RuntimeException("不能访问外部文件或者模板");
			}
			return relResourceId;
		}
		else
		{
			throw new RuntimeException("资源ID为空，参数错");
		}

	}
}
