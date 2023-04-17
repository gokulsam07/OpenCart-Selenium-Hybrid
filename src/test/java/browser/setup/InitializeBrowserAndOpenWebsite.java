package browser.setup;

import java.io.File;
import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import tutorialsninja.utils.Utilities;


public class InitializeBrowserAndOpenWebsite {
	WebDriver driver;
	public Properties prop;
	public Properties dataProp;

	public Properties loadProperties() {
		prop = new Properties();
		try {
			File file = new File("C:\\OpenCart\\tutorialsninja\\src\\test\\java\\browser\\setup\\config.properties");
			FileInputStream fis = new FileInputStream(file);
			prop.load(fis);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return prop;
	}
	
	public Properties loadDataProperties() {
		dataProp = new Properties();
		try {
			File file = new File("C:\\OpenCart\\tutorialsninja\\src\\test\\java\\testdata\\testdata.properties");
			FileInputStream fis = new FileInputStream(file);
			dataProp.load(fis);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dataProp;
	}

	public WebDriver setupBrowser(String browserName) {

		if(browserName.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		}
		else if(browserName.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		}
		else if(browserName.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Utilities.IMPLICIT_WAIT_TIME));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Utilities.PAGE_LOAD_TIME));
		driver.get(prop.getProperty("url"));
		return driver;
	}
}