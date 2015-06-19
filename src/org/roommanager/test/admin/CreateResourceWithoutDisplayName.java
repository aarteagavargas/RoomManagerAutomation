package org.roommanager.test.admin;

import org.roommanager.utils.Log;
import org.roommanager.pageobjects.admin.*;
import org.roommanager.browser.BrowserManager;
import org.testng.annotations.*;
import static org.junit.Assert.*;
import org.openqa.selenium.*;

public class CreateResourceWithoutDisplayName{
  private LoginPage loginPage;
  private  static WebDriver driver;
  @BeforeSuite
  public void setUp( ) throws Exception {	
	  driver=BrowserManager.getDriver() ;     
  }
  @Test
  public void testCreateResourceWithoutDisplayName() throws Exception {	
	  	//Variables
	  	String Name="Monitor";
	    String expectedResult= "Display name must not be empty";
	    String errorMessage= "Test failed: The resource was created without display name";
	    //Test
	    Log.startTestCase("CreateResourceWithoutDisplayName"); 
	    loginPage= new LoginPage(driver);
		CreateResourcePage createResourcePage= loginPage
			.clickSignInButton()
			.selectResources()
			.clickAddButton()
			.typeResourceName(Name);
		createResourcePage
			.clickSaveButton();
		//Assertion
		assertEquals(errorMessage,expectedResult,createResourcePage.getErrorMessageDisplayName());    
		
		createResourcePage.clickCloseWindow();
	    Log.endTestCase("CreateResourceWithoutDisplayName");
  }
  @AfterSuite
  public void tearDown() throws Exception {
    driver.close();  
  }
}
