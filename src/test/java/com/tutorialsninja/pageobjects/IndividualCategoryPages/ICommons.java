package com.tutorialsninja.pageobjects.IndividualCategoryPages;

import com.tutorialsninja.pageobjects.HomePage;

public interface ICommons {


	HomePage clickOnContinue();
	void selectProduct(String pdtName);
	boolean isProductDisplayed(String pdtName);
	boolean isProductDisplayed();
	


}
