package com.tutorialsninja.tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.tutorialsninja.pageobjects.HomePage;
import com.tutorialsninja.pageobjects.RegisterPage;
import browser.setup.InitializeBrowserAndOpenWebsite;
import tutorialsninja.utils.Utilities;


public class RegisterTest extends InitializeBrowserAndOpenWebsite {
	public WebDriver driver;

	@BeforeMethod
	public void setup() {
		driver =setupBrowser(loadProperties().getProperty("browserName"));
		HomePage homePage = new HomePage(driver);
		homePage.ClickOnMyAccount();
		homePage.ClickOnRegister();

	}
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	@Test(priority=1)
	public void RegisterWithMandatoryFields() {
		RegisterPage registerPage = new RegisterPage(driver);
		registerPage.enterFirstName(loadDataProperties().getProperty("firstName"));
		registerPage.enterLastName(loadDataProperties().getProperty("lastName"));
		registerPage.enterEmail(Utilities.generateTimeStamp());
		registerPage.enterTelephone(loadDataProperties().getProperty("telephone"));
		registerPage.enterPassword(loadDataProperties().getProperty("password"));
		registerPage.confirmPassword(loadDataProperties().getProperty("password"));
		registerPage.agreePolicy();
		registerPage.save();
		Assert.assertEquals(registerPage.confirmationMessageIsDisplayed(), loadDataProperties().getProperty("accountCreatedMessage"));


	}

	@Test(priority=2)
	public void RegisterWithPreRegisteredEmail() {

		RegisterPage registerPage = new RegisterPage(driver);
		registerPage.enterFirstName(loadDataProperties().getProperty("firstName"));
		registerPage.enterLastName(loadDataProperties().getProperty("lastName"));
		registerPage.enterEmail(loadProperties().getProperty("username"));
		registerPage.enterTelephone(loadDataProperties().getProperty("telephone"));
		registerPage.enterPassword(loadDataProperties().getProperty("password"));
		registerPage.confirmPassword(loadDataProperties().getProperty("password"));
		registerPage.agreePolicy();
		registerPage.save();
		Assert.assertEquals(registerPage.isErrorDisplayedForPreConfiguredMail(), loadDataProperties().getProperty("emailPreConfigured"));


	}

	@Test(priority=3)
	public void RegisterWithoutMandatoryFields() {
		RegisterPage registerPage = new RegisterPage(driver);
		registerPage.save();

		Assert.assertEquals(registerPage.isErrorDisplayedForfirstName(), loadDataProperties().getProperty("fnError"));
		Assert.assertEquals(registerPage.isErrorDisplayedForlastName(), loadDataProperties().getProperty("lnError"));
		Assert.assertEquals(registerPage.isErrorDisplayedForEmail(), loadDataProperties().getProperty("eError"));
		Assert.assertEquals(registerPage.isErrorDisplayedFortelephone(), loadDataProperties().getProperty("tError"));
		Assert.assertEquals(registerPage.isErrorDisplayedForpassword(), loadDataProperties().getProperty("pasError"));
		Assert.assertEquals(registerPage.isErrorDisplayedForpolicy(), loadDataProperties().getProperty("policyError"));
	}
}
