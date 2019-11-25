package com.prestashop.Listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class PrestaListeners implements ITestListener{

	@Override
	public void onFinish(ITestContext result) {
		System.out.println("Test cases Finished Time >>:: "+result.getName());
		System.out.println("Finish time >> "+new java.util.Date());
		
	}

	@Override
	public void onStart(ITestContext result) {
		System.out.println("Test cases Start Time >>:: "+result.getName());
		System.out.println("Start Time >> "+new java.util.Date());
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailure(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestSkipped(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestStart(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestSuccess(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

}
