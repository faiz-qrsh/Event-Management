package com.ems;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
public class Register extends HttpServlet{
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        
        response.setContentType("text/html");
        PrintWriter out=response.getWriter();
        String a1=request.getParameter("cardno");
        String a2=request.getParameter("edate");
        String a3=request.getParameter("cvv");
        String a4=request.getParameter("cname");
        String a5=request.getParameter("enum");
        String a6=request.getParameter("ename");
        
        try{
        	
        	Class.forName("com.mysql.cj.jdbc.Driver");  
		    Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ems","root","Faiz@293031");  
		    PreparedStatement ps=con.prepareStatement("insert into card values(?,?,?,?,?,?)");  
		     ps.setString(1,a1);  
		     ps.setString(2,a2);
		     ps.setString(3,a3);
		     ps.setString(4,a4);
		     ps.setString(5,a5);
		     ps.setString(6,a6);
		     ps.executeUpdate();
            con.close();
            RequestDispatcher rd=request.getRequestDispatcher("Payment.html");
            rd.forward(request,response);  
            
            }catch(Exception exe){
            	System.out.println("Exception caught"+exe);
            }
    }
}
    