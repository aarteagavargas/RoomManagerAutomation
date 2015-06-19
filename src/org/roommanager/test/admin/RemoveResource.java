package org.roommanager.test.admin;

import org.roommanager.utils.ApiRoomManager;
import org.roommanager.utils.Log;
import org.roommanager.pageobjects.admin.*;
import org.roommanager.browser.BrowserManager;
import org.testng.annotations.*;

import static org.junit.Assert.*;

import org.openqa.selenium.*;

public class RemoveResource{
	private LoginPage loginPage;
	private  static WebDriver driver;
	@BeforeSuite
	public void setUp( ) throws Exception {	
		driver=BrowserManager.getDriver() ; 
	}
	@BeforeTest
	public void testsetUp( ) throws Exception {	
		Log.startTestCase("RemoveResource");  
		String name="ResourceToRemove";
		String displayName="ResourceToRemove";
		String iconType="fa fa-folder";
		String description="ResourceToRemove";
		//Precondition: To have one created resource to remove
		ApiRoomManager.createResource(name,displayName,iconType,description);
	}
	@Test
	public void testRemoveResource() throws Exception {
		//Variables
		String nameResource="ResourceToRemove";
		String errorMessage= "Test failed: The resource was not removed";
		//Test
		loginPage= new LoginPage(driver);
		boolean actualResutl=loginPage
				.clickSignInButton()
				.selectResources()
				.checkResource(nameResource)
				.clickRemoveButton()
				.clickRemoveConfirmButton()
				.verifyThatAnResourceExist(nameResource);
		//Assertion
		assertEquals(errorMessage,false,actualResutl);
		
		Log.endTestCase("RemoveResource");
	}
	@AfterSuite
	public void tearDown() throws Exception {
		driver.close();  
	}
}
