package com.components;
import org.openqa.selenium.Keys;

import org.openqa.selenium.interactions.Actions;

import com.objectRepository.WFMLocators;
import com.utility.BaseClass;
import com.utility.ReadData;
import org.apache.commons.lang3.RandomStringUtils;

public class Components extends BaseClass{

	WFMLocators loc = new WFMLocators();
	public Components(ReadData readData){
		this.readData=readData;
	}
/*
 * 
 * 
 * 
 * 
 */
	String RandomString = RandomStringUtils.random(3, false, true);
	public void launchApp() throws Exception{
		try{
			openBrowser("chrome");
			openURL(readData.testDataValue.get("AppURL"));
			checkPageLoad();
			readData.addStepDetails("launchApp","Application should open the url","Successfully opened the URL" ,"Pass", "Y");
		}catch(Exception e){
			readData.addStepDetails("launchApp","Application should open the url","unable to open the URL" ,"Fail", "N");	
		}
	}
	
	public void viewLaunchApp() throws Exception{
		try{
			openBrowser("chrome");
			openURL(readData.testDataValue.get("AppURL"));
			checkPageLoad();
			driver.getPageSource();
			Actions act = new Actions(driver);
			act.sendKeys(Keys.F12).build().perform();
			Thread.sleep(2000);
			String strContent = driver.findElement(loc.ogTitle).getAttribute("content");
			System.out.println("Title of the page is: "+strContent);
			//String sPageName = (String)((JavascriptExecutor)driver).executeScript("return s.getPageName();");

//			getToolTipText(loc.ogTitle,"content");
			readData.addStepDetails("launchApp","Application should open the url","Successfully opened the URL" ,"Pass", "Y");
		}catch(Exception e){
			readData.addStepDetails("launchApp","Application should open the url","unable to open the URL" ,"Fail", "N");	
		}
	}

	}