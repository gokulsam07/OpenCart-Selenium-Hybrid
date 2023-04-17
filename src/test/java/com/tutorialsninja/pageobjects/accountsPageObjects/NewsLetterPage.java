package com.tutorialsninja.pageobjects.accountsPageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewsLetterPage {
	WebDriver driver;
	@FindBy(xpath="//h1[normalize-space()='Newsletter Subscription']")
	private WebElement newsLetterFocus;
	@FindBy(css="input[value='1']")
	private WebElement subscribeYes;
	@FindBy(css="input[value='0']")
	private WebElement subscribeNo;
	@FindBy(linkText="Back")
	private WebElement back;
	@FindBy(css="input[value='Continue']")
	private WebElement ctd;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")
	private WebElement subModifyAlert;




	public NewsLetterPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}



	public boolean isFocusInNewsLetterPage() {
		return newsLetterFocus.isDisplayed();
	}

	public boolean selectSusbsciption(String type) {
		if(type.equalsIgnoreCase("yes")) {
			subscribeYes.click();
			ctd.click();
			return subModifyAlert.isDisplayed();

		}
		else
		{
			subscribeNo.click();
			ctd.click();
			return subModifyAlert.isDisplayed();

		}
	}


}

