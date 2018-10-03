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
 
@WebServlet("/firstServlet")
public class FirstServlet extends HttpServlet {
 
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
         
    	HttpSession session = request.getSession();
        String firstName1 = request.getParameter("firstName");
        String lastName1 = request.getParameter("lastName");
        session.setAttribute("firstName", firstName1);
        session.setAttribute("lastName", lastName1);
        
            
        PrintWriter writer = response.getWriter();
        
        String firstName =(String) session.getAttribute("firstName");
        String lastName =(String) session.getAttribute("lastName");
        
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