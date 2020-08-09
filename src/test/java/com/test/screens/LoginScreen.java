package com.test.screens;

import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class LoginScreen extends BaseScreen {

	/**
	 * first screen to select login action
	 */
	@AndroidFindBy(id = "com.amazon.mShop.android.shopping:id/sign_in_button")
	private AndroidElement alreadyCustomerSignInButton;

	/**
	 * second screen to select login mode
	 */
	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.webkit.WebView")
	private AndroidElement webView;

	@AndroidFindBy(id = "ap_email_login")
	private AndroidElement emailInput;

	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View[2]/android.view.View[2]/android.view.View[2]/android.view.View/android.view.View/android.view.View[4]/android.widget.Button")
	private AndroidElement continueButtonEmailScreen;

	/**
	 * third screen of login to enter password
	 */
	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.widget.TextView[1]")
	private AndroidElement emailString;

	@AndroidFindBy(id = "ap_password")
	private AndroidElement passwordInput;

	@AndroidFindBy(id = "signInSubmit")
	private AndroidElement loginButton;

	public void clickAlreadyCustomerSignInButton() {
		alreadyCustomerSignInButton.click();
	}

	public AndroidElement getWebView() {
		return webView;
	}

	public void setEmail(String email) {
		emailInput.sendKeys(email);
	}

	public void clickContinueButtonEmailScreen() {
		continueButtonEmailScreen.click();
	}

	public String getEmailStringOnPasswordScreen() {
		return emailString.getText();
	}

	public void setPassword(String password) {
		passwordInput.sendKeys(password);
	}

	public void clickLoginButton() {
		loginButton.click();
	}
	
	public void doLogin(String email, String setPassword) {
		clickAlreadyCustomerSignInButton();
		setEmail(email);
		clickContinueButtonEmailScreen();
		setPassword(setPassword);
		clickLoginButton();
	}

}
