package com;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AddTraining
 */
@WebServlet("/AddTraining")
public class AddTraining extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddTraining() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		int tid= Integer.valueOf(request.getParameter("tid"));
		String tname= request.getParameter("tname");
		String sdate= request.getParameter("sdate");
		String edate= request.getParameter("edate");
		String tmode= request.getParameter("mode");
		String bunit= request.getParameter("bunit");
		String cpersonid= request.getParameter("cpersonid");
		
		Training obj=new Training();
		obj.setTid(tid);
		obj.setTname(tname);
		obj.setSdate(sdate);
		obj.setEdate(edate);
		obj.setTmode(tmode);
		obj.setBunit(bunit);
		obj.setCpersonid(cpersonid);
		
		int status=Dao.saveTraining(obj);
		
		if(status>0) {
			
			out.println("<p>Record saved successfully!</p>");
		    out.println("<a href='admin.html'>Click to switch back to Admin page</a>");
		    
		}
			
		else
			out.println("<p>Sorry! unable to save record</p>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
