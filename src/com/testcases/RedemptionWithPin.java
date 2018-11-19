package com.testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

import com.objectRepository.WFMLocators;
import com.utility.BaseClass;
import com.utility.ReadData;

public class RedemptionWithPin extends BaseClass{

	public RedemptionWithPin(ReadData readData) {
		this.readData = readData;
	}
	WFMLocators loc = new WFMLocators();
	BaseClass baseclass = new BaseClass();
	public void redemptionMyFamilyMobile(String strPIN) throws Exception {
		/*if(click(loc.myAccountLink)){
			readData.addStepDetails("activateFamilyMobile","Application should click the ACTIVATE link","Successfully clicked the ACTIVATE link" ,"Pass", "Y");	
		}
		else{
			readData.addStepDetails("activateFamilyMobile","Application should click the ACTIVATE link","Failed to click the ACTIVATE link" ,"Fail", "N");
		}
		if(type(loc.txtPhone,strMin)){
			readData.addStepDetails("activateFamilyMobile","Application should click the ACTIVATE link","Successfully clicked the ACTIVATE link" ,"Pass", "Y");	
		}
		else{
			readData.addStepDetails("activateFamilyMobile","Application should click the ACTIVATE link","Failed to click the ACTIVATE link" ,"Fail", "N");
		}
		if(click(loc.btnContinue)){
			readData.addStepDetails("activateFamilyMobile","Application should click the ACTIVATE link","Successfully clicked the ACTIVATE link" ,"Pass", "Y");	
		}
		else{
			readData.addStepDetails("activateFamilyMobile","Application should click the ACTIVATE link","Failed to click the ACTIVATE link" ,"Fail", "N");
		}
		if(type(loc.txtPassword1,readData.testDataValue.get("Password"))){
			readData.addStepDetails("activateFamilyMobile","Application should click the ACTIVATE link","Successfully clicked the ACTIVATE link" ,"Pass", "Y");	
		}
		else{
			readData.addStepDetails("activateFamilyMobile","Application should click the ACTIVATE link","Failed to click the ACTIVATE link" ,"Fail", "N");
		}
		if(click(loc.btnLogIn)){
			readData.addStepDetails("activateFamilyMobile","Application should click the ACTIVATE link","Successfully clicked the ACTIVATE link" ,"Pass", "Y");	
		}
		else{
			readData.addStepDetails("activateFamilyMobile","Application should click the ACTIVATE link","Failed to click the ACTIVATE link" ,"Fail", "N");
		}*/
		//
		if(click(loc.payServiceLink)){
			readData.addStepDetails("activateFamilyMobile","Application should click the PAY SERVICE link","Successfully clicked the PAY SERVICE link" ,"Pass", "Y");	
		}
		else{
			readData.addStepDetails("activateFamilyMobile","Application should click the PAY SERVICE link","Failed to click the PAY SERVICE link" ,"Fail", "N");
		}
		//Thread.sleep(1000);
		//Changes
		if(type(loc.enterPhoneNumber,"3052986588")) {
			readData.addStepDetails("activateFamilyMobile","Application should enter Phone number","Successfully entered Phone number" ,"Pass", "Y");	
		}
		else{
			readData.addStepDetails("activateFamilyMobile","Application should enter Phone number","Failed to enter Phone number" ,"Fail", "N");
		}
		if(type(loc.txtPin,strPIN)) {
			readData.addStepDetails("activateFamilyMobile","Application should enter Phone number","Successfully entered Phone number" ,"Pass", "Y");	
		}
		else{
			readData.addStepDetails("activateFamilyMobile","Application should enter Phone number","Failed to enter Phone number" ,"Fail", "N");
		}
		/*if(click(loc.dropDownSelectDevice)) {
			Thread.sleep(1000);
			click(By.xpath("//span[contains(text(),'(305) 896-1386')]"));
			readData.addStepDetails("activateFamilyMobile","Application should enter Phone number","Successfully entered Phone number" ,"Pass", "Y");	
		}
		else{
			readData.addStepDetails("activateFamilyMobile","Application should enter Phone number","Failed to enter Phone number" ,"Fail", "N");
		}*/
		
		if(click(loc.btnAddServicePlan1)) {
			readData.addStepDetails("activateFamilyMobile","Application should click the Add Service Plan button","Successfully clicked Add Service Plan button" ,"Pass", "Y");	
		}
		else{
			readData.addStepDetails("activateFamilyMobile","Application should click the Add Service Plan button","Failed to click Add Service Plan button" ,"Fail", "N");
		}
		baseclass.waitForElement(loc.btnDone, 10);
		if(click(loc.btnDone)) {
			readData.addStepDetails("activateFamilyMobile","Application should click the Done Button","Successfully clicked the Done Button" ,"Pass", "Y");	
		}
		else{
			readData.addStepDetails("activateFamilyMobile","Application should click the Done Button","Failed to click the Done Button" ,"Fail", "N");
		}
	}

}
