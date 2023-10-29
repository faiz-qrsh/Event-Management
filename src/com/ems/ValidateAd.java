package com.ems;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class ValidateAd extends HttpServlet{
	
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        PrintWriter out = response.getWriter();
        
        String un = request.getParameter("Ausername"); 
        String pw = request.getParameter("Apassword"); 
        
        response.setContentType("text/html");

        String u1 ="ems.admin1";
        String p1 ="admin1";
        
        String u2 ="ems.admin2";
        String p2 ="admin2";
        
        String u3 ="ems.admin3";
        String p3 ="admin3";
        
        String u4 ="ems.admin4";
        String p4 ="admin4";
        
        if(pw.equals(p1)&&un.equals(u1)){
            RequestDispatcher rd =request.getRequestDispatcher("AdminEvent.html");
            rd.forward(request, response);
        }
          else if(pw.equals(p2)&&un.equals(u2)){
          RequestDispatcher rd=request.getRequestDispatcher("AdminEvent.html");
          rd.forward(request, response);  
        }
        else if(pw.equals(p3)&&un.equals(u3)){
          RequestDispatcher rd=request.getRequestDispatcher("AdminEvent.html");
          rd.forward(request, response);  
        }
        else if(pw.equals(p4)&&un.equals(u4)){
          RequestDispatcher rd=request.getRequestDispatcher("AdminEvent.html");
          rd.forward(request, response);  
        }
        else
        {
            out.println("<center><h1>!! Please Enter Valid Username & Password for Admin !!</h1><center>");
            RequestDispatcher rd=request.getRequestDispatcher("Alogin.html");
            rd.include(request, response);
        }
        out.close();
     }
    
}
    

  
