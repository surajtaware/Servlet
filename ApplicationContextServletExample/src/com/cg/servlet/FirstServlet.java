package com.cg.servlet;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
@WebServlet("/firstServlet")
public class FirstServlet extends HttpServlet {
 
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
         
    	ServletContext context = request.getSession().getServletContext();
        String firstName1 = request.getParameter("firstName");
        String lastName1 = request.getParameter("lastName");
        context.setAttribute("firstName", firstName1);
        context.setAttribute("lastName", lastName1);
        
            
        PrintWriter writer = response.getWriter();
        
        String firstName =(String) context.getAttribute("firstName");
        String lastName =(String) context.getAttribute("lastName");
        
        String htmlRespone = "<html>";
        htmlRespone += "<form method=\'post\' action=\'secondServlet\'>";
        htmlRespone += "First Name: " + firstName  + "<br/>";      
        htmlRespone += "Last Name: " + lastName  + "<br/>";               
        htmlRespone += "Email: <input type='text' name='email'/><br/>";
        htmlRespone += "Phone: <input type='text' name='phone'/><br/>";
        		htmlRespone += "<input type='submit' value='Submit'/>";
        
        
        htmlRespone += "</form></html>";
         
        writer.println(htmlRespone);
         
    }
 
}