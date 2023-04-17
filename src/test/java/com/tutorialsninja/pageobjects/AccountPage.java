package com.tutorialsninja.pageobjects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.tutorialsninja.pageobjects.accountsPageObjects.ChangePasswordPage;
import com.tutorialsninja.pageobjects.accountsPageObjects.EditAccInfoPage;
import com.tutorialsninja.pageobjects.accountsPageObjects.NewsLetterPage;
public class AccountPage {
	WebDriver driver;
	@FindBy(linkText="Edit your account information")
	private WebElement editYourAccInfo;
	@FindBy(partialLinkText="Subscribe")
	private WebElement newsLetter;
	@FindBy(partialLinkText="Change your")
	private WebElement changePwd;

	//Top Ribbon after login check
	@FindBy(linkText="Order History")
	private WebElement orderHistory;
	@FindBy(linkText="Transactions")
	private WebElement transactions;
	@FindBy(linkText="Downloads")
	private WebElement downloads;
	@FindBy(linkText="Logout")
	private WebElement logout;
	@FindBy(xpath="//span[normalize-space()='My Account']")
	private WebElement myAccount;
	@FindBy(xpath="//ul[@class='dropdown-menu dropdown-menu-right']//a[normalize-space()='My Account']")
	private WebElement myAccountInUL;

	@FindBy(xpath="//p[contains(text(),'You have been logged off your account. It is now s')]")
	private WebElement logoutMsg;

	public AccountPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	public boolean getDisplayOfEditAccInfo() {
		try {
			editYourAccInfo.isDisplayed();
		} catch (Exception e) {
			return false;
		}
		return editYourAccInfo.isDisplayed();
	}

	public NewsLetterPage selectNewsLetter() {
		newsLetter.click();
		return new NewsLetterPage(driver);
	}

	public boolean IsAllAccountOptionsDisplayed() {
		myAccount.click();
		if(myAccountInUL.isDisplayed()&&orderHistory.isDisplayed()&&transactions.isDisplayed()&&logout.isDisplayed()&&downloads.isDisplayed()) {
			return true;
		}
		return false;
	}

	public boolean clickLogout() {
		logout.click();
		return logoutMsg.isDisplayed();

	}

	public EditAccInfoPage clickEditAccountInfo() {
		editYourAccInfo.click();
		return new EditAccInfoPage(driver);
	}

	public ChangePasswordPage clickChangepassword() {
		changePwd.click();
		return new ChangePasswordPage(driver);
	}
}
