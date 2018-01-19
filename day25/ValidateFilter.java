package com.htc.filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet Filter implementation class ValidateFilter
 */

@WebFilter(	urlPatterns = { "/AddServlet" }, filterName="/ValidateFilter")
public class ValidateFilter implements Filter {
	
    /**
     * Default constructor. 
     */
    public ValidateFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here

		// pass the request along the filter chain
	
		System.out.println("Inside filter method , before reaching the servlet  ");
		System.out.println("Do validations, compression , encrytion .....");
		int a=Integer.parseInt(request.getParameter("numonetext"));
		int b=Integer.parseInt(request.getParameter("numtwotext"));
		System.out.println(request.getParameter("numonetext"));
		System.out.println(request.getParameter("numtwotext"));
		if(a>0 && b>0) {			
		   chain.doFilter(request, response);
		   System.out.println(" Inside Filter , after communicating with the servlet  ");
		   System.out.println("decompression , decrytion , localization , internationaliztion ......");
		}	   
		    
		else
			request.getRequestDispatcher("/Error.html").forward(request, response);
			
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
