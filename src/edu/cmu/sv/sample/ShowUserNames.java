package edu.cmu.sv.sample;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ShowUserNames
 */
public class ShowUserNames extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowUserNames() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<html><head><meta charset='UTF-8'>");
		out.println("<link href='//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css' rel='stylesheet'>");
		out.println("<title>Saved user names page</title></head>");
		out.println("<body><br/><br/><div style='text-align: center' class='lead'>");
		out.println("<table class='lead' align='center'>");
		out.println("<tr><td><b>User Names</b></td></tr>");
		List<String> users = DBHelper.loadAllUserNames();
		for(String user: users) {
			out.println("<tr><td>" + user + "</td></tr>");
		}
		out.println("</table><br/><a href='index.html'>Go Back</a>");
		out.println("</div></body></html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
