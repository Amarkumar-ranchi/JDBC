package com.coursecube.jdbc;
import com.coursecube.jdbc.util.DataSourceUtil;
import java.sql.*;

public class Lab11 {

	public static void main(String[] args) {
		
		Connection con=null;
		 CallableStatement cs=null;

 
  String  SQL1="insert  into mycustomers values(107,'vishal Gupta','vg@jlc',3213,'Blore')";
  String  SQL2="update mycustomers set phone=7659 where phone=4441 ";
  	String SQL3="select * from mycustomers where city='Blore'"; 
try {
	
	con=DataSourceUtil.getConnection();
	String SQL="{call p1(?,?,?,?)}";
		
	
		 cs=con.prepareCall(SQL);
		cs.setInt(1,10);	
		cs.setInt(2,20);	
		cs.registerOutParameter(3, Types.INTEGER);
		cs.registerOutParameter(4, Types.INTEGER);

	cs.execute();
	int sum=cs.getInt(3);
	int mul=cs.getInt(4);
  System.out.println("Sum:"+sum);       
  System.out.println("mul:"+mul);   
  
}catch(Exception ex) {
	ex.printStackTrace();	
}finally {
	  
	DataSourceUtil.cleanup( cs, con);
}
	}
	
	



	}


