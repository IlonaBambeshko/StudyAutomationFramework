package com.stormnet.listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import utility.logerator.Logger;

public class CustomTestNgListener implements ITestListener {
	@Override
	public void onTestSuccess(ITestResult result) {
		Logger.getLogger().info("Test {} finished. ", result.getTestName());
	}

	@Override
	public void onTestFailure(ITestResult result) {
		Logger.getLogger().error("Test {} finished. STATUS: FAILED", result.getTestName(), result.getThrowable());
	}

	@Override
	public void onStart(ITestContext context) {
		Logger.getLogger().debug("On start method called");
	}
}
