package com.testcases;

import org.apache.commons.lang3.RandomStringUtils;

import com.WFM.pages.CreateAccount;
import com.WFM.pages.PurchasePaymentPage;
import com.objectRepository.WFMLocators;
import com.utility.BaseClass;
import com.utility.DBConnections;
import com.utility.ReadData;

public class ActivationWithPurchase extends BaseClass {

	WFMLocators loc = new WFMLocators();
	CreateAccount createAccount = new CreateAccount();
	PurchasePaymentPage purchasePaymentPage = new PurchasePaymentPage();
	BaseClass baseclass = new BaseClass();
	String RandomString = RandomStringUtils.random(3, false, true);
	public String MIN = null;
	public String status = null;

	public ActivationWithPurchase(ReadData readData) {
		this.readData = readData;
	}

	public String activateFamilyMobilePurchase(String strSIM, String strPIN, String strESN) throws Exception {
		waitForElement(loc.activeLink, 50);
		if (click(loc.activeLink)) {
			readData.addStepDetails("activateFamilyMobile", "Application should click the ACTIVATE link",
					"Successfully clicked the ACTIVATE link", "Pass", "Y");
		} else {
			readData.addStepDetails("activateFamilyMobile", "Application should click the ACTIVATE link",
					"Failed to click the ACTIVATE link", "Fail", "N");
		}

		if (click(loc.cntFamilyMobile)) {
			readData.addStepDetails("activateFamilyMobile", "Application should click the Continue link",
					"Successfully clicked the Continue link", "Pass", "Y");
		} else {
			readData.addStepDetails("activateFamilyMobile", "Application should click the Continue link",
					"Failed to click the Continue link", "Fail", "N");
		}

		if (type(loc.txtSIMEntry, strSIM)) {
			readData.addStepDetails("activateFamilyMobile", "Application should enter the SIM number",
					"Successfully entered the SIM number", "Pass", "Y");
		} else {
			readData.addStepDetails("activateFamilyMobile", "Application should enter the SIM number",
					"Failed to enter the SIM number", "Fail", "N");
		}
		if (click(loc.chkSIMConfirm)) {
			click(loc.cntSIMConfirm);
			readData.addStepDetails("activateFamilyMobile", "Application should accept the conditions by checking",
					"Successfully checked the condition", "Pass", "Y");
		} else {
			readData.addStepDetails("activateFamilyMobile", "Application should accept the conditions by checking",
					"Failed to check the condition", "Fail", "N");
		}
		waitForElement(loc.txtSecurityPin, 50);
		if (type(loc.txtSecurityPin, readData.testDataValue.get("SecurePIN"))) {
			click(loc.btnSecurityPin);
			readData.addStepDetails("activateFamilyMobile", "Application should enter the SecurityPIN",
					"Successfully entered the SecurityPIN", "Pass", "Y");
		} else {
			readData.addStepDetails("activateFamilyMobile", "Application should enter the SecurityPIN",
					"Failed to enter the SecurityPIN", "Fail", "N");
		}
		if (type(loc.txtEnterZIP, readData.testDataValue.get("ZIPCode"))) {
			click(loc.cntZIPCode);
			readData.addStepDetails("activateFamilyMobile", "Application should enter the ZIPCode",
					"Successfully entered the ZIP Codde", "Pass", "Y");
		} else {
			readData.addStepDetails("activateFamilyMobile", "Application should enter the ZIPCode",
					"Failed to enter the ZIP Code", "Fail", "N");
		}
		if (click(loc.btnCCCardContinue)) {

			readData.addStepDetails("activateFamilyMobile", "Application should enter the SecurityPIN",
					"Successfully entered the SecurityPIN", "Pass", "Y");
		} else {
			readData.addStepDetails("activateFamilyMobile", "Application should enter the SecurityPIN",
					"Failed to enter the SecurityPIN", "Fail", "N");
		}
		if (click(loc.btnServicePlan)) {
			readData.addStepDetails("activateFamilyMobile", "Application should click the PAY SERVICE link",
					"Successfully clicked the PAY SERVICE link", "Pass", "Y");
		} else {
			readData.addStepDetails("activateFamilyMobile", "Application should click the PAY SERVICE link",
					"Failed to click the PAY SERVICE link", "Fail", "N");
		}
		if (click(loc.btnCreateNewAccount)) {
			readData.addStepDetails("activateFamilyMobile", "Application should click the Create Account button",
					"Successfully clicked on the Create Account button", "Pass", "Y");
		} else {
			readData.addStepDetails("activateFamilyMobile", "Application should click the Create Account button",
					"Failed to click on the Create Account button", "Fail", "N");
		}
		// Account Creation
		createAccount.createAccount(readData);

		waitForElement(loc.paymentMethodLnk, 10);
		if (click(loc.paymentMethodLnk)) {
			readData.addStepDetails("activateFamilyMobile", "Application should click the PAY SERVICE link",
					"Successfully clicked the PAY SERVICE link", "Pass", "Y");
		} else {
			readData.addStepDetails("activateFamilyMobile", "Application should click the PAY SERVICE link",
					"Failed to click the PAY SERVICE link", "Fail", "N");
		}
		purchasePaymentPage.purchasePaymentPage(readData);

		waitForElement(loc.myAccountLink, 10);
		if (click(loc.myAccountLink)) {
			readData.addStepDetails("activateFamilyMobile",
					"Application should click the Continue button after Request Submitted",
					"Successfully clicked on the Continue button after request Submitted", "Pass", "Y");
		} else {
			readData.addStepDetails("activateFamilyMobile", "v",
					"Failed to click on the Continue button after Request Submitted", "Fail", "N");
		}
		MIN = DBConnections.generateMIN(strESN);
		System.out.println("Genarated min is: " + MIN);
		DBConnections.updateStatusMsid(MIN);
		Thread.sleep(10000);
		do {
			status = DBConnections.getStatus(strESN);
		} while (!status.equalsIgnoreCase("S"));
		driver.get(driver.getCurrentUrl());
		return MIN;
	}

	public String activateByopPurchase(String strSIM, String strPIN, String strESN) throws Exception {
		waitForElement(loc.activeLink, 10);
		if (click(loc.activeLink)) {
			readData.addStepDetails("activateFamilyMobile", "Application should click the ACTIVATE link",
					"Successfully clicked the ACTIVATE link", "Pass", "Y");
		} else {
			readData.addStepDetails("activateFamilyMobile", "Application should click the ACTIVATE link",
					"Failed to click the ACTIVATE link", "Fail", "N");
		}

		if (click(loc.btnByopContinue)) {
			readData.addStepDetails("activateFamilyMobile", "Application should click the Continue link",
					"Successfully clicked the Continue link", "Pass", "Y");
		} else {
			readData.addStepDetails("activateFamilyMobile", "Application should click the Continue link",
					"Failed to click the Continue link", "Fail", "N");
		}
		if (click(loc.btnByopTerms)) {
			readData.addStepDetails("activateFamilyMobile", "Application should click the Continue link",
					"Successfully clicked the Continue link", "Pass", "Y");
		} else {
			readData.addStepDetails("activateFamilyMobile", "Application should click the Continue link",
					"Failed to click the Continue link", "Fail", "N");
		}

		if (type(loc.txtByopSim, strSIM)) {
			click(loc.btnByopSim);
			readData.addStepDetails("activateFamilyMobile", "Application should enter the SIM number",
					"Successfully entered the SIM number", "Pass", "Y");
		} else {
			readData.addStepDetails("activateFamilyMobile", "Application should enter the SIM number",
					"Failed to enter the SIM number", "Fail", "N");
		}
		waitForElement(loc.txtSecurityPin, 10);
		if (type(loc.txtSecurityPin, readData.testDataValue.get("SecurePIN"))) {
			click(loc.btnSecurityPin);
			readData.addStepDetails("activateFamilyMobile", "Application should enter the SecurityPIN",
					"Successfully entered the SecurityPIN", "Pass", "Y");
		} else {
			readData.addStepDetails("activateFamilyMobile", "Application should enter the SecurityPIN",
					"Failed to enter the SecurityPIN", "Fail", "N");
		}
		waitForElement(loc.txtEnterZIP, 10);
		if (type(loc.txtEnterZIP, readData.testDataValue.get("ZIPCode"))) {
			click(loc.cntZIPCode);
			readData.addStepDetails("activateFamilyMobile", "Application should enter the ZIPCode",
					"Successfully entered the ZIP Codde", "Pass", "Y");
		} else {
			readData.addStepDetails("activateFamilyMobile", "Application should enter the ZIPCode",
					"Failed to enter the ZIP Code", "Fail", "N");
		}
		if (click(loc.btnCCCardContinue)) {
			readData.addStepDetails("activateFamilyMobile", "Application should enter the Plan PIN",
					"Successfully entered the Plan PIN", "Pass", "Y");
		} else {
			readData.addStepDetails("activateFamilyMobile", "Application should enter the Plan PIN",
					"Failed to enter the Plan PIN", "Fail", "N");
		}
		baseclass.waitForElement(loc.btnServicePlan, 10);
		if (click(loc.btnServicePlan)) {
			readData.addStepDetails("activateFamilyMobile", "Application should click the PAY SERVICE link",
					"Successfully clicked the PAY SERVICE link", "Pass", "Y");
		} else {
			readData.addStepDetails("activateFamilyMobile", "Application should click the PAY SERVICE link",
					"Failed to click the PAY SERVICE link", "Fail", "N");
		}
		/*
		 * baseclass.waitForElement(loc.btnAutoPayNo, 10); if(click(loc.btnAutoPayNo)){
		 * readData.addStepDetails(
		 * "activateFamilyMobile","Application should click the PAY SERVICE link"
		 * ,"Successfully clicked the PAY SERVICE link" ,"Pass", "Y"); } else{
		 * readData.addStepDetails(
		 * "activateFamilyMobile","Application should click the PAY SERVICE link"
		 * ,"Failed to click the PAY SERVICE link" ,"Fail", "N"); }
		 */
		if (click(loc.btnCreateNewAccount)) {
			readData.addStepDetails("activateFamilyMobile", "Application should click the Create Account button",
					"Successfully clicked on the Create Account button", "Pass", "Y");
		} else {
			readData.addStepDetails("activateFamilyMobile", "Application should click the Create Account button",
					"Failed to click on the Create Account button", "Fail", "N");
		}
		// Account Creation
		createAccount.createAccount(readData);

		baseclass.waitForElement(loc.paymentMethodLnk, 20);
		if (click(loc.paymentMethodLnk)) {
			readData.addStepDetails("activateFamilyMobile", "Application should click the PAY SERVICE link",
					"Successfully clicked the PAY SERVICE link", "Pass", "Y");
		} else {
			readData.addStepDetails("activateFamilyMobile", "Application should click the PAY SERVICE link",
					"Failed to click the PAY SERVICE link", "Fail", "N");
		}
		purchasePaymentPage.purchasePaymentPage(readData);
		baseclass.waitForElement(loc.btnActivateNoPin, 10);
		if (click(loc.btnActivateNoPin)) {
			readData.addStepDetails("activateFamilyMobile", "Application should click the PAY SERVICE link",
					"Successfully clicked the PAY SERVICE link", "Pass", "Y");
		} else {
			readData.addStepDetails("activateFamilyMobile", "Application should click the PAY SERVICE link",
					"Failed to click the PAY SERVICE link", "Fail", "N");
		}

		waitForElement(loc.btnDoneConfirm, 10);
		if (click(loc.btnDoneConfirm)) {
			readData.addStepDetails("activateFamilyMobile",
					"Application should click the Continue button after Request Submitted",
					"Successfully clicked on the Continue button after request Submitted", "Pass", "Y");
		} else {
			readData.addStepDetails("activateFamilyMobile", "v",
					"Failed to click on the Continue button after Request Submitted", "Fail", "N");
		}
		if (click(loc.btnNoThanks)) {
			readData.addStepDetails("activateFamilyMobile", "Application should click the PAY SERVICE link",
					"Successfully clicked the PAY SERVICE link", "Pass", "Y");
		} else {
			readData.addStepDetails("activateFamilyMobile", "Application should click the PAY SERVICE link",
					"Failed to click the PAY SERVICE link", "Fail", "N");
		}

		if (click(loc.myAccountLink)) {
			readData.addStepDetails("activateFamilyMobile",
					"Application should click the Continue button after Request Submitted",
					"Successfully clicked on the Continue button after request Submitted", "Pass", "Y");
		} else {
			readData.addStepDetails("activateFamilyMobile", "v",
					"Failed to click on the Continue button after Request Submitted", "Fail", "N");
		}
		MIN = DBConnections.generateMIN(strESN);
		System.out.println("Genarated min is: " + MIN);
		// DBConnections.updateStatus(strESN);
		DBConnections.updateStatusMsid(MIN);
		Thread.sleep(10000);
		do {
			status = DBConnections.getStatus(strESN);
		} while (!status.equalsIgnoreCase("S"));
		driver.get(driver.getCurrentUrl());
		Thread.sleep(10000);
		return MIN;
	}

}
