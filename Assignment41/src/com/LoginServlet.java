package com;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		PrintWriter out = response.getWriter();
		
		Cookie[] ck=request.getCookies();
		
		if(ck!=null) {
			
			String name="";
			String password="";
			
			for(Cookie cookie:ck) {
				
				if(cookie.getName().equals("name"))
					name=cookie.getValue();
				if(cookie.getName().equals("password"))
					password=cookie.getValue();
				
			}
				
			if(LoginDao.validate(name, password))
				out.println("Login Successful");
			else
				out.println("Login Failed");
				
		}
		
		else {
			Cookie ck1 = new Cookie("name",request.getParameter("name"));
			Cookie ck2 = new Cookie("password",request.getParameter("pwd"));
			
			response.addCookie(ck1);
		    response.addCookie(ck2);
		    
		    out.println("Cookie added succsessfuly");
			
		}
		
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
