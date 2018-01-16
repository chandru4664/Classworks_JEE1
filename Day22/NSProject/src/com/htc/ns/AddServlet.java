package com.htc.ns;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.htc.emilvls.EmailServiceProviderImpl;
import com.htc.emilvls.IEmailServiceProvider;
import com.htc.emilvls.InvalidEmailIdException;

/**
 * Servlet implementation class AddServlet
 */
@WebServlet("/AddServlet")
public class AddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		int a=Integer.parseInt(request.getParameter("numonetext"));
		int b=Integer.parseInt(request.getParameter("numtwotext"));
		System.out.println(request.getParameter("numonetext"));
		System.out.println(request.getParameter("numtwotext"));
		int c=a+b;
		PrintWriter printwriter=response.getWriter();
		printwriter.println("The sum value is "+c);
	        
		
		
	}

}
