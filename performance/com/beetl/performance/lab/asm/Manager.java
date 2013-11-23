package com.beetl.performance.lab.asm;

import com.beetl.performance.lab.User;

public class Manager  extends User{
	@Override
	public Manager getPeer(){
		return new Manager();
	}
}
