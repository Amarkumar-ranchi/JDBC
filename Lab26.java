package com.coursecube.jdbc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;

import org.apache.commons.dbcp.BasicDataSource;

import com.coursecube.jdbc.util.DataSourceUtil;


public class Lab26 { 
public static void main(String[] args) { 
 
	Connection con = null;
	PreparedStatement ps=null; 
	ResultSet rs=null;
int dd = 8;
int mm=01;
int yy=2000;
Date dob=new Date(yy - 1900, mm - 1,dd);//1
	
try { 
 
 
 con=DataSourceUtil.getConnection();
String SQL = "select * from mystudents ";
ps=con.prepareStatement(SQL);	
rs=ps.executeQuery();

while(rs.next()) {
	int sid=rs.getInt(1);
	String sname=rs.getString(2);
	Date dob1=rs.getDate(3);//1
	SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy"); 
	String mydob = sdf.format(dob1); //2
System.out.println(sid+"\t"+sname+"\t"+mydob); 
	
}
 
System.out.println("----Done-----"); 
} catch (Exception ex) { 
ex.printStackTrace(); 
} finally { 
DataSourceUtil.cleanup(ps, con);
} 
} 
} 
 
 
 
 
 
