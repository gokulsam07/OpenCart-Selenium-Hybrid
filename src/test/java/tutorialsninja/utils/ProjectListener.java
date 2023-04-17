package tutorialsninja.utils;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class ProjectListener implements ITestListener {
	ExtentReports report;
	WebDriver driver;
	@Override
	public void onStart(ITestContext context) {
		report =Reporter.generateReport();
	}
	@Override
	public void onTestStart(ITestResult result) {

		ExtentTest extentTest = report.createTest(result.getName().toString());
		extentTest.log(Status.INFO, result.getName().toString()+ " started executing");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		ExtentTest extentTest = report.createTest(result.getName().toString());
		extentTest.log(Status.PASS, result.getName().toString()+ "  passed");
	}

	@Override
	public void onTestFailure(ITestResult result) {

		try {
			driver = (WebDriver) result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
		} catch (Exception e) {
			e.printStackTrace();
		}
		String destination = Utilities.takeScreenshot(driver, result.getName().toString());


		ExtentTest extentTest = report.createTest(result.getName().toString());
		extentTest.addScreenCaptureFromPath(destination);
		extentTest.log(Status.INFO, result.getThrowable());
		extentTest.log(Status.FAIL, result.getName().toString()+ "  failed");
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		ExtentTest extentTest = report.createTest(result.getName().toString());
		extentTest.log(Status.INFO, result.getThrowable());
		extentTest.log(Status.SKIP, result.getName().toString()+ "  skipped");
	}


	@Override
	public void onFinish(ITestContext context) {
		report.flush();
		File open = new File("C:\\OpenCart\\tutorialsninja\\Reports\\report.html");
		try {
			Desktop.getDesktop().browse(open.toURI());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
