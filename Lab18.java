package com.coursecube.jdbc;
import com.coursecube.jdbc.util.DataSourceUtil;
import java.sql.*;

public class Lab18 {
public static void displayRow(ResultSet rs) throws SQLException {
	  int cid=rs.getInt("cid");
	   String cn=rs.getString("cname");
	   String em=rs.getString("email");
	   int ph=rs.getInt("phone");
	   String ci=rs.getString("city");
	 
	   System.out.println(cid+"\t"+cn+"\t"+em+"\t"+ph+"\t"+ci);
}
	public static void main(String[] args) {
		
		Connection con=null;
		Statement st=null;
        ResultSet rs=null;
   
try {
	con=DataSourceUtil.getConnection();


		String SQL="select*from mycustomers";

		
		 st=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
		rs=st.executeQuery(SQL);
		
		  System.out.println("Rs Type:"+st.getResultSetType());
		  System.out.println("Rs Updatability:"+st.getResultSetConcurrency());
		  System.out.println("Rs Holdability:"+st.getResultSetHoldability());
		  
	               System.out.println("-------Forward Order-------");
           while(rs.next()) { 
        	   displayRow(rs);
           }
           
           System.out.println("-------Reverse Order-------");
           while(rs.previous()) { 
        	 displayRow(rs);
           }	
           System.out.println(rs.isBeforeFirst());//	T
           System.out.println(rs.isFirst()); //F
           rs.first();
           System.out.println(rs.isBeforeFirst());//	F
           System.out.println(rs.isFirst()); //T
           
           System.out.println("1st Record"); //T
           displayRow(rs);
       System.out.println(rs.isAfterLast());//F
       System.out.println(rs.isLast());//F
           rs.last();
           System.out.println(rs.isAfterLast());//F
           System.out.println(rs.isLast());//T
           System.out.println("Last Record"); 
         displayRow(rs);
    	   rs.absolute(5);
    	   
    	   System.out.println("5th Record"); 
    	   displayRow(rs);
    	   rs.relative(2);
    	   System.out.println("7th Record"); 
    	   displayRow(rs);
    	   rs.relative(-3);
    	   System.out.println("4th Record"); 
    	   displayRow(rs);
		 System.out.println("----Done----");
	
}catch(Exception ex) {
	ex.printStackTrace();	
}finally {
	DataSourceUtil.cleanup(rs, st, con);
	
}
	}
	
	



	}


