package org.beetl.sample.s01;

import org.beetl.core.User;
import org.beetl.core.resolver.AttributeAccess;


public class Test extends AttributeAccess{

	@Override
	public Object value(Object o, Object name) {
		// TODO Auto-generated method stub
		return ((User) o).getAge();
	}
   
}
