package com.tutorialsninja.pageobjects.IndividualCategoryPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.tutorialsninja.pageobjects.HomePage;

public class PCPage implements ICommons {

	WebDriver driver;
	
	@FindBy(linkText="Continue")
	private WebElement ctd;
	
	

	public PCPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@Override
	public HomePage clickOnContinue() {
		ctd.click();
		return new HomePage(driver);
	}

	@Override
	public void selectProduct(String pdtName) {
		//LBI
		
	}
	@Override
	public boolean isProductDisplayed() {
		//LBI
		return false;
	}
	@Override
	public boolean isProductDisplayed(String pdtName) {
		//LBI
		return false;
	}

}
