package com.coursecube.jdbc; 
 
import java.sql.*; 
 

public class Lab27 { 
public static void main(String[] args) { 
 
String URL="jdbc:mysql://localhost:3306/myjdbcdb"; 
String UN="root"; 
String PW="Chinta"; 
String SQL="select * from mycustomers "; 
 
try(Connection con =DriverManager.getConnection(URL,UN,PW); 
Statement st=con.createStatement(); 
ResultSet rs=st.executeQuery(SQL)  ) { 
 
while(rs.next()) { 
int cid= rs.getInt(1); 
String cn=rs.getString(2); 
String em=rs.getString(3); 
int ph=rs.getInt(4); 
String ci=rs.getString(5); 
 
System.out.println(cid+"\t"+cn+"\t"+em+"\t"+ph+"\t"+ci); 
} 
System.out.println("----Done-----"); 
}catch(Exception ex) { 
ex.printStackTrace(); 
} 
} 
}