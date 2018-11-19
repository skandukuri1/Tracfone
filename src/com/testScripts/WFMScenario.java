package com.testScripts;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.components.Components;
import com.testcases.ActivationWithPin;
import com.testcases.ActivationWithPurchase;
import com.testcases.RedemptionWithPin;
import com.testcases.RedemptionWithPurchase;
import com.utility.BaseClass;
import com.utility.DBConnections;

public class WFMScenario extends BaseClass{
	/*HttpServletRequest request ;
	HttpSession session = request.getSession();*/
	
	DBConnections dbConn = new DBConnections();
	public Components component=new Components(readData);
	ActivationWithPin activationPin = new ActivationWithPin(readData);
	ActivationWithPurchase activationPurchase = new ActivationWithPurchase(readData);
	RedemptionWithPin redemption = new RedemptionWithPin(readData);
	RedemptionWithPurchase redemptionPurchase = new RedemptionWithPurchase(readData);
	
	public Logger log=Logger.getLogger(com.testScripts.WFMScenario.class);
	@Parameters("TestcaseNo")	
	@Test(description = "Scenario:To test the WFM application launch")
	public void f(String no) throws Exception {
		BasicConfigurator.configure();
		readData.readTestDataFile(System.getProperty("user.dir")+ "\\Repository\\TestData.xls", no);
		String returnValue = dbConn.getConnection(readData.testDataValue.get("SIM"), readData.testDataValue.get("PIN"), readData.testDataValue.get("ESN"));
		String strSIM = "";
		String strPIN = "";
		String strESN = "";
		
		String[] arrValue = returnValue.split(":");

		for (int i = 0; i < arrValue.length; i++) {
			strSIM = arrValue[0];
//			session.setAttribute(strSIM, "SIM");
			strPIN = arrValue[1];
//			session.setAttribute(strPIN, "PIN");
			strESN = arrValue[2];
//			session.setAttribute(strESN, "ESN");
		}
		log.info("SIM: "+strSIM +" PIN: "+strPIN+" ESN: "+strESN);
		System.out.println("User Diretory*****************"+System.getProperty("user.dir"));
//		String strSIMSessionVal =  request.getAttribute("SIM").toString();
//		System.out.println("Session SIM value is: "+strSIMSessionVal);
		log.info("Entered the method");
		component.launchApp();
		//String strMin = activationPin.activateFamilyMobile(strSIM,strPIN, strESN);
		//String strMin = activationPin.activateByopPin(strSIM, strPIN, strESN);
		String strMin = activationPurchase.activateFamilyMobilePurchase(strSIM, strPIN, strESN);
		//String strMin = activationPurchase.activateByopPurchase(strSIM, strPIN, strESN);
		//redemption.redemptionMyFamilyMobile(strPIN);
		redemptionPurchase.redemptionPurchaseMyFamilyMobileAR(strMin);
		//redemptionPurchase.redemptionPurchaseMyFamilyMobileNonAR(strMin);
	}
}
