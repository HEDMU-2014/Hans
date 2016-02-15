package test.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GrretingServlet
 */
@WebServlet("/greeting")
public class GreetingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Enumeration<String> names = request.getHeaderNames();
		while(names.hasMoreElements()) {
			System.out.println(names.nextElement());
		}

		request.setAttribute("hans", "hans");
		
		response.setContentType("text/html");
		response.setBufferSize(8192);
		try (PrintWriter out = response.getWriter()) {
			out.println("<html lang=\"en\">"
			+ "<head><title>Servlet Hello</title></head>"
			+ "<body bgcolor=\"#ffffff\">" 
			+ "<img src=\"Duke.wave.shadow.gif\" alt=\"Duke waving his hand\">"
			+ "<form method=\"post\">"
			+ "<h2>Hello, my name is Duke. What's yours?</h2>"
			+ "<input title=\"My name is: \"type=\"text\" name=\"username\" size=\"25\"><p></p>"
			+ "<input type=\"submit\" value=\"Submit\">"
			+ "<input type=\"reset\" value=\"Reset\">"
			+ "</form>");
			String username = request.getParameter("username");
			if (username != null && username.length() > 0) {
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/response");
				if (dispatcher != null) {
					dispatcher.include(request, response);
				}
			}
			out.println("</body></html>");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)	throws ServletException, IOException {
//		response.setContentType("text/html");
//		response.setBufferSize(8192);
//		try (PrintWriter out = response.getWriter()) {
//			out.println("<html lang=\"en\">"
//			+ "<head><title>Servlet Hello</title></head>"
//			+ "<body bgcolor=\"#ffffff\">" 
//			+ "<img src=\"Duke.wave.shadow.gif\" alt=\"Duke waving his hand\">"
//			+ "<form method=\"post\">"
//			+ "<h2>Hello, my name is Duke. What's yours?</h2>"
//			+ "<input title=\"My name is: \"type=\"text\" name=\"username\" size=\"25\"><p></p>"
//			+ "<input type=\"submit\" value=\"Submit\">"
//			+ "<input type=\"reset\" value=\"Reset\">"
//			+ "</form>");
//			String username = request.getParameter("username");
//			if (username != null && username.length() > 0) {
//				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/response");
//				if (dispatcher != null) {
//					dispatcher.include(request, response);
//				}
//			}
//			out.println("</body></html>");
//		}
		String username = request.getParameter("username");
		if (username != null && username.length() > 0) {
			response.sendRedirect("/test/response?username=" + username);
		}
	}
	

}
