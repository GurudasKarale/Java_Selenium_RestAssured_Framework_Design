package com.Utility;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class TestListenerss extends BaseClass implements ITestListener {


	ExtentTest test;
	ExtentReports extent = ReporterUtil.getReportObject();
	
	@Override
	public void onTestStart(ITestResult result) {
		
		test = extent.createTest(result.getMethod().getMethodName());
		
	}
	
	@Override
	public void onTestSuccess(ITestResult result) {
		
		test.log(Status.PASS,"Test passed");
		
	}
	
	@Override
	public void onTestFailure(ITestResult result)  {
		
		test.fail(result.getThrowable());
		
		//reason behind getting takescreenshot null was driver was not declared public
		try {
			driver = (WebDriver)result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
			//filepath = getScreenshot(result.getMethod().getMethodName(),driver);
			System.out.println("------------->>>"+driver);
		} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		String filepath = null;
		try {
			 filepath = getScreenshot(result.getMethod().getMethodName(),driver);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		test.addScreenCaptureFromPath(filepath,result.getMethod().getMethodName());
	}
	
	@Override
	public void onFinish(ITestContext context) {
		extent.flush();
	}
	
}
