package com.beetl.test.junit;

import junit.framework.Test;
import junit.framework.TestSuite;

import com.beetl.test.junit.exp.BigNumberTest;

public class AllTests {

	public static Test suite() {

		TestSuite suite = new TestSuite("Test for org.beetl.testcase");
		// $JUnit-BEGIN$
		suite.addTestSuite(BigNumberTest.class);

		// $JUnit-END$
		return suite;
	}

}
