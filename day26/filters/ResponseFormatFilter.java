package com.htc.servlets.filters;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

/**
 * Servlet Filter implementation class ResponseFormatFilter
 */
@WebFilter("/hello")
public class ResponseFormatFilter implements Filter {

   
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
	
		PrintWriter pw = response.getWriter();
		pw.println("<h2 style='background-color:cyan;color:red'> Welcome to my Site</h2>");
		boolean status = false;
		if(status) {
			chain.doFilter(request, response);
		}
		pw.println("</br></br></br></br></br></br></br></br>");
		pw.println("<center>Phase II, MPEZ, HTC Global Services. Chennai-45</center>");
		pw.close();
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

}
