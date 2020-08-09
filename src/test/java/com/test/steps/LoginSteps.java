package com.test.steps;

import com.test.screens.BaseScreen;
import com.test.screens.LoginScreen;
import com.test.utils.Config;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;


public class LoginSteps{
	
	LoginScreen loginScreen= BaseScreen.loadPageObjects(LoginScreen.class);

	@Given("I click on 'already a customer signin' button")
	public void i_navigate_to_sign_in_screen() {
		loginScreen.clickAlreadyCustomerSignInButton();
	}
	
	@And("I enter email as {string}")
	public void i_enter_email(String email) {
		loginScreen.setEmail(email);
	}
	
	@And("I click continue button on email screen")
	public void i_click_continue_on_email_screen() {
		loginScreen.clickContinueButtonEmailScreen();
	}
	
	@And("I enter password as {string}")
	public void i_enter_password() {
		loginScreen.clickContinueButtonEmailScreen();
	}
	
	@And("I click on sign in button")
	public void i_click_on_signin_button() {
		loginScreen.clickLoginButton();
	}
}
