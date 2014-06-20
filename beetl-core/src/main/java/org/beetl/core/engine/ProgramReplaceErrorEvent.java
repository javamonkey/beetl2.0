package org.beetl.core.engine;

import org.beetl.core.Event;

public class ProgramReplaceErrorEvent extends Event
{

	public ProgramReplaceErrorEvent(String resourceId, String errorDetail, Exception ex)
	{
		super(resourceId);
	}

}
