package com.htc.servlet.day1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.htc.servlet.dto.UserDTO;
import com.htc.servlet.service.UserService;

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
		
		request.setAttribute("user", user);
		
		RequestDispatcher rd = request.getRequestDispatcher("user.jsp");
		rd.forward(request, response);
		
		
	}

}
