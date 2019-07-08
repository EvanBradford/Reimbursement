package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ReOracle;

/**
 * Servlet implementation class AddUserServlet
 */
public class AddUserServlet extends HttpServlet {
	
	private static final long serialVersionUID = -6545567095900943875L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String type = request.getParameter("type");
		String firstName = request.getParameter("firstname");//"adam";
		String lastName = request.getParameter("lastname");//"adam";
		String email = request.getParameter("email");//"adam@gmail.com";
		String password = request.getParameter("password");//"pass123";
		String address = request.getParameter("address");
		String startdate = request.getParameter("startdate");
		String status = "ACTIVE";
		
		ReOracle userDAO = new ReOracle();
		try {
			userDAO.insertEmp(type, firstName, lastName, email, password, address, startdate, status);
			System.out.println("Account Created");
			response.sendRedirect("homeAdmin.html");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}