package com.coursecube.jdbc;
import com.coursecube.jdbc.util.DataSourceUtil;
import java.sql.*;

public class Lab17 {

	public static void main(String[] args) {
		
		Connection con=null;
		PreparedStatement ps=null;


try {
	Object [][] mycustomers = {
			{120,"gg","gg@jlc",589534,"Noida"},
			{121,"hh","hh@jlc",6745643,"Noida"},
			{122,"ii","ii@jlc",641643,"Blore"},
			{123,"jj","jj@jlc",6416543,"Blore"},
	};
	
	con=DataSourceUtil.getConnection();
	String SQL="insert into mycustomers values(?,?,?,?,?)";
	
	ps=con.prepareStatement(SQL);
	
for(Object [] mycust: mycustomers) {
	int paramNum=1;
	for(Object obj:mycust) {
		ps.setObject(paramNum++,obj);
	}


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


