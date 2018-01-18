

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SecondServ
 */
@WebServlet("/S2.do")
public class SecondServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SecondServ() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out=	response.getWriter();
		//out.println("Welcome "+request.getParameter("name"));
		ServletConfig sc=getServletConfig();
		out.println("<html>");
		out.println("<body>");
		out.println("<select name='s1'>");
		  Enumeration<String> e = sc.getInitParameterNames();
		    while(e.hasMoreElements())
		    {
		      String name=e.nextElement();  // returns the <param-name>*/ 
		      out.println("<option>"+sc.getInitParameter(name)+"</option>");  // returns <param-value> 
		       
		    }
		out.println("</select>");
		out.println("</body>");
		out.println("</html>");
	
		
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
