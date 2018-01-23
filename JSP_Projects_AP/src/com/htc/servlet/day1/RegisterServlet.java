package com.htc.servlet.day1;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.htc.servlet.service.UserService;

@WebServlet("/registerUser")
public class RegisterServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter pw = response.getWriter();
		response.setContentType("text/html");
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		String mobileno = request.getParameter("mobileno");
		String gender = request.getParameter("gender");
		String[] hobbies = request.getParameterValues("hobby");

		String hobbyList = Arrays.toString(hobbies);

		
		UserService service = new UserService();
		boolean status = service.registerUser(username, password, email, mobileno);
		
		if(status) {
			pw.println("<h1>Hello : " + username + "</h1>");
			pw.println("<h2> Registraion Successful</h2>");
		}
		else {
			pw.println("<h2> Registration failed</h2>");
			pw.println("<a href='register.html'> Back </a>");
		}
		pw.close();
	}
}
