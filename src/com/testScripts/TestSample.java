package com.testScripts;

import java.sql.SQLException;
import java.util.ArrayList;

import com.utility.DBConnections;

public class TestSample {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		String strESNVal = "100000008190349";
		ArrayList<String> statusLs = new ArrayList<String>();
		//String status = DBConnections.getStatus(strESNVal);
		String statusL = null;
		//System.out.println(status);
		/*statusLs = DBConnections.getStatusTest(strESNVal);
		for(String status :statusLs) {
			System.out.println(status);
			
		}*/
		do {
			statusLs = DBConnections.getStatusTest(strESNVal);
			for(String statusvalue :statusLs){
				if(!statusvalue.equalsIgnoreCase("S")) {
					statusL=statusvalue;
				}
			}
		}
			while(!statusL.toString().equalsIgnoreCase("S"));
		
	}

}
