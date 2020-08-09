package com.test.screens;

import java.util.List;

import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class ProductDetailsPage extends BaseScreen{
	
	@AndroidFindBy(id = "")
	private AndroidElement productTitle;
	
	@AndroidFindBy(id = "")
	private AndroidElement productDescription;
	
	
	@AndroidFindBy(id = "")
	private AndroidElement productPrice;
	
	@AndroidFindBy(id = "")
	private List<AndroidElement> addToKartButton;

	public String getProductTitle() {
		return productTitle.getText();
	}

	public String getProductDescription() {
		return productDescription.getText();
	}
	
	public boolean isProductDescriptionDisplayed() {
		return productDescription.isDisplayed();
	}

	public String getProductPrice() {
		return productPrice.getText();
	}

	public boolean isAddToKartButtonDisplayed() {
		return addToKartButton.size() > 0;
	}
	
	public void clickAddToKartButton() {
		addToKartButton.get(0).click();
	}

	
}
