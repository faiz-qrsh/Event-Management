package com.ems;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
public class ViewEvent extends HttpServlet{
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Event  Page</title>");
        out.println("<link rel=\"stylesheet\" href=\"total.css\">");
        out.println("<link href=\"https://fonts.googleapis.com/css2?family=Balsamiq+Sans&display=swap\" rel=\"stylesheet\">");
        out.println("</head>");
        out.println("<body>");
        try{
        	Class.forName("com.mysql.cj.jdbc.Driver");  
		    Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ems","root","Faiz@293031");  

            response.setContentType("text/html");
            Statement stmt1 = con.createStatement();  
            ResultSet rp = stmt1.executeQuery("select * from Event"); 
                 
            
            out.println("<center><h1>Event Details</h1></center>");
            out.println("<br>");
            out.println("<div>");
                 
            out.println("<center>");
            out.println("<table border=2 width=50% height=50%>");  
            out.println("<tr><th style='padding: 10px; text-align: center; '>EventNumber</th><th style='padding: 10px; text-align: center; '>EventName</th><th style='padding: 10px; text-align: center; '>Coordinator</th><th style='padding: 10px; text-align: center; '>Coordinator Contact</th><th style='padding: 10px; text-align: center; '>Fees</th><th style='padding: 10px; text-align: center;'>Venue</th><th style='padding: 10px; text-align: center; '>Date</th>");  
            while (rp.next()) 
            {  
                String n = rp.getString("EventNo");  
                String nm = rp.getString("EventName");  
                String co = rp.getString("CoordinatorNo");
                String cono  = rp.getString("CoordinatorName");
                String f=rp.getString("fee");
                String v=rp.getString("venue");
                String d=rp.getString("date");
                out.println("<tr><td style='text-align: center;'>" + n + "</td><td style='text-align: center;>" + nm +"</td><td style='text-align: center;>"+co+"</td><td style='text-align: center;>"+cono+"</td><td style='text-align: center;>"+f+"</td><td style='text-align: center;>"+v+"</td><td style='text-align: center;>"+d+"</td></tr>");   
            }  
            
            con.close(); 
            out.println("</table>"); 
            out.println("</center>");
            out.print("</body>");
            out.print("</html>"); 
        } catch(Exception exe){System.out.println("Exception caught"+exe);}
    }
}
