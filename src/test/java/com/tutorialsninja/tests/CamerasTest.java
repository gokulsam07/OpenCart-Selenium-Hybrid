package com.tutorialsninja.tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tutorialsninja.pageobjects.CategoryRibbon.CategoryRibbon;
import com.tutorialsninja.pageobjects.IndividualCategoryPages.CameraPage;
import browser.setup.InitializeBrowserAndOpenWebsite;

public class CamerasTest extends InitializeBrowserAndOpenWebsite {
	public WebDriver driver;
	CameraPage cameraPage;
	

	@BeforeMethod
	public void setup() {
		driver =setupBrowser(loadProperties().getProperty("browserName"));
		CategoryRibbon catRib = new CategoryRibbon(driver);
		cameraPage = catRib.selectCameras();

	}

	@Test(priority=1,enabled=true)
	public void checkIfTabletsPageIsDisplayed() {
		Assert.assertEquals(true, cameraPage.verifyIfFocusInCameraPage());
	}
	
	@Test(priority=2, enabled=true)
	public void checkIfListedProdctCountEqualsDisplayed(){
		Assert.assertEquals(true, cameraPage.IsDisplayValueEqualsActualCount());
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
