package com.htc.servlet.day1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sun.istack.internal.logging.Logger;

@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		PrintWriter pw = response.getWriter();
		response.setContentType("text/html");
		
			HttpSession session = request.getSession(false);
			if(session == null) {
				pw.println("<h2>Not part of a valid session</h2>");
				pw.println("<a href='login'>Login Here</a>");
			}
			else{
				session.removeAttribute("username");
				session.invalidate();
				pw.println("<h2> Successfully logout !!</h2>");
				pw.println("<a href='login.html'>Login Here</a>");
			}
		pw.close();
	}
}
