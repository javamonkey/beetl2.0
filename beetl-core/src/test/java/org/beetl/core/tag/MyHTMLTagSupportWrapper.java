package org.beetl.core.tag;

import java.io.File;

import org.beetl.ext.tag.HTMLTagSupportWrapper;

public class MyHTMLTagSupportWrapper extends HTMLTagSupportWrapper
{
	/*更改到tag目录下*/
	protected String getHtmlTagResourceId(String child)
	{
		String path = child.replace(':', File.separatorChar);
		return "/tag/" + path + ".tag";
	}
}
