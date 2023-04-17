package com.tutorialsninja.pageobjects;


import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductComparisonPage {
	WebDriver driver;


	@FindBy(partialLinkText="Product Compare")
	private WebElement pdtCompare;

	@FindBy(xpath="//p[text()='You have not chosen any products to compare.']")
	private WebElement emptyMsg;

	@FindBy(linkText="Continue")
	private WebElement cont;

	@FindBy(xpath="//strong[normalize-space()='Product Details']")
	private WebElement headingAvailable;

	@FindBy(xpath="//td[normalize-space()='Product']/following-sibling::td")
	private List<WebElement> pdtCountInPage;

	@FindBy(linkText="Remove")
	private WebElement removeFromComparison;

	@FindBy(xpath="//i[@class='fa fa-check-circle']")
	private WebElement dismissible;

	@FindBy(xpath="//button[@data-original-title='Compare this Product']")
	private List<WebElement> addPdtListFromHomePage;

	@FindBy(xpath="//a[normalize-space()='product comparison']")
	private WebElement goToPdtCmp;

	public ProductComparisonPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	public void selectPdtCompareLink() {
		pdtCompare.click();
	}
	public boolean emptyPdtPageElementIsDisplayed(String elementName) {
		boolean status=false;
		if(elementName.contains("not chosen any products")) {
			status = cont.isDisplayed();
		}
		return status;
	}

	public void startComparison() {
		cont.click();
	}

	public void addToCmpPageAndRedirectToCmpPage() throws InterruptedException {
		WebDriverWait wdWait = new WebDriverWait(driver, Duration.ofSeconds(5));
		for (WebElement pdt : addPdtListFromHomePage) {
			wdWait.until(ExpectedConditions.visibilityOf(pdt));
			wdWait.until(ExpectedConditions.attributeToBe(pdt, "data-original-title", "Compare this Product"));
			pdt.click();
			Thread.sleep(1000);
		}
		wdWait.until(ExpectedConditions.elementToBeClickable(goToPdtCmp));
		goToPdtCmp.click();
	}

	public boolean verifyAfterPdtAddition() {
		return headingAvailable.isDisplayed();
	}


	public boolean goToPdtComparisonPageAfterAddAndRemove() {
		if(headingAvailable.isDisplayed()) {
			for(int i=pdtCountInPage.size(); i>0;i--) {
				removeFromComparison.click();
			}
			return emptyMsg.isDisplayed();
		}
		else {

			return  emptyMsg.isDisplayed();
		}
	}


}
