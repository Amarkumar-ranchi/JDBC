package com.coursecube.jdbc;
import com.coursecube.jdbc.util.DataSourceUtil;
import java.sql.*;

public class Lab6 {

	public static void main(String[] args) {
		
		Connection con=null;
		Statement st=null;
        ResultSet rs=null;
        String mycity="Pune";
try {
	con=DataSourceUtil.getConnection();


		String SQL=String.format("select*from mycustomers where city='%s'",mycity);
		System.out.println(SQL);		
		 st=con.createStatement();
						
		rs=st.executeQuery(SQL);
	               
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
	DataSourceUtil.cleanup(rs, st, con);
	
}
	}
	
	



	}


