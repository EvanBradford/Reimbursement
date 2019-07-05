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
public class ListResolvedServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ReOracle userDAO = new ReOracle();
		try {
			List<reimbursements> list = userDAO.getAllRe();
			for (reimbursements re : list) {
				System.out.println(re);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
}