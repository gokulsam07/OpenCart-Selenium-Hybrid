package com.tutorialsninja.tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tutorialsninja.pageobjects.HomePage;
import com.tutorialsninja.pageobjects.LoginPage;
import com.tutorialsninja.pageobjects.ShoppingcartPage;

import browser.setup.InitializeBrowserAndOpenWebsite;

public class TopRibbonTest extends InitializeBrowserAndOpenWebsite {
	public WebDriver driver;
	private ShoppingcartPage shoppingCartPage;
	private HomePage homePage ;
	private LoginPage loginPage;



	@BeforeMethod
	public void setUp() {
		driver =setupBrowser(loadProperties().getProperty("browserName"));
		homePage = new HomePage(driver);
	}


	@Test(priority=1)
	public void testEmptyShoppingCartFocus() {
		shoppingCartPage = homePage.clickShoppingCart();
		Assert.assertEquals("Your shopping cart is empty!", shoppingCartPage.checkIfFocusInShoppingCart());

	}

	@Test(priority=2)
	public void testEmptyShoppingCartRedirection() {
		shoppingCartPage = homePage.clickShoppingCart();
		homePage = shoppingCartPage.clickContinueInEmptyCart();
		Assert.assertEquals(true, homePage.isSliderVisible());
	}

	@Test(priority=3)
	public void testEmptyWishlistFocus(){
		loginPage = homePage.clickWishlistwithoutLogin();
		Assert.assertEquals(loginPage.isRegisterDetailsDisplayedInLoginPage(),true);
	}

	@Test(priority=4)
	public void cartButtonTest() {
		Assert.assertEquals(true, homePage.clickBtnCart());
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
