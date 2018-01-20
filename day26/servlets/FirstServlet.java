package com.htc.servlets.day1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FirstServlet
 */
@WebServlet("/FirstServlet")
public class FirstServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String data = request.getParameter("empname");
		double salary = Double.parseDouble(request.getParameter("salary"));
		double taxRate = 0.0;
		if(salary< 50000) {
			taxRate = 5;
		}
		else if(salary <100000) {
			taxRate = 6;
		}
		else {
			taxRate = 10;
		}
		double taxAmount = salary * taxRate /100;
		
		
		request.setAttribute("taxRate", taxRate);
		request.setAttribute("taxAmount", taxAmount);
		
		//RequestDispatcher  rd = request.getRequestDispatcher("SecondServlet");
		//rd.forward(request, response);
		response.sendRedirect("SecondServlet");
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
