package com.htc.servlet.day1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		PrintWriter pw = response.getWriter();
		response.setContentType("text/html");
		
		String username = request.getParameter("uname");
		String pwd = request.getParameter("pwd");
		
		//call a dao method here
		if(username.equals("Anish") && pwd.equals("htc")) {
			pw.println("<h2> Login Successful</h2>");
		
		
			HttpSession session = request.getSession(true);
			System.out.println(session.getId());
			session.setMaxInactiveInterval(300);
			
			session.setAttribute("username", username);
			
			String bookTicketURL = response.encodeURL("bookTicket");
			String cancelTicketURL = response.encodeURL("cancelTicket");
			String logoutURL = response.encodeURL("logout");
			
			System.out.println(bookTicketURL);
			
			pw.println("<h2> <a href='" + bookTicketURL +"'> Book Ticket </a> </h2>");
			pw.println("<h2> <a href='"+cancelTicketURL+"'> Cancel Ticket </a> </h2>");
			pw.println("<h2> <a href='"+logoutURL + "'> Logout </a> </h2>");

			ServletContext context = getServletContext();
			Integer usercount = (Integer) context.getAttribute("usercount");
			
			pw.println("<h1> Usercount:" + usercount + "</h1>");
	
		}
		else {
			pw.println("<h2>Login Failure</h2>");
			pw.println("<a href='login.html'> Login Again </a>");
		}
		pw.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	System.out.println("doPost() method");
		doGet(request, response);
	}

}
