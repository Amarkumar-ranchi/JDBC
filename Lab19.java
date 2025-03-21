package com.coursecube.jdbc;
import com.coursecube.jdbc.util.DataSourceUtil;
import java.sql.*;

public class Lab19 {
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

		
		 st=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
		rs=st.executeQuery(SQL);
		
		  System.out.println("Rs Type:"+st.getResultSetType());
		  System.out.println("Rs Updatability:"+st.getResultSetConcurrency());
		  System.out.println("Rs Holdability:"+st.getResultSetHoldability());
		  
	               System.out.println("-------Forward Order-------");
           while(rs.next()) { 
        	   displayRow(rs);
           }
           
          //Insert Record into RS
           rs.moveToInsertRow();//0 null null 0 null
           
           rs.updateInt(1,502);// 502 null null 0 null
           rs.updateString(2,"hai");// 502 hai null 0 null
           rs.updateString(3,"hai@jlc");// 502 hai hai@jlc 0 null
           rs.updateInt(4,666);// 502 hai hai@jlc 666 null
           rs.updateString(5,"Blore");// 502 hai hai@jlc 666 Blore
           
           rs.insertRow();//Insert the Row in DB
           
           //Update the Row 8
           rs.absolute(8);
        
           rs.updateString(2,"Anshul");
           rs.updateString(3,"An@jlc");
           rs.updateInt(4,666);
           rs.updateString(5,"Blore");
           
           rs.updateRow();//Update the row with DB	
        
           // Delete the Row 10 
           rs.absolute(10);
           rs.deleteRow();
           
           // Delete the Row 1
           rs.absolute(1);
           rs.deleteRow();
           
         rs.beforeFirst();
           System.out.println("-------Forward Order-------");
           while(rs.next()) { 
        	   displayRow(rs);
           }
		 System.out.println("----Done----");
	
}catch(Exception ex) {
	ex.printStackTrace();	
}finally {
	DataSourceUtil.cleanup(rs, st, con);
	
}
	}
	
	



	}


