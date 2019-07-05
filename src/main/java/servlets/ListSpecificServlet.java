package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import application.reimbursements;
import dao.ReOracle;

/**
 * Servlet implementation class ListUserServlet
 */
public class ListSpecificServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ReOracle userDAO = new ReOracle();
		int id = Integer.parseInt(request.getParameter("id"));
		try {
			List<reimbursements> list = userDAO.getRe(id);
			for (reimbursements re : list) {
				System.out.println(re);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
}