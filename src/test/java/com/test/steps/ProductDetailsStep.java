package com.test.steps;

import static org.junit.Assert.assertEquals;

import com.test.screens.BaseScreen;
import com.test.screens.ProductDetailsPage;
import com.test.utils.TestContext;
import com.test.utils.Utils;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;

public class ProductDetailsStep {

	ProductDetailsPage productDetailsPage = BaseScreen.loadPageObjects(ProductDetailsPage.class);
	TestContext context = TestContext.getTestContext();

	@Given("I should see product details page")
	public void i_see_product_details_page() {
		assertEquals(productDetailsPage.isProductDescriptionDisplayed(), true);
		((TestContext) context).set("product price", productDetailsPage.getProductPrice());
	}

	@When("I add product to cart")
	public void i_add_product_rp_cart() {
		while (!productDetailsPage.isAddToKartButtonDisplayed()) {
			Utils.randomSwipe(1);
		}
		productDetailsPage.clickAddToKartButton();
	}
}
