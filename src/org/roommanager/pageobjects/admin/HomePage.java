package org.roommanager.pageobjects.admin;
import org.openqa.selenium.*;
import org.roommanager.appmodels.admin.HomeModel;
import org.roommanager.common.Element;
import org.roommanager.pageobjects.admin.ResourcesPage;
import org.roommanager.utils.Log;



public class HomePage {
    private  WebElement element = null;
    private  WebDriver driver;
   
public HomePage(WebDriver driver){
	this.driver = driver;
}	 
	By lnkResourcesLocator = HomeModel.RESOURCESLNK.value;
	By lnkEmailServerLocator = HomeModel.EMAILLNK.value;
	public ResourcesPage selectResources() throws Exception{  
	    selectLink(lnkResourcesLocator,"Resources"); 
	    return new ResourcesPage(driver);
	}
	private void selectLink(By locator,String option) throws Exception {
		try{ 
	    	element=Element.waitForPresence(locator, 60);
	    	Log.info(option+" option was found and selected on the Home Page");
	    	element.click();
	   }catch (Exception e){	
		   Log.error(option+" option was not found on the Home Page");
		   throw(e);
	  		}
	}
	public EmailServerPage selecteEmailServer() throws Exception{  
	    selectLink(lnkEmailServerLocator,"Email Server"); 
	    return new EmailServerPage();
	}
		
}

