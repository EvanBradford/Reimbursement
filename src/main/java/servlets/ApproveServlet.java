package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ReOracle;

/**
 * Servlet implementation class ApproveServlet
 */
public class ApproveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ReOracle userDAO = new ReOracle();
		int reId = Integer.parseInt(request.getParameter("id"));
		try {
			userDAO.approve(reId);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}