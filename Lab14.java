package com.coursecube.jdbc;
import com.coursecube.jdbc.util.DataSourceUtil;
import java.sql.*;

public class Lab14 {

	public static void main(String[] args) {
		
		Connection con=null;
		 CallableStatement cs=null;

  int mysid=103;
try {
	
	con=DataSourceUtil.getConnection();
	String SQL="{call findmyGrade1(?,?,?,?,?)}";
		
	
		 cs=con.prepareCall(SQL);
		cs.setInt(1,mysid);	
		cs.registerOutParameter(2,Types.INTEGER);
		cs.registerOutParameter(3,Types.DOUBLE);
		cs.registerOutParameter(4,Types.CHAR);
		cs.registerOutParameter(5,Types.CHAR);

	cs.execute();

  System.out.println("Done-call completed:");  
  
int total=cs.getInt(2);
  double avg=cs.getDouble(3);
  String status=cs.getString(4);
  String grade=cs.getString(5); 
  
  System.out.println("Total:\t"+total);
  System.out.println("Avg:\t"+avg);
  System.out.println("Status:\t"+status);
  System.out.println("Grade:\t"+grade);
  
}catch(Exception ex) {
	ex.printStackTrace();	
}finally {
	  
	DataSourceUtil.cleanup( cs, con);
}
	}
	
	



	}


