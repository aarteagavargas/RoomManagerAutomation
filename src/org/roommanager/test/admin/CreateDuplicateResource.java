package org.roommanager.test.admin;

import org.roommanager.utils.ApiRoomManager;
import org.roommanager.utils.Log;
import org.roommanager.pageobjects.admin.*;
import org.roommanager.browser.BrowserManager;
import org.testng.annotations.*;

import static org.junit.Assert.*;

import org.openqa.selenium.*;

public class CreateDuplicateResource{
	private LoginPage loginPage;
	private static WebDriver driver;
	private String id;
	@BeforeSuite
	public void setUp( ) throws Exception {	
		driver=BrowserManager.getDriver() ; 
	}
	@BeforeTest
	public void testsetUp( ) throws Exception {	
		Log.startTestCase("CreateDuplicateResource");
		String name="ResourceToDuplicate";
		String displayName="ResourceToDuplicate";
		String iconType="fa fa-folder";
		String description="ResourceToDuplicate";
		//Precondition: To have one created resource to duplicate
		id=ApiRoomManager.createResource(name,displayName,iconType,description);
	}
	@Test
	public void testCreateDuplicateResource() throws Exception {
		//Variables
		String nameResource="ResourceToDuplicate";
		String displayNameResource="ResourceToDuplicate";
		String expectedResult="A resource with the same name already exists, please choose another name";
		String errorMessage= "Test failed: The duplicate resource was created";
		//Test
		loginPage= new LoginPage(driver);
		CreateResourcePage createResourcePage=loginPage
				.clickSignInButton()
				.selectResources()
				.clickAddButton()
				.typeResourceName(nameResource)
				.typeResourceDisplayName(displayNameResource)
				.clickIconsButton()
				.selectFolderIcon();
		createResourcePage.clickSaveButton();
		//Assertion
		assertEquals(errorMessage,expectedResult,createResourcePage.getErrorMessageDuplicate() );
		createResourcePage.clickCloseWindow();
		
	}
	@AfterTest
	public void testtearDown( ) throws Exception {	
		//Postcondition: Remove the created resource to duplicate
		ApiRoomManager.deleteResource(id);
		Log.endTestCase("CreateDuplicateResource");
	}
	@AfterSuite
	public void tearDown() throws Exception {
		driver.quit();  
	}
}
