package com.ems;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class StoreP extends HttpServlet{
	
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        response.setContentType("text/html");
        
        PrintWriter out=response.getWriter();
        String up = request.getParameter("Pusername");
        String pp = request.getParameter("Ppassword");
        String cp = request.getParameter("Cpassword");
        String name = request.getParameter("Pname"); 
                
        String a1=up;
        String a2=pp;
        String a3=cp;
        String a4 =name;
        
        
        if(a2.equals(a3)){
            
             try{
            	 Class.forName("com.mysql.cj.jdbc.Driver");  
     		     Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ems","root","Faiz@293031");  

                 PreparedStatement ps=con.prepareStatement("insert into plogindetails values(?,?,?)");  
     		     ps.setString(1,a1);  
     		     ps.setString(2,a2);
     		     ps.setString(3,a3);
     		     ps.executeUpdate();
                 
                 RequestDispatcher rd=request.getRequestDispatcher("Plogin.html");
                 rd.forward(request, response);
                 con.close();
                 
            }catch(Exception exe){System.out.println(exe);}
             
        }
        else
        {
            out.println("<center><h1>!! Please Enter Password And Confirm Password Same !!</h1><center>");
            RequestDispatcher rd=request.getRequestDispatcher("Psignup.html");
            rd.include(request, response);
        }
            
        
    }

}