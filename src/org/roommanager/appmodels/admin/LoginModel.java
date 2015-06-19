package org.roommanager.appmodels.admin;

import org.openqa.selenium.By;

public enum LoginModel {
      SIGNINBTN(By.xpath("//button"));
      public By value;  
      private LoginModel(By locator){
             this.value = locator;          
      }
}

