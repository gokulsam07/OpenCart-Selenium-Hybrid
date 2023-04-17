package com.tutorialsninja.pageobjects.accountsPageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ChangePasswordPage {
	WebDriver driver;
	@FindBy(id="input-password")
	private WebElement password;
	@FindBy(id="input-confirm")
	private WebElement confirmPwd;
	@FindBy(linkText="Back")
	private WebElement back;
	@FindBy(xpath="//input[@value='Continue']") 
	private WebElement cont;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")
	private WebElement successMsg;
	@FindBy(css=".text-danger")
	private WebElement errorInMain;
	@FindBy(css=".text-danger")
	private WebElement errorInConfirm;




	public ChangePasswordPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	public String changePassword() {
		password.sendKeys("Gokul@123");
		confirmPwd.sendKeys("Gokul@123");
		cont.click();
		System.out.println(successMsg.getText().toString());
		return successMsg.getText();
	}

	public String clickCtdDirectly() {
		cont.click();
		return errorInMain.getText();
	}

	public String leaveConfirmPwdEmpty() {
		password.sendKeys("Gokul@123");
		cont.click();
		return errorInConfirm.getText();
	}
	
	public String notMatchingPwd(){
		password.sendKeys("Gokul@123");
		confirmPwd.sendKeys("Gokul@222");
		cont.click();
		return errorInConfirm.getText();
	}


}
