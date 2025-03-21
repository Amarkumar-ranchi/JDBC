package com.coursecube.jdbc;

import java.sql.*;

public class Lab1 {

	public static void main(String[] args) {
		
		Connection con=null;
		Statement st=null;
 
        
try {
	
	//step 1: Load the Driver Class
		Class.forName("com.mysql.jdbc.Driver");
		
			//step 2: Open the Connection
		 con = DriverManager.getConnection("jdbc:mysql://localhost:3306/myjdbcdb","root","Chinta");
				//step 3: Prepare SQL Statement
		String SQL="insert into mycustomers values(104,'amit ranjan','amit@jlc',24411,'Blore')";
					//step 4: Create the JDBC Statement
		 st=con.createStatement();
						//step 5: Submit SQL to DB
	int x=st.executeUpdate(SQL);
	                  //  Step 6: Process Results
         if  (x==1){
        	   System.out.println("Customer Record is Inserted Succesfully"); 
           }else {
	                  System.out.println("Sorry Customer Record is Not Inserted");
           }
}catch(Exception ex) {
	ex.printStackTrace();	
}finally {
	  //Step 7: Close the Resources.
	try {
		
		if(st!=null)
			st.close();
		if(con!=null)
			con.close();
	}catch(Exception e) {
		e.printStackTrace();
	}
}
	}
	
	



	}


