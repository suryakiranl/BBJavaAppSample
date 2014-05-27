package edu.cmu.sv.sample;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SampleServlet
 */
public class SampleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SampleServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<html><head><meta charset='UTF-8'>");
		out.println("<link href='//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css' rel='stylesheet'>");
		out.println("<title>Hi there page :)</title></head>");
		out.println("<body><br/><br/><br/><div style='text-align: center' class='lead'>");
		
		String responseStr = "";

		String userName = request.getParameter("userName");
		if (userName == null || userName.trim().equals("")) {
			responseStr = "ERROR: User name provided was empty. "
					+ "Please provide a valid name!!";
		} else {
			responseStr = "Hello " + userName + " !!";
			User user = new User();
			user.setUserName(userName);
			DBHelper.saveUser(user);
		}
		
		responseStr += "<br/><a href='index.html'>Go Back</a>";
		out.println(responseStr);
		out.println("</div></body></html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
