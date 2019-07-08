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
public class AddReimbursementServlet extends HttpServlet {
	
	private static final long serialVersionUID = -6545567095900943875L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		double amount = Double.parseDouble(request.getParameter("amount"));
		String purpose = request.getParameter("purpose");//"adam";
		String date = request.getParameter("date");//"adam";
		String status = "SUBMITTED";
		int id = Integer.parseInt(request.getParameter("id"));//"adam@gmail.com";
		
		ReOracle userDAO = new ReOracle();
		try {
			userDAO.insertRe(amount, purpose, date, status, id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		//System.out.println(response.getWriter().append("Served at: ").append(request.getContextPath()));
		response.sendRedirect("homeEmp.html");
	}
}