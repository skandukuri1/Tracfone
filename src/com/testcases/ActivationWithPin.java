package com.testcases;

import java.util.ArrayList;

import org.apache.commons.lang3.RandomStringUtils;

import com.WFM.pages.CreateAccount;
import com.objectRepository.WFMLocators;
import com.utility.BaseClass;
import com.utility.DBConnections;
import com.utility.ReadData;

public class ActivationWithPin extends BaseClass {
	
	WFMLocators loc = new WFMLocators();
	CreateAccount createAccount = new CreateAccount();
	//DBConnections dbconn = new DBConnections();
	String RandomString = RandomStringUtils.random(3, false, true);
	public String MIN = null;
	public String status = null;
	public ActivationWithPin(ReadData readData) {
		this.readData = readData;
	}
	public String activateFamilyMobile(String strSIM,String strPIN, String strESN) throws Exception{
		if(click(loc.activeLink)){
			readData.addStepDetails("activateFamilyMobile","Application should click the ACTIVATE link","Successfully clicked the ACTIVATE link" ,"Pass", "Y");	
		}
		else{
			readData.addStepDetails("activateFamilyMobile","Application should click the ACTIVATE link","Failed to click the ACTIVATE link" ,"Fail", "N");
		}

		if(click(loc.cntFamilyMobile)){
			readData.addStepDetails("activateFamilyMobile","Application should click the Continue link","Successfully clicked the Continue link" ,"Pass", "Y");
		}
		else{
			readData.addStepDetails("activateFamilyMobile","Application should click the Continue link","Failed to click the Continue link" ,"Fail", "N");
		}

		if(type(loc.txtSIMEntry, strSIM)){
			readData.addStepDetails("activateFamilyMobile","Application should enter the SIM number","Successfully entered the SIM number" ,"Pass", "Y");
		}
		else{
			readData.addStepDetails("activateFamilyMobile","Application should enter the SIM number","Failed to enter the SIM number" ,"Fail", "N");
		}
		if(click(loc.chkSIMConfirm)){
			click(loc.cntSIMConfirm);
			readData.addStepDetails("activateFamilyMobile","Application should accept the conditions by checking","Successfully checked the condition" ,"Pass", "Y");
		}
		else{
			readData.addStepDetails("activateFamilyMobile","Application should accept the conditions by checking","Failed to check the condition" ,"Fail", "N");
		}

		/*if(click(loc.cntSIMConfirm)){
			readData.addStepDetails("activateFamilyMobile","Application should click the Continue link","Successfully clicked on the Continue link" ,"Pass", "Y");
		}
		else{
			readData.addStepDetails("activateFamilyMobile","Application should click the Continue link","Failed to click on the Continue link" ,"Fail", "N");
		}*/
		if(type(loc.txtSecurePIN, readData.testDataValue.get("SecurePIN"))){
			click(loc.cntSecurePIN);
			readData.addStepDetails("activateFamilyMobile","Application should enter the SecurityPIN","Successfully entered the SecurityPIN" ,"Pass", "Y");
		}
		else{
			readData.addStepDetails("activateFamilyMobile","Application should enter the SecurityPIN","Failed to enter the SecurityPIN" ,"Fail", "N");
		}
		/*if(click(loc.cntSecurePIN)){
			readData.addStepDetails("activateFamilyMobile","Application should click the Continue link at SecurityPIN page","Successfully clicked the Continue link at SecurityPIN page" ,"Pass", "Y");
		}
		else{
			readData.addStepDetails("activateFamilyMobile","Application should click the Continue link at SecurityPIN page","Failed to click the Continue link at SecurityPIN page" ,"Fail", "N");
		}*/
		if(type(loc.txtEnterZIP, readData.testDataValue.get("ZIPCode"))){
			click(loc.cntZIPCode);
			readData.addStepDetails("activateFamilyMobile","Application should enter the ZIPCode","Successfully entered the ZIP Codde" ,"Pass", "Y");
		}
		else{
			readData.addStepDetails("activateFamilyMobile","Application should enter the ZIPCode","Failed to enter the ZIP Code" ,"Fail", "N");
		}
		/*if(click(loc.cntZIPCode)){
			readData.addStepDetails("activateFamilyMobile","Application should click the Continue link at ZIPCode entry","Successfully clicked on the Continue link at ZIPCode entry" ,"Pass", "Y");
		}
		else{
			readData.addStepDetails("activateFamilyMobile","Application should click the Continue link at ZIPCode entry","Failed to click on the Continue link at ZIPCode entry" ,"Fail", "N");
		}*/
		if(type(loc.txtPIN,strPIN)){
			readData.addStepDetails("activateFamilyMobile","Application should enter the Plan PIN","Successfully entered the Plan PIN" ,"Pass", "Y");
		}
		else{
			readData.addStepDetails("activateFamilyMobile","Application should enter the Plan PIN","Failed to enter the Plan PIN" ,"Fail", "N");
		}
		if(click(loc.cntPIN)){
			readData.addStepDetails("activateFamilyMobile","Application should click the Continue link at PIN entry","Successfully clicked on the Continue link at PIN entry" ,"Pass", "Y");
		}
		else{
			readData.addStepDetails("activateFamilyMobile","Application should click the Continue link at PIN entry","Failed to click on the Continue link at PIN entry" ,"Fail", "N");
		}
		if(click(loc.btnCreateNewAccount)){
			readData.addStepDetails("activateFamilyMobile","Application should click the Create Account button","Successfully clicked on the Create Account button" ,"Pass", "Y");
		}
		else{
			readData.addStepDetails("activateFamilyMobile","Application should click the Create Account button","Failed to click on the Create Account button" ,"Fail", "N");
		}
		//Account Creation
		
		createAccount.createAccount(readData);
		waitForElement(loc.cntRequestSubmitted,50);
		if(click(loc.cntRequestSubmitted)){
			readData.addStepDetails("activateFamilyMobile","Application should click the Continue button after Request Submitted","Successfully clicked on the Continue button after request Submitted" ,"Pass", "Y");
		}
		else{
			readData.addStepDetails("activateFamilyMobile","v","Failed to click on the Continue button after Request Submitted" ,"Fail", "N");
		}
		if(click(loc.myAccountLink)){
			readData.addStepDetails("activateFamilyMobile","Application should click the Continue button after Request Submitted","Successfully clicked on the Continue button after request Submitted" ,"Pass", "Y");
		}
		else{
			readData.addStepDetails("activateFamilyMobile","v","Failed to click on the Continue button after Request Submitted" ,"Fail", "N");
		}
		MIN = DBConnections.generateMIN(strESN);
		System.out.println("Genarated min is: "+MIN);
		DBConnections.updateStatus(strESN);
		Thread.sleep(10000);
	/*	status = DBConnections.getStatus(strESN);
		System.out.println(status);*/
		String expectedStatus = "S";
		do {
		status = DBConnections.getStatus(strESN);
		//System.out.println(status);
		//System.out.println(!status.equals(expectedStatus));
		}
		while(!status.equals(expectedStatus));
		
		return MIN;
	}
	
	public String activateByopPin(String strSIM,String strPIN, String strESN) throws Exception{
		waitForElement(loc.activeLink,10);
		if(click(loc.activeLink)){
			readData.addStepDetails("activateFamilyMobile","Application should click the ACTIVATE link","Successfully clicked the ACTIVATE link" ,"Pass", "Y");	
		}
		else{
			readData.addStepDetails("activateFamilyMobile","Application should click the ACTIVATE link","Failed to click the ACTIVATE link" ,"Fail", "N");
		}

		if(click(loc.btnByopContinue)){
			readData.addStepDetails("activateFamilyMobile","Application should click the Continue link","Successfully clicked the Continue link" ,"Pass", "Y");
		}
		else{
			readData.addStepDetails("activateFamilyMobile","Application should click the Continue link","Failed to click the Continue link" ,"Fail", "N");
		}
		if(click(loc.btnByopTerms)){
			readData.addStepDetails("activateFamilyMobile","Application should click the Continue link","Successfully clicked the Continue link" ,"Pass", "Y");
		}
		else{
			readData.addStepDetails("activateFamilyMobile","Application should click the Continue link","Failed to click the Continue link" ,"Fail", "N");
		}	

		if(type(loc.txtByopSim, strSIM)){
			click(loc.btnByopSim);
			readData.addStepDetails("activateFamilyMobile","Application should enter the SIM number","Successfully entered the SIM number" ,"Pass", "Y");
		}
		else{
			readData.addStepDetails("activateFamilyMobile","Application should enter the SIM number","Failed to enter the SIM number" ,"Fail", "N");
		}
		if(type(loc.txtSecurityPin, readData.testDataValue.get("SecurePIN"))){
			click(loc.btnSecurityPin);
			readData.addStepDetails("activateFamilyMobile","Application should enter the SecurityPIN","Successfully entered the SecurityPIN" ,"Pass", "Y");
		}
		else{
			readData.addStepDetails("activateFamilyMobile","Application should enter the SecurityPIN","Failed to enter the SecurityPIN" ,"Fail", "N");
		}
		if(type(loc.txtEnterZIP, readData.testDataValue.get("ZIPCode"))){
			click(loc.cntZIPCode);
			readData.addStepDetails("activateFamilyMobile","Application should enter the ZIPCode","Successfully entered the ZIP Codde" ,"Pass", "Y");
		}
		else{
			readData.addStepDetails("activateFamilyMobile","Application should enter the ZIPCode","Failed to enter the ZIP Code" ,"Fail", "N");
		}
		if(type(loc.txtPIN,strPIN)){
			click(loc.cntPIN);
			readData.addStepDetails("activateFamilyMobile","Application should enter the Plan PIN","Successfully entered the Plan PIN" ,"Pass", "Y");
		}
		else{
			readData.addStepDetails("activateFamilyMobile","Application should enter the Plan PIN","Failed to enter the Plan PIN" ,"Fail", "N");
		}
		if(click(loc.btnCreateNewAccount)){
			readData.addStepDetails("activateFamilyMobile","Application should click the Create Account button","Successfully clicked on the Create Account button" ,"Pass", "Y");
		}
		else{
			readData.addStepDetails("activateFamilyMobile","Application should click the Create Account button","Failed to click on the Create Account button" ,"Fail", "N");
		}
		//Account Creation
		
		createAccount.createAccount(readData);
		waitForElement(loc.cntRequestSubmitted,50);
		if(click(loc.cntRequestSubmitted)){
			readData.addStepDetails("activateFamilyMobile","Application should click the Continue button after Request Submitted","Successfully clicked on the Continue button after request Submitted" ,"Pass", "Y");
		}
		else{
			readData.addStepDetails("activateFamilyMobile","v","Failed to click on the Continue button after Request Submitted" ,"Fail", "N");
		}
		if(click(loc.myAccountLink)){
			readData.addStepDetails("activateFamilyMobile","Application should click the Continue button after Request Submitted","Successfully clicked on the Continue button after request Submitted" ,"Pass", "Y");
		}
		else{
			readData.addStepDetails("activateFamilyMobile","v","Failed to click on the Continue button after Request Submitted" ,"Fail", "N");
		}
		MIN = DBConnections.generateMIN(strESN);
		System.out.println("Genarated min is: "+MIN);
	//	DBConnections.updateStatus(strESN);
		DBConnections.updateStatusMsid(MIN);
		Thread.sleep(10000);
		do {
			status = DBConnections.getStatus(strESN);
			}
			while(!status.equalsIgnoreCase("S"));
		driver.get(driver.getCurrentUrl());
	return MIN;	
	}


}
