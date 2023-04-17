package com.tutorialsninja.pageobjects.CategoryRibbon;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.tutorialsninja.pageobjects.StorePage;
import com.tutorialsninja.pageobjects.IndividualCategoryPages.ICommons;
import com.tutorialsninja.pageobjects.IndividualCategoryPages.Mice_TrackBallsPage;
import com.tutorialsninja.pageobjects.IndividualCategoryPages.MonitorPage;
import com.tutorialsninja.pageobjects.IndividualCategoryPages.PrinterPage;
import com.tutorialsninja.pageobjects.IndividualCategoryPages.ScannerPage;
import com.tutorialsninja.pageobjects.IndividualCategoryPages.WebCamerasPage;

public class ComponentsList {


	WebDriver driver;

	@FindBy(partialLinkText="Mice")
	private WebElement miceAndTrackballsList;
	@FindBy(partialLinkText="Monitors")
	private WebElement monitorsList;
	@FindBy(partialLinkText="Printers")
	private WebElement printersList;
	@FindBy(partialLinkText="Scanners")
	private WebElement scannersList;
	@FindBy(partialLinkText="Web")
	private WebElement webCamerasList;
	@FindBy(linkText="Show AllComponents")
	private WebElement showAllComponents;



	public ComponentsList(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	public ICommons selectComponentType(String type) {
		if(type.contains("Mice")) {
			miceAndTrackballsList.click();
		return new Mice_TrackBallsPage(driver);
		}
		else if(type.contains("Monitor")) {
			monitorsList.click();
			return new MonitorPage(driver);
		}
		else if(type.contains("Printer")) {
			printersList.click();
			return new PrinterPage(driver);
		}
		else if(type.contains("Scanner")) {
			scannersList.click();
			return new ScannerPage(driver);
		}
		else if(type.contains("Web")) {
			webCamerasList.click();
			return new WebCamerasPage(driver);
		}
		else if(type.equalsIgnoreCase("Show All Components")) {
			showAllComponents.click();
			return new StorePage(driver);
		}
	return null;
	}

}

