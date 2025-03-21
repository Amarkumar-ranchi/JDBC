package com.coursecube.jdbc;
import com.coursecube.jdbc.util.DataSourceUtil;
import java.sql.*;

public class Lab3 {

	public static void main(String[] args) {
		
		Connection con=null;
		Statement st=null;
 
        
try {
	
	con=DataSourceUtil.getConnection();
		String SQL="insert into mycustomers values(106,'yogesh k','yog@jlc',15743,'Blore')";
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


