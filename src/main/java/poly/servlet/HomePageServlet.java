package poly.servlet;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import poly.DAO.FavoriteDAO;
import poly.DAO.UserDAO;
import poly.DAO.VideoDAO;
import poly.common.PageInfo;
import poly.common.PageType;
import poly.model.Favorite_TB;
import poly.model.User_TB;
import poly.model.Video_TB;
import poly.serve.SessionUtils;


/**
 * Servlet implementation class HomePageServlet
 */
@WebServlet({ "/homepage", "/page-infomation/*","/page-find-video","/page-pagination/*"})

public class HomePageServlet extends HttpServlet {
	VideoDAO vdao = null;
	Video_TB video = null;
	Integer numberPage = 1;
	int numberOfRecord = 9;
	
	
	public void doSelectAllVideos(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			vdao = new VideoDAO();
			Video_TB video = new Video_TB();
			List<Video_TB> list = vdao.findAll();
			request.setAttribute("video", list);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void doShow4Video(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// SHOW TOP 3 VIDEO
		vdao = new VideoDAO();
		List<Video_TB> list = vdao.showTop4Video();
		request.setAttribute("item4video", list);
	}

	public void doShow6Video(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// SHOW TOP 3 VIDEO
		vdao = new VideoDAO();
		List<Video_TB> list = vdao.showTop6Video();
		request.setAttribute("itemvideo", list);
	}
	

	public void doVideoAll(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		vdao = new VideoDAO();
		List<Video_TB> list = vdao.findAll();
			
		int totalPage = list.size() / numberOfRecord;
		if(list.size() % numberOfRecord > 0) {
			totalPage++;
		}
		request.setAttribute("video", list);
		request.setAttribute("counttt", totalPage);
	}

	// Video infomation
	public void doPageInfomation(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Integer id = Integer.parseInt(request.getParameter("watch"));
		video = vdao.findByID(id);
		request.setAttribute("video", video);
	}

	//Search
	public void doFindVideoByKeyWord(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			String keyword = request.getParameter("input_search");
			vdao = new VideoDAO();
			List<Video_TB> video = vdao.findByKeyWord(keyword);
			for (Video_TB v : video) {
				System.out.println(v);
			}
			request.setAttribute("video", video);
	}
	
	
	//Pagination video
	public void doShowWithPage(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		vdao = new VideoDAO();
		List<Video_TB> list = vdao.findAll();
		
		int totalPage = list.size() / numberOfRecord;
		if(list.size() % numberOfRecord > 0) {
			totalPage++;
		}
		
	    int offset = (numberPage - 1) * numberOfRecord;
	    int limit = numberOfRecord;
	    List<Video_TB> videoList = vdao.showPage(offset, limit);
	    
	    request.setAttribute("video", videoList);
	    request.setAttribute("counttt", totalPage);
	}
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String uri = request.getRequestURI();
		String method = request.getMethod();
		if (uri.contains("homepage")) {
			this.doShowWithPage(request, response);
			PageInfo.prepareAndForwardSite(request, response, PageType.SITE_VIDEOS_PAGE);
		} 
		//VIDEO INFOMATION
		else if (uri.contains("page-infomation")) {
			this.doPageInfomation(request, response);
			this.doShow4Video(request, response);
			this.doShow6Video(request, response);

			// Lấy ra id video
			Integer idVideo = Integer.parseInt(request.getParameter("watch"));
			System.out.println("Idvideo" + idVideo);
			// Lấy ra được đối tượng User
			User_TB user = SessionUtils.getUserFromSession(request, "user");

			if (idVideo == null) {
				response.sendRedirect("/WebASMServlet/homepage");
				return;
			}
			if (!SessionUtils.isLogin(request)) {
				response.sendRedirect("/WebASMServlet/login");
				return;
			}

			// LIKE VIDEO
			if (method.equalsIgnoreCase("POST")) {
				try {
					FavoriteDAO fdao = new FavoriteDAO();
					VideoDAO vdao = new VideoDAO();
					UserDAO udao = new UserDAO();
					Favorite_TB favorite = new Favorite_TB();
					// Lấy ra được đối tượng Video
					Video_TB video = vdao.findByID(idVideo);

//					User_TB user = udao.findByID()
					favorite.setUserTb(user);
					favorite.setVideoTb(video);
					favorite.setLikeDate(new Date());

					fdao.insert(favorite);
					System.out.println("Oke");

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			PageInfo.prepareAndForwardSite(request, response, PageType.SITE_VIDEO_INFO_PAGE);
		}
		// FIND VIDEO
		else if (uri.contains("find-video")) {
			if(method.equalsIgnoreCase("POST")) {
				this.doFindVideoByKeyWord(request, response);
			}
			PageInfo.prepareAndForwardSite(request, response, PageType.SITE_VIDEOS_PAGE);
		}
		else if(uri.contains("page-pagination")) {
			numberPage = Integer.parseInt(request.getParameter("page-item"));
			if(numberPage==1) {
				response.sendRedirect("/WebASMServlet/homepage");
				return;
			}
			doShowWithPage(request, response);
			PageInfo.prepareAndForwardSite(request, response, PageType.SITE_VIDEOS_PAGE);
		}
	}
}
