package com.htc.servlets.day1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HelloServlet
 */
@WebServlet("/hello")
public class HelloServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		PrintWriter pw = response.getWriter(); //getting the outputstream of servlet.
		response.setContentType("text/html");

		ServletContext servletContext = getServletContext();
		String org = servletContext.getInitParameter("organization");
		String email= servletContext.getInitParameter("email");
		
		pw.println("<h2> Welcome to HelloServlet</h2");
		pw.println("<b> This is a test page</b>");
		pw.println("Organzation:" + org);
		pw.println("Emai:" + email);
		//pw.close();
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
