package com.vocalize.testcases;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.qa.base.Testbase;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;


public class CustomListners extends Testbase implements ITestListener {
	public ExtentReports extent;
	public ExtentTest extentTest;
	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("Failed Test case");
		failed(result.getMethod().getMethodName());
		//extentTest.log(LogStatus.FAIL, "TEST CASE FAILED IS "+result.getName()); //to add name in extent report
		//extentTest.log(LogStatus.FAIL, "TEST CASE FAILED IS "+result.getThrowable()); //to add error/exception in extent report
		//extentTest.log(LogStatus.FAIL, extentTest.addScreenCapture("C:\\Users\\DELL\\git\\VOCALZIE-GIT\\Hybrid_framework\\src\\test\\java\\com\\failed\\screen_shots\\fail_"+testMethodName+"_"+".jpg")); //to add screenshot in extent report
		//extentTest.log(LogStatus.FAIL, extentTest.addScreenCapture(screenshotPath)); //to add screenshot in extent report
		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		String screenshotPath="C:\\Users\\DELL\\git\\VOCALZIE-GIT\\Hybrid_framework\\src\\test\\java\\com\\failed\\screen_shots\\fail_"+ dateName+".jpg";
		extentTest.log(LogStatus.FAIL, extentTest.addScreenCapture(screenshotPath));
		
	
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

}
