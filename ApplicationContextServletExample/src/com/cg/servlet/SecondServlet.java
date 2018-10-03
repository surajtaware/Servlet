package com.cg.servlet;
import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/secondServlet")
public class SecondServlet extends HttpServlet {

	 protected void doPost(HttpServletRequest request,
    HttpServletResponse response) throws ServletException, IOException {
        
     
    ServletContext context = request.getSession().getServletContext();
    context.setAttribute("email", request.getParameter("email"));
    context.setAttribute("phone", request.getParameter("phone"));
        
    PrintWriter writer = response.getWriter();
    
    String firstName =(String) context.getAttribute("firstName");
    String lastName =(String) context.getAttribute("lastName");
    String email =(String) context.getAttribute("email");
    String phone =(String) context.getAttribute("phone");
    
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
