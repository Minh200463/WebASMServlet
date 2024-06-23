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
import poly.domain.LoginForm;
import poly.model.User_TB;
import poly.serve.CookieUtils;
import poly.serve.SessionUtils;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")	
public class LoginServlet extends HttpServlet {

	
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		 response.sendRedirect("/WebASMServlet/homepage");
		String username = CookieUtils.get("username", request);
		if(username == null) {
			PageInfo.prepareAndForwardSign(request, response, PageType.SITE_LOGIN_PAGE);
			return;
		}
		SessionUtils.add(request, "username", username);
		request.getRequestDispatcher("/homepage").forward(request, response);;
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			LoginForm form = new LoginForm();
			BeanUtils.populate(form, request.getParameterMap());
			
			UserDAO udao = new UserDAO();
			//Lấy ra được user dựa vào username và password
			User_TB user = 	udao.findOne(form.getUsername(), form.getPassword());
			if(user!=null) {
				SessionUtils.add(request, "username", user.getUsername());
				if(form.isRemember()) {
					CookieUtils.add("username", form.getUsername(), 24, response);
				}else {
					CookieUtils.add("username", form.getUsername(), 0, response);
				}
				request.getSession().setAttribute("user", user);
//				request.getSession().setAttribute("name", user.getUsername());
//				request.getRequestDispatcher("/homepage").forward(request, response);
				response.sendRedirect("/WebASMServlet/homepage");
				return;
			}
			request.setAttribute("error", "Sai thông tin tài khoản hoặc mật khẩu!");
			PageInfo.prepareAndForwardSign(request, response, PageType.SITE_LOGIN_PAGE);
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
	}



}
