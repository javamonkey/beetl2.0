package org.beetl.core.statement.nat;

import org.beetl.core.statement.VarRef;

public class InstanceNode implements java.io.Serializable
{
	public VarRef ref;

	public InstanceNode(VarRef ref)
	{
		this.ref = ref;
	}
}