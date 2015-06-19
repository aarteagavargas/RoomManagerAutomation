package org.roommanager.appmodels.admin;

import org.openqa.selenium.By;

public enum RemoveResourceModel {
	REMOVEBTN(By.cssSelector("button.info"));
	public By value;  
    private RemoveResourceModel(By locator){
           this.value = locator;          
    }
}
