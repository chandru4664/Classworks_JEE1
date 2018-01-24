package com.htc.ajax.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.htc.ajax.dao.RestaurantDAOImpl;
import com.htc.ajax.dto.RestaurantDTO;


@WebServlet("/saveRest")
public class RestaurantServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	public RestaurantServlet() {
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("DoPost invoked...");
		int restId=Integer.parseInt(request.getParameter("restId"));
		System.out.println("RestID: " +restId);
		RestaurantDAOImpl restImpl=new RestaurantDAOImpl();
		RestaurantDTO restaurant=restImpl.getData(restId);
		response.setContentType("text/plain");
		if(restaurant!=null){
			response.getWriter().println("exist");
		}else
			response.getWriter().println("notExist");
		
		response.getWriter().close();
	}

}
