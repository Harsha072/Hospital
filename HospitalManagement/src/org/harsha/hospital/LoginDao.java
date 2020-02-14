package org.harsha.hospital;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDao { 
static	Connection con=null;
static int id1;
 static String namet;
static String ph;
static int dept;



public static boolean validate(String name,String pass){  
boolean status=false;  
String url="jdbc:mysql://localhost:3306/hospital";
String username = "root";
String pwd = "Reset123";

try {
    Class.forName("com.mysql.cj.jdbc.Driver");  
 con=DriverManager.getConnection(url,username,pwd);  
	    
	PreparedStatement ps=con.prepareStatement("select * from patient where username=? and pwd=?");  
     ps.setString(1,name);   
     ps.setString(2,pass);  
    

      ResultSet rs=ps.executeQuery();  
         status=rs.next();  
        
}
catch(Exception e){
	System.out.println(e);


}  
return status;  


}
public static void getDoctor(String name) {
	ResultSet rs=null;
	Boolean b = false;
	String qry2 = "select * from doctors where name=?";
	
	try {
		PreparedStatement ps=con.prepareStatement(qry2);
		ps.setString(1, name);
		rs = ps.executeQuery();
		if(rs.next()) {
			 id1 = rs.getInt(1);
			 namet = rs.getString(2);
			 ph = rs.getString(3);
			 dept = rs.getInt(4);
			
			System.out.println(namet+" "+ph+" "+dept);
		}
		
		
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
}
public static void BookAppointment(String fname,String lname,String ct,String em) {
	
String qry2 = "insert into appointment values(?,?,?,?)";
	
	try {
		PreparedStatement ps=con.prepareStatement(qry2);
		ps.setString(1, fname);
		ps.setString(2, lname);
		ps.setString(3, ct);
		ps.setString(4, em);
		ps.executeUpdate();
		System.out.println("all data inserted");
		
	} catch (SQLException e) {
		e.printStackTrace();
	}
	
}

}  
