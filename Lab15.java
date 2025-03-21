package com.coursecube.jdbc;
import com.coursecube.jdbc.util.DataSourceUtil;
import java.sql.*;

public class Lab15 {

	public static void main(String[] args) {
		
		Connection con=null;
		 Statement st=null;


try {
	
	con=DataSourceUtil.getConnection();
	String SQL1="insert into mycustomers values(114,'Abhishek','abhi@jlc',34412,'Noida')";
	String SQL2="insert into mycustomers values(115,'Rishikesh','ris@jlc',34016,'Noida')";		
	String SQL3="insert into mycustomers values(116,'sandeep','san@jlc',340014,'Noida')";
	
	String SQL4="update mycustomers set phone=5000 where cid=109";
	String SQL5="update mycustomers set phone=5001 where city='Noida'";
	
	String SQL6="delete from mycustomers where cid=120";
	
st=con.createStatement();

st.addBatch(SQL1);
st.addBatch(SQL2);
st.addBatch(SQL3);
st.addBatch(SQL4);
st.addBatch(SQL5);
st.addBatch(SQL6);

int results[]=st.executeBatch();

for(int x:results) {
	System.out.println(x);
}

  System.out.println("Done-call completed:");  
  


}catch(Exception ex) {
	ex.printStackTrace();	
}finally {
	  
	DataSourceUtil.cleanup( st, con);
}
	}
	
	



	}


