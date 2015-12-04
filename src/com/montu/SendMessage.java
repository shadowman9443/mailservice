package com.montu;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;

public class SendMessage {
	static int status=0;
	static int d=0;
	public static int sendMsg(String sender,String reciever,String msg){
		Connection con=GetCon.getCon();
		Date sqdate=Calendar.getInstance().getTime();
		java.sql.Date dat=new java.sql.Date(sqdate.getTime());
		try {
			PreparedStatement ps=con.prepareStatement("Insert into INBOX6 values(?,?,?,?,?)");
			ps.setString(3,sender);
			ps.setString(2,reciever);
			ps.setString(4,msg);
			ps.setDate(5,dat);
			ps.setInt(1,d);
			
			
			status=ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return status;
		
		
	}
}
