package com.cg.servlet;
import java.io.IOException;
import java.io.PrintWriter;
 
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
@WebServlet("/thirdServlet")
public class ThirdServlet extends HttpServlet {
 
	protected void doPost(HttpServletRequest request,
		    HttpServletResponse response) throws ServletException, IOException {
		        
		    String firstName = request.getParameter("firstName");
		    String lastName = request.getParameter("lastName");
		    String email = request.getParameter("email");
		    String phone = request.getParameter("phone");
		    String city = request.getParameter("city");
		    String country = request.getParameter("country");
		     
		        
		    PrintWriter writer = response.getWriter();
		     
		    
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
