package poly.serve;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import poly.model.User_TB;

public class SessionUtils {
	public static void add(HttpServletRequest request, String name, Object value) {
		HttpSession session = request.getSession();
		session.setAttribute(name, value);
	}
	
	public static Object get(HttpServletRequest request, String name) {
		HttpSession session = request.getSession();
		return session.getAttribute(name);
	}
	
	public static void invalitedate(HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.removeAttribute("username");
		session.invalidate();
	}
	
	public static boolean isLogin(HttpServletRequest request) {
		return get(request, "username") != null;
	}
	
	public static String getLogineUsername(HttpServletRequest request) {
		Object username = get(request, "username");
		return username == null ? null : username.toString();
	}

	
	public static User_TB getUserFromSession(HttpServletRequest request, String param) {
		HttpSession session = request.getSession();
		if(session != null) {
			return (User_TB) session.getAttribute(param);
		}
		return null;
	}
}
