

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/S1.do")
public class FirstServ extends HttpServlet {
	
    public FirstServ() {
        super();
        // TODO Auto-generated constructor stub
    }
PrintWriter out=null;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.sendRedirect("S2.do");
		out=response.getWriter();
		out.println("Hrellioif");
		//request.getRequestDispatcher("S2.do").include(request,response);
		response.sendRedirect("S2.do");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
