package com.tutorialsninja.tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tutorialsninja.pageobjects.CategoryRibbon.CategoryRibbon;
import com.tutorialsninja.pageobjects.IndividualCategoryPages.TabletsPage;

import browser.setup.InitializeBrowserAndOpenWebsite;


public class TabletsTest extends InitializeBrowserAndOpenWebsite {
	public WebDriver driver;
	TabletsPage tabPage;

	@BeforeMethod
	public void setup() {
		driver =setupBrowser(loadProperties().getProperty("browserName"));
		CategoryRibbon catRib = new CategoryRibbon(driver);
		tabPage = catRib.selectTablets();

	}

	@Test(priority=1,enabled=true)
	public void checkIfTabletsPageIsDisplayed() {
		Assert.assertEquals(true, tabPage.verifyIfFocusInTabletsPage());
	}
	
	@Test(priority=2, enabled=true)
	public void checkIfListedProdctCountEqualsDisplayed(){
		Assert.assertEquals(true, tabPage.IsDisplayValueEqualsActualCount());
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
