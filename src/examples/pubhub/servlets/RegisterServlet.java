package examples.pubhub.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import examples.pubhub.dao.UserDAOImpl;
import examples.pubhub.model.User;
@WebServlet(urlPatterns={"/Register"})
public class RegisterServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
	 response.setContentType("text/html;charset=UTF-8");
	 
	 PrintWriter out = response.getWriter();
	 String errMsg = ""; 
	 boolean valid = true;
	 String pattern = "((?=.*\\d{2})[a-zA-Z0-9]{8,})";
     
	 
	 String firstName = request.getParameter("firstName");
	 String lastName = request.getParameter("lastName");
	 String userName = request.getParameter("userName");
	 String email = request.getParameter("email");
	 String address = request.getParameter("address");
	 String password = request.getParameter("password");
	
	
	
	User user = new User(firstName,lastName,userName,email,address,password);

			
	 try {	
		 
				 
		 out.println("<html>");
		 out.println("<head>");		
		 out.println("<title>Registration Successful</title>");		
		 out.println("</head>");
		 out.println("<body>");
		 out.println("<center>");
		 
		 UserDAOImpl userdaoImpl = new UserDAOImpl();
		 if (userdaoImpl.isUserExists(user)){
			errMsg += "<h1>User Already exits!!</h1>"; 
		 }
		 
		 
		
		if(userName.length() < 8){
				errMsg += "<br>UserName must have at least 8 characters.";
				valid = false;
			}   
		 if(password.length() < 8){
				errMsg += "<br>Password must have at least 8 characters.";
				valid = false;
		  	}
		 
		   if(password.matches(pattern)){
				errMsg += "<br>Password have at least 2 numbers.";
				valid = false;
			    
		     }
			if(valid == false){
				
				request.setAttribute("errMsg",errMsg);
				String url = "/register.jsp";
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
				dispatcher.include(request, response);
				}
		   else {
			 boolean result = userdaoImpl.register(user);
			 if(result){
				 out.println("<h1>Thanks for Registering with us :</h1>");
				 out.println("To login with new User and Password<a href=login.jsp>Click here</a>");
			 }else{
				 out.println("<h1>Registration Failed</h1>");
				 out.println("To try again<a href=register.jsp>Click here</a>");
			 }
			 out.println("</center>");
			 out.println("</body>");
			 out.println("</html>");
		 } 
		}
		 
	 finally {		
		 out.close();
	 }
   }
 }


