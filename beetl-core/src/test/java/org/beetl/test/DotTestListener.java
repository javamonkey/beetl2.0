package org.beetl.test;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

public class DotTestListener extends TestListenerAdapter {
	private int m_count = 0;

	@Override
	public void onTestFailure(ITestResult tr) {
		log("F");
	}

	@Override
	public void onTestSkipped(ITestResult tr) {
		log("S");
	}

	@Override
	public void onTestSuccess(ITestResult tr) {
		log(".");
	}

	@Override
	public void onFinish(ITestContext testContext) {
		log("\n");
	}

	private void log(String string) {
		System.out.print(string);
		if (++m_count % 40 == 0) {
			System.out.println("");
		}
	}
}