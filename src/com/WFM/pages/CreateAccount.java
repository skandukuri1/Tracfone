package com.WFM.pages;

import org.apache.commons.lang3.RandomStringUtils;

import com.objectRepository.WFMLocators;
import com.utility.BaseClass;
import com.utility.ReadData;

public class CreateAccount extends BaseClass{

	public void createAccount(ReadData readData) throws Exception{
		WFMLocators loc = new WFMLocators();
		String RandomString = RandomStringUtils.random(3, false, true);
	
	if(type(loc.txtEmailID, (readData.testDataValue.get("EmailID"))+RandomString+"@wfm.com")){
		System.out.println((readData.testDataValue.get("EmailID"))+RandomString+"@wfm.com");
		readData.addStepDetails("activateFamilyMobile","Application should enter the Email ID","Successfully entered the Email ID" ,"Pass", "Y");
	}
	else{
		readData.addStepDetails("activateFamilyMobile","Application should enter the Email ID","Failed to enter the Email ID" ,"Fail", "N");
	}
	if(type(loc.txtDOB, readData.testDataValue.get("DOB"))){
		readData.addStepDetails("activateFamilyMobile","Application should enter the DOB","Successfully entered the DOB" ,"Pass", "Y");
	}
	else{
		readData.addStepDetails("activateFamilyMobile","Application should enter the DOB","Failed to enter the DOB" ,"Fail", "N");
	}
	if(type(loc.txtPassword, readData.testDataValue.get("Password"))){
		readData.addStepDetails("activateFamilyMobile","Application should enter the Password","Successfully entered the Password" ,"Pass", "Y");
	}
	else{
		readData.addStepDetails("activateFamilyMobile","Application should enter the Password","Failed to enter the Password" ,"Fail", "N");
	}
	if(type(loc.txtConfirmPassword, readData.testDataValue.get("ConfirmPassword"))){
		readData.addStepDetails("activateFamilyMobile","Application should enter the Confirm Password","Successfully entered the Confirm Password" ,"Pass", "Y");
	}
	else{
		readData.addStepDetails("activateFamilyMobile","Application should enter the Confirm Password","Failed to enter the Confirm Password" ,"Fail", "N");
	}
	if(type(loc.txtAccountPIN, readData.testDataValue.get("AccountPIN"))){
		readData.addStepDetails("activateFamilyMobile","Application should enter the Account PIN","Successfully entered the Account PIN" ,"Pass", "Y");
	}
	else{
		readData.addStepDetails("activateFamilyMobile","Application should enter the Account PIN","Failed to enter the Account PIN" ,"Fail", "N");
	}
	if(click(loc.btnCreateAccount)){
		readData.addStepDetails("activateFamilyMobile","Application should click the Create Account button","Successfully clicked on the Create Account button" ,"Pass", "Y");
	}
	else{
		readData.addStepDetails("activateFamilyMobile","Application should click the Create Account button","Failed to click on the Create Account button" ,"Fail", "N");
	}
	if(click(loc.cntThankYou)){
		readData.addStepDetails("activateFamilyMobile","Application should click the Continue button at Account Creation","Successfully clicked on the Continue button at Account Creation" ,"Pass", "Y");
	}
	else{
		readData.addStepDetails("activateFamilyMobile","Application should click the Continue button at Account Creation","Failed to click on the Continue button at Account Creation" ,"Fail", "N");
	}
	
	}
}
