package org.roommanager.test.admin;

import org.roommanager.utils.ApiRoomManager;
import org.roommanager.utils.Log;
import org.roommanager.pageobjects.admin.*;
import org.roommanager.browser.BrowserManager;
import org.testng.annotations.*;

import static org.junit.Assert.*;

import org.openqa.selenium.*;

public class UpdateIconResource{
	private LoginPage loginPage;
	private  static WebDriver driver;
	private String id;
	@BeforeSuite
	public void setUp( ) throws Exception {	
		driver=BrowserManager.getDriver() ; 
	}
	@BeforeTest
	public void testsetUp( ) throws Exception {	
		Log.startTestCase("Update Icon Resource");  
		String name="FolderResource";
		String displayName="FolderResource";
		String iconType="fa fa-folder";
		String description="fa fa-folder";
		//Precondition: To have one created FOLDER resource to update
		id=ApiRoomManager.createResource(name,displayName,iconType,description);
	}
	@Test
	public void testUpdateIconResource() throws Exception {
		//Variables
		String nameResource="FolderResource";
		String expectedIcon="fa fa-eraser";
		String errorMessage= "Test failed: The Icon resource was not updated";
		//Test
		loginPage= new LoginPage(driver);
		ResourcesPage resourcesPage=loginPage
				.clickSignInButton()
				.selectResources()
				.selectResource(nameResource)
				.clickIconsButton()
				.selectEraserIcon()
		        .clickSaveButton();
		//Assertion
		assertEquals(errorMessage,expectedIcon,resourcesPage.getIconResource(nameResource));
	}
	@AfterTest
	public void testtearDown( ) throws Exception {	
		//Postcondition: Remove the created resource to duplicate
		ApiRoomManager.deleteResource(id);
		Log.endTestCase("UpdateIconResource");
	}
	@AfterSuite
	public void tearDown() throws Exception {
		driver.quit();  
	}
}
