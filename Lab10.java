package com.coursecube.jdbc;
import com.coursecube.jdbc.util.DataSourceUtil;
import java.sql.*;

public class Lab10 {

	public static void main(String[] args) {
		
		Connection con=null;
		PreparedStatement ps=null;
ResultSet rs=null;
 
  String  SQL1="insert  into mycustomers values(107,'vishal Gupta','vg@jlc',3213,'Blore')";
  String  SQL2="update mycustomers set phone=7659 where phone=4441 ";
  	String SQL3="select * from mycustomers where city='Blore'"; 
try {
	
	con=DataSourceUtil.getConnection();
	
		
	
		 ps=con.prepareStatement(SQL2);
			
		
	boolean b=ps.execute();
	                 
         if  (b==false){
        	   System.out.println("Submitted -Updatable Op"); 
    int x=ps.getUpdateCount();
	                  System.out.println("Records Updated:"+x);
           }else {
        	   System.out.println("Submitted -select Op");
        	    rs=ps.getResultSet();
        	   while(rs.next()) {
        		   int cid=rs.getInt(1);
            	   String cn=rs.getString(2);
            	   String em=rs.getString(3);
            	   int ph=rs.getInt(4);
            	   String ci=rs.getString(5);
            	   System.out.println(cid+"\t"+cn+"\t"+em+"\t"+ph+"\t"+ci);
        	   }
           }
}catch(Exception ex) {
	ex.printStackTrace();	
}finally {
	  
	DataSourceUtil.cleanup( rs,ps, con);
}
	}
	
	



	}


