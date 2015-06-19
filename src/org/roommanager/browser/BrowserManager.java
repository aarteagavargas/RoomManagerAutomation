package org.roommanager.browser;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.roommanager.utils.Log;


public class BrowserManager {

	   //Create an object of SingleObject
	   private static BrowserManager _manager = new BrowserManager();
	   private static WebDriver driver;

	   //Private constructor 
	   private BrowserManager(){}

	   //Get the only object available
	   public static BrowserManager Instance(){
		   return _manager;
	   }

	   public static WebDriver getDriver(){
		   if (driver == null)
           {
			   
			   DOMConfigurator.configure("config//log4j.xml");
			   System.setProperty("webdriver.chrome.driver", "lib//chromedriver.exe");
			   driver = new ChromeDriver();
			   driver.manage().deleteAllCookies();
			   Log.info("New driver instantiated");
			   driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); 
			   Log.info("Implicit wait applied on the driver for 30 seconds");
			   driver.manage().window().maximize();
			   Log.info("The application window was maximized ");
           } 
		   return driver;
	   }
	}
