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

public class ComponentsTest extends InitializeBrowserAndOpenWebsite {

	public WebDriver driver;
	private CategoryRibbon catRib;
	private HomePage homePage;

	@BeforeMethod
	public void setUp() {
		driver =setupBrowser(loadProperties().getProperty("browserName"));
		catRib= new CategoryRibbon(driver);
	}


	@Test(priority=1)
	public void miceTest() {
	 homePage = catRib.selectComponents().selectComponentType(loadDataProperties().getProperty("c1")).clickOnContinue();
		Assert.assertEquals(true, homePage.isSliderVisible());

	}

	@Test(priority=2)
	public void monitorTest() {
		Assert.assertEquals(true, catRib.selectComponents().selectComponentType(loadDataProperties().getProperty("c2")).isProductDisplayed(loadDataProperties().getProperty("apple")));
	}
	@Test(priority=3)
	public void printerTest() {
		 homePage =catRib.selectComponents().selectComponentType(loadDataProperties().getProperty("c4")).clickOnContinue();
		Assert.assertEquals(true, homePage.isSliderVisible());
	}

	@Test(priority=4)
	public void scannerTest() {
		 homePage =catRib.selectComponents().selectComponentType(loadDataProperties().getProperty("c4")).clickOnContinue();
		Assert.assertEquals(true, homePage.isSliderVisible());
	}
	@Test(priority=5)
	public void webCameraTest() {
		 homePage =catRib.selectComponents().selectComponentType(loadDataProperties().getProperty("c5")).clickOnContinue();
		Assert.assertEquals(true, homePage.isSliderVisible());
	}

	@Test(priority=6)
	public void checkIfAllComponentsIsDisplayed() {
		StorePage allComponents =(StorePage) catRib.selectComponents().selectComponentType(loadDataProperties().getProperty("c6"));
		Assert.assertEquals(true, allComponents.isAllComponentsDisplayed());
	}


	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
