package org.harsha.hospital;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ThirdServlet extends HttpServlet {

public void doPost(HttpServletRequest request, HttpServletResponse response)  
	        throws ServletException, IOException{
	

	 LocalDateTime myDateObj = LocalDateTime.now();
	    DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("E, MMM dd yyyy  mm:ss");

	    String formattedDate = myDateObj.format(myFormatObj);
	PrintWriter out = response.getWriter();
	String fname = request.getParameter("fname");
	String lname = request.getParameter("lname");
	String ct = request.getParameter("ct");
	String em = request.getParameter("em");
	LoginDao.BookAppointment(fname,lname,ct,em);
	out.print("<h3>"+"Your appointment is fixed at"+" "+formattedDate+"</h3>");

}

}
