package com;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ViewTraining
 */
@WebServlet("/ViewTraining")
public class ViewTraining extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewTraining() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
        
        out.println("<a href='AddTraining.html'>Add Training Details</a>");  
        out.println("<h1>Training List</h1>");  
          
        List<Training> list=Dao.getAllTraining();  
          
        out.print("<table border='1' width='100%'");  
        out.print("<tr><th>TId</th><th>TName</th><th>StartDate</th><th>EndDate</th><th>TMode</th><th>BUnit</th><th>CPersonID</th></tr>");  
        for(Training t:list){  
         out.print("<tr><td>"+t.getTid()+"</td><td>"+t.getTname()+"</td><td>"+t.getSdate()+"</td><td>"+t.getEdate()+"</td><td>"+t.getTmode()+"</td><td>"+t.getBunit()+"</td><td>"+t.getCpersonid()+"</td><td><a href='DeleteTraining?id="+t.getTid()+"'>delete</a></td></tr>");  
        }  
        out.print("</table>");  
          
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
