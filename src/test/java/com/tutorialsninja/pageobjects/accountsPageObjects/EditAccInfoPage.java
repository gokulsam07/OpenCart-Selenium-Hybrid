package com.tutorialsninja.pageobjects.accountsPageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EditAccInfoPage {
	WebDriver driver;
	@FindBy(id="input-firstname")
	private WebElement fName;
	@FindBy(id="input-lastname")
	private WebElement lName;
	@FindBy(id="input-email")
	private WebElement email;
	@FindBy(id="input-telephone")
	private WebElement phone;
	@FindBy(linkText="Back")
	private WebElement back;
	@FindBy(xpath="//input[@value='Continue']")
	private WebElement cont;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")
	private WebElement successMsg;



	public EditAccInfoPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}


	public String editLastName() {
		lName.clear();
		lName.sendKeys("Sam");
		cont.click();
		return successMsg.getText();
	}
	
	public String saveWithoutChange() {
		cont.click();
		return successMsg.getText();
	}

}
