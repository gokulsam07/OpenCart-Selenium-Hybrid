package com.tutorialsninja.pageobjects.CategoryRibbon;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.tutorialsninja.pageobjects.StorePage;
import com.tutorialsninja.pageobjects.IndividualCategoryPages.*;


public class DesktopList {
	WebDriver driver;

	@FindBy(partialLinkText="Mac")
	private WebElement macList;
	@FindBy(partialLinkText="PC")
	private WebElement pcList;
	@FindBy(linkText="Show AllDesktops")
	private WebElement allDesktop;
	
	

	public DesktopList(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public ICommons selectDesktopType(String type) {

		if(type.equalsIgnoreCase("PC"))
		{
			pcList.click();
			return new PCPage(driver);
		}
		else if(type.equalsIgnoreCase("Mac"))
		{
			macList.click();
			return new MacPage(driver);
		}
		else if(type.equalsIgnoreCase("Show All Desktops")) {
			allDesktop.click();
			return new StorePage(driver);
		}

		return null;
	}

}
