package com.cg.servlet;
import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/secondServlet")
public class SecondServlet extends HttpServlet {

	 protected void doPost(HttpServletRequest request,
    HttpServletResponse response) throws ServletException, IOException {
        
		 Cookie firstName = new Cookie("email", request.getParameter("email"));
	     Cookie lastName = new Cookie("phone", request.getParameter("phone"));

	        firstName.setMaxAge(60*60*24);
	        lastName.setMaxAge(60*60*24);

	        response.addCookie( firstName );
	        response.addCookie( lastName );
	            
	        PrintWriter writer = response.getWriter();
	        Cookie[] cookies = request.getCookies();

	        String firstName1 = null;
	        String lastName1 = null;
	        for(Cookie cookie : cookies){
	            if("firstName".equals(cookie.getName())){
	            	firstName1 = cookie.getValue();
	            }else if("lastName".equals(cookie.getName())){
	            	lastName1 = cookie.getValue();}
	        }
   
        
    PrintWriter writer = response.getWriter();
    
    
    String htmlRespone = "<html>";
    htmlRespone += "<form method=\'post\' action=\'thirdServlet\'>";
    htmlRespone += "First Name: " + firstName + "<br/>";      
    htmlRespone += "Last Name: " + lastName + "<br/>";
    htmlRespone += "Email: " + email + "<br/>";      
    htmlRespone += "Phone: " + phone + "<br/>"; 
    htmlRespone += "City: <input type='text' name='city'/><br/>";
    htmlRespone += "Country: <input type='text' name='country'/><br/>";
    htmlRespone += "<input type='submit' value='Submit'/>";
    
    
    htmlRespone += "</form></html>";
     
    writer.println(htmlRespone);
     
}
}
