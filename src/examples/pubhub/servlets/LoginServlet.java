package examples.pubhub.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
//@WebServlet(urlPatterns={"/UserLogin"})

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LoginServlet() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		response.setContentType("text/html");
		pw.println("<center>Page successfully displayed</center>");
		pw.println("<center><b>The user is " + request.getRemoteUser()
				+ "</b></center>");
		pw.println("<center><b>The Authentication Type is "
				+ request.getAuthType() + "</b></center>");
	}

	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

    /*String userName = request.getRemoteUser();   
     String password = request.getRemoteUser();
     
     UserDAOImpl userdaoImpl = new UserDAOImpl();
     
     boolean result = userdaoImpl.authenticateUser(userName, password);
     User user = userdaoImpl.getUserByUserName(userName);
     if(result == true){
         request.getSession().setAttribute("user", user);      
       //response.sendRedirect("index.jsp");
         request.getRequestDispatcher("/admin/index.jsp").forward(request, response);
     }
     else{
    	 
    	 //response.sendRedirect("error.jsp");
    	 request.getRequestDispatcher("/admin/notFoundError.jsp").forward(request, response);
     }
     
    
    
  }
 */
