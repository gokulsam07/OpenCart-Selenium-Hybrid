package com.tutorialsninja.pageobjects.CategoryRibbon;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.tutorialsninja.pageobjects.IndividualCategoryPages.CameraPage;
import com.tutorialsninja.pageobjects.IndividualCategoryPages.PhonesPage;
import com.tutorialsninja.pageobjects.IndividualCategoryPages.SoftwarePage;
import com.tutorialsninja.pageobjects.IndividualCategoryPages.TabletsPage;

public class CategoryRibbon {
	public WebDriver driver;
	//TopLevel
	@FindBy(linkText="Desktops")
	private WebElement desktops;
	@FindBy(linkText="Laptops & Notebooks")
	private WebElement lapNoteBook;
	@FindBy(linkText="Components")
	private WebElement components;
	@FindBy(linkText="Tablets")
	private WebElement tablets;
	@FindBy(linkText="Software")
	private WebElement software;
	@FindBy(linkText="Phones & PDAs")
	private WebElement phone;
	@FindBy(linkText="Cameras")
	private WebElement cameras;



	@FindBy(partialLinkText="Mac")
	private WebElement macList;
	@FindBy(linkText="iMac")
	private WebElement macProducts;


	@FindBy(linkText="Monitors (2)")
	private WebElement monitorList;
	@FindBy(linkText="Apple Cinema 30\"")
	private WebElement appleCinema;
	@FindBy(linkText="Samsung SyncMaster 941BW")
	private WebElement samsung;


	public CategoryRibbon(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	public laptopAndNoteBookList selectLaptopAndNoteBook() {
		lapNoteBook.click();
		return new laptopAndNoteBookList(driver);
	}

	public DesktopList selectDesktop() {
		desktops.click();
		return new DesktopList(driver);
	}

	public ComponentsList selectComponents() {
		components.click();
		return new ComponentsList(driver);
	}

	public TabletsPage selectTablets() {
		tablets.click();
		return new TabletsPage(driver);
	}

	public SoftwarePage selectSoftwares() {
		software.click();
		return new SoftwarePage(driver);
	}
	public PhonesPage selectPhones() {
		phone.click();
		return new PhonesPage(driver);
	}
	public CameraPage selectCameras() {
		cameras.click();
		return new CameraPage(driver);
	}










	public void selectMacList() {
		macList.click();
	}
	public boolean isMacProductDisplayed() {
		return macProducts.isDisplayed();
	}




	public boolean monitorProductsDisplayed(String pdt) {
		boolean display=false;
		if(pdt.equalsIgnoreCase("Apple Cinema 30\"")) {
			display =  appleCinema.isDisplayed();
		}
		else if(pdt.equalsIgnoreCase("Samsung SyncMaster 941BW")) {
			display =  samsung.isDisplayed();
		}
		return display;
	}

}
