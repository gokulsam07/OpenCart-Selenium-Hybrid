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

public class Laptops_NotebooksTest extends InitializeBrowserAndOpenWebsite {

	public WebDriver driver;
	private CategoryRibbon catRib;
	private HomePage homePage;

	@BeforeMethod
	public void setUp() {
		driver =setupBrowser(loadProperties().getProperty("browserName"));
		catRib= new CategoryRibbon(driver);
	}


	@Test(priority=1,enabled=true)
	public void macTest() {
		homePage = catRib.selectLaptopAndNoteBook().selectlaptopOrNotebookType(loadDataProperties().getProperty("nb1")).clickOnContinue();
		Assert.assertEquals(true, homePage.isSliderVisible());

	}

	@Test(priority=2,enabled=true)
	public void windowsTest() {
		homePage = catRib.selectLaptopAndNoteBook().selectlaptopOrNotebookType(loadDataProperties().getProperty("nb2")).clickOnContinue();
		Assert.assertEquals(true, homePage.isSliderVisible());
	}

	@Test(priority=3,enabled=true)
	public void checkIfLap_NotebookPageIsDisplayed() {
		StorePage allNotebooks =(StorePage) catRib.selectLaptopAndNoteBook().selectlaptopOrNotebookType(loadDataProperties().getProperty("nb3"));
		Assert.assertEquals(true, allNotebooks.isAllLaptopsNotebboksDisplayed());
	}


	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
