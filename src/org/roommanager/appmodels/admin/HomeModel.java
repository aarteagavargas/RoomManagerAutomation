package org.roommanager.appmodels.admin;

import org.openqa.selenium.By;


public enum HomeModel {
	RESOURCESLNK (By.linkText("Resources")),
	EMAILLNK(By.linkText("Email Servers"));
	public By value;  
	private HomeModel(By locator){
		this.value = locator;            
	}
}
