package com.tutorialsninja.tests;


import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tutorialsninja.pageobjects.HomePage;
import com.tutorialsninja.pageobjects.StorePage;
import com.tutorialsninja.pageobjects.CategoryRibbon.CategoryRibbon;

import browser.setup.InitializeBrowserAndOpenWebsite;

public class SearchProduct extends InitializeBrowserAndOpenWebsite{
	public WebDriver driver; //Why declared public? Otherwise SS failure won't get the driver since it is from a different package

	@BeforeMethod
	public void setup() {
		driver =setupBrowser(loadProperties().getProperty("browserName"));
	}
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

	@Test(priority=1)
	public void searchandFindMac() {

		CategoryRibbon catRib = new CategoryRibbon(driver);
		catRib.selectDesktop();
		catRib.selectMacList();
		Assert.assertTrue(catRib.isMacProductDisplayed());
	}

	@Test(priority=2)
	public void searchInvalid() {
		HomePage homePage = new HomePage(driver);
		StorePage storePage = new StorePage(driver);
		homePage.EnterProductName(loadDataProperties().getProperty("product"));
	    homePage.clickSearchButton();
		Assert.assertTrue(storePage.noProductAvailableIsDisplayed(), "No product available");
	}
	

}
