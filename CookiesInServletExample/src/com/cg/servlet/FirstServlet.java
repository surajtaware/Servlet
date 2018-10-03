package com.cg.servlet;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
@WebServlet("/firstServlet")
public class FirstServlet extends HttpServlet {
 
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
         
    	
        
        Cookie firstName = new Cookie("first_name", request.getParameter("first_name"));
        Cookie lastName = new Cookie("last_name", request.getParameter("last_name"));

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
        
        
        String htmlRespone = "<html>";
        htmlRespone += "<form method=\'post\' action=\'secondServlet\'>";
        htmlRespone += "First Name: " + firstName1  + "<br/>";      
        htmlRespone += "Last Name: " + lastName1  + "<br/>";               
        htmlRespone += "Email: <input type='text' name='email'/><br/>";
        htmlRespone += "Phone: <input type='text' name='phone'/><br/>";
        		htmlRespone += "<input type='submit' value='Submit'/>";
        
        
        htmlRespone += "</form></html>";
         
        writer.println(htmlRespone);
         
    }
 
}