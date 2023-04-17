package com.tutorialsninja.pageobjects.IndividualCategoryPages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PhonesPage {
	WebDriver driver;

	@FindBy(xpath="//h2[normalize-space()='Phones & PDAs']")
	private WebElement phonesPageHeading;
	@FindBy(partialLinkText="Phones & PDAs (")
	private WebElement sidePanelPhones;

	@FindBy(xpath="//h4//a[contains(@href, 'product_id')]")
	private List<WebElement> allProductList;

	@FindBy(xpath="//p[normalize-space()='There are no products to list in this category.']")
	private WebElement noPdt;

	public PhonesPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	public boolean verifyIfFocusInPhonesPage() {
		return sidePanelPhones.getCssValue("color").equals("rgba(68, 68, 68, 1)");
	}

	public boolean IsDisplayValueEqualsActualCount() {
		try {
			if(noPdt.isDisplayed()) {
				return false;
			}
		} catch (Exception e) {
				//LBI
		}

		String str = sidePanelPhones.getText().toString();
		return str.substring(str.indexOf("(") + 1, str.indexOf(")")).trim().equals(String.valueOf(allProductList.size()));
	}


}
