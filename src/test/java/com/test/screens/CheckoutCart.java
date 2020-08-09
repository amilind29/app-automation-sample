package com.test.screens;

import java.util.List;

import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class CheckoutCart extends BaseScreen{

	@AndroidFindBy(id = "")
	private AndroidElement cartButton;
	
	@AndroidFindBy(id = "")
	private List<AndroidElement> productDescription;
	
	
	@AndroidFindBy(id = "")
	private AndroidElement productPrice;
	
	@AndroidFindBy(id = "")
	private AndroidElement cartSubTotal;

	public void openCart() {
		cartButton.click();
	}
	
	public String getProductDescription() {
		return productDescription.get(0).getText();
	}
	
	public boolean isProductDescriptionDesplyed() {
		return productDescription.size() > 0;
	}

	public String getProductPrice() {
		return productPrice.getText();
	}

	public String getCartSubTotal() {
		return cartSubTotal.getText();
	}
	
	

}
