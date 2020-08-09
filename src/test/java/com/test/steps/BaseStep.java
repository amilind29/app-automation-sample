package com.test.steps;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.test.utils.Config;
import com.test.utils.DriverManager;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import io.qameta.allure.Allure;

public class BaseStep {

	protected WebDriver driver;
	protected Config config;

	 @Before
	public void initialize() {
		driver = DriverManager.getDriverManager().getDriver();
		config = Config.getConfig();
	}

	 @After
	public void tearDown(Scenario scenario) {
		 if(scenario.isFailed()) {
			 final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
				InputStream is=new ByteArrayInputStream(screenshot);
			 Allure.addAttachment("Failed Step",is);
		 }
	}

}
