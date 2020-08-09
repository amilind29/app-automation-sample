package com.test.steps;

import static org.junit.Assert.assertEquals;

import com.test.screens.BaseScreen;
import com.test.screens.CheckoutCart;
import com.test.utils.TestContext;

import cucumber.api.java.en.And;

public class CheckoutSteps {

	
	CheckoutCart cart = BaseScreen.loadPageObjects(CheckoutCart.class);
	TestContext context = TestContext.getTestContext();
	
	@And("I open cart")
	public void i_open_cart() {
		cart.openCart();
	}
	
	@And("I should see product in the cart")
	public void i_see_product_in_cart() {
		assertEquals(cart.isProductDescriptionDesplyed(), true);
	}
	
	@And("Price should match the product details page")
	public void price_match_the_product_details_page() {
		assertEquals(cart.getProductPrice(), context.read("product price"));
	}
	
}
