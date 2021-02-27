package com;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/TableServlet")
public class TableServlet extends HttpServlet {
	
    public TableServlet() {
        // TODO Auto-generated constructor stub
    }
    
    public void init() throws ServletException{
    	//initialization method
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		    response.setContentType("text/html");
	        PrintWriter out = response.getWriter();

	        out.println("<html>");
	        out.println("<head><title>Table</title></head>");
	        out.println("<body>");
	        out.println("<table border='1px'>");
	        for (int i = 1; i <= 25; i++)
	        {
	        	out.println("<tr>");
	        	for(int j= 1;j<=3;j++) {
	        		
	        		out.println("<td>"+"Row"+i+","+"Col"+j+"</td>");
	        	}
	        	out.println("</tr>");
	           
	        }
	        out.println("</table>");
	        out.println("</body></html>");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	public void destroy() {
		//destroy method
	}

}
