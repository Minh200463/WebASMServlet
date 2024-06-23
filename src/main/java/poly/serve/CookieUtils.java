package poly.serve;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CookieUtils {
	public static String get(String name, HttpServletRequest request) {
		Cookie[] cookies = request.getCookies();
		if(cookies != null) {
			for(Cookie cookie : cookies) {
				if(cookie.getName().equals(name)) {
					return cookie.getValue();
				}
			}
		}
		return null;
	}
	
	public static Cookie add(String name , String value, int hours, HttpServletResponse respose) {
		Cookie cookie = new Cookie(name, value);
		cookie.setMaxAge(60 * 60 * hours);
		cookie.setPath("/");
		respose.addCookie(cookie);
		return cookie;
	}
}
