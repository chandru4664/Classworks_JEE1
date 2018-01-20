package com.htc.servlets.day1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SecondServlet
 */
@WebServlet("/SecondServlet")
public class SecondServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PrintWriter pw = response.getWriter();
		response.setContentType("text/html");
		
		String empname= request.getParameter("empname");
		double salary = Double.parseDouble(request.getParameter("salary"));
		
		double taxRate = (Double) request.getAttribute("taxRate");
		double taxAmount = (Double) request.getAttribute("taxAmount");

		pw.println("<br/>Emp name:" + empname);
		pw.println("<br/>Salary: " + salary);
		pw.println("<br/>TaxRate:" + taxRate);
		pw.println("<br/>Tax AMount:" + taxAmount);
		pw.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
