package com.tutorialsninja.pageobjects.IndividualCategoryPages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TabletsPage {

	WebDriver driver;

	@FindBy(xpath="//h2[normalize-space()='Tablets']")
	private WebElement tabletPageHeading;
	@FindBy(partialLinkText="Tablets (")
	private WebElement sidePanelTablet;
	@FindBy(css=".col-sm-6.text-right")
	private WebElement pdtPageCount;

	@FindBy(xpath="//h4//a[contains(@href, 'product_id')]")
	private List<WebElement> allProductList;
	
	@FindBy(xpath="//p[normalize-space()='There are no products to list in this category.']")
	private WebElement noPdt;


	public TabletsPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	public boolean verifyIfFocusInTabletsPage() {
		return sidePanelTablet.getCssValue("color").equals("rgba(68, 68, 68, 1)");

	}

	public boolean IsDisplayValueEqualsActualCount() {
		try {
			if(noPdt.isDisplayed()) {
				return false;
			}
		} catch (Exception e) {
				//LBI
		}
		String str = sidePanelTablet.getText().toString();	
		return str.substring(str.indexOf("(") + 1, str.indexOf(")")).trim().equals(String.valueOf(allProductList.size()));
	}
}
