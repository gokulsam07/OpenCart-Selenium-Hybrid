package com.tutorialsninja.tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tutorialsninja.pageobjects.CategoryRibbon.CategoryRibbon;
import com.tutorialsninja.pageobjects.IndividualCategoryPages.SoftwarePage;


import browser.setup.InitializeBrowserAndOpenWebsite;

public class SoftwaresTest extends InitializeBrowserAndOpenWebsite {
	public WebDriver driver;
	SoftwarePage softwaresPage;
	

	@BeforeMethod
	public void setup() {
		driver =setupBrowser(loadProperties().getProperty("browserName"));
		CategoryRibbon catRib = new CategoryRibbon(driver);
		 softwaresPage = catRib.selectSoftwares();

	}

	@Test(priority=1,enabled=true)
	public void checkIfTabletsPageIsDisplayed() {
		Assert.assertEquals(true, softwaresPage.verifyIfFocusInSoftwarePage());
	}
	
	@Test(priority=2, enabled=true)
	public void checkIfListedProdctCountEqualsDisplayed(){
		Assert.assertEquals(true, softwaresPage.IsDisplayValueEqualsActualCount());
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
