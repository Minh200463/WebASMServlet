package poly.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import poly.DAO.UserDAO;
import poly.common.PageInfo;
import poly.common.PageType;
import poly.model.User_TB;
import poly.serve.SessionUtils;

/**
 * Servlet implementation class ChangePasswordServlet
 */
@WebServlet("/page-change-password")
public class ChangePasswordServlet extends HttpServlet {

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserDAO udao = new UserDAO();
		User_TB user = null;
		String method = request.getMethod();
		if(method.equalsIgnoreCase("POST")) {
			user = SessionUtils.getUserFromSession(request, "user");
			
			String password_new = request.getParameter("password_new");
			String repassword = request.getParameter("repassword");
			String password_now = request.getParameter("password_now");
	
			user = udao.findOne(user.getUsername(), password_now);
			
			
			if(user != null) {
				try {
					BeanUtils.populate(user, request.getParameterMap());
					if(repassword.equals(password_new)) {
						user.setId(user.getId());
						user.setPassword(repassword);
							udao.update(user);
							request.setAttribute("message", "Cật nhập thành công!");
							
					}else {
						request.setAttribute("error", "Mật khẩu không trùng khớp");						
					}	
					
				} catch (Exception e) {
					e.printStackTrace();
					request.setAttribute("error", "Cật nhập thất bại!");
				}
			}else {
				request.setAttribute("error", "Mật khẩu không chính xác");				
			}
		}
		PageInfo.prepareAndForwardSite(request, response, PageType.SITE_CHANGE_PASS_PAGE);
	}

}
