package org.roommanager.pageobjects.admin;
import org.roommanager.utils.Log;
import org.roommanager.utils.ReadConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.roommanager.appmodels.admin.LoginModel;
import org.roommanager.common.Element;
import org.roommanager.pageobjects.admin.HomePage;

public class LoginPage {
	private WebDriver driver;
	private WebElement element;
	private String baseUrl=ReadConfig.getBaseUrl();
	public LoginPage(WebDriver driver){
		this.driver = driver;
		this.driver.get(baseUrl + "/admin/#/login");
		Log.info("Web application launched successfully");
	}	
	By signInButtonLocator = LoginModel.SIGNINBTN.value;
	public HomePage clickSignInButton(){  
		try{ 
			driver.navigate().refresh();
			element=Element.waitForPresence(signInButtonLocator, 60); 
			element.click();
			Log.info("SignIn button was found and clicked on the Login Page");
		}catch (Exception e){
			Log.error("SignIn button was not found on the Login Page");
			throw(e);
		}
		return new HomePage(driver);
	}  		
}

