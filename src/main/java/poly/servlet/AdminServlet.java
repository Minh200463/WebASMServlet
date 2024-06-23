package poly.servlet;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.commons.beanutils.BeanUtils;

import poly.DAO.UserDAO;
import poly.DAO.VideoDAO;
import poly.common.PageInfo;
import poly.common.PageType;
import poly.model.User_TB;
import poly.model.Video_TB;
import poly.serve.JPAUtils;
import poly.serve.SessionUtils;

/**
 * Servlet implementation class TestWWEB
 */
@WebServlet({ 
	"/admin-home", 
	"/admin-videos",
	"/admin-video-reset", 
	"/admin-video-create",
	"/admin-video-edit/*",
	"/admin-video-update/*",
	"/admin-video-delete/*", 
	"/admin-video-delete-insite/*",
		"/admin-users", 
		"/admin-edit/*",
		"/admin-create",
		"/admin-update/*",
		"/admin-reset", 
		"/admin-delete/*",
		"/admin-find-video",
		"/admin-find-user",
	"/page-home"})
@MultipartConfig
public class AdminServlet extends HttpServlet {
	UserDAO udao = null;
	User_TB user = null;
	VideoDAO vdao = null;
	Video_TB video = null;

	public boolean doValidateUser(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Check if any field of user object is null
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String email = request.getParameter("email");

		if (username == null || username.equals("") || password == null || password.equals("") || email == null
				|| email.equals("")) {
			return false;
		}
		// You can add more validations here if needed
		return true;
	}

	public boolean doValidateVideo(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Check if any field of user object is null
		String title = request.getParameter("tittle");
		String href = request.getParameter("href");
		String poster = request.getParameter("poster");
		String description = request.getParameter("description");
		String viewcount = request.getParameter("viewcount");
		
		if (title == null || title.equals("") || href == null || href.equals("") || description == null
				|| description.equals("") || viewcount == null || viewcount.equals("")) {
			return false;
		}
		// You can add more validations here if needed
		return true;
	}

	// *****************ADMIN-VIDEO*************************
	public void doResetVideo(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		video = new Video_TB();
		request.setAttribute("vd", video);
	}

	public void doCreateVideo(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		vdao = new VideoDAO();
		video = new Video_TB();
		try {
			Integer view = Integer.parseInt(request.getParameter("viewcount"));
			String href = request.getParameter("href");
			// Xử lý ảnh
			File dir = new File(request.getServletContext().getRealPath("/img"));
			if (!dir.exists()) {
				dir.mkdir();
			}
			Part photo = request.getPart("poster"); // File ảnh
			File photoFile = new File(dir, photo.getSubmittedFileName());
			String namePoster = photoFile.getName();

			if (photo.getSubmittedFileName().equals("") || photo.getSubmittedFileName() == null) {
				video.setPoster("anhloi.jpg");
			} else {
				photo.write(photoFile.getAbsolutePath());
				video.setPoster(namePoster);
			}
			if (doValidateVideo(request, response)) {
				video.setViews(view);
				BeanUtils.populate(video, request.getParameterMap());
				vdao.insert(video);
				request.setAttribute("message", "Thêm mới thành công!");
			} else {
				request.setAttribute("error", "Vui lòng nhập đầy đủ thông tin");
			}
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", "Thêm mới thất bại!");
			// TODO: handle exception
		}
	}

	public void doSelectAllVideos(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		vdao = new VideoDAO();
		Video_TB video = new Video_TB();
		List<Video_TB> list = vdao.findAll();
		request.setAttribute("video", list);
	}

	public void doDeleteVideo(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		vdao = new VideoDAO();
		video = new Video_TB();
		try {
			Integer id = Integer.parseInt(request.getParameter("id"));
			vdao.delete(id);
			request.setAttribute("message", "Xóa thành công!");
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", "Xóa thất bại!");
		}

	}

	public void doUpdateVideo(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		vdao = new VideoDAO();
		video = new Video_TB();
		try {
			Integer id = Integer.parseInt(request.getParameter("id"));
			Integer view = Integer.parseInt(request.getParameter("viewcount"));
			// Xử lý ảnh
			File dir = new File(request.getServletContext().getRealPath("/img"));
			if (!dir.exists()) {
				dir.mkdir();
			}
			Part photo = request.getPart("poster"); // File ảnh
			File photoFile = new File(dir, photo.getSubmittedFileName());
			String namePoster = photoFile.getName();

			if (photo.getSubmittedFileName().equals("") || photo.getSubmittedFileName() == null) {
				video.setPoster("anhloi.jpg");
			} else {
				photo.write(photoFile.getAbsolutePath());
				video.setPoster(namePoster);
			}
			if (doValidateVideo(request, response)) {
				// Set model
				video.setId(id);
				video.setViews(view);
				BeanUtils.populate(video, request.getParameterMap());
				vdao.update(video);
				request.setAttribute("message", "Cật nhập thành công!");

			} else {
				request.setAttribute("error", "Vui lòng nhập đầy đủ thông tin");
			}
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", "Cật nhập thất bại!");
			return;
		}
	}
	
	
	public void doFindVideoByKeyWord(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			String keyword = request.getParameter("input_search");
			vdao = new VideoDAO();
			List<Video_TB> video = vdao.findByKeyWord(keyword);
			request.setAttribute("video", video);
	}

	// ***************ADMIN-USER**************************** **
	
	public void doFindUserByKeyWord(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			String keyword = request.getParameter("input_search");
			udao = new UserDAO();
			List<User_TB> user = udao.findByKeyWord(keyword);
			request.setAttribute("user", user);
	} 
	
	public void doResetUser(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		user = new User_TB();
		request.setAttribute("us", user);
	}

	public void doSelectAllUser(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		UserDAO udao = new UserDAO();
		List<User_TB> list = udao.findAll();
		request.setAttribute("user", list);
	}

	public void doCreateUser(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		udao = new UserDAO();
		user = new User_TB();
		String username = request.getParameter("username");
		try {
			BeanUtils.populate(user, request.getParameterMap());
			if (doValidateUser(request, response)) {
				List<User_TB> list = udao.findAll();
				for (User_TB us : list) {
					if(us.getUsername().equals(username)) {
						request.setAttribute("error", "Trùng lặp username!");
						return;
					}
				}
				udao.insert(user);
				request.setAttribute("message", "Thêm mới thành công!");
				request.setAttribute("us", user);
			} else {
				request.setAttribute("error", "Vui lòng nhập đầy đủ thông tin");
				request.setAttribute("us", user);
			}
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", "Thêm mới thất bại!");
			request.setAttribute("us", user);
			// TODO: handle exception
		}
	}

	public void doUpdateUser(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		udao = new UserDAO();
		user = new User_TB();
		try {
			Integer id = Integer.parseInt(request.getParameter("id"));
			BeanUtils.populate(user, request.getParameterMap());
			user.setId(id);
			if (doValidateUser(request, response)) {
				udao.update(user);
				request.setAttribute("message", "Cật nhập thành công!");
				request.setAttribute("us", user);
			} else {
				request.setAttribute("error", "Vui lòng nhập đầy đủ thông tin!");
			}
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", "Cật nhập thất bại!");
			return;
		}
	}

	public void doDeleteUser(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		udao = new UserDAO();
		user = new User_TB();
		try {
			Integer id = Integer.parseInt(request.getParameter("id"));
			udao.delete(id);
			request.setAttribute("message", "Xóa thành công!");
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", "Xóa thất bại!");
		}
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		
		String method = request.getMethod();
		String uri = request.getRequestURI();
		if (uri.contains("admin-home")) {
			this.doSelectAllVideos(request, response);
			PageInfo.prepareAndForward(request, response, PageType.LISTALL_MANAGEMENT_PAGE);
		} else if (uri.contains("admin-videos")) {
			PageInfo.prepareAndForward	(request, response, PageType.VIDEOS_MANAGEMENT_PAGE);
		} else if (uri.contains("admin-users")) {
			this.doSelectAllUser(request, response);
			PageInfo.prepareAndForward(request, response, PageType.USER_MANAGEMENT_PAGE);
		} else if (uri.contains("admin-edit")) {
			try {
				Integer id = Integer.parseInt(request.getParameter("id"));
				udao = new UserDAO();
				user = udao.findByID(id);
				request.setAttribute("us", user);
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("Loi");
			}
			this.doSelectAllUser(request, response);
			PageInfo.prepareAndForward(request, response, PageType.USER_MANAGEMENT_PAGE);
		} else if (uri.contains("admin-create")) {
			if (method.equalsIgnoreCase("POST")) {
				this.doCreateUser(request, response);
			}
			this.doSelectAllUser(request, response);
			PageInfo.prepareAndForward(request, response, PageType.USER_MANAGEMENT_PAGE);
		}else if(uri.contains("admin-find-user")) {
			if(method.equalsIgnoreCase("POST")) {
				this.doFindUserByKeyWord(request, response);
			}
			PageInfo.prepareAndForward(request, response, PageType.USER_MANAGEMENT_PAGE);
		}
		
		else if (uri.contains("admin-update")) {
			if (method.equalsIgnoreCase("POST")) {
				this.doUpdateUser(request, response);
			}
			this.doSelectAllUser(request, response);
			PageInfo.prepareAndForward(request, response, PageType.USER_MANAGEMENT_PAGE);
		} else if (uri.contains("admin-reset")) {
			this.doResetUser(request, response);
			this.doSelectAllUser(request, response);
			PageInfo.prepareAndForward(request, response, PageType.USER_MANAGEMENT_PAGE);
		} else if (uri.contains("admin-delete")) {
			if (method.equalsIgnoreCase("POST")) {
				this.doDeleteUser(request, response);
			}
			this.doSelectAllUser(request, response);
			PageInfo.prepareAndForward(request, response, PageType.USER_MANAGEMENT_PAGE);
		}
		
		
//		********************VIDEO**********************
		else if (uri.contains("admin-video-reset")) {
			if (method.equalsIgnoreCase("POST")) {
				this.doResetVideo(request, response);
			}
			PageInfo.prepareAndForward(request, response, PageType.VIDEOS_MANAGEMENT_PAGE);
		} else if (uri.contains("admin-video-create")) {
			if (method.equalsIgnoreCase("POST")) {
				this.doCreateVideo(request, response);
			}
			PageInfo.prepareAndForward(request, response, PageType.VIDEOS_MANAGEMENT_PAGE);
		} else if (uri.contains("admin-video-update")) {
			if (method.equalsIgnoreCase("POST")) {
				this.doUpdateVideo(request, response);
			}
			this.doSelectAllVideos(request, response);
			PageInfo.prepareAndForward(request, response, PageType.VIDEOS_MANAGEMENT_PAGE);
		}

		else if (uri.contains("admin-video-edit")) {
			try {
				Integer id = Integer.parseInt(request.getParameter("id"));
				vdao = new VideoDAO();
				video = vdao.findByID(id);
				request.setAttribute("vd", video);
			} catch (Exception e) {
				e.printStackTrace();	
				System.out.println("Loi");
			}
			PageInfo.prepareAndForward(request, response, PageType.VIDEOS_MANAGEMENT_PAGE);
		} else if (uri.contains("admin-video-delete")) {
			if (method.equalsIgnoreCase("POST")) {
				this.doDeleteVideo(request, response);
			}
			this.doSelectAllVideos(request, response);
			PageInfo.prepareAndForward(request, response, PageType.VIDEOS_MANAGEMENT_PAGE);
		} else if(uri.contains("admin-find-video")) {
			if(method.equalsIgnoreCase("POST")) {
				this.doFindVideoByKeyWord(request, response);
			}
			PageInfo.prepareAndForward(request, response, PageType.LISTALL_MANAGEMENT_PAGE);
		}

	}

}
