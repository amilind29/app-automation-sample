package com.test.screens;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import com.test.utils.DriverManager;

public class BaseScreen {
	protected WebDriver driver = DriverManager.getDriverManager().getDriver();
	protected Actions action=new Actions(driver);



	public static <T extends BaseScreen> T loadPageObjects(Class<T> type) {
		return PageFactory.initElements(DriverManager.getDriverManager().getDriver(), type);
	}

	
}