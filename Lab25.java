package com.coursecube.jdbc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.apache.commons.dbcp.BasicDataSource;

import com.coursecube.jdbc.util.DataSourceUtil;


public class Lab25 { 
public static void main(String[] args) { 
 
	Connection con = null;
	PreparedStatement ps=null;
int dd = 8;
int mm=01;
int yy=2000;
Date dob=new Date(yy - 1900, mm - 1,dd);//1
	
try { 
 
 
 con=DataSourceUtil.getConnection();
String SQL = "insert into mystudents values(?,?,?)";
ps=con.prepareStatement(SQL);	
ps.setInt(1, 103);
ps.setString(2, "Anshul ");
ps.setDate(3, dob);//2

 int x=ps.executeUpdate();

 
 System.out.println(x);

 
System.out.println("----Done-----"); 
} catch (Exception ex) { 
ex.printStackTrace(); 
} finally { 
DataSourceUtil.cleanup(ps, con);
} 
} 
} 
 
 
 
 
 
