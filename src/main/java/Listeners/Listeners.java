package Listeners;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import Resources.Base;
import utilities.ExtentRepoter;

public class Listeners extends Base implements ITestListener {

	public WebDriver driver = null;
	ExtentReports extentReport = ExtentRepoter.getExtentReport();
	ExtentTest extentTest;
	ThreadLocal<ExtentTest> extentTestThread = new ThreadLocal<ExtentTest>();

	@Override
	public void onTestStart(ITestResult result) {

		String testName = result.getMethod().getMethodName();
		// String testName = result.getTestName();
		extentTest = extentReport.createTest(testName + "Execution Started");
		extentTestThread.set(extentTest);

	}

	@Override
	public void onTestSuccess(ITestResult result) {

		String testName = result.getMethod().getMethodName();
		// String testName = result.getName();
		//extentTest.log(Status.PASS, testName + "got passed");
		extentTestThread.get().log(Status.PASS, testName + "got passed");

	}

	@Override
	public void onTestFailure(ITestResult result) {
	    // extentTest.fail(result.getThrowable());
	    extentTestThread.get().fail(result.getThrowable());

	    // Get the name of the test that failed
	    String testName = result.getMethod().getMethodName();

	    try {
	        // Retrieve the WebDriver instance from the test class using reflection
	        driver = (WebDriver) result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
	    } catch (Exception e) {
	        e.printStackTrace(); // Print the stack trace if there's an error retrieving the WebDriver
	    }

	    try {
	        // Take a screenshot using the WebDriver instance
	        String screenshotFilePath = takeScreenshot(testName, driver);
	        
	        // Add the screenshot to the report
	        extentTestThread.get().addScreenCaptureFromPath(screenshotFilePath, testName);
	    } catch (IOException e) {
	        e.printStackTrace(); // Print the stack trace if there's an error taking the screenshot
	    }
	}


	@Override
	public void onTestSkipped(ITestResult result) {

	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {

	}

	@Override
	public void onStart(ITestContext context) {

	}

	@Override
	public void onFinish(ITestContext context) {

		extentReport.flush();

	}

}
