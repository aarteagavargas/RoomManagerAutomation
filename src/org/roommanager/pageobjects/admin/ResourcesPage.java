package org.roommanager.pageobjects.admin;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.roommanager.appmodels.admin.ResourcesModel;
import org.roommanager.common.Element;
import org.roommanager.utils.Log;

public class ResourcesPage {
	private WebElement element;
	private WebDriver driver;
	public ResourcesPage(WebDriver driver){
		this.driver = driver;
	}	
	By btnAddResourceLocator = ResourcesModel.ADDRESOURCEBTN.value;
	By filterResourcesLocator = ResourcesModel.RESOURCEFILTER.value;
	By btnRemoveResourceLocator = ResourcesModel.REMOVEBTN.value;
	By eraserIconResourceLocator=ResourcesModel.ERASERICON.value;
	By resourceTableLocator=ResourcesModel.RESOURCESTABLE.value;
	By nameResourceLocator=ResourcesModel.RESOURCENAME.value;

	private List<WebElement> getAllResources(){  	
		WebElement table=driver.findElement(resourceTableLocator);
		List<WebElement> elements= table.findElements(nameResourceLocator);
		return elements;
	}
	public boolean verifyThatAnResourceExist(String nameToFind){
		Element.waitForPresence(btnAddResourceLocator, 60);
		boolean result=false;
		List<WebElement> elements=getAllResources();
		for (WebElement webElement : elements) {
			String name=webElement.getText();
			if (name.equals(nameToFind)){
				Log.info("Resource "+nameToFind+" was found on the Resources grid");
				result=true;
				return result;
			}		
		}
		Log.info("Resource "+nameToFind+" was not found on the Resources grid");
		return result; 	
	}
	private WebElement getAnResource(String nameToFind){
		WebElement result=null;
		List<WebElement> elements=getAllResources();
		for (WebElement webElement : elements) {
			String name=webElement.getText();
			if (name.equals(nameToFind)){
				Log.info("Resource "+nameToFind+" was found on the Resources grid");
				return result=webElement;
			}		
		}
		if( result==null){
			Log.info("Resource "+nameToFind+" was not found on the Resources grid");
		}
		return result; 	
	}
	public String getIconResource(String resource){
		Element.waitForPresence(btnAddResourceLocator, 60);
		List<WebElement> elements= getAllResources();
		Integer i=0;
		String typeIcon="";
		for (WebElement webElement : elements) {
			String result=resource;
			String name=webElement.getText();
			if (name.equals(result)){
				if(i==0){
					String c="//div[@id='resourcesGrid']/div[2]/div/div/div[2]/div[2]/div/span";
					typeIcon=driver.findElement(By.xpath(c)).getAttribute("class");
				}
				else{
					String c="//div[@id='resourcesGrid']/div[2]/div/div["+i+"]/div[2]/div[2]/div/span";
					typeIcon=driver.findElement(By.xpath(c)).getAttribute("class");	
				}
				Log.info(resource+" has a type icon: "+typeIcon+ " that was found on the Resources grid");
			}
			i=i+1;	
		}
		return typeIcon;		
	}

	public CreateResourcePage clickAddButton(){  
		try{ 
			element=Element.waitForPresence(btnAddResourceLocator, 60);
			element.click();
			Log.info("Add button was found and clicked on the Resources Page");
		}catch (Exception e){
			Log.error("Add button was not found on the Resources Page");
			throw(e);
		} 
		return new CreateResourcePage(driver);
	} 
	public RemoveResourcePage clickRemoveButton(){  
		try{ 
			element=Element.waitForClickable(btnRemoveResourceLocator, 60);
			element.click();
			Log.info("Remove button was found and clicked on the Resources Page");
		}catch (Exception e){
			Log.error("Remove button was not found on the Resources Page");
			throw(e);
		} 
		return new RemoveResourcePage(driver);
	} 
	public ResourcesPage checkResource(String name){  
		try{ 
			element=getAnResource(name);
			element.click();
			Log.info("The resource was checked on the Resources grid");
		}catch (Exception e){
			Log.error("The resource was not checked on the Resources grid");
			throw(e);
		} 
		return this;
	} 
	public CreateResourcePage selectResource(String nameToFind){  
		try{ 
			element=getAnResource(nameToFind);
			Actions act = new Actions(driver);
			act.moveToElement(element);
			act.doubleClick();
			act.perform();
			Log.info("The resource details was opened ");
		}catch (Exception e){
			Log.error("The resource details was not opened");
			throw(e);
		} 
		return new CreateResourcePage(driver);
	}
	public ResourcesPage typeResourceOnFilter(String resourceName){  
		try{ 
			driver.navigate().refresh();
			element=Element.waitForPresence(filterResourcesLocator, 60);    
			element.clear();  
			element.sendKeys(resourceName);  
			Log.info(resourceName+" was typed on the filter on the Resources Page");
		}catch (Exception e){
			Log.error("Filter of resources was not found on the Resources Page");
			throw(e);
		}
		return this;	    
	}
}
