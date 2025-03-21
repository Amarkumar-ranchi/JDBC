package com.coursecube.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.apache.commons.dbcp.BasicDataSource;

import com.coursecube.jdbc.util.DataSourceUtil;


public class Lab24 { 
public static void main(String[] args) { 
 
	Connection con = null;
	PreparedStatement ps=null;
	ResultSet rs=null;
	
try { 
 
 
 con=DataSourceUtil.getConnection();
String SQL = "select * from mycustomers";
ps=con.prepareStatement(SQL);		
rs=ps.executeQuery();

 


 
while (rs.next()) { 
int cid = rs.getInt(1); 
String cn = rs.getString(2); 
String em = rs.getString(3); 
int ph = rs.getInt(4); 
String ci = rs.getString(5); 
 
System.out.println(cid + "\t" + cn + "\t" + em + "\t" + ph + "\t" + ci); 
} 
System.out.println("----Done-----"); 
} catch (Exception ex) { 
ex.printStackTrace(); 
} finally { 
DataSourceUtil.cleanup(rs,ps, con);
} 
} 
} 
 
 
 
 
 
