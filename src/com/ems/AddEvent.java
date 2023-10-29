package com.ems;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
public class AddEvent extends HttpServlet{
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        response.setContentType("text/html");
        
        PrintWriter out=response.getWriter();
        
        String a1=request.getParameter("EventNo");
        String a2=request.getParameter("EventName");
        String a3=request.getParameter("coordinatorName");
        String a4=request.getParameter("CoordinatorNo");
        String a5 =request.getParameter("fee");
        String a6=request.getParameter("venue");
        String a7=request.getParameter("date");
        
        try{
        	Class.forName("com.mysql.cj.jdbc.Driver");  
		    Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ems","root","Faiz@293031");  

		    PreparedStatement ps=con.prepareStatement("insert into event values(?,?,?,?,?,?,?)");  
		     ps.setString(1,a1);  
		     ps.setString(2,a2);
		     ps.setString(3,a3);
		     ps.setString(4,a4);
		     ps.setString(5,a5);
		     ps.setString(6,a6);
		     ps.setString(7,a7);
		     ps.executeUpdate();
                 
            RequestDispatcher rd=request.getRequestDispatcher("CreateE.html");
            rd.include(request, response);
                 
            out.println("<br><center><h3> Event Added</h3></center>");
            System.out.println("Added to database!");
            con.commit();
            con.close();
            }catch(Exception exe){System.out.println("Exception caught"+exe);}
        }
    }



