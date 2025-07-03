package genericUtility.Practice;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.logging.FileHandler;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.slf4j.helpers.Reporter;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.google.common.io.Files;

public class ListenerImplementation implements ITestListener, ISuiteListener {
	
		public ExtentReports report;
		public static ExtentTest test;
		
	@Override
	public void onStart(ISuite suite) {
		// TODO Auto-generated method stub
		ISuiteListener.super.onStart(suite);
		System.out.println("<===== ON START =====>"+suite.getName());
		
		String timeStamp = new Date().toString().replace(" ","-").replace(":", "-");
		
		ExtentSparkReporter spark = new ExtentSparkReporter(".\\Advance Reports\\ReportDemo"+timeStamp+".html");
		spark.config().setDocumentTitle("Detailed Test Report");
		spark.config().setReportName("Report"+timeStamp);
		spark.config().setTheme(Theme.DARK);
		
		report = new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("OS", "windows 11");
		report.setSystemInfo("Browser", "chrome 133");
	}

	@Override
	public void onFinish(ISuite suite) {
		// TODO Auto-generated method stub
		ISuiteListener.super.onFinish(suite);
		System.out.println("<===== ON FINISH =====>"+suite.getName());
		report.flush();
	}

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestStart(result);
		System.out.println("<===== =====>"+result.getMethod().getMethodName()+"<===== TEST STARTED =====>");
		
		test = report.createTest(result.getMethod().getMethodName()+"ON TEST START");
		ThreadUtility.setTest(test);
		ThreadUtility.getTest().log(Status.INFO, result.getMethod().getMethodName()+"ON TEST START");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestSuccess(result);
		System.out.println("<===== =====>"+result.getMethod().getMethodName()+"<===== ON TEST END =====>");
		ThreadUtility.getTest().log(Status.INFO, result.getMethod().getMethodName()+"<==== TEST SUCCESS ====>");
		}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailure(result);
		String methodName = result.getMethod().getMethodName();
		
		String timeStamp = new Date().toString().replace(" ","-").replace(":", "-");
		TakesScreenshot ts = (TakesScreenshot)BaseClassPractice.sdriver;
		String src = ts.getScreenshotAs(OutputType.BASE64);
		File dest = new File(".\\Screenshots"+"ErrorFile"+timeStamp+".html");
//		try {
//			Files.copy(src, dest);
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		ThreadUtility.getTest().log(Status.INFO, result.getMethod().getMethodName()+ "<===== ON TEST FAILURE ====>");
		ThreadUtility.getTest().info(MarkupHelper.createLabel("FAIL", ExtentColor.RED));
		ThreadUtility.getTest().log(Status.FAIL, result.getThrowable());
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestSkipped(result);
		System.out.println("<==== TEST HAS SKIPPED ====>");
		ThreadUtility.getTest().log(Status.INFO, result.getMethod().getMethodName()+"<==== TEST HAS SKIPPED ====>");
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
		
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedWithTimeout(result);
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		ITestListener.super.onStart(context);
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		ITestListener.super.onFinish(context);
	}
	
	

}
