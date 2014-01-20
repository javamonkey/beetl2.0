package org.beetl.core.event;

public class Event
{
	Object event = null;

	public Event(Object eventTarget)
	{
		this.event = eventTarget;
	}

	public Object getEventTaget()
	{
		return event;
	}
}
