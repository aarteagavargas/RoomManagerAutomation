package org.roommanager.common;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.roommanager.browser.BrowserManager;

public class Element {
	
	private static WebDriver driver=BrowserManager.getDriver();

	public static WebElement waitForPresence(By locator,Integer time){	 
		WebElement element =(new WebDriverWait(driver, time))
			    .until(ExpectedConditions
			    		.presenceOfElementLocated(locator));
	 	return element;
	}
	public static WebElement waitForClickable(By locator,Integer time){	 
		WebElement element =(new WebDriverWait(driver, time))
			    .until(ExpectedConditions
			    		.elementToBeClickable(locator));
	 	return element;
	}
}
