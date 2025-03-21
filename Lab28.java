package com.coursecube.jdbc; 
import java.sql.*; 
import com.coursecube.jdbc.util.DataSourceUtil; 


public class Lab28 { 
public static void main(String[] args) { 

 
 
Connection con = null; 
PreparedStatement ps=null; 
 
try { 
 
con=DataSourceUtil.getConnection(); 
 
String SQL = "update mycustomers set city='Bangalore'"; 
ps=con.prepareStatement(SQL); 
 
long x= ps.executeLargeUpdate(); 
 
System.out.println(x); 
 
System.out.println("----Done-----"); 
} catch (Exception ex) { 
ex.printStackTrace(); 
} finally { 
DataSourceUtil.cleanup(ps, con); 
} 
} 
}