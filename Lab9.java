package com.coursecube.jdbc;
import com.coursecube.jdbc.util.DataSourceUtil;
import java.sql.*;

public class Lab9 {

	public static void main(String[] args) {
		
		Connection con=null;
		Statement st=null;
		ResultSet rs=null;
 
  String  SQL1="insert  into mycustomers values(107,'vishal Gupta','vg@jlc',3213,'Blore')";
  String  SQL2="update mycustomers set phone=22334 where phone=24411 ";
  	String SQL3="select * from mycustomers"; 
try {
	
	con=DataSourceUtil.getConnection();
	
		
	
		 st=con.createStatement();
			
		
	boolean b=st.execute(SQL3);
	                 
         if  (b==false){
        	   System.out.println("Submitted -Updatable Op"); 
    int x=st.getUpdateCount();
	                  System.out.println("Records Updated:"+x);
           }else {
        	   System.out.println("Submitted -select Op");
        	    rs=st.getResultSet();
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
	  
	DataSourceUtil.cleanup( rs,st, con);
}
	}
	
	



	}


