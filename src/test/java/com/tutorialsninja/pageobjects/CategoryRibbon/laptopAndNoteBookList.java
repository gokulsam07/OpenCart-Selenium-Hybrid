package com.tutorialsninja.pageobjects.CategoryRibbon;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.tutorialsninja.pageobjects.StorePage;
import com.tutorialsninja.pageobjects.IndividualCategoryPages.ICommons;
import com.tutorialsninja.pageobjects.IndividualCategoryPages.MacsPage;
import com.tutorialsninja.pageobjects.IndividualCategoryPages.WindowsPage;

public class laptopAndNoteBookList {

	WebDriver driver;

	@FindBy(partialLinkText="Macs")
	private WebElement macsList;
	@FindBy(partialLinkText="Windows")
	private WebElement windowsList;
	@FindBy(linkText="Show AllLaptops & Notebooks")
	private WebElement showAllLaptops_Notebooks;


	public laptopAndNoteBookList(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	public ICommons selectlaptopOrNotebookType(String type) {
		if(type.equalsIgnoreCase("Macs"))
		{
			macsList.click();
			return new MacsPage(driver);
		}
		else if(type.equalsIgnoreCase("Windows"))
		{
			windowsList.click();
			return new WindowsPage(driver);
		}
		else if(type.equalsIgnoreCase("Show All Laptops & Notebooks")) {
			showAllLaptops_Notebooks.click();
			return new StorePage(driver);
		}
		return null;
	}

}