package com.tutorialsninja.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShoppingcartPage {

	WebDriver driver;

	@FindBy(css="div[id='content'] h1") 
	private WebElement shoppingCartHeading;
	@FindBy(css="div[id='content'] p") 
	private WebElement emptyCartMsg;
	@FindBy(css=".btn.btn-primary") 
	private WebElement cont;
	


	public ShoppingcartPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}


	public String checkIfFocusInShoppingCart() {
		if(shoppingCartHeading.getText().equalsIgnoreCase("Shopping Cart")) {
			return emptyCartMsg.getText();
		}
		return null;
	}
	
	public HomePage clickContinueInEmptyCart() {
		cont.click();
		return new HomePage(driver);
	}
}
