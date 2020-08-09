package com.test.utils;

import java.time.Duration;

import org.openqa.selenium.Dimension;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class Utils {

	public static int getRandomNumber(int range) {
		return (int) (Math.random() * (range));
	}

	public static void touchAndSwipe(int fromX, int fromY, int toX, int toY, int swipeCycle) {
		TouchAction touchAction = new TouchAction(DriverManager.getDriverManager().getDriver());
		for (int i = 0; i < swipeCycle; i++) {
			touchAction.press(PointOption.point(fromX, fromY))
					.waitAction(new WaitOptions().withDuration(Duration.ofMillis(1000)))
					.moveTo(PointOption.point(toX, toY)).release().perform();
		}

	}

	public static void randomSwipe(int swipeCycle) {
		// calculate screen size
		DriverManager manager = DriverManager.getDriverManager();
		AppiumDriver<MobileElement> driver = manager.getDriver();
		manager.switchToWebContext();
		Dimension dimensions = driver.manage().window().getSize();
		int screenWidth = dimensions.getWidth();
		int screenHeight = dimensions.getHeight();

		int offsetx = (int) (dimensions.width / 2);
		int endY = (int) (dimensions.width * 0.20);
		int startY = (int) (dimensions.width * 0.80);

		touchAndSwipe(offsetx, startY, offsetx, endY, swipeCycle);
	}


}