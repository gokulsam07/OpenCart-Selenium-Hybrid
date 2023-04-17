package com.tutorialsninja.tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tutorialsninja.pageobjects.CategoryRibbon.CategoryRibbon;
import com.tutorialsninja.pageobjects.IndividualCategoryPages.PhonesPage;
import browser.setup.InitializeBrowserAndOpenWebsite;

public class PhonesTest extends InitializeBrowserAndOpenWebsite {
	public WebDriver driver;
	PhonesPage phonesPage;
	

	@BeforeMethod
	public void setup() {
		driver =setupBrowser(loadProperties().getProperty("browserName"));
		CategoryRibbon catRib = new CategoryRibbon(driver);
		phonesPage = catRib.selectPhones();

	}

	@Test(priority=1,enabled=true)
	public void checkIfTabletsPageIsDisplayed() {
		Assert.assertEquals(true, phonesPage.verifyIfFocusInPhonesPage());
	}
	
	@Test(priority=2, enabled=true)
	public void checkIfListedProdctCountEqualsDisplayed(){
		Assert.assertEquals(true, phonesPage.IsDisplayValueEqualsActualCount());
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
