package com.cg.servlet;
import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/secondServlet")
public class SecondServlet extends HttpServlet {

	 protected void doPost(HttpServletRequest request,
    HttpServletResponse response) throws ServletException, IOException {
        
    String firstName = request.getParameter("firstName");
    String lastName = request.getParameter("lastName");
    String email = request.getParameter("email");
    String phone = request.getParameter("phone");
     
        
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
