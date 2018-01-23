package com.htc.servlet.day1;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.htc.servlet.dto.UserDTO;
import com.htc.servlet.service.UserService;

/**
 * Servlet implementation class ViewAllUsersServlet
 */
@WebServlet("/viewAllUsers")
public class ViewAllUsersServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
			UserService service = new UserService();
			List<UserDTO> userList = service.getAllUsers();
			//System.out.println(userList.size());
			HttpSession session = request.getSession(true);
			session.setAttribute("userList", userList);
			
			response.sendRedirect("allusers.jsp");
			
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
