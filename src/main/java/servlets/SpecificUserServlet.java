package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import application.users;
import dao.ReOracle;

/**
 * Servlet implementation class SpecificUserServlet
 */
public class SpecificUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ReOracle userDAO = new ReOracle();
		setAccessControlHeaders(response);
		PrintWriter out = response.getWriter();
		ArrayList<users> list = new ArrayList<users>();
		users user = null;
		int id = Integer.parseInt(request.getParameter("id"));
		try {
			user = userDAO.getInfo(id);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		Gson gson = new Gson();
		String json = gson.toJson(user);
		out.write(json.toString());
		out.flush();
	}
	private void setAccessControlHeaders(HttpServletResponse resp) {
        //resp.setHeader("Access-Control-Allow-Origin", "http://localhost:8080");
        resp.setHeader("Access-Control-Allow-Origin", "*");
        resp.setHeader("Access-Control-Allow-Methods", "GET");
    }
}