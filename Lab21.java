package com.coursecube.jdbc;
import com.coursecube.jdbc.util.DataSourceUtil;
import java.sql.*;

public class Lab21 {


	public static void main(String[] args) {
		
		Connection con=null;
	
try {
	con=DataSourceUtil.getConnection();
DatabaseMetaData dbmd=con.getMetaData();

System.out.println(dbmd.getDatabaseProductName());
System.out.println(dbmd.getDatabaseProductVersion());
System.out.println(dbmd.getDatabaseMajorVersion());
System.out.println(dbmd.getDatabaseMinorVersion());
System.out.println(dbmd.getDefaultTransactionIsolation());
System.out.println(dbmd.getDriverVersion());
System.out.println(dbmd.getJDBCMajorVersion());
System.out.println(dbmd.getJDBCMinorVersion());

System.out.println(dbmd.supportsBatchUpdates());
System.out.println(dbmd.supportsFullOuterJoins());
System.out.println(dbmd.supportsTransactions());
System.out.println(dbmd.supportsGroupBy());
System.out.println(dbmd.supportsMultipleTransactions());
System.out.println(dbmd.supportsMultipleTransactions());
System.out.println(dbmd.supportsMultipleResultSets());

		
		 System.out.println("----Done----");
	
}catch(Exception ex) {
	ex.printStackTrace();	
}finally {
	DataSourceUtil.cleanup(null, con);
	
}
	}
	
	



	}


