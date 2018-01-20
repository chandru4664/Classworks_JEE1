package com.htc.servlets.day1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.htc.servlets.dto.UserDTO;
import com.htc.servlets.service.UserService;

@WebServlet("/searchUser")
public class SearchUserServlet extends HttpServlet {

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter pw = response.getWriter();
		response.setContentType("text/html");
		
		String username = request.getParameter("username");
		
		UserService userservice = new UserService();
		UserDTO user = userservice.searchUser(username); 
		
		ServletContext servletContext = getServletContext();
		String org = servletContext.getInitParameter("organization");
		String email= servletContext.getInitParameter("email");
		
		pw.println("<h2>User Details</h2>");
		pw.println("<table>");
		pw.println("<tr><td>Username</td> <td>" + user.getUsername() + "</td></tr>");
		pw.println("<tr><td>Password</td> <td> **********</td></tr>");
		pw.println("<tr><td>Email</td> <td>" + user.getEmail() + "</td></tr>");
		pw.println("<tr><td>Mobileno</td> <td>" + user.getMobileno() + "</td></tr>");
		pw.println("</table>");
		
		pw.println("Organzation:" + org);
		pw.println("Emai:" + email);
		
		pw.close();	
	}

}
