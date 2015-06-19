package org.roommanager.utils;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.roommanager.browser.BrowserManager;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listener implements ITestListener {
	WebDriver driver=null;
	String filePath = "screenshots//";
    @Override
    public void onTestFailure(ITestResult result) {
    	Log.info("The test: "+result.getName()+"was failed and it has taken a screenshot");
    	String methodName=result.getName().toString().trim();
    	takeScreenShot(methodName);
    }
    public void takeScreenShot(String methodName) {
    	 driver=BrowserManager.getDriver();
    	 File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            try {
				FileUtils.copyFile(scrFile, new File(filePath+methodName+".png"));
			} catch (IOException e) {
				e.printStackTrace();
			}
    }
	public void onFinish(ITestContext context) {}
  
    public void onTestStart(ITestResult result) {   }
  
    public void onTestSuccess(ITestResult result) {   }

    public void onTestSkipped(ITestResult result) { 
    	Log.info("The test: "+result.getName()+"was skipped");
    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {   }

    public void onStart(ITestContext context) {   }
}  