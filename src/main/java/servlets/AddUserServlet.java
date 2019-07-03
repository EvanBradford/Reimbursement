package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import application.employees;
import dao.ReOracle;

/**
 * Servlet implementation class AddUserServlet
 */
public class AddUserServlet extends HttpServlet {
	
	private static final long serialVersionUID = -6545567095900943875L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String type = "EMPLOYEE";
		String firstName = request.getParameter("firstname");//"adam";
		String lastName = request.getParameter("lastname");//"adam";
		String email = request.getParameter("email");//"adam@gmail.com";
		String password = request.getParameter("password");//"pass123";
		String address = request.getParameter("address");
		String startdate = request.getParameter("startdate");
		String status = "ACTIVE";
		System.out.println("Name: "+ firstName + " " + lastName + ", email: " + email + ", password: " + password);
		employees user = new employees();
		user.setFirstname(firstName);
		user.setLastname(lastName);
		user.setEmail(email);
		user.setPassword(password);
		
		ReOracle userDAO = new ReOracle();
		try {
			userDAO.insertEmp(type, firstName, lastName, email, password, address, startdate, status);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
}