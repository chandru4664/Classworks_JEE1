package com.htc.servlets.day1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(
		urlPatterns = { "/TestServlet" }, 
		initParams = { 
				@WebInitParam(name = "message", value = "Good Morning")
		})
public class TestServlet extends HttpServlet {

	
	@Override
	public void init() throws ServletException {
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter pw = response.getWriter();
		response.setContentType("text/html");
		
		ServletConfig  config = getServletConfig();
		ServletContext context = config.getServletContext();

		String message = config.getInitParameter("message");
		String org = context.getInitParameter("organization");
		String email= context.getInitParameter("email");

		pw.println("<br/>Message:" + message);
		pw.println("<br/>Organzation:" + org);
		pw.println("<br/>Emai:" + email);
		pw.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
