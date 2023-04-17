package com.tutorialsninja.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
;

public class HomePage { 
	WebDriver driver;
	//Objects
	@FindBy(xpath="//span[normalize-space()='My Account']")
	private WebElement myAccount;
	@FindBy(xpath="//ul[@class='dropdown-menu dropdown-menu-right']//a[normalize-space()='My Account']")
	private WebElement myAccountInUL;
	@FindBy(linkText="Register")
	private WebElement register;
	@FindBy(linkText="Login")
	private WebElement login;
	@FindBy(name="search")
	private WebElement search;
	@FindBy(css="button.btn.btn-default.btn-lg")
	private WebElement searchButton;
	@FindBy(xpath="//body/div[@id='common-home']/div[@class='row']/div[@id='content']/div[1]")
	private WebElement slider;


	@FindBy(css="a[title='Shopping Cart']")
	private WebElement shoppingCartTop;

	@FindBy(css=".btn.btn-inverse.btn-block.btn-lg.dropdown-toggle")
	private WebElement shoppingCart;

	@FindBy(xpath="//ul[@class='dropdown-menu pull-right']//p")
	private WebElement shoppingCartEmptyMsg;

	@FindBy(css="a[title='Checkout'] span[class='hidden-xs hidden-sm hidden-md']")
	private WebElement checkout;

	@FindBy(xpath="(//ul//a)[5]")
	private WebElement wish;

	@FindBy(xpath="//span[normalize-space()='Currency']")
	private WebElement currency;

	@FindBy(name="EUR")
	private WebElement EUR;
	@FindBy(name="USD")
	private WebElement USD;
	@FindBy(name="GBP")
	private WebElement pound;

	//currency 
	@FindBy(xpath="(//span[@class='price-new'])[1]")
	private WebElement usdDisplay;
	@FindBy(xpath="(//span[@class='price-new'])[1]")
	private WebElement poundDisplay;
	@FindBy(xpath="(//span[@class='price-new'])[1]")
	private WebElement euroDisplay;

	@FindBy(xpath="//strong[contains(text(),'€')]")
	private WebElement euroIcon;
	@FindBy(xpath="//strong[contains(text(),'$')]")
	private WebElement usdIcon;
	@FindBy(xpath="//strong[contains(text(),'£')]")
	private WebElement poundIcon;




	public HomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		//PageFactory.initElements(driver, HomePage.class); //means the same thing
	}


	//Actions

	public void ClickOnMyAccount() {
		myAccount.click();
	}

	public void ClickOnRegister() {
		register.click();
	}

	public LoginPage ClickOnLogin() {
		login.click();
		return new LoginPage(driver);

	}

	public void EnterProductName(String pdtName) {
		search.sendKeys(pdtName);
	}

	public void clickSearchButton() {
		searchButton.click();
	}

	public boolean isSliderVisible() {
		return slider.isDisplayed();
	}

	public ShoppingcartPage clickShoppingCart() {
		shoppingCartTop.click();
		return new ShoppingcartPage(driver);
	}

	public LoginPage clickWishlistwithoutLogin() {
		wish.click();
		return new LoginPage(driver);
	}
	public boolean clickBtnCart() {
		shoppingCart.click();
		return shoppingCartEmptyMsg.isDisplayed();
	}

	public boolean selectCurrency(String text) {
		currency.click();
		if(text.equalsIgnoreCase("Euro")) {
			EUR.click();
			return euroIcon.isDisplayed();

		}
		else if(text.equalsIgnoreCase("USD")) {
			USD.click();
			return usdIcon.isDisplayed();
		}
		else {
			pound.click();
			return poundIcon.isDisplayed();
		}
	}

	public boolean verifyInPdtListing(String symbol) {
		boolean status =false;
		switch (symbol) {

		case "$": {
			return status = usdDisplay.getText().contains("$");
		}

		case "€": {
			return status = euroDisplay.getText().contains("€");

		}

		case "£": {
			return status = poundDisplay.getText().contains("£");

		}

		}
		return status;

	}

}