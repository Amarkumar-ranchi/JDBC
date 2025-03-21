package com.coursecube.jdbc;
import com.coursecube.jdbc.util.DataSourceUtil;
import java.sql.*;

public class Lab12 {

	public static void main(String[] args) {
		
		Connection con=null;
		 CallableStatement cs=null;

  int mysid=102;
try {
	
	con=DataSourceUtil.getConnection();
	String SQL="{call findBalance(?,?)}";
		
	
		 cs=con.prepareCall(SQL);
		cs.setInt(1,mysid);	
		cs.registerOutParameter(2, Types.DOUBLE);
		

	cs.execute();
	double bal=cs.getDouble(2);
  System.out.println("Balance:"+bal);       

  
}catch(Exception ex) {
	ex.printStackTrace();	
}finally {
	  
	DataSourceUtil.cleanup( cs, con);
}
	}
	
	



	}


