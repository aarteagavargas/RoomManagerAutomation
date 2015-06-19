package org.roommanager.pageobjects.admin;

import org.openqa.selenium.*;
import org.roommanager.appmodels.admin.CreateResourceModel;
import org.roommanager.common.Element;
import org.roommanager.pageobjects.admin.ResourcesPage;
import org.roommanager.utils.Log;

public class CreateResourcePage {
	private WebElement element;
    private WebDriver driver;
    public CreateResourcePage(WebDriver driver){
    	this.driver = driver;
    }
	By resourceNameLocator = CreateResourceModel.RESOURCENAMETXTFIELD.value;
	By resourceDisplayNameLocator = CreateResourceModel.RESOURCEDISPLAYNAMETXTFIELD.value;
	By resourceIconsLocator = CreateResourceModel.RESOURCEICONS.value;
	By folderIconLocator = CreateResourceModel.FOLDERICON.value;
	By eraserIconLocator = CreateResourceModel.ERASERICON.value;
	By bntSaveLocator = CreateResourceModel.SAVEBTN.value;
	By bntCloseLocator = CreateResourceModel.CLOSEBTN.value;
	By errorMessageName =CreateResourceModel.ERRORMESSAGENAME.value;
	By errorMessageDisplayName =CreateResourceModel.ERRORMESSAGEDISPLAYNAME.value;
	By errorMessageDuplicate =CreateResourceModel.ERRORMESSAGEDUPLICATE.value;
	
	public CreateResourcePage typeResourceName(String resourceName){  
		try{ 
			element=Element.waitForPresence(resourceNameLocator, 60); 
			element.clear();  
		    element.sendKeys(resourceName);  
		    Log.info(resourceName+" was typed on the Name text box on the Create Resource form");
		}catch (Exception e){	
			Log.error("Name text box was not found on Create Resource form");
			throw(e);
	  		}
	    return this;	    
	}
	public CreateResourcePage typeResourceDisplayName(String resourceDisplayName){  
			
			try{ 
				element=Element.waitForPresence(resourceDisplayNameLocator, 60);
				element.clear();  
			    element.sendKeys(resourceDisplayName);  
			    Log.info(resourceDisplayName+" was typed on the Display Name text box on the Create Resource form");
			}catch (Exception e){	
				Log.error("Display Name text box was not found on Create Resource form");
				throw(e);
		  		}
		    return this;    
		}

	public ResourcesPage clickSaveButton(){  

		try{ 
			element=Element.waitForPresence(bntSaveLocator, 60);      
		    element.click();
		    Log.info("Save button was found and clicked on the Create Resource form");
	    }catch (Exception e){	
	    	Log.error("Save button was not found on Create Resource form");
	    	throw(e);
	  		}   
	    return new ResourcesPage(driver);   
	}
	public ResourcesPage clickCloseWindow(){  
	    try{ 
	    	element=Element.waitForPresence(bntCloseLocator, 60);
	    	element.click();
		    Log.info("Close button was found and clicked on the Create Resource form");
	    }catch (Exception e){	
	    	Log.error("Close button was not found on Create Resource form");
	    	throw(e);
	  		}  
	    return new ResourcesPage(driver);   
	}
	public CreateResourcePage clickIconsButton(){  
	    try{ 
	    	element=Element.waitForClickable(resourceIconsLocator, 60);      
	    	element.click();
		    Log.info("Icon combo box was found and clicked on the Create Resource form");
	    }catch (Exception e){	
	    	Log.error("Icon combo box was not found on Create Resource form");
	    	throw(e);
	  		}
	    return this;   
	}
	private void selectIcon(By locator){  
	    try{ 
	    	element=Element.waitForPresence(locator, 60 );  
	    	element.click();
		    Log.info("The icon was found and selected on the Icon combo box");
	    }catch (Exception e){	
	    	Log.error("The icon was not found on the Icon combo box");
	    	throw(e);
	  		}    
	}
	public CreateResourcePage selectFolderIcon(){  
		selectIcon(folderIconLocator);
	    return this;   
	}
	public CreateResourcePage selectEraserIcon(){  
		selectIcon(eraserIconLocator);
	    return this;   
	}
	private String getErrorMessage(By errorLocator){  
		String errorMessage;
		try{ 
	    	//wait 60 and get the MESSAGE ERROR 
			errorMessage=Element.waitForPresence(errorLocator, 60).getText();
		    Log.info("Error Message was displayed  on the text box");
	    }catch (Exception e){	
	    	Log.error("Error Message was not displayed on the text box");
	    	throw(e);
	  		}  
	    return errorMessage;   
	}
	public String getErrorMessageName(){  
		String errorMessage=getErrorMessage(errorMessageName);
		return errorMessage;  
	}
	public String getErrorMessageDisplayName(){  
		String errorMessage=getErrorMessage(errorMessageDisplayName);
		return errorMessage; 
	}
	public String getErrorMessageDuplicate(){  
		String errorMessage=getErrorMessage(errorMessageDuplicate);
		return errorMessage; 
	}
}
