package org.roommanager.pageobjects.admin;
import org.openqa.selenium.*;
import org.roommanager.appmodels.admin.RemoveResourceModel;
import org.roommanager.common.Element;
import org.roommanager.pageobjects.admin.ResourcesPage;
import org.roommanager.utils.Log;



public class RemoveResourcePage {
    private  WebElement element = null;
    private  WebDriver driver;
   
public RemoveResourcePage(WebDriver driver){
	this.driver = driver;
}	 
	By btnRemoveLocator = RemoveResourceModel.REMOVEBTN.value;
	public ResourcesPage clickRemoveConfirmButton(){  
	    try{ 
	    	element=Element.waitForPresence(btnRemoveLocator, 60);
	    	Log.info("Remove button was found and selected on the Remove Resource form");
	    	element.click();
	   }catch (Exception e){	
		   Log.error("Remove button was not found on the Remove Resource form");
		   throw(e);
	  		} 
	    return new ResourcesPage(driver);
	}
		
}