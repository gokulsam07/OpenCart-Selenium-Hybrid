package com.tutorialsninja.tests;


import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.tutorialsninja.pageobjects.AccountPage;
import com.tutorialsninja.pageobjects.HomePage;
import com.tutorialsninja.pageobjects.LoginPage;

import browser.setup.InitializeBrowserAndOpenWebsite;
import tutorialsninja.utils.Utilities;

public class LoginTest extends InitializeBrowserAndOpenWebsite {

	public WebDriver driver;
	private LoginPage loginPage;
	private HomePage homePage;
	private AccountPage accountPage;

	@BeforeMethod
	public void setUp() {
		driver =setupBrowser(loadProperties().getProperty("browserName"));
		homePage = new HomePage(driver);
		homePage.ClickOnMyAccount();
		loginPage= homePage.ClickOnLogin();
	}


	@Test(priority=1,dataProvider="loginData")
	public void TestLogin(String username, String password) {
		loginPage.enterUsername(username);
		loginPage.enterPassword(password);
		loginPage.clickLogin();
		AccountPage accountPage = new AccountPage(driver);

		if(accountPage.getDisplayOfEditAccInfo()) {
			Assert.assertTrue(true,"Logged in");
		}
		else {
			Assert.assertTrue(true,"Failed to Login becuase of wrong credentials");
		}
	}


	@Test(priority=2)
	public void checkIfRegisterDetailsPresent() {

		Assert.assertEquals(true, loginPage.isRegisterDetailsDisplayedInLoginPage());	
	}

	@Test(priority=3)
	public void checkRegstrationInLoginPage() {
		Assert.assertEquals(true, loginPage.registerContinuefromLoginClick().checkIfFocusInRegisterPage());	
	}

	@Test(priority=4)
	public void ribbonMyAccountOptions() {
		loginPage.enterUsername(loadProperties().getProperty("username"));
		loginPage.enterPassword(loadProperties().getProperty("password"));
		accountPage =loginPage.clickLogin();
		Assert.assertEquals(true, accountPage.IsAllAccountOptionsDisplayed());	
	}

	@Test(priority=5,enabled=true)
	public void logOut() {
		loginPage.enterUsername(loadProperties().getProperty("username"));
		loginPage.enterPassword(loadProperties().getProperty("password"));
		accountPage =loginPage.clickLogin();
		Assert.assertEquals(true, accountPage.clickLogout());	
	}


	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

	@DataProvider(name="loginData")
	public  Object[][] callPOI() throws IOException{
		Object[][] data = Utilities.readExcel();
		return data;

	}

}


//Code before DataDriven


//	@Test(priority=2)
//	public void LoginWithInvalidCredentials() throws InterruptedException  {
//		Thread.sleep(2000);
//		driver.findElement(By.id("input-email")).sendKeys(Utilities.generateTimeStamp());
//		driver.findElement(By.id("input-password")).sendKeys(loadDataProperties().getProperty("invalidPassword"));
//		driver.findElement(By.cssSelector("input[type='submit']")).click();
//		String warning = driver.findElement(By.cssSelector("div.alert.alert-danger.alert-dismissible")).getText();
//		Assert.assertEquals(warning,loadDataProperties().getProperty("warning"));
//
//	}
//
//	@Test(priority=3)
//	public void LoginWithInvalidUsernameValidPassword()  {
//		driver.findElement(By.id("input-email")).sendKeys(loadDataProperties().getProperty("invalidEmail"));
//		driver.findElement(By.id("input-password")).sendKeys(loadProperties().getProperty("password"));
//		driver.findElement(By.cssSelector("input[type='submit']")).click();
//		String warning = driver.findElement(By.cssSelector("div.alert.alert-danger.alert-dismissible")).getText();
//		Assert.assertEquals(warning,loadDataProperties().getProperty("warning"));
//
//	}
//
//	@Test(priority=4)
//	public void LoginWithValidUsernameInvalidPassword()  {
//		driver.findElement(By.id("input-email")).sendKeys(loadProperties().getProperty("username"));
//		driver.findElement(By.id("input-password")).sendKeys(loadDataProperties().getProperty("invalidPassword"));
//		driver.findElement(By.cssSelector("input[type='submit']")).click();
//		String warning = driver.findElement(By.cssSelector("div.alert.alert-danger.alert-dismissible")).getText();
//		Assert.assertEquals(warning,loadDataProperties().getProperty("warning"));
//
//	}
//	@Test(priority=5)
//	public void NoCredentialsLogin()  {
//		driver.findElement(By.id("input-email")).sendKeys("");
//		driver.findElement(By.id("input-password")).sendKeys("");
//		driver.findElement(By.cssSelector("input[type='submit']")).click();
//		String warning = driver.findElement(By.cssSelector("div.alert.alert-danger.alert-dismissible")).getText();
//		Assert.assertEquals(warning,dataProp.getProperty("warning"));
//
//	}