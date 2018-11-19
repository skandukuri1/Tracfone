package com.testScripts;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.components.Components;
import com.utility.BaseClass;
import com.utility.DBConnections;

public class CR59124 extends BaseClass{
//	DBConnections dbConn = new DBConnections();
	public Components component=new Components(readData);

	@Parameters("TestcaseNo")	
	@Test(description = "Scenario:To test the CR59124")
	public void f(String no) throws Exception {
		//readData.readTestDataFile(System.getProperty("user.dir")	+ "\\Resources\\TestData.xlsx", no);
		System.out.println("----------------------------------------: Entered the Test method");
		readData.readTestDataFile("D:\\workspace\\AutoWFM\\WFM\\Repository\\TestData.xls", no);
//		component.launchApp();
		component.viewLaunchApp();
		//component.activateFamilyMobile();
	}
}
