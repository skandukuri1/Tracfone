package com.components;


public class Constants {

	public static String queryUpdateSIM = "update table_part_inst set x_iccid = ? where part_serial_no= ? and x_part_inst_status='50'";
	public static String queryUpdateStatus = "update ig_transaction set status = 'W' where esn = ? and not status ='S'";
	public static String queryUpdateStatusMsid = "update ig_transaction set status = 'W' , new_msid_flag = 'Y' where action_item_id IN (select action_item_id from ig_transaction where msid= ?) AND not status ='S'";
	public String queryGetStatus = "select status as STATUS from ig_transaction where esn= ?";
}
