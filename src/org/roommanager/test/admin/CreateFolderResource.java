package org.roommanager.test.admin;

import static org.junit.Assert.assertEquals;

import org.roommanager.utils.Log;
import org.roommanager.pageobjects.admin.*;
import org.roommanager.browser.BrowserManager;
import org.testng.annotations.*;
import org.openqa.selenium.*;

public class CreateFolderResource{
	private static WebDriver driver;
	private LoginPage loginPage;
	private ResourcesPage resourcesPage;
	private String name;

	@BeforeSuite
	public void setUp() throws Exception {	
		driver=BrowserManager.getDriver() ;    
	}
	@Test
	public void testCreateFolderResource() throws Exception { 
		//Variables
		name="Folder";
		String displayName="DisplayNameFolder";
		String expectedIconFolder="fa fa-folder";
		String errorMessage= "Test failed: The folder resource was not created";
		//Test
		Log.startTestCase("CreateFolderResource"); 
		loginPage= new LoginPage(driver);
		resourcesPage=loginPage
				.clickSignInButton()
				.selectResources()
				.clickAddButton()
				.typeResourceName(name)
				.typeResourceDisplayName(displayName)
				.clickIconsButton()
				.selectFolderIcon()
				.clickSaveButton();
		//Assertion 
		assertEquals(errorMessage,expectedIconFolder,resourcesPage.getIconResource(name));
	}
	@AfterTest
	public void testtearDown( ) throws Exception {	
		//Postcondition: Remove the created resource to duplicate
		resourcesPage
		.checkResource(name)
		.clickRemoveButton()
		.clickRemoveConfirmButton();
		Log.endTestCase("CreateFolderResource");
	}
	@AfterSuite
	public void tearDown() throws Exception {
		driver.close();
	}
}
