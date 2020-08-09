package com.test.utils;

import java.net.MalformedURLException;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

/**
 * 
 * Class manages - driver initialisation, - adding required capabilities -
 * setting up devices based on provided properties
 */
public class DriverManager {

	private static DriverManager driverManager;
	private AppiumDriver<MobileElement> driver;
	private DesiredCapabilities capabilities;
	AppiumDriverLocalService appiumService;

	private Config config = Config.getConfig();

	private DriverManager() {

	}

	/**
	 * Method returns singleton object for driver manager
	 */
	public static DriverManager getDriverManager() {
		if (driverManager == null)
			driverManager = new DriverManager();
		return driverManager;
	}

	/**
	 * Method returns driver required for executing app actions
	 */
	public AppiumDriver<MobileElement> getDriver() {
		if (driver == null)
			try {
				if (config.getProperty("test.run.local") == "True") {
					this.initiateLocalAppiumService();
				}
				this.initializeAndroidDriver();
			} catch (MalformedURLException e) {

			}
		return driver;
	}

	/**
	 * 
	 * Method will take care of initialising driver object with required
	 * capabilities
	 */
	public void initiateLocalAppiumService() {
		AppiumServiceBuilder serviceBuilder = new AppiumServiceBuilder();
		serviceBuilder.usingPort(Integer.parseInt(config.getProperty("test.run.port")));
		appiumService = AppiumDriverLocalService.buildService(serviceBuilder);
		appiumService.start();
	}

	/**
	 * 
	 * This method will take care of initialising driver object with required
	 * capabilities for android platform
	 */
	public void initializeAndroidDriver() throws MalformedURLException {
		String executionDevice = config.getProperty("test.run.platform");
		capabilities = new DesiredCapabilities();
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("app", "");
		capabilities.setCapability("platformVersion", config.getProperty("test.run.platform"));
		capabilities.setCapability("appPackage", config.getProperty("test.app.activity"));
		if (executionDevice == "device") {
			capabilities.setCapability("deviceName", config.getProperty("test.run.platform"));
			capabilities.setCapability("appActivity", "com.amazon.mShop.home.HomeActivity");
		} else {
			capabilities.setCapability("deviceName", "");
			capabilities.setCapability("platformVersion", "");
		}
		driver = new AndroidDriver<MobileElement>(appiumService.getUrl(), capabilities);
		driver.manage().timeouts().implicitlyWait(30000, TimeUnit.MILLISECONDS);
	}

	public void switchToNativeContext() {
		driver.context("NATIVE_APP");
	}

	public void switchToWebContext() {
		String webContext = this.getWebContext();
		driver.context(webContext);
	}

	private String getWebContext() {
		ArrayList<String> contexts = new ArrayList<String>(driver.getContextHandles());
		for (String context : contexts) {
			if (!context.equals("NATIVE_APP")) {
				return context;
			}
		}
		return null;
	}

}