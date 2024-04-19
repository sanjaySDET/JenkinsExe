package com.comcast.genericutlity;

import java.io.File;
import java.time.LocalDateTime;
import java.util.Random;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import net.bytebuddy.agent.builder.AgentBuilder.Identified.Extendable;

public class ListnerImplementation implements ITestListener{

	
	ExtentReports report;
	ExtentTest test;
	
	@Override
	public void onTestStart(ITestResult result) {
		test=report.createTest(result.getName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		test.log(Status.PASS, result.getMethod().getMethodName());
		test.log(Status.PASS, result.getThrowable());
	}

	@Override
	public void onTestFailure(ITestResult result) {
		test.log(Status.FAIL, result.getMethod().getMethodName());
		test.log(Status.FAIL, result.getThrowable());
		
		System.out.println("<--------I am Listening----------->");
		
		String screenShot = WebActionUtility.takeScreenShot(BaseClass.sdriver, result.getMethod().getMethodName());
		test.addScreenCaptureFromPath(screenShot);
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		test.log(Status.SKIP, result.getMethod().getMethodName());
		test.log(Status.SKIP, result.getThrowable());
	}

	@Override
	public void onStart(ITestContext context) {
		Random random = new Random();
		int randNum = random.nextInt(1000);
		
		ExtentSparkReporter spark = new ExtentSparkReporter("ExtentReport/Report.html"+randNum);
		spark.config().setTheme(Theme.DARK);
		spark.config().setDocumentTitle("ExtentReport");
		spark.config().setReportName("sanjay");
		
	    report=new ExtentReports();
	    report.attachReporter(spark);
	    report.setSystemInfo("platform", "windows10");
	    report.setSystemInfo("Execuited by", "sanjay");
	    report.setSystemInfo("reviewed By", "Deepak");
	}

	@Override
	public void onFinish(ITestContext context) {
		report.flush();
	}

}
