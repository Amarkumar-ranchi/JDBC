package com.coursecube.jdbc;
import com.coursecube.jdbc.util.DataSourceUtil;
import java.sql.*;

public class Lab5 {

	public static void main(String[] args) {
		
		Connection con=null;
		Statement st=null;
 
    int mycid=109;
    String mycname="Rahul";
    String myemail="Rah@jlc";
    int myphone=222;
    String mycity="Blore";
    
try {
	
	con=DataSourceUtil.getConnection();
		String SQL=String.format("insert into mycustomers values(%d,'%s','%s',%d,'%s')",mycid,mycname,myemail,myphone,mycity);
		System.out.println(SQL);
	
		 st=con.createStatement();
						
	int x=st.executeUpdate(SQL);
	                 
         if  (x==1){
        	   System.out.println("Customer Record is Inserted Succesfully"); 
           }else {
	                  System.out.println("Sorry Customer Record is Not Inserted");
           }
          
}catch(Exception ex) {
	ex.printStackTrace();	
}finally {
	  
	DataSourceUtil.cleanup( st, con);
}
	}
	
	



	}


