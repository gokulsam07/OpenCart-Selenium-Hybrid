package com.tutorialsninja.pageobjects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class RegisterPage {
	WebDriver driver;
	@FindBy(id="input-firstname")
	private WebElement fname;
	@FindBy(id="input-lastname")
	private WebElement lname;
	@FindBy(id="input-email")
	private WebElement email;
	@FindBy(id="input-telephone")
	private WebElement telephone;
	@FindBy(id="input-password")
	private WebElement password;
	@FindBy(id="input-confirm")
	private WebElement confirmPassword;
	@FindBy(name="agree")
	private WebElement policyAgree;
	@FindBy(xpath="//input[@value='Continue']")
	private WebElement save;
	@FindBy(xpath="//h1[normalize-space()='Your Account Has Been Created!']")
	private WebElement confirmation;
	@FindBy(xpath="//div[@class='alert alert-danger alert-dismissible']")
	private WebElement preConfigured;
	@FindBy(xpath="//h1[normalize-space()='Register Account']")
	private WebElement registerPageCheck;

	//Errors
	@FindBy(xpath="(//div[@class='text-danger'])[1]")
	private WebElement fnameError;
	@FindBy(xpath="(//div[@class='text-danger'])[2]")
	private WebElement lnameError;
	@FindBy(xpath="(//div[@class='text-danger'])[3]")
	private WebElement emailError;
	@FindBy(xpath="(//div[@class='text-danger'])[4]")
	private WebElement teleError;
	@FindBy(xpath="(//div[@class='text-danger'])[5]")
	private WebElement passError;
	@FindBy(xpath="//div[contains(@class,'alert alert-danger')]")
	private WebElement policyError;




	public RegisterPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	public void enterFirstName(String firstname) {
		fname.sendKeys(firstname);
	}
	public void enterLastName(String lastname) {
		lname.sendKeys(lastname);
	}
	public void enterEmail(String mail) {
		email.sendKeys(mail);
	}
	public void enterTelephone(String phone) {
		telephone.sendKeys(phone);
	}
	public void enterPassword(String pass) {
		password.sendKeys(pass);
	}
	public void confirmPassword(String confirmPass) {
		confirmPassword.sendKeys(confirmPass);
	}

	public void agreePolicy() {
		policyAgree.click();
	}
	public void save() {
		save.click();
	}

	public String confirmationMessageIsDisplayed() {
		return confirmation.getText().toString();
	}

	public String isErrorDisplayedForPreConfiguredMail() {
		return preConfigured.getText().toString();
	}

	//Error display code check

	public String isErrorDisplayedForfirstName() {
		return fnameError.getText().toString();
	}

	public String isErrorDisplayedForlastName() {
		return lnameError.getText().toString();
	}

	public String isErrorDisplayedForEmail() {
		return emailError.getText().toString();
	}

	public String isErrorDisplayedFortelephone() {
		return teleError.getText().toString();
	}

	public String isErrorDisplayedForpassword() {
		return passError.getText().toString();
	}

	public String isErrorDisplayedForpolicy() {
		return policyError.getText().toString();
	}


	public boolean checkIfFocusInRegisterPage() {
		return registerPageCheck.isDisplayed();
	}


}
