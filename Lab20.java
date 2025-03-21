package com.coursecube.jdbc;
import com.coursecube.jdbc.util.DataSourceUtil;
import java.sql.*;

public class Lab20 {
public static void displayRow(ResultSet rs) throws SQLException {
}
	public static void main(String[] args) {
		
		Connection con=null;
		Statement st=null;
        ResultSet rs=null;
   
try {
	con=DataSourceUtil.getConnection();


		String SQL="select*from mycustomers";
		 st=con.createStatement();
		rs=st.executeQuery(SQL);
		
ResultSetMetaData rsmd =rs.getMetaData();
int cc=rsmd.getColumnCount();
System.out.println("Col Count:"+cc);

rs.first();
for(int i=1;i<=cc;i++) {

		 String colName=rsmd.getColumnName(i);
		 System.out.println(colName);
		 String colLabel=rsmd.getColumnLabel(i);
		 System.out.println(colLabel);
		 String colType=rsmd.getColumnTypeName(i);
		 System.out.println(colType);
		 String colClsName=rsmd.getColumnClassName(i);
		 System.out.println(colClsName);
		 String tabName=rsmd.getTableName(i);
		 System.out.println(tabName);
		 String catName=rsmd.getCatalogName(i);
		 System.out.println(catName);
		 System.out.println("------------");
		 
}
		 System.out.println("----Done----");
	
}catch(Exception ex) {
	ex.printStackTrace();	
}finally {
	DataSourceUtil.cleanup(rs, st, con);
	
}
	}
	
	



	}


