package com.coursecube.jdbc;
import com.coursecube.jdbc.util.DataSourceUtil;
import java.sql.*;

public class Lab7 {

	public static void main(String[] args) {
		
		Connection con=null;
		PreparedStatement ps=null;
 
    int mycid=120;
    String mycname="Ankit Gupta";
    String myemail="an@jlc";
    int myphone=333;
    String mycity="Blore";
    
try {
	
	con=DataSourceUtil.getConnection();
	String SQL="insert into mycustomers values(?,?,?,?,?)";
		
	
		 ps=con.prepareStatement(SQL);
			ps.setInt(1,mycid);	
			ps.setString(2,mycname);
			ps.setString(3,myemail);
			ps.setInt(4,myphone);
			ps.setString(5,mycity);
		
	int x=ps.executeUpdate();
	                 
         if  (x==1){
        	   System.out.println("Customer Record is Inserted Succesfully"); 
           }else {
	                  System.out.println("Sorry Customer Record is Not Inserted");
           }
          
}catch(Exception ex) {
	ex.printStackTrace();	
}finally {
	  
	DataSourceUtil.cleanup( ps, con);
}
	}
	
	



	}


