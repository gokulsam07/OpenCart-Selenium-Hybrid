package com.tutorialsninja.pageobjects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.tutorialsninja.pageobjects.IndividualCategoryPages.ICommons;


public class StorePage implements ICommons {
	WebDriver driver;
	boolean status =false;

	@FindBy(xpath="//p[text()='There is no product that matches the search criteria.']")
	private WebElement productNotAvilable;

	@FindBy(xpath="//ul[@class='breadcrumb']//a[contains(text(),'Desktops')]")
	private WebElement desktops;

	@FindBy(xpath="//ul[@class='breadcrumb']//a[contains(text(),'Laptops & Notebooks')]")
	private WebElement laptop_Notebooks;

	@FindBy(xpath="//ul[@class='breadcrumb']//a[contains(text(),'Components')]")
	private WebElement components;


	public StorePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	public boolean noProductAvailableIsDisplayed() {
		return productNotAvilable.isDisplayed();
	}


	public boolean isAllDesktopsDisplayed() {
		status = desktops.isDisplayed();
		return status;
	}

	public boolean isAllLaptopsNotebboksDisplayed() {
		status = laptop_Notebooks.isDisplayed();
		return status;
	}
	public boolean isAllComponentsDisplayed() {
		status = components.isDisplayed();
		return status;
	}



	@Override
	public  boolean isProductDisplayed(String pdtName) {
		//LBI
		return false;
	}


	@Override
	public  void selectProduct(String pdtName) {
		//LBI
	}
	@Override
	public  HomePage clickOnContinue() {
		return null;
		//LBI
	}

	@Override
	public  boolean isProductDisplayed() {
		//LBI
		return false;
	}

}
