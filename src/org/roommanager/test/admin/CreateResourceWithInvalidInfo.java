package org.roommanager.test.admin;

import org.roommanager.utils.Log;
import org.roommanager.pageobjects.admin.*;
import org.roommanager.browser.BrowserManager;
import org.testng.annotations.*;

import static org.junit.Assert.*;

import org.openqa.selenium.*;

public class CreateResourceWithInvalidInfo{
	private LoginPage loginPage;
	private  static WebDriver driver;
	@BeforeSuite
	public void setUp( ) throws Exception {	
		driver=BrowserManager.getDriver() ; 
	}
	@Test
	public void testCreateResourceWithInvalidInfo() throws Exception {
		//Variables
		String invalidName="Monitor-01";
		String expectedResult= "Invalid name, A-Z, a-z, 0-9 and \"_\" are the allowed characters only";
		String errorMessage= "Test failed: The resource was created with an invalid name";
		//Test
		loginPage= new LoginPage(driver);
		CreateResourcePage createResourcePage= loginPage
				.clickSignInButton()
				.selectResources()
				.clickAddButton()
				.typeResourceName(invalidName);
		createResourcePage.clickSaveButton();
		//Assertion
		assertEquals(errorMessage,expectedResult,createResourcePage.getErrorMessageName());		
		
		createResourcePage.clickCloseWindow();
		Log.endTestCase("CreateResourceWithInvalidInfo");
	}
	@AfterSuite
	public void tearDown() throws Exception {
		driver.quit();  
	}
}
