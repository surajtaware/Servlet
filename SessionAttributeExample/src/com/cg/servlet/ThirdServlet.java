package com.cg.servlet;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
 
@WebServlet("/thirdServlet")
public class ThirdServlet extends HttpServlet {
 
	protected void doPost(HttpServletRequest request,
		    HttpServletResponse response) throws ServletException, IOException {
		        
		HttpSession session = request.getSession();
		session.setAttribute("city", request.getParameter("city"));
		session.setAttribute("country", request.getParameter("country"));
	        
	    PrintWriter writer = response.getWriter();
	    
	    String firstName =(String) session.getAttribute("firstName");
	    String lastName =(String) session.getAttribute("lastName");
	    String email =(String) session.getAttribute("email");
	    String phone =(String) session.getAttribute("phone");
	    String city =(String) session.getAttribute("city");
	    String country =(String) session.getAttribute("country");
		     
		        
		        
		    
		    String htmlRespone = "<html>";
		    htmlRespone += "<form method=\'post\' action=\'thirdServlet\'>";
		    htmlRespone += "First Name: " + firstName + "<br/>";      
		    htmlRespone += "Last Name: " + lastName + "<br/>";
		    htmlRespone += "Email: " + email + "<br/>";      
		    htmlRespone += "Phone: " + phone + "<br/>"; 
		    htmlRespone += "City: " + city + "<br/>";      
		    htmlRespone += "Country: " + country + "<br/>";
		    
		    
		    htmlRespone += "</form></html>";
		     
		    writer.println(htmlRespone);
		     
		}
		}
