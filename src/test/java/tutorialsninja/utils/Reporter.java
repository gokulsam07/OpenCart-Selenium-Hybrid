package tutorialsninja.utils;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Reporter {

	public static ExtentReports generateReport() {
		ExtentReports report = new ExtentReports();
		File reportFile = new File("C:\\OpenCart\\tutorialsninja\\Reports\\report.html");
		ExtentSparkReporter spark = new ExtentSparkReporter(reportFile);
		spark.config().setTheme(Theme.DARK);
		spark.config().setReportName("Tutorials Ninja Test Automation Report");
		spark.config().setDocumentTitle("Automation Report");
		spark.config().setTimeStampFormat("DD-MM-YYYY HH:MM:SS");
		report.attachReporter(spark);

		Properties prop = new Properties();
		try {
			File propFile = new File("C:\\tutorialsninja\\src\\test\\java\\browser\\setup\\config.properties");
			FileInputStream fis = new FileInputStream(propFile);
			prop.load(fis);
		} catch (Exception e) {
			e.printStackTrace();
		}

		report.setSystemInfo("Application URL", prop.getProperty("url"));
		report.setSystemInfo("Browser", prop.getProperty("browserName"));
		report.setSystemInfo("Username", prop.getProperty("username"));
		report.setSystemInfo("Password", prop.getProperty("password"));
		report.setSystemInfo("OS", System.getProperty("os.name"));
		return report;
	}
}
