package com.tutorialsninja.tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tutorialsninja.pageobjects.ProductComparisonPage;
import com.tutorialsninja.pageobjects.CategoryRibbon.CategoryRibbon;

import browser.setup.InitializeBrowserAndOpenWebsite;

public class ComparisonTest extends InitializeBrowserAndOpenWebsite {

	public WebDriver driver;
	CategoryRibbon catRib;

	@BeforeMethod
	public void setUp() {
		driver =setupBrowser(loadProperties().getProperty("browserName"));
	}


	@Test(priority=1,enabled=true)
	public void checkEmptyProductComparisonPage() {
		driver.get(loadDataProperties().getProperty("pdtCmpURL"));
		ProductComparisonPage cmpPage = new ProductComparisonPage(driver);
		Assert.assertEquals(true, cmpPage.emptyPdtPageElementIsDisplayed(loadDataProperties().getProperty("noPdt")));
	}

	@Test(priority=2,enabled=true)
	public void checkAfterAddingProductsToCmpPage() throws InterruptedException {
		driver.get(loadDataProperties().getProperty("pdtCmpURL"));
		ProductComparisonPage cmpPage = new ProductComparisonPage(driver);
		cmpPage.startComparison();
		cmpPage.addToCmpPageAndRedirectToCmpPage();		
		Assert.assertEquals(true, cmpPage.verifyAfterPdtAddition());
	}

	@Test(priority=3,enabled=true)
	public void addAndRemoveFromComparePageVeification() throws InterruptedException {
		driver.get(loadDataProperties().getProperty("pdtCmpURL"));
		ProductComparisonPage cmpPage = new ProductComparisonPage(driver);
		cmpPage.startComparison();
		cmpPage.addToCmpPageAndRedirectToCmpPage();	
		cmpPage.goToPdtComparisonPageAfterAddAndRemove();
		Assert.assertEquals(true, cmpPage.emptyPdtPageElementIsDisplayed(loadDataProperties().getProperty("noPdt")));
	}


	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
