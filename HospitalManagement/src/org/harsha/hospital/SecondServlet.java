package org.harsha.hospital;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SecondServlet  extends HttpServlet{

public void doPost(HttpServletRequest request, HttpServletResponse response)  
	        throws ServletException, IOException{
	
	String name = request.getParameter("username");
	LoginDao.getDoctor(name);
	PrintWriter out = response.getWriter();
	

	  out.print("<html><body>"
			  +"<table style=\"width:100%\">\r\n" + 
			  "  <tr>" + 
			  "    <th>Docter's name</th>" + 
			  "    <th>Contact no</th>" + 
			  "    <th>Department</th>"+"<th>Book Appointment</th>"+ 
			  "  </tr>" + 
			  "  <tr>" + 
			  "    <td>"+LoginDao.namet+"</td>" + 
			  "    <td>"+LoginDao.ph+"</td>" + 
			  "    <td>"+LoginDao.dept+"</td>" +"<td>"+"<a href=form.html>\"Book an appointment\"</a>"+"</td>"+ 
			  "  </tr>" + 
			  "</table>"+"<br><br>"
			  
			  );

	
}//remove this after	
}
