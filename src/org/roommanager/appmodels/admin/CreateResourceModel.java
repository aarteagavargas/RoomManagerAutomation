package org.roommanager.appmodels.admin;

import org.openqa.selenium.By;

public enum CreateResourceModel {
	RESOURCENAMETXTFIELD(By.xpath("(//input[@type='text'])[3]")),
	RESOURCEDISPLAYNAMETXTFIELD(By.xpath("(//input[@type='text'])[4]")),
	RESOURCEICONS(By.id("convert")),
	FOLDERICON(By.xpath("//button[@value='fa-folder']")),
	ERASERICON(By.xpath("//button[@value='fa-eraser']")),
	SAVEBTN(By.cssSelector("button.info")),
	CLOSEBTN(By.xpath("//span/i")),
	ERRORMESSAGENAME(By.xpath("//small[4]")),
	ERRORMESSAGEDUPLICATE(By.xpath("//small[2]")),
	ERRORMESSAGEDISPLAYNAME(By.xpath("//small[5]"));
	public By value;
	CreateResourceModel(By locator){
		this.value=locator;		
	}
}
