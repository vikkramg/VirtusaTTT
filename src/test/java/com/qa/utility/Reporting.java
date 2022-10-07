package com.qa.utility;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.aventstack.extentreports.markuputils.MarkupHelper;

public class Reporting extends TestListenerAdapter
{
	public ExtentHtmlReporter htmlReporter;
	public ExtentReports xReports;
	public ExtentTest xTest;

	public void onStart(ITestContext testContext) {

		String dateStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		String repName = "Test-Automation-Report"+dateStamp+".html";

		htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir")+"/Reports/"+repName);
		htmlReporter.config().setDocumentTitle("Automation Report");
		htmlReporter.config().setReportName("Functional Test Report");
		htmlReporter.config().setTheme(Theme.DARK);
		htmlReporter.config().setAutoCreateRelativePathMedia(true);

		
		xReports = new ExtentReports();
		xReports.attachReporter(htmlReporter);
		xReports.setSystemInfo("hostName", "localhost");
		xReports.setSystemInfo("OS", "Windows");
		xReports.setSystemInfo("QA", "Vikkram");
		
		
	}

	public void onFinish(ITestContext testContext) {
		xReports.flush();

	}
	
	public void onTestSuccess(ITestResult tr) {
		xTest = xReports.createTest(tr.getName()); 
		xTest.log(Status.PASS, "Test is passed");
		xTest.log(Status.PASS,MarkupHelper.createLabel(tr.getName(), ExtentColor.GREEN));

	}
	public void onTestFailure(ITestResult tr) {
		xTest = xReports.createTest(tr.getName()); 
		xTest.log(Status.FAIL, "Test is failed");
		xTest.log(Status.FAIL, tr.getThrowable());
		xTest.log(Status.FAIL, MarkupHelper.createLabel(tr.getName(), ExtentColor.RED));
		
		String SSPath = System.getProperty("user.dir")+"/Screenshots/"+tr.getName()+".png";
		
		File file = new File(SSPath);
		if(file.exists()) {
			try {
				xTest.fail("The screenshot for test failed is : " + xTest.addScreenCaptureFromPath(SSPath));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		

	}

	public void onTestSkipped(ITestResult tr) {
		xTest = xReports.createTest(tr.getName());
		xTest.log(Status.SKIP, "Test is skipped");
		xTest.log(Status.SKIP, tr.getThrowable());
		xTest.log(Status.SKIP, MarkupHelper.createLabel(tr.getName(), ExtentColor.AMBER));


	}

}
