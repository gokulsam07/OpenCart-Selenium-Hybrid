package com.tutorialsninja.pageobjects.IndividualCategoryPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.tutorialsninja.pageobjects.HomePage;

public class WebCamerasPage implements ICommons{
	WebDriver driver;
	@FindBy(linkText="Continue")
	private WebElement ctd;

	public WebCamerasPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@Override
	public HomePage clickOnContinue() {
		ctd.click();
		return new HomePage(driver);

	}



	@Override
	public boolean isProductDisplayed(String pdtName) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void selectProduct(String pdtName) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isProductDisplayed() {
		// TODO Auto-generated method stub
		return false;
	}
}
