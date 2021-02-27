package com;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Enumeration;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Users extends HttpServlet {
	
	Connection con;
	ServletConfig config;
	ServletContext context;
	String driver="";
	String url="";
	String username="";
	String password="";
	
	public void init() {
		
		 config= getServletConfig();
         context=getServletContext();
         
		 driver=config.getInitParameter("driver");
		 url=config.getInitParameter("url");
			
		 username=context.getInitParameter("username");
		 password=context.getInitParameter("password");
		
		try {
			
           Class.forName(driver);
           con= DriverManager.getConnection(url,username,password);
			
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		String user=null;
		
		try {
			
			PreparedStatement ps=con.prepareStatement(  
			"select * from users where username=? and password=?");  
			ps.setString(1,request.getParameter("name"));  
			ps.setString(2,request.getParameter("pwd"));  
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				
				user=rs.getString("usertype");
			}
			
		}
		catch(Exception e) {
			System.out.println(e);
		}
		
		
		if(user==null)
			out.println("Login is failed due to invalid credentials");
		else 
			out.println("Login is successful");
		
	}


}
