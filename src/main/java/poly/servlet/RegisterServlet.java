package poly.servlet;

import java.io.IOException;
import java.util.List;

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




/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	User_TB user = null;
	UserDAO udao = null;
	public boolean doValidate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String repassword = request.getParameter("repassword");
		
		if(username.equals("") || username == null ||
			password.equals("") || password == null ||
			repassword.equals("") || repassword == null) {
			return false;
		}
		return true;
	}
	
	public void doCreateUser(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		udao = new UserDAO();
		user = new User_TB();
		String password = request.getParameter("password");
		String repassword = request.getParameter("repassword");
		String username = request.getParameter("username");
		String email = request.getParameter("email");
		try {
			BeanUtils.populate(user, request.getParameterMap());
			if (doValidate(request, response)) {
				List<User_TB> list = udao.findAll();
				for (User_TB us : list) {
					if(us.getUsername().equals(username)) {	
						request.setAttribute("error", "Username đã có sẵn!");
						request.setAttribute("us", user);
						return;
					}
					if(us.getEmail().equals(email)) {
						request.setAttribute("error", "Email đã được đăng ký trước đó!");
						request.setAttribute("us", user);
						return;
					}
					if(!repassword.equals(password)) {
						request.setAttribute("error", "Mật khẩu không trùng khớp!");
						request.setAttribute("us", user);
						return;
					}
				
				}
				udao.insert(user);
				request.setAttribute("message", "Đăng ký thành công!");
				
			} else {
				request.setAttribute("error", "Vui lòng nhập đầy đủ thông tin");
			}
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", "Thêm mới thất bại!");
		}
		request.setAttribute("us", user);
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String method = request.getMethod();
		if(method.equalsIgnoreCase("POST")) {
			this.doCreateUser(request, response);	
		}
		PageInfo.prepareAndForwardSign(request, response, PageType.SITE_REGISTER_PAGE);
		
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("/WebASMServlet/login");
	}
}
