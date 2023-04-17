package com.tutorialsninja.pageobjects.IndividualCategoryPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.tutorialsninja.pageobjects.HomePage;

public class MacPage implements ICommons {
	WebDriver driver;

	@FindBy(linkText="iMac")
	private WebElement iMac;


	@FindBy(linkText="Continue")
	private WebElement ctd;

	public MacPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@Override
	public void selectProduct(String pdtName) {
		if(pdtName.equalsIgnoreCase("iMac")) {
			iMac.click();
		}
	}
	@Override
	public boolean isProductDisplayed() {
		boolean status =false;
		status =iMac.isDisplayed();
		return status;

	}

	@Override
	public HomePage clickOnContinue() {
		ctd.click();
		return new HomePage(driver);
		

	}

	@Override
	public boolean isProductDisplayed(String pdtName) {
		boolean status =false;
		status =iMac.isDisplayed();
		return status;
		
	}
}
