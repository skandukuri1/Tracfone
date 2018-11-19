package com.testcases;

import com.WFM.pages.PurchasePaymentPage;
import com.objectRepository.WFMLocators;
import com.utility.BaseClass;
import com.utility.ReadData;

public class RedemptionWithPurchase extends BaseClass{

	public RedemptionWithPurchase(ReadData readData) {
		this.readData = readData;
	}
	WFMLocators loc = new WFMLocators();
	BaseClass baseclass = new BaseClass();
	PurchasePaymentPage purchasePaymentPage = new PurchasePaymentPage();
	public void redemptionPurchaseMyFamilyMobileAR(String strMIN) throws Exception {
		baseclass.waitForElement(loc.payServiceLink, 10);
		if(click(loc.payServiceLink)){
			readData.addStepDetails("activateFamilyMobile","Application should click the PAY SERVICE link","Successfully clicked the PAY SERVICE link" ,"Pass", "Y");	
		}
		else{
			readData.addStepDetails("activateFamilyMobile","Application should click the PAY SERVICE link","Failed to click the PAY SERVICE link" ,"Fail", "N");
		}
		baseclass.waitForElement(loc.btnPayNow, 10);
		//Purchase with AR outside account
		if(type(loc.txtPhoneNumber,strMIN)){
			readData.addStepDetails("activateFamilyMobile","Application should click the PAY SERVICE link","Successfully clicked the PAY SERVICE link" ,"Pass", "Y");	
		}
		else{
			readData.addStepDetails("activateFamilyMobile","Application should click the PAY SERVICE link","Failed to click the PAY SERVICE link" ,"Fail", "N");
		}
		if(click(loc.btnPayNow)){
			readData.addStepDetails("activateFamilyMobile","Application should click the PAY SERVICE link","Successfully clicked the PAY SERVICE link" ,"Pass", "Y");	
		}
		else{
			readData.addStepDetails("activateFamilyMobile","Application should click the PAY SERVICE link","Failed to click the PAY SERVICE link" ,"Fail", "N");
		}
		baseclass.waitForElement(loc.btnServicePlan, 10);
		if(click(loc.btnServicePlan)){
			readData.addStepDetails("activateFamilyMobile","Application should click the PAY SERVICE link","Successfully clicked the PAY SERVICE link" ,"Pass", "Y");	
		}
		else{
			readData.addStepDetails("activateFamilyMobile","Application should click the PAY SERVICE link","Failed to click the PAY SERVICE link" ,"Fail", "N");
		}
		baseclass.waitForElement(loc.btnAutoPayYes, 10);
		if(click(loc.btnAutoPayYes)){
			readData.addStepDetails("activateFamilyMobile","Application should click the PAY SERVICE link","Successfully clicked the PAY SERVICE link" ,"Pass", "Y");	
		}
		else{
			readData.addStepDetails("activateFamilyMobile","Application should click the PAY SERVICE link","Failed to click the PAY SERVICE link" ,"Fail", "N");
		}
		baseclass.waitForElement(loc.paymentMethodLnk, 10);
		if(click(loc.paymentMethodLnk)){
			readData.addStepDetails("activateFamilyMobile","Application should click the PAY SERVICE link","Successfully clicked the PAY SERVICE link" ,"Pass", "Y");	
		}
		else{
			readData.addStepDetails("activateFamilyMobile","Application should click the PAY SERVICE link","Failed to click the PAY SERVICE link" ,"Fail", "N");
		}
		purchasePaymentPage.purchasePaymentPage(readData);
		if(click(loc.myAccountLink)){
			readData.addStepDetails("activateFamilyMobile","Application should click the Continue button after Request Submitted","Successfully clicked on the Continue button after request Submitted" ,"Pass", "Y");
		}
		else{
			readData.addStepDetails("activateFamilyMobile","v","Failed to click on the Continue button after Request Submitted" ,"Fail", "N");
		}
	}
	
	public void redemptionPurchaseMyFamilyMobileNonAR(String strMIN) throws Exception {
		baseclass.waitForElement(loc.payServiceLink, 10);
		if(click(loc.payServiceLink)){
			readData.addStepDetails("activateFamilyMobile","Application should click the PAY SERVICE link","Successfully clicked the PAY SERVICE link" ,"Pass", "Y");	
		}
		else{
			readData.addStepDetails("activateFamilyMobile","Application should click the PAY SERVICE link","Failed to click the PAY SERVICE link" ,"Fail", "N");
		}
		baseclass.waitForElement(loc.btnPayNow, 10);
		/*if(type(loc.txtPhoneNumber,strMIN)){
			readData.addStepDetails("activateFamilyMobile","Application should click the PAY SERVICE link","Successfully clicked the PAY SERVICE link" ,"Pass", "Y");	
		}
		else{
			readData.addStepDetails("activateFamilyMobile","Application should click the PAY SERVICE link","Failed to click the PAY SERVICE link" ,"Fail", "N");
		}*/
		if(click(loc.btnPayNow)){
			readData.addStepDetails("activateFamilyMobile","Application should click the PAY SERVICE link","Successfully clicked the PAY SERVICE link" ,"Pass", "Y");	
		}
		else{
			readData.addStepDetails("activateFamilyMobile","Application should click the PAY SERVICE link","Failed to click the PAY SERVICE link" ,"Fail", "N");
		}
		baseclass.waitForElement(loc.btnServicePlan, 10);
		if(click(loc.btnServicePlan)){
			readData.addStepDetails("activateFamilyMobile","Application should click the PAY SERVICE link","Successfully clicked the PAY SERVICE link" ,"Pass", "Y");	
		}
		else{
			readData.addStepDetails("activateFamilyMobile","Application should click the PAY SERVICE link","Failed to click the PAY SERVICE link" ,"Fail", "N");
		}
		baseclass.waitForElement(loc.btnAutoPayNo, 10);
		if(click(loc.btnAutoPayNo)){
			readData.addStepDetails("activateFamilyMobile","Application should click the PAY SERVICE link","Successfully clicked the PAY SERVICE link" ,"Pass", "Y");	
		}
		else{
			readData.addStepDetails("activateFamilyMobile","Application should click the PAY SERVICE link","Failed to click the PAY SERVICE link" ,"Fail", "N");
		}
		baseclass.waitForElement(loc.paymentMethodLnk, 10);
		if(click(loc.paymentMethodLnk)){
			readData.addStepDetails("activateFamilyMobile","Application should click the PAY SERVICE link","Successfully clicked the PAY SERVICE link" ,"Pass", "Y");	
		}
		else{
			readData.addStepDetails("activateFamilyMobile","Application should click the PAY SERVICE link","Failed to click the PAY SERVICE link" ,"Fail", "N");
		}
		purchasePaymentPage.purchasePaymentPage(readData);
		if(click(loc.myAccountLink)){
			readData.addStepDetails("activateFamilyMobile","Application should click the Continue button after Request Submitted","Successfully clicked on the Continue button after request Submitted" ,"Pass", "Y");
		}
		else{
			readData.addStepDetails("activateFamilyMobile","v","Failed to click on the Continue button after Request Submitted" ,"Fail", "N");
		}
	}
	
}
