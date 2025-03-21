package com.coursecube.jdbc;
import com.coursecube.jdbc.util.DataSourceUtil;
import java.sql.*;

public class Lab13 {

	public static void main(String[] args) {
		
		Connection con=null;
		 CallableStatement cs=null;

  int mysid=104;
try {
	
	con=DataSourceUtil.getConnection();
	String SQL="{call findGrade2(?)}";
		
	
		 cs=con.prepareCall(SQL);
		cs.setInt(1,mysid);	
		
		

	cs.execute();

  System.out.println("Done-call completed:");       

  
}catch(Exception ex) {
	ex.printStackTrace();	
}finally {
	  
	DataSourceUtil.cleanup( cs, con);
}
	}
	
	



	}


