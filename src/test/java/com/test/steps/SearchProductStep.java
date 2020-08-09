package com.test.steps;

import static org.junit.Assert.assertNotEquals;

import java.util.List;

import com.test.screens.BaseScreen;
import com.test.screens.HomeScreen;
import com.test.utils.Utils;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.appium.java_client.android.AndroidElement;

public class SearchProductStep {

	HomeScreen homeScreen = BaseScreen.loadPageObjects(HomeScreen.class);

	@When("I search for {string}")
	public void i_enter_search_string(String searchString) {
		homeScreen.searchProduct(searchString);

	}

	@And("I select a result from suggestion")
	public void i_select_product_from_search_suggestion() {
		homeScreen.getSearchResultsSuggestion().get(0).click();
	}

	@Then("I should see search result")
	public void i_see_search_result() {
		List<AndroidElement> product_list = homeScreen.getSearchResult();
		assertNotEquals(product_list.size(), 0);
	}

	@When("I open random product")
	public void i_open_random_product() {
		Utils.randomSwipe(Utils.getRandomNumber(5));
		List<AndroidElement> product_list = homeScreen.getSearchResult();
		product_list.get(0).click();
		
	}

	
}
