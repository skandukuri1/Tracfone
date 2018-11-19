package com.WFM.pages;
import com.objectRepository.WFMLocators;
import com.utility.BaseClass;
import com.utility.ReadData;

public class PurchasePaymentPage extends BaseClass{

	public void purchasePaymentPage(ReadData readData) throws Exception {
		WFMLocators loc = new WFMLocators();
		BaseClass baseclass = new BaseClass();
		baseclass.waitForElement(loc.txtCardNo, 10);
		if(type(loc.txtCardNo,readData.testDataValue.get("CardNumber"))){
			readData.addStepDetails("activateFamilyMobile","Application should click the PAY SERVICE link","Successfully clicked the PAY SERVICE link" ,"Pass", "Y");	
		}
		else{
			readData.addStepDetails("activateFamilyMobile","Application should click the PAY SERVICE link","Failed to click the PAY SERVICE link" ,"Fail", "N");
		}
	if(type(loc.txtCvv,readData.testDataValue.get("CVV"))){
		readData.addStepDetails("activateFamilyMobile","Application should click the PAY SERVICE link","Successfully clicked the PAY SERVICE link" ,"Pass", "Y");	
	}
	else{
		readData.addStepDetails("activateFamilyMobile","Application should click the PAY SERVICE link","Failed to click the PAY SERVICE link" ,"Fail", "N");
	}
	if(click(loc.selectMonth)){
		readData.addStepDetails("activateFamilyMobile","Application should click the PAY SERVICE link","Successfully clicked the PAY SERVICE link" ,"Pass", "Y");	
	}
	else{
		readData.addStepDetails("activateFamilyMobile","Application should click the PAY SERVICE link","Failed to click the PAY SERVICE link" ,"Fail", "N");
	}
	baseclass.waitForElement(loc.selectJanuary, 10);
	if(click(loc.selectJanuary)){
		readData.addStepDetails("activateFamilyMobile","Application should click the PAY SERVICE link","Successfully clicked the PAY SERVICE link" ,"Pass", "Y");	
	}
	else{
		readData.addStepDetails("activateFamilyMobile","Application should click the PAY SERVICE link","Failed to click the PAY SERVICE link" ,"Fail", "N");
	}baseclass.waitForElement(loc.selectYear, 10);
	if(click(loc.selectYear)){
		readData.addStepDetails("activateFamilyMobile","Application should click the PAY SERVICE link","Successfully clicked the PAY SERVICE link" ,"Pass", "Y");	
	}
	else{
		readData.addStepDetails("activateFamilyMobile","Application should click the PAY SERVICE link","Failed to click the PAY SERVICE link" ,"Fail", "N");
	}
	baseclass.waitForElement(loc.selectYear2022, 10);
	if(click(loc.selectYear2022)){
		readData.addStepDetails("activateFamilyMobile","Application should click the PAY SERVICE link","Successfully clicked the PAY SERVICE link" ,"Pass", "Y");	
	}
	else{
		readData.addStepDetails("activateFamilyMobile","Application should click the PAY SERVICE link","Failed to click the PAY SERVICE link" ,"Fail", "N");
	}
	if(type(loc.txtFname,readData.testDataValue.get("FirstName"))){
		readData.addStepDetails("activateFamilyMobile","Application should click the PAY SERVICE link","Successfully clicked the PAY SERVICE link" ,"Pass", "Y");	
	}
	else{
		readData.addStepDetails("activateFamilyMobile","Application should click the PAY SERVICE link","Failed to click the PAY SERVICE link" ,"Fail", "N");
	}
	if(type(loc.txtLname,readData.testDataValue.get("LastName"))){
		readData.addStepDetails("activateFamilyMobile","Application should click the PAY SERVICE link","Successfully clicked the PAY SERVICE link" ,"Pass", "Y");	
	}
	else{
		readData.addStepDetails("activateFamilyMobile","Application should click the PAY SERVICE link","Failed to click the PAY SERVICE link" ,"Fail", "N");
	}
	if(type(loc.txtAddress1,readData.testDataValue.get("Address1"))){
		readData.addStepDetails("activateFamilyMobile","Application should click the PAY SERVICE link","Successfully clicked the PAY SERVICE link" ,"Pass", "Y");	
	}
	else{
		readData.addStepDetails("activateFamilyMobile","Application should click the PAY SERVICE link","Failed to click the PAY SERVICE link" ,"Fail", "N");
	}
	if(type(loc.txtCity,readData.testDataValue.get("City"))){
		readData.addStepDetails("activateFamilyMobile","Application should click the PAY SERVICE link","Successfully clicked the PAY SERVICE link" ,"Pass", "Y");	
	}
	else{
		readData.addStepDetails("activateFamilyMobile","Application should click the PAY SERVICE link","Failed to click the PAY SERVICE link" ,"Fail", "N");
	}
	if(click(loc.selectState)){
		readData.addStepDetails("activateFamilyMobile","Application should click the PAY SERVICE link","Successfully clicked the PAY SERVICE link" ,"Pass", "Y");	
	}
	else{
		readData.addStepDetails("activateFamilyMobile","Application should click the PAY SERVICE link","Failed to click the PAY SERVICE link" ,"Fail", "N");
	}
	baseclass.waitForElement(loc.selectStateCA, 10);
	if(click(loc.selectStateCA)){
		readData.addStepDetails("activateFamilyMobile","Application should click the PAY SERVICE link","Successfully clicked the PAY SERVICE link" ,"Pass", "Y");	
	}
	else{
		readData.addStepDetails("activateFamilyMobile","Application should click the PAY SERVICE link","Failed to click the PAY SERVICE link" ,"Fail", "N");
	}
	if(type(loc.txtZipCode,readData.testDataValue.get("ZipCode"))){
		readData.addStepDetails("activateFamilyMobile","Application should click the PAY SERVICE link","Successfully clicked the PAY SERVICE link" ,"Pass", "Y");	
	}
	else{
		readData.addStepDetails("activateFamilyMobile","Application should click the PAY SERVICE link","Failed to click the PAY SERVICE link" ,"Fail", "N");
	}
	if(click(loc.btnPlaceMyOrder)){
		readData.addStepDetails("activateFamilyMobile","Application should click the PAY SERVICE link","Successfully clicked the PAY SERVICE link" ,"Pass", "Y");	
	}
	else{
		readData.addStepDetails("activateFamilyMobile","Application should click the PAY SERVICE link","Failed to click the PAY SERVICE link" ,"Fail", "N");
	}
	
	
	}
}
