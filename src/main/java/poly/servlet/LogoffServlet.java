package poly.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import poly.serve.CookieUtils;
import poly.serve.SessionUtils;

/**
 * Servlet implementation class LogoffServlet
 */
@WebServlet("/logoff")
public class LogoffServlet extends HttpServlet {
	
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CookieUtils.add("username", null, 0, response);
		SessionUtils.invalitedate(request);
		RequestDispatcher rd = request.getRequestDispatcher("/homepage");
		rd.forward(request, response);
	}

}
