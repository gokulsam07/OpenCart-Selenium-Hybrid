package com.tutorialsninja.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver driver;


	@FindBy(id="input-email")
	private WebElement username;
	@FindBy(id="input-password")
	private WebElement password;
	@FindBy(css="input[type='submit']")
	private WebElement submit;
	@FindBy(css="div.alert.alert-danger.alert-dismissible")
	private WebElement loginError;
	@FindBy(linkText="Continue")
	private WebElement registerContinue;
	@FindBy(xpath="//strong[normalize-space()='Register Account']")
	private WebElement registerDetailsInLogin; 


	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	public void enterUsername(String email) {
		username.sendKeys(email);
	}
	public void enterPassword(String pass) {
		password.sendKeys(pass);
	}
	public AccountPage clickLogin() {
		submit.click();
		return new AccountPage(driver);
	}

	public boolean isErrorDisplayedForWrongCreds() {
		return loginError.isDisplayed();
	}
	
	public boolean isRegisterDetailsDisplayedInLoginPage() {
		return registerDetailsInLogin.isDisplayed();
	}
	
	public RegisterPage registerContinuefromLoginClick() {
		registerContinue.click();
		return new RegisterPage(driver);
	}
}
