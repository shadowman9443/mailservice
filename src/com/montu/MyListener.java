package com.montu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Application Lifecycle Listener implementation class MyListener
 *
 */
public class MyListener implements ServletContextListener {

    /**
     * Default constructor. 
     */
    public MyListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent arg0) {
    	System.out.println("project undeployed");
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent arg0) {
    	Connection con=null;
    	try{
    		

    		Class.forName("oracle.jdbc.driver.OracleDriver");
    		con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","maildb","1234");
    		
    		PreparedStatement ps2= con.prepareStatement("CREATE SEQUENCE MONTU MINVALUE 1 MAXVALUE 999999999 INCREMENT BY 1 START WITH 1 NOCACHE NOORDER NOCYCLE");
    		ps2.executeUpdate();
    		PreparedStatement ps=con.prepareStatement("CREATE TABLE MAILCASTINGUSER(EMAIL VARCHAR2(4000),PASSWORD VARCHAR2(4000),NAME VARCHAR2(4000),GENDER VARCHAR2(4000),MNAME VARCHAR2(4000), COUNTRY VARCHAR2(4000)))");
    		ps.executeUpdate();
    		PreparedStatement ps4=con.prepareStatement("CREATE TABLE INBOX6(ID NUMBER,RECIEVER VARCHAR2(4000),SENDER VARCHAR2(4000),MESSAGE VARCHAR2(4000),DATE_OF_RECEIVING VARCHAR2(4000))");
    		ps4.executeUpdate();		
    		
    		Statement stmt=con.createStatement();
    		stmt.executeUpdate("CREATE TRIGGER  BI_INBOX6 before insert on INBOX6 for each row begin select MONTU.nextval into :NEW.ID from dual;end");
    		}	
    	
    		
    	    catch(Exception e){
    	    	e.printStackTrace();
    	    	
    	    }
    }
	
}
