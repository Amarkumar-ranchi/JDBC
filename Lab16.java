package com.coursecube.jdbc;
import com.coursecube.jdbc.util.DataSourceUtil;
import java.sql.*;

public class Lab16 {

	public static void main(String[] args) {
		
		Connection con=null;
		PreparedStatement ps=null;


try {
	Object [][] mycustomers = {
			{117,"dd","dd@jlc",54534,"Noida"},
			{118,"ee","ee@jlc",67643,"Noida"},
			{119,"ff","ff@jlc",64643,"Blore"},
	};
	
	con=DataSourceUtil.getConnection();
	String SQL="insert into mycustomers values(?,?,?,?,?)";
	
	ps=con.prepareStatement(SQL);
for(Object [] mycust: mycustomers) {
ps.setInt(1,(int)mycust[0]);
ps.setString(2,(String)mycust[1]);
ps.setString(3,(String)mycust[2]);
ps.setInt(4,(int)mycust[3]);
ps.setString(5,(String)mycust[4]);

ps.addBatch();
}


int results[]=ps.executeBatch();

for(int x:results) {
	System.out.println(x);
}

  System.out.println("Done!!!!");  
  


}catch(Exception ex) {
	ex.printStackTrace();	
}finally {
	  
	DataSourceUtil.cleanup( ps, con);
}
	}
	
	



	}


