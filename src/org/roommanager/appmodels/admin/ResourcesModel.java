package org.roommanager.appmodels.admin;

import org.openqa.selenium.By;

public enum ResourcesModel {
	ADDRESOURCEBTN(By.xpath("//div/div/button")),
	RESOURCEFILTER(By.xpath("//input[@type='text']")),
	FOLDERICON(By.cssSelector("span.fa.fa-desktop")),
	ERASERICON(By.cssSelector("span.fa.fa-eraser")),
	REMOVEBTN(By.id("btnRemove")),
	RESOURCESTABLE(By.xpath("//div[@id='resourcesGrid']/div[2]/div")),
	RESOURCENAME(By.xpath("//div/div/div[3]/div[2]/div/span"));
	public By value;
	private ResourcesModel(By locator){
		this.value=locator;
	}
}
