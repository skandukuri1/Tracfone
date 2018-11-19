package com.utility;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.apache.bcel.classfile.Constant;
import org.apache.log4j.BasicConfigurator;
import org.testng.log4testng.Logger;

import bsh.org.objectweb.asm.Constants;

public class DBConnections {

	public static Connection connection;
	public static CallableStatement cstmt = null;
	public static PreparedStatement pstmt = null;
	public static String strVal;
	public static String strSIMVal;
	public static String strPINVal;
	public static String strESNVal;
	public static String strMINVal;
	public static String strDBVal;
	public static String returnValue;
	public static int rscount;
	public static String Status;
	public static Logger log = Logger.getLogger(com.utility.DBConnections.class);
	public static Map<String,String> getTestData = new HashMap<String,String>();


	public static String getConnection(String valSIMPartNumber, String valPINPartNumber, String valESNPartNumber){

		try {
			BasicConfigurator.configure();
			if (connection == null) {
				Class.forName("oracle.jdbc.OracleDriver");
				String url = "jdbc:oracle:thin:@devdb.tracfone.com:3013:CLFYSITB";
				//String url = "jdbc:oracle:thin:@devdb.tracfone.com:3011:CLFYSIT1";
				//String url = "jdbc:oracle:thin:@devdb.tracfone.com:3015:CLFYSITA";
				
				connection = DriverManager.getConnection(url,"itquser_data","sitb4testdata");
				String getSIM = "{ ? = call get_test_sim(?)}";
				String getPIN = "{ ? = call Get_Test_Pin(?)}";
				String getESN = "{ ? = call sa.Get_Test_Esn(?)}";

				strSIMVal = getSIMVal(getSIM,valSIMPartNumber); 
				strPINVal = getPINVal(getPIN,valPINPartNumber);
				strESNVal = getESNVal(getESN,valESNPartNumber);
				boolean strSIMMarry = isSIMMarry(strSIMVal, strESNVal);
				strDBVal = strSIMVal+":"+strPINVal+":"+strESNVal;
				log.info("The database return value is: "+strDBVal);
			}
		} catch (Exception e) {
			System.err.println("Got an exception! ");
			System.err.println(e.getMessage());
		}
		return returnValue = strDBVal;
	}

	public static String getSIMVal(String getSIM , String valSIMPartNumber) throws Exception
	{
		if (valSIMPartNumber!=null || !valSIMPartNumber.equalsIgnoreCase("")) {
			cstmt = connection.prepareCall(getSIM);
			cstmt.registerOutParameter(1,  Types.VARCHAR);
			cstmt.setString(2, valSIMPartNumber);
			cstmt.executeUpdate();
			strVal = cstmt.getString(1);
			System.out.println("SIM Value is: "+strVal);
		}
		return strVal;
	}

	public static String getPINVal(String getPIN , String valPINPartNumber) throws Exception
	{
		if (valPINPartNumber!=null || !valPINPartNumber.equalsIgnoreCase("")) {
			cstmt = connection.prepareCall(getPIN);
			cstmt.registerOutParameter(1,  Types.VARCHAR);
			cstmt.setString(2, valPINPartNumber);
			cstmt.executeUpdate();
			strVal = cstmt.getString(1);
			System.out.println("PIN Value is: "+strVal);
		}
		return strVal;
	}
	public static String getESNVal(String getESN , String valESNPartNumber) throws Exception
	{
		if (valESNPartNumber!=null || !valESNPartNumber.equalsIgnoreCase("")) {
			cstmt = connection.prepareCall(getESN);
			cstmt.registerOutParameter(1,  Types.VARCHAR);
			cstmt.setString(2, valESNPartNumber);
			cstmt.executeUpdate();
			strVal = cstmt.getString(1);
			System.out.println("ESN Value is: "+strVal);
		}
		return strVal;
	}

	public static boolean isSIMMarry (String strSIM, String strESN) throws Exception{
		boolean bln = false;
		com.components.Constants constant =  new com.components.Constants();
		if(!strSIM.equalsIgnoreCase("") && !strESN.equalsIgnoreCase("")){
			pstmt = connection.prepareStatement(constant.queryUpdateSIM);		
			pstmt.setString(1, strSIM);
			pstmt.setString(2, strESN);
			int val = pstmt.executeUpdate();
			if(val>0){
				bln = true;
			}
		}
		return bln;
	}
	public static String generateMIN(String strESN) throws Exception{
		String getMIN = "{ ? = call sa.clear_tnumber(?,?)}";
		ReadData readData = new ReadData();
		if (strESN!=null || !strESN.equalsIgnoreCase("")) {
			// getConnection();
			cstmt = connection.prepareCall(getMIN);
			cstmt.registerOutParameter(1,  Types.VARCHAR);
			cstmt.setString(2, strESN);
			cstmt.setString(3, "305");
			cstmt.executeUpdate();
			strVal = cstmt.getString(1);
			strMINVal = strVal.substring(35, 45);
			System.out.println(strMINVal);
			getTestData.put("MIN", strMINVal);
			log.info("MIN Value is: "+strMINVal);
		}
		return strMINVal;
	}

	public static boolean updateStatus(String strESN) throws SQLException {
		boolean bln = false;
		com.components.Constants constant =  new com.components.Constants();
		if(strESN !=null || !strESN.equalsIgnoreCase("")) {
			pstmt = connection.prepareStatement(constant.queryUpdateStatus);
			pstmt.setString(1, strESN);
			int val = pstmt.executeUpdate();
			if(val >0) {
				bln = true;
			}			
		}
		return bln;

	}
	public static boolean updateStatusMsid(String strMin) throws SQLException {
		boolean bln = false;
		com.components.Constants constant =  new com.components.Constants();
		if(strMin !=null || !strMin.equalsIgnoreCase("")) {
			pstmt = connection.prepareStatement(constant.queryUpdateStatusMsid);
			pstmt.setString(1, strMin);
			int val = pstmt.executeUpdate();
			if(val >0) {
				bln = true;
			}			
		}
		return bln;

	}
	/*public static ArrayList getStatusTest(String strESN) throws SQLException, Exception {
		com.components.Constants constant =  new com.components.Constants();
		int rscount = 0;
		if(strESN !=null || !strESN.equalsIgnoreCase("")) {
			//ArrayList<String> Status = new ArrayList();
			if (connection == null) {
				Class.forName("oracle.jdbc.OracleDriver");
				//String url = "jdbc:oracle:thin:@devdb.tracfone.com:3013:CLFYSITB";
				String url = "jdbc:oracle:thin:@devdb.tracfone.com:3011:CLFYSIT1";
				//String url = "jdbc:oracle:thin:@devdb.tracfone.com:3015:CLFYSITA";
				connection = DriverManager.getConnection(url,"itquser_data","sit14testdata");
				
				pstmt = connection.prepareStatement(constant.queryGetStatus);
				pstmt.setString(1, strESN);
				ResultSet rs = pstmt.executeQuery();
				//int value= pstmt.executeUpdate();

				while(rs.next()) {
					 String val =  rs.getString(1).toString();
					 if(!val.equalsIgnoreCase("")|| val != null) {
					 Status.add(val);
					 }
					rscount+=1;
				}
				for(String statusList:Status) {
					System.out.println(statusList);
				}
//				
//				if(!strStatus.equalsIgnoreCase("")|| strStatus != null)
//				{
//					System.out.println("rscount: "+strStatus);
//					if(strStatus.equalsIgnoreCase("S"))
//					{
//						System.out.println("Don't Exit");
//						
//					}
//					
//				}
				// rs.absolute(rscount);
//				for(int i=1;i<=rscount;i++) {
//					System.out.println("Status :"+Status);
//					Status = rs.getString(i);
//					if(Status!="S") {
//						//System.out.println("Status :"+Status);
//						break;
//					}
//				}
//			}
				
		}
		
	}
		return Status;

}*/
	public static String getStatus(String strESN) throws SQLException, Exception {
		com.components.Constants constant =  new com.components.Constants();
		int rscount = 0;
		if(strESN !=null || !strESN.equalsIgnoreCase("")) {
			//ArrayList<String> Status = new ArrayList();
			/*if (connection == null) {
				Class.forName("oracle.jdbc.OracleDriver");
				String url = "jdbc:oracle:thin:@devdb.tracfone.com:3013:CLFYSITB";
				//String url = "jdbc:oracle:thin:@devdb.tracfone.com:3015:CLFYSITA";
				connection = DriverManager.getConnection(url,"itquser_data","sitb4testdata");*/
				
				pstmt = connection.prepareStatement(constant.queryGetStatus);
				pstmt.setString(1, strESN);
				ResultSet rs = pstmt.executeQuery();				 
				while(rs.next()) {
					 Status =  rs.getString(1);
					 System.out.println("Status:"+ Status);
					rscount+=1;
				}
				
		}
//		}
		return Status;

	//	public static void main(String [] args){
	//		getConnection("WFM128PSIMT5TM","WFMAPPU0049","WFMLGL57BGP");
		//}
}
}