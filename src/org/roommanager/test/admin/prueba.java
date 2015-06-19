package org.roommanager.test.admin;

import java.util.List;
import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;

import org.junit.*;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.roommanager.utils.Log;

public class prueba {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "http://172.20.208.174:4044/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    driver.manage().window().maximize() ;
  }

  @Test
  public void testPrueba() throws Exception {
	 By  ResourceTableLocator=By.xpath("//div[@id='resourcesGrid']/div[2]/div");
	 By nameResourceLocator=By.xpath("//div/div/div[3]/div[2]/div/span");
	
    driver.get(baseUrl + "/admin/#/login");
    driver.findElement(By.xpath("//button")).click();
    driver.findElement(By.linkText("Resources")).click();
    Thread.sleep(3000);
	WebElement table=driver.findElement(ResourceTableLocator);
    List<WebElement> elements= table.findElements(nameResourceLocator);
    Integer i=0;
	for (WebElement webElement : elements) {
		String result="hola";
		String name=webElement.getText();
		if (name.equals(result)){
			if(i==0){
				System.out.println("Se encontro " + name+"position: "+ i);
				String c="//div[@id='resourcesGrid']/div[2]/div/div/div[2]/div[2]/div/span";
				System.out.println(driver.findElement(By.xpath(c)).getAttribute("class"));
			}
			else{
				System.out.println("Se encontro " + name+"position: "+ i);
				String c="//div[@id='resourcesGrid']/div[2]/div/div["+i+"]/div[2]/div[2]/div/span";
				System.out.println(driver.findElement(By.xpath(c)).getAttribute("class"));	
			}
			
		}
		else{
			System.out.println("No:"+name);
		}
		i=i+1;	
	}
	
  }

  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}

