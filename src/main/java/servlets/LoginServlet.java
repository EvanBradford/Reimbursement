package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import application.employees;
import application.users;
import dao.ReOracle;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String email = request.getParameter("email");//"john@gmail.com";
			String password  = request.getParameter("password");//"pass123";
			String admin = request.getParameter("admin");
			System.out.println("Email:" + email +",password:" + password);
			ReOracle userDAO = new ReOracle();
			users user;
			admin = admin.toUpperCase();
			if(admin.equals("ADMIN"))
			{
				user = userDAO.loginA(email, password);
				response.sendRedirect("homeAdmin.html");
			}
			else if(admin.equals("EMPLOYEE"))
			{
				user = userDAO.loginE(email, password);
				employees emp = userDAO.loginE(email, password);
				System.out.println(userDAO.getInfo(emp.getEmployeeId()));
				response.sendRedirect("homeEmp.html");	
			}
			else {
				System.out.println("Invalid Account Type");
				return;
			}
			if(user == null) {
				System.out.println("Invalid Email/Password");
			}
			else {
				System.out.println("Valid Email/Password");
			}
			System.out.println(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(response.getWriter().append("Served at: ").append(request.getContextPath()));
	}
}