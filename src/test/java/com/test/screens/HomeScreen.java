package com.test.screens;

import java.util.List;

import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class HomeScreen extends BaseScreen {

	@AndroidFindBy(id = "com.amazon.mShop.android.shopping:id/rs_search_src_text")
	private AndroidElement searchBox;

	@AndroidFindBy(xpath = "com.amazon.mShop.android.shopping:id/rs_search_src_text")
	private List<AndroidElement> searchResultsSuggestion;

	@AndroidFindBy(xpath = "")
	private List<AndroidElement> searchResult;

	public void searchProduct(String searchString) {
		searchBox.sendKeys(searchString);

	}

	public List<AndroidElement> getSearchResultsSuggestion() {
		return searchResultsSuggestion;
	}

	public List<AndroidElement> getSearchResult() {
		return searchResult;
	}
	
	public void searchProductAndOpenResult(String searchString) {
		// search product
		searchProduct(searchString);
		// select first suggested product from list
		getSearchResultsSuggestion().get(0).click();
	}
	
	

}
