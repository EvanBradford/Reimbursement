package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import application.users;
import dao.ReOracle;

/**
 * Servlet implementation class ListUserServlet
 */
public class ListUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ReOracle userDAO = new ReOracle();
		setAccessControlHeaders(response);
		PrintWriter out = response.getWriter();
		List<users> list = null;
		try {
			list = userDAO.getAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		Gson gson = new Gson();
		String json = gson.toJson(list);
		out.write(json.toString());
		out.flush();
	}
	
	private void setAccessControlHeaders(HttpServletResponse resp) {
        //resp.setHeader("Access-Control-Allow-Origin", "http://localhost:8080");
        resp.setHeader("Access-Control-Allow-Origin", "*");
        resp.setHeader("Access-Control-Allow-Methods", "GET");
    }
}