package org.beetl.core;

import junit.framework.Test;
import junit.framework.TestSuite;

import org.beetl.core.exp.BigNumberTest;

public class AllTests
{

	public static Test suite()
	{

		TestSuite suite = new TestSuite("Test for org.bee.testcase");
		//$JUnit-BEGIN$
		suite.addTestSuite(BigNumberTest.class);

		//$JUnit-END$
		return suite;
	}

}
