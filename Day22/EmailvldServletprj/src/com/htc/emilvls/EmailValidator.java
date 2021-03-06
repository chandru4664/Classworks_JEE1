package com.htc.emilvls;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

 

/**
 * Servlet implementation class EmailValidator
 */
@WebServlet("/EmailValidator")
public class EmailValidator extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmailValidator() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	//	doGet(request, response);
		request.getParameter("emailtext");		
		IEmailServiceProvider emailServiceProviderImpl= new EmailServiceProviderImpl();
		System.out.println(request.getParameter("emailtext"));
		PrintWriter emailPrintWriter=response.getWriter();
		try
		{
			System.out.println(emailServiceProviderImpl.validateEmail(request.getParameter("emailtext")));
		   if(emailServiceProviderImpl.validateEmail(request.getParameter("emailtext")))
	         {
			   System.out.println("TRUE EMAIL");
			   emailPrintWriter.println("This is a Valid Email ID............");
	         }
		   else
			   emailPrintWriter.println(" This is an Invalid Email ID");	       
		   
		}
		catch(InvalidEmailIdException iex)
		{
			this.getServletContext().log(iex.getErrorMessage());
		}
		catch(Exception exception)
		{
			this.log(exception.getMessage());
		}
		
	}

}
