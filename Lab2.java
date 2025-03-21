package com.coursecube.jdbc;

import java.sql.*;

public class Lab2 {

	public static void main(String[] args) {
		
		Connection con=null;
		Statement st=null;
        ResultSet rs=null;
        
try {
	
	//step 1: Load the Driver Class
		Class.forName("com.mysql.jdbc.Driver");
		
			//step 2: Open the Connection
		 con = DriverManager.getConnection("jdbc:mysql://localhost:3306/myjdbcdb","root","Chinta");
				//step 3: Prepare SQL Statement
		String SQL="select*from mycustomers where city='Blore'";
					//step 4: Create the JDBC Statement
		 st=con.createStatement();
						//step 5: Submit SQL to DB
		rs=st.executeQuery(SQL);
	                  //  Step 6: Process Results
           while(rs.next()) {
        	   
        	   int cid=rs.getInt(1);
        	   String cn=rs.getString(2);
        	   String em=rs.getString(3);
        	   int ph=rs.getInt(4);
        	   String ci=rs.getString(5);
        	 
        	   System.out.println(cid+"\t"+cn+"\t"+em+"\t"+ph+"\t"+ci);
           }	
	                    
		 System.out.println("----Done----");
	
}catch(Exception ex) {
	ex.printStackTrace();	
}finally {
	  //Step 7: Close the Resources.
	try {
		if(rs!=null)
			rs.close();
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


