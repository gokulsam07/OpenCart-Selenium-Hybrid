package com.tutorialsninja.tests;


import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tutorialsninja.pageobjects.HomePage;
import com.tutorialsninja.pageobjects.StorePage;
import com.tutorialsninja.pageobjects.CategoryRibbon.CategoryRibbon;
import com.tutorialsninja.pageobjects.IndividualCategoryPages.ICommons;


import browser.setup.InitializeBrowserAndOpenWebsite;


public class DesktopTest extends InitializeBrowserAndOpenWebsite {

	public WebDriver driver;
	private CategoryRibbon catRib;
	private HomePage homePage;

	@BeforeMethod
	public void setUp() {
		driver =setupBrowser(loadProperties().getProperty("browserName"));
		catRib= new CategoryRibbon(driver);
	}


	@Test(priority=1)
	public void PCTest() {
		 homePage = catRib.selectDesktop().selectDesktopType(loadDataProperties().getProperty("typ1")).clickOnContinue();
		 Assert.assertEquals(true, homePage.isSliderVisible());

	}

	@Test(priority=2)
	public void MacTest() {
		ICommons macProduct = catRib.selectDesktop().selectDesktopType(loadDataProperties().getProperty("typ2"));
		Assert.assertEquals(true, macProduct.isProductDisplayed());

	}
	
	@Test(priority=3)
	public void checkIfDesktopPageIsDisplayed() {
		StorePage allDesktop =(StorePage) catRib.selectDesktop().selectDesktopType(loadDataProperties().getProperty("allD"));
		Assert.assertEquals(true, allDesktop.isAllDesktopsDisplayed());

	}


	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
